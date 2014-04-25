package com.dd.beaconscanner.components;

import org.apache.commons.lang.StringUtils;

import com.dd.beaconscanner.Beacon;
import com.dd.beaconscanner.HealthItem;
import com.dd.beaconscanner.Location;
import com.dd.beaconscanner.metadata.LocationData;
import com.dd.beaconscanner.metadata.volotile.VolatileAssetBeacon;
import com.dd.beaconscanner.metadata.volotile.VolatileBeaconData;
import com.dd.beaconscanner.metadata.volotile.VolatilePersonBeacon;
import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;

public class RadarOverview extends BaseComponent {
    private LocationData currentRadar;
	private Beacon currentBeacon;
	
	private String thirdLineForCurrentBeaconDisplay;

	public RadarOverview(WOContext context) {
        super(context);
    }

	public NSArray<LocationData> allRadar() {
		return LocationData.fetchAllLocationDatas(editingContext(), LocationData.NAME.ascInsensitives());
	}

	/**
	 * @return the currentRadar
	 */
	public LocationData currentRadar() {
		return currentRadar;
	}

	/**
	 * @param currentRadar the currentRadar to set
	 */
	public void setCurrentRadar(LocationData currentRadar) {
		this.currentRadar = currentRadar;
	}

	public String currentRadarPanelId() {
		// TODO
		return "id_"+currentRadar().primaryKey();
	}

	public NSArray<Beacon> allBeaconsOfCurrentRadar() {
		return beaconManager().beaconLocationMap().objectForKey(currentRadar().uuid());
	}
	
	public String firstLineForCurrentBeaconDisplay(){
		VolatileBeaconData beaconData = beaconDataForCurrentBeacon();
		if(VolatileBeaconData.BEACON_META_DATA_TYPE_PERSON.equals(beaconData.type())){
			VolatilePersonBeacon person = (VolatilePersonBeacon)beaconData;
			return person.title()+" "+person.firstName()+" "+person.lastName();
		}
		if(VolatileBeaconData.BEACON_META_DATA_TYPE_ASSET.equals(beaconData.type())){
			VolatileAssetBeacon asset = (VolatileAssetBeacon)beaconData;
			return asset.assetType();
		}
		return null;
	}
	
	public String secondLineForCurrentBeaconDisplay(){
		VolatileBeaconData beaconData = beaconDataForCurrentBeacon();
		if(VolatileBeaconData.BEACON_META_DATA_TYPE_PERSON.equals(beaconData.type())){
			VolatilePersonBeacon person = (VolatilePersonBeacon)beaconData;
			return person.position();
		}
		if(VolatileBeaconData.BEACON_META_DATA_TYPE_ASSET.equals(beaconData.type())){
			VolatileAssetBeacon asset = (VolatileAssetBeacon)beaconData;
			return asset.assetId();
		}
		return null;
	}

	public String iconURLForCurrentBeaconDisplay(){
		VolatileBeaconData beaconData = beaconDataForCurrentBeacon();
		if(VolatileBeaconData.BEACON_META_DATA_TYPE_PERSON.equals(beaconData.type())){
			VolatilePersonBeacon person = (VolatilePersonBeacon)beaconData;
			return person.iconURL();
		}
		if(VolatileBeaconData.BEACON_META_DATA_TYPE_ASSET.equals(beaconData.type())){
			VolatileAssetBeacon asset = (VolatileAssetBeacon)beaconData;
			return asset.iconURL();
		}
		return null;
	}

	
	public VolatileBeaconData beaconDataForCurrentBeacon(){
		return beaconManager().beaconMetaDataForBeacon(currentBeacon);	
	}
	
	/**
	 * @return the currentBeacon
	 */
	public Beacon currentBeacon() {
		return currentBeacon;
	}

	/**
	 * @param currentBeacon the currentBeacon to set
	 */
	public void setCurrentBeacon(Beacon currentBeacon) {
		this.currentBeacon = currentBeacon;
		applyThirdLineForCurrentBeaconDisplay();
	}

	public Integer beaconCountForCurrentRadar() {
		NSArray<Beacon> beacons = allBeaconsOfCurrentRadar();
			if(beacons==null){
				return null;
			}
		Integer count = beacons.count();
		if(count<1){
			return null;
		}
		return count;
	}

	public String collapseLinkForCurrentBeaconPanel() {
		return "#"+currentRadarPanelId();
	}

	public String radarStatusIconCSSClasses() {
		Location location = beaconManager().locationsByUUID().objectForKey(currentRadar.uuid());
		if(location==null||Integer.valueOf(HealthItem.HEALTH_STATUS_LOST).equals(location.health())){
			return "col-xs-1 beacon beacon-inactive";
		}
		return "col-xs-1 beacon beacon-active";
	}

	public String beaconStatusCSSClasses() {
		if(HealthItem.HEALTH_STATUS_MEDIUM.equals(currentBeacon.health())){
			return "thumbnail medium_health";
		}
		if(HealthItem.HEALTH_STATUS_BAD.equals(currentBeacon.health())){
			return "thumbnail bad_health";
		}
		return "thumbnail";
	}

	public String currentUpdateRadarPanelId() {
		return "update_panel_"+currentRadarPanelId();
	}
	
	public String currentUpdateRadarStatusId() {
		return "update_status_"+currentRadarPanelId();
	}

	public NSArray<String> pannelsToUpdate() {
		NSMutableArray<String> ids = new NSMutableArray<String>();
		for(LocationData location : allRadar()){
			setCurrentRadar(location);
			ids.addObject(currentUpdateRadarPanelId());
			ids.addObject(currentUpdateRadarStatusId());
			
		}
		return ids.immutableClone();
	}

	public String thirdLineForCurrentBeaconDisplay() {
		return thirdLineForCurrentBeaconDisplay;
	}
	
	private void applyThirdLineForCurrentBeaconDisplay() {
		thirdLineForCurrentBeaconDisplay = ((NSArray<String>)VolatileBeaconData.HEALTH.gt(HealthItem.HEALTH_STATUS_LOST).filtered(beaconDataForCurrentBeacon().channelBeacons()).valueForKey("message")).componentsJoinedByString("<br />");
	}
	
	public boolean hasThirdLineForCurrentBeaconDisplay() {
		return !StringUtils.isEmpty(thirdLineForCurrentBeaconDisplay);
	}
}
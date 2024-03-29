package com.dd.beaconscanner.components;

import org.apache.commons.lang.StringUtils;

import com.dd.beaconscanner.Beacon;
import com.dd.beaconscanner.HealthItem;
import com.dd.beaconscanner.Location;
import com.dd.beaconscanner.metadata.LocationData;
import com.dd.beaconscanner.metadata.volotile.VolatileBeaconData;
import com.dd.beaconscanner.metadata.volotile.VolatileChannelBeacon;
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
		return "id_"+currentRadar().primaryKey();
	}

	public NSArray<Beacon> allBeaconsOfCurrentRadar() {
		return beaconManager().beaconLocationMap().objectForKey(currentRadar().uuid());
	}
	
	public String firstLineForCurrentBeaconDisplay(){
		VolatileBeaconData beaconData = beaconDataForCurrentBeacon();
		if(beaconData!=null){
			return beaconData.primaryInformationString();
		}
		return null;
	}
	
	public String secondLineForCurrentBeaconDisplay(){
		VolatileBeaconData beaconData = beaconDataForCurrentBeacon();
		if(beaconData!=null){
			return beaconData.secondaryInformationString();
		}
		return null;
	}

	public String iconURLForCurrentBeaconDisplay(){
		VolatileBeaconData beaconData = beaconDataForCurrentBeacon();
		if(beaconData!=null){
			return beaconData.iconURL();
		}
		return null;
	}

	
	public VolatileBeaconData beaconDataForCurrentBeacon(){
		VolatileBeaconData beaconData = beaconManager().beaconMetaDataForBeacon(currentBeacon);
		if(beaconData instanceof VolatileChannelBeacon){
			beaconData = ((VolatileChannelBeacon)beaconData).beaconData();
			if(beaconData!=null&&beaconData.isAlive()){
				//channel owner is visible elsewhere so we don't display it here
				return null;
			}
		}


		return beaconData;
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
		
		thirdLineForCurrentBeaconDisplay = null;
		if (currentBeacon != null) {
			applyThirdLineForCurrentBeaconDisplay();
		}
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
		VolatileBeaconData beacon = beaconDataForCurrentBeacon();
		if(beacon!=null){
			thirdLineForCurrentBeaconDisplay = beacon.channelInformation().componentsJoinedByString("<br />");
		}
	}
	
	public boolean hasThirdLineForCurrentBeaconDisplay() {
		return StringUtils.isNotEmpty(thirdLineForCurrentBeaconDisplay);
	}
	

}
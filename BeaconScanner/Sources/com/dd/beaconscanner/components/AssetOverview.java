package com.dd.beaconscanner.components;

import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;
import com.dd.beaconscanner.Beacon;
import com.dd.beaconscanner.HealthItem;
import com.dd.beaconscanner.Location;
import com.dd.beaconscanner.metadata.AssetBeacon;
import com.dd.beaconscanner.metadata.volotile.VolatileLocationData;

public class AssetOverview extends BaseComponent {
    private AssetBeacon currentAsset;

	public AssetOverview(WOContext context) {
        super(context);
    }

	public NSArray<AssetBeacon> allAssets() {
		return AssetBeacon.fetchAllAssetBeacons(editingContext(),AssetBeacon.ASSET_TYPE.ascInsensitives());
	}

	/**
	 * @return the currentAsset
	 */
	public AssetBeacon currentAsset() {
		return currentAsset;
	}

	/**
	 * @param currentAsset the currentAsset to set
	 */
	public void setCurrentAsset(AssetBeacon currentAsset) {
		this.currentAsset = currentAsset;
	}

	public String currentAssetLocationDomID() {
		return "asset_location_"+currentAsset().primaryKey();
	}

	public NSArray<String> pannelsToUpdate() {
		NSMutableArray<String> ids = new NSMutableArray<String>();
		for(AssetBeacon beacon : allAssets()){
			setCurrentAsset(beacon);
			ids.addObject(currentAssetLocationDomID());
		}
		return ids.immutableClone();
	}

	public String locationForCurrentAsset() {
			Beacon beacon = beaconManager().beaconForBeaconDataItem(currentAsset());
			if(beacon==null||HealthItem.HEALTH_STATUS_LOST.equals(beacon.health())){
				return "offline";
			}
			Location location = beaconManager().locationsByUUID().objectForKey(beacon.location());
			if(location==null){
				return "error";
			}
			VolatileLocationData locationMetaData = beaconManager().locationMetaDataForLocation(location);
			if(locationMetaData==null){
				return "n/a";
			}
			return locationMetaData.name();
	}
}
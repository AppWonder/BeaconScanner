package com.dd.beaconscanner.metadata;

import org.apache.log4j.Logger;

import com.dd.beaconscanner.metadata.interfaces.AssetBeaconItem;
import com.dd.beaconscanner.metadata.volotile.VolatileAssetBeacon;
import com.dd.beaconscanner.metadata.volotile.VolatileBeaconData;

public class AssetBeacon extends _AssetBeacon implements AssetBeaconItem{
	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(AssetBeacon.class);
	
	public VolatileBeaconData volatileRepresentation(){
		return new VolatileAssetBeacon(uuid(), minorCode(), majorCode(), assetType());
	}
}

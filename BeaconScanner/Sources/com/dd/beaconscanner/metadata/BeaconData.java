package com.dd.beaconscanner.metadata;

import org.apache.log4j.Logger;

import com.dd.beaconscanner.BeaconItem;
import com.dd.beaconscanner.BeaconManager;
import com.dd.beaconscanner.metadata.interfaces.BeaconDataItem;
import com.dd.beaconscanner.metadata.volotile.VolatileBeaconData;

public abstract class BeaconData extends _BeaconData implements BeaconDataItem, BeaconItem{
	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(BeaconData.class);
	
	public abstract VolatileBeaconData volatileRepresentation();
	
	public String infoString(){
		return uuid()+"--"+majorCode()+"--"+minorCode();
	}
	
	public String uniqueKey(){
		return BeaconManager.uniqueKey(uuid(), majorCode(), minorCode());
	}
}

package com.dd.beaconscanner.metadata;

import org.apache.log4j.Logger;

import com.dd.beaconscanner.metadata.volotile.VolatileLocationData;

public class LocationData extends _LocationData {
	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(LocationData.class);
	
	public VolatileLocationData volatileRepresentation(){
		return new VolatileLocationData(iconURL(), uuid(), name(), deviceId());
	}
	
	
	public String infoString(){
		return uuid()+"--"+name()+"--"+deviceId();
	}
}

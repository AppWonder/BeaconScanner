package com.dd.beaconscanner.metadata;

import org.apache.log4j.Logger;

import com.dd.beaconscanner.metadata.interfaces.PersonBeaconItem;
import com.dd.beaconscanner.metadata.volotile.VolatileBeaconData;
import com.dd.beaconscanner.metadata.volotile.VolatilePersonBeacon;

public class PersonBeacon extends _PersonBeacon implements PersonBeaconItem{
	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(PersonBeacon.class);
	
	public VolatileBeaconData volatileRepresentation(){
		return new VolatilePersonBeacon(uuid(), minorCode(), majorCode(), firstName(), lastName(), title(), position(),iconURL());
	}
}

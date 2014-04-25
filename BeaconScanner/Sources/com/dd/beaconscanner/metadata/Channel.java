package com.dd.beaconscanner.metadata;

import org.apache.log4j.Logger;

import com.dd.beaconscanner.BeaconManager;
import com.dd.beaconscanner.metadata.interfaces.ChannelDataItem;
import com.dd.beaconscanner.metadata.volotile.VolatileBeaconData;
import com.dd.beaconscanner.metadata.volotile.VolatileChannelBeacon;

public class Channel extends _Channel implements ChannelDataItem{
	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(Channel.class);
	
	public VolatileBeaconData volatileRepresentation(){
		return new VolatileChannelBeacon(uuid(), minorCode(), majorCode(), message(), action(), beaconData()!=null?BeaconManager.getInstance().beaconMetaDataForBeacon(beaconData()):null);
	}
}

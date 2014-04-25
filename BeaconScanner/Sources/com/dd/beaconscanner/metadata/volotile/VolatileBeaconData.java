package com.dd.beaconscanner.metadata.volotile;

import com.dd.beaconscanner.Beacon;
import com.dd.beaconscanner.BeaconItem;
import com.dd.beaconscanner.BeaconManager;
import com.dd.beaconscanner.HealthItem;
import com.dd.beaconscanner.metadata.interfaces.BeaconDataItem;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;

import er.extensions.eof.ERXKey;

public abstract class VolatileBeaconData implements BeaconDataItem, HealthItem, BeaconItem{

	public static final String BEACON_META_DATA_TYPE_PERSON = "person";
	public static final String BEACON_META_DATA_TYPE_ASSET = "asset";
	public static final String BEACON_META_DATA_TYPE_CHANNEL = "channel";
	public static final ERXKey<String> UNIQUE_KEY = new ERXKey<String>("uniqueKey");
	
	/**
	 * @param uuid
	 * @param minorCode
	 * @param majorCode
	 */
	public VolatileBeaconData(String uuid, Integer minorCode, Integer majorCode) {
		super();
		this.uuid = uuid;
		this.minorCode = minorCode;
		this.majorCode = majorCode;
	}

	private String uuid;
	private Integer minorCode;
	private Integer majorCode;
	private NSArray<VolatileChannelBeacon> channelBeacons = NSArray.emptyArray();

	@Override
	public Integer majorCode() {
		return majorCode;
	}

	@Override
	public void setMajorCode(Integer value) {
		majorCode = value;

	}

	@Override
	public Integer minorCode() {
		return minorCode;
	}

	@Override
	public void setMinorCode(Integer value) {
		minorCode = value;

	}

	@Override
	public String uuid() {
		return uuid;
	}

	@Override
	public void setUuid(String value) {
		uuid = value;
	}
	
	public abstract String type();
	public abstract String primaryInformationString();
	public abstract String secondaryInformationString();
	public abstract String iconURL();
	
	public NSArray<VolatileChannelBeacon> channelBeacons(){
		return channelBeacons;
	}
	
	public void addToChannelBeacons(VolatileChannelBeacon message){
		NSMutableArray<VolatileChannelBeacon> data = channelBeacons.mutableClone();
		data.addObject(message);
		channelBeacons = data.immutableClone();
	}
	
	public int health(){
		Beacon beacon = BeaconManager.getInstance().beaconForBeaconDataItem(this);
		if(beacon==null){
			return HEALTH_STATUS_LOST;
		}
		return beacon.health();
	}
	
	public String uniqueKey(){
		return BeaconManager.uniqueKey(uuid(), majorCode(), minorCode());
	}
	

	public  NSArray<String> channelInformation(){
		return ((NSArray<String>)VolatileBeaconData.HEALTH.gt(HealthItem.HEALTH_STATUS_LOST).filtered(channelBeacons()).valueForKey("message"));
	}

}

package com.dd.beaconscanner.metadata.volotile;

import com.dd.beaconscanner.metadata.interfaces.BeaconDataItem;

public abstract class VolatileBeaconData implements BeaconDataItem {

	public static final String BEACON_META_DATA_TYPE_PERSON = "person";
	public static final String BEACON_META_DATA_TYPE_ASSET = "asset";
	public static final String BEACON_META_DATA_TYPE_CHANNEL = "channel";
	
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

}

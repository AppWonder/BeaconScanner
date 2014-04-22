package com.dd.beaconscanner.metadata.volotile;

import com.dd.beaconscanner.metadata.interfaces.LocationDataItem;

public class VolatileLocationData implements LocationDataItem {

	/**
	 * @param iconURL
	 * @param uuid
	 * @param name
	 * @param deviceId
	 */
	public VolatileLocationData(String iconURL, String uuid, String name,
			String deviceId) {
		super();
		this.iconURL = iconURL;
		this.uuid = uuid;
		this.name = name;
		this.deviceId = deviceId;
	}

	private String iconURL;
	private String uuid;
	private String name;
	private String deviceId;

	@Override
	public String deviceId() {
		return deviceId;
	}

	@Override
	public void setDeviceId(String value) {
		deviceId = value;
	}

	@Override
	public String iconURL() {
		return iconURL;
	}

	@Override
	public void setIconURL(String value) {
		this.iconURL = value;
	}

	@Override
	public String name() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String uuid() {
		return uuid;
	}

	@Override
	public void setUuid(String value) {
		this.uuid = value;
	}

}

package com.dd.beaconscanner.metadata.interfaces;

public interface LocationDataItem {

	public abstract String deviceId();

	public abstract void setDeviceId(String value);

	public abstract String iconURL();

	public abstract void setIconURL(String value);

	public abstract String name();

	public abstract void setName(String value);

	public abstract String uuid();

	public abstract void setUuid(String value);

}
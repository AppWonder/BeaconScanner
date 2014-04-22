package com.dd.beaconscanner.metadata.interfaces;

public interface BeaconDataItem {

	public abstract Integer majorCode();

	public abstract void setMajorCode(Integer value);

	public abstract Integer minorCode();

	public abstract void setMinorCode(Integer value);

	public abstract String uuid();

	public abstract void setUuid(String value);

}
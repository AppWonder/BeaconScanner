package com.dd.beaconscanner.metadata.interfaces;

import com.dd.beaconscanner.BeaconItem;

public interface BeaconDataItem extends BeaconItem{

	

	public abstract void setMajorCode(Integer value);
	public abstract void setMinorCode(Integer value);
	public abstract void setUuid(String value);

}
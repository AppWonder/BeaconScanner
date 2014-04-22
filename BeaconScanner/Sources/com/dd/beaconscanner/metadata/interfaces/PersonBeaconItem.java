package com.dd.beaconscanner.metadata.interfaces;

public interface PersonBeaconItem extends BeaconDataItem {
	public String firstName();
	public void setFirstName(String firstName);
	public String lastName();
	public void setLastName(String lastName);
	public String title();
	public void setTitle(String title);
}

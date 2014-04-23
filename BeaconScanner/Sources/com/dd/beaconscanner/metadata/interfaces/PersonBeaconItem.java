package com.dd.beaconscanner.metadata.interfaces;

public interface PersonBeaconItem extends BeaconDataItem {
	public String firstName();
	public void setFirstName(String firstName);
	public String lastName();
	public void setLastName(String lastName);
	public String title();
	public void setTitle(String title);
	public String position();
	public void setPosition(String position);
	public String iconURL();
	public void setIconURL(String iconURL);
}

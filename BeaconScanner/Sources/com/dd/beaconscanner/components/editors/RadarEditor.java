package com.dd.beaconscanner.components.editors;

import org.apache.commons.lang.StringUtils;

import com.dd.beaconscanner.Location;
import com.dd.beaconscanner.components.BaseComponent;
import com.dd.beaconscanner.metadata.LocationData;
import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSArray;

public class RadarEditor extends BaseComponent {
    private LocationData currentRadar;
	private LocationData selectedRadar;
	private String newRadarUUID;
	private String newRadarName;
	private String newRadarDeviceId;
	private String newRadarIconURL;
	private Location location;

	public RadarEditor(WOContext context) {
        super(context);
    }

	/**
	 * @return the currentRadar
	 */
	public LocationData currentRadar() {
		return currentRadar;
	}

	/**
	 * @param currentRadar the currentRadar to set
	 */
	public void setCurrentRadar(LocationData currentRadar) {
		this.currentRadar = currentRadar;
	}

	public NSArray<LocationData> allRadars() {
		return LocationData.fetchAllLocationDatas(editingContext(),LocationData.NAME.ascInsensitives());
	}

	/**
	 * @return the selectedRadar
	 */
	public LocationData selectedRadar() {
		return selectedRadar;
	}

	/**
	 * @param selectedRadar the selectedRadar to set
	 */
	public void setSelectedRadar(LocationData selectedRadar) {
		this.selectedRadar = selectedRadar;
	}

	public WOActionResults saveChanges() {
		editingContext().saveChanges();
		return null;
	}

	/**
	 * @return the newRadarUUID
	 */
	public String newRadarUUID() {
		return newRadarUUID;
	}

	/**
	 * @param newRadarUUID the newRadarUUID to set
	 */
	public void setNewRadarUUID(String newRadarUUID) {
		this.newRadarUUID = newRadarUUID;
	}

	/**
	 * @return the newRadarName
	 */
	public String newRadarName() {
		return newRadarName;
	}

	/**
	 * @param newRadarName the newRadarName to set
	 */
	public void setNewRadarName(String newRadarName) {
		this.newRadarName = newRadarName;
	}

	/**
	 * @return the newRadarDeviceId
	 */
	public String newRadarDeviceId() {
		return newRadarDeviceId;
	}

	/**
	 * @param newRadarDeviceId the newRadarDeviceId to set
	 */
	public void setNewRadarDeviceId(String newRadarDeviceId) {
		this.newRadarDeviceId = newRadarDeviceId;
	}

	/**
	 * @return the newRadarIconURL
	 */
	public String newRadarIconURL() {
		return newRadarIconURL;
	}

	/**
	 * @param newRadarIconURL the newRadarIconURL to set
	 */
	public void setNewRadarIconURL(String newRadarIconURL) {
		this.newRadarIconURL = newRadarIconURL;
	}

	public WOActionResults createNewRadar() {
		if(StringUtils.isNotBlank(newRadarUUID)){
			LocationData locationData = LocationData.createLocationData(editingContext(), newRadarUUID());
			locationData.setDeviceId(newRadarDeviceId());
			locationData.setIconURL(newRadarIconURL());
			locationData.setName(newRadarName());
			saveChanges();
			setSelectedRadar(locationData);
		}
		return null;
	}

	/**
	 * @return the location
	 */
	public Location location() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(Location location) {
		this.location = location;
	}
}
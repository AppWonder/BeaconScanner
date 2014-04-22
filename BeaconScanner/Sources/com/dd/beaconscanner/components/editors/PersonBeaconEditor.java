package com.dd.beaconscanner.components.editors;

import org.apache.commons.lang.StringUtils;

import com.webobjects.appserver.WOContext;
import com.dd.beaconscanner.components.BaseComponent;
import com.webobjects.foundation.NSArray;
import com.dd.beaconscanner.metadata.PersonBeacon;
import com.webobjects.appserver.WOActionResults;
import com.dd.beaconscanner.Beacon;

public class PersonBeaconEditor extends BaseComponent {
    private PersonBeacon currentPersonBeacon;
	private PersonBeacon selectedPersonBeacon;
	private String newBeaconUuid;
	private Integer newBeaconMajorCode;
	private Integer newBeaconMinorCode;
	private String newPersonBeaconTitle;
	private String newPersonBeaconFirstName;
	private String newPersonBeaconLastName;
	private String newPersonBeaconIconURL;
	private Beacon beacon;

	public PersonBeaconEditor(WOContext context) {
        super(context);
    }

	public NSArray<PersonBeacon> allPersonBeacons() {
		return PersonBeacon.fetchAllPersonBeacons(editingContext());
	}

	/**
	 * @return the currentPersonBeacon
	 */
	public PersonBeacon currentPersonBeacon() {
		return currentPersonBeacon;
	}

	/**
	 * @param currentPersonBeacon the currentPersonBeacon to set
	 */
	public void setCurrentPersonBeacon(PersonBeacon currentPersonBeacon) {
		this.currentPersonBeacon = currentPersonBeacon;
	}

	/**
	 * @return the selectedPersonBeacon
	 */
	public PersonBeacon selectedPersonBeacon() {
		return selectedPersonBeacon;
	}

	/**
	 * @param selectedPersonBeacon the selectedPersonBeacon to set
	 */
	public void setSelectedPersonBeacon(PersonBeacon selectedPersonBeacon) {
		this.selectedPersonBeacon = selectedPersonBeacon;
	}

	public WOActionResults saveChanges() {
		editingContext().saveChanges();
		return null;
	}

	/**
	 * @return the newBeaconUuid
	 */
	public String newBeaconUuid() {
		return newBeaconUuid;
	}

	/**
	 * @param newBeaconUuid the newBeaconUuid to set
	 */
	public void setNewBeaconUuid(String newBeaconUuid) {
		this.newBeaconUuid = newBeaconUuid;
	}

	/**
	 * @return the newBeaconMajorCode
	 */
	public Integer newBeaconMajorCode() {
		return newBeaconMajorCode;
	}

	/**
	 * @param newBeaconMajorCode the newBeaconMajorCode to set
	 */
	public void setNewBeaconMajorCode(Integer newBeaconMajorCode) {
		this.newBeaconMajorCode = newBeaconMajorCode;
	}

	/**
	 * @return the newBeaconMinorCode
	 */
	public Integer newBeaconMinorCode() {
		return newBeaconMinorCode;
	}

	/**
	 * @param newBeaconMinorCode the newBeaconMinorCode to set
	 */
	public void setNewBeaconMinorCode(Integer newBeaconMinorCode) {
		this.newBeaconMinorCode = newBeaconMinorCode;
	}

	/**
	 * @return the newPersonBeaconTitle
	 */
	public String newPersonBeaconTitle() {
		return newPersonBeaconTitle;
	}

	/**
	 * @param newPersonBeaconTitle the newPersonBeaconTitle to set
	 */
	public void setNewPersonBeaconTitle(String newPersonBeaconTitle) {
		this.newPersonBeaconTitle = newPersonBeaconTitle;
	}

	/**
	 * @return the newPersonBeaconFirstName
	 */
	public String newPersonBeaconFirstName() {
		return newPersonBeaconFirstName;
	}

	/**
	 * @param newPersonBeaconFirstName the newPersonBeaconFirstName to set
	 */
	public void setNewPersonBeaconFirstName(String newPersonBeaconFirstName) {
		this.newPersonBeaconFirstName = newPersonBeaconFirstName;
	}

	/**
	 * @return the newPersonBeaconLastName
	 */
	public String newPersonBeaconLastName() {
		return newPersonBeaconLastName;
	}

	/**
	 * @param newPersonBeaconLastName the newPersonBeaconLastName to set
	 */
	public void setNewPersonBeaconLastName(String newPersonBeaconLastName) {
		this.newPersonBeaconLastName = newPersonBeaconLastName;
	}

	/**
	 * @return the newPersonBeaconIconURL
	 */
	public String newPersonBeaconIconURL() {
		return newPersonBeaconIconURL;
	}

	/**
	 * @param newPersonBeaconIconURL the newPersonBeaconIconURL to set
	 */
	public void setNewPersonBeaconIconURL(String newPersonBeaconIconURL) {
		this.newPersonBeaconIconURL = newPersonBeaconIconURL;
	}

	public WOActionResults create() {
		if(StringUtils.isNotBlank(newBeaconUuid())&&newBeaconMajorCode()!=null&&newBeaconMinorCode()!=null){
			PersonBeacon beacon = PersonBeacon.createPersonBeacon(editingContext(), newBeaconMajorCode(), newBeaconMinorCode(), newBeaconUuid());
			beacon.setTitle(newPersonBeaconTitle());
			beacon.setFirstName(newPersonBeaconFirstName);
			beacon.setLastName(newPersonBeaconLastName);
			beacon.setIconURL(newPersonBeaconIconURL());
			saveChanges();
			setSelectedPersonBeacon(beacon);
		}
		return null;
	}

	/**
	 * @return the beacon
	 */
	public Beacon beacon() {
		return beacon;
	}

	/**
	 * @param beacon the beacon to set
	 */
	public void setBeacon(Beacon beacon) {
		this.beacon = beacon;
	}
}
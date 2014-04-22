/**
 * 
 */
package com.dd.beaconscanner.metadata.volotile;

import com.dd.beaconscanner.metadata.interfaces.PersonBeaconItem;

/**
 * @author goetz
 *
 */
public class VolatilePersonBeacon extends VolatileBeaconData implements
		PersonBeaconItem {

	/**
	 * @param uuid
	 * @param minorCode
	 * @param majorCode
	 * @param firstName
	 * @param lastName
	 * @param title
	 */
	public VolatilePersonBeacon(String uuid, Integer minorCode,
			Integer majorCode, String firstName, String lastName, String title) {
		super(uuid, minorCode, majorCode);
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
	}

	private String firstName;
	private String lastName;
	private String title;

	/* (non-Javadoc)
	 * @see com.dd.beaconscanner.metadata.interfaces.PersonBeaconItem#firstName()
	 */
	@Override
	public String firstName() {
		return firstName;
	}

	/* (non-Javadoc)
	 * @see com.dd.beaconscanner.metadata.interfaces.PersonBeaconItem#setFirstName(java.lang.String)
	 */
	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;

	}

	/* (non-Javadoc)
	 * @see com.dd.beaconscanner.metadata.interfaces.PersonBeaconItem#lastName()
	 */
	@Override
	public String lastName() {
		return lastName;
	}

	/* (non-Javadoc)
	 * @see com.dd.beaconscanner.metadata.interfaces.PersonBeaconItem#setLastName(java.lang.String)
	 */
	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;

	}

	/* (non-Javadoc)
	 * @see com.dd.beaconscanner.metadata.interfaces.PersonBeaconItem#title()
	 */
	@Override
	public String title() {
		return title;
	}

	/* (non-Javadoc)
	 * @see com.dd.beaconscanner.metadata.interfaces.PersonBeaconItem#setTitle(java.lang.String)
	 */
	@Override
	public void setTitle(String title) {
		this.title = title;

	}
	
	public String type(){
		return "person";
	}

}

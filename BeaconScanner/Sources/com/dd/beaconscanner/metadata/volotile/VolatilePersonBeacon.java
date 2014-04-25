/**
 * 
 */
package com.dd.beaconscanner.metadata.volotile;

import org.apache.commons.lang.StringUtils;

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
			Integer majorCode, String firstName, String lastName, String title, String position,String iconURL) {
		super(uuid, minorCode, majorCode);
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
		this.position = position;
		this.setIconURL(iconURL);
	}

	private String firstName;
	private String lastName;
	private String title;
	private String position;
	private String iconURL;

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
		return BEACON_META_DATA_TYPE_PERSON;
	}

	public String position() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String iconURL() {
		return iconURL;
	}

	public void setIconURL(String iconURL) {
		this.iconURL = iconURL;
	}

	@Override
	public String primaryInformationString() {
		StringBuilder sb =  new StringBuilder();
		if(StringUtils.isNotBlank(title())){
			sb.append(title()+" ");
		}
		if(StringUtils.isNotBlank(firstName())){
			sb.append(firstName()+" ");
		}
		if(StringUtils.isNotBlank(lastName())){
			sb.append(lastName());
		}
		return sb.toString();
	}

	@Override
	public String secondaryInformationString() {
		return position();
	}

}

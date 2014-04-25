/**
 * 
 */
package com.dd.beaconscanner.metadata.volotile;

import com.dd.beaconscanner.metadata.interfaces.ChannelDataItem;

/**
 * @author goetz
 *
 */
public class VolatileChannelBeacon extends VolatileBeaconData implements ChannelDataItem{

	private String message;
	private String action;
	private VolatileBeaconData beaconData;

	/**
	 * @param uuid
	 * @param minorCode
	 * @param majorCode
	 */
	public VolatileChannelBeacon(String uuid, Integer minorCode,
			Integer majorCode, String message, String action, VolatileBeaconData beaconData) {
		super(uuid, minorCode, majorCode);
		this.setMessage(message);
		this.setAction(action);
		this.setBeaconData(beaconData);
		if(beaconData!=null){
			beaconData.addToChannelBeacons(this);
		}
	}

	/* (non-Javadoc)
	 * @see com.dd.beaconscanner.metadata.volotile.VolatileBeaconData#type()
	 */
	@Override
	public String type() {
		return VolatileBeaconData.BEACON_META_DATA_TYPE_CHANNEL;
	}

	public String message() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String action() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public VolatileBeaconData beaconData() {
		return beaconData;
	}

	public void setBeaconData(VolatileBeaconData beaconData) {
		this.beaconData = beaconData;
	}

	@Override
	public String primaryInformationString() {
		return beaconData().primaryInformationString();
	}

	@Override
	public String secondaryInformationString() {
		return beaconData().secondaryInformationString();
	}

	@Override
	public String iconURL() {
		return beaconData().iconURL();
	}
	

}

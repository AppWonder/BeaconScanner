package com.dd.beaconscanner.components.editors;

import org.apache.commons.lang.StringUtils;

import com.webobjects.appserver.WOContext;
import com.dd.beaconscanner.components.BaseComponent;
import com.webobjects.foundation.NSArray;
import com.dd.beaconscanner.metadata.Channel;
import com.webobjects.appserver.WOActionResults;
import com.dd.beaconscanner.Beacon;

public class ChannelEditor extends BaseComponent {
    private Channel currentChannel;
	private Channel selectedChannel;
	private String newBeaconUuid;
	private Integer newBeaconMajorCode;
	private Integer newBeaconMinorCode;
	private String newChannelMessage;
	private String newChannelAction;
	private Beacon beacon;

	public ChannelEditor(WOContext context) {
        super(context);
    }

	public NSArray<Channel> allChannels() {
		return Channel.fetchAllChannels(editingContext());
	}

	/**
	 * @return the currentChannel
	 */
	public Channel currentChannel() {
		return currentChannel;
	}

	/**
	 * @param currentChannel the currentChannel to set
	 */
	public void setCurrentChannel(Channel currentChannel) {
		this.currentChannel = currentChannel;
	}

	/**
	 * @return the selectedChannel
	 */
	public Channel selectedChannel() {
		return selectedChannel;
	}

	/**
	 * @param selectedChannel the selectedChannel to set
	 */
	public void setSelectedChannel(Channel selectedChannel) {
		this.selectedChannel = selectedChannel;
	}

	public WOActionResults saveChanges() {
		editingContext().saveChanges();
		beaconManager().resetVolatileMetaData();
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
	 * @return the newChannelMessage
	 */
	public String newChannelMessage() {
		return newChannelMessage;
	}

	/**
	 * @param newChannelMessage the newChannelMessage to set
	 */
	public void setNewChannelMessage(String newChannelMessage) {
		this.newChannelMessage = newChannelMessage;
	}

	/**
	 * @return the newChannelAction
	 */
	public String newChannelAction() {
		return newChannelAction;
	}

	/**
	 * @param newChannelAction the newChannelAction to set
	 */
	public void setNewChannelAction(String newChannelAction) {
		this.newChannelAction = newChannelAction;
	}

	public WOActionResults create() {
		if(StringUtils.isNotBlank(newBeaconUuid())&&newBeaconMajorCode()!=null&&newBeaconMinorCode()!=null){
			Channel channel = Channel.createChannel(editingContext(), newBeaconMajorCode, newBeaconMinorCode, newBeaconUuid);
			channel.setMessage(newChannelMessage);
			channel.setAction(newChannelAction);
			saveChanges();
			setSelectedChannel(channel);
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
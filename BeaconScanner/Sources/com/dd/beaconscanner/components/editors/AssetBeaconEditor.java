package com.dd.beaconscanner.components.editors;

import org.apache.commons.lang.StringUtils;

import com.webobjects.appserver.WOContext;
import com.dd.beaconscanner.components.BaseComponent;
import com.webobjects.foundation.NSArray;
import com.dd.beaconscanner.metadata.AssetBeacon;
import com.webobjects.appserver.WOActionResults;
import com.dd.beaconscanner.Beacon;

public class AssetBeaconEditor extends BaseComponent {
    private AssetBeacon currentAssetBeacon;
	private AssetBeacon selectedAssetBeacon;
	private Beacon beacon;
	private String newAssetBeaconUuid;
	private Integer newAssetBeaconMajorCode;
	private Integer newAssetBeaconMinorCode;
	private String newAssetBeaconAssetId;
	private String newAssetBeaconAssetType;
	private String newAssetBeaconAssetIconURL;

	public AssetBeaconEditor(WOContext context) {
        super(context);
    }

	public NSArray<AssetBeacon> allAssetBeacons() {
		return AssetBeacon.fetchAllAssetBeacons(editingContext());
	}

	/**
	 * @return the currentAssetBeacon
	 */
	public AssetBeacon currentAssetBeacon() {
		return currentAssetBeacon;
	}

	/**
	 * @param currentAssetBeacon the currentAssetBeacon to set
	 */
	public void setCurrentAssetBeacon(AssetBeacon currentAssetBeacon) {
		this.currentAssetBeacon = currentAssetBeacon;
	}

	/**
	 * @return the selectedAssetBeacon
	 */
	public AssetBeacon selectedAssetBeacon() {
		return selectedAssetBeacon;
	}

	/**
	 * @param selectedAssetBeacon the selectedAssetBeacon to set
	 */
	public void setSelectedAssetBeacon(AssetBeacon selectedAssetBeacon) {
		this.selectedAssetBeacon = selectedAssetBeacon;
	}

	public WOActionResults saveChanges() {
		editingContext().saveChanges();
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

	/**
	 * @return the newAssetBeaconUuid
	 */
	public String newAssetBeaconUuid() {
		return newAssetBeaconUuid;
	}

	/**
	 * @param newAssetBeaconUuid the newAssetBeaconUuid to set
	 */
	public void setNewAssetBeaconUuid(String newAssetBeaconUuid) {
		this.newAssetBeaconUuid = newAssetBeaconUuid;
	}

	/**
	 * @return the newAssetBeaconMajorCode
	 */
	public Integer newAssetBeaconMajorCode() {
		return newAssetBeaconMajorCode;
	}

	/**
	 * @param newAssetBeaconMajorCode the newAssetBeaconMajorCode to set
	 */
	public void setNewAssetBeaconMajorCode(Integer newAssetBeaconMajorCode) {
		this.newAssetBeaconMajorCode = newAssetBeaconMajorCode;
	}

	/**
	 * @return the newAssetBeaconMinorCode
	 */
	public Integer newAssetBeaconMinorCode() {
		return newAssetBeaconMinorCode;
	}

	/**
	 * @param newAssetBeaconMinorCode the newAssetBeaconMinorCode to set
	 */
	public void setNewAssetBeaconMinorCode(Integer newAssetBeaconMinorCode) {
		this.newAssetBeaconMinorCode = newAssetBeaconMinorCode;
	}

	/**
	 * @return the newAssetBeaconAssetId
	 */
	public String newAssetBeaconAssetId() {
		return newAssetBeaconAssetId;
	}

	/**
	 * @param newAssetBeaconAssetId the newAssetBeaconAssetId to set
	 */
	public void setNewAssetBeaconAssetId(String newAssetBeaconAssetId) {
		this.newAssetBeaconAssetId = newAssetBeaconAssetId;
	}

	/**
	 * @return the newAssetBeaconAssetType
	 */
	public String newAssetBeaconAssetType() {
		return newAssetBeaconAssetType;
	}

	/**
	 * @param newAssetBeaconAssetType the newAssetBeaconAssetType to set
	 */
	public void setNewAssetBeaconAssetType(String newAssetBeaconAssetType) {
		this.newAssetBeaconAssetType = newAssetBeaconAssetType;
	}

	public WOActionResults create() {
		if(StringUtils.isNotBlank(newAssetBeaconUuid)&&newAssetBeaconMajorCode!=null&&newAssetBeaconMinorCode!=null){
			AssetBeacon beacon = AssetBeacon.createAssetBeacon(editingContext(), newAssetBeaconMajorCode(), newAssetBeaconMinorCode(), newAssetBeaconUuid());
			beacon.setAssetId(newAssetBeaconAssetId);
			beacon.setAssetType(newAssetBeaconAssetType);
			beacon.setIconURL(newAssetBeaconAssetIconURL);
			saveChanges();
			setSelectedAssetBeacon(beacon);
		}
		return null;
	}

	/**
	 * @return the newAssetBeaconAssetIconURL
	 */
	public String newAssetBeaconAssetIconURL() {
		return newAssetBeaconAssetIconURL;
	}

	/**
	 * @param newAssetBeaconAssetIconURL the newAssetBeaconAssetIconURL to set
	 */
	public void setNewAssetBeaconAssetIconURL(String newAssetBeaconAssetIconURL) {
		this.newAssetBeaconAssetIconURL = newAssetBeaconAssetIconURL;
	}
}
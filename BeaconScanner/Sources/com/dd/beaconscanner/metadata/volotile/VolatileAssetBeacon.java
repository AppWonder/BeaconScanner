package com.dd.beaconscanner.metadata.volotile;

import com.dd.beaconscanner.metadata.interfaces.AssetBeaconItem;

public class VolatileAssetBeacon extends VolatileBeaconData implements AssetBeaconItem {




	

	/**
	 * @param uuid
	 * @param minorCode
	 * @param majorCode
	 * @param assetType
	 */
	public VolatileAssetBeacon(String uuid, Integer minorCode,
			Integer majorCode, String assetType, String assetId, String iconURL) {
		super(uuid, minorCode, majorCode);
		this.assetType = assetType;
		this.assetId = assetId;
		this.iconURL = iconURL;
	}

	private String assetType;
	private String assetId;
	private String iconURL;

	@Override
	public String assetType() {
		return assetType;
	}

	@Override
	public void setAssetType(String assetType) {
		this.assetType = assetType; 
	}
	
	public String type(){
		return BEACON_META_DATA_TYPE_ASSET;
	}

	public String assetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public String iconURL(){
		return iconURL;
	}
	
	public void setIconURL(String iconURL){
		this.iconURL = iconURL;
	}
}

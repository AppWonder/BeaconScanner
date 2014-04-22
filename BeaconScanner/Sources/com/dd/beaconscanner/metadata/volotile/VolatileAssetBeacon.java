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
			Integer majorCode, String assetType) {
		super(uuid, minorCode, majorCode);
		this.assetType = assetType;
	}

	private String assetType;

	@Override
	public String assetType() {
		return assetType;
	}

	@Override
	public void setAssetType(String assetType) {
		this.assetType = assetType; 
	}
	
	public String type(){
		return "asset";
	}

}

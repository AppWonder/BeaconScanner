/**
 * 
 */
package com.dd.beaconscanner.metadata.interfaces;


/**
 * @author goetz
 *
 */
public interface AssetBeaconItem extends BeaconDataItem {

	public String assetType();
	public void setAssetType(String assetType);
	public String assetId();
	public void setAssetId(String assetId);
	public String iconURL();
	public void setIconURL(String iconURL);
	
}

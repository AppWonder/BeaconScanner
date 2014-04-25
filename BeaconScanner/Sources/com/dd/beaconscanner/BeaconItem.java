/**
 * 
 */
package com.dd.beaconscanner;

/**
 * @author goetz
 *
 */
public interface BeaconItem {
	
	public String uuid();
	public Integer majorCode();
	public Integer minorCode();
	public String uniqueKey();

}

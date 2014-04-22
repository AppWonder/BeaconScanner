package com.dd.beaconscanner.components;

import com.dd.beaconscanner.Beacon;
import com.dd.beaconscanner.BeaconManager;
import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSArray;

public class Main extends BaseComponent {
	
	
	private NSArray<Beacon> allBeacons;
	private Beacon currentBeacon;
	private String currentLocation;

	public Main(WOContext context) {
		super(context);
	}

	/**
	 * @return the allBeacons
	 */
	public NSArray<Beacon> allBeacons() {
		if(allBeacons==null){
			allBeacons = beaconManager().currentBeacons();
		}
		return allBeacons;
	}

	/**
	 * @param allBeacons the allBeacons to set
	 */
	public void setAllBeacons(NSArray<Beacon> allBeacons) {
		this.allBeacons = allBeacons;
	}

	/**
	 * @return the currentBeacon
	 */
	public Beacon currentBeacon() {
		return currentBeacon;
	}

	/**
	 * @param currentBeacon the currentBeacon to set
	 */
	public void setCurrentBeacon(Beacon currentBeacon) {
		this.currentBeacon = currentBeacon;
	}

	public BeaconManager beaconManager() {
		return BeaconManager.getInstance();
	}

	public String currentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}
	
	public NSArray<String> availableLocations(){
		return beaconManager().beaconLocationMap().allKeys();
	}
	
	public NSArray<Beacon> beaconsForCurrentLocation(){
		return beaconManager().beaconLocationMap().objectForKey(currentLocation());
	}


	
	
}

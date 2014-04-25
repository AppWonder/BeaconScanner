package com.dd.beaconscanner.components;

import com.dd.beaconscanner.Beacon;
import com.dd.beaconscanner.HealthItem;
import com.dd.beaconscanner.Location;
import com.dd.beaconscanner.metadata.PersonBeacon;
import com.dd.beaconscanner.metadata.volotile.VolatileLocationData;
import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;

public class PersonOverview extends BaseComponent {
    private PersonBeacon currentPerson;

	public PersonOverview(WOContext context) {
        super(context);
    }

	public NSArray<PersonBeacon> allPerson() {
		return PersonBeacon.fetchAllPersonBeacons(editingContext(), PersonBeacon.LAST_NAME.ascInsensitives());
	}

	/**
	 * @return the currentPerson
	 */
	public PersonBeacon currentPerson() {
		return currentPerson;
	}

	/**
	 * @param currentPerson the currentPerson to set
	 */
	public void setCurrentPerson(PersonBeacon currentPerson) {
		this.currentPerson = currentPerson;
	}

	public String locationForCurrentPerson() {
		Beacon beacon = beaconManager().beaconForBeaconDataItem(currentPerson());
		if(beacon==null||HealthItem.HEALTH_STATUS_LOST.equals(beacon.health())){
			return "offline";
		}
		Location location = beaconManager().locationsByUUID().objectForKey(beacon.location());
		if(location==null){
			return "error";
		}
		VolatileLocationData locationMetaData = beaconManager().locationMetaDataForLocation(location);
		if(locationMetaData==null){
			return "n/a";
		}
		return locationMetaData.name();
	}

	public NSArray<String> pannelsToUpdate() {
		NSMutableArray<String> ids = new NSMutableArray<String>();
		for(PersonBeacon beacon : allPerson()){
			setCurrentPerson(beacon);
			ids.addObject(currentPersonLocationDomID());
		}
		return ids.immutableClone();
	}

	public String currentPersonLocationDomID() {
		return "person_location_"+currentPerson().primaryKey();
	}
}
package com.dd.beaconscanner.components;

import com.dd.beaconscanner.Beacon;
import com.dd.beaconscanner.HealthItem;
import com.dd.beaconscanner.metadata.PersonBeacon;
import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSArray;

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
		Beacon beacon = beaconManager().beaconForUniqueKey(currentPerson().uniqueKey());
		if(beacon==null||HealthItem.HEALTH_STATUS_LOST.equals(beacon.health())){
			return "offline";
		}
		return beaconManager().locationsByUUID().objectForKey(beacon.location()).name();
	}

	public NSArray<String> pannelsToUpdate() {
		// TODO
		return null;
	}
}
// DO NOT EDIT.  Make changes to LocationData.java instead.
package com.dd.beaconscanner.metadata;

import com.dd.beaconscanner.metadata.interfaces.LocationDataItem;
import com.webobjects.eoaccess.*;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;
import java.math.*;
import java.util.*;
import org.apache.log4j.Logger;

import er.extensions.eof.*;
import er.extensions.foundation.*;

@SuppressWarnings("all")
public abstract class _LocationData extends  ERXGenericRecord implements LocationDataItem {
  public static final String ENTITY_NAME = "LocationData";

  // Attribute Keys
  public static final ERXKey<String> DEVICE_ID = new ERXKey<String>("deviceId");
  public static final ERXKey<String> ICON_URL = new ERXKey<String>("iconURL");
  public static final ERXKey<String> NAME = new ERXKey<String>("name");
  public static final ERXKey<String> UUID = new ERXKey<String>("uuid");
  // Relationship Keys

  // Attributes
  public static final String DEVICE_ID_KEY = DEVICE_ID.key();
  public static final String ICON_URL_KEY = ICON_URL.key();
  public static final String NAME_KEY = NAME.key();
  public static final String UUID_KEY = UUID.key();
  // Relationships

  private static Logger LOG = Logger.getLogger(_LocationData.class);

  public LocationData localInstanceIn(EOEditingContext editingContext) {
    LocationData localInstance = (LocationData)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  /* (non-Javadoc)
 * @see com.dd.beaconscanner.metadata.LocationDataItem#deviceId()
 */
@Override
public String deviceId() {
    return (String) storedValueForKey(_LocationData.DEVICE_ID_KEY);
  }

  /* (non-Javadoc)
 * @see com.dd.beaconscanner.metadata.LocationDataItem#setDeviceId(java.lang.String)
 */
@Override
public void setDeviceId(String value) {
    if (_LocationData.LOG.isDebugEnabled()) {
    	_LocationData.LOG.debug( "updating deviceId from " + deviceId() + " to " + value);
    }
    takeStoredValueForKey(value, _LocationData.DEVICE_ID_KEY);
  }

  /* (non-Javadoc)
 * @see com.dd.beaconscanner.metadata.LocationDataItem#iconURL()
 */
@Override
public String iconURL() {
    return (String) storedValueForKey(_LocationData.ICON_URL_KEY);
  }

  /* (non-Javadoc)
 * @see com.dd.beaconscanner.metadata.LocationDataItem#setIconURL(java.lang.String)
 */
@Override
public void setIconURL(String value) {
    if (_LocationData.LOG.isDebugEnabled()) {
    	_LocationData.LOG.debug( "updating iconURL from " + iconURL() + " to " + value);
    }
    takeStoredValueForKey(value, _LocationData.ICON_URL_KEY);
  }

  /* (non-Javadoc)
 * @see com.dd.beaconscanner.metadata.LocationDataItem#name()
 */
@Override
public String name() {
    return (String) storedValueForKey(_LocationData.NAME_KEY);
  }

  /* (non-Javadoc)
 * @see com.dd.beaconscanner.metadata.LocationDataItem#setName(java.lang.String)
 */
@Override
public void setName(String value) {
    if (_LocationData.LOG.isDebugEnabled()) {
    	_LocationData.LOG.debug( "updating name from " + name() + " to " + value);
    }
    takeStoredValueForKey(value, _LocationData.NAME_KEY);
  }

  /* (non-Javadoc)
 * @see com.dd.beaconscanner.metadata.LocationDataItem#uuid()
 */
@Override
public String uuid() {
    return (String) storedValueForKey(_LocationData.UUID_KEY);
  }

  /* (non-Javadoc)
 * @see com.dd.beaconscanner.metadata.LocationDataItem#setUuid(java.lang.String)
 */
@Override
public void setUuid(String value) {
    if (_LocationData.LOG.isDebugEnabled()) {
    	_LocationData.LOG.debug( "updating uuid from " + uuid() + " to " + value);
    }
    takeStoredValueForKey(value, _LocationData.UUID_KEY);
  }


  public static LocationData createLocationData(EOEditingContext editingContext, String uuid
) {
    LocationData eo = (LocationData) EOUtilities.createAndInsertInstance(editingContext, _LocationData.ENTITY_NAME);    
		eo.setUuid(uuid);
    return eo;
  }

  public static ERXFetchSpecification<LocationData> fetchSpec() {
    return new ERXFetchSpecification<LocationData>(_LocationData.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<LocationData> fetchAllLocationDatas(EOEditingContext editingContext) {
    return _LocationData.fetchAllLocationDatas(editingContext, null);
  }

  public static NSArray<LocationData> fetchAllLocationDatas(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _LocationData.fetchLocationDatas(editingContext, null, sortOrderings);
  }

  public static NSArray<LocationData> fetchLocationDatas(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<LocationData> fetchSpec = new ERXFetchSpecification<LocationData>(_LocationData.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<LocationData> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static LocationData fetchLocationData(EOEditingContext editingContext, String keyName, Object value) {
    return _LocationData.fetchLocationData(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static LocationData fetchLocationData(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<LocationData> eoObjects = _LocationData.fetchLocationDatas(editingContext, qualifier, null);
    LocationData eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one LocationData that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static LocationData fetchRequiredLocationData(EOEditingContext editingContext, String keyName, Object value) {
    return _LocationData.fetchRequiredLocationData(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static LocationData fetchRequiredLocationData(EOEditingContext editingContext, EOQualifier qualifier) {
    LocationData eoObject = _LocationData.fetchLocationData(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no LocationData that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static LocationData localInstanceIn(EOEditingContext editingContext, LocationData eo) {
    LocationData localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}

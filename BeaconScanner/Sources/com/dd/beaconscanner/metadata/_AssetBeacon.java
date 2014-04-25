// DO NOT EDIT.  Make changes to AssetBeacon.java instead.
package com.dd.beaconscanner.metadata;

import com.webobjects.eoaccess.*;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;
import java.math.*;
import java.util.*;
import org.apache.log4j.Logger;

import er.extensions.eof.*;
import er.extensions.foundation.*;

@SuppressWarnings("all")
public abstract class _AssetBeacon extends com.dd.beaconscanner.metadata.BeaconData {
  public static final String ENTITY_NAME = "AssetBeacon";

  // Attribute Keys
  public static final ERXKey<String> ASSET_ID = new ERXKey<String>("assetId");
  public static final ERXKey<String> ASSET_TYPE = new ERXKey<String>("assetType");
  public static final ERXKey<String> ICON_URL = new ERXKey<String>("iconURL");
  public static final ERXKey<Integer> MAJOR_CODE = new ERXKey<Integer>("majorCode");
  public static final ERXKey<Integer> MINOR_CODE = new ERXKey<Integer>("minorCode");
  public static final ERXKey<Integer> RECORD_TYPE = new ERXKey<Integer>("record_type");
  public static final ERXKey<String> UUID = new ERXKey<String>("uuid");
  // Relationship Keys
  public static final ERXKey<com.dd.beaconscanner.metadata.Channel> CHANNELS = new ERXKey<com.dd.beaconscanner.metadata.Channel>("channels");

  // Attributes
  public static final String ASSET_ID_KEY = ASSET_ID.key();
  public static final String ASSET_TYPE_KEY = ASSET_TYPE.key();
  public static final String ICON_URL_KEY = ICON_URL.key();
  public static final String MAJOR_CODE_KEY = MAJOR_CODE.key();
  public static final String MINOR_CODE_KEY = MINOR_CODE.key();
  public static final String RECORD_TYPE_KEY = RECORD_TYPE.key();
  public static final String UUID_KEY = UUID.key();
  // Relationships
  public static final String CHANNELS_KEY = CHANNELS.key();

  private static Logger LOG = Logger.getLogger(_AssetBeacon.class);

  public AssetBeacon localInstanceIn(EOEditingContext editingContext) {
    AssetBeacon localInstance = (AssetBeacon)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String assetId() {
    return (String) storedValueForKey(_AssetBeacon.ASSET_ID_KEY);
  }

  public void setAssetId(String value) {
    if (_AssetBeacon.LOG.isDebugEnabled()) {
    	_AssetBeacon.LOG.debug( "updating assetId from " + assetId() + " to " + value);
    }
    takeStoredValueForKey(value, _AssetBeacon.ASSET_ID_KEY);
  }

  public String assetType() {
    return (String) storedValueForKey(_AssetBeacon.ASSET_TYPE_KEY);
  }

  public void setAssetType(String value) {
    if (_AssetBeacon.LOG.isDebugEnabled()) {
    	_AssetBeacon.LOG.debug( "updating assetType from " + assetType() + " to " + value);
    }
    takeStoredValueForKey(value, _AssetBeacon.ASSET_TYPE_KEY);
  }

  public String iconURL() {
    return (String) storedValueForKey(_AssetBeacon.ICON_URL_KEY);
  }

  public void setIconURL(String value) {
    if (_AssetBeacon.LOG.isDebugEnabled()) {
    	_AssetBeacon.LOG.debug( "updating iconURL from " + iconURL() + " to " + value);
    }
    takeStoredValueForKey(value, _AssetBeacon.ICON_URL_KEY);
  }


  public static AssetBeacon createAssetBeacon(EOEditingContext editingContext, Integer majorCode
, Integer minorCode
, String uuid
) {
    AssetBeacon eo = (AssetBeacon) EOUtilities.createAndInsertInstance(editingContext, _AssetBeacon.ENTITY_NAME);    
		eo.setMajorCode(majorCode);
		eo.setMinorCode(minorCode);
		eo.setUuid(uuid);
    return eo;
  }

  public static ERXFetchSpecification<AssetBeacon> fetchSpecForAssetBeacon() {
    return new ERXFetchSpecification<AssetBeacon>(_AssetBeacon.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<AssetBeacon> fetchAllAssetBeacons(EOEditingContext editingContext) {
    return _AssetBeacon.fetchAllAssetBeacons(editingContext, null);
  }

  public static NSArray<AssetBeacon> fetchAllAssetBeacons(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _AssetBeacon.fetchAssetBeacons(editingContext, null, sortOrderings);
  }

  public static NSArray<AssetBeacon> fetchAssetBeacons(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<AssetBeacon> fetchSpec = new ERXFetchSpecification<AssetBeacon>(_AssetBeacon.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<AssetBeacon> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static AssetBeacon fetchAssetBeacon(EOEditingContext editingContext, String keyName, Object value) {
    return _AssetBeacon.fetchAssetBeacon(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static AssetBeacon fetchAssetBeacon(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<AssetBeacon> eoObjects = _AssetBeacon.fetchAssetBeacons(editingContext, qualifier, null);
    AssetBeacon eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one AssetBeacon that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static AssetBeacon fetchRequiredAssetBeacon(EOEditingContext editingContext, String keyName, Object value) {
    return _AssetBeacon.fetchRequiredAssetBeacon(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static AssetBeacon fetchRequiredAssetBeacon(EOEditingContext editingContext, EOQualifier qualifier) {
    AssetBeacon eoObject = _AssetBeacon.fetchAssetBeacon(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no AssetBeacon that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static AssetBeacon localInstanceIn(EOEditingContext editingContext, AssetBeacon eo) {
    AssetBeacon localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}

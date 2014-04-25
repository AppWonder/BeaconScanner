// DO NOT EDIT.  Make changes to BeaconData.java instead.
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
public abstract class _BeaconData extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "BeaconData";

  // Attribute Keys
  public static final ERXKey<Integer> MAJOR_CODE = new ERXKey<Integer>("majorCode");
  public static final ERXKey<Integer> MINOR_CODE = new ERXKey<Integer>("minorCode");
  public static final ERXKey<Integer> RECORD_TYPE = new ERXKey<Integer>("record_type");
  public static final ERXKey<String> UUID = new ERXKey<String>("uuid");
  // Relationship Keys
  public static final ERXKey<com.dd.beaconscanner.metadata.Channel> CHANNELS = new ERXKey<com.dd.beaconscanner.metadata.Channel>("channels");

  // Attributes
  public static final String MAJOR_CODE_KEY = MAJOR_CODE.key();
  public static final String MINOR_CODE_KEY = MINOR_CODE.key();
  public static final String RECORD_TYPE_KEY = RECORD_TYPE.key();
  public static final String UUID_KEY = UUID.key();
  // Relationships
  public static final String CHANNELS_KEY = CHANNELS.key();

  private static Logger LOG = Logger.getLogger(_BeaconData.class);

  public BeaconData localInstanceIn(EOEditingContext editingContext) {
    BeaconData localInstance = (BeaconData)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public Integer majorCode() {
    return (Integer) storedValueForKey(_BeaconData.MAJOR_CODE_KEY);
  }

  public void setMajorCode(Integer value) {
    if (_BeaconData.LOG.isDebugEnabled()) {
    	_BeaconData.LOG.debug( "updating majorCode from " + majorCode() + " to " + value);
    }
    takeStoredValueForKey(value, _BeaconData.MAJOR_CODE_KEY);
  }

  public Integer minorCode() {
    return (Integer) storedValueForKey(_BeaconData.MINOR_CODE_KEY);
  }

  public void setMinorCode(Integer value) {
    if (_BeaconData.LOG.isDebugEnabled()) {
    	_BeaconData.LOG.debug( "updating minorCode from " + minorCode() + " to " + value);
    }
    takeStoredValueForKey(value, _BeaconData.MINOR_CODE_KEY);
  }

  public Integer record_type() {
    return (Integer) storedValueForKey(_BeaconData.RECORD_TYPE_KEY);
  }

  public void setRecord_type(Integer value) {
    if (_BeaconData.LOG.isDebugEnabled()) {
    	_BeaconData.LOG.debug( "updating record_type from " + record_type() + " to " + value);
    }
    takeStoredValueForKey(value, _BeaconData.RECORD_TYPE_KEY);
  }

  public String uuid() {
    return (String) storedValueForKey(_BeaconData.UUID_KEY);
  }

  public void setUuid(String value) {
    if (_BeaconData.LOG.isDebugEnabled()) {
    	_BeaconData.LOG.debug( "updating uuid from " + uuid() + " to " + value);
    }
    takeStoredValueForKey(value, _BeaconData.UUID_KEY);
  }

  public NSArray<com.dd.beaconscanner.metadata.Channel> channels() {
    return (NSArray<com.dd.beaconscanner.metadata.Channel>)storedValueForKey(_BeaconData.CHANNELS_KEY);
  }

  public NSArray<com.dd.beaconscanner.metadata.Channel> channels(EOQualifier qualifier) {
    return channels(qualifier, null, false);
  }

  public NSArray<com.dd.beaconscanner.metadata.Channel> channels(EOQualifier qualifier, boolean fetch) {
    return channels(qualifier, null, fetch);
  }

  public NSArray<com.dd.beaconscanner.metadata.Channel> channels(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<com.dd.beaconscanner.metadata.Channel> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(com.dd.beaconscanner.metadata.Channel.BEACON_DATA_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = com.dd.beaconscanner.metadata.Channel.fetchChannels(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = channels();
      if (qualifier != null) {
        results = (NSArray<com.dd.beaconscanner.metadata.Channel>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<com.dd.beaconscanner.metadata.Channel>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToChannels(com.dd.beaconscanner.metadata.Channel object) {
    includeObjectIntoPropertyWithKey(object, _BeaconData.CHANNELS_KEY);
  }

  public void removeFromChannels(com.dd.beaconscanner.metadata.Channel object) {
    excludeObjectFromPropertyWithKey(object, _BeaconData.CHANNELS_KEY);
  }

  public void addToChannelsRelationship(com.dd.beaconscanner.metadata.Channel object) {
    if (_BeaconData.LOG.isDebugEnabled()) {
      _BeaconData.LOG.debug("adding " + object + " to channels relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToChannels(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _BeaconData.CHANNELS_KEY);
    }
  }

  public void removeFromChannelsRelationship(com.dd.beaconscanner.metadata.Channel object) {
    if (_BeaconData.LOG.isDebugEnabled()) {
      _BeaconData.LOG.debug("removing " + object + " from channels relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromChannels(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _BeaconData.CHANNELS_KEY);
    }
  }

  public com.dd.beaconscanner.metadata.Channel createChannelsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( com.dd.beaconscanner.metadata.Channel.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _BeaconData.CHANNELS_KEY);
    return (com.dd.beaconscanner.metadata.Channel) eo;
  }

  public void deleteChannelsRelationship(com.dd.beaconscanner.metadata.Channel object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _BeaconData.CHANNELS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllChannelsRelationships() {
    Enumeration<com.dd.beaconscanner.metadata.Channel> objects = channels().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteChannelsRelationship(objects.nextElement());
    }
  }


  public static BeaconData createBeaconData(EOEditingContext editingContext, Integer majorCode
, Integer minorCode
, Integer record_type
, String uuid
) {
    BeaconData eo = (BeaconData) EOUtilities.createAndInsertInstance(editingContext, _BeaconData.ENTITY_NAME);    
		eo.setMajorCode(majorCode);
		eo.setMinorCode(minorCode);
		eo.setRecord_type(record_type);
		eo.setUuid(uuid);
    return eo;
  }

  public static ERXFetchSpecification<BeaconData> fetchSpec() {
    return new ERXFetchSpecification<BeaconData>(_BeaconData.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<BeaconData> fetchAllBeaconDatas(EOEditingContext editingContext) {
    return _BeaconData.fetchAllBeaconDatas(editingContext, null);
  }

  public static NSArray<BeaconData> fetchAllBeaconDatas(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _BeaconData.fetchBeaconDatas(editingContext, null, sortOrderings);
  }

  public static NSArray<BeaconData> fetchBeaconDatas(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<BeaconData> fetchSpec = new ERXFetchSpecification<BeaconData>(_BeaconData.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<BeaconData> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static BeaconData fetchBeaconData(EOEditingContext editingContext, String keyName, Object value) {
    return _BeaconData.fetchBeaconData(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static BeaconData fetchBeaconData(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<BeaconData> eoObjects = _BeaconData.fetchBeaconDatas(editingContext, qualifier, null);
    BeaconData eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one BeaconData that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static BeaconData fetchRequiredBeaconData(EOEditingContext editingContext, String keyName, Object value) {
    return _BeaconData.fetchRequiredBeaconData(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static BeaconData fetchRequiredBeaconData(EOEditingContext editingContext, EOQualifier qualifier) {
    BeaconData eoObject = _BeaconData.fetchBeaconData(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no BeaconData that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static BeaconData localInstanceIn(EOEditingContext editingContext, BeaconData eo) {
    BeaconData localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}

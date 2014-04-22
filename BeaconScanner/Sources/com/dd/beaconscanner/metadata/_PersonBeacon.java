// DO NOT EDIT.  Make changes to PersonBeacon.java instead.
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
public abstract class _PersonBeacon extends com.dd.beaconscanner.metadata.BeaconData {
  public static final String ENTITY_NAME = "PersonBeacon";

  // Attribute Keys
  public static final ERXKey<String> FIRST_NAME = new ERXKey<String>("firstName");
  public static final ERXKey<String> LAST_NAME = new ERXKey<String>("lastName");
  public static final ERXKey<Integer> MAJOR_CODE = new ERXKey<Integer>("majorCode");
  public static final ERXKey<Integer> MINOR_CODE = new ERXKey<Integer>("minorCode");
  public static final ERXKey<Integer> RECORD_TYPE = new ERXKey<Integer>("record_type");
  public static final ERXKey<String> TITLE = new ERXKey<String>("title");
  public static final ERXKey<String> UUID = new ERXKey<String>("uuid");
  // Relationship Keys

  // Attributes
  public static final String FIRST_NAME_KEY = FIRST_NAME.key();
  public static final String LAST_NAME_KEY = LAST_NAME.key();
  public static final String MAJOR_CODE_KEY = MAJOR_CODE.key();
  public static final String MINOR_CODE_KEY = MINOR_CODE.key();
  public static final String RECORD_TYPE_KEY = RECORD_TYPE.key();
  public static final String TITLE_KEY = TITLE.key();
  public static final String UUID_KEY = UUID.key();
  // Relationships

  private static Logger LOG = Logger.getLogger(_PersonBeacon.class);

  public PersonBeacon localInstanceIn(EOEditingContext editingContext) {
    PersonBeacon localInstance = (PersonBeacon)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String firstName() {
    return (String) storedValueForKey(_PersonBeacon.FIRST_NAME_KEY);
  }

  public void setFirstName(String value) {
    if (_PersonBeacon.LOG.isDebugEnabled()) {
    	_PersonBeacon.LOG.debug( "updating firstName from " + firstName() + " to " + value);
    }
    takeStoredValueForKey(value, _PersonBeacon.FIRST_NAME_KEY);
  }

  public String lastName() {
    return (String) storedValueForKey(_PersonBeacon.LAST_NAME_KEY);
  }

  public void setLastName(String value) {
    if (_PersonBeacon.LOG.isDebugEnabled()) {
    	_PersonBeacon.LOG.debug( "updating lastName from " + lastName() + " to " + value);
    }
    takeStoredValueForKey(value, _PersonBeacon.LAST_NAME_KEY);
  }

  public String title() {
    return (String) storedValueForKey(_PersonBeacon.TITLE_KEY);
  }

  public void setTitle(String value) {
    if (_PersonBeacon.LOG.isDebugEnabled()) {
    	_PersonBeacon.LOG.debug( "updating title from " + title() + " to " + value);
    }
    takeStoredValueForKey(value, _PersonBeacon.TITLE_KEY);
  }


  public static PersonBeacon createPersonBeacon(EOEditingContext editingContext, Integer majorCode
, Integer minorCode
, String uuid
) {
    PersonBeacon eo = (PersonBeacon) EOUtilities.createAndInsertInstance(editingContext, _PersonBeacon.ENTITY_NAME);    
		eo.setMajorCode(majorCode);
		eo.setMinorCode(minorCode);
		eo.setUuid(uuid);
    return eo;
  }

  public static ERXFetchSpecification<PersonBeacon> fetchSpecForPersonBeacon() {
    return new ERXFetchSpecification<PersonBeacon>(_PersonBeacon.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<PersonBeacon> fetchAllPersonBeacons(EOEditingContext editingContext) {
    return _PersonBeacon.fetchAllPersonBeacons(editingContext, null);
  }

  public static NSArray<PersonBeacon> fetchAllPersonBeacons(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _PersonBeacon.fetchPersonBeacons(editingContext, null, sortOrderings);
  }

  public static NSArray<PersonBeacon> fetchPersonBeacons(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<PersonBeacon> fetchSpec = new ERXFetchSpecification<PersonBeacon>(_PersonBeacon.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<PersonBeacon> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static PersonBeacon fetchPersonBeacon(EOEditingContext editingContext, String keyName, Object value) {
    return _PersonBeacon.fetchPersonBeacon(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static PersonBeacon fetchPersonBeacon(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<PersonBeacon> eoObjects = _PersonBeacon.fetchPersonBeacons(editingContext, qualifier, null);
    PersonBeacon eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one PersonBeacon that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static PersonBeacon fetchRequiredPersonBeacon(EOEditingContext editingContext, String keyName, Object value) {
    return _PersonBeacon.fetchRequiredPersonBeacon(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static PersonBeacon fetchRequiredPersonBeacon(EOEditingContext editingContext, EOQualifier qualifier) {
    PersonBeacon eoObject = _PersonBeacon.fetchPersonBeacon(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no PersonBeacon that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static PersonBeacon localInstanceIn(EOEditingContext editingContext, PersonBeacon eo) {
    PersonBeacon localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}

// DO NOT EDIT.  Make changes to BeaconData.java instead.
package com.dd.beaconscanner.metadata;

import com.dd.beaconscanner.metadata.interfaces.BeaconDataItem;
import com.webobjects.eoaccess.*;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;
import java.math.*;
import java.util.*;
import org.apache.log4j.Logger;

import er.extensions.eof.*;
import er.extensions.foundation.*;

@SuppressWarnings("all")
public abstract class _BeaconData extends  ERXGenericRecord implements BeaconDataItem {
  public static final String ENTITY_NAME = "BeaconData";

  // Attribute Keys
  public static final ERXKey<Integer> MAJOR_CODE = new ERXKey<Integer>("majorCode");
  public static final ERXKey<Integer> MINOR_CODE = new ERXKey<Integer>("minorCode");
  public static final ERXKey<Integer> RECORD_TYPE = new ERXKey<Integer>("record_type");
  public static final ERXKey<String> UUID = new ERXKey<String>("uuid");
  // Relationship Keys

  // Attributes
  public static final String MAJOR_CODE_KEY = MAJOR_CODE.key();
  public static final String MINOR_CODE_KEY = MINOR_CODE.key();
  public static final String RECORD_TYPE_KEY = RECORD_TYPE.key();
  public static final String UUID_KEY = UUID.key();
  // Relationships

  private static Logger LOG = Logger.getLogger(_BeaconData.class);

  public BeaconData localInstanceIn(EOEditingContext editingContext) {
    BeaconData localInstance = (BeaconData)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  /* (non-Javadoc)
 * @see com.dd.beaconscanner.metadata.BeaconDataItem#majorCode()
 */
@Override
public Integer majorCode() {
    return (Integer) storedValueForKey(_BeaconData.MAJOR_CODE_KEY);
  }

  /* (non-Javadoc)
 * @see com.dd.beaconscanner.metadata.BeaconDataItem#setMajorCode(java.lang.Integer)
 */
@Override
public void setMajorCode(Integer value) {
    if (_BeaconData.LOG.isDebugEnabled()) {
    	_BeaconData.LOG.debug( "updating majorCode from " + majorCode() + " to " + value);
    }
    takeStoredValueForKey(value, _BeaconData.MAJOR_CODE_KEY);
  }

  /* (non-Javadoc)
 * @see com.dd.beaconscanner.metadata.BeaconDataItem#minorCode()
 */
@Override
public Integer minorCode() {
    return (Integer) storedValueForKey(_BeaconData.MINOR_CODE_KEY);
  }

  /* (non-Javadoc)
 * @see com.dd.beaconscanner.metadata.BeaconDataItem#setMinorCode(java.lang.Integer)
 */
@Override
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

  /* (non-Javadoc)
 * @see com.dd.beaconscanner.metadata.BeaconDataItem#uuid()
 */
@Override
public String uuid() {
    return (String) storedValueForKey(_BeaconData.UUID_KEY);
  }

  /* (non-Javadoc)
 * @see com.dd.beaconscanner.metadata.BeaconDataItem#setUuid(java.lang.String)
 */
@Override
public void setUuid(String value) {
    if (_BeaconData.LOG.isDebugEnabled()) {
    	_BeaconData.LOG.debug( "updating uuid from " + uuid() + " to " + value);
    }
    takeStoredValueForKey(value, _BeaconData.UUID_KEY);
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

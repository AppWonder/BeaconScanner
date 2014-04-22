// DO NOT EDIT.  Make changes to ChannelMap.java instead.
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
public abstract class _ChannelMap extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "ChannelMap";

  // Attribute Keys
  public static final ERXKey<String> NAME = new ERXKey<String>("name");
  // Relationship Keys

  // Attributes
  public static final String NAME_KEY = NAME.key();
  // Relationships

  private static Logger LOG = Logger.getLogger(_ChannelMap.class);

  public ChannelMap localInstanceIn(EOEditingContext editingContext) {
    ChannelMap localInstance = (ChannelMap)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String name() {
    return (String) storedValueForKey(_ChannelMap.NAME_KEY);
  }

  public void setName(String value) {
    if (_ChannelMap.LOG.isDebugEnabled()) {
    	_ChannelMap.LOG.debug( "updating name from " + name() + " to " + value);
    }
    takeStoredValueForKey(value, _ChannelMap.NAME_KEY);
  }


  public static ChannelMap createChannelMap(EOEditingContext editingContext, String name
) {
    ChannelMap eo = (ChannelMap) EOUtilities.createAndInsertInstance(editingContext, _ChannelMap.ENTITY_NAME);    
		eo.setName(name);
    return eo;
  }

  public static ERXFetchSpecification<ChannelMap> fetchSpec() {
    return new ERXFetchSpecification<ChannelMap>(_ChannelMap.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<ChannelMap> fetchAllChannelMaps(EOEditingContext editingContext) {
    return _ChannelMap.fetchAllChannelMaps(editingContext, null);
  }

  public static NSArray<ChannelMap> fetchAllChannelMaps(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _ChannelMap.fetchChannelMaps(editingContext, null, sortOrderings);
  }

  public static NSArray<ChannelMap> fetchChannelMaps(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<ChannelMap> fetchSpec = new ERXFetchSpecification<ChannelMap>(_ChannelMap.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<ChannelMap> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static ChannelMap fetchChannelMap(EOEditingContext editingContext, String keyName, Object value) {
    return _ChannelMap.fetchChannelMap(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ChannelMap fetchChannelMap(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<ChannelMap> eoObjects = _ChannelMap.fetchChannelMaps(editingContext, qualifier, null);
    ChannelMap eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one ChannelMap that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ChannelMap fetchRequiredChannelMap(EOEditingContext editingContext, String keyName, Object value) {
    return _ChannelMap.fetchRequiredChannelMap(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ChannelMap fetchRequiredChannelMap(EOEditingContext editingContext, EOQualifier qualifier) {
    ChannelMap eoObject = _ChannelMap.fetchChannelMap(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no ChannelMap that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ChannelMap localInstanceIn(EOEditingContext editingContext, ChannelMap eo) {
    ChannelMap localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}

// DO NOT EDIT.  Make changes to Channel.java instead.
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
public abstract class _Channel extends com.dd.beaconscanner.metadata.BeaconData {
  public static final String ENTITY_NAME = "Channel";

  // Attribute Keys
  public static final ERXKey<String> ACTION = new ERXKey<String>("action");
  public static final ERXKey<Integer> MAJOR_CODE = new ERXKey<Integer>("majorCode");
  public static final ERXKey<String> MESSAGE = new ERXKey<String>("message");
  public static final ERXKey<Integer> MINOR_CODE = new ERXKey<Integer>("minorCode");
  public static final ERXKey<Integer> RECORD_TYPE = new ERXKey<Integer>("record_type");
  public static final ERXKey<String> UUID = new ERXKey<String>("uuid");
  // Relationship Keys

  // Attributes
  public static final String ACTION_KEY = ACTION.key();
  public static final String MAJOR_CODE_KEY = MAJOR_CODE.key();
  public static final String MESSAGE_KEY = MESSAGE.key();
  public static final String MINOR_CODE_KEY = MINOR_CODE.key();
  public static final String RECORD_TYPE_KEY = RECORD_TYPE.key();
  public static final String UUID_KEY = UUID.key();
  // Relationships

  private static Logger LOG = Logger.getLogger(_Channel.class);

  public Channel localInstanceIn(EOEditingContext editingContext) {
    Channel localInstance = (Channel)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String action() {
    return (String) storedValueForKey(_Channel.ACTION_KEY);
  }

  public void setAction(String value) {
    if (_Channel.LOG.isDebugEnabled()) {
    	_Channel.LOG.debug( "updating action from " + action() + " to " + value);
    }
    takeStoredValueForKey(value, _Channel.ACTION_KEY);
  }

  public String message() {
    return (String) storedValueForKey(_Channel.MESSAGE_KEY);
  }

  public void setMessage(String value) {
    if (_Channel.LOG.isDebugEnabled()) {
    	_Channel.LOG.debug( "updating message from " + message() + " to " + value);
    }
    takeStoredValueForKey(value, _Channel.MESSAGE_KEY);
  }


  public static Channel createChannel(EOEditingContext editingContext, Integer majorCode
, Integer minorCode
, String uuid
) {
    Channel eo = (Channel) EOUtilities.createAndInsertInstance(editingContext, _Channel.ENTITY_NAME);    
		eo.setMajorCode(majorCode);
		eo.setMinorCode(minorCode);
		eo.setUuid(uuid);
    return eo;
  }

  public static ERXFetchSpecification<Channel> fetchSpecForChannel() {
    return new ERXFetchSpecification<Channel>(_Channel.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<Channel> fetchAllChannels(EOEditingContext editingContext) {
    return _Channel.fetchAllChannels(editingContext, null);
  }

  public static NSArray<Channel> fetchAllChannels(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Channel.fetchChannels(editingContext, null, sortOrderings);
  }

  public static NSArray<Channel> fetchChannels(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<Channel> fetchSpec = new ERXFetchSpecification<Channel>(_Channel.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<Channel> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static Channel fetchChannel(EOEditingContext editingContext, String keyName, Object value) {
    return _Channel.fetchChannel(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Channel fetchChannel(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Channel> eoObjects = _Channel.fetchChannels(editingContext, qualifier, null);
    Channel eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Channel that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Channel fetchRequiredChannel(EOEditingContext editingContext, String keyName, Object value) {
    return _Channel.fetchRequiredChannel(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Channel fetchRequiredChannel(EOEditingContext editingContext, EOQualifier qualifier) {
    Channel eoObject = _Channel.fetchChannel(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Channel that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Channel localInstanceIn(EOEditingContext editingContext, Channel eo) {
    Channel localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}

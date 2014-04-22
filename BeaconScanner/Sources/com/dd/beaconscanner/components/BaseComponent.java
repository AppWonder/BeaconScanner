package com.dd.beaconscanner.components;

import com.dd.beaconscanner.Application;
import com.dd.beaconscanner.BeaconManager;
import com.dd.beaconscanner.Session;
import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.EOEditingContext;

import er.extensions.components.ERXComponent;

public class BaseComponent extends ERXComponent {
	public BaseComponent(WOContext context) {
		super(context);
	}
	
	@Override
	public Application application() {
		return (Application)super.application();
	}
	
	@Override
	public Session session() {
		return (Session)super.session();
	}
	
	public BeaconManager beaconManager(){
		return BeaconManager.getInstance();
	}
	
	public EOEditingContext editingContext(){
		return session().defaultEditingContext();
	}
}

package com.dd.beaconscanner.components;

import com.webobjects.appserver.WOContext;

import er.extensions.components.ERXComponent;

import com.dd.beaconscanner.Application;
import com.dd.beaconscanner.Session;

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
}

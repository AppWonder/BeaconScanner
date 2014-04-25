package com.dd.beaconscanner.components;

import com.webobjects.appserver.WOContext;

public class NavigationBar extends BaseComponent {
    
	public NavigationBar(WOContext context) {
        super(context);
    }
	
	public boolean isSelectedPersons() {
		return (context().page() instanceof PersonOverview);
	}
	
	public boolean isSelectedRadar() {
		return (context().page() instanceof RadarOverview);
	}
	
	public boolean isSelectedAssets() {
		return (context().page() instanceof AssetOverview);
	}
	
	public String cssClassPersons() {
		return isSelectedPersons() ? "active" : null;
	}
	
	public String cssClassRadar() {
		return isSelectedRadar() ? "active" : null;
	}
	
	public String cssClassAssets() {
		return isSelectedAssets() ? "active" : null;
	}
	
}
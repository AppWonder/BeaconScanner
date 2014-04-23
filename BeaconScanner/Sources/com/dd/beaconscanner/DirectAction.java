package com.dd.beaconscanner;

import org.apache.commons.lang.StringUtils;

import com.dd.beaconscanner.components.Main;
import com.dd.beaconscanner.components.RadarOverview;
import com.dd.beaconscanner.components.editors.AdminPortal;
import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOApplication;
import com.webobjects.appserver.WORequest;
import com.webobjects.foundation.NSMutableArray;

import er.extensions.appserver.ERXDirectAction;
import er.extensions.appserver.ERXResponse;

public class DirectAction extends ERXDirectAction {
	public DirectAction(WORequest request) {
		super(request);
	}

	@Override
	public WOActionResults defaultAction() {
		return pageWithName(Main.class.getName());
	}
	
	public Application application() {
		return (Application)WOApplication.application();
	}
	
	@Override
	public Session session() {
		return (Session)super.session();
	}
	
	public WOActionResults updateBeaconDataAction(){
		String beaconData = (String)request().formValueForKey("beacon_data");
		String location = (String)request().formValueForKey("radar_id");
		//System.out.println(location);
		if(StringUtils.isNotBlank(beaconData)){
			BeaconManager.getInstance().updateBeacon(beaconData, location);
		}
		return new ERXResponse("OK", 200);
	}
	
	public WOActionResults adminAction(){
		return pageWithName(AdminPortal.class);
	}
	
	public WOActionResults radarOverviewAction(){
		return pageWithName(RadarOverview.class);
	}
}

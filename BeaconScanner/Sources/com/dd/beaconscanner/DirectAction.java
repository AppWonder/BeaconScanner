package com.dd.beaconscanner;

import com.dd.beaconscanner.components.AssetOverview;
import com.dd.beaconscanner.components.Main;
import com.dd.beaconscanner.components.PersonOverview;
import com.dd.beaconscanner.components.RadarOverview;
import com.dd.beaconscanner.components.editors.AdminPortal;
import com.dd.beaconscanner.metadata.Channel;
import com.dd.beaconscanner.metadata.PersonBeacon;
import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOApplication;
import com.webobjects.appserver.WORequest;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSDictionary;

import er.extensions.appserver.ERXDirectAction;
import er.extensions.appserver.ERXResponse;
import er.extensions.eof.ERXEC;
import er.extensions.foundation.ERXPropertyListSerialization;

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
		BeaconManager.getInstance().updateBeacon(beaconData, location);
		return new ERXResponse("OK", 200);
	}
	
	public WOActionResults adminAction(){
		return pageWithName(AdminPortal.class);
	}
	
	public WOActionResults radarOverviewAction(){
		return pageWithName(RadarOverview.class);
	}
	
	public WOActionResults personOverviewAction(){
		return pageWithName(PersonOverview.class);
	}
	
	public WOActionResults assetOverviewAction(){
		return pageWithName(AssetOverview.class);
	}
	
	public WOActionResults availableChannelsAction(){
		EOEditingContext ec = ERXEC.newEditingContext();
		ec.lock();
		try{
			NSArray<Channel> availableChannels = Channel.fetchAllChannels(ec, Channel.MINOR_CODE.ascs());
			ERXResponse response = new ERXResponse(ERXPropertyListSerialization.jsonStringFromPropertyList(availableChannels.valueForKey(Channel.NAME_KEY)));
			response.setHeader("application/json", "Content-Type");
			return response;
			
		}
		catch(Exception e){
			e.printStackTrace();
			return new ERXResponse(500);
		}
		finally{
			ec.unlock();
		}
	}
	
	public WOActionResults personBeaconMapAction(){
		EOEditingContext ec = ERXEC.newEditingContext();
		ec.lock();
		try{
			NSArray<PersonBeacon> persons = PersonBeacon.fetchAllPersonBeacons(ec);
			NSArray<String> minorCodes = (NSArray<String>)persons.valueForKeyPath("minorCode.toString");
			NSArray<String> info = (NSArray<String>)persons.valueForKeyPath("primaryInformationString");
			ERXResponse response = new ERXResponse(ERXPropertyListSerialization.jsonStringFromPropertyList(new NSDictionary<String,String>(info,minorCodes)));
			response.setHeader("application/json", "Content-Type");
			return response;
		}
		catch(Exception e){
			e.printStackTrace();
			return new ERXResponse(500);
		}
		finally{
			ec.unlock();
		}
		
	}
	
	public WOActionResults personDetailAction(){
		EOEditingContext ec = ERXEC.newEditingContext();
		ec.lock();
		try{
			PersonBeacon person = PersonBeacon.fetchPersonBeacon(ec, PersonBeacon.MINOR_CODE.eq(Integer.valueOf(request().stringFormValueForKey("mic"))));
			StringBuilder sb = new StringBuilder();
			sb.append("{");
			sb.append("\"name\": \""+person.primaryInformationString()+"\",");
			sb.append("\"position\": \""+person.position()+"\",");
 //   "portrait": "doc_8.png",
			sb.append("\"timeInOffice\": \"5 years\",");
			sb.append("\"qualifications\": [");
			sb.append("\"Implantology\",");
			sb.append("\"Obstetrics\",");
			sb.append("\"Naturopathy\",");
			sb.append("\"Acupuncture\",");
			sb.append("\"Sports Medicine\"],");
	       sb.append("\"ratings\": {");
	       sb.append("\"general\": 0.75,");
	       sb.append("\"kindness\": 0.8,");
	       sb.append("\"counseling\": 0.75}}");		
			ERXResponse response = new ERXResponse(sb.toString());
			response.setHeader("application/json", "Content-Type");
			return response;
		}
		catch(Exception e){
			e.printStackTrace();
			return new ERXResponse(500);
		}
		finally{
			ec.unlock();
		}
		}
	

	
}

package com.dd.beaconscanner;

import org.apache.commons.lang.StringUtils;

import com.dd.beaconscanner.metadata.BeaconData;
import com.dd.beaconscanner.metadata.Channel;
import com.dd.beaconscanner.metadata.LocationData;
import com.dd.beaconscanner.metadata.interfaces.BeaconDataItem;
import com.dd.beaconscanner.metadata.volotile.VolatileBeaconData;
import com.dd.beaconscanner.metadata.volotile.VolatileLocationData;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSLock;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSMutableDictionary;

import er.extensions.eof.ERXEC;
import er.extensions.eof.ERXQ;
import er.extensions.foundation.ERXArrayUtilities;

public class BeaconManager {

	private NSMutableArray<Beacon> currentBeacons;
	private NSMutableArray<Location> currentLocations;
	private NSMutableDictionary<String,Beacon> beaconsByUniqueKey;
	private NSDictionary<String,NSArray<Beacon>> beaconLocationMap = NSDictionary.emptyDictionary();
	private NSMutableDictionary<String,Location> locationsByUUID;
	private NSMutableDictionary<String,VolatileBeaconData> beaconMetaDataForUniqueKey;
	private NSMutableDictionary<String,VolatileLocationData> locationMetaDataForUUID;
	private String lastBLEChunk;
	
	private long timeOfLastHealthCheck;
	private static BeaconManager _beaconManager;
	private long updateCount;
	private NSLock lock;
	
	public static BeaconManager getInstance(){
		if(_beaconManager==null){
			_beaconManager = new BeaconManager();
		}
		return _beaconManager;
	}
	
	private BeaconManager(){
		currentBeacons = new NSMutableArray<Beacon>();
		currentLocations = new NSMutableArray<Location>();
		beaconsByUniqueKey = new NSMutableDictionary<String,Beacon>();
		locationsByUUID = new NSMutableDictionary<String, Location>();
		beaconMetaDataForUniqueKey = new NSMutableDictionary<String, VolatileBeaconData>();
		locationMetaDataForUUID = new NSMutableDictionary<String, VolatileLocationData>();
		updateCount = 0;
		lock = new NSLock();
		
	}

	public NSArray<Beacon> currentBeacons() {
		return currentBeacons.immutableClone();
	}


	public static String uniqueKeyForBLEChunk(String[] bleChunks) {
		try{
		StringBuilder sb = new StringBuilder();
		for(int i = 23; i < 39;i++){
			sb.append(bleChunks[i]);
		}
		
		String uuid = sb.toString();
		
		
		
		int	major = Integer.parseInt(bleChunks[39]+bleChunks[40],16);
		int	minor = Integer.parseInt(bleChunks[41]+bleChunks[42],16);
		return uniqueKey(uuid, major, minor);
		/*	
		StringBuilder sb = new StringBuilder();
		for(int i = 23; i < 43;i++){
			sb.append(bleChunks[i]);
		}
		return sb.toString();
		*/}
		catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}
		
	}
	
	public NSDictionary<String,NSArray<Beacon>> beaconLocationMap(){
		return beaconLocationMap;
	}
	
	public void updateBeacon(String beaconData, String locationuuid){
		try{
			lock.tryLock();
			Location location = locationsByUUID.objectForKey(locationuuid);
			if(location==null){
				location = new Location(locationuuid);
				currentLocations.addObject(location);
				locationsByUUID.setObjectForKey(location, locationuuid);
			}
			location.update(null);
			if(StringUtils.isNotBlank(beaconData)){
				lastBLEChunk = beaconData;
			String lines[] = beaconData.split("\\r?\\n");
			for(int i = 0; i<lines.length;i++){
				
				String[] bleChunks = lines[i].split("\\s+");
				String uniqueKey = uniqueKeyForBLEChunk(bleChunks);
				Beacon beacon =  beaconsByUniqueKey.objectForKey(uniqueKey);
				
				
				if(beacon==null){
					beacon = new Beacon(bleChunks);
					beacon.setLocation(locationuuid);
					beaconsByUniqueKey.setObjectForKey(beacon, uniqueKey);
					currentBeacons.addObject(beacon);
				}
				else{
					beacon.updateData(bleChunks, locationuuid);
				}
				
			}
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(lock._isLocked()){
				lock.unlock();
			}
		}
		
		updateState();
		
	}

	public void updateState() {
		updateCount++;
		checkBeaconHealth();
		updateLocationMap();
	}
	
	public void checkBeaconHealth(){
		try{
			lock.tryLock();
		timeOfLastHealthCheck = System.currentTimeMillis();
		for(Beacon currentBeacon : currentBeacons.immutableClone()){
			if(Beacon.HEALTH_STATUS_LOST==currentBeacon.health()){
				currentBeacons.removeObject(currentBeacon);
				beaconsByUniqueKey.remove(currentBeacon.uniqueKey());
			}
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(lock._isLocked()){
				lock.unlock();
			}
		}
	}
	
	public void updateLocationMap(){
		try{
			lock.tryLock();
			beaconLocationMap = ERXArrayUtilities.arrayGroupedByKeyPath(currentBeacons(), Beacon.LOCATION);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(lock._isLocked()){
				lock.unlock();
			}
		}
	}

	public long updateCount(){
		return updateCount;
	}
	
	public VolatileBeaconData beaconMetaDataForBeacon(BeaconItem beacon){
		VolatileBeaconData metaData = beaconMetaDataForUniqueKey.objectForKey(beacon.uniqueKey());

		if(metaData==null){
			EOEditingContext ec = ERXEC.newEditingContext();
			ec.lock();
			try{
			BeaconData beaconData = BeaconData.fetchBeaconData(ec, ERXQ.and(BeaconData.UUID.eq(beacon.uuid()),BeaconData.MAJOR_CODE.eq(beacon.majorCode()),BeaconData.MINOR_CODE.eq(beacon.minorCode())));
				if(beaconData!=null){
					metaData = beaconData.volatileRepresentation();
					beaconMetaDataForUniqueKey.setObjectForKey(metaData, beacon.uniqueKey());
				}
				else{

				}

			}
			catch(Exception e){
				e.printStackTrace();
			}
			finally{
				ec.unlock();
			}
		}
		if(metaData!=null){
		//	System.out.println("metaData.channelBeacons(): "+metaData.channelBeacons());
		}
		else{
		//	System.out.println(":-( "+beacon.minor());
		}
		return metaData;
	}
	
	public VolatileLocationData locationMetaDataForLocation(Location location){
		VolatileLocationData metaData = locationMetaDataForUUID.objectForKey(location.uuid());
		if(metaData==null){


				EOEditingContext ec = ERXEC.newEditingContext();
				ec.lock();
				try {
				LocationData locationData = LocationData.fetchLocationData(ec, LocationData.UUID.eq(location.uuid()));
				if(locationData!=null){
					metaData = locationData.volatileRepresentation();
					locationMetaDataForUUID.setObjectForKey(metaData, location.uuid());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}	
			finally{
				ec.unlock();
			}
			
		}
		return metaData;
	}
	
	public long timeOfLastHealthCheck(){
		return timeOfLastHealthCheck;
	}
	
	public NSArray<Location> locationsWithoutMetaData(){
		NSMutableArray<Location> locationsWithoutMetaData = new NSMutableArray<Location>();
		NSArray<Location> allLocations = currentLocations.immutableClone();
		for(Location location : allLocations){
			if(locationMetaDataForLocation(location)==null){
				locationsWithoutMetaData.addObject(location);
			}
		}
		return locationsWithoutMetaData.immutableClone();
	}
	
	public NSArray<Beacon> beaconsWithoutMetaData(){
		NSMutableArray<Beacon> beaconsWithoutMetaData = new NSMutableArray<Beacon>();
		NSArray<Beacon> allBeacons = currentBeacons();
		for(Beacon beacon : allBeacons){
			if(beaconMetaDataForBeacon(beacon)==null){
				beaconsWithoutMetaData.addObject(beacon);
			}
		}
		return beaconsWithoutMetaData.immutableClone();
	}
	
	public NSDictionary<String,Location> locationsByUUID(){
		return locationsByUUID.immutableClone();
	}
	
	public void resetVolatileMetaData(){
		lock.tryLock();
		try{
			beaconMetaDataForUniqueKey = new NSMutableDictionary<String, VolatileBeaconData>();
			locationMetaDataForUUID = new NSMutableDictionary<String, VolatileLocationData>();
			updateCount++;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			lock.unlock();
		}
	}
	
	public Beacon beaconForBeaconDataItem(BeaconDataItem beacon){
		Beacon aBeacon = ERXQ.and(Beacon.UUID.eq(beacon.uuid()),Beacon.MAJOR.eq(beacon.majorCode()),Beacon.MINOR.eq(beacon.minorCode())).filtered(currentBeacons().immutableClone()).lastObject();
		return aBeacon;
	}
	
	
	public static String uniqueKey(String uuid, Integer majorCode, Integer minorCode){
		return uuid+":"+majorCode+":"+minorCode;
	}
	
	public String lastBeaconData(){
		return lastBLEChunk;
	}
}


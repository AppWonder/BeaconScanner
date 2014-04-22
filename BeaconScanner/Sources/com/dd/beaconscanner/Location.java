package com.dd.beaconscanner;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSTimestamp;


public class Location implements HealthItem {
	private String uuid;
	private String id;
	private String name;
	private NSTimestamp initializationDate;
	private long updateTime;
	private String domain;
	
	
	public Location(String uuid){
		super();
		this.uuid = uuid;
	}
	
	public String uuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String id() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String name() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public NSTimestamp initializationDate() {
		return initializationDate;
	}
	public void setInitializationDate(NSTimestamp initializationDate) {
		this.initializationDate = initializationDate;
	}
	public long updateTime() {
		return updateTime;
	}
	public void setUpdateTime(long updateTime) {
		this.updateTime = updateTime;
	}
	public String domain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	
	public void update(NSDictionary<String,Object> metaData){
		//TODO something with metaData
		updateTime = System.currentTimeMillis();
	}
	
	public int health(){
		int factor = (int)(((updateTime-System.currentTimeMillis())/1000)/6);// (float)((updateTime/1000)+50/(System.currentTimeMillis()/1000));

		int health =  10+factor;
		if(health<=0){
			return HEALTH_STATUS_LOST;
		}
		if(health>10){
			
			return HEALTH_STATUS_BEST;
		}
		return health;
	}
	
}

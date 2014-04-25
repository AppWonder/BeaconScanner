package com.dd.beaconscanner;

import er.extensions.eof.ERXKey;

public class Beacon implements HealthItem, BeaconItem{
	public static final ERXKey<String> LOCATION = new ERXKey<String>("location");
	public static final ERXKey<String> UUID = new ERXKey<String>("uuid");
	public static final ERXKey<Integer> MAJOR = new ERXKey<Integer>("majorCode");
	public static final ERXKey<Integer> MINOR = new ERXKey<Integer>("minorCode");
	public static final ERXKey<Integer> POWER = new ERXKey<Integer>("power");
	public static final ERXKey<Integer> RSSI = new ERXKey<Integer>("rssi");
	public static final ERXKey<String> UNIQUE_KEY = new ERXKey<String>("uniqueKey");
	public static final ERXKey<Long> HEALTH = new ERXKey<Long>("health");

	
	private String uuid;
	private Integer major;
	private Integer minor;
	private Integer power;
	private Integer rssi;
	private String location;
	private long creationTime;
	private long updateTime;
	private String uniqueKey;
	
	public Beacon(String uuid, Integer major, Integer minor, Integer power,
			Integer rssi, String location) {
		super();
		this.uuid = uuid;
		this.major = major;
		this.minor = minor;
		this.power = power;
		this.rssi = rssi;
		this.location = location;
		creationTime = System.currentTimeMillis();
		updateTime = System.currentTimeMillis();
	}
	
	public Beacon(String[] bleChunks){
		creationTime = System.currentTimeMillis();
		updateTime = System.currentTimeMillis();
		StringBuilder sb = new StringBuilder();
		for(int i = 23; i < 39;i++){
			sb.append(bleChunks[i]);
		}
		
		uuid = sb.toString();
		
		
		try{
			major = Integer.parseInt(bleChunks[39]+bleChunks[40],16);
			minor = Integer.parseInt(bleChunks[41]+bleChunks[42],16);
			uniqueKey = BeaconManager.uniqueKey(uuid,major,minor);
			power = Integer.parseInt(bleChunks[43],16)-256;
			rssi = Integer.parseInt(bleChunks[44],16)-256;
		//	uniqueKey = uuid+""+major+""+minor;
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		//System.out.println(toString());
	}
	


	public String uuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public Integer majorCode() {
		return major;
	}
	public void setMajorCode(Integer major) {
		this.major = major;
	}
	public Integer minorCode() {
		return minor;
	}
	public void setMinorCode(Integer minor) {
		this.minor = minor;
	}
	public Integer power() {
		return power;
	}
	public void setPower(Integer power) {
		this.power = power;
	}
	public Integer rssi() {
		return rssi;
	}
	public void setRssi(Integer rssi) {
		this.rssi = rssi;
	}
	public String location() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
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
	
	public void updateData(String[] bleChunks, String location){
		boolean doUpdate = false;
		
		int _power = Integer.parseInt(bleChunks[43],16)-256;
		int _rssi = Integer.parseInt(bleChunks[44],16)-256;
		this.location = location;
		if((health()<HEALTH_STATUS_MEDIUM&&rssi()<_rssi)){
			doUpdate = true;
		}
		else{
			if(location.equals(location())){
				rssi = _rssi;
			}
		}
		
		//	System.out.println(minor()+" doUpdate: "+doUpdate);
		//	System.out.println(minor()+" health: "+health());
			
		if(doUpdate){
			updateTime = System.currentTimeMillis();
			power = _power;
			rssi = _rssi;
			this.location = location;
		}
	}
	
	
	
	@Override
	public String toString() {
		return "uuid:"+uuid()+" major:"+majorCode()+" minor:"+minor+" power:"+power()+" rssi:"+rssi()+" location:"+location();
	}
	
	public String uniqueKey(){
		return uniqueKey;
	}
}

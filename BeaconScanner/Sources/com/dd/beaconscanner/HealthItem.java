package com.dd.beaconscanner;

public interface HealthItem {
	public static final int HEALTH_STATUS_LOST = 0;
	public static final int HEALTH_STATUS_BAD = 3;
	public static final int HEALTH_STATUS_MEDIUM = 6;
	public static final int HEALTH_STATUS_GOOD = 8;
	public static final int HEALTH_STATUS_BEST = 10;
	
	public int health();
}

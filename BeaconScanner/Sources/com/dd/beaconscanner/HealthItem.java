package com.dd.beaconscanner;

import er.extensions.eof.ERXKey;

public interface HealthItem {
	public static final Integer HEALTH_STATUS_LOST = 0;
	public static final Integer HEALTH_STATUS_BAD = 3;
	public static final Integer HEALTH_STATUS_MEDIUM = 6;
	public static final Integer HEALTH_STATUS_GOOD = 8;
	public static final Integer HEALTH_STATUS_BEST = 10;
	public static final ERXKey<Integer> HEALTH = new ERXKey<Integer>("health");
	
	public int health();
}

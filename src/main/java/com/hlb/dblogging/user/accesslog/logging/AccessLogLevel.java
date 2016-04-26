package com.hlb.dblogging.user.accesslog.logging;


public enum AccessLogLevel {
	INFO(0, "INFO"), ERROR(1, "ERROR");
	
	private String level;
	private int levelInt;
	
	private AccessLogLevel(int levelInt, String level) {
		this.level = level;
		this.levelInt = levelInt;
	}
	
	public String getLevel() {
		return level;
	}
	
	public int getLevelInt() {
		return levelInt;
	}

}

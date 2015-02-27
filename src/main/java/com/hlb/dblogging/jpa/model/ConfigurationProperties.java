package com.hlb.dblogging.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ConfigurationProperties")
public class ConfigurationProperties {
	
	
	private int id;
	private String logLevel;
	private String retryPath;
	
	@Id
	@GeneratedValue
	@Column(name="ID", nullable=false, unique=true)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@Column(name="LOGLEVEL", nullable=false)
	public String getLogLevel() {
		return logLevel;
	}

	public void setLogLevel(String logLevel) {
		this.logLevel = logLevel;
	}

	public ConfigurationProperties(int id, String logLevel) {
		super();
		this.id = id;
		this.logLevel = logLevel;
	}

	@Column(name="RETRYPATH", nullable=false)
	public String getRetryPath() {
		return retryPath;
	}

	public void setRetryPath(String retryPath) {
		this.retryPath = retryPath;
	}

	public ConfigurationProperties() {
		super();
	}

	@Override
	public String toString() {
		return "ConfigurationProperties [id=" + id + ", logLevel=" + logLevel
				+ ", retryPath=" + retryPath + "]";
	}

	
	
	
	

}

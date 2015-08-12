package com.hlb.dblogging.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="ConfigurationProperties")
public class ConfigurationProperties {
	
	
	private int id;
	private String logLevel;
	private String retryPath;
	@Lob
	private String viewXslTransformer;
	@Lob
	private String saveXslTransformer;
	
	private boolean viewEnabled;
	private boolean saveEnabled;
	
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

	@Column(name="VIEWXSLTRANSFORMER", nullable=true)
	public String getViewXslTransformer() {
		return viewXslTransformer;
	}

	public void setViewXslTransformer(String viewXslTransformer) {
		this.viewXslTransformer = viewXslTransformer;
	}

	@Column(name="SAVEXSLTRANSFORMER", nullable=true)
	public String getSaveXslTransformer() {
		return saveXslTransformer;
	}

	public void setSaveXslTransformer(String saveXslTransformer) {
		this.saveXslTransformer = saveXslTransformer;
	}

	public ConfigurationProperties() {
		super();
	}
	
	
	@Column(name="viewEnabled", columnDefinition="NUMBER(1)") 
	@Type(type="org.hibernate.type.NumericBooleanType")
	public boolean isViewEnabled() {
		return viewEnabled;
	}

	public void setViewEnabled(boolean viewEnabled) {
		this.viewEnabled = viewEnabled;
	}

	@Column(name="saveEnabled", columnDefinition="NUMBER(1)") 
	@Type(type="org.hibernate.type.NumericBooleanType")
	public boolean isSaveEnabled() {
		return saveEnabled;
	}

	public void setSaveEnabled(boolean saveEnabled) {
		this.saveEnabled = saveEnabled;
	}

	@Override
	public String toString() {
		return "ConfigurationProperties [id=" + id + ", logLevel=" + logLevel
				+ ", retryPath=" + retryPath + "]";
	}

	
	
	
	

}

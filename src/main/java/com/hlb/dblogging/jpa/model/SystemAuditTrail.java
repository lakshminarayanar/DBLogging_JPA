package com.hlb.dblogging.jpa.model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;


@Entity
@Table(name="SystemAuditTrail")
public class SystemAuditTrail implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private Date date;
	private int actorUserId;
	private String actorUsername;
	private String logLevel;
	private String activity;
	private String description;
	private boolean isDeleted = false;
	
	
	@Id
	@GeneratedValue
	@Column(name="id", nullable=false, unique=true)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="actionDate", nullable=false)
	 @Temporal(TemporalType.TIMESTAMP)
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Column(name="actorUserId", nullable=false)
	public int getActorUserId() {
		return actorUserId;
	}
	public void setActorUserId(int actorUserId) {
		this.actorUserId = actorUserId;
	}
	
	@Column(name="actorUsername", nullable=false)
	public String getActorUsername() {
		return actorUsername;
	}
	public void setActorUsername(String actorUsername) {
		this.actorUsername = actorUsername;
	}
	
	@Column(name="logLevel", nullable=false)
	public String getLogLevel() {
		return logLevel;
	}
	public void setLogLevel(String logLevel) {
		this.logLevel = logLevel;
	}
	
	@Column(name="activity", nullable=false)
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	
	@Column(name="description",nullable=false)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name="isDeleted", columnDefinition="NUMBER(1)") 
	@Type(type="org.hibernate.type.NumericBooleanType")
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	

}

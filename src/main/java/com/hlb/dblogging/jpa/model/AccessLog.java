package com.hlb.dblogging.jpa.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

@Entity
@Table(name="accessLog")
public class AccessLog implements Serializable{	

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	private int accessLogId;
	
	
	private Date actionDate;
	
	
	private String level;
	
	
	private String activity;
	
	
	private String description;
	
	
	private int actorUserId;
	
	
	private String actorUsername;
	
	
	private boolean isDeleted = false;   
	   


	public AccessLog(){
    	
    }
	
	@Id
	@GeneratedValue
	@Column(name="accessLogId", nullable=false, unique=true)
	public int getAccessLogId() {
		return accessLogId;
	}
	
	public void setAccessLogId(int accessLogId) {
		this.accessLogId = accessLogId;
	}
	
	
	@Column(name="isDeleted", columnDefinition="NUMBER(1)") 
	@Type(type="org.hibernate.type.NumericBooleanType")
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	
	
	@Column(name="actionDate", nullable=false)
	 @Temporal(TemporalType.TIMESTAMP)
	public Date getActionDate() {
		return actionDate;
	}
	
	public void setActionDate(Date actionDate) {
		this.actionDate = actionDate;
	}
	
	
	
	@Column(name="logLevel", nullable=false)
	public String getLevel() {
		return level;
	}
	
	public void setLevel(String level) {
		this.level = level;
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
	
/*static DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	
	
	public String getFormatedDate(){
		return format.format(actionDate);
	}	*/
	
	
	
	
	public String toString() {
		return "Agents [accessLogId=" + accessLogId + ", actionDate=" + actionDate
				+ ", level=" + level + ", activity="
				+ activity + ", description=" + description + ", actorUserId="
				+ actorUserId + ", actorUsername=" + actorUsername + "," + "]";
	}
	
	
}




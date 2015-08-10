package com.hlb.dblogging.jpa.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="AuditDetail")
public class AuditDetail implements Serializable {
	
	
	/**
	 * 
	 */
	private int id;
	private static final long serialVersionUID = 1L;
	private String UniqueProcessID;
	private String MessageID;
	@Lob
	private String Content;
	private String MessageType;
	private Date CreatedDateTime;
	private Date UpdatedDateTime;
	private long auditMasterId;
	
	@Id
	@GeneratedValue
	@Column(name="ID", nullable=false, unique=true)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="UNIQUEPROCESSID", nullable=false)
	public String getUniqueProcessID() {
		return UniqueProcessID;
	}
	public void setUniqueProcessID(String uniqueProcessID) {
		UniqueProcessID = uniqueProcessID;
	}
	@Column(name="MESSAGEID", nullable=false)
	public String getMessageID() {
		return MessageID;
	}
	public void setMessageID(String messageID) {
		MessageID = messageID;
	}
	@Column(name="CONTENT", nullable=false)
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	@Column(name="MESSAGETYPE", nullable=true)
	public String getMessageType() {
		return MessageType;
	}
	public void setMessageType(String messageType) {
		MessageType = messageType;
	}
	@Column(name="CREATEDDATETIME", nullable=false)
	public Date getCreatedDateTime() {
		return CreatedDateTime;
	}
	public void setCreatedDateTime(Date createdDateTime) {
		CreatedDateTime = createdDateTime;
	}
	@Column(name="UPDATEDDATETIME", nullable=true)
	public Date getUpdatedDateTime() {
		return UpdatedDateTime;
	}
	public void setUpdatedDateTime(Date updatedDateTime) {
		UpdatedDateTime = updatedDateTime;
	}
	
	@Column(name="AUDITMASTERID", nullable=false)	
	public long getAuditMasterId() {
		return auditMasterId;
	}
	public void setAuditMasterId(long auditMasterId) {
		this.auditMasterId = auditMasterId;
	}
	@Override
	public String toString() {
		return "AuditDetail [id=" + id + ", UniqueProcessID=" + UniqueProcessID
				+ ", MessageID=" + MessageID + ", MessageType=" + MessageType + ", CreatedDateTime="
				+ CreatedDateTime + ", UpdatedDateTime=" + UpdatedDateTime
				+ ", auditMasterId=" + auditMasterId + "]";
	}
	

	

}

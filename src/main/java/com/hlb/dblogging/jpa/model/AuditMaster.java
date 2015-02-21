package com.hlb.dblogging.jpa.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="AuditMaster")
public class AuditMaster implements Serializable {
	
	
	/**
	 * 
	 */
	
	private int id;
	private static final long serialVersionUID = 1L;
	private String LogInterface;
	private String MessageFormat;
	private String Host;
	private String TransType;
	private String MessageID;
	private String ServiceID;
	private String ApplName;
	private String AppID;
	private String UniqueProcessID;
	private int JournalSeq;
	private String LogLevel;
	private String StatusCode;
	private String ErrorCode;
	private String ErrorMessage;
	private String ReasonCode;
	private Date TransDateTime;
	private Date UpdatedDateTime;
	private Date CreatedDateTime;
	private String CreatedBy;
	private String UpdatedBy;
	private String CustomString1;
	private String CustomString2;
	private String CustomString3;
	private int CustomInt1;
	private int CustomInt2;
	private int CustomInt3;
	private Date CustomDate1;
	private Date CustomDate2;
	
	@Id
	@GeneratedValue
	@Column(name="ID", nullable=false, unique=true)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="LogInterface", nullable=false)
	public String getLogInterface() {
		return LogInterface;
	}
	public void setLogInterface(String logInterface) {
		LogInterface = logInterface;
	}
	
	@Column(name="MESSAGEFORMAT", nullable=false)
	public String getMessageFormat() {
		return MessageFormat;
	}
	public void setMessageFormat(String messageFormat) {
		MessageFormat = messageFormat;
	}
	
	@Column(name="HOST", nullable=false)
	public String getHost() {
		return Host;
	}
	
	public void setHost(String host) {
		Host = host;
	}
	
	@Column(name="TRANSTYPE", nullable=false)
	public String getTransType() {
		return TransType;
	}
	public void setTransType(String transType) {
		TransType = transType;
	}
	
	@Column(name="MESSAGEID", nullable=false)
	public String getMessageID() {
		return MessageID;
	}
	public void setMessageID(String messageID) {
		MessageID = messageID;
	}
	
	@Column(name="SERVICEID", nullable=false)
	public String getServiceID() {
		return ServiceID;
	}
	public void setServiceID(String serviceID) {
		ServiceID = serviceID;
	}

	@Column(name="APPLNAME", nullable=false)
	public String getApplName() {
		return ApplName;
	}
	public void setApplName(String applName) {
		ApplName = applName;
	}
	
	@Column(name="APPID", nullable=false)
	public String getAppID() {
		return AppID;
	}
	public void setAppID(String appID) {
		AppID = appID;
	}
	
	@Column(name="UNIQUEPROCESSID", nullable=false)
	public String getUniqueProcessID() {
		return UniqueProcessID;
	}
	public void setUniqueProcessID(String uniqueProcessID) {
		UniqueProcessID = uniqueProcessID;
	}
	
	@Column(name="JOURNALSEQ", nullable=false)
	public int getJournalSeq() {
		return JournalSeq;
	}
	public void setJournalSeq(int journalSeq) {
		JournalSeq = journalSeq;
	}
	
	
	@Column(name="LOGLEVEL", nullable=false)
	public String getLogLevel() {
		return LogLevel;
	}
	public void setLogLevel(String logLevel) {
		LogLevel = logLevel;
	}
	@Column(name="STATUSCODE", nullable=false)
	public String getStatusCode() {
		return StatusCode;
	}
	public void setStatusCode(String statusCode) {
		StatusCode = statusCode;
	}
	@Column(name="ERRORCODE", nullable=false)
	public String getErrorCode() {
		return ErrorCode;
	}
	public void setErrorCode(String errorCode) {
		ErrorCode = errorCode;
	}
	@Column(name="ERRORMESSAGE", nullable=false)
	public String getErrorMessage() {
		return ErrorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		ErrorMessage = errorMessage;
	}
	@Column(name="REASONCODE", nullable=false)
	public String getReasonCode() {
		return ReasonCode;
	}
	public void setReasonCode(String reasonCode) {
		ReasonCode = reasonCode;
	}
	@Column(name="TRANSDATETIME", nullable=false)
	public Date getTransDateTime() {
		return TransDateTime;
	}
	public void setTransDateTime(Date transDateTime) {
		TransDateTime = transDateTime;
	}
	@Column(name="UPDATEDDATETIME", nullable=false)
	public Date getUpdatedDateTime() {
		return UpdatedDateTime;
	}
	public void setUpdatedDateTime(Date updatedDateTime) {
		UpdatedDateTime = updatedDateTime;
	}
	@Column(name="CREATEDDATETIME", nullable=false)
	public Date getCreatedDateTime() {
		return CreatedDateTime;
	}
	public void setCreatedDateTime(Date createdDateTime) {
		CreatedDateTime = createdDateTime;
	}
	@Column(name="CREATEDBY", nullable=false)
	public String getCreatedBy() {
		return CreatedBy;
	}
	public void setCreatedBy(String createdBy) {
		CreatedBy = createdBy;
	}
	@Column(name="UPDATEDBY", nullable=false)
	public String getUpdatedBy() {
		return UpdatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		UpdatedBy = updatedBy;
	}
	@Column(name="CUSTOMSTRING1", nullable=false)
	public String getCustomString1() {
		return CustomString1;
	}
	public void setCustomString1(String customString1) {
		CustomString1 = customString1;
	}
	@Column(name="CUSTOMSTRING2", nullable=false)
	public String getCustomString2() {
		return CustomString2;
	}
	public void setCustomString2(String customString2) {
		CustomString2 = customString2;
	}
	@Column(name="CUSTOMSTRING3", nullable=false)
	public String getCustomString3() {
		return CustomString3;
	}
	public void setCustomString3(String customString3) {
		CustomString3 = customString3;
	}
	@Column(name="CUSTOMINT1", nullable=false)
	public int getCustomInt1() {
		return CustomInt1;
	}
	public void setCustomInt1(int customInt1) {
		CustomInt1 = customInt1;
	}
	@Column(name="CUSTOMINT2", nullable=false)
	public int getCustomInt2() {
		return CustomInt2;
	}
	public void setCustomInt2(int customInt2) {
		CustomInt2 = customInt2;
	}
	@Column(name="CUSTOMINT3", nullable=false)
	public int getCustomInt3() {
		return CustomInt3;
	}
	public void setCustomInt3(int customInt3) {
		CustomInt3 = customInt3;
	}
	@Column(name="CUSTOMDATE1", nullable=false)
	public Date getCustomDate1() {
		return CustomDate1;
	}
	public void setCustomDate1(Date customDate1) {
		CustomDate1 = customDate1;
	}
	@Column(name="CUSTOMDATE2", nullable=false)
	public Date getCustomDate2() {
		return CustomDate2;
	}
	public void setCustomDate2(Date customDate2) {
		CustomDate2 = customDate2;
	}
	@Override
	public String toString() {
		return "AuditMaster [id=" + id + ", LogInterface=" + LogInterface
				+ ", MessageFormat=" + MessageFormat + ", Host=" + Host
				+ ", TransType=" + TransType + ", MessageID=" + MessageID
				+ ", ServiceID=" + ServiceID + ", ApplName=" + ApplName
				+ ", AppID=" + AppID + ", UniqueProcessID=" + UniqueProcessID
				+ ", JournalSeq=" + JournalSeq + ", LogLevel=" + LogLevel
				+ ", StatusCode=" + StatusCode + ", ErrorCode=" + ErrorCode
				+ ", ErrorMessage=" + ErrorMessage + ", ReasonCode="
				+ ReasonCode + ", TransDateTime=" + TransDateTime
				+ ", UpdatedDateTime=" + UpdatedDateTime + ", CreatedDateTime="
				+ CreatedDateTime + ", CreatedBy=" + CreatedBy + ", UpdatedBy="
				+ UpdatedBy + ", CustomString1=" + CustomString1
				+ ", CustomString2=" + CustomString2 + ", CustomString3="
				+ CustomString3 + ", CustomInt1=" + CustomInt1
				+ ", CustomInt2=" + CustomInt2 + ", CustomInt3=" + CustomInt3
				+ ", CustomDate1=" + CustomDate1 + ", CustomDate2="
				+ CustomDate2 + "]";
	}
	
}

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


@Entity
@Table(name="AuditMaster")
public class AuditMaster implements Serializable {
	
	
	/**
	 * 
	 */
	
	private long id;
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
	private Date RequestDateTime;
	private String CreatedBy;
	private String UpdatedBy;
	private String Segment;
	private String applicationTransactionId;
	private String CustomString2;
	private String CustomString1;
	private String CustomString3;
	private int CustomInt1;
	private int CustomInt2;
	private int CustomInt3;
	private Date CustomDate1;
	private Date CustomDate2;
	
	@Id
	@GeneratedValue
	@Column(name="ID", nullable=false, unique=true)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Column(name="LogInterface", nullable=true, length=255)
	public String getLogInterface() {
		return LogInterface;
	}
	public void setLogInterface(String logInterface) {
		LogInterface = logInterface;
	}
	
	@Column(name="MESSAGEFORMAT", nullable=false, length=10)
	public String getMessageFormat() {
		return MessageFormat;
	}
	public void setMessageFormat(String messageFormat) {
		MessageFormat = messageFormat;
	}
	
	@Column(name="HOST", nullable=false, length=30)
	public String getHost() {
		return Host;
	}
	
	public void setHost(String host) {
		Host = host;
	}
	
	@Column(name="TRANSTYPE", nullable=false, length=10)
	public String getTransType() {
		return TransType;
	}
	public void setTransType(String transType) {
		TransType = transType;
	}
	
	@Column(name="MESSAGEID", nullable=true, length=50)
	public String getMessageID() {
		return MessageID;
	}
	public void setMessageID(String messageID) {
		MessageID = messageID;
	}
	
	@Column(name="SERVICEID", nullable=true, length=6)
	public String getServiceID() {
		return ServiceID;
	}
	public void setServiceID(String serviceID) {
		ServiceID = serviceID;
	}

	@Column(name="APPLNAME", nullable=true, length=20)
	public String getApplName() {
		return ApplName;
	}
	public void setApplName(String applName) {
		ApplName = applName;
	}
	
	@Column(name="APPID", nullable=false, length=20)
	public String getAppID() {
		return AppID;
	}
	public void setAppID(String appID) {
		AppID = appID;
	}
	
	@Column(name="UNIQUEPROCESSID", nullable=false, length=15)
	public String getUniqueProcessID() {
		return UniqueProcessID;
	}
	public void setUniqueProcessID(String uniqueProcessID) {
		UniqueProcessID = uniqueProcessID;
	}
	
	@Column(name="JOURNALSEQ", nullable=true, length=10)
	public int getJournalSeq() {
		return JournalSeq;
	}
	public void setJournalSeq(int journalSeq) {
		JournalSeq = journalSeq;
	}
	
	
	@Column(name="LOGLEVEL", nullable=false, length=8)
	public String getLogLevel() {
		return LogLevel;
	}
	public void setLogLevel(String logLevel) {
		LogLevel = logLevel;
	}
	@Column(name="STATUSCODE", nullable=true, length=1)
	public String getStatusCode() {
		return StatusCode;
	}
	public void setStatusCode(String statusCode) {
		StatusCode = statusCode;
	}
	@Column(name="ERRORCODE", nullable=true, length=5)
	public String getErrorCode() {
		return ErrorCode;
	}
	public void setErrorCode(String errorCode) {
		ErrorCode = errorCode;
	}
	@Column(name="ERRORMESSAGE", nullable=true, length=250)
	public String getErrorMessage() {
		return ErrorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		ErrorMessage = errorMessage;
	}
	@Column(name="REASONCODE", nullable=true, length=5)
	public String getReasonCode() {
		return ReasonCode;
	}
	public void setReasonCode(String reasonCode) {
		ReasonCode = reasonCode;
	}
	@Column(name="TRANSDATETIME", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getTransDateTime() {
		return TransDateTime;
	}
	public void setTransDateTime(Date transDateTime) {
		TransDateTime = transDateTime;
	}
	@Column(name="UPDATEDDATETIME", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpdatedDateTime() {
		return UpdatedDateTime;
	}
	public void setUpdatedDateTime(Date updatedDateTime) {
		UpdatedDateTime = updatedDateTime;
	}
	@Column(name="CREATEDDATETIME", nullable=true)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreatedDateTime() {
		return CreatedDateTime;
	}
	public void setCreatedDateTime(Date createdDateTime) {
		CreatedDateTime = createdDateTime;
	}
	@Column(name="CREATEDBY", nullable=true, length=50)
	public String getCreatedBy() {
		return CreatedBy;
	}
	public void setCreatedBy(String createdBy) {
		CreatedBy = createdBy;
	}
	@Column(name="UPDATEDBY", nullable=true, length=50)
	public String getUpdatedBy() {
		return UpdatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		UpdatedBy = updatedBy;
	}
	@Column(name="SEGMENT", nullable=false, length=255)
	public String getSegment() {
		return Segment;
	}
	public void setSegment(String segment) {
		Segment = segment;
	}
	
	
	@Column(name="CUSTOMSTRING2", nullable=true, length=50)
	public String getCustomString2() {
		return CustomString2;
	}
	
	public void setCustomString2(String customString2) {
		CustomString2 = customString2;
	}
	@Column(name="CUSTOMSTRING1", nullable=true, length=50)
	public String getCustomString1() {
		return CustomString1;
	}
	public void setCustomString1(String customString1) {
		CustomString1 = customString1;
	}
	@Column(name="CUSTOMINT1", nullable=true, length=20)
	public int getCustomInt1() {
		return CustomInt1;
	}
	public void setCustomInt1(int customInt1) {
		CustomInt1 = customInt1;
	}
	@Column(name="CUSTOMINT2", nullable=true, length=20)
	public int getCustomInt2() {
		return CustomInt2;
	}
	public void setCustomInt2(int customInt2) {
		CustomInt2 = customInt2;
	}
	@Column(name="CUSTOMINT3", nullable=true, length=20)
	public int getCustomInt3() {
		return CustomInt3;
	}
	public void setCustomInt3(int customInt3) {
		CustomInt3 = customInt3;
	}
	@Column(name="CUSTOMDATE1", nullable=true)
	public Date getCustomDate1() {
		return CustomDate1;
	}
	public void setCustomDate1(Date customDate1) {
		CustomDate1 = customDate1;
	}
	@Column(name="CUSTOMDATE2", nullable=true)
	public Date getCustomDate2() {
		return CustomDate2;
	}
	public void setCustomDate2(Date customDate2) {
		CustomDate2 = customDate2;
	}
	@Column(name="REQUESTDATETIME", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getRequestDateTime() {
		return RequestDateTime;
	}
	public void setRequestDateTime(Date requestDateTime) {
		RequestDateTime = requestDateTime;
	}
	@Column(name="APPLTRANSID", nullable=false, length=255)
	public String getApplicationTransactionId() {
		return applicationTransactionId;
	}
	public void setApplicationTransactionId(String applicationTransactionId) {
		this.applicationTransactionId = applicationTransactionId;
	}
	@Column(name="CUSTOMSTRING3", nullable=true, length=50)
	public String getCustomString3() {
		return CustomString3;
	}
	public void setCustomString3(String customString3) {
		CustomString3 = customString3;
	}
	@Override
	public String toString() {
		return "AuditMaster [LogInterface=" + LogInterface + ", MessageFormat="
				+ MessageFormat + ", Host=" + Host + ", TransType=" + TransType
				+ ", MessageID=" + MessageID + ", ServiceID=" + ServiceID
				+ ", ApplName=" + ApplName + ", AppID=" + AppID
				+ ", UniqueProcessID=" + UniqueProcessID + ", JournalSeq="
				+ JournalSeq + ", LogLevel=" + LogLevel + ", StatusCode="
				+ StatusCode + ", ErrorCode=" + ErrorCode + ", ErrorMessage="
				+ ErrorMessage + ", ReasonCode=" + ReasonCode
				+ ", TransDateTime=" + TransDateTime + ", UpdatedDateTime="
				+ UpdatedDateTime + ", CreatedDateTime=" + CreatedDateTime
				+ ", RequestDateTime=" + RequestDateTime + ", CreatedBy="
				+ CreatedBy + ", UpdatedBy=" + UpdatedBy + ", Segment="
				+ Segment + ", applicationTransactionId="
				+ applicationTransactionId + "]";
	}
	
	
	
}

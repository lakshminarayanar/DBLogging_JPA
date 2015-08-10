package com.hlb.dblogging.jpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

@Entity
@Table(name="XSLT")
public class XSLT implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3663999221496214521L;
	private int id;
	private String name;
	private String transType;
	@Lob
	private String xsltFile;
	private String viewOrSave;
	private boolean enabled;
	private boolean deleted;
	private String createdBy;
	private java.util.Date creationTime;
	private String lastModifiedBy;
	private java.util.Date lastModifiedTime;
	
	@Id
	@GeneratedValue
	@Column(name="ID", nullable=false, unique=true)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="NAME", nullable=true)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="TRANSTYPE", nullable=false)
	public String getTransType() {
		return transType;
	}
	public void setTransType(String transType) {
		this.transType = transType;
	}
	@Column(name="XSLTFILE", nullable=false)
	public String getXsltFile() {
		return xsltFile;
	}
	public void setXsltFile(String xsltFile) {
		this.xsltFile = xsltFile;
	}
	@Column(name="VIEWORSAVE", nullable=false)
	public String getViewOrSave() {
		return viewOrSave;
	}
	public void setViewOrSave(String viewOrSave) {
		this.viewOrSave = viewOrSave;
	}
	@Column(name="ENABLED", columnDefinition="NUMBER(1)") 
	@Type(type="org.hibernate.type.NumericBooleanType")
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	@Column(name="deleted", columnDefinition="NUMBER(1)") 
	@Type(type="org.hibernate.type.NumericBooleanType")
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	@Column(name="CREATEDBY", nullable=false)
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	@Column(name="CREATIONTIME",nullable=true)
	@Temporal(TemporalType.TIMESTAMP)
	public java.util.Date getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(java.util.Date creationTime) {
		this.creationTime = creationTime;
	}
	@Column(name="LASTMODIFIEDBY", nullable=true)
	public String getLastModifiedBy() {
		return lastModifiedBy;
	}
	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}
	@Column(name="LASTMODIFIEDTIME",nullable=true)
	@Temporal(TemporalType.TIMESTAMP)
	public java.util.Date getLastModifiedTime() {
		return lastModifiedTime;
	}
	public void setLastModifiedTime(java.util.Date lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}
	
	

}

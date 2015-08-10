package com.hlb.dblogging.jpa.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

@Entity
@Table(name="Users")
public class Users implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String username;
	private String password;
	private String domain;
	private boolean active;
	private boolean deleted;
	private String createdBy;
	private java.util.Date creationTime;
	private String lastModifiedBy;
	private java.util.Date lastModifiedTime;
	private Set<Role> userRoles = new HashSet<Role>();
	
	@Id
	@GeneratedValue
	@Column(name="id", nullable=false, unique=true)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="username", nullable=false,unique=true)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(name="password", nullable=true)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name="active", columnDefinition="NUMBER(1)") 
	@Type(type="org.hibernate.type.NumericBooleanType")
	public boolean isActive() {
		return active;
	}
	public void setCreationTime(java.util.Date creationTime) {
		this.creationTime = creationTime;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public void setLastModifiedTime(java.util.Date lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}
	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}
			
	@Column(name="creationTime",nullable=true)
	@Temporal(TemporalType.TIMESTAMP)
	public java.util.Date getCreationTime() {
		return creationTime;
	}
	@Column(name="createdBy",nullable=true)
	public String getCreatedBy() {
		return createdBy;
	}
	@Column(name="lastModifiedTime",nullable=true)
	@Temporal(TemporalType.TIMESTAMP)
	public java.util.Date getLastModifiedTime() {
		return lastModifiedTime;
	}
	@Column(name="lastModifiedBy",nullable=true)
	public String getLastModifiedBy() {
		return lastModifiedBy;
	}


	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinTable(name = "UserToRole" , joinColumns = { @JoinColumn(name = "userId", referencedColumnName = "id" )},
	inverseJoinColumns=
			{@JoinColumn (name = "userRoleId", referencedColumnName = "id" ) } )
	public Set<Role> getUserRoles() {
		return userRoles;
	}
	
	public void setUserRoles(Set<Role> userRoles) {
		this.userRoles = userRoles;
	}
	@Column(name="domain",nullable=false)
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	
	
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	@Column(name="deleted", columnDefinition="NUMBER(1)") 
	@Type(type="org.hibernate.type.NumericBooleanType")
	public boolean isDeleted() {
		return deleted;
	}
	
	
	
	
}


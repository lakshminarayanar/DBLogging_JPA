package com.hlb.dblogging.jpa.model;

import java.util.Date;

public class SearchBean {
		private String uniqueProcessId;
		private String applicationName;
		private String statusCode;
		private String transactionType;
		private Date transactionDateTime;
		private String Segment;
		
		
		public String getApplicationName() {
			return applicationName;
		}
		public void setApplicationName(String applicationName) {
			this.applicationName = applicationName;
		}
		public String getStatusCode() {
			return statusCode;
		}
		public void setStatusCode(String statusCode) {
			this.statusCode = statusCode;
		}
		public String getTransactionType() {
			return transactionType;
		}
		public void setTransactionType(String transactionType) {
			this.transactionType = transactionType;
		}
		
		public Date getTransactionDateTime() {
			return transactionDateTime;
		}
		public void setTransactionDateTime(Date transactionDateTime) {
			this.transactionDateTime = transactionDateTime;
		}
		public String getUniqueProcessId() {
			return uniqueProcessId;
		}
		public void setUniqueProcessId(String uniqueProcessId) {
			this.uniqueProcessId = uniqueProcessId;
		}
		public String getSegment() {
			return Segment;
		}
		public void setSegment(String segment) {
			Segment = segment;
		}
		@Override
		public String toString() {
			return "SearchBean [uniqueProcessId=" + uniqueProcessId
					+ ", applicationName=" + applicationName + ", statusCode="
					+ statusCode + ", transactionType=" + transactionType
					+ ", transactionDateTime=" + transactionDateTime
					+ ", Segment=" + Segment + "]";
		}
		
		
			
}

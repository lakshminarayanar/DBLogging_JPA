package com.hlb.dblogging.jpa.model;

import java.util.Date;

public class SearchBean {
		private String uniqueProcessId;
		private String applicationName;
		private String transactionType;
		private Date transactionStartDateTime;
		private Date transactionEndDateTime;
		private String Segment;
		
		
		public String getApplicationName() {
			return applicationName;
		}
		public void setApplicationName(String applicationName) {
			this.applicationName = applicationName;
		}
		public String getTransactionType() {
			return transactionType;
		}
		public void setTransactionType(String transactionType) {
			this.transactionType = transactionType;
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
		
		public Date getTransactionStartDateTime() {
			return transactionStartDateTime;
		}
		public void setTransactionStartDateTime(Date transactionStartDateTime) {
			this.transactionStartDateTime = transactionStartDateTime;
		}
		public Date getTransactionEndDateTime() {
			return transactionEndDateTime;
		}
		public void setTransactionEndDateTime(Date transactionEndDateTime) {
			this.transactionEndDateTime = transactionEndDateTime;
		}
		@Override
		public String toString() {
			return "SearchBean [uniqueProcessId=" + uniqueProcessId
					+ ", applicationName=" + applicationName + ", transactionType=" + transactionType
					+ ", transactionStartDateTime=" + transactionStartDateTime
					+ ", transactionEndDateTime=" + transactionEndDateTime
					+ ", Segment=" + Segment + "]";
		}
		
		
		
			
}

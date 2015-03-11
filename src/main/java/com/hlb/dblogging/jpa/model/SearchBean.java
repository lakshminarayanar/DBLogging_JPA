package com.hlb.dblogging.jpa.model;

import java.util.Date;

public class SearchBean {
		private String logInterface;
		private String applicationName;
		private String statusCode;
		private String transactionType;
		private Date transactionDateTime;
		
		public String getLogInterface() {
			return logInterface;
		}
		public void setLogInterface(String logInterface) {
			this.logInterface = logInterface;
		}
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
		

		
		
		@Override
		public String toString() {
			return "SearchBean [logInterface=" + logInterface
					+ ", applicationName=" + applicationName + ", statusCode="
					+ statusCode + ", transactionType=" + transactionType
					+ ", transactionDateTime=" + transactionDateTime + "]";
		}
	
}

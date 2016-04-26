package com.hlb.dblogging.user.accesslog.logging;

public enum AccessLogActivity {
	

	 
		LOGIN("LOGIN"), LOGOUT("LOGOUT"), FAILED("FAILED"), REJECTED("REJECTED");
		
		private String activity;
		private AccessLogActivity(String activity) {
			this.activity = activity;
		}
		
		public String getActivity() {
			return this.activity;
		}
	}



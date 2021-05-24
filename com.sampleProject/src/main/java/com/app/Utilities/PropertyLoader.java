package com.app.Utilities;

import java.util.ResourceBundle;

public class PropertyLoader {
	
	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("config");
	
	public static long getWaitTime() {
		return 6000;
	}
	
	public static String getBrowserType() {
		return RESOURCE_BUNDLE.getString("myBrowser");
	}
	
	public static String getQaUrl() {
		return RESOURCE_BUNDLE.getString("qaUrl");
	}
	
	public static String getStageUrl() {
		return RESOURCE_BUNDLE.getString("stageUrl");
	}
	
	public static String getPreProdUrl() {
		return RESOURCE_BUNDLE.getString("preProdUrl");
	}

}
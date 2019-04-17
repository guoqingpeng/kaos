package com.jiede.template.filter;

import java.util.HashMap;
import java.util.Map;

public class NoNeedToBeCheckedUrls {
	
	
	private static Map<String, Boolean> urls = new HashMap<String, Boolean>();
	
	static {
		 
		 urls.put("/login.do", true);
		 urls.put("toLogin.do", true);
		
	}
	
	/**
	 * 
	 * @param url
	 * @return
	 */
	public static boolean isUrlInNoNeedToBeCheckedUrls(String url) {
		
		if (urls.containsKey(url)) {
			
			return true;
			
		}
		
		return false;
		
	}

}

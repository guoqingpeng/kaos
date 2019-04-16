package com.jiede.sso.sesstion;

import javax.servlet.http.HttpServletRequest;

public class SesstionStore {
	
	public  static final String  unionApplicationToken = "unionApplicationToken";
	
	/**
	 * 
	 * @param request
	 * @param unionApplicationTokenValue
	 */
	public static void setUnionApplicationTokenSession(HttpServletRequest request,String unionApplicationTokenValue){
		
		request.getSession().setAttribute(unionApplicationToken, unionApplicationTokenValue);
		
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public static String getUnionApplicationToken(HttpServletRequest request) {
		
		return (String)request.getSession().getAttribute(unionApplicationToken);
		
	}
	

}

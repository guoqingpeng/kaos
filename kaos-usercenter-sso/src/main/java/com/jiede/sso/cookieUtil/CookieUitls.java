package com.jiede.sso.cookieUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUitls {
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public static String findSesstionKey(HttpServletRequest request) {
		
		String sesstionKey = "SESSION";
		
		Cookie[] cookies = request.getCookies();
		
		if (cookies != null && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				
				String keyName = cookie.getName();
				
				if (!(keyName.toLowerCase().indexOf("session") ==-1)) {
					
					sesstionKey = keyName;
					
					return sesstionKey;
					
				}
				
			}
		}
		
		return sesstionKey;
		
	}
	
	/**
	 * 
	 * @param cookies
	 * @param name
	 * @return
	 */
	public static String getCookie(Cookie[] cookies,String name) {
		
		if (cookies != null && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				
				if (cookie.getName().equals(name)) {
					
					return cookie.getValue();			}
				
			}
		}
		return "";
	}
	
	/**
	 * transform all single domain cookie to parent cookie
	 * @param request
	 * @param response
	 * @param cookie
	 */
	public static void addCookie(HttpServletRequest request,  HttpServletResponse response,Cookie newCookie) {
		
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				
				if (cookie.getName().equals(newCookie.getName())) {
					
					//delete single domain cookie
					cookie.setMaxAge(0);
					
					response.addCookie(cookie);
					
				}
				
			}
		}
		
		
		newCookie.setDomain(".kaku.com");
		
		newCookie.setPath("/");
		
		response.addCookie(newCookie);
		
	}


}

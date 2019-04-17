package com.jiede.template.cookieUtil;

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
		
		String sesstionKey = "";
		
		Cookie[] cookies = request.getCookies();
		
		if (cookies != null && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				
				String keyName = cookie.getName();
				
				if (!(keyName.toLowerCase().indexOf("session") ==-1)) {
					
					sesstionKey = keyName;
					
					return keyName;
					
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
	 * 
	 * @param request
	 * @param response
	 * @param cookie
	 */
	public static void addCookie(HttpServletRequest request,  HttpServletResponse response,Cookie newCookie) {
		
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				
				if (cookie.getName().equals(newCookie.getName())) {
					
					cookie.setDomain(".kaku.com");
					
					cookie.setPath("/");
					
					return;
					
				}
				
			}
		}
		newCookie.setDomain(".kaku.com");
		
		newCookie.setPath("/");
		
		response.addCookie(newCookie);
		
	}

}

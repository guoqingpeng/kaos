package com.jiede.template.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jiede.template.sesstion.SesstionStore;

public class LoginCheckSessionFilter implements  Filter{

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		//
		String url = ((HttpServletRequest) request).getServletPath();
		
		if (NoNeedToBeCheckedUrls.isUrlInNoNeedToBeCheckedUrls(url)) {
			
			System.out.println("sdfsdfsdfdsfsd");
			
			chain.doFilter(request, response);
			
			return;
			
		}
		
		String sessionId = ((HttpServletRequest)request).getSession().getId();
		
		//unionApplicationToken
		String unionApplicationToken = SesstionStore.getUnionApplicationToken((HttpServletRequest)request);
		
		if (unionApplicationToken == null || "".equals(unionApplicationToken)) {
			
			String jumpToUrl  = "http://sso.kaku.com:8080/toLogin.do";
			
			String redirectUrl = "http://kwt.kaku.com:8081/hh.do";
			
			String destinationUrl = jumpToUrl.concat("?").concat("redirectUrl=").concat(redirectUrl);
			
			((HttpServletResponse)response).sendRedirect(destinationUrl);
			
		}else {
			
			chain.doFilter(request, response);
			
		}
		
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		
	}

}

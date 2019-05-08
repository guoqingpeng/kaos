package com.jiede.sso.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.jiede.sso.sesstion.SesstionStore;

public class LoginCheckSessionFilter implements  Filter{

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		//
		String url = ((HttpServletRequest) request).getServletPath();
		
		if (NoNeedToBeCheckedUrls.isUrlInNoNeedToBeCheckedUrls(url)) {
			
			chain.doFilter(request, response);
			
			return;
			
		}
		
		//unionApplicationToken
		String unionApplicationToken = SesstionStore.getUnionApplicationToken((HttpServletRequest)request);
		
		if (unionApplicationToken == null || "".equals(unionApplicationToken)) {
			
			((HttpServletRequest)request).getRequestDispatcher("/toLogin.do?redirectUrl=/demo.do").forward(request, response);
			
		}else {
			
			chain.doFilter(request, response);
			
		}
		
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		
	}

}

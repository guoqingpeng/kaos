package com.jiede.template.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MtFilter implements  Filter{

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain arg2)
			throws IOException, ServletException {
		
		
		System.out.println("i am a filter");
		
		arg2.doFilter(request, response);
		
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		
	}

}

package com.jiede.template.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jiede.template.cookieUtil.CookieUitls;
import com.jiede.template.sesstion.SesstionStore;

@Controller
public class HelloWordController {
	
	@RequestMapping("hh")
	public String hello(HttpSession  session) {
		
		return "login-success";
		
	}
	
	
	
	@RequestMapping("login")
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response) {
		
		return null;
		
	}

}

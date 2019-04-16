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
	
	@ResponseBody
	@RequestMapping("hh")
	public String hello(HttpSession  session) {
		
		session.setAttribute("userId", "dddssd");
		
		return "中文hello kaku where are you we are looking for you";
		
	}
	
	
	
	@RequestMapping("login")
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response) {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("login-success");
		
		
		SesstionStore.setUnionApplicationTokenSession(request, "sssssssssssssggggggggggggggggg");
		
		//
		CookieUitls.addCookie(response, new Cookie(CookieUitls.findSesstionKey(request), request.getSession().getId()));
		
		return mv;
		
	}

}

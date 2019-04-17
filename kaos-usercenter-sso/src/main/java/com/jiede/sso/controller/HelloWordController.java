package com.jiede.sso.controller;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jiede.sso.cookieUtil.CookieUitls;
import com.jiede.sso.sesstion.SesstionStore;

@Controller
public class HelloWordController {
	
	@ResponseBody
	@RequestMapping("hh")
	public String hello(HttpSession  session) {
		
		session.setAttribute("userId", "dddssd");
		
		return "中文hello kaku where are you we are looking for you";
		
	}
	
	@RequestMapping("demo")
	public ModelAndView demo(HttpSession  session) {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("demo");
		
		return mv;
		
	}
	
	@RequestMapping("toLogin")
	public ModelAndView toLogin(HttpServletResponse response,HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView();
		
		String redirectUrl = request.getParameter("redirectUrl");
		
		mv.addObject("redirectUrl",redirectUrl);
		
		String seesionId = ((HttpServletRequest)request).getSession().getId();
		
		mv.setViewName("login");
		
		return mv;
		
	}
	
	@RequestMapping("login")
	public void login(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("login-success");
		
		String redirectUrl = request.getParameter("redirectUrl");
		
		String seesionId = ((HttpServletRequest)request).getSession().getId();
		
		SesstionStore.setUnionApplicationTokenSession(request, "sssssssssssssggggggggggggggggg");
		
		CookieUitls.addCookie(request, response, new Cookie(CookieUitls.findSesstionKey(((HttpServletRequest)request)),seesionId));
		
		response.sendRedirect(redirectUrl);
		
		//return mv;
		
	}

}

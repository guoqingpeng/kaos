package com.jiede.template.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWordController {
	
	@ResponseBody
	@RequestMapping("hh")
	public String hello() {
		
		return "中文hello kaku where are you we are looking for you";
		
	}
	
	@RequestMapping("demo")
	public ModelAndView demo() {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("demo");
		
		return mv;
		
	}

}

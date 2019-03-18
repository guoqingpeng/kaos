package com.jiede.template.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWordController {

	@ResponseBody
	@RequestMapping("hh")
	public String hello() {
		
		return "中文hello kaku where are you we are looking for you";
		
	}
	

}

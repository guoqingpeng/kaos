package com.jiede.template.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jiede.template.dao.UserDao;

@Controller
public class HelloWordController {
	
	public  static Logger logger = Logger.getLogger(HelloWordController.class);
	
	@Autowired 
	UserDao userDao;

	 
	
	@ResponseBody
	@RequestMapping("hh")
	public String  hello(HttpSession  session) throws IOException {
		
		
		return "fsf";
		
	}

}

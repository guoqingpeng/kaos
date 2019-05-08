package com.jiede.template.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.jiede.template.dao.UserDao;
import com.jiede.template.entity.User;

@Controller
public class HelloWordController {
	
	public  static Logger logger = Logger.getLogger(HelloWordController.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired 
	UserDao userDao;

	@ResponseBody
	@RequestMapping("hh")
	public String  hello(HttpSession  session) throws IOException {
		
		String usersql = "select * from user";
		
		List<Map<String, Object>> userList = jdbcTemplate.queryForList(usersql);
		
		List<User> users = userDao.getAllUsers();
		
		for (Map<String, Object> map : userList) {
			
			logger.info(map.get("name"));
			logger.warn(map.get("name"));
			logger.error(map.get("name"));
			
		}
		
		return JSONArray.toJSONString(users);
		
	}

}

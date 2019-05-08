package com.jiede.template.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.jiede.template.entity.User;

@MapperScan
public interface UserDao {
	
	public List<User> getAllUsers();

}

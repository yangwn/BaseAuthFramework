package com.cfilmcloud.auth.base.privilege.extrenal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.privilege.mapper.UserMapper;
import com.base.privilege.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public User getUserByName(String username) {
		return userMapper.getUserByUsername(username);
	}

}

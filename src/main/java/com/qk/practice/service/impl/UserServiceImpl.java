package com.qk.practice.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qk.practice.dao.IUserDao;
import com.qk.practice.model.User;
import com.qk.practice.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Resource
	private IUserDao userDao;
	@Override
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return this.userDao.selectByPrimaryKey(userId);
	}

}

package com.npu.myproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.npu.myproject.dao.UserDao;
import com.npu.myproject.domain.User;

@Service("userservice")
@Transactional(readOnly=false)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userdao;
	public UserServiceImpl(){}
	@Override
	public List<User> selectUsers() {
		List<User> userList=userdao.selectUsers();
		return userList;
	}

	@Override
	public User selectUserById(Integer id) {
		User user=userdao.selectUserById(id);
		return user;
	}
	
	@Override
	public List<User> selectUserByEventId(Integer id) {
		List<User> userList=userdao.selectUserByEventId(id);
		return userList;
	}

	@Override
	public User validateUser(String username,String password) {
		User user=userdao.validateUser(username, password);
		return user;
	}

	@Override
	public void insertUser(User user) {
		userdao.insertUser(user);
	}
	@Override
	public void updateUser(User user) {
		userdao.updateUser(user);
	}

}

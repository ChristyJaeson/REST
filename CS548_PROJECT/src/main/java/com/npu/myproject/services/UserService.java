package com.npu.myproject.services;

import java.util.List;

import com.npu.myproject.domain.User;

public interface UserService {
	public List<User> selectUsers();
	public User selectUserById(Integer id);
	public List<User> selectUserByEventId(Integer id) ;
	public void insertUser(User user);
	public User validateUser(String username,String password);
	public void updateUser(User user);
}

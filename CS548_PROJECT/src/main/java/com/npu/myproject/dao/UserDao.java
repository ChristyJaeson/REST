package com.npu.myproject.dao;

import java.util.List;

import com.npu.myproject.domain.User;

public interface UserDao {
	public List<User> selectUsers();
	public User selectUserById(Integer id);
	public List<User> selectUserByEventId(Integer id) ;
	public User insertUser(User user);
	public User validateUser(String username,String password);
	public void updateUser(User user);

}

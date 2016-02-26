package com.npu.myproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.npu.myproject.dao.UserDao;
import com.npu.myproject.dao.UserEventDao;
import com.npu.myproject.domain.Deal;
import com.npu.myproject.domain.Event;
import com.npu.myproject.domain.User;
import com.npu.myproject.domain.UserEvent;

@Service("usereventservice")
@Transactional(readOnly=false)
public class UserEventServiceImpl implements UserEventService {

	@Autowired
	private UserEventDao userdao;
	public UserEventServiceImpl(){}
	@Override
	public List<User> selectUsersByEvent(Integer id) {
		List<User> userList=userdao.selectUsersByEvent(id);
		return userList;
	}
	@Override
	public List<Event> selectEventsByUser(Integer id) {
		List<Event> eList=userdao.selectEventsByUser(id);
		return eList;
	}
	@Override
	public UserEvent insertUser(UserEvent ue) {
		ue=userdao.insertUser(ue);
		return ue;
	}
	@Override
	public void updateUserEvent(UserEvent ue) {
		userdao.updateUserEvent(ue);
		
	}
	@Override
	public int getDealPercent(int user_id) {
		 return userdao.getDealPercent(user_id);
		
	}
	
}

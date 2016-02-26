package com.npu.myproject.dao;

import java.util.List;

import com.npu.myproject.domain.Deal;
import com.npu.myproject.domain.Event;
import com.npu.myproject.domain.User;
import com.npu.myproject.domain.UserEvent;

public interface UserEventDao {
	public List<User> selectUsersByEvent(Integer id);
	public List<Event> selectEventsByUser(Integer id);
	public UserEvent insertUser(UserEvent ue);
	public void updateUserEvent(UserEvent ue);
	public int getDealPercent(int user_id);

}

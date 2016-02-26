package com.npu.myproject.dao;

import java.util.List;

import com.npu.myproject.domain.Event;

public interface EventDao {
	 List<Event> selectEvents(String eventArea,String location);
	 List<Event> selectEventsByUser(String user_id);
	 Event selectEventById(Integer id);
	 Event selectEventByName(String eventName);
	 public void insertEvent(Event event);
}

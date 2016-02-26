package com.npu.myproject.services;

import java.util.List;

import com.npu.myproject.domain.Event;

public interface EventService {
	 List<Event> selectEvents(String eventArea,String location);
	 List<Event> selectEvents(String user_id);
	 Event selectEventById(Integer id);
	 Event selectEventByName(String eventName);
	 public void insertEvent(Event event);
}

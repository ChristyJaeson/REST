package com.npu.myproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.npu.myproject.dao.EventDao;
import com.npu.myproject.domain.Event;
@Service("eventservice")
@Transactional(readOnly=true)
public class EventServiceImpl implements EventService {

	@Autowired
	private EventDao eventdao;
	public EventServiceImpl(){}
	@Override
	public List<Event> selectEvents(String eventArea, String location) {
		List<Event> eventList=eventdao.selectEvents(eventArea, location);
		System.out.println("Search Service Result" +eventList);
		return eventList;
	}

	@Override
	public Event selectEventById(Integer id) {
		Event event=eventdao.selectEventById(id);
		return event;
	}

	@Override
	public Event selectEventByName(String eventName) {
		Event event=eventdao.selectEventByName(eventName);
		return event;
	}

	@Override
	public void insertEvent(Event event) {
		eventdao.insertEvent(event);
	}
	@Override
	public List<Event> selectEvents(String user_id) {
		//bug fix
		//List<Event> eventList=eventdao.selectEventsbyUserID(user_id);
		//System.out.println("Search Service Result" +eventList);
		//return eventList;
		return null;
	}

}

package com.npu.myproject.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EventList implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// XmlElement sets the name of the entities
	@XmlElement(name = "eventList")
	private List<Event> eventList ;

	public EventList(){}
	public EventList(List<Event> eventList) {
		super();
		this.eventList = eventList;
	}
	public EventList(Event event) {
		super();
		this.eventList = new ArrayList<Event>();
		eventList.add(event);
	}

	public List<Event> getEventList() {
		return eventList;
	}

	public void setEventList(List<Event> eventList) {
		this.eventList = eventList;
	}
	public int numEntries() {
		if (eventList == null) return 0;
		return eventList.size();
	}
	
	public Event getEvent(int idx) {
		return eventList.get(idx);
	}
	
	public String toString() {
		String listStr;
		
		listStr = "eventList{";
		for (Event entry: eventList) {
			listStr = listStr + "\n\t" + entry;
		}
		
		listStr = listStr + "\n}";
		return listStr;
	}
	
}

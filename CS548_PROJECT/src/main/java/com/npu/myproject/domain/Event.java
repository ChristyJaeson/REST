package com.npu.myproject.domain;

import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;
@XmlRootElement(name = "event")
public class Event {
	private int id;
	@NotEmpty
	private String eventName;
	private String eventType;
	@NotEmpty
	private String eventArea;
	private String eventDate;
	private int duration;
	@NotEmpty
	private Location location;
	private Double eventPrice;
	private int eventCapacity;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Event(){}
	public Event(String eventName, String eventType, String eventArea,
			String eventDate, int duration, Location location, Double eventPrice,
			int eventCapacity) {
		super();
		this.eventName = eventName;
		this.eventType = eventType;
		this.eventArea = eventArea;
		this.eventDate = eventDate;
		this.duration = duration;
		this.location = location;
		this.eventPrice = eventPrice;
		this.eventCapacity = eventCapacity;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public String getEventArea() {
		return eventArea;
	}
	public void setEventArea(String eventArea) {
		this.eventArea = eventArea;
	}
	public String getEventDate() {
		return eventDate;
	}
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public Double getEventPrice() {
		return eventPrice;
	}
	public void setEventPrice(Double eventPrice) {
		this.eventPrice = eventPrice;
	}
	public int getEventCapacity() {
		return eventCapacity;
	}
	public void setEventCapacity(int eventCapacity) {
		this.eventCapacity = eventCapacity;
	}
	

}

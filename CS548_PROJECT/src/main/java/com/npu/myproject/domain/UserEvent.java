package com.npu.myproject.domain;

import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;
@XmlRootElement(name = "user")
public class UserEvent {
	
	private int  user_id;
	private int  event_id;
	private int  deal_id;
	
	private int  id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserEvent(){}
	public UserEvent(int user_id, int event_id) {
		super();
		this.user_id = user_id;
		this.event_id = event_id;
	}
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getEvent_id() {
		return event_id;
	}
	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}
	public int getDeal_id() {
		return deal_id;
	}
	public void setDeal_id(int deal_id) {
		this.deal_id = deal_id;
	}
	
}

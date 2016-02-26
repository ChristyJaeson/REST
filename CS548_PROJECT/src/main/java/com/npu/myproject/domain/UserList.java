package com.npu.myproject.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserList implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// XmlElement sets the name of the entities
	@XmlElement(name = "userList")
	private List<User> userList ;

	public List<User> getUserList() {
		return userList;
	}

	public UserList(User user) {
		super();
		this.userList=new ArrayList<User>();
		userList.add(user);
	}
	public UserList() {
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	public int numEntries() {
		if (userList == null) return 0;
		return userList.size();
	}
	
	public User getUser(int idx) {
		return userList.get(idx);
	}
	
	public String toString() {
		String listStr;
		
		listStr = "userList{";
		for (User entry: userList) {
			listStr = listStr + "\n\t" + entry.getFirst_name();
		}
		
		listStr = listStr + "\n}";
		return listStr;
	}
	
}

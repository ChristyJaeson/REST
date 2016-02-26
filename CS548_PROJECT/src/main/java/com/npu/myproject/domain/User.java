package com.npu.myproject.domain;

import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;
@XmlRootElement(name = "user")
public class User {
	private int id;
	@NotEmpty
	private String username;
	private String password;
	private String first_name;
	private String last_name;
	private char gender;
	private String birthdate;
	private String pictture;
	public User(){}
	public User(String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	public User(String username, String password, String first_name,
			String last_name, char gender, String birthdate) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.gender = gender;
		this.birthdate = birthdate;
		this.pictture = pictture;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public String getPictture() {
		return pictture;
	}
	public void setPictture(String pictture) {
		this.pictture = pictture;
	}
	public String toString(){
		String str="User["+id+":"+first_name+","+last_name+"]";
		return str;
	}

}

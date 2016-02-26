package com.npu.myproject.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.npu.myproject.domain.User;

public class UserRowMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet resultset, int rows) throws SQLException {
		
		//username ,password ,first_name ,last_name , gender ,birthdate ,picture 
		String username;
		String password;
		String first_name;
		String last_name;
		char gender;
		String birthdate;
		 
		 User user;
		 
		 username=resultset.getString("username");
		 password=resultset.getString("password");
		 first_name=resultset.getString("first_name");
		 last_name = resultset.getString("last_name");
		 gender=resultset.getString("gender").charAt(0);
		 birthdate=resultset.getString("birthdate");
		 
		  user= new User(username ,password ,first_name ,last_name , gender ,birthdate );	
		  user.setId(resultset.getInt("user_id"));
		  return user;		  		
	}
}

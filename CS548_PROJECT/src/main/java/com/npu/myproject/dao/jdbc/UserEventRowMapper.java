package com.npu.myproject.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.npu.myproject.domain.User;
import com.npu.myproject.domain.UserEvent;

public class UserEventRowMapper implements RowMapper<UserEvent>{
	@Override
	public UserEvent mapRow(ResultSet resultset, int rows) throws SQLException {
		int user_id, event_id, deal_id ;
		 UserEvent userEvent;
		 
		 user_id=resultset.getInt("user_id");
		 event_id=resultset.getInt("event_id");
		 deal_id=resultset.getInt("deal_id");
		 
		 userEvent= new UserEvent(user_id, event_id );	
		 userEvent.setId(resultset.getInt("user_id"));
		  return userEvent;		  		
	}

}

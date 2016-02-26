package com.npu.myproject.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.npu.myproject.domain.Event;
import com.npu.myproject.domain.Location;

public class EventRowMapper implements RowMapper<Event>{

	@Override
	public Event mapRow(ResultSet resultset, int rows) throws SQLException {
		
		
		String eventName;
		String eventType;
		String eventArea;
		String eventDate;
		int duration;
		Location location=null;
		Double eventPrice;
		int eventCapacity;
		 
		 Event event;
		 
		 eventName=resultset.getString("eventName");
		 eventType=resultset.getString("eventType");
		 eventArea=resultset.getString("eventArea");
		 eventDate = resultset.getString("eventDate");
		 duration=resultset.getInt("duration");
		 LocationDaoJdbc temp=new LocationDaoJdbc();
		 System.out.println(resultset.getInt("location_id")+"<<<<<<<<<<<<<");
		 
		 //location=temp.selectById(resultset.getInt("location_id"));
		 eventPrice=resultset.getDouble("eventPrice");
		 eventCapacity=resultset.getInt("eventCapacity");
		 
		  event= new Event( eventName,  eventType,  eventArea,
					 eventDate,  duration,  location,  eventPrice,
					 eventCapacity);	
		  event.setId(resultset.getInt("id"));
		  return event;
		  		
	}
}

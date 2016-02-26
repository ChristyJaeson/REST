package com.npu.myproject.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.npu.myproject.domain.Deal;

public class DealRowMapper implements RowMapper<Deal> {

	@Override
	public Deal mapRow(ResultSet resultset, int rows) throws SQLException {
	
		int id;
		String location_code;
		int price;
		int discount;
		String event;
		String dates;
		String place;
		Deal deal;
		
		id = resultset.getInt("id");
		
		location_code=resultset.getString("location_code");
		price=resultset.getInt("price");
		discount=resultset.getInt("discount");
	    event=resultset.getString("event");
	    dates=resultset.getString("dates");
	    place=resultset.getString("place");
	  
	    deal=new Deal(id,location_code,price,discount,event,dates,place);
	 
	    /*deal.setlocation_code(location_code);
	    deal.setPrice(price);
	    deal.setDiscount(discount);
	    deal.setEvent(event);
	    deal.setDates(dates);
	    deal.setPlace(place);*/
	    
	    return deal;
	    
		
		
		
		
	}
	
	
	

}

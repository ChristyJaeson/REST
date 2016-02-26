package com.npu.myproject.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.npu.myproject.domain.Location;

public class LocationRowMapper implements RowMapper<Location>{

	public Location mapRow(ResultSet resultset, int rows) throws SQLException {
		String name;
		String city;
		String code;
		String country;
		Location location;
		
		name = resultset.getString("name");
		city = resultset.getString("city");
		country=resultset.getString("country");
		code=resultset.getString("code");
		
		location=new Location(name,city,country,code);
		
		location.setName(name);
		location.setCity(city);
		location.setCountry(country);
		location.setCode(code);
		
		return location;
		
	}
	

}

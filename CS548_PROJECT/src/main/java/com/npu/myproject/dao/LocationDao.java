package com.npu.myproject.dao;

import java.util.List;

import com.npu.myproject.domain.Location;

public interface LocationDao {

	 Location selectById(int id);
	 

	  public List<Location> selectAll(Location location);

	  public void insert(Location location);

	  public int updatebyCity(int id,String newcity);

	  public int delete(int id);
	  
	
}

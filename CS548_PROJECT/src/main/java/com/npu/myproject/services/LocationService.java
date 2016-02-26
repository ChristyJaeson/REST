package com.npu.myproject.services;

import java.util.List;

import com.npu.myproject.domain.Location;
import com.npu.myproject.exceptions.LocationNotFound;

public interface LocationService {
	  Location selectById(int id);
		 
  public List<Location> selectAll(Location location);

	 public void insert(Location location);

	  public int updatebyCity(int id,String newcity) throws LocationNotFound;

	  public int delete(int id) throws LocationNotFound;
	  public void addnewLocation(Location location);
	  


}

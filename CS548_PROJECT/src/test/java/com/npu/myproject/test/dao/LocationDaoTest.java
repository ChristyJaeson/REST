package com.npu.myproject.test.dao;
import java.util.List;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.npu.myproject.dao.LocationDao;
import com.npu.myproject.domain.Location;
import com.npu.myproject.exceptions.LocationNotFound;
import com.npu.myproject.services.LocationService;

@ContextConfiguration("classpath:context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class LocationDaoTest {
	@Autowired
	@Qualifier("locationDaoJdbc")
	private LocationDao locationDao;
	@Autowired
	@Qualifier("locationservice")
	private LocationService locationservice;
	
	//Testing to get location by id
	@Test
	public void testSelectbyId(){
		//Form form;
		
		Location location1;
		Location location=new Location("CDG","Charles De Gaulle","Paris", "FR");
		location1=locationDao.selectById(2);
					
	}
	//Testing to get list of location
	@Test
	public void testSelectAll(){
		Location location=new Location("CDG","Charles De Gaulle","Paris", "FR");
		List<Location> locationlist=locationDao.selectAll(location); //selectAll(location);
		
	}
	//testing to insert
	@Test
	public void testinsert(){
		Location location1;
		Location location=new Location("CDG","Charles De Gaulle","Paris", "FR");
		locationDao.insert(location);
		location1=locationDao.selectById(location.getId());
		System.out.println("Data Inserted");
		
			
	}
	//Testing update
	@Test
	public void testUpdate(){
		Location location=new Location("CDG","Charles De Gaulle","Paris", "FR");
		locationDao.updatebyCity(3, "London");
		
		
	}
	
	

}

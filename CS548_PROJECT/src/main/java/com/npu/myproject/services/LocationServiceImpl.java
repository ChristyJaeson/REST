package com.npu.myproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.npu.myproject.dao.DealDao;
import com.npu.myproject.dao.LocationDao;
import com.npu.myproject.domain.Location;
import com.npu.myproject.exceptions.LocationNotFound;
@Service("locationservice")
@Transactional(readOnly=true)

public class LocationServiceImpl implements LocationService {
	@Autowired
	private LocationDao locationDao;
	@Autowired
	private DealDao dealDao;
	
	
    @Transactional(readOnly=false)
	public Location selectById(int id) {
		Location location=locationDao.selectById(id);
		return location;
	}
    
    @Transactional
	public List<Location> selectAll(Location location) {
		List<Location> locationlist=locationDao.selectAll(location);
		return locationlist;
	}
    @Transactional
    public void addnewLocation(Location location){
    	locationDao.insert(location);
    }
	
    @Transactional(readOnly=false)
	public void insert(Location location) {
		locationDao.insert(location);
	}
    @Transactional(readOnly=false, rollbackForClassName="LocationNotFound")
	public int updatebyCity(int id, String newcity)throws LocationNotFound {
    	int rowsaffected;
    	rowsaffected=locationDao.updatebyCity(id, newcity);	
    	if(rowsaffected !=1){
    		throw new LocationNotFound("Unable to update City");
    	}
    	return rowsaffected;
	}
//Transactions done on delete method.
    @Transactional(readOnly=false,rollbackForClassName="LocationNotFound")
	public int delete(int id) throws LocationNotFound {
    	int rowsaffected, rowsaffected1;
    	//delete from deals
    	rowsaffected1 = dealDao.delete(id);
    	rowsaffected=locationDao.delete(4545);
    	if(rowsaffected !=1 || rowsaffected1 != 1){
    		throw new LocationNotFound("Unable to delete");
    	}
    	return rowsaffected;
   	
	}

}

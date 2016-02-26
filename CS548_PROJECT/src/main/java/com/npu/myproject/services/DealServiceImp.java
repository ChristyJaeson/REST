package com.npu.myproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.npu.myproject.dao.DealDao;
import com.npu.myproject.domain.Deal;
import com.npu.myproject.exceptions.DealNotFound;


@Service("dealservice")
@Transactional(readOnly=true)
public class DealServiceImp implements DealService {
	@Autowired
	
	private DealDao dealDao;
	
	public DealServiceImp(){
		System.out.println("instantiated");
	}
	
    @Transactional
	public List<Deal> selectDeals() {
    	
		List<Deal> deallist=dealDao.selectDeals();
		System.out.println("from service: "+deallist);
		return deallist;
	}
    @Transactional
	public List<Deal> selectDealsByType(String str) {
    	
		List<Deal> deallist=dealDao.selectDealsByType(str);
		System.out.println("from service: "+deallist);
		return deallist;
	}
    
    @Transactional(readOnly=false)
	public Deal findDealByDealId(int id) {
		Deal deal=dealDao.findDealById(id);
		return deal;
		
	}
	@Transactional(readOnly=false)
	public void insertDeal(Deal deal) {
		
		dealDao.insertDeal(deal);	
		System.out.println("deal inserted");
	}

	@Transactional(readOnly=false, rollbackForClassName="DealNotFound")
	public int updatebyPlace(int id, String newplace) throws DealNotFound{
		int rowsupdated;
		
		rowsupdated=dealDao.updatebyPlace(id, newplace);
		if(rowsupdated !=1){
			throw new DealNotFound("Unable to update place");
		}
		return rowsupdated;
		}

	@Transactional(readOnly=false, rollbackForClassName="DealNotFound")
	public int delete(int id) throws DealNotFound{
		
		int rowsaffected;
		rowsaffected=dealDao.delete(id);
		if(rowsaffected !=1){
			throw new DealNotFound("Unable to delete");
			
		}
		return rowsaffected;	
	}

}

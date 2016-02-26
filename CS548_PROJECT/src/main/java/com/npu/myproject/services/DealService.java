package com.npu.myproject.services;

import java.util.List;

import com.npu.myproject.domain.Deal;
import com.npu.myproject.exceptions.DealNotFound;

public interface DealService {
	
	List<Deal> selectDeals();
	List<Deal> selectDealsByType(String str);
	 public Deal findDealByDealId(int id);
	  
	  public void  insertDeal(Deal deal);

	  public int updatebyPlace(int id,String newplace) throws DealNotFound;

	  public int delete(int id) throws DealNotFound;

}

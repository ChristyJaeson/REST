package com.npu.myproject.dao;

import java.util.List;

import com.npu.myproject.domain.Deal;

public interface DealDao {
	List<Deal> selectDeals();
	public List<Deal> selectDealsByType(String str) ;
	  
	 public Deal findDealById(int id);
	  
	  public void  insertDeal(Deal deal);

	  public int updatebyPlace(int id,String newplace);

	  public int delete(int id);
	  

}

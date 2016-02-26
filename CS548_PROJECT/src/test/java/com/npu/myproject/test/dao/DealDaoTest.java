package com.npu.myproject.test.dao;
import static org.junit.Assert.*;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.npu.myproject.dao.DealDao;
import com.npu.myproject.domain.Deal;

@ContextConfiguration("classpath:context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class DealDaoTest {
	@Autowired
	@Qualifier("dealDaoJdbc")
	private DealDao dealDao;
	
	
	//Testing to get deal by ID
	@Test
	public void testfindDealbyId(){
		Deal deal1;
		Deal deal=new Deal(3,"CDG", 150, 15, "Cycling", "August 1 to August 6", "Paris");
		deal1=dealDao.findDealById(3);
		//assertEquals(deal,deal1);	
	}
	

	//testing for update by place
	@Test
	public void testupdatebyPlace(){
		Deal deal=new Deal(3,"CDG", 150, 15, "Cycling", "August 1 to August 6", "Paris");
		dealDao.updatebyPlace(4, "Mumbai");			
	}
	
}

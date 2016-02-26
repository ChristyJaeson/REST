package com.npu.myproject.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.npu.myproject.domain.Deal;
import com.npu.myproject.domain.DealList;
import com.npu.myproject.domain.EventList;
import com.npu.myproject.services.DealService;

@Controller
public class DealController {
	@Autowired
	DealService dealservice;
	private static final Logger logger = LoggerFactory.getLogger(DealController.class);
	
		

		//Process the deleted flight operation
		@RequestMapping(value="/findDealform",method= RequestMethod.GET)
		public ModelAndView processDealForm(HttpServletRequest r,HttpSession session){
			ModelAndView modelView;
			List<Deal> dealList22= dealservice.selectDeals();
			DealList dealList=new DealList();
			dealList.setdealList1(dealservice.selectDeals());
			if(session.getAttribute("user")==null)
				modelView= new ModelAndView("findDealProfileSuccess","dealList",dealList);
			else
				modelView= new ModelAndView("displaySelectedDeals","dealList",dealList);
			
			return modelView;
		}
		@RequestMapping(value="/*/booknnn/{name}",method= RequestMethod.POST)
		public ModelAndView book(@PathVariable String name,HttpServletRequest r,HttpSession session){
			ModelAndView modelView;
			List<Deal> dealList_temp= dealservice.selectDealsByType(name);
			DealList dealList=new DealList();
			dealList.setdealList1(dealList_temp);
			System.out.println("---"+dealList.getDeal(0).getEvent());
			modelView= new ModelAndView("displaySelectedDeals","dealList",dealList);
			return modelView;
		}
	

}

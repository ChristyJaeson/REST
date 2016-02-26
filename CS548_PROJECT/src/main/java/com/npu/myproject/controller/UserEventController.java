package com.npu.myproject.controller;

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
import com.npu.myproject.domain.EventList;
import com.npu.myproject.domain.User;
import com.npu.myproject.domain.UserEvent;
import com.npu.myproject.services.UserEventService;
@Controller
public class UserEventController {
	@Autowired
	UserEventService userEventService;


	private static final Logger logger = LoggerFactory.getLogger(UserEventController.class);

	@RequestMapping(value="/checkAvailability/book/{id}", method=RequestMethod.POST)
	public ModelAndView addEvent(@PathVariable int id, HttpServletRequest r,HttpSession session){
		ModelAndView modelView;
		
		User user=(User)session.getAttribute("user");
		UserEvent ue=new UserEvent(user.getId(), id);
		System.out.println("[User:"+ue.getUser_id()+", Event:"+ue.getEvent_id()+"]");
		if(userEventService.insertUser(ue)==null)
			modelView= new ModelAndView("errorMsg");
		else
			modelView= new ModelAndView("statusMsg");
		return modelView;			
	}
	@RequestMapping(value="/viewCart", method=RequestMethod.GET)
	public ModelAndView myEvents( HttpServletRequest r,HttpSession session){
		ModelAndView modelView;		
		User user=(User)session.getAttribute("user");
		EventList eventList=new EventList();
		eventList.setEventList(userEventService.selectEventsByUser(user.getId()));
		modelView= new ModelAndView("viewMyEvents", "eventList", eventList);
		return modelView;			
	}
	@RequestMapping(value="/savings", method=RequestMethod.GET)
	public ModelAndView mySave( HttpServletRequest r,HttpSession session){
		ModelAndView modelView;		
		User user=(User)session.getAttribute("user");
		EventList eventList=new EventList();
		eventList.setEventList(userEventService.selectEventsByUser(user.getId()));
		modelView= new ModelAndView("purchaseOrder", "eventList", eventList);
		int  deal=0;
		deal=userEventService.getDealPercent(user.getId());
		System.out.println("===="+deal);
		modelView.addObject("deal", deal);
		return modelView;			
	}
	@RequestMapping(value="/addDeal/{id}", method=RequestMethod.POST)
	public ModelAndView addDeal(@PathVariable int id, HttpServletRequest r,HttpSession session){
		ModelAndView modelView;		
		User user=(User)session.getAttribute("user");
		UserEvent ue= new UserEvent();
		ue.setUser_id(user.getId());
		ue.setDeal_id(id);
		userEventService.updateUserEvent(ue);
		modelView= new ModelAndView("statusMsg");
		return modelView;			
	}
}

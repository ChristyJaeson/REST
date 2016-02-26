package com.npu.myproject.controller;
import java.util.List;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.npu.myproject.domain.Deal;
import com.npu.myproject.domain.DealList;
import com.npu.myproject.domain.Event;
import com.npu.myproject.domain.EventList;
import com.npu.myproject.domain.User;
import com.npu.myproject.services.EventService;

@Controller
public class EventController {
	@Autowired
	EventService eventservice;


	private static final Logger logger = LoggerFactory.getLogger(EventController.class);


		
		
		@RequestMapping(value="/selecteventform",method= RequestMethod.GET)
		public ModelAndView selectFlighForm(){
			ModelAndView modelView;
			modelView = new ModelAndView("selectEventDataForm");
			modelView.addObject("event", new Event());
			return modelView;
		}
		
		@RequestMapping(value="/processEventInformation", method=RequestMethod.POST)
		public ModelAndView processSelectedEvent(HttpServletRequest r,HttpSession session){
			ModelAndView modelView;
			
			 EventList eventList= new EventList();
			 eventList.setEventList(
					 eventservice.selectEvents(r.getParameter("eventArea"),r.getParameter("location")));
			System.out.println(r.getParameter("eventArea")+r.getParameter("location")+eventList);			
			modelView= new ModelAndView("displaySelectedEvents", "eventList", eventList);
			
			return modelView;			
		}
		@RequestMapping(value="/checkAvailability/{id}",method= RequestMethod.POST)
		public ModelAndView CheckAvailability(@PathVariable int id,HttpServletRequest r,HttpSession session){
			ModelAndView modelView;
			if(null== session.getAttribute("user")){
				modelView = new ModelAndView("signIn");
				modelView.addObject("user", new User());
			}else{
				
				System.out.println("Event ID: "+id);
				EventList eventList= new EventList(eventservice.selectEventById(id));
				System.out.println("id "+eventList.getEvent(0).getEventName());			
				modelView= new ModelAndView("cart", "eventList", eventList);
			}
			return modelView;
		}
		
		@RequestMapping(value="/*/book/{name}",method= RequestMethod.POST)
		public ModelAndView book(@PathVariable int name,HttpServletRequest r,HttpSession session){
			ModelAndView modelView;
			
			//return modelView;
			return null;
		}

		


	}
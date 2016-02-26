package com.npu.myproject.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.npu.myproject.domain.Location;
import com.npu.myproject.services.LocationService;

@Controller
public class LocationController {
	@Autowired
	LocationService locationservice;
	private static final Logger logger = LoggerFactory.getLogger(LocationController.class);
	
	//Location Details:Name,City,Country,Code.
	
	@RequestMapping(value="/addlocationDataForm",method= RequestMethod.GET)
	public ModelAndView LocationDataForm(){
		ModelAndView modelView;
		modelView = new ModelAndView("locationDataForm");
		modelView.addObject("location", new Location());
		return modelView;
	}
	@RequestMapping(value = "/processNewLocationProfile", method = RequestMethod.POST)
	public ModelAndView processNewLocationForm(@Valid Location location, BindingResult result, HttpSession session) 
	{
		ModelAndView modelView;
		
		if (result.hasErrors()) {
			modelView = new ModelAndView("locationDataForm", "location", location);
			return modelView;
		}

		locationservice.addnewLocation(location);
 		modelView = new ModelAndView("newLocationProfileSuccess");
 		session.setAttribute("location",location);
 		modelView.addObject("location",location);
		
		return modelView;
	}


}

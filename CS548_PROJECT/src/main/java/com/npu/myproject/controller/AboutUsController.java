package com.npu.myproject.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class AboutUsController {
	private static final Logger logger = LoggerFactory.getLogger(AboutUsController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 * Point your browser to:  http://localhost:8080/myproject/aboutus
	 */
	@RequestMapping(value = {"/aboutus", "aboutus"}, method = RequestMethod.GET)
	public String aboutUs(Locale locale, Model model)
	{
		logger.info(" About Us! The client locale is {}.", locale);
		return "aboutus";
	}

}

package com.npu.myproject.controller;
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

import com.npu.myproject.domain.EventList;
import com.npu.myproject.domain.Status;
import com.npu.myproject.domain.User;
import com.npu.myproject.domain.UserEvent;
import com.npu.myproject.domain.UserList;
import com.npu.myproject.services.UserEventService;
import com.npu.myproject.services.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userservice;

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	

		@RequestMapping(value="/signIn")
		public ModelAndView signIn(){
			ModelAndView modelView;
			modelView = new ModelAndView("signIn");
			modelView.addObject("user", new User());
			return modelView;
		}
		@RequestMapping(value="/signUp")
		public ModelAndView signUp(){
			ModelAndView modelView;
			modelView = new ModelAndView("signUp");
			modelView.addObject("user", new User());
			return modelView;
		}
		@RequestMapping(value="/newUserInformation")
		public ModelAndView newUser(HttpServletRequest r,HttpSession session){
			ModelAndView modelView;
			User user_new=new User();
			user_new.setFirst_name(r.getParameter("first_name"));
			user_new.setLast_name(r.getParameter("last_name"));
			user_new.setUsername(r.getParameter("username"));
			user_new.setPassword(r.getParameter("password"));
			user_new.setGender(r.getParameter("gender").charAt(0));
			user_new.setBirthdate(r.getParameter("birthdate"));
			user_new.setPictture("nopic");
			userservice.insertUser(user_new);
			session.setAttribute("user", user_new);
			System.out.println("Af"+(User)session.getAttribute("user"));
			
			modelView = new ModelAndView("userHome","userlist",user_new);
			return modelView;		
		}
		@RequestMapping(value="/editProfile")
		public ModelAndView editProfileView(HttpServletRequest r,HttpSession session){
			ModelAndView modelView;
			modelView = new ModelAndView("editProfile");
			modelView.addObject("user", (User)session.getAttribute("user"));
			return modelView;
		}
		
		
		/*@RequestMapping(value="/selectuserform",method= RequestMethod.GET)
		public ModelAndView selectFlighForm(){
			ModelAndView modelView;
			modelView = new ModelAndView("selectEventDataForm");
			modelView.addObject("user", new User());
			return modelView;
		}*/
		
		@RequestMapping(value="/processUserInformation", method=RequestMethod.POST)
		public ModelAndView processSelectedEvent(HttpServletRequest r,HttpSession session){
			ModelAndView modelView;
			User user=userservice.validateUser(
					r.getParameter("username"),r.getParameter("password"));
			System.out.println(user.getFirst_name()+"-"+ user.getId());
			session.setAttribute("user", user);
			User sUser=(User)session.getAttribute("user");
			System.out.println("sess"+sUser.getFirst_name());
			modelView= new ModelAndView("userHome", "userlist", user);
			return modelView;			
		}
		@RequestMapping(value="/saveUserInformation", method=RequestMethod.POST)
		public ModelAndView saveProfile(HttpServletRequest r,HttpSession session){
			ModelAndView modelView;
			User user_new=(User)session.getAttribute("user");
			user_new.setFirst_name(r.getParameter("first_name"));
			user_new.setLast_name(r.getParameter("last_name"));
			user_new.setGender(r.getParameter("gender").charAt(0));
			user_new.setBirthdate(r.getParameter("birthdate"));
			
			System.out.println("b4"+(User)session.getAttribute("user"));
			userservice.updateUser(user_new);
			session.setAttribute("user", user_new);
			System.out.println("Af"+(User)session.getAttribute("user"));
			
			Status status=new Status("Updated Profile.");
			modelView = new ModelAndView("statusMsg","status",status);
			return modelView;			
		}
		@RequestMapping(value="/logout", method=RequestMethod.GET)
		public ModelAndView logout(HttpServletRequest r,HttpSession session){
			ModelAndView modelView;
			session.removeAttribute("user");
			if(null==session.getAttribute("user"));
			System.out.println("SESSION DELETED");
			modelView= new ModelAndView("home");
			return modelView;			
		}
		@RequestMapping(value="/getEventRegisteredUserList", method=RequestMethod.POST)
		public ModelAndView getUsersRegisteredForEvent(HttpServletRequest r,HttpSession session){
			ModelAndView modelView;
			UserList userlist=new UserList();
			userlist.setUserList(userservice.selectUserByEventId(
					Integer.parseInt(r.getParameter("eventID"))));
			System.out.println(userlist.toString());
			
			modelView= new ModelAndView("displayUserDetails", "userlist", userlist);
			return modelView;			
		}
		
	}
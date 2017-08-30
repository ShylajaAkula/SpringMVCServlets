package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.ModelAndView;

import com.pojo.Loginpojo;
import com.service.Loginservice;

@Controller
public class Controllercls {
	
	/*@RequestMapping("login")
	public ModelAndView login(String user,String password,HttpServletRequest req)
	{
		ModelAndView mv=new ModelAndView();
		String nextpage="login.jsp";
		if(user.equals(password))
		{
			nextpage="home.jsp";
		}
		else{
			mv.addObject("message", "Please provide valid username and password");
		}
		mv.setViewName(nextpage);
		return mv;
		*/
		/*public String loginmeth(String user,String password,HttpServletRequest req){
		String nextpage="login.jsp";
		if(user.equals(password)){
			nextpage="home.jsp";
			}
		else
		{
			req.setAttribute("message", "Please provide valid username and password");
		}
		return nextpage;
	}*/
	
	/*@Autowired
	private Loginservice ls;
	*/
	/*@RequestMapping("loginDisplay")
	public String loginDisplay()
	{
		return "login";
	}*/
	
	/*@ExceptionHandler
	public ModelAndView handleException(Exception e){
		return new ModelAndView("login","error","Contact Admin");
	}*/
	@RequestMapping("home")
	public String home()
	{
		return "home";
	}
	/*@RequestMapping("login")
	public String login(Loginpojo lp)
	{
		System.out.println("login");
		String next="home";
		return next;
	}*/

	

}

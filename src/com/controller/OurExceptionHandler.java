package com.controller;

import java.io.FileNotFoundException;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class OurExceptionHandler {
	
	private final Logger LOGGER=Logger.getLogger(getClass());
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception e){
		LOGGER.error(e.getMessage());
		return new ModelAndView("home","error","Error..Contact admin");
		
	}
	
	@ExceptionHandler(HibernateException.class)
	public ModelAndView handleHibernateException(Exception e){
		LOGGER.error(e.getMessage());
		return new ModelAndView("home","error","Error..Contact admin");
		
	}
	
	@ExceptionHandler(FileNotFoundException.class)
	public ModelAndView handleFileNotFoundException(Exception e){
		LOGGER.error(e.getMessage());
		return new ModelAndView("home","error","Error..Contact admin");
		
	}

}
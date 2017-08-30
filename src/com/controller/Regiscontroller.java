package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pojo.GrantedAuthorityImpl;
import com.pojo.UserDetailsImpl;
import com.service.Regisservice;



@Controller
public class Regiscontroller {
	
	@Autowired
	private Regisservice rs;
	
	@RequestMapping("regisHome")
	public String regis(){
		System.out.println("regishome");
		return "regis";
	}
	
	@RequestMapping("registerbody")
	public String regis(UserDetailsImpl userDetails){
		
		System.out.println("Registration body");
		userDetails.setAccountNonExpired(true);
		userDetails.setAccountNonLocked(true);
		userDetails.setCredentialsNonExpired(true);
		userDetails.setEnabled(true);
		
		GrantedAuthorityImpl authr=new GrantedAuthorityImpl();
		authr.setId(1);
		List<GrantedAuthorityImpl> authrs=new ArrayList<GrantedAuthorityImpl>();
		authrs.add(authr);
		
		userDetails.setAuthorities(authrs);
		rs.regis(userDetails);
		return "login";
	}
	
}

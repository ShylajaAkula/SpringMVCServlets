package com.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dao.UserDetailsDao;
import com.pojo.GrantedAuthorityImpl;
import com.pojo.UserDetailsImpl;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserDetailsDao userDao;
	
	public UserDetails loadUserByUsername(String arg0)
			throws UsernameNotFoundException {
		UserDetailsImpl user = userDao.loadUserDetailsByUserName(arg0);
		//System.out.println(user);
		/*UserDetailsImpl userDetails=new UserDetailsImpl();
		userDetails.setAccountNonExpired(true);
		userDetails.setAccountNonLocked(true);
		userDetails.setCredentialsNonExpired(true);
		userDetails.setEnabled(true);
		userDetails.setUsername("user");
		userDetails.setPassword("pwd");
		
		Collection<GrantedAuthorityImpl> authorities=new ArrayList<GrantedAuthorityImpl>();
		GrantedAuthorityImpl au1=new GrantedAuthorityImpl();
		au1.setAuthority("ROLE_ADMIN");
		authorities.add(au1);
		userDetails.setAuthorities(authorities);
		System.out.println("return");
		System.out.println("..."+userDetails.getUsername()+"::"+userDetails.getPassword());
		System.out.println("END");
		return userDetails;*/
		return user;
		
	}

}

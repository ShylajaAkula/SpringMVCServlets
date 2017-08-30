package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.Regisdao;
import com.pojo.UserDetailsImpl;

@Service
public class Regisservice {

	@Autowired
	private Regisdao rd;
	
	@Transactional
	public void regis(UserDetailsImpl userDetails){
		rd.regis(userDetails);
	}
}

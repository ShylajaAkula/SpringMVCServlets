package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.Logindao;
import com.pojo.Loginpojo;

@Service
public class Loginservice {
	
	@Autowired
	private Logindao ld;
	
	@Transactional
	public void login(Loginpojo lp)
	{
		ld.login(lp);
	}

}

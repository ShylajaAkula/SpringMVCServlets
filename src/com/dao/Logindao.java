package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.pojo.Loginpojo;

@Repository
public class Logindao {

	@Autowired
	private HibernateTemplate ht;
	
	public void login(Loginpojo lp)
	{
		ht.save(lp);
	}
}

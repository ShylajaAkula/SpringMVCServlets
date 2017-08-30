package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.pojo.UserDetailsImpl;

@Repository
public class Regisdao {

	@Autowired
	private HibernateTemplate ht;
	
	public void regis(UserDetailsImpl userDetails){
		ht.save(userDetails);
	}
}

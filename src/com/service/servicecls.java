package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.Daocls;
import com.pojo.Studentpojo;

@Service
public class servicecls {

	@Autowired
	private Daocls dao;
	
	@Transactional
	public void save(Studentpojo sp)
	{
		dao.save(sp);
	}
	
	@Transactional
	public void delete(Studentpojo sno){
		dao.delete(sno);
	}
	
	@Transactional
	public void update(Studentpojo sp){
		dao.update(sp);
	}
	
	public List<Studentpojo> getall(){
		return dao.getall();
	}
	
	public Studentpojo get(Integer sno){
			return dao.get(sno);
		}
}

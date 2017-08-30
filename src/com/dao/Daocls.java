package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.pojo.Studentpojo;

@Repository
public class Daocls {
	
	@Autowired
	private HibernateTemplate hb;
	
	public void save(Studentpojo sp){
		hb.save(sp);
	}
	
	public void delete(Studentpojo sno){
		hb.delete(sno);
	}

	public void update(Studentpojo sp){
		hb.update(sp);
	}
	
	public List<Studentpojo> getall(){
		return hb.loadAll(Studentpojo.class);
	}

	public Studentpojo get(Integer sno)
		{
			return hb.get(Studentpojo.class, sno);
		
		}
		
	

}

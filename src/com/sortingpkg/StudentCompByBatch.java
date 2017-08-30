package com.sortingpkg;

import java.util.Comparator;

import com.pojo.Studentpojo;

public class StudentCompByBatch implements Comparator<Studentpojo>{

	public int compare(Studentpojo arg0, Studentpojo arg1) {
		// TODO Auto-generated method stub
		return arg0.getBatch().compareTo(arg1.getBatch());
	}

	
	}



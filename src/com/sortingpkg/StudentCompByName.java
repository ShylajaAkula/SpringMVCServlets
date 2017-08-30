package com.sortingpkg;

import java.util.Comparator;

import com.pojo.Studentpojo;

public class StudentCompByName implements Comparator<Studentpojo>{

	public int compare(Studentpojo arg0, Studentpojo arg1) {
		// TODO Auto-generated method stub
		return arg0.getSname().toUpperCase().compareTo(arg1.getSname().toUpperCase());
	}

}

package com.sortingpkg;

import java.util.Comparator;

import com.pojo.Studentpojo;

public class StudentCompByFamt implements Comparator<Studentpojo> {

	@Override
	public int compare(Studentpojo arg0, Studentpojo arg1) {
		// TODO Auto-generated method stub
		return arg0.getFamt().compareTo(arg1.getFamt());
	}

}

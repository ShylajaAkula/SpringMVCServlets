package com.pojo;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.sortingpkg.StudentCompByBatch;
import com.sortingpkg.StudentCompByFamt;
import com.sortingpkg.StudentCompByName;
import com.sortingpkg.StudentCompBySno;



public class StudentCompUtil{
	
	public static void sort(List<Studentpojo> list,String param){
		Collections.sort(list,getComprator(param));
	}
	
	public static Comparator<Studentpojo> getComprator(String param){
		
		Comparator<Studentpojo> c=null;
		if(param==null) param="sno";
		switch(param){
		
		case "sno":c=new StudentCompBySno();
		            break;
		case "sname":c=new StudentCompByName();
                    break;
		case "batch":c=new StudentCompByBatch();
                    break;
		case "famt":c=new StudentCompByFamt();
                    break;
		}
		return c;
		
	}
}

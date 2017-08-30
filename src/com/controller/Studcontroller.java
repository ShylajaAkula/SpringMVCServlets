package com.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.pojo.StudentCompUtil;
import com.pojo.Studentpojo;
import com.service.servicecls;

@Controller
public class Studcontroller {
	
	@Autowired
	private servicecls sc;
	/*@RequestMapping("homes")
	public String HomePage(){
		return "home.jsp";
	}*/
	
	@RequestMapping("downloadFile")
	public void downloadFile(String fileName,HttpServletResponse res){
		try {
			PrintWriter pw=res.getWriter();
			FileInputStream fis=new FileInputStream("F:\\fileUploads\\"+fileName);
			res.setHeader("Content-Disposition", "download;fileName="+fileName);
			int data=fis.read();
			while(data!=-1){
				pw.print(data);
				data=fis.read();
			}
			fis.close();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@RequestMapping("savestud")
	public String save(Studentpojo sp)
	{
		MultipartFile file=sp.getFile();
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		File targetFile=new File("F:\\fileUploads\\"+file.getOriginalFilename());
		try {
			file.transferTo(targetFile);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("save");
		sc.save(sp);
		return "home";
	}
	
	@RequestMapping("delete")
	public String delete(Studentpojo sno){
		sc.delete(sno);
		return "home";
		
	}
	@Secured("ROLE_ADMIN")
	@RequestMapping("update")
	public String update(Studentpojo sp){
		sc.update(sp);
		return "home";
	}
	
	@RequestMapping("getall")
	public ModelAndView getall(HttpServletRequest req)
	{
		//get current time
		long startTime=System.currentTimeMillis();
		ModelAndView mv=new ModelAndView();
		List<Studentpojo> student=sc.getall();
		String sort=req.getParameter("sort");
		StudentCompUtil.sort(student, sort);
		mv.addObject("stud", student);
		mv.setViewName("home");
		//get current time
		//end-time-starttime
		long endtime=System.currentTimeMillis();
		System.out.println("Time taken to execute getAll is:"+(endtime-startTime));
		return mv;
		
	}
	
	
	@RequestMapping("get")
	public ModelAndView get(Integer sno){
		System.out.println("get");
		ModelAndView mv1=new ModelAndView();
		Studentpojo getstud=sc.get(sno);
		mv1.addObject("getstd", getstud);
		mv1.setViewName("home");
		return mv1;
	}
}

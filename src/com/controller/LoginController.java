package com.controller;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Controller
public class LoginController {
	@RequestMapping("loginDisplay")
	public String loginDisplay() {
		System.out.println("Login Display Controller");
		return "login";

	}

	@RequestMapping("success")
	public String loginSuccess(HttpServletRequest req) {
		List<String> list = (List<String>) req.getServletContext().getAttribute("userlist");
		if (list != null) {
			list = new LinkedList<String>();
			req.getServletContext().setAttribute("userlist", list);
		}
		SecurityContext seccontext = SecurityContextHolder.getContext();
		Authentication auth = seccontext.getAuthentication();
		list.add(getUser());
		System.out.println("home");
		return "redirect:getall.do";
	}

	private String getUser() {
		SecurityContext seccontext = SecurityContextHolder.getContext();
		Authentication auth = seccontext.getAuthentication();
		return auth.getName();

	}
}

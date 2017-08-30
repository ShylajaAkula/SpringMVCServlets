package com.util;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Component;

import com.pojo.UserDetailsImpl;

@Component
public class OurLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {

	private RedirectStrategy redirect = new DefaultRedirectStrategy();

	@Override
	public void onLogoutSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication
				.getPrincipal();

		String username = userDetails.getUsername();
		List<String> userlist = (List<String>) request.getServletContext().getAttribute("userlist");
		userlist.remove(username);
		redirect.sendRedirect(request, response, "/loginDisplay.do");

	}

}

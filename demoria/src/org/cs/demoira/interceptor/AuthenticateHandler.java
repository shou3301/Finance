package org.cs.demoira.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.cs.demoria.model.Person;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthenticateHandler extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler) throws Exception {
		
		HttpSession session = request.getSession();
		Person person = (Person)session.getAttribute("currentUser");
		
		if (person == null) {
			response.sendRedirect("http://127.0.0.1:8080/demoria/login");
			return false;
		}
		else
			return true;
	}
	
}

package com.controllers.student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Student_OnlineTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		System.out.println(request.getParameter("sub_code"));
		session.setAttribute("sub_code", request.getParameter("sub_code"));
		response.sendRedirect("stu_displayPaper.jsp");
    	System.out.println("Controller Called");
	
	}

}

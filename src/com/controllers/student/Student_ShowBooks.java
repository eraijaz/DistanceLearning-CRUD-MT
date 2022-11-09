package com.controllers.student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Student_ShowBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
				
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session= request.getSession();

		if(request.getParameter("sem")!=null)
		{
		session.setAttribute("sem", request.getParameter("sem"));
	
		response.sendRedirect("student_showBooksBySem.jsp");
		}
		else if(request.getParameter("sub_code")!=null)
		{
			session.setAttribute("sub_code",request.getParameter("sub_code") );
			response.sendRedirect("student_showBooksBySubject.jsp");
		}
		
		
		
	}

}

package com.controllers.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class View_Students extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session= request.getSession();
		System.out.println("controller :)");
		if(request.getParameter("course")!=null)
		{
		session.setAttribute("course", request.getParameter("course"));
		response.sendRedirect("admin_view_stu_course11.jsp");
		}	
			
		else if(request.getParameter("batch")!=null)
		{
			session.setAttribute("batch", request.getParameter("batch"));
			response.sendRedirect("admin_view_stu_batch11.jsp");
		}
	}

}

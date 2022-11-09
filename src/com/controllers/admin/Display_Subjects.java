package com.controllers.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Display_Subjects extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

				HttpSession session = request.getSession();
				
				System.out.println("controller");
				
				if(request.getParameter("sem")!=null )
				{
				session.setAttribute("course", request.getParameter("course"));
				session.setAttribute("sem", request.getParameter("sem"));
		
				response.sendRedirect("admin_delete_subject.jsp");
				}
				else
				{
					session.setAttribute("course", request.getParameter("course"));
					response.sendRedirect("admin_view_subject.jsp");
			
			}
	}

}

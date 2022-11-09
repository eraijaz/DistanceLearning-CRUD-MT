package com.controllers.superadmin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.actionbeans.superadmin.SuperAdminActionBean;
import com.beans.BeanClass;

public class Create_NewAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
			PrintWriter out = response.getWriter();
				RequestDispatcher dispatch;
				BeanClass bean = new BeanClass();
				bean.setFirstname(request.getParameter("firstname"));
				bean.setLastname(request.getParameter("lastname"));
				bean.setUsername(request.getParameter("username"));
				bean.setMailid(request.getParameter("mailid"));
				bean.setContact(request.getParameter("contact"));
				
				SuperAdminActionBean action = new SuperAdminActionBean(bean);
			//	boolean result =  action.insert();
				
				if(action.creatAdmin())
				{
					request.setAttribute("username", "ID: "+bean.getUsername());
					request.setAttribute("password","Password: "+bean.getPassword());
					out.print("<h3 align= 'center'> <font color='green'>Administrator created sucessfully. </font></h3>");
					dispatch = request.getRequestDispatcher("new_admin.jsp");
					dispatch.include(request, response);
					
				}
				else
				{
					request.setAttribute("msg", "Administrator Couldn't be created.");
					dispatch = request.getRequestDispatcher("new_admin.jsp");
					dispatch.forward(request, response);
				}
	}

}

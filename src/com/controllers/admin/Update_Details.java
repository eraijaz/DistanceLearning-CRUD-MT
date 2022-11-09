package com.controllers.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.actionbeans.admin.AdminUpdateDetailsActionBean;
import com.beans.BeanClass;

public class Update_Details extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	try{
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession();
		RequestDispatcher dispatch;
	
		BeanClass bean=new BeanClass();
		
		bean.setFirstname(session.getAttribute("firstname").toString());
		bean.setUsername(session.getAttribute("username").toString());
		bean.setContact(request.getParameter("contact"));
		bean.setMailid(request.getParameter("mailid"));
		
		AdminUpdateDetailsActionBean action=new AdminUpdateDetailsActionBean(bean);
		
		boolean result = action.updateRecord();
		
		if(result==true)
		{
			out.print("<h3 align= 'center'> <font color='green'>Updation done Sucessfully...</font></h3>");
			dispatch = request.getRequestDispatcher("adminHome.jsp");
			dispatch.include(request, response);
		}
	    else
		{
	    	request.setAttribute("msg","Updation failed..");
			dispatch = request.getRequestDispatcher("admin_update_details.jsp");
			dispatch.forward(request, response);
		}
	}
	catch(Exception exception)
	{
		exception.printStackTrace();
		}
	}

}

package com.controllers.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.actionbeans.admin.AdminUpdatesActionBean;
import com.beans.BeanClass;


public class Write_Updates extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		RequestDispatcher  dispatch;
		BeanClass bean= new BeanClass();
		
		bean.setEvent_date(request.getParameter("event_date"));
		bean.setNews(request.getParameter("news"));
	
		AdminUpdatesActionBean action = new AdminUpdatesActionBean(bean);
		boolean result  = action.insertUpdates();
		if(result==true)
		{
			request.setAttribute("msg","News Updation done Successfully.");
			dispatch = request.getRequestDispatcher("write_updates.jsp");
			dispatch.forward(request, response);
		}
		else{
			request.setAttribute("msg","News Updation Failed..");
			dispatch = request.getRequestDispatcher("write_updates.jsp");
			dispatch.forward(request, response);
		}	
	}

}

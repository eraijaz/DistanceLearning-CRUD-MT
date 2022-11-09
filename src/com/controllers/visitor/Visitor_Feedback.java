package com.controllers.visitor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.actionbeans.visitor.FeedbackActionBean;
import com.beans.BeanClass;


public class Visitor_Feedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean flag;
		PrintWriter out = response.getWriter();
		RequestDispatcher dispatch;
		
		BeanClass bean = new BeanClass();
		bean.setV_name(request.getParameter("v_name"));
		bean.setV_mailid(request.getParameter("v_mailid"));
		bean.setV_comment(request.getParameter("v_comment"));
		
		FeedbackActionBean action = new FeedbackActionBean(bean);
		
		flag=action.writeFeedback();
		if(flag==true)
		{	out.print("<h3 align= 'center'> <font color='green'>Feedback Updated...Check at Bottom.. </font></h3>");
			dispatch = request.getRequestDispatcher("feedback.jsp");
			dispatch.include(request, response);
		}
		else
		{
			out.print("<h3 align= 'center'> <font color='green'>Feedback Updation Failed... </font></h3>");
			dispatch = request.getRequestDispatcher("feedback.jsp");
			dispatch.include(request, response);
		}
		
	}

}

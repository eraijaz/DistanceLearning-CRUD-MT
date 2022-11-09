package com.controllers.student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.actionbeans.student.StudentUpdateDetailsActionBean;
import com.beans.BeanClass;


public class Student_UpdateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
					try{
						
						PrintWriter out = response.getWriter();
				HttpSession session=request.getSession();
				RequestDispatcher dispatch;
			
				String username = session.getAttribute("username").toString();
				String fname = session.getAttribute("firstname").toString();
				Long reg_no=Long.parseLong(username);
			
				
				BeanClass bean = new BeanClass();
				bean.setContact(request.getParameter("contact"));
				bean.setAddress(request.getParameter("address"));
				bean.setMailid(request.getParameter("mailid"));
				bean.setQuestion(request.getParameter("question"));
				bean.setAnswer(request.getParameter("answer"));
				bean.setReg_no(reg_no);
				bean.setFirstname(fname);
				
				StudentUpdateDetailsActionBean action = new StudentUpdateDetailsActionBean(bean);
				boolean result = action.updateRecord();
				
				if(result==true)
				{
					out.print("<h3 align= 'center'> <font color='green'>Updation done Sucessfully...</font></h3>");
					dispatch = request.getRequestDispatcher("studentHome.jsp");
					dispatch.include(request, response);
				}
    		    else
				{
    		    	request.setAttribute("msg","Updation failed..");
					dispatch = request.getRequestDispatcher("student_UpdateProfile.jsp");
					dispatch.forward(request, response);
				}
					}
					catch(Exception exception)
					{
						exception.printStackTrace();
					}
	
	}
}

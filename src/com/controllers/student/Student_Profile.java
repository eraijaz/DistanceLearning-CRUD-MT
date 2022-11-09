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

public class Student_Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher  dispatch;
		HttpSession session=request.getSession();
		PrintWriter out = response.getWriter();
		
		String reg_no=session.getAttribute("username").toString();
		String fname = session.getAttribute("firstname").toString();
		
		BeanClass bean = new BeanClass();
		bean.setFathername(request.getParameter("fathername"));
		bean.setAddress(request.getParameter("address"));
		bean.setDob(request.getParameter("dob"));
		bean.setQuestion(request.getParameter("question"));
		bean.setAnswer(request.getParameter("answer"));
		bean.setReg_no(Long.parseLong(reg_no));
		bean.setFname(fname);
		
		StudentUpdateDetailsActionBean action = new StudentUpdateDetailsActionBean(bean);
		
		boolean result  = action.profile();
		if(result==true)
		{
			out.print("<h3 align= 'center'> <font color='green'>Detail Registered Sucessfully...</font></h3>");
			dispatch = request.getRequestDispatcher("studentHome.jsp");
			dispatch.include(request, response);
		}
		else{
			request.setAttribute("msg","Details Updation Failed..");
			dispatch = request.getRequestDispatcher("student_Profile.jsp");
			dispatch.forward(request, response);
		}	
		
	}
}


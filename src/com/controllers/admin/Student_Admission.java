package com.controllers.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.actionbeans.admin.StudentAdmissionActionBean;
import com.beans.BeanClass;

public class Student_Admission extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher  dispatch;
		BeanClass student = new BeanClass();
		
		//	student.setReg_no(Long.parseLong(request.getParameter("reg_no")));
		student.setFname(request.getParameter("fname"));
		student.setLname(request.getParameter("lname"));
		student.setGender(request.getParameter("gender"));
		student.setBatch(Integer.parseInt(request.getParameter("batch")));
		student.setCourse(request.getParameter("course"));
		student.setQualification(request.getParameter("qualification"));
		student.setMarks(Float.parseFloat(request.getParameter("marks")));
		student.setContact(request.getParameter("contact"));
		student.setMailid(request.getParameter("mailid"));
		
		StudentAdmissionActionBean action   = new StudentAdmissionActionBean(student);
		
		boolean result  = action.insert();
		if(result==true)
		{
			
			request.setAttribute("msg","Registration successful.");
			request.setAttribute("reg_no", "Registration no. : "+student.getReg_no());
			request.setAttribute("password","Password: "+student.getPassword());
			dispatch = request.getRequestDispatcher("student_admission.jsp");
			dispatch.forward(request, response);
		}
		else{
			request.setAttribute("msg","Registration Failed..");
			dispatch = request.getRequestDispatcher("student_admission.jsp");
			dispatch.forward(request, response);
		}	
		
	}

}

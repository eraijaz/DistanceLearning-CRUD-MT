package com.controllers.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.actionbeans.admin.AdminSubjectsActionBean;
import com.beans.BeanClass;

public class Insert_Subject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		RequestDispatcher  dispatch;
		BeanClass book = new BeanClass();
		
		book.setSub_name(request.getParameter("sub_name"));
		book.setSub_code(request.getParameter("sub_code"));
		book.setPaper_id(request.getParameter("paper_id"));
		book.setCourse(request.getParameter("course"));
		book.setSem(Integer.parseInt(request.getParameter("sem")));
		book.setMax_mrks(Integer.parseInt(request.getParameter("max_mrks")));
		book.setMin_mrks(Integer.parseInt(request.getParameter("min_mrks")));
		
		AdminSubjectsActionBean action = new AdminSubjectsActionBean(book);
		
		boolean result  = action.insertSubject();
		if(result==true)
		{
			request.setAttribute("msg","Insertion successful.");
			dispatch = request.getRequestDispatcher("insert_subject.jsp");
			dispatch.forward(request, response);
		}
		else{
			request.setAttribute("msg","Insertion Failed..");
			dispatch = request.getRequestDispatcher("insert_subject.jsp");
			dispatch.forward(request, response);
		}	
	
	}

}

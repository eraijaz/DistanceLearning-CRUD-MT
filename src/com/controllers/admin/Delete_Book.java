package com.controllers.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.actionbeans.admin.AdminBooksActionBean;
import com.beans.BeanClass;

public class Delete_Book extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		RequestDispatcher dispatch;
		boolean flag=false;
		PrintWriter out = response.getWriter();
		System.out.println("hii welcum");
		String[] values = request.getParameterValues("delete");
		int a= values.length;
		BeanClass bean = new BeanClass();
		
		for(int i=0;i<a;i++)
		{
			bean.setSub_code(values[i]);
		System.out.println("Items selected "+values[i]);
		
		bean.setBook(values[i]);
		AdminBooksActionBean action = new AdminBooksActionBean(bean);
		flag=action.deleteBooks();
	}
		if(flag==true)
		{
			out.print("<h3 align= 'center'> <font color='green'>Deletion Successful... </font></h3>");
			dispatch = request.getRequestDispatcher("admin_delete_book.jsp");
			dispatch.include(request, response);
		}
		else
		{
			out.print("<h3 align= 'center'> <font color='brown'>Deletion Failed... </font></h3>");
			dispatch = request.getRequestDispatcher("admin_delete_book.jsp");
			dispatch.include(request, response);
		}
	}
}

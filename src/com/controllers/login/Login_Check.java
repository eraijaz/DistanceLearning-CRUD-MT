package com.controllers.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.actionbeans.login.LoginActionBean;
import com.beans.BeanClass;

public class Login_Check extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
    	BeanClass login= new BeanClass();
		String user_type = request.getParameter("user_type");
		HttpSession session = request.getSession();
		PrintWriter out=response.getWriter();
		RequestDispatcher dispatch;
		
		try
		{
			
			
			if(user_type.equalsIgnoreCase("admin"))
			{
				login.setUsername(request.getParameter("username"));
				login.setPassword(request.getParameter("password"));
				login.setUser_type(request.getParameter("user_type"));
				LoginActionBean action = new LoginActionBean(login);
				
				if(action.admSearch())
				{
					login = action.getBean();
					session = request.getSession();
					session.setAttribute("username", login.getUsername());
					session.setAttribute("firstname", login.getFirstname());
					session.setAttribute("lastname", login.getLastname());
					session.setAttribute("password", login.getPassword());
					session.setAttribute("usertype", login.getUser_type());
					response.sendRedirect("adminHome.jsp");
				}
				
				else
				{
					request.setAttribute("msg","Login Failed.. Try Again...");
					dispatch = request.getRequestDispatcher("login.jsp");
					dispatch.forward(request, response);
				}
			}
			
			else if(user_type.equalsIgnoreCase("student"))
			{
				login.setUsername(request.getParameter("username"));
				login.setPassword(request.getParameter("password"));
				login.setUser_type(request.getParameter("user_type"));
				LoginActionBean action = new LoginActionBean(login);
				
				if(action.stuSearch())
				{
					login = action.getBean();
					session = request.getSession();
					session.setAttribute("username", login.getUsername());
					session.setAttribute("firstname", login.getFirstname());
					session.setAttribute("lastname", login.getLastname());
					session.setAttribute("password", login.getPassword());
					session.setAttribute("course", login.getCourse());
					session.setAttribute("batch", login.getBatch());
					session.setAttribute("usertype", login.getUser_type());
					response.sendRedirect("studentHome.jsp");
				}
				
				else
				{
					request.setAttribute("msg","Login Failed.. Try Again...");
					dispatch = request.getRequestDispatcher("login.jsp");
					dispatch.forward(request, response);
				}
			}
			
			else if(user_type.equalsIgnoreCase("superadmin"))
			{
				
				if(request.getParameter("username").equalsIgnoreCase("vinod")&&(request.getParameter("password").equalsIgnoreCase("vinod")))
					{
					dispatch = request.getRequestDispatcher("superAdminHome.jsp");
					dispatch.include(request, response);
					}
				else{
					out.print("<h3 align= 'center'> <font color='green'>Login Failed.. Try Again... </font></h3>");
					dispatch = request.getRequestDispatcher("login.jsp");
					dispatch.include(request, response);
				}
				
				
			}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}

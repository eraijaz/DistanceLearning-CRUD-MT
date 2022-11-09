package com.controllers.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.actionbeans.login.ResetPasswordActionBean;
import com.beans.BeanClass;

public class Reset_Password extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private RequestDispatcher dispatch;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			HttpSession session= request.getSession();
			BeanClass bean = new BeanClass();
			String username= session.getAttribute("username").toString();
			bean.setUsername(username);
			
			ResetPasswordActionBean action = new ResetPasswordActionBean(bean);
			bean = action.stuGetAns();
			if(request.getParameter("answer").equalsIgnoreCase(bean.getAnswer()))
			{
				dispatch = request.getRequestDispatcher("stu_reset_pwd.jsp");
				dispatch.forward(request, response);
			}
			else{
				request.setAttribute("msg", "Answer Mismatch..");
				dispatch = request.getRequestDispatcher("stu_get_ans_pwd.jsp");
				dispatch.forward(request, response);
			}
	}

}

package com.controllers.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.actionbeans.admin.AdminQuestionsActionBean;
import com.beans.BeanClass;

public class Add_Questions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		BeanClass bean= new BeanClass();
		RequestDispatcher dispatch;
		bean.setSub_code(request.getParameter("sub_code"));
		bean.setExam_ques(request.getParameter("exam_ques"));
		bean.setAns1(request.getParameter("ans1"));
		bean.setAns2(request.getParameter("ans2"));
		bean.setAns3(request.getParameter("ans3"));
		bean.setAns4(request.getParameter("ans4"));
		bean.setRight_ans(request.getParameter("right_ans"));
		
		AdminQuestionsActionBean action= new AdminQuestionsActionBean(bean);
		boolean flag=action.insertQuestion();
		
			if(flag==true)
			{
				request.setAttribute("msg","Insertion successful.");
				dispatch = request.getRequestDispatcher("addQuestions.jsp");
				dispatch.forward(request, response);
			}
			else
			{
				request.setAttribute("msg","Insertion Failed.");
				dispatch = request.getRequestDispatcher("addQuestions.jsp");
				dispatch.forward(request, response);
			}
		}

}

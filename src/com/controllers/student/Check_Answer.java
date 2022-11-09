package com.controllers.student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.actionbeans.student.StudentOnlineTestActionBean;
import com.beans.BeanClass;

public class Check_Answer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		BeanClass bean=new BeanClass();
		boolean flag;
		PrintWriter out=response.getWriter();
		RequestDispatcher dispatch;
		
	int total_ques= Integer.parseInt(session.getAttribute("total_ques").toString());
	System.out.println("total "+total_ques);
	System.out.println("hii kiran");
	bean.setSub_code(session.getAttribute("sub_code").toString());
	int no_rightans=0;
	int no_wrongans=0;
	int unAttempt_ques=0;
	
	for(int j=1;j<=total_ques;j++)
	{
		if(request.getParameter("ans"+j)!=null)
		{
			System.out.println("if block "+j );
			System.out.println("question"+j+": "+session.getAttribute("ques"+j));
				System.out.println("given ans "+request.getParameter("ans"+j));
				bean.setExam_ques(session.getAttribute("ques"+j).toString());
				bean.setAnswer(request.getParameter("ans"+j));
				StudentOnlineTestActionBean action = new StudentOnlineTestActionBean(bean);
				flag= action.CheckAns();
				if(flag==true)
				{
					no_rightans++;
				}
				else
				{
					no_wrongans++;
			
				}
		}
		else
		{
			System.out.println("else block "+j);
			unAttempt_ques++;
		}
	}
	int attempt_ques=total_ques-unAttempt_ques;
	System.out.println("No. of Right Answers "+no_rightans);
	System.out.println("No. of Wrong Answers "+no_wrongans);
	System.out.println("No. of UnAttempted Answers "+unAttempt_ques);
	session.setAttribute("no_rightans", no_rightans);
	session.setAttribute("no_wrongans", no_wrongans);
	session.setAttribute("attempt_ques", attempt_ques);
	
	int total_marks=total_ques*5;
	int result = (no_rightans*5)-(no_wrongans*2);
	float result_percentage = (result*100)/total_marks;
	session.setAttribute("result_percentage", result_percentage);
	
	bean.setReg_no(Long.parseLong(session.getAttribute("username").toString()));
	bean.setFirstname(session.getAttribute("firstname").toString());
	bean.setLastname(session.getAttribute("lastname").toString());
	bean.setBatch(Integer.parseInt(session.getAttribute("batch").toString()));
	bean.setCourse(session.getAttribute("course").toString());
	bean.setSub_code(session.getAttribute("sub_code").toString());
	bean.setSub_name(session.getAttribute("subject").toString());
	bean.setResult_percentage(result_percentage);
	StudentOnlineTestActionBean action = new StudentOnlineTestActionBean(bean);
	flag =action.saveResult();
	if(flag==true)
	{
	dispatch = request.getRequestDispatcher("student_displayResult.jsp");
	dispatch.include(request, response);
	}
	else
	{
		out.print("<h3 align= 'center'> <font color='green'>Result Couldn't be Saved.. </font></h3>");
		dispatch = request.getRequestDispatcher("student_displayResult.jsp");
		dispatch.include(request, response);
	}
	}

}

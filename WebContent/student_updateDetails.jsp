<%@page import="com.actionbeans.student.StudentUpdateDetailsActionBean"%>
<%@page import="com.beans.BeanClass"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	BeanClass bean=new BeanClass();
		bean.setReg_no(Long.parseLong(session.getAttribute("username").toString()));
		StudentUpdateDetailsActionBean action=new StudentUpdateDetailsActionBean(bean);
		boolean flag= action.getInfo();

		if(flag==true)
		{
	response.sendRedirect("student_Profile.jsp");
		}
		else
		{
	response.sendRedirect("student_updateProfile.jsp");
		}
%>



</body>
</html>
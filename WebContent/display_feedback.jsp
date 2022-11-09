<%@page import="java.sql.ResultSet"%>
<%@page import="com.actionbeans.visitor.FeedbackActionBean"%>
<%@page import="com.controllers.visitor.Visitor_Feedback"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="com.beans.BeanClass"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Vector"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="H:\kiranjeet\OnlineDistanceLearning\images\bg.png">
	<%
		BeanClass bean= new BeanClass();
		FeedbackActionBean action = new FeedbackActionBean(bean);
		ResultSet resultSet;
		resultSet = action.displayFeedback();
		
									
						while(resultSet.next())
						{
	%>
								<center><b>	<%= resultSet.getString(2) %></b><br>
							  				by <b> <%= resultSet.getString(1) %></b> (mail id: <%=resultSet.getString(3) %>)<br><br>
							  				</center>	

					
		<%	
								}
		%>
	</body>
	</html>
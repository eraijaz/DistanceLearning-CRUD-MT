<%@page import="java.sql.ResultSet"%>
<%@page import="com.actionbeans.admin.AdminQuestionsActionBean"%>
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
<jsp:include page="questions.jsp"></jsp:include>
<%
	BeanClass bean=new BeanClass();
bean.setCourse(session.getAttribute("course").toString());
bean.setBatch(Integer.parseInt(session.getAttribute("batch").toString()));
AdminQuestionsActionBean action = new AdminQuestionsActionBean(bean);
ResultSet resultSet = action.viewResults();
%>

<center><h2><font color="darkred" ><b>Results of Students of <%=session.getAttribute("course").toString() %> (<%=session.getAttribute("batch").toString() %>)</b></font></h2></center>
 				<table align="center"  border=1 >
 						<tr>
 						<th align="center">Registration no.</th>
 									<th align="center">First Name</th>
 									<th align="center">Last Name</th>
 									<th align="center">Batch</th>
 									<th align="center">Course</th>
 									<th align="center">Subject Code</th>
 									<th align="center">Subject Name</th>
 									<th align="center">Result (in %age)</th>
 					</tr>

	<%
			while(resultSet.next())
			{
	
	%>
	
				<tr><td><%=resultSet.getLong(1) %></td>
					<td><%=resultSet.getString(2) %></td>
					<td><%=resultSet.getString(3) %></td>
					<td><%=resultSet.getInt(4) %></td>
					<td><%=resultSet.getString(5) %></td>
					<td><%=resultSet.getString(6) %></td>
					<td><%=resultSet.getString(7) %></td>
					<td><%=resultSet.getFloat(8) %></td></tr>
	<%
	} 
	%>
</table>
</body>
</html>
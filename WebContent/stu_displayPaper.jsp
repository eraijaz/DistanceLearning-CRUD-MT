<%@page import="java.sql.ResultSet"%>
<%@page import="com.actionbeans.student.StudentOnlineTestActionBean"%>
<%@page import="com.controllers.student.Student_OnlineTest"%>
<%@page import="com.beans.BeanClass"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Question Paper</title>
</head>
<body background='images/bg03.jpg'>

<form action="Check_Answer" method="post">
		<%
			int i=0;
			String sub_code="";
			String subject="";
			String paper_id="";
			BeanClass bean= new BeanClass();
			ResultSet resultSet=null;
			ResultSet resultSet2=null;
			bean.setSub_code(session.getAttribute("sub_code").toString());
			bean.setCourse(session.getAttribute("course").toString());
			StudentOnlineTestActionBean action = new StudentOnlineTestActionBean(bean);
			resultSet2=action.getPaperId();
			resultSet=action.onlineTest();
			while(resultSet2.next())
			{
				subject=resultSet2.getString(1);
				sub_code=resultSet2.getString(2);
				paper_id=resultSet2.getString(3);
				session.setAttribute("subject", resultSet2.getString(1));
				session.setAttribute("sub_code", resultSet2.getString(2));
				session.setAttribute("paper_id",resultSet2.getString(3));
			}
		%>
		
		 <center><h2><font color="darkred" ><b>Online Test of <%=subject %> (<%=sub_code %>)</b></font><br>
						<%=session.getAttribute("course")%>&nbsp;&nbsp;&nbsp;<%=paper_id %></h2>
			
						</center> 
		
		<%
					while(resultSet.next())
					{
						i++;
					
		%>	<br>
		<table align="left" width="1300">
 				<tr><td colspan="4"> Question <%=i %>: <%=resultSet.getString(2) %></td></tr>
 			<tr>	<td><input type="radio" name="ans<%=i %>" value="<%=resultSet.getString(3)%>"><%=resultSet.getString(3)%></td></tr>
 			<tr>	<td><input type="radio" name="ans<%=i %>" value="<%=resultSet.getString(4)%>"><%=resultSet.getString(4)%></td></tr>
 			<tr>	<td><input type="radio" name="ans<%=i %>" value="<%=resultSet.getString(5)%>"><%=resultSet.getString(5)%></td></tr>
 				<tr><td><input type="radio" name="ans<%=i %>" value="<%=resultSet.getString(6)%>"><%=resultSet.getString(6)%></td></tr>
			</table>
		<%	
			session.setAttribute("ques"+i, resultSet.getString(2));
			}
		
			%><br>
			<table align="center">
			<tr><td colspan="2" align="center"><input type="submit" value="Done"></td></tr>
			</table>
			<%   session.setAttribute("total_ques", i); %>
</form>
</body>
</html>
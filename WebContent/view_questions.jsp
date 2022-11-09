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
<form action="View_Questions" method="post">
<%
	BeanClass bean = new BeanClass();
AdminQuestionsActionBean action = new AdminQuestionsActionBean(bean);
ResultSet resultSet= action.getSubCode();
%>
		<table align="center">
			<tr><th colspan="2"><h2><font color="darkred"><b>View Questions of</b></font></h2></th></tr>
						<tr><td><b>Subject Code : </b></td>
						<td> 
						<select name=sub_code>
								<option>-Select-</option>
								<%
								while(resultSet.next())
								{
								%>
						 <option value="<%=resultSet.getString(2) %>"><%=resultSet.getString(2)%> (<%=resultSet.getString(1)%>)</option>
							  <%  } %>
					</select>	</td></tr>
						<tr><td align ="center" colspan="2"><input type="submit" value="Submit">
					&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="Reset">
				</td>
				</tr>
						
		</table>
		</form>
</body>
</html>
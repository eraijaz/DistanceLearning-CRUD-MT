<%@page import="com.actionbeans.student.StudentShowBooksActionBean"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.beans.BeanClass"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enter Sub Code</title>
</head>
<body>
<jsp:include page="student_showBooks.jsp"></jsp:include><br><br>
<form action = "student_showBooksBySubject.jsp" method="post">
<table align="center">

<%
	BeanClass bean=new BeanClass();
		bean.setCourse(session.getAttribute("course").toString());
		StudentShowBooksActionBean action = new StudentShowBooksActionBean(bean);
		ResultSet resultSet=action.getSubCode();
%>
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
						<tr><td align ="center"><input type="submit" value="Submit">
				</td>
				<td><input type="reset" value="Reset">
				</td>
				</tr>
				
		</table>
</form>

</body>
</html>
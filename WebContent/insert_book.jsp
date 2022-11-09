<%@page import="com.actionbeans.admin.AdminBooksActionBean"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.actionbeans.student.StudentOnlineTestActionBean"%>
<%@page import="com.beans.BeanClass"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Book</title>
</head>
<body>
<jsp:include page="books.jsp"></jsp:include>

		<%
			String msg = "";
				if(request.getAttribute("msg")!=null)
				{
					 msg = request.getAttribute("msg").toString();
				}
				else{
						msg = "";	
				}

				
				BeanClass bean=new BeanClass();
				AdminBooksActionBean action= new AdminBooksActionBean(bean);
				ResultSet resultSet=action.getSubCodefromSubject();
				ResultSet resultSet2=action.getSubCodefromSubject();
		%>

			<form action="Insert_Book" method="post">
				<table align = "center">
				
				  	<tr><th colspan="2"><h2><font color="darkred"><b>Add New Book</b></font></h2></th></tr>
				  	<tr>
						<td colspan=2 align="center"><font color="green"><b><%= msg%> </b></font></td>
					</tr>
						<tr>
						<tr><td><b>Subject Name: </b></td>
						<td> 
						<select name=sub_name>
								<option>-Select-</option>
								<%
								while(resultSet2.next())
								{
									%>
								  <option value="<%=resultSet2.getString(2) %>"><%=resultSet2.getString(2)%> (<%=resultSet2.getString(1)%>)</option>
							  <%  } %>
					</select>	</td></tr>
				
				<tr><td><b>Subject Code : </b></td>
						<td> 
						<select name=sub_code>
								<option>-Select-</option>
								<%
								while(resultSet.next())
								{
								%>
						 <option value="<%=resultSet.getString(1) %>"><%=resultSet.getString(1)%></option>
							  <%  } %>
					</select>	</td></tr>
				
				<tr><td><b>Book Name :</b> </td>
						<td> <input type = "text" name="book" value=""></td></tr>
				<tr><td><b>Author : </b></td>
						<td> <input type = "text" name="author" value=""></td></tr>
				<tr><td><b>Course :</b> </td>
						<td> <select name=course>
							<option>-Select-</option>
							  <option value="B.Tech (ECE)">B.Tech (ECE)</option>
							   <option value="B.Tech (CSE)">B.Tech (CSE)</option>
							    <option value="B.Tech (IT)">B.Tech (IT)</option>
							     <option value="B.Tech (ME)">B.Tech (ME)</option>
							
							  <option value="BCA">BCA</option>
							  <option value="M.Tech (ECE)">M.Tech (ECE)</option>
							  <option value="M.Tech (CSE)">M.Tech (CSE)</option>
							  <option value="M.Tech (IT)">M.Tech (IT)</option>
							  <option value="M.Tech (ME)">M.Tech (ME)</option>
							 
							  <option value="MCA">MCA</option>
							</select> 
						</td></tr>
				
				<tr><td><b>Sem :</b> </td>
					<td> <select name=sem>
							<option>-Select-</option>
							<option value="1">1</option>
							  <option value="2">2</option>
							  <option value="3">3</option>
							  <option value="4">4</option>
							  <option value="5">5</option>
							  <option value="6">6</option>
							  <option value="7">7</option>
							  <option value="8">8</option>
							  </select></td></tr>
				<tr><td><b>Path :</b> </td>
						<td> <input type="file" name="path" value=""></td></tr>
				<tr><td align ="center" colspan="2"><input type="submit" value="Submit">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="Reset">
				</td>
				</tr>
				</table>
				</form>
</body>
</html>
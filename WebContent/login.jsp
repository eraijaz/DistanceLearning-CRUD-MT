<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.io.PrintWriter"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<jsp:include page="empty_page.jsp"></jsp:include>
	<%		String msg = "";
				if(request.getAttribute("msg")!=null)
				{
					 msg = request.getAttribute("msg").toString();
				}
				else
				{
					msg = "";	
				}
		%>
			<form action="Login_Check" target="_parent" method="post">
		
				<table align = "center">
							<tr><th colspan="2"><h2><font color="darkred"><b>Login Here</b></font></h2></th></tr>
						<tr>
							<td colspan=2 align="center"><font color="green"><b><%=msg %></b></font></td>
					</tr>
					
						<tr><td><b>Username :</b></td>
						<td> <input type = "text" name="username" value=""></td></tr>
					<tr><td><b>Password :</b> </td>
						<td> <input type = "password" name="password" value=""></td></tr>
					<tr><td><b>User Type :</b> </td>
						<td> <select name="user_type">
							<option>-Select-</option>
							  <option value="admin">Administrator</option>
							  <option value="student">Student</option>
							  <option value="superadmin">Super Administrator</option>
							</select>
						</td></tr>
					<tr><td align ="right"><input type="submit" value="Submit">
				</td>
				<td><input type="reset" value="Reset">
				</td>
				</tr><tr><td colspan = 2 align="center">  <a href="forget_password.jsp" target="_parent"><b>Forget Password</b></a></td></tr>
			
							</table>
			</form>
</body>
</html>
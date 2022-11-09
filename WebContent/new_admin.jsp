<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Admin</title>
</head>
<body>
<jsp:include page="superAdminHome.jsp"></jsp:include>
		<%		String username = "";
					String password="";
				if(request.getAttribute("username")!=null)
				{
					username=request.getAttribute("username").toString();
					 password = request.getAttribute("password").toString();
				}
				else{
						username="";
						password="";
				}
		%>
		<form action="Create_NewAdmin" method="post">
		<table align = "center">
					<tr><th colspan="2"><h2><font color="darkred"><b>Create New Administrator</b></font></h2></th>
					</tr>
					
					<tr>
							<td colspan=2 align="center"><font color="darkred"><b><%=username %></b></font></td>
					</tr>
					<tr>
							<td colspan=2 align="center"><font color="darkred"><b><%=password %></b></font></td>
					</tr>
				<tr><td><b>First Name :</b> </td>
						<td> <input type = "text" name="firstname" value=""></td></tr>
				<tr><td><b>Last Name :</b> </td>
						<td> <input type = "text" name="lastname" value=""></td></tr>
				<tr><td><b>User Name : </b></td>
						<td> <input type = "text" name="username" value=""></td></tr>
				<tr><td><b>E_mail ID :</b> </td>
						<td> <input type = "text" name="mailid" value=""></td></tr>
				<tr><td><b>Contact No. :</b> </td>
						<td> <input type = "text" name="contact" value=""></td></tr>
						
				<tr><td align ="center" colspan="2"><input type="submit" value="Submit">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="Reset">
				</td>
				</tr>
	</table>
		</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
</head>
<body background='images/bg00.jpg'>
<%
				String msg1="";
				String msg2="";
				String msg="";
				if(request.getAttribute("msg")!=null)
				{
					if(request.getAttribute("msg").toString().equalsIgnoreCase("Wrong Password"))
					{
						 msg1 = request.getAttribute("msg").toString();
						msg2="";
					}
					
					else if(request.getAttribute("msg").toString().equalsIgnoreCase("Password Mismatch"))
					{
						msg1="";
						msg2 = request.getAttribute("msg").toString();
					}
					else
					{
						msg= request.getAttribute("msg").toString();
					}
					
				}
				else
				{
					msg="";
				}


%>

<form action = "Change_password" method = "post">
<table  align="center">
	<tr><td colspan = 2 align="center"> <h2><font color="darkred"><b>Reset Password</b></font></h2></td></tr>
	<tr><td  colspan = 2 align="center"><h2><font color="green"><b><%=msg %></b></font></h2></td></tr>
	<tr> <td><b> Old Password :</b></td>
		<td><input type="text" name = "oldpwd" value=""><%=msg1 %></td></tr>
	<tr><td><b> New Password :</b></td>
		<td><input type="password" name = "newpwd" value=""></td></tr>
	<tr><td><b>Confirm Password :</b></td>
		<td><input type="password" name = "confrmpwd" value=""><%=msg2 %></td></tr>
		
	<tr><td align ="right"><input type="submit" value="Done"></td>
		<td><input type="reset" value= "Reset"></td></tr>
	
</table>

</form>

</body>
</html>
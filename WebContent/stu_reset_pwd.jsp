<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Set New Password</title>
</head>
<body background="H:\kiranjeet\OnlineDistanceLearning\images\bg00.jpg">

<form action = "Set_New_Password" method = "post">
<table  align="center">
	<tr><td colspan = 2 align="center"> <h2><font color="darkred"><b>Change Password</b></font></h2></td></tr>
	<tr><td  colspan = 2 align="center"><h2><font color="green"><b></b></font></h2></td></tr>
		<tr><td><b> New Password :</b></td>
		<td><input type="password" name = "newpwd" value=""></td></tr>
	<tr><td><b>Confirm Password :</b></td>
		<td><input type="password" name = "confrmpwd" value=""></td></tr>
		
	<tr><td align ="right"><input type="submit" value="Done"></td>
		<td><input type="reset" value= "Reset"></td></tr>
	</table></form>
</body>
</html>		

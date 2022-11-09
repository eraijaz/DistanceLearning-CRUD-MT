<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forget Password
</title>
</head>
<body background="H:\kiranjeet\OnlineDistanceLearning\images\bg00.jpg">

		<form action="Forget_Password" method="post" >
		<table align="center">
		<tr><td><b>Reg No./ID :</b></td>
						<td> <input type = "text" name="username" value=""></td></tr>
		<tr><td><b>User Type :</b> </td>
						<td> <select name="user_type" disabled="disabled">
							
							  <option value="student">Student</option>
							</select>
						</td></tr>
		<tr><td align ="right"><input type="submit" value="Submit">
				</td>
				<td><input type="reset" value="Reset">
				</td>
				</tr>
		
		</table>
		</form>


</body>
</html>
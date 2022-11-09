<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Subject</title>
</head>
<body>

		<%		String msg = "";
				if(request.getAttribute("msg")!=null)
				{
					 msg = request.getAttribute("msg").toString();
				}
				else{
						msg = "";	
				}
		%>
				<form action="Delete_Subject" method="post">
				<h3 align="center"><font color="blue">Delete Subject</font></h3>
				<table>
				<tr>		<td colspan=2 align="center"><font color="green"><b><%=msg %></b></font></td>
					</tr>
			
					<tr>
					<td><b>Subject Code :</b> </td>
					<td><input type="text" name="sub_code" value=""></td></tr> 
				
					<tr><td align ="right"><input type="submit" value="Delete">
								</td>
								<td><input type="reset" value="Reset">
								</td>
								</tr>
				</table>
				</form>
</body>
</html>
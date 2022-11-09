<%@page import="com.actionbeans.admin.AdminUpdateDetailsActionBean"%>
<%@page import="com.beans.BeanClass"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
<jsp:include page="adminMenu.jsp"></jsp:include>
<%
	String msg = "";
	if(request.getAttribute("msg")!=null)
	{
		 msg = request.getAttribute("msg").toString();
	}
	else{
	msg = "";	
	}
		BeanClass bean = new BeanClass();
		bean.setFirstname(session.getAttribute("firstname").toString());
		bean.setUsername(session.getAttribute("username").toString());
		
		AdminUpdateDetailsActionBean action = new AdminUpdateDetailsActionBean(bean);
		
		bean= action.displayRecord();
%>

	<form action="Update_Details" method="post">
	
		<table align="center">
					<tr><th colspan="2" align = "center"><h2><font color="darkred" ><b>Update Details</b></font></h2></th></tr>
					<tr>
							<td colspan=2 align="center"><font color="green"><b><%=msg %></b></font></td>
					</tr>
					<tr>
							<td><b>First Name :</b> </td><td><input type="text" disabled="disabled" name="fname" value="<%=bean.getFirstname()%>"></td>
					</tr>
					<tr>
							<td><b>Last Name :</b> </td><td><input type="text" disabled="disabled" name="lname" value="<%=bean.getLastname()%>"></td>
					</tr>
					<tr>
							<td><b>User Name :</b> </td><td><input type="text" disabled="disabled" name="username" value="<%=bean.getUsername()%>"></td>
					</tr>
					<tr>
							<td><b>Mail ID :</b> </td><td><input type="text"  name="mailid" value="<%=bean.getMailid()%>"></td>
					</tr>
					<tr>
							<td><b>Contact No. :</b> </td><td><input type="text" name="contact" value="<%=bean.getContact()%>"></td>
					</tr>
					<tr>
								<td align="right"><input type="submit" value="Update"></td><td> <input type="reset" value="Reset"></td>
				</tr>
				</table>			
	
	</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Home</title>
</head>
<body background='images/bg00.jpg'>

			<% 
				String fname="";
				String lname="";
				if(session.getAttribute("firstname")!=null && session.getAttribute("lastname")!=null)
				{
					 fname = session.getAttribute("firstname").toString();
					 lname = session.getAttribute("lastname").toString();
			}
				else{
					fname="";
					lname="";
				}
			
			%>	
		<center>	<h2><font color="darkred"> WELCOME ADMIN &nbsp;&nbsp;&nbsp; </font></h2><h2><font><%= fname +" "+lname %></font></h2>
			<jsp:include page="adminMenu.jsp"></jsp:include></center>
</body>
</html>
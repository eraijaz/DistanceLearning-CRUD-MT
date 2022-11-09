<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body><jsp:include page="empty_page.jsp"></jsp:include>
<% 		
		PrintWriter printout = response.getWriter();
	    printout.print("<center><h1><font color='black'></t>Online Distance Learning</font> </h1></center>");
		printout.print(" <center><table width=100% STYLE=\"BORDER: double 4px #FF00AA\" BGCOLOR=\"#4DC5D6\" ><tr><td> <marquee scrolldelay='100' behavior='alternate'> <img src='images/1.jpg'><img src='images/2.jpg'><img src='images/3.jpg'><img src='images/4.jpg'><img src='images/5.jpg'></marquee></td></tr></table></center>");
%>


	</body>
</html>
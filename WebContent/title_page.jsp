<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Title Page</title>
</head>
<body>

<%
		PrintWriter printout = response.getWriter();
		printout.print("<frameset border=0 rows='32,170,*'><frame src='view_updates_visitor.jsp'> <frameset cols='25%,*,25%'> <frame src='title_left.jsp'> <frame src='title_center.jsp'> <frame src='title_right.jsp'></frameset> <frameset cols='10%,*,20%'><frame src='empty_page.jsp'><frame src='pics.jsp'><frameset rows='25%,*'><frame src='empty_page.jsp'><frame src='login.jsp'></frameset></frameset></frameset>");
%>

		
</body>
</html>
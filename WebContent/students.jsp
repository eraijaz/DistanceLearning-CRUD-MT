<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="adminMenu.jsp"></jsp:include>
	
	<center>	
		<h2><font color="darkred" >Welcome To Student Maintenance</font></h2><br>
				<a href="student_admission.jsp"><b>New Admission</b></a>&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
			<a href = "admin_view_students.jsp"><b>View Students</b></a>&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
			
			<a href = "admin_listStu.jsp"><b>Delete Students</b></a> </center>
</body>
</html>
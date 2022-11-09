<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Students</title>
</head>
<body>
<jsp:include page="students.jsp"></jsp:include>
<center>
		<h2><font color="darkred"><b>View Students By</b></font></h2>
		<a href="admin_view_stu_course.jsp"><b>Course</b></a>&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="admin_view_stu_batch.jsp"><b>Batch</b></a>
			
		
		
		</center>

</body>
</html>
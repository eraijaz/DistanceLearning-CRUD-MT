<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Student By Batch</title>
</head>
<body>
<jsp:include page="students.jsp"></jsp:include>
	<form action = "View_Students" method="post">
<table align="center">

<tr><th colspan="2"><h2><font color="darkred"><b>View Students of</b></font></h2></th>
					</tr>

<tr><td><b>Batch : </b> </td>
						<td> <select name=batch>
								<option>-Select-</option>
								  <option value="2010">2010</option>
							  <option value="2011">2011</option>
							  <option value="2012">2012</option>
							  <option value="2013">2013</option>
							  
							</select> 
						</td></tr>
						<tr>
<tr><td align ="center" colspan="2"><input type="submit" value="Done"> <input type="reset" value="Reset">
				</td>
				</tr>


</table>

</form>
</body>
</html>
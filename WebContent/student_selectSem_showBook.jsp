
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Select Sem</title>
</head>
<body>
<jsp:include page="student_showBooks.jsp"></jsp:include><br><br>
		<form action="student_showBooksBySem.jsp" method="post">
		<table align="center">
		<tr>
		<td><b> Semester :</b> </td>
					<td> <select name=sem>
							<option>-Select-</option>
							<option value="1">1</option>
							  <option value="2">2</option>
							  <option value="3">3</option>
							  <option value="4">4</option>
							  <option value="5">5</option>
							  <option value="6">6</option>
							  <option value="7">7</option>
							  <option value="8">8</option>
							  </select></td></tr>
							 <tr>
				<td align ="center"><input type="submit" value="Done">
				</td><td>
				<input type="reset" value= "Reset"></td></tr>
				</table>

		</form>
		
		
			


</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display Subjects</title>
</head>
<body>
<jsp:include page="subjects.jsp"></jsp:include>
<form action="Display_Subjects" method="post">
	<table align = "center">
	<tr><th colspan="2"><h2><font color="darkred"><b>Delete Subjects of</b></font></h2></th></tr>
						<tr>
	
	<tr><td><b>Course :</b> </td>
						<td> <select name=course>
							<option>-Select-</option>
							  <option value="B.Tech (ECE)">B.Tech (ECE)</option>
							   <option value="B.Tech (CSE)">B.Tech (CSE)</option>
							    <option value="B.Tech (IT)">B.Tech (IT)</option>
							     <option value="B.Tech (ME)">B.Tech (ME)</option>
							
							  <option value="BCA">BCA</option>
							  <option value="M.Tech (ECE)">M.Tech (ECE)</option>
							  <option value="M.Tech (CSE)">M.Tech (CSE)</option>
							  <option value="M.Tech (IT)">M.Tech (IT)</option>
							  <option value="M.Tech (ME)">M.Tech (ME)</option>
							 
							  <option value="MCA">MCA</option>
							</select> 
						</td></tr>
						
						<tr><td><b>Sem :</b> </td>
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
							  
							  <tr><td align ="center"><input type="submit" value="Submit">
				</td><td>
				<input type="reset" value= "Reset"></td></tr>
	
	</table>


</form>
		
</body>
</html>
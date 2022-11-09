<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Records</title>
</head>
<body>
<jsp:include page="studentMenu.jsp"></jsp:include>
			<%		String msg = "";
				if(request.getAttribute("msg")!=null)
				{
					 msg = request.getAttribute("msg").toString();
				}
				else{
						msg = "";	
				}
		%>
				<form action="Student_Profile" method="post">
		
				<table align = "center">
						<tr><th colspan="2" ><h2><font color="darkred"><b>Personal Information</b></font></h2></th></tr>
					<tr>
							<td colspan=2 align="center"><font color="green"><b><%=msg %></b></font></td>
					</tr>
					
					<tr><td><b>Father's Name :</b> </td>
						<td> <input type = "text" name="fathername" value=""></td></tr>
					<tr><td><b>Address :</b> </td>
						<td> <input type = "text" name="address" value=""></td></tr>
					<tr><td><b>Date of Birth :</b></td>
							<td> <input type = "text" name="dob" value="">dd/mm/yyyy</td></tr>
				<tr><td><b>Question :</b> </td>
						<td> <select name="question">
								<option>-Select Any Question-</option>
							  <option value="What was your first phone number?">What was your first phone number?</option>
							  <option value="What is name of your best friend?">What is name of your best friend?</option>
							  <option value="Who is your favorite person?">Who is your favorite person?</option>
							  <option value="Which color is your favorite?">Which color is your favorite?</option>
							  <option value="What is your pet's name?">What is your pet's name?</option>
							</select> 
						</td></tr>
				<tr><td><b>Answer :</b> </td>
						<td> <input type = "text" name="answer" value=""></td></tr>
						
				<tr><td align ="center" colspan="2"><input type="submit" value="Submit">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="Reset">
				</td>
				</tr>
				
				</table>
			</form>

</body>
</html>
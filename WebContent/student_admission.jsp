<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admission Page</title>
</head>
<body>
<jsp:include page="students.jsp"></jsp:include>
		<%		String msg = "";
				String reg_no="";
				String password="";
				if(request.getAttribute("msg")!=null)
				{
					 msg = request.getAttribute("msg").toString();
					 reg_no=request.getAttribute("reg_no").toString();
					 password = request.getAttribute("password").toString();
				}
				else{
						msg = "";	
					
				}
		%>
		<form action="Student_Admission" method="post">
		
				<table align = "center">
						<tr><th colspan="2"><h2><font color="darkred"><b>Admission</b></font></h2></th></tr>
						<tr>
							<td colspan=2 align="center"><font color="green"><b><%=msg %></b></font></td>
					</tr>
					<tr>
							<td colspan=2 align="center"><font color="darkred"><b><%=reg_no %></b></font></td>
					</tr>
					<tr>
							<td colspan=2 align="center"><font color="darkred"><b><%=password %></b></font></td>
					</tr>
					
					<tr><td><b>First Name : </b></td>
						<td> <input type = "text" name="fname" value=""></td></tr>
					<tr><td><b>Last Name :</b> </td>
						<td> <input type = "text" name="lname" value=""></td></tr>
					<tr><td><b>Gender :</b></td>
					<td><input type="radio" name="gender" value="Male">Male
						<input type="radio" name="gender" value="Female">Female
					</td>
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
					<tr><td><b>Course : </b></td>
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
				<tr><td><b>Prev. Qualification :</b> </td>
						<td> <select name=qualification>
							<option>-Select-</option>
							
							  <option value="+2 Non.Med">+2 Non.Med</option>
							  <option value="+2 Arts">+2 Arts</option>
							  <option value="B.Tech">B.Tech</option>
						  <option value="BCA">BCA</option>
							</select> 
						</td>
				</tr>
				<tr><td><b>Prev. Marks : </b></td>
						<td> <input type = "text" name="marks" value=""></td></tr>
				<tr><td><b>Contact No. :</b> </td>
						<td> <input type = "text" name="contact" value=""></td></tr>
				<tr><td><b>Mail ID :</b> </td>
						<td> <input type = "text" name="mailid" value=""></td></tr>
				<tr><td align ="center" colspan="2"><input type="submit" value="Submit">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="Reset">
				</td>
				</tr>
				
				</table>
			</form>

</body>
</html>
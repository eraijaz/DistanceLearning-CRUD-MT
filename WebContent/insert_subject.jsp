<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Subject</title>
</head>
<body>
<jsp:include page="subjects.jsp"></jsp:include>
			
			<%		String msg = "";
				if(request.getAttribute("msg")!=null)
				{
					 msg = request.getAttribute("msg").toString();
				}
				else{
						msg = "";	
				}
		%>
		<form action="Insert_Subject" method="post">
				<table align = "center">
					<tr><th colspan="2"><h2><font color="darkred"><b>Add New Subject</b></font></h2></th>
					</tr>
					
					<tr>		<td colspan=2 align="center"><font color="green"><b><%=msg %></b></font></td>
					</tr>
						<tr>
				<tr><td><b>Subject :</b> </td>
						<td> <input type = "text" name="sub_name" value=""></td></tr>
				<tr><td><b>Code :</b> </td>
						<td> <input type = "text" name="sub_code" value=""></td></tr>
				<tr><td><b>Paper ID : </b></td>
						<td> <input type = "text" name="paper_id" value=""></td></tr>
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
				<tr><td><b>Maximum Marks :</b> </td>
						<td> <input type = "text" name="max_mrks" value=""></td></tr>
				<tr><td><b>Minimum Marks :</b> </td>
						<td> <input type = "text" name="min_mrks" value=""></td></tr>
				<tr><td align ="center" colspan="2"><input type="submit" value="Submit">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="Reset">
				</td>
				</tr>
				</table>
		</form>

</body>
</html>
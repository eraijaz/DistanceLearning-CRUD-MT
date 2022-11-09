<%@page import="com.actionbeans.student.StudentUpdateDetailsActionBean"%>
<%@page import="com.beans.BeanClass"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Profile</title>
</head>
<body>
	<jsp:include page="studentMenu.jsp"></jsp:include>
		<jsp:useBean id="student"  class="com.beans.BeanClass" scope="application" ></jsp:useBean>
		
		
		<%
							String msg = "";
																if(request.getAttribute("msg")!=null)
																{
																	 msg = request.getAttribute("msg").toString();
																}
																else{
																		msg = "";	
																}
																
															BeanClass bean=new BeanClass();
															StudentUpdateDetailsActionBean action = new StudentUpdateDetailsActionBean(bean);
															Long reg_no= Long.parseLong(session.getAttribute("username").toString());
															bean.setReg_no(reg_no);
															bean=action.ViewRecord();
						%>
			
			<form action="Student_UpdateProfile"  method="post">
			<table align="center">
					<tr><th colspan="2" align = "center"><h2><font color="darkred" ><b>Update Details</b></font></h2></th></tr>
					<tr>
							<td colspan=2 align="center"><font color="green"><b><%=msg %></b></font></td>
					</tr>
			
					<tr>
							<td><b>Reg No. :</b> </td><td><input type="text" disabled="disabled" name="reg_no" value="<%=bean.getReg_no()%>"></td>
					</tr>
					<tr>
							<td><b>First Name :</b> </td><td><input type="text" disabled="disabled" name="fname" value="<%=bean.getFirstname()%>"></td>
					</tr>
					<tr>
							<td><b>Last Name :</b> </td><td><input type="text" disabled="disabled" name="lname" value="<%=bean.getLastname()%>"></td>
					</tr>
					<tr>
					
							<td><b>Gender :</b> </td>
							<td>
							<%
							if(bean.getGender().equalsIgnoreCase("male"))
							{
							%>
							<input type="radio" disabled="disabled" name="gender" checked="checked" value="Male">Male
							<input type="radio" disabled="disabled" name="gender" value="Female">Female
							<% 
							}
							else if(bean.getGender().equalsIgnoreCase("female"))
							{
							%>
							<input type="radio" disabled="disabled" name="gender" value="Male">Male
							<input type="radio" disabled="disabled" name="gender" checked="checked"  value="Female">Female
							<%
							}
							%>
							</td>
					</tr> 
					
					
					<tr><td><b>Batch : </b> </td>
						<td> <select name=batch disabled="disabled">
								<option value=<%=bean.getBatch()%>><%=bean.getBatch() %></option>
								  <option value="2010">2010</option>
							  <option value="2011">2011</option>
							  <option value="2012">2012</option>
							  <option value="2013">2013</option>
							  
							</select> 
						</td></tr>
					<tr><td><b>Course :</b> </td>
						<td> <select name=course disabled="disabled">
							<option value=<%=bean.getCourse() %>><%=bean.getCourse() %></option>
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
						<td> <select name=qualification disabled="disabled">
							<option value=<%=bean.getPrev_qual() %>><%=bean.getPrev_qual() %></option> 
							  <option value="+2 Non.Med">+2 Non.Med</option>
							  <option value="B.Tech">B.Tech</option>
						  <option value="BCA">BCA</option>
							</select> 
						</td>
				</tr>
					<tr>
							<td><b>Prev. Marks : </b></td><td><input type="text" disabled="disabled" name="marks" value="<%=bean.getPrev_marks()%>"></td>
					</tr>
					<tr>
							<td><b>Contact No. :</b> </td><td><input type="text" name="contact" value="<%=bean.getContact()%>"></td>
					</tr>
					<tr>
							<td><b>Mail ID :</b> </td><td><input type="text" name="mailid" value="<%=bean.getMailid()%>"></td>
					</tr>
					<tr>
							<td><b>Father Name :</b> </td><td><input type="text" disabled="disabled" name="fathername" value="<%=bean.getFather_name()%>"></td>
					</tr>
					<tr>
							<td><b>Address :</b> </td><td><input type="text" name="address" value="<%=bean.getAddress()%>"></td>
					</tr>
					<tr>
							<td><b>Date of Birth :</b> </td><td><input type="text" disabled="disabled" name="dob" value="<%=bean.getDob()%>"></td>
					</tr>
					<tr><td><b>Question : </b></td>
						<td> <select name="question">
								<option value=<%=bean.getQuestion() %>><%=bean.getQuestion() %></option>
							  <option value="What was your first phone number?">What was your first phone number?</option>
							  <option value="What is name of your best friend?">What is name of your best friend?</option>
							  <option value="Who is your favorite person?">Who is your favorite person?</option>
							  <option value="Which color is your favorite?">Which color is your favorite?</option>
							  <option value="What is your pet's name?">What is your pet's name?</option>
							</select> 
						</td></tr>
					<tr>
							<td><b>Answer :</b> </td><td><input type="text" name="answer" value="<%=bean.getAnswer()%>"></td>
					</tr>
					<tr><td align ="center" colspan="2"><input type="submit" value="Submit">
					&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="Reset">
				</td>
				</tr>
			
			</table>
	</form>			
		
</body>
</html>
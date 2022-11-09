<%@page import="java.sql.ResultSet"%>
<%@page import="com.actionbeans.admin.AdminQuestionsActionBean"%>
<%@page import="com.beans.BeanClass"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="questions.jsp"></jsp:include>
<%
	String msg = "";
		if(request.getAttribute("msg")!=null)
		{
	 msg = request.getAttribute("msg").toString();
		}
		else{
		msg = "";	
		}
		
		
		BeanClass bean = new BeanClass();
		AdminQuestionsActionBean action = new AdminQuestionsActionBean(bean);
		ResultSet resultSet= action.getSubCode();
%>
<form action="Add_Questions" method="post">
		<table align = "center">
						<tr><th colspan="2"><h2><font color="darkred"><b>Add Question</b></font></h2></th></tr>
						<tr>
							<td colspan=2 align="center"><font color="green"><b><%=msg %></b></font></td>
					</tr>
					
					<tr><td><b>Subject Code : </b></td>
						<td> 
						<select name=sub_code>
								<option>-Select-</option>
								<%
								while(resultSet.next())
								{
								%>
						 <option value="<%=resultSet.getString(2) %>"><%=resultSet.getString(2)%> (<%=resultSet.getString(1)%>)</option>
							  <%  } %>
					</select>	</td></tr>
					<tr><td><b>Question : </b></td>
						<td> <input type = "text" name="exam_ques" value=""></td></tr>
					<tr><td><b>Answer 1 : </b></td>
						<td> <input type = "text" name="ans1" value=""></td></tr>
					<tr><td><b>Answer 2 : </b></td>
						<td> <input type = "text" name="ans2" value=""></td></tr>
					<tr><td><b>Answer 3 : </b></td>
						<td> <input type = "text" name="ans3" value=""></td></tr>
					<tr><td><b>Answer 4 : </b></td>
						<td> <input type = "text" name="ans4" value=""></td></tr>
					<tr><td><b>Right Answer : </b></td>
						<td> <input type = "text" name="right_ans" value=""></td></tr>
					<tr><td align ="center"><input type="submit" value="Submit">
				</td><td>
				<input type="reset" value= "Reset"></td></tr>
	
			</table>
</form>
</body>
</html>
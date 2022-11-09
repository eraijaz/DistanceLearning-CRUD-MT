<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Write Updates</title>
</head>
<body>
				<%		String msg = "";
				if(request.getAttribute("msg")!=null)
				{
					 msg = request.getAttribute("msg").toString();
				}
				else
				{
					msg = "";	
				}
		%>
		<jsp:include page="view_updates.jsp"></jsp:include>
		<jsp:include page="updates.jsp"></jsp:include>
				<form action="Write_Updates" method="post">
	
				<table align = "center">
						<tr><th colspan="2"><h2><font color="darkred"><b>Write News</b></font></h2></th></tr>
						<tr>
							<td colspan=2 align="center"><font color="green"><b><%=msg %></b></font></td>
					</tr>
						<tr><td><b>Date</b>     </td>
						<td> <input type = "text" name="event_date" value="" >dd//mm/yyyy</td></tr>
					<tr><td><b>News</b>    </td>
						<td> <input type = "text" name="news" value=""></td></tr>
					
					<tr><td align ="center" colspan="2"><input type="submit" value="Submit">
					&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="Reset">
				</td>
				</tr>
			</table>
			</form>
</body>
</html>
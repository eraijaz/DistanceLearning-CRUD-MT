<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body><jsp:include page="empty_page.jsp"></jsp:include>
	<form action="Visitor_Feedback" method="post">
	<table align="center">
	<tr><td colspan="3" align="center"><h3><b><font color="darkred" >Write Comment </font></b> </h3> </td></tr>
	<tr><td><b>Name :</b></td>
	<td><input type="text"  name="v_name" value=""></td></tr>
	
	<tr><td><b>Mail Id :</b></td>
	<td><input type="text"  name="v_mailid" value=""></td></tr>
	
	<tr><td><b>Comment :</b></td>
	<td><input type="text"  name="v_comment" value=""></td></tr>
	
	
	<tr><td align ="right"><input type="submit" value="Done">
				</td>
				<td><input type="reset" value="Reset">
				</td>
				</tr>
	</table>
	</form>
	<br>
<jsp:include page="display_feedback.jsp"></jsp:include>

</body>
</html>
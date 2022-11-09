<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="studentHome.jsp"></jsp:include>
		<%
		int total_ques=Integer.parseInt(session.getAttribute("total_ques").toString());
		int rightans=Integer.parseInt(session.getAttribute("no_rightans").toString());
		int wrongans=Integer.parseInt(session.getAttribute("no_wrongans").toString());
		
		int total_marks=total_ques*5;
		int result = (rightans*5)-(wrongans*2);
		float result_percentage = (result*100)/total_marks;
		
		%>
		<center>
	<h3><font color="darkred">Registration no.:</font> <%=session.getAttribute("username") %><br>
	<font color="darkred">	Subject:</font> <%=session.getAttribute("subject") %> <br>
	<font color="darkred">	Subject Code:</font> <%=session.getAttribute("sub_code") %><br>
	<font color="darkred">	Paper Id:</font> <%=session.getAttribute("paper_id")%><br>
	<font color="darkred">	Total Questions: </font><%=session.getAttribute("total_ques") %><br>
	<font color="darkred">	Attempted Questions:</font> <%=session.getAttribute("attempt_ques") %><br>
	<font color="darkred">	Right Answers:</font> <%=session.getAttribute("no_rightans") %><br>
	<font color="darkred">	Wrong Answers:</font> <%=session.getAttribute("no_wrongans") %><br>
	<font color="darkred">	Result:</font> <%=result %> / <%=total_marks %> (<%=result_percentage %>%)
		</h3>
</center>
</body>
</html>
<%@page import="java.sql.*"%>
<%@page import="java.sql.*"%>
<%@page import="com.actionbeans.student.StudentShowBooksActionBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.beans.BeanClass"%>
    <%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show books by Subject
</title>
</head>
<body>
<jsp:include page="studentMenu.jsp"></jsp:include>
<%
	int i=0;

Iterator<Object> itr=null;
ArrayList<Object> list = null;

	BeanClass bean = new BeanClass();
	bean.setReg_no(Long.parseLong(session.getAttribute("username").toString()));
	bean.setSub_code(request.getParameter("sub_code").toString());
	
	StudentShowBooksActionBean action = new StudentShowBooksActionBean(bean);
	
	list = action.BooksBySubject();
	
	 itr  =   list.iterator(); 
		
	    if(list.size()>0)
		{
	   
%>	<center><h2><font color="darkred" ><b>List of Books By Subject</b></font></h2></center>
		
		
				<table align="center"  border=1>
					<tr>	<th align="center">S.no</th>
					<th align="center">Subject Code</th>
								<th align="center">Subject Name</th>
								<th align="center">Book</th>
								<th align="center">Author</th>
								<th align="center">Course</th>
								<th align="center">Semester</th>
										
				</tr>
				<%
				while(itr.hasNext())
				{
					i++;
%>
						<tr><td><%=i %></td>
						<td><%=itr.next() %></td>
						<td><%=itr.next() %></td>
						<td><%=itr.next() %></td>
						<td><%=itr.next() %></td>
						<td><%=itr.next() %></td>
						<td><%=itr.next() %></td>
						<%
						String path = itr.next().toString();
								
					}
					

%>
	</tr>
<%
				}

				
%>
					</table>
					
		
	
</body>
</html>
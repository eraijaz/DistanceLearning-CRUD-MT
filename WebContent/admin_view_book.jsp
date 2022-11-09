<%@page import="com.actionbeans.admin.AdminBooksActionBean"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.actionbeans.admin.AdminSubjectsActionBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.beans.BeanClass"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Vector"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="books.jsp"></jsp:include><br><br>
<%
	int i=0;
		Vector<Vector<Object>>  data=null;
		Vector<Object>    row   = null;
		Iterator<Vector<Object>> itr_row = null;
		Iterator<Object>       itr_col=null;
		ResultSet resultset = null;
		    	BeanClass bean = new BeanClass();
		    	
		    	bean.setCourse(session.getAttribute("course").toString());
		    	AdminBooksActionBean action = new AdminBooksActionBean(bean);
		    	
		    	data= action.viewBooks();
		    	itr_row  =   data.iterator(); 
	    if(data.size()>0)
		{
%>
					<center><h2><font color="darkred" ><b>List of Books</b></font></h2></center>
 		
					<table align="center"  border=1>
					
							<tr>
							<th align="center">S.no</th>
								<th align="center">Subject Code</th>
									<th align="center">Subject Name</th>
									<th align="center">Book</th>
									<th align="center">Author</th>
									<th align="center">Course</th>
									<th align="center">Sem</th>
									<th align="center">Path</th>
									
				</tr>
						
			<%			
								itr_row = 	data.iterator();					
								while(itr_row.hasNext())
								{ i++;
									 row  =     itr_row.next();
									itr_col =row.iterator();		

		%>
					<tr><td><%=i %></td>
		<%							
									while(itr_col.hasNext())
									{
										
							%>
										<td><%=itr_col.next() %></td>
										
							<%		
									}
									
		
		%>
					</tr>
		<%
								}

								
		%>
				</table>
		<%
				}
				else{
	%>				
							<h3 align=center>Record not exist.</h3>		
		<%				
				}		
						
		%>
		
		
</body>
</html>
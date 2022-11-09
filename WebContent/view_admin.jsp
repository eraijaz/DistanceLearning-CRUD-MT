<%@page import="com.actionbeans.superadmin.SuperAdminActionBean"%>
<%@page import="com.beans.BeanClass"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Admin</title>
</head>
<body>
<jsp:include page="superAdminHome.jsp"></jsp:include><br><br>
<%
	Vector<Object> row=null;
		Vector<Vector<Object>> data=null;
		Iterator<Vector<Object>> itr_row = null;
		Iterator<Object>       itr_col=null;
		BeanClass bean = new BeanClass();
		
		SuperAdminActionBean action = new SuperAdminActionBean(bean);
		data = action.listAdmin();
		
		 itr_row  =   data.iterator(); 
		    if(data.size()>0)
	{
%>

		<center><h2><font color="darkred" ><b>List of Administrators</b></font></h2></center>
				
			<table align="center"  border=1>
		
					<tr>
								<th align="center">First Name</th>
									<th align="center">Last Name</th>
									<th align="center">Username</th>
									<th align="center">Password</th>
									<th align="center">Mail ID</th>
									<th align="center">Contact</th>
									
				</tr>
						
			<%			
								itr_row = 	data.iterator();					
								while(itr_row.hasNext())
								{
									 row  =     itr_row.next();
									itr_col =row.iterator();		

		%>
					<tr>
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
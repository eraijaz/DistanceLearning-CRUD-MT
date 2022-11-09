<%@page import="com.actionbeans.superadmin.SuperAdminActionBean"%>
<%@page import="com.beans.BeanClass"%>
<%@page import="java.sql.ResultSet"%>
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
<form action="Delete_Admin" method="post">
<%
	Vector<Object> row=null;
		Vector<Vector<Object>> data=null;
		Iterator<Vector<Object>> itr_row = null;
		Iterator<Object>       itr_col=null;
		ResultSet resultset=null;
		BeanClass bean = new BeanClass();
		
		SuperAdminActionBean action = new SuperAdminActionBean(bean);
		resultset = action.getUsername();
		data = action.listAdmin();
		
		 itr_row  =   data.iterator(); 
		    if(data.size()>0)
	{
%>
			<center><h2><font color="darkred" ><b>List of Administrators</b></font></h2></center>
		
			<table align="center"  border=1 >
				
					<tr>	<th align="center">Delete</th>
								<th align="center">First Name</th>
									<th align="center">Last Name</th>
									<th align="center">Username</th>
									<th align="center">Password</th>
									<th align="center">Mail ID</th>
									<th align="center">Contact</th>
									
				</tr>
						
			<%			
 									itr_row = 	data.iterator();					
 									while(itr_row.hasNext() && resultset.next())
 									{
 									
 										 row  =     itr_row.next();
 										itr_col =row.iterator();	
 										
 										

 			%>
 						<tr><td align="center"><input type="checkbox" name= "delete" value="<%=resultset.getString(3)%>"></td>
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
 					<tr><td colspan="7" align= "center"><input type="submit" value="Delete Selected"></td></tr>
 					</table>
 			<%
 					}
 									
 					else{
 		%>				
 								<h3 align=center>No Record exist.</h3>		
 			<%				
 					}		
 							
 			%>
 			</form>
</body>
</html>
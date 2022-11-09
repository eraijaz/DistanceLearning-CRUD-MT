<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*"%>
<%@page import="com.database.Dao"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="lightpink" >
			  				<%
			  				int i=0;
			  					Connection connection = Dao.getConnect();
			  					String selectQuery = "select * from updates";
			  					try{
			  						PreparedStatement prepare = connection.prepareStatement(selectQuery);
			  						ResultSet resultset= prepare.executeQuery();
			  				%>
			  				
			  			<marquee bgcolor="black" width="100%" direction="left" onmouseover="stop();" onmouseout="start();">
			  					
			  					
			  				<%	
			  					while(resultset.next())
			  					{
			  					i++;
			  				%>
			  				   
			  				<b> <font color="mistyrose">  <%= resultset.getString(1) %> - </font></b> - 
			  				 <b>  <font color="mistyrose"> <%= resultset.getString(2) %></font></b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			  				   
			  				<%
			  			
			  					}
			  				%>    
							</marquee>		
										
			  				<%
			  					}
			  					catch(Exception e)
			  					{
			  						e.printStackTrace();
			  					}
			  				%>
			  
</body>
</html>
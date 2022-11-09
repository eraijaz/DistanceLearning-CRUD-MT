<%@page import="java.sql.*"%>
<%@page import="com.database.Dao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Updates</title>
</head>
<body>
			  <table width=250 height="450" align = "right" border= 1 > 
			  		   <tr> <th><font color="brown">NEWS</font></th></tr>
			  				<%
			  				int i=0;
			  					Connection connection = Dao.getConnect();
			  					String selectQuery = "select * from updates";
			  					try{
			  						PreparedStatement prepare = connection.prepareStatement(selectQuery);
			  						ResultSet resultset= prepare.executeQuery();
			  				%>
			  				
			  					<tr><td><marquee direction="up" height="300" onmouseover="stop();" onmouseout="start(); ">
			  					<table>
			  					
			  				<%	
			  					while(resultset.next())
			  					{i++;
			  				%>
			  				    <tr><td>
			  				  <%=i %>. &nbsp;  <%= resultset.getString(1) %><br>
			  				    <hr width = 200 color="brown" > 
			  				    <%= resultset.getString(2) %><br><br><br>
			  				    </td></tr>
			  				<%
			  					}
			  				%>    
								</table></marquee>		
								</td></tr>  				
			  				<%
			  					}
			  					catch(Exception e)
			  					{
			  						e.printStackTrace();
			  					}
			  				%>
			  
			  </table>

</body>
</html>
package com.actionbeans.login;

import java.sql.*;

import com.beans.BeanClass;
import com.database.Dao;

public class LoginActionBean {
	
	private BeanClass login;
	private Connection connection;
	private PreparedStatement prepare;
	private boolean flag;
	private ResultSet resultset;
	
	
	private String admSearchQuery="select * from admin_details";
	private String stuSearchQuery="select * from student_profile";

	public LoginActionBean(BeanClass login)
	{
		this.login= login;
		connection=Dao.getConnect();
	}
	
	public boolean admSearch()
	{
		try
		{
			prepare = connection.prepareStatement(admSearchQuery);
			resultset = prepare.executeQuery();
			
			String username= login.getUsername();
			String password = login.getPassword();
		
			while(resultset.next())
			{
				
				if(resultset.getString(3).equalsIgnoreCase(username)&&resultset.getString(4).equalsIgnoreCase(password))
				{
					
					login.setUsername(username);
					login.setFirstname(resultset.getString(1));
					login.setLastname(resultset.getString(2));
					
					flag=true;
					break;
				
				}
				else 
				{
					System.out.println("else block");
					flag= false;
				}
				
			}
		} 
		
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return flag;
	}
	

	public boolean stuSearch()
	{
		try
		{
			prepare = connection.prepareStatement(stuSearchQuery);
			resultset = prepare.executeQuery();
			String username= login.getUsername();
			String password = login.getPassword();
			
			while(resultset.next())
			{
				if(resultset.getString(1).equalsIgnoreCase(username)&&resultset.getString(11).equalsIgnoreCase(password))
				{
					flag=true;
					login.setFirstname(resultset.getString(2));
					login.setLastname(resultset.getString(3));
					login.setCourse(resultset.getString(6));
					login.setBatch(resultset.getInt(5));
					break;
				}
				else 
				{
					flag= false;
				}
				
			}
		} 
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public BeanClass getBean()
	{
		return login;
	}
	
}

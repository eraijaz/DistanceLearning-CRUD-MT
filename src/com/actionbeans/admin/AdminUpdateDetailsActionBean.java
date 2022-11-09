package com.actionbeans.admin;

import java.sql.*;

import com.beans.BeanClass;
import com.database.Dao;

public class AdminUpdateDetailsActionBean {
	
		private BeanClass bean;
		private Connection connection;
		private PreparedStatement prepare;
		private ResultSet resultSet;
		private boolean flag;
		
		private String selectQuery="select * from admin_details where firstname=? && username=?";
		private String updateQuery="update admin_details set mailid=?,contact=? where firstname=? &&username=? ";
		
		public AdminUpdateDetailsActionBean(BeanClass bean)
		{
		this.bean=bean;
		connection=Dao.getConnect();
		}
		
		public BeanClass displayRecord()
		{
			try{
				prepare=connection.prepareStatement(selectQuery);
				prepare.setString(1, bean.getFirstname());
				prepare.setString(2, bean.getUsername());
				resultSet=prepare.executeQuery();
				
				while(resultSet.next())
				{
					if(bean.getFirstname().equalsIgnoreCase(resultSet.getString(1)))
					{
						bean.setFirstname(resultSet.getString(1));
						bean.setLastname(resultSet.getString(2));
						bean.setUsername(resultSet.getString(3));
						bean.setMailid(resultSet.getString(5));
						bean.setContact(resultSet.getString(6));
						System.out.println("bean set");
					}
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
			return bean;
		}
	
		public boolean updateRecord() 
		{
			try{
				prepare=connection.prepareStatement(updateQuery);
				prepare.setString(1, bean.getMailid());
				prepare.setString(2, bean.getContact());
				prepare.setString(3, bean.getFirstname());
				prepare.setString(4, bean.getUsername());
			
				System.out.println(bean.getMailid());
				System.out.println(bean.getUsername());
				int res=prepare.executeUpdate();
				System.out.println(res);
				if(res==1)
				{
					flag=true;
				}
				else
				{
					flag=false;
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			return flag;
			
		}


}

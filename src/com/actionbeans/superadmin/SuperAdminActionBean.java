package com.actionbeans.superadmin;

import java.sql.*;
import java.util.Vector;

import com.actionbeans.login.PasswordGenerationActionBean;
import com.beans.BeanClass;
import com.database.Dao;

public class SuperAdminActionBean {
	
		private BeanClass bean;
		
		private Connection connection;
		private PreparedStatement prepare;
		private int result;
		private boolean flag;
		private String password;
		private ResultSet resultset;
		private ResultSetMetaData metadata;
		
		private Vector<Object>  row = new Vector<Object>();
		private Vector<Vector<Object>>  data = new Vector<Vector<Object>>();
		
		private String insertQuery="insert into admin_details values(?,?,?,?,?,?)";
		private String selectQuery="select * from admin_details";
		private String deleteQuery="delete from admin_details where username=?";
		private String showPwdQuery="select * from admin_details where username=?";
		
		public SuperAdminActionBean(BeanClass bean)
		{
			this.bean= bean;
			connection=Dao.getConnect();
			password = PasswordGenerationActionBean.getPassword();
		}
		
		public boolean creatAdmin()
		{
			try
			{
				prepare = connection.prepareStatement(insertQuery);
				
				prepare.setString(1, bean.getFirstname());
				prepare.setString(2, bean.getLastname());
				prepare.setString(3, bean.getUsername());
				prepare.setString(4, password);
				prepare.setString(5, bean.getMailid());
				prepare.setString(6, bean.getContact());
				
				result = prepare.executeUpdate();
				
				if(result==1)
				{
					flag = true;
					
						prepare=connection.prepareStatement(showPwdQuery);
						prepare.setString(1, bean.getUsername());
						
						resultset = prepare.executeQuery();
						while(resultset.next())
							{
								bean.setUsername((resultset.getString(3)));
								bean.setPassword(resultset.getString(4));
							}
				}
				else
				{
					flag = false;
				}
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			return flag;
		}
	
		public Vector<Vector<Object>> listAdmin()
		{
			try{
				prepare = connection.prepareStatement(selectQuery);
				
				resultset = prepare.executeQuery();
				
				metadata = resultset.getMetaData();
				int cols = metadata.getColumnCount();
				System.out.println("cols "+cols);
				
					while(resultset.next())
					{
						row  = new Vector<Object>();
							
							for(int i=1;i<=cols;i++)
							{		
								row.addElement(resultset.getObject(i));
							}
							
							data.addElement(row);
							System.out.println("row added ");
						}
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}
			return data;
		}
		
		public ResultSet getUsername()
		{
			try{
				prepare=connection.prepareStatement(selectQuery);
				resultset = prepare.executeQuery();
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}
			return resultset;				
		}

		public boolean deleteAdmin()
		{
			try{
			prepare = connection.prepareStatement(deleteQuery);
			
			prepare.setString(1, bean.getUsername());
			
			result = prepare.executeUpdate();
			if(result>0)
			{
				System.out.println("Success");
				flag = true;
			}
			else{
				flag = false;
			}
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}
			return flag;
		}
}


package com.actionbeans.admin;

import java.sql.*;
import java.util.Vector;

import com.beans.BeanClass;
import com.database.Dao;

public class AdminBooksActionBean {

	private BeanClass bean;
	private Connection connection;
	private PreparedStatement prepare;
	private int result;
	private boolean flag;
	private ResultSet resultset;
	private ResultSetMetaData metadata;
	
	private Vector<Object>  row = new Vector<Object>();
	private Vector<Vector<Object>>  data = new Vector<Vector<Object>>();
	
	private String insertQuery="insert into library values(?,?,?,?,?,?,?)";
	private String displayBookQuery="select * from library where course=? and sem=?";
	private String deleteQuery="delete from library where book=?";
	private String viewBookQuery="select * from library where course=? order by sem";
	private String getSubCode="select distinct sub_code,subject from subject order by sub_code"; 
	
	public AdminBooksActionBean(BeanClass bean)
	{
		this.bean=bean;
		connection=Dao.getConnect();
	}
	
	public boolean insertBook()
	{
				try{
				prepare = connection.prepareStatement(insertQuery);
				prepare.setString(1, bean.getSub_code());
				prepare.setString(2, bean.getSub_name());
				prepare.setString(3, bean.getBook());
				prepare.setString(4, bean.getAuthor());
				prepare.setString(5, bean.getCourse());
				prepare.setInt(6, bean.getSem());
				prepare.setString(7, bean.getPath());
				
				result = prepare.executeUpdate();
				if(result==1)
				{
					flag = true;
				}
				else{
					flag = false;
				}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				return flag;
	}
	
	public Vector<Vector<Object>> displayBooks()
	{
		try{
		
				prepare= connection.prepareStatement(displayBookQuery);
				prepare.setString(1, bean.getCourse());
				prepare.setInt(2, bean.getSem());
		
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
	
	public Vector<Vector<Object>> viewBooks()
	{
		try{
		
				prepare= connection.prepareStatement(viewBookQuery);
				prepare.setString(1, bean.getCourse());
		
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

	public boolean deleteBooks()
	{
		try{
			
			prepare = connection.prepareStatement(deleteQuery);
			prepare.setString(1, bean.getBook());
			
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
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return flag;
	}

	public ResultSet getSub_Code()
	{
		try
		{
			prepare= connection.prepareStatement(displayBookQuery);
			prepare.setString(1, bean.getCourse());
			prepare.setInt(2, bean.getSem());
	
			resultset = prepare.executeQuery();
			
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
			
		return resultset;
	}

	public ResultSet getSubCodefromSubject()
	{
		try{
		prepare=connection.prepareStatement(getSubCode);
		
		resultset=prepare.executeQuery();
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}	
		return resultset;
	}
}

package com.actionbeans.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;

import com.beans.BeanClass;
import com.database.Dao;

public class AdminUpdatesActionBean {

	private BeanClass bean;
	private Connection connection;
	private PreparedStatement prepare;
	private int result;
	private boolean flag;
	private ResultSet resultset;
	private ResultSetMetaData metadata;
	
	private Vector<Object>  row = new Vector<Object>();
	private Vector<Vector<Object>>  data = new Vector<Vector<Object>>();
	
	private String insertQuery="insert into updates values(?,?)";
	private String selectQuery="select * from updates";
	private String deleteQuery="delete from updates where news=?";
	
	
	public AdminUpdatesActionBean(BeanClass bean)
	{
		this.bean=bean;
		connection = Dao.getConnect();
	}
	
	public boolean insertUpdates()
	{
			try
			{
				prepare  = connection.prepareStatement(insertQuery);
				prepare.setString(1,bean.getEvent_date());
				prepare.setString(2,bean.getNews());
				
				result = prepare.executeUpdate();
				if(result==1)
				{
					flag = true;
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
	
	public Vector<Vector<Object>> listNews()
	{
		try
		{
			prepare=connection.prepareStatement(selectQuery);
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
			}
		
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		return data;
	}
	
	public ResultSet getEvent()
	{
		try{
		prepare=connection.prepareStatement(selectQuery);
		resultset = prepare.executeQuery();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return resultset;
	}
	
	public boolean DeleteUpdates()
	{
		try
		{
			prepare=connection.prepareStatement(deleteQuery);
			prepare.setString(1, bean.getNews());
			
			result = prepare.executeUpdate();
			
			if(result>=1)
			{
				flag=true;
			}
			else
			{
				flag=false;
			}
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		return flag;
	}
}

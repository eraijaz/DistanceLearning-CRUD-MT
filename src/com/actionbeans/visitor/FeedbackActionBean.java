package com.actionbeans.visitor;

import java.sql.*;

import com.beans.BeanClass;
import com.database.Dao;

public class FeedbackActionBean {
	
	private BeanClass bean;
	private Connection connection;
	private PreparedStatement prepare;
	private int result;
	private boolean flag;	
	private ResultSet resultset;
	private ResultSetMetaData metadata;
	
	private String writeFeedbackQuery="insert into feedback values(?,?,?)";
	private String displayFeedbackQuery="select * from feedback";
	
	
	public FeedbackActionBean(BeanClass bean)
	{
		this.bean=bean;
		connection=Dao.getConnect();
	}
	
	public boolean writeFeedback()
	{
		try
		{
			prepare=connection.prepareStatement(writeFeedbackQuery);
			prepare.setString(1, bean.getV_name());
			prepare.setString(3, bean.getV_mailid());
			prepare.setString(2, bean.getV_comment());
			
			result= prepare.executeUpdate();
			
			if(result==1)
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
	
	
	public ResultSet displayFeedback()
	{
		try{
		
				prepare= connection.prepareStatement(displayFeedbackQuery);
		
				resultset = prepare.executeQuery();
				
				metadata = resultset.getMetaData();
				int cols = metadata.getColumnCount();
				System.out.println("cols "+cols);
		
				}
				catch(Exception exception)
				{
					exception.printStackTrace();
				}
		
		return resultset;
		
	}
	

}

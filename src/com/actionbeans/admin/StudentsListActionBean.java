package com.actionbeans.admin;

import java.sql.*;
import java.util.Vector;

import com.beans.BeanClass;
import com.database.Dao;

public class StudentsListActionBean {
	
	private BeanClass bean;
	private Connection connection;
	private PreparedStatement prepare;
	private ResultSet resultset;
	private ResultSetMetaData metadata;
	private boolean flag;

	private Vector<Object>  row = null;
	private Vector<Vector<Object>>  data = null;
	
	private String selectQueryByCourse="select * from student_profile where course=? order by batch";
	private String selectQueryByBatch="select * from student_profile where batch=? order by course";
	private String deleteStudentQuery="delete from student_profile where reg_no=? ";
	private String selectQuery="select * from student_profile where batch=? && course=?";
	public StudentsListActionBean(BeanClass bean)
	{
		this.bean=bean;
		connection = Dao.getConnect();
		data = new  Vector<Vector<Object>>();
		
	}
	
	public Vector<Vector<Object>> listStudentsByCourse()
	{
		try 
		
		{
			prepare=connection.prepareStatement(selectQueryByCourse);
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
			}
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return data;
		
	}
	
	
	public Vector<Vector<Object>> listStudentsByBatch()
	{
		try 
		
		{
			prepare=connection.prepareStatement(selectQueryByBatch);
			prepare.setInt(1, bean.getBatch());
			System.out.println("batch "+bean.getBatch());
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
			System.out.println("row added");
			data.addElement(row);
			}
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return data;
		
	}
	
	public ResultSet getRegNoByBatch_Course()
	{
		try{
			prepare= connection.prepareStatement(selectQuery);
			prepare.setInt( 1, bean.getBatch());
			prepare.setString(2, bean.getCourse());
			resultset=prepare.executeQuery();
			
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}
			
			return resultset;
		}
		
	public Vector<Vector<Object>> listStudents()
	{
		try 		
		{
			prepare=connection.prepareStatement(selectQuery);
			prepare.setInt(1, bean.getBatch());
			prepare.setString(2,bean.getCourse());
			System.out.println("batch "+bean.getBatch());
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
			System.out.println("row added");
			data.addElement(row);
			}
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public boolean deleteStudents()
	{
		try{
			prepare = connection.prepareStatement(deleteStudentQuery);
			prepare.setLong(1, bean.getReg_no());
			
			int result=prepare.executeUpdate();
			if(result>=1)
			{
				flag = true;
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

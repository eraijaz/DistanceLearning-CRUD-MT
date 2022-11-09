package com.actionbeans.admin;

import java.sql.*;
import java.util.Vector;

import com.beans.BeanClass;
import com.database.Dao;

public class AdminSubjectsActionBean {
	
		private BeanClass bean;
		private Connection connection;
		private PreparedStatement prepare;
		private int result;
		private boolean flag;
		
		private ResultSet resultset;
		private ResultSetMetaData metadata;
		
		private Vector<Object>  row = new Vector<Object>();
		private Vector<Vector<Object>>  data = new Vector<Vector<Object>>();
		
		private String insertQuery="insert into subject values(?,?,?,?,?,?,?)";
		private String displaySubQuery="select * from subject where course=? and sem=?";
		private String deleteQuery="delete from subject where paper_id=?";
		private String viewSubQuery="select * from subject where course=? order by sem";
		public AdminSubjectsActionBean(BeanClass bean)
		{
			this.bean=bean;
			connection=Dao.getConnect();
			
		}
		
		public boolean insertSubject()
		{
				try{
					prepare  = connection.prepareStatement(insertQuery);
					
					prepare.setString(1, bean.getSub_name());
					prepare.setString(2,bean.getSub_code());
					prepare.setString(3,bean.getPaper_id());
					prepare.setString(4,bean.getCourse());
					prepare.setInt(5,bean.getSem());
					prepare.setInt(6,bean.getMax_mrks());
					prepare.setInt(7,bean.getMin_mrks());
					
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
		
		public Vector<Vector<Object>> displaySubjects()
		{
			try{
			
					prepare= connection.prepareStatement(displaySubQuery);
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

		public boolean deleteSubjects()
		{
			try{
				
				prepare = connection.prepareStatement(deleteQuery);
				
				prepare.setString(1, bean.getPaper_id());
				
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
				prepare= connection.prepareStatement(displaySubQuery);
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
		
		
		public Vector<Vector<Object>> viewSubjects()
		{
			try{
			
					prepare= connection.prepareStatement(viewSubQuery);
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
}

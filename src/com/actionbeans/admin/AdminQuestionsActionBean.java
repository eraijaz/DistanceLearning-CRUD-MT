package com.actionbeans.admin;

import java.sql.*;
import java.util.Vector;

import com.beans.BeanClass;
import com.database.Dao;


public class AdminQuestionsActionBean {

		BeanClass bean = new BeanClass();
		private Connection connection;
		private PreparedStatement prepare;
		private ResultSet resultset;
		private boolean flag;
		private ResultSetMetaData metadata;
		
		private Vector<Object>  row = new Vector<Object>();
		private Vector<Vector<Object>>  data = new Vector<Vector<Object>>();
		
		private String insetQuesQuery= "insert into exam_ques values(?,?,?,?,?,?,?)";
		private String deleteQuesQuery="delete from exam_ques where exam_ques=?";
		private String listQuesQuery="select * from exam_ques where sub_code=?";
		private String getSubCode="select distinct subject, sub_code from subject";
		private String viewResultQuery="select * from student_result where course=? and batch=? order by reg_no";
		public AdminQuestionsActionBean(BeanClass bean)
		{
			this.bean=bean;
			connection=Dao.getConnect();
		}
		
		public boolean insertQuestion()
		{
			try
			{
						prepare = connection.prepareStatement(insetQuesQuery);
						prepare.setString(1, bean.getSub_code());
						prepare.setString(2, bean.getExam_ques());
						prepare.setString(3, bean.getAns1());
						prepare.setString(4, bean.getAns2());
						prepare.setString(5, bean.getAns3());
						prepare.setString(6, bean.getAns4());
						prepare.setString(7, bean.getRight_ans());
						
						int result = prepare.executeUpdate();
						
						if(result==1)
						{
							flag=true;
							System.out.println("true flag");
						}
						
						else
						{
							flag=false;
							System.out.println("false flag");
						}
				
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}
			return flag;
		}	

		public Vector<Vector<Object>> listQues()
		{
			try
			{
				prepare=connection.prepareStatement(listQuesQuery);
				prepare.setString(1, bean.getSub_code());
				
				resultset=prepare.executeQuery();
				
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

		public ResultSet getQues()
		{
			try
			{
				prepare=connection.prepareStatement(listQuesQuery);
				prepare.setString(1, bean.getSub_code());
				
				resultset=prepare.executeQuery();
				
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}
			
			return resultset;
		}

		public boolean deleteQuestions()
		{
			try
			{
				prepare=connection.prepareStatement(deleteQuesQuery);
				prepare.setString(1, bean.getExam_ques());
				
				int res=prepare.executeUpdate();
				if(res>=1)
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
		
		public ResultSet getSubCode()
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

		public ResultSet viewResults()
		{
			try {
			
				prepare=connection.prepareStatement(viewResultQuery);
				prepare.setString(1, bean.getCourse());
				prepare.setInt(2, bean.getBatch());
				
				resultset=prepare.executeQuery();
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			
			return resultset;
		}

}

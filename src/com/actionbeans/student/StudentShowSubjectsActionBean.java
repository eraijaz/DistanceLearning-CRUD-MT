package com.actionbeans.student;

import java.sql.*;
import java.util.Vector;

import com.beans.BeanClass;
import com.database.Dao;

public class StudentShowSubjectsActionBean {

			private BeanClass bean;
			private Connection connection;
			private PreparedStatement prepare;
			private ResultSet resultset;
			private ResultSetMetaData metadata;

			private Vector<Object>  row = null;
			private Vector<Vector<Object>>  data = null;
			
			private String getCourseQuery="select * from student_admission where reg_no=?";
			private String showSubjectQuery="select * from subject where course=? order by sem asc";
			
		public StudentShowSubjectsActionBean(BeanClass bean)
		{
			this.bean = bean;
			connection = Dao.getConnect();
			data = new Vector<Vector<Object>>();
		}
		
		public Vector<Vector<Object>> ShowSubjects()
		{
			try
			{
			prepare = connection.prepareStatement(getCourseQuery);
			prepare.setLong(1, bean.getReg_no());
			resultset = prepare.executeQuery();
		
					while(resultset.next())
					{
						if(resultset.getLong(1)==bean.getReg_no())
						{
							String course = resultset.getString(6).toString();
							System.out.println("Hiiiiii");
							System.out.println("course is "+course);
							resultset=null;
							
							prepare = connection.prepareStatement(showSubjectQuery);
							prepare.setString(1, course);
							resultset = prepare.executeQuery();					
							metadata = resultset.getMetaData();
							int cols = metadata.getColumnCount();
							
							while(resultset.next())
							{
								System.out.println("while loop of sub");
								row  = new Vector<Object>();
									for(int i=1;i<=cols;i++)
									{		
										
									row.addElement(resultset.getObject(i));
									}
								
								data.addElement(row);
							}
							}
								
						}
					

			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return data;
		}

	
	
}

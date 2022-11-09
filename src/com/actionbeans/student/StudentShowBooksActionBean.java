package com.actionbeans.student;

import java.sql.*;
import java.util.ArrayList;


import com.beans.BeanClass;
import com.database.Dao;

public class StudentShowBooksActionBean {
	
			private BeanClass bean;
			private Connection connection;
			private PreparedStatement prepare;
			
			private ResultSet resultset=null;
			private ResultSet resultSet2=null;
			private ArrayList<Object> list= new ArrayList<Object>();
			
			private String getCourseQuery="select * from student_admission where reg_no=?";
			private String selectQueryBySem= "select * from library where course=? and sem=?";
			private String selectQueryBySubject="select * from library where course=? and sub_code=? order by sem";
			private String getSubCodQuery="select distinct subject,sub_code from library where course=?";
			private String course;
	
			
			public StudentShowBooksActionBean(BeanClass bean)
			{
				this.bean = bean;
				connection=Dao.getConnect();
			}
			
			
			public ArrayList<Object> BooksBySem()
			{
				
				try{
						prepare = connection.prepareStatement(getCourseQuery);
						prepare.setLong(1, bean.getReg_no());
						
						resultset = prepare.executeQuery();
							while(resultset.next())
							{
								System.out.println("RegNo "+resultset.getLong(1));
								System.out.println("Semester "+bean.getSem());
								
								if(resultset.getLong(1)==bean.getReg_no())
								{
									 course = resultset.getString(6).toString();
									
										prepare =connection.prepareStatement(selectQueryBySem);
										prepare.setString(1, course);
										prepare.setInt(2,bean.getSem());
																	
										resultSet2 = prepare.executeQuery();	
									System.out.println("query executed");		
									
										while(resultSet2.next())
										{
											list.add(resultSet2.getObject(1));
											list.add(resultSet2.getObject(2));
											list.add(resultSet2.getObject(3));
											list.add(resultSet2.getObject(4));
											list.add(resultSet2.getObject(5));
											list.add(resultSet2.getObject(6));
											list.add(resultSet2.getObject(7));
											System.out.println("list added");
										}
																		
								}
							}
				}
	
				     
						catch(Exception e)
							{
								e.printStackTrace();
							}
				return list;
				
			}
			

			public ArrayList<Object> BooksBySubject()
			{
				
				System.out.println("fn called");
				try{
						prepare = connection.prepareStatement(getCourseQuery);
						prepare.setLong(1, bean.getReg_no());
						
						resultset = prepare.executeQuery();
						
							while(resultset.next())
							{
								if(resultset.getLong(1)==bean.getReg_no())
								{
									 course = resultset.getString(6).toString();
																		
										prepare =connection.prepareStatement(selectQueryBySubject);
										prepare.setString(1, course);
										prepare.setString(2,bean.getSub_code());
									
										resultSet2 = prepare.executeQuery();	
										System.out.println("query executed");		
										
											while(resultSet2.next())
											{
												list.add(resultSet2.getObject(1));
												list.add(resultSet2.getObject(2));
												list.add(resultSet2.getObject(3));
												list.add(resultSet2.getObject(4));
												list.add(resultSet2.getObject(5));
												list.add(resultSet2.getObject(6));
												list.add(resultSet2.getObject(7));
												System.out.println("list added");
											}
								}
							
							}
				     }
							catch(Exception e)
							{
								e.printStackTrace();
							}
				
				return list;
			}

			
			public ResultSet getSubCode()
			{
				try{
				prepare=connection.prepareStatement(getSubCodQuery);
				prepare.setString(1, bean.getCourse());
				
				resultset=prepare.executeQuery();
				}
				catch(Exception exception)
				{
					exception.printStackTrace();
				}	
				return resultset;
			}

}
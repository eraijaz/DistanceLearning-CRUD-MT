package com.actionbeans.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.database.Dao;
import com.actionbeans.login.PasswordGenerationActionBean;
import com.beans.BeanClass;

public class StudentAdmissionActionBean {

	
				private BeanClass student;
				private Connection connection;
				private PreparedStatement prepare;
				private int result;
				private boolean flag;
				private ResultSet resultset;
				private String password;
				
				private String setQuery="select max(reg_no) from student_admission where batch=? and course=?";
				private String insertQuery="insert into student_admission values(?,?,?,?,?,?,?,?,?,?,?)";
				
				private String showPswrdQuery="select * from student_admission where reg_no =?";
				
				public StudentAdmissionActionBean(BeanClass student)
				{
					this.student  = student;
					connection = Dao.getConnect();
					password= PasswordGenerationActionBean.getPassword();
				}
				
				public boolean insert()
				{
						try{
							
							prepare= connection.prepareStatement(setQuery);
							prepare.setString(2,student.getCourse());
							prepare.setInt(1, student.getBatch());
							resultset = prepare.executeQuery();
							
							if(resultset.next())
							{
								Long reg_no= resultset.getLong(1);
								reg_no=reg_no+1;
								student.setReg_no(reg_no);
								flag= true;
							}
							else{
								flag=false;
							}
							
							
							prepare  = connection.prepareStatement(insertQuery);
							
							prepare.setLong(1, student.getReg_no());
							prepare.setString(2,student.getFname());
							prepare.setString(3,student.getLname() );
							prepare.setString(4,student.getGender());
							prepare.setInt(5,student.getBatch());
							prepare.setString(6,student.getCourse());
							prepare.setString(7,student.getQualification());
							prepare.setFloat(8, student.getMarks());
							prepare.setString(9,student.getContact());
							prepare.setString(10, student.getMailid());
							prepare.setString(11,password);
							
							result = prepare.executeUpdate();
							if(result==1)
							{
								flag = true;
								
									prepare = connection.prepareStatement(showPswrdQuery);
									prepare.setLong(1, student.getReg_no());
									
									resultset = prepare.executeQuery();
									while(resultset.next())
										{
											System.out.println("regno "+resultset.getLong(1));
											System.out.println("passwrd "+resultset.getString(11));
											
											student.setReg_no(resultset.getLong(1));
											student.setPassword(resultset.getString(11));
										}
								
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
				
}

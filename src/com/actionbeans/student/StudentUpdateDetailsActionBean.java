package com.actionbeans.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.beans.BeanClass;
import com.database.Dao;

public class StudentUpdateDetailsActionBean {
	
	
	private BeanClass bean =new BeanClass();
	private Connection connection=null;
	private PreparedStatement prepare=null;
	private ResultSet  resultset=null;
	private boolean flag;
	private Integer result;
	
	private String getInfoQuery="select * from student_profile where reg_no=?";
	private String insertQuery="update student_profile set father_name=?, address=?, dob=?, question =?, answer =? where reg_no=? and firstname=?";
	private String searchQuery="select * from student_profile where reg_no=?";
	private String updateQuery="update student_profile set contact=?,mailid=?,address=?,question=?,answer=? where reg_no=? and firstname=?";
   
public StudentUpdateDetailsActionBean(BeanClass bean)
	{
		this.bean=bean;
		connection=Dao.getConnect();
	}
   
   public boolean getInfo()
   {
	   try
		{
		   
		prepare = connection.prepareStatement(getInfoQuery);
		prepare.setLong(1, bean.getReg_no());
		resultset = prepare.executeQuery();
		System.out.println("method");
		while(resultset.next())
		{
			if(resultset.getString(12).length()==1 && resultset.getString(13).length()==1 && resultset.getString(14).length()==1 && resultset.getString(16).length()==1 )
						
					{
						System.out.println("flag true");
						flag=true;
						System.out.println("f name is null ");
					}
					
					else
					{
						System.out.println("f name is not null ");
						System.out.println("flag false");
						
						flag=false;
					}
				}
		
		}
		catch(Exception exception){
			exception.printStackTrace();
			}
	   return flag;
   }

   public boolean profile()
	{
			try{
				 
				prepare  = connection.prepareStatement(insertQuery);
				
				prepare.setString(1,bean.getFathername());
				prepare.setString(2,bean.getAddress());
				prepare.setString(3,bean.getDob());
				prepare.setString(4,bean.getQuestion());
				prepare.setString(5,bean.getAnswer());
				prepare.setLong(6, bean.getReg_no());
				prepare.setString(7, bean.getFname());
				
				result = prepare.executeUpdate();
				System.out.println("result "+result);
				if(result>0)
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

   public BeanClass ViewRecord()
	{
	long id = bean.getReg_no();
		System.out.println("bean object"+bean.getReg_no());
	try 
	{
		prepare = connection.prepareStatement(searchQuery);
		prepare.setLong(1,id);
		
		System.out.println("Function");
		resultset = prepare.executeQuery();
			
		
			System.out.println("Resultset set");
	
			while(resultset.next())
			{
				if(resultset.getLong(1)==id)
				{
					System.out.println("kiran here...");
				System.out.println("reg no"+resultset.getLong(1));
				System.out.println("reg no"+resultset.getString(2));
				
				bean.setReg_no(resultset.getLong(1));
				bean.setFirstname(resultset.getString(2));
				bean.setLastname(resultset.getString(3));
				bean.setGender(resultset.getString(4));
				bean.setBatch(resultset.getInt(5));
				bean.setCourse(resultset.getString(6));
				bean.setPrev_qual(resultset.getString(7));
				bean.setPrev_marks(resultset.getString(8));
				bean.setContact(resultset.getString(9));
				bean.setMailid(resultset.getString(10));
				bean.setFather_name(resultset.getString(12));
				bean.setAddress(resultset.getString(13));
				bean.setDob(resultset.getString(14));
				bean.setQuestion(resultset.getString(15));
				bean.setAnswer(resultset.getString(16));
				
				}
				else
				{
					System.out.println("record not found");
				}
			}	
	}
	catch (Exception e) 
	{
		e.printStackTrace();
	}
	return bean;	
}

   public boolean updateRecord()
{
	try 
	{
		prepare=connection.prepareStatement(updateQuery);
		prepare.setString(1, bean.getContact());
		prepare.setString(2, bean.getMailid());
		prepare.setString(3, bean.getAddress());
		prepare.setString(4, bean.getQuestion());
		prepare.setString(5, bean.getAnswer());
		prepare.setLong(6, bean.getReg_no());
		prepare.setString(7, bean.getFirstname());
		result = prepare.executeUpdate();
		if(result==1)
		{
			System.out.println("if");
			flag = true;
		}
		else{
			System.out.println("else..");
			flag = false;
		}
	} 
	catch (Exception e)
	{
	e.printStackTrace();	
	}
	return flag;

}

}

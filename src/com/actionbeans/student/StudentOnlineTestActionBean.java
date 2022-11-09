package com.actionbeans.student;

import java.sql.*;

import com.beans.BeanClass;
import com.database.Dao;

public class StudentOnlineTestActionBean {

	
	private BeanClass bean;
	private Connection connection;
	private PreparedStatement prepare;
	private ResultSet resultset;
	private boolean flag;
	
	private String selectQuery="select * from exam_ques where sub_code=?";
	private String checkansQuery="select * from exam_ques where sub_code=? && exam_ques=?";
	private String getPaperIdQuery="select subject,sub_code,paper_id from subject where sub_code=? && course=?";
	private String getSubCode="select subject, sub_code from subject where course=?";
	private String saveResultQuery="insert into student_result values(?,?,?,?,?,?,?,?)";
	public StudentOnlineTestActionBean(BeanClass bean)
	{
		this.bean=bean;
		connection=Dao.getConnect();
	}
	
	public ResultSet onlineTest()
	{
		try{
			
			prepare=connection.prepareStatement(selectQuery);
			prepare.setString(1, bean.getSub_code());
			resultset=prepare.executeQuery();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return resultset;
	}
	
	public ResultSet getPaperId()
	{
		try{
			System.out.println("fn called");
			prepare=connection.prepareStatement(getPaperIdQuery);
			prepare.setString(1, bean.getSub_code());
			prepare.setString(2, bean.getCourse());
			resultset=prepare.executeQuery();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return resultset;
	}
	
	public boolean CheckAns()
	{
		try{
			
			prepare=connection.prepareStatement(checkansQuery);
			prepare.setString(1, bean.getSub_code());
			prepare.setString(2, bean.getExam_ques());
			System.out.println("Sub Code "+bean.getSub_code());
			resultset=prepare.executeQuery();
			
			while(resultset.next())
			{
				System.out.println("given ans "+bean.getAnswer());
				System.out.println("right ans "+resultset.getString(7));
				if(resultset.getString(7).equalsIgnoreCase(bean.getAnswer()))
				{
					bean.setAnswer(bean.getAnswer());
					bean.setRight_ans(resultset.getString(7));
					flag=true;
				}
				else
				{
					bean.setAnswer(bean.getAnswer());
					bean.setRight_ans(resultset.getString(7));
					flag=false;
					
				}
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
		prepare.setString(1, bean.getCourse());
		
		resultset=prepare.executeQuery();
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}	
		return resultset;
	}
	
	public boolean saveResult()
	{
		try{
			prepare=connection.prepareStatement(saveResultQuery);
			prepare.setLong(1, bean.getReg_no());
			prepare.setString(2, bean.getFirstname());
			prepare.setString(3, bean.getLastname());
			prepare.setInt(4, bean.getBatch());
			prepare.setString(5, bean.getCourse());
			prepare.setString(6, bean.getSub_code());
			prepare.setString(7, bean.getSub_name());
			prepare.setFloat(8, bean.getResult_percentage());
			
			int result=prepare.executeUpdate();
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
}

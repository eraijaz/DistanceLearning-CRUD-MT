package com.actionbeans.login;

import java.sql.*;

import com.beans.BeanClass;
import com.database.Dao;

public class ResetPasswordActionBean {

		private BeanClass bean;
		private Connection connection;
		private PreparedStatement prepare;
		private int result;
		private boolean flag;
		private ResultSet resultset;
		
		private String stuChangePwdQuery = "update student_profile set password=? where reg_no=? and password=? ";
		private String admChangepwdQuery="update admin_details set password=? where username=? and password=?";
		private String selectQuery="select * from student_profile where reg_no=?";
	 	private String resetPwdQuery="update student_profile set password=? where reg_no=?";
		
		public ResetPasswordActionBean(BeanClass bean)
		{
				this.bean = bean;
				connection=Dao.getConnect();
		}
		public boolean admChangePassword()
		{
			try{
				prepare = connection.prepareStatement(admChangepwdQuery);
				prepare.setString(1, bean.getNewpwd());
				prepare.setString(2, bean.getUsername());
				prepare.setString(3, bean.getOldpwd());
				
				result = prepare.executeUpdate();
				{
					if(result==1)
					{
						flag=true;
					}
					
					else
					{
						flag=false;
					}
					
				}
			}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				return flag;

		}
		
		public boolean stuChangePassword()
		{
			try{
			prepare = connection.prepareStatement(stuChangePwdQuery);
			prepare.setString(1, bean.getNewpwd());
			prepare.setString(2, bean.getUsername());
			prepare.setString(3, bean.getOldpwd());
			
			result = prepare.executeUpdate();
			{
				if(result==1)
				{
					flag=true;
				}
				
				else
				{
					flag=false;
				}
				
			}
		}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			return flag;
		}
		
		public BeanClass stuGetAns()
	 	{	
	 		try{
	 			Long reg_no = Long.parseLong(bean.getUsername());
	 			prepare = connection.prepareStatement(selectQuery);
	 			prepare.setLong(1,reg_no);
	 			
	 			System.out.println("hello "+reg_no);
	 			resultset = prepare.executeQuery();
	 			
	 			System.out.println("Resultset set");
	 				 			
					while(resultset.next())
					{
						if(resultset.getLong(1)==reg_no)
						{
							bean.setUsername(reg_no.toString());
							bean.setFirstname(resultset.getString(2));
							bean.setLastname(resultset.getString(3));
							bean.setQuestion(resultset.getString(15));
							bean.setAnswer(resultset.getString(16));
						}
						else
						{
							bean.setFirstname(null);
						}
					}
	 			
	 		}
	 		catch(Exception exception)
	 		{
	 			exception.printStackTrace();
	 		}
	 		return bean;
	 	}
	 	
	 	public boolean resetPwd()
	 	{
	 		try{
	 			
	 		Long reg_no = Long.parseLong(bean.getUsername());
	 		
	 		System.out.println("usrname "+reg_no);
 			prepare = connection.prepareStatement(resetPwdQuery);
 			prepare.setString(1, bean.getNewpwd());
 			prepare.setLong(2,reg_no);
 			
 			int result = prepare.executeUpdate();
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

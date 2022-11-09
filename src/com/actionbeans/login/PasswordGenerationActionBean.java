package com.actionbeans.login;

import java.util.Random;

public class PasswordGenerationActionBean
{

	static Random random = new Random();
	static String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	static char pass;
	static String test="";
	static int number= str.length();
	static int num;
	
	 public static String getPassword()
		 {
			try 
			{
				test="";
				for (int i=0;i<10;i++)
				{
					num = random.nextInt(number);
					pass = str.charAt(num);
					test = test + pass;
				}
				System.out.println("password "+test);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return test;
		}
}

package com.database;

import java.sql.Connection;
import java.sql.DriverManager;

	public class Dao {
		
		private static String driverclass  =  "com.mysql.jdbc.Driver";
        private static String url          =  "jdbc:mysql://localhost:3306/";
		private static String database     =  "distance_learning";
		private static String username     =  "root";
		private static String password     =  "root";
		private static Connection connection;
		
		
		public static Connection getConnect()
		{
			try{
						Class.forName(driverclass);
						connection = DriverManager.getConnection(url+database,username,password);
						System.out.println("Connection created..");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return connection;
		}
}
package com.htc.LoadAndUnload.dbconnection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnector 
{
private static Connection con;
	
	public static Connection getConnection() throws SQLException, IOException {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\ravichandra\\Documents\\Load_Unload\\src\\db_info.properties");
		
		Properties prop = new Properties();
		
		prop.load(fis);
		
		String url = prop.getProperty("url");
		String host = prop.getProperty("host");
		String portnumber = prop.getProperty("portnumber");
		String database = prop.getProperty("database");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		//System.out.println(prop.getProperty("connection"));
		con = DriverManager.getConnection(url+"://"+host+":"+portnumber+"/"+database,username,password);
		return con;	
	}
}

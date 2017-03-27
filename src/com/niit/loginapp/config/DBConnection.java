package com.niit.loginapp.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
private static String  id="sa";
private static String  password="";
private static String  url="jdbc:h2:~/test";
private static String  driver="org.h2.Driver";


public static Connection  getDBConnection()
{
	Connection con=null;
	//load the driver
try {
	Class.forName(driver);
	con= DriverManager.getConnection(url, id, password);
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
catch(SQLException e)
{
	e.printStackTrace();
}
	return con;
}
public static void main(String[] args) {
	if(getDBConnection()==null)
	{
		System.out.println("could not connect to database");
	}
	else
	{
		System.out.println("sucessfully connected to database");
	}
		
}



}

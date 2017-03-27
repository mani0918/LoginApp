package com.niit.loginapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.niit.loginapp.config.DBConnection;

public class LoginDao {

	//write simple method which takes two parameters and return true or false
	
	
	public boolean isValidCredentials(String id, String password)
	{
		//get the connection
		Connection con = DBConnection.getDBConnection();
		//write query
		try {
			PreparedStatement pStatement = con.prepareStatement("Select * from Tuser where id=? and password=?");
			
			pStatement.setString(1, id);
			pStatement.setString(2, password);
			
			//execute query
			ResultSet resultset= pStatement.executeQuery();
			
			if(resultset.next())
			{
				return true;
			}
			else{
				return false;
			}
			
			
		
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if(id.equals("niit") && password.equals("niit"))
		{
			return true;
		}
		else
		{
			return false;
		}
		//temporarily assuming that id and password is niit
		
		
	}
	public void getAllUsers()
	{
		Connection con = DBConnection.getDBConnection();
		try{
			Statement statement = con.createStatement();
			ResultSet resultset = statement.executeQuery("select * from Tuser");
		}
		while()
		
	}
	
}

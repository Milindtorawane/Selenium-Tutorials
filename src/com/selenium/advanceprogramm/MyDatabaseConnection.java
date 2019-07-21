package com.selenium.advanceprogramm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

//Write a programm for database  connection 
public class MyDatabaseConnection {
	
	@Test
	public void myDbconnection() throws SQLException, Exception{
		
		//Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"		
        String dbUrl = "jdbc:mysql://localhost:3306/pa_data";					

		//Database Username	 //QA_User	
		String username = "root";
		
		//Database Password		
		String password = "root";				

		//Query to Execute		
		String query = "select * from customerinfo";
		
		String text="MJ05004";
		String query2 = "INSERT INTO courtoffice(OfficeID)VALUES('"+text+"')";
        
 	    //Load mysql jdbc driver		
   	    Class.forName("com.mysql.jdbc.Driver");			
   
   		//Create Connection to DB		
    	Connection con = DriverManager.getConnection(dbUrl,username,password);
  
  		//Create Statement Object		
	   Statement stmt = con.createStatement();					

			// Execute the SQL Query. Store results in ResultSet		
 		 stmt.executeUpdate(query2);							
 
 		
 		/*
 		
 		// While Loop to iterate through all data and print results		
		while (rs.next())
		{
	        		String myName = rs.getString(1);								        
                    String myAge = rs.getString("MobNo");			                               
                    System. out.println(myName+"  "+myAge);	
		
		}	
		
		*/
		
	}   
	

}

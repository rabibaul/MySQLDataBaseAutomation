package com.RH.mysqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class Top5countries {
	
	@Test

	public static void dbconnectionTop() throws SQLException {
		
		
		//Create a connection
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee","root","monrabi2017");
		System.out.println("\nTOP 5 records from countries Table:\n");
		
		//Create a statement/query 
		Statement stmt=con.createStatement();
		// Write Query
		String query="SELECT * FROM countries LIMIT 5";
		
		//Execute query
		ResultSet rSet=stmt.executeQuery(query);
		
		System.out.println("country_id"+"\t"+"country_name"+"\t"+"region_id");
		
	
			while (rSet.next()) {
				System.out.println(rSet.getString("country_id") + "\t\t" + 
								rSet.getString("country_name") + "\t\t" + 
								rSet.getInt("region_id"));
			}
         con.close();
		
	}

}

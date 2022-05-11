package com.RH.mysqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class Top5departments {
	
	@Test
public static void dbconnection() throws SQLException {
		
		
		//Create a connection
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee","root","monrabi2017");
		System.out.println("\nTOP 5 records from departments Table:\n");
		
		//Create a statement/query 
		Statement stmt=con.createStatement();
		// Write Query
		String query="SELECT * FROM departments LIMIT 5";
		
		//Execute query
		ResultSet rSet=stmt.executeQuery(query);
		
		System.out.println("department_id"+"\t"+"department_name"+"\t"+"location_id");
		
	
			while (rSet.next()) {
				System.out.println(rSet.getString("department_id") + "\t\t" + 
								rSet.getString("department_name") + "\t\t" + 
								rSet.getInt("location_id"));
			}
         con.close();
		
	}

}

package com.RH.mysqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class Top5locations {
	
	@Test
public static void dbconnection() throws SQLException {
		
		
		//Create a connection
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee","root","monrabi2017");
		System.out.println("\nTOP 5 records from locations Table:\n");
		
		//Create a statement/query 
		Statement stmt=con.createStatement();
		// Write Query
		String query="SELECT * FROM locations LIMIT 5";
		
		//Execute query
		ResultSet rSet=stmt.executeQuery(query);
		
		System.out.println("location_id"+"\t"+"street_address"+"\t\t"+"postal_code"+"\t\t"+"city"+"\t\t\t"+"state_province"+"\t\t"+"country_id");
		
	
			while (rSet.next()) {
				System.out.println(rSet.getInt("location_id") + "\t\t" + 
								rSet.getString("street_address") + "\t\t" + 
								rSet.getString("postal_code") + "\t\t" +
								rSet.getString("city") + "\t\t" +
								rSet.getString("state_province") + "\t\t" +
								rSet.getString("country_id"));
			}
         con.close();
		
	}


}

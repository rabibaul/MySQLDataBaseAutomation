package com.RH.mysqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class Top5employees {
	
	@Test
	public static void dbconnection() throws SQLException {
			
			
			//Create a connection
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee","root","monrabi2017");
			System.out.println("\nTOP 5 records from employees Table:\n");
			
			//Create a statement/query 
			Statement stmt=con.createStatement();
			// Write Query
			String query="SELECT * FROM employees LIMIT 5";
			
			//Execute query
			ResultSet rSet=stmt.executeQuery(query);
			
			System.out.println("employee_id"+"\t"+"first_name"+"\t"+"last_name"+"\t\t"+"email"+"\t\t\t\t"+"phone_number"+"\t\t"+"hire_date"+"\t\t"+"job_id"
			+"\t\t"+"salary"+"\t\t"+"manager_id"+"\t\t"+"department_id");
			
		
				while (rSet.next()) {
					System.out.println(rSet.getString("employee_id") + "\t\t" + 
									rSet.getString("first_name") + "\t\t" +
									rSet.getString("last_name") + "\t\t" +
									rSet.getString("email") + "\t\t" +
									rSet.getString("phone_number") + "\t\t" +
									rSet.getString("hire_date") + "\t\t" +
									rSet.getString("job_id") + "\t\t" +
									rSet.getString("salary") + "\t\t" +
									rSet.getString("manager_id") + "\t\t" +
									rSet.getInt("department_id"));
				}
	         con.close();
			
		}


}

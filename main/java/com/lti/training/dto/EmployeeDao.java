package com.lti.training.dto;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

//Data Access Object
public class EmployeeDao {

	public void add(Employee emp) {

		Connection conn = null;
		PreparedStatement pstmt = null; // pre compiled sql statements
		ResultSet rs = null;
		

		try {
		
			
			//code for intializing the variables
			//why not FileInputStream is =new FileInputStream("dev-db.properties");  
			InputStream is=this.getClass().getClassLoader().getResourceAsStream("dev-db.properties");
			
			Properties dbProps=new Properties();
			dbProps.load(is);
			
			//done for not hard coding the db credentials
			String driverClassName=dbProps.getProperty("driverClassName");
			String url=dbProps.getProperty("url");
			String username=dbProps.getProperty("username");
			String password=dbProps.getProperty("password");
			
			
			//using the dev-db-properties
			Class.forName(driverClassName);
			conn = DriverManager.getConnection(url,username,password);
			System.out.println("it is inserting records now");
			pstmt = conn.prepareStatement("insert into EMPLOYEE13 values(?,?,?)"); // preparing the query to be inserted
			System.out.println("hello");

			pstmt.setInt(1, emp.getEmpno());
			pstmt.setString(2, emp.getName());
			pstmt.setDouble(3, emp.getSalary());
			rs = pstmt.executeQuery();
			// pstmt.executeUpdate(); // any DML statement
		} catch (Exception e1) {
			e1.printStackTrace();
			System.out.println("Problem while inserting employee data");
		}

		finally {
			try {

				rs.close();
				pstmt.close();
			} catch (Exception e) {
			}
			try {
				conn.close();
			}

			catch (Exception e) {
			}
		}
	}
}

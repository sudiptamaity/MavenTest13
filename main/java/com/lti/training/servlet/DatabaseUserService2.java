package com.lti.training.servlet;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//Data Access Object
public class DatabaseUserService2 {

	public void add(String empno, String name, String salary) {

		Connection conn = null;
		PreparedStatement pstmt = null; // pre compiled sql statements
		ResultSet rs = null;
		System.out.println("melissa");

		try {
			System.out.println("sdjasda ");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("it ");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			System.out.println("it is inserting records now");
			pstmt = conn.prepareStatement("Insert into EMPLOYEE values(?,?,?)"); // preparing the query to be inserted
			System.out.println("hello");
			pstmt.setString(1, empno);
			pstmt.setString(2, name);
			pstmt.setString(3, salary);

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

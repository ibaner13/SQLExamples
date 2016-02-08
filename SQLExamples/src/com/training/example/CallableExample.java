package com.training.example;

import java.sql.*;

public class CallableExample {

	public static void main(String[] args) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:system/ruchi@localhost:1521:XE";
			Connection con = DriverManager.getConnection(url);
			CallableStatement stmt = con.prepareCall("Call updatePhoneNumber(?,?)");
			stmt.setInt(1,  105);
			stmt.setInt(2, 9886459);
			stmt.execute();
			System.out.println("Thanks for updating Phone Number");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

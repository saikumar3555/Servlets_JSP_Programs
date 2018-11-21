package com.nit;
import java.sql.*;
public class DBConnection {
	public static Connection con;

	private DBConnection() {
	}

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
		} catch (Exception e) {e.printStackTrace();
		}

	}

	public static Connection getCon() {
		return con;

	}
}

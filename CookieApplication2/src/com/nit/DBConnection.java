package com.nit;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	private static Connection con;

	private DBConnection() {
	}

	static {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
     public static Connection getCon() {
    	 return con;
     }
	/*public static Connection getCon(String connectionURL, String dbUser , String dbPword) {
		try {
			con = DriverManager.getConnection(connectionURL, dbUser ,dbPword );
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
*/	}


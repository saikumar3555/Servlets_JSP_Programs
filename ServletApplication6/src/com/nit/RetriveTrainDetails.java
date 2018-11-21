package com.nit;

import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class RetriveTrainDetails extends GenericServlet {
	public static Connection con;
	public void init()throws ServletException{
		con=DBConnection.getCon();
	}
	public void service(ServletRequest req,ServletResponse res) {
		try {
	PrintWriter pw = res.getWriter();
	res.setContentType("text/html");
	String Tnumber = req.getParameter("Tnumber");
	    
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		//Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		
		PreparedStatement ps = con.prepareStatement("select* from Train11 where Train_no=?");
		ps.setString(1,Tnumber);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			pw.println(""+rs.getString(1));
			pw.println(""+rs.getString(2));
			pw.println(""+rs.getString(3));
			pw.println(""+rs.getString(4));
			pw.println(""+rs.getInt(5));
		}else {
		pw.println("Invaid Train Number....");	
		}
	}catch(Exception e) {e.printStackTrace();
	
	}
	}
}

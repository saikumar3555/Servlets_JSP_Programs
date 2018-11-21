package com.nit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class UpdateTrain11Details extends GenericServlet {
	public void service(ServletRequest req,ServletResponse res)throws IOException,ServletException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String trainnumber=req.getParameter("trainnumber");
		String trainname=req.getParameter("trainname");
		String fromstation=req.getParameter("fromstation");
		String tostation=req.getParameter("tostation");
		int seats=Integer.parseInt(req.getParameter("seats"));
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			PreparedStatement ps = con.prepareStatement("insert into Train11 values(?,?,?,?,?)");
			ps.setString(1, trainnumber);
			ps.setString(2, trainname);
			ps.setString(3, fromstation);
			ps.setString(4, tostation);
			ps.setInt(5,seats);
			int k = ps.executeUpdate();
			if (k > 0) {
				pw.println("Train11 details are updated Successfully...");
			}
		}
		catch(Exception e) {e.printStackTrace();}
		
		
		
	}

}

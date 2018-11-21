package com.nit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginServlet extends GenericServlet {
	public Connection con;

	public void init() throws ServletException {
		con= DBConnection.getCon();
	}

	public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		//res.setContentType("text/html");
		String uname=req.getParameter("uname");
		String pword=req.getParameter("pword");
		try {
			PreparedStatement ps=con.prepareStatement("select * from productreg13 where uname=? and pword=?");
			ps.setString(1,uname);
			ps.setString(2,pword);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				RequestDispatcher rd=req.getRequestDispatcher("/product.html");
				rd.forward(req,res);
				return;
			}
			else 
			{
				pw.println("Invalid username or password...");
				RequestDispatcher rd=req.getRequestDispatcher("login.html");
				rd.include(req,res);
			}
			
		}catch(Exception e) {e.printStackTrace();}
		
	}

}

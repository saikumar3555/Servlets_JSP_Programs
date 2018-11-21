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

public class AddServlet extends GenericServlet {
	public Connection con;
	public void init()throws ServletException
	{
		con=DBConnection.getCon();
	}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	   PrintWriter pw=res.getWriter();
	   res.setContentType("text/html");
	   String tno=req.getParameter("tno");
	   String tname=req.getParameter("tname");
	   String fstation=req.getParameter("fstation");
	   String tstation=req.getParameter("tstation");
	   int avl=Integer.parseInt(req.getParameter("avl"));
	   try {
		   PreparedStatement ps=con.prepareStatement("insert into  train13 values(?,?,?,?,?)");
		   ps.setString(1, tno);
		   ps.setString(2, tname);
		   ps.setString(3, fstation);
		   ps.setString(4, tstation);
		   ps.setInt(5, avl);
		   int k=ps.executeUpdate();
		   if(k>0) {
			   pw.println("Train Details Updated...");
			   RequestDispatcher rd=req.getRequestDispatcher("Homepage.html");
			   rd.include(req, res);
			   
		   }else {
			   pw.println("please Enter Valid Details...");
			   RequestDispatcher rd=req.getRequestDispatcher("Add.html");
			   rd.include(req, res);
			   
		   }
	   }catch(Exception e) {e.printStackTrace();}
		
	}
	

}

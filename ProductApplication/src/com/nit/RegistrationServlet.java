package com.nit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class RegistrationServlet extends GenericServlet{
	public static Connection con;
	public void init()throws ServletException
	{
		con=DBConnection.getCon();
	}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	 PrintWriter pw=res.getWriter();
	 //res.setContentType("text/html");
	 String uname=req.getParameter("uname");
	 String pword=req.getParameter("pword");
	 String fname=req.getParameter("fname");
	 String lname=req.getParameter("lname");
	 String addr=req.getParameter("addr");
	 String phno=req.getParameter("phno");
	 String mid=req.getParameter("mid");
	 try {
		 PreparedStatement ps=con.prepareStatement("insert into productreg13 values(?,?,?,?,?,?,?)");
		 ps.setString(1,uname);
		 ps.setString(2,pword);
		 ps.setString(3,fname);
		 ps.setString(4,lname);
		 ps.setString(5,addr);
		 ps.setString(6,phno);
		 ps.setString(7,mid);
		 int k=ps.executeUpdate();
		 if(k>0) {
			 pw.println("user registration successfull.....");
			 RequestDispatcher rd=req.getRequestDispatcher("login.html");
			 rd.include(req, res);
		 }
	 }catch(Exception e) {e.printStackTrace();}	 
		
	}
	

}

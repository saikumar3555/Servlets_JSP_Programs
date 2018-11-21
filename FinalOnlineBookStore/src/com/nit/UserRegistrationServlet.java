package com.nit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserRegistrationServlet extends HttpServlet {
	public Connection con;
	public void init()throws ServletException{
	con=DBConnection.getCon();	
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/hml");
		String uname=req.getParameter("uname");
		String pword=req.getParameter("pword");
		String fname=req.getParameter("fname");
		String lname=req.getParameter("lname");
		String addr=req.getParameter("addr");
		String phno=req.getParameter("phno");
		String mid=req.getParameter("mid");
		try {
			PreparedStatement ps=con.prepareStatement("insert into userreg13 values(?,?,?,?,?,?,?)");
			ps.setString(1,uname);
			ps.setString(2,pword);
			ps.setString(3,fname);
			ps.setString(4,lname);
			ps.setString(5,addr);
			ps.setString(6,phno);
			ps.setString(7,mid);
			int k=ps.executeUpdate();
			if(k>0) {
				pw.println("<font color='lightgreen'>User Registration Succesfull.....</font>");
				RequestDispatcher rd=req.getRequestDispatcher("UserLogin.html");
				rd.include(req, res);
			}else {
				pw.println("please fill the Fields...");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}


package com.nit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminLoginServlet extends HttpServlet {
	public Connection con;

	public void init() throws ServletException {
		con = DBConnection.getCon();
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String uname=req.getParameter("uname");
		String pword=req.getParameter("pword");
		try {
			PreparedStatement ps=con.prepareStatement("select * from AdminReg23 where uname=? and pword=?");
			ps.setString(1, uname);
			ps.setString(2, pword);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				pw.println("Welcome : "+uname);
				Cookie ck1=new Cookie("Auname",uname);
				res.addCookie(ck1);
				Cookie ck2=new Cookie("Apword",pword);
				res.addCookie(ck2);
				RequestDispatcher rd=req.getRequestDispatcher("AdminHomepage.html");
				rd.include(req,res);
			}else {
				pw.println("Invalid Username or Password");
				RequestDispatcher rd=req.getRequestDispatcher("AdminLogin.html");
				rd.include(req,res);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}

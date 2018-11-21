package com.nit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminLogoutServlet extends HttpServlet{
	public Connection con;
	public void init() throws ServletException {
		con = DBConnection.getCon();
	}
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		RequestDispatcher rd=req.getRequestDispatcher("StartingPage.html");
		rd.include(req, res);
		Cookie ck1=new Cookie("Auname", "");
		ck1.setMaxAge(0);
		res.addCookie(ck1);
		Cookie ck2=new Cookie("Apword","");
		ck2.setMaxAge(0);
		res.addCookie(ck2);
		pw.println("You are Logged out Successfully...");
		
	}
}

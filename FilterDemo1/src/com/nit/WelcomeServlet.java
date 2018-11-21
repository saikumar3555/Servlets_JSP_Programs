package com.nit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class WelcomeServlet extends HttpServlet {
	public Connection con;
	
	public void init()throws ServletException{
		con=DBConnection.getCon();
	}

	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String uname=req.getParameter("uname");
		pw.println("Welcome:"+uname);
	}
}

package com.nit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Login extends GenericServlet{
	public Connection con;
	 public String uname;
	public String pword;
public ServletContext context;
public LoginBean lb;
	public void init() throws ServletException {
		con= DBConnection.getCon();
		 context=this.getServletContext();
		 lb=new LoginBean();
		 
	}

	public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		 uname=req.getParameter("uname");
		 pword=req.getParameter("pword");
		 lb.setUname(uname);
		 lb.setPword(pword);
		 context.setAttribute("beanref", lb);
		try {
			PreparedStatement ps=con.prepareStatement("select * from bookreg13 where uname=? and pword=?");
			ps.setString(1,uname);
			ps.setString(2,pword);
			
			
			
			context.setAttribute("uname",uname);
			context.setAttribute("pword",pword);
			
			
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				RequestDispatcher rd=req.getRequestDispatcher("Options.html");
				rd.forward(req,res);
				return;
			}
			else 
			{
				pw.println("<font color='red'>Invalid username or password...</font>");
				RequestDispatcher rd=req.getRequestDispatcher("Login.html");
				rd.include(req,res);
			}
			
		}catch(Exception e) {e.printStackTrace();}
		
	}

}


package com.nit;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class RegFinalServlet extends GenericServlet{
	public ServletContext context;
	public RegBean rb;
	public Connection con;
	public void init()throws ServletException
	{
		
		context=this.getServletContext();
		
		rb=(RegBean)context.getAttribute("beanref");
		con=DBConnection.getCon();
	}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		try {
			PreparedStatement ps=con.prepareStatement("insert into userreg13 values(?,?,?,?,?,?,?)");
			ps.setString(1,rb.getUname());
			ps.setString(2,rb.getPword());
			ps.setString(3,rb.getFname());
			ps.setString(4,rb.getLname());
			ps.setString(5,rb.getAddr());
			ps.setLong(6,rb.getPhno());
			ps.setString(7,rb.getMid());
			
			int k = ps.executeUpdate();
			if(k>=0) {
				pw.println("User Registration Succesful...");}}
				  
			
		catch(Exception e) {e.printStackTrace();}
		
		}
		
		
	}
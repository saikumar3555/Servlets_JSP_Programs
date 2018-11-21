package com.nit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DeleteAccountServlet extends GenericServlet{
  
	
	public Connection con;
	String uname;
	String pword;
    public LoginBean lb;
    public ServletContext context;
	public void init()throws ServletException{
		con=DBConnection.getCon();
		context=this.getServletContext();
	lb=new LoginBean();
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		lb=(LoginBean)context.getAttribute("beanref");
		uname=lb.getUname();
		pword=lb.getPword();
		
		
		try {
			PreparedStatement ps = con.prepareStatement("delete from bookreg13  where uname=? and pword=?");
			
			ps.setString(1, uname);
			ps.setString(2, pword);
			int k = ps.executeUpdate();
			if (k>=0) {
				pw.println("Account Deleted.....");
				RequestDispatcher rd=req.getRequestDispatcher("Login.html");
				 rd.include(req, res);
			}
		} catch (Exception e) {
			e.printStackTrace();}
	}
	
}
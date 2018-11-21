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

public class UpdateAccountServlet extends GenericServlet {
	public Connection con;
	String unameorg;
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
		unameorg=lb.getUname();
		
		//String uname=req.getParameter("uname");
		String pword=req.getParameter("pword");
		String fname=req.getParameter("fname");
		String lname=req.getParameter("lname");
		String addr=req.getParameter("addr");
		long phno=Long.parseLong(req.getParameter("phno"));
		String mid=req.getParameter("mid");
		try {
			//PreparedStatement ps1=con.prepareStatement("update bookreg13 set uname=? where uname=?");
			//ps1.setString(1,uname);
			//ps1.setString(2,unameorg);
			//int k1=ps1.executeUpdate();
			
			PreparedStatement ps2=con.prepareStatement("update bookreg13 set pword=? where uname=?");
			ps2.setString(1,pword);
			ps2.setString(2,unameorg);
			int k2=ps2.executeUpdate();
			
			PreparedStatement ps3=con.prepareStatement("update bookreg13 set fname=? where uname=?");
			ps3.setString(1,fname);
			ps3.setString(2,unameorg);
			int k3=ps3.executeUpdate();
			 
			PreparedStatement ps4=con.prepareStatement("update bookreg13 set lname=? where uname=?");
			ps4.setString(1,lname);
			ps4.setString(2,unameorg);
			int k4=ps4.executeUpdate();
			
			PreparedStatement ps5=con.prepareStatement("update bookreg13 set addr=? where uname=?");
			ps5.setString(1,addr);
			ps5.setString(2,unameorg);
			int k5=ps5.executeUpdate();
			
			PreparedStatement ps6=con.prepareStatement("update bookreg13 set phno=? where uname=?");
			ps6.setLong(1,phno);
			ps6.setString(2,unameorg);
			int k6=ps6.executeUpdate();
			
			PreparedStatement ps7=con.prepareStatement("update bookreg13 set mid=? where uname=?");
			ps7.setString(1,mid);
			ps7.setString(2,unameorg);
			int k7=ps7.executeUpdate();
			
		
			if( k2>=0 && k3>=0 && k4>=0 && k5>=0 && k6>=0 && k7>=0){
				pw.println("<font color='lightgreen'>Account Details Updated.....</font>");
				RequestDispatcher rd=req.getRequestDispatcher("Options.html");
				rd.include(req, res);
			}
		}catch(Exception e) {
				e.printStackTrace();
				
			
		
		}
	}}
	

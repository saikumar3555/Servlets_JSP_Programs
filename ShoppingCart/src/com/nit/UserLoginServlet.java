package com.nit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserLoginServlet extends HttpServlet {
	Connection con;
	public void init()throws ServletException{
		con=DBConnection.getCon();	
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws SecurityException,IOException{
		PrintWriter pw=res.getWriter();
	    String uname=req.getParameter("uname");
	    String pword=req.getParameter("pword");
	    try {
	    	PreparedStatement ps=con.prepareStatement("select * from userreg13 where uname=? and pword=?");
	    	ps.setString(1, uname);
	    	ps.setString(2, pword);
	    	ResultSet rs=ps.executeQuery();
	    	if(rs.next()) {
	    		HttpSession session=req.getSession();
	    		session.setAttribute("username",uname);
	    		RequestDispatcher rd=req.getRequestDispatcher("userhomepage");
	    		rd.forward(req, res);
	    	}//end of if
	    	else {
	    		pw.println("Invalid Username or Password");
	    		RequestDispatcher rd=req.getRequestDispatcher("Login.html");
	    		rd.include(req, res);
	    	}
	    }catch (Exception e) {
			// TODO: handle exception
		}
	}

}

package com.nit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ViewServlet extends GenericServlet {
	public Connection con;
	public void init()throws ServletException{
		con=DBConnection.getCon();
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		 res.setContentType("text/html");
		 String bcode=req.getParameter("bcode");
		 try {
			 PreparedStatement ps=con.prepareStatement("select * from book13 where bcode=?");
			 ps.setString(1,bcode);
			 ResultSet rs=ps.executeQuery();
			 if(rs.next())
			 {
				 RequestDispatcher rd=req.getRequestDispatcher("viewbook");
				 rd.forward(req, res);
				 }else {
					 pw.println("You Entered Invalid Book code...");
					 RequestDispatcher rd=req.getRequestDispatcher("View.html");
					 rd.include(req, res);
				 }
			 }catch(Exception e) {e.printStackTrace();}
		
	}
	

}

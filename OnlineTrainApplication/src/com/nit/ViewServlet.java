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
	public void init()throws ServletException
	{
		con=DBConnection.getCon();
	}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	   PrintWriter pw=res.getWriter();
	   res.setContentType("text/html");
	   String fstation=req.getParameter("fstation");
	   String tstation=req.getParameter("tstation");
	   try {
		   PreparedStatement ps=con.prepareStatement("select * from train13 where fstation=? and tstation=?");
		   ps.setString(1, fstation);
		   ps.setString(2, tstation);
		   ResultSet rs=ps.executeQuery();
		   if(rs.next()) {
			   pw.println("<html>");
			   pw.println("<head>");
			   
			  
			   pw.println();
			   pw.println("</head>");
			   pw.println("<body>");
			   pw.println("<div align='center'>");
		   pw.println("<p>"+"-----Train Details-----"+"</p>");
		   pw.println("</div>");
		 pw.println( " <table align='center' border='10px' border-collapse:'collapse'>");
		 pw.println("<thead>");    
		 pw.println("<tr>");  
		 pw.println("<th>Tno</th>");	  
		 pw.println(" <th>Tname</th>"); 
		 pw.println("<th>Fstation</th>");  
		 pw.println("<th>tstation</th>");  
		 pw.println("<th>available</th>");  
		 	
		 pw.println("</tr>");	
		 pw.println(" </thead>");
		 pw.println("<tbody>");
		
		   
			   pw.println("<tr>");
			   
			   pw.println("<td>"+rs.getString(1)+"</td>");
			   pw.println("<td>"+rs.getString(2)+"</td>");
			   pw.println("<td>"+rs.getString(3)+"</td>");
			   pw.println("<td>"+rs.getString(4)+"</td>");
			   pw.println("<td>"+rs.getInt(5)+"</td>");
			   /*pw.println("<tdTrain Number    :"+rs.getString(1));
			   pw.println("<br>Train Name  :"+rs.getString(2));
			   pw.println("<br>From Station:"+rs.getString(3));
			   pw.println("<br>To Station  :"+rs.getString(4));
			   pw.println("<br>Available   :"+rs.getInt(5));*/
			   pw.println("</tr>");
		   }
		   
		   else {
			   pw.println("No Train Available...");
			   RequestDispatcher rd=req.getRequestDispatcher("View.html");
			   rd.include(req, res);
			   
		   }
		   pw.println(" </tbody>");
		   pw.println(" </body>");
			 pw.println(" </html>");
	   }catch(Exception e) {e.printStackTrace();}
		
	}
	

}

package com.nit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserViewBooksServlet extends HttpServlet{
	public Connection con;
	public void init() throws ServletException {
		con = DBConnection.getCon();
	}
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		try {
			PreparedStatement ps=con.prepareStatement("select * from book13");
			ResultSet rs=ps.executeQuery();		
			pw.println("<h2>---Book Details---</h2>");
			while(rs.next()) {
				
				pw.println("<br>BCode:  "+rs.getString(1));
				pw.println("<br>BName:  "+rs.getString(1));
				pw.println("<br>BAuthor:  "+rs.getString(1));
				pw.println("<br>BPrice:  "+rs.getString(1));
				pw.println("<br>BQty:  "+rs.getString(1));
						pw.println("<hr>");
			}  
		}catch (Exception e) {
			// TODO: handle exception
		}
	}


}

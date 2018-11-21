package com.nit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteBookServlet extends HttpServlet {
	public Connection con;
	public void init() throws ServletException {
		con = DBConnection.getCon();
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String bcode=req.getParameter("bcode");
		
		
		try {
			PreparedStatement ps=con.prepareStatement("delete from  book13 where bcode=?");
			ps.setString(1, bcode);
			
			int k=ps.executeUpdate();
			if(k>0) {
				pw.println("Book Details Deleted Succesfully");
				RequestDispatcher rd=req.getRequestDispatcher("AdminHomepage.html");
				rd.include(req, res);
			}else {
				pw.println("Invalid Book code..");
			}
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	

}

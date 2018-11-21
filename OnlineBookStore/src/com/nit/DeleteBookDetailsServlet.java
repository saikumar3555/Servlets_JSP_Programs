package com.nit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DeleteBookDetailsServlet extends GenericServlet {
	public Connection con;

	public void init()throws ServletException{
		con=DBConnection.getCon();}
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		String bcode = req.getParameter("bcode");
		
		
		try {
			PreparedStatement ps = con.prepareStatement("delete book13  where bcode=?");
			
			ps.setString(1, bcode);
			int k = ps.executeUpdate();
			if (k>0) {
				pw.println("Book Details Deleted.....");
				RequestDispatcher rd=req.getRequestDispatcher("Options.html");
				 rd.include(req, res);
			}else {
				pw.println("You Entered Invalid Book Code...");
				 RequestDispatcher rd=req.getRequestDispatcher("Delete.html");
				 rd.include(req, res);
			}
		} catch (Exception e) {
			e.printStackTrace();}
	}

}

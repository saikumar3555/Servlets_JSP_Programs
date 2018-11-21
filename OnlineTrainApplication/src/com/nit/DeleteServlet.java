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

public class DeleteServlet extends GenericServlet {
	public Connection con;

	public void init()throws ServletException{
		con=DBConnection.getCon();}
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		String tno = req.getParameter("tno");
		
		
		try {
			PreparedStatement ps = con.prepareStatement("delete Train13  where tno=?");
			
			ps.setString(1, tno);
			int k = ps.executeUpdate();
			if (k>0) {
				pw.println("Train Details Deleted.....");
				RequestDispatcher rd=req.getRequestDispatcher("Homepage.html");
				 rd.include(req, res);
			}else {
				pw.println(" Invalid Train Number...");
				 RequestDispatcher rd=req.getRequestDispatcher("Delete.html");
				 rd.include(req, res);
			}
		} catch (Exception e) {
			e.printStackTrace();}
	}

}

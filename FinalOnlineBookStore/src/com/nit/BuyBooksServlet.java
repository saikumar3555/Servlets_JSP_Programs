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

public class BuyBooksServlet extends HttpServlet {
	public Connection con;
	int bqty;
	String bcode;

	public void init() throws ServletException {
		con = DBConnection.getCon();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		bcode = req.getParameter("bcode");
		bqty = Integer.parseInt(req.getParameter("bqty"));
		try {
			PreparedStatement ps = con.prepareStatement("select * from book13 where bcode=?");
			ps.setString(1, bcode);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				RequestDispatcher rd = req.getRequestDispatcher("Payment.html");
				rd.forward(req, res);}
			else {
				pw.println("Invalid BookCode");
				RequestDispatcher rd = req.getRequestDispatcher("Payment.html");
				rd.include(req, res);}
			
			
			/*int avlqty = rs.getInt(5);
			if (bqty <= rs.getInt(5)) {
				int remqty = rs.getInt(5) - bqty;
				PreparedStatement ps2 = con.prepareStatement("update book13 set bqty=? where bcode=?");
				ps.setInt(1, remqty);
				ps.setString(2, bcode);
				int k = ps2.executeUpdate();
				if (k>0) {*/
					
				//} 
					//}
			//else {
			//	pw.println("Stack is Not Available....");
			//

			
	} catch (Exception e) {
			// TODO: handle exception
		}}}

	


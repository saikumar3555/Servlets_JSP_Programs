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

public class UpdateBookQuantityServlet extends GenericServlet {
	public Connection con;

	public void init() throws ServletException {
		con = DBConnection.getCon();
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		String bcode = req.getParameter("bcode");
		int bqty = Integer.parseInt(req.getParameter("bqty"));

		try {
			PreparedStatement ps = con.prepareStatement("update book13 set bqty=? where bcode=?");
			ps.setInt(1, bqty);
			ps.setString(2, bcode);
			int k = ps.executeUpdate();
			if (k > 0) {
				pw.println("Books Quantity Updated.....");
				RequestDispatcher rd = req.getRequestDispatcher("Options.html");
				rd.include(req, res);
			} else {
				pw.println("You Entered Invalid Book Code...");
				RequestDispatcher rd = req.getRequestDispatcher("UpdateBookQuantity.html");
				rd.include(req, res);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

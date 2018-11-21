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

public class UpdateBookPriceServlet extends GenericServlet {
	public Connection con;

public void init()throws ServletException{
	con=DBConnection.getCon();
}

@Override
public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	PrintWriter pw = res.getWriter();
	res.setContentType("text/html");
	String bcode = req.getParameter("bcode");
	float bprice = Float.parseFloat(req.getParameter("bprice"));
	
	try {
		PreparedStatement ps = con.prepareStatement("update book13 set bprice=? where bcode=?");
		ps.setFloat(1, bprice);
		ps.setString(2, bcode);
		int k = ps.executeUpdate();
		if (k>0) {
			pw.println("Book Price Updated.....");
			RequestDispatcher rd=req.getRequestDispatcher("Options.html");
			 rd.include(req, res);
		}else {
			pw.println(" Invalid Book Code...");
			 RequestDispatcher rd=req.getRequestDispatcher("UpdateBookPrice.html");
			 rd.include(req, res);
		}
	} catch (Exception e) {
		e.printStackTrace();}
}
}

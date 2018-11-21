package com.nit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PaymentServlet extends HttpServlet {
	public Connection con;
	public void init() throws ServletException {
		con = DBConnection.getCon();
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String cardnumber=req.getParameter("cardnumber");
		String cvv=req.getParameter("cvv");
		String otp=req.getParameter("otp");
		pw.println("Your Order is Successful...");
		RequestDispatcher rd=req.getRequestDispatcher("UserHomepage.html");
		rd.include(req, res);
	}
	


}

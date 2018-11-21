package com.nit;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DiscountServlet extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String pcode=req.getParameter("pcode");
		String pname=req.getParameter("pname");
		
		float totbill=Float.parseFloat(req.getParameter("GrandTotal"));
		float fbill=totbill-(0.18F*totbill);
		
		pw.println("From Discount Servlet...");
		//pw.println("<br>Pcode"+pcode);
		//pw.println("<br>Pname"+pname);
		
		pw.println("<br>TotalBill"+totbill);
		pw.println("<br>FinalBill"+fbill);
		
		
	}

}

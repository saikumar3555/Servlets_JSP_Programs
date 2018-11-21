package com.nit;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BillServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String pcode=req.getParameter("pcode");
		String pname=req.getParameter("pname");
		
		float pprice=Float.parseFloat(req.getParameter("pprice"));
		int pqty=Integer.parseInt(req.getParameter("pqty"));
		float totBill=pprice*pqty;
		if(totBill>=5000) {
			res.sendRedirect("http://localhost:8081/TestApp2/dis?pcode="+pcode+"&pname="+pname+"&totBill="+totBill);
			
		}else {
			
		
		pw.println("From Bill Servlet...");
		pw.println("<br>Pcode:"+pcode);
		pw.println("<br>Pname:"+pname);
		
		pw.println("<br>TotalBill:"+totBill);}
		
		
		
		
	}
	
	

}

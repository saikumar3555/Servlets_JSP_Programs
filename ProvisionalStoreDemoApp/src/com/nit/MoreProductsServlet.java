package com.nit;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MoreProductsServlet extends HttpServlet{
	public ProductBean pb;
	public ServletContext context;
	public ArrayList al;
	public void init()throws ServletException{
		context=this.getServletContext();
		pb=new ProductBean();
		al=new ArrayList();
	}
	
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String pcode=req.getParameter("pcode");
		String pname=req.getParameter("pname");
		
		float pprice=Float.parseFloat(req.getParameter("pprice"));
		int pqty=Integer.parseInt(req.getParameter("pqty"));
		
		pb.setPCode(pcode);
		pb.setPName(pname);
		pb.setPPrice(pprice);
		pb.setPQty(pqty);
	 float eachproductbill=pprice*pqty;
	 //pb.setEachProductBill(eachproductbill);
		
		al.add(pb);
		context.setAttribute("ref", al);
		pw.println("enter next Product...");
		RequestDispatcher rd=req.getRequestDispatcher("Product.html");
		rd.forward(req, res);
		
	}

}

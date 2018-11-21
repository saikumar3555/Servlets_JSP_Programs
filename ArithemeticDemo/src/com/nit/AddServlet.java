package com.nit;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		int  op1=Integer.parseInt(req.getParameter("op1")); 
		int op2=Integer.parseInt(req.getParameter("op2")); 
		int sum=op1+op2;
		pw.println("sum:"+sum);
		RequestDispatcher rd=req.getRequestDispatcher("input.html");
		rd.include(req,res);
		
	}

}

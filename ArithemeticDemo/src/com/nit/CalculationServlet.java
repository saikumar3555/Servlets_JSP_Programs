package com.nit;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculationServlet extends HttpServlet {
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String submit=req.getParameter("submit");
		if(submit.equals("ADD")) {
			RequestDispatcher rd=req.getRequestDispatcher("add");
			rd.forward(req,res);
			
		}else if(submit.equals("MUL")) {
			RequestDispatcher rd=req.getRequestDispatcher("mul");
			rd.forward(req,res);	
		} 
		else if(submit.equals("DIV")) {
			RequestDispatcher rd=req.getRequestDispatcher("div");
			rd.forward(req,res);	
		} 
		else if(submit.equals("MOD")) {
			RequestDispatcher rd=req.getRequestDispatcher("mod");
			rd.forward(req,res);	
		} 
		else {
			RequestDispatcher rd=req.getRequestDispatcher("sub");
			rd.forward(req,res);
		}
		
	}

}

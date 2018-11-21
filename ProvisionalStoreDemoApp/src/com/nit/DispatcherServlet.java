package com.nit;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String submit=req.getParameter("submit");
		if(submit.equals("next>>")) {
			RequestDispatcher rd=req.getRequestDispatcher("moreproducts");
			rd.forward(req,res);
		}else {
			RequestDispatcher rd=req.getRequestDispatcher("bill");
			rd.forward(req,res);
		}
		}
			

}

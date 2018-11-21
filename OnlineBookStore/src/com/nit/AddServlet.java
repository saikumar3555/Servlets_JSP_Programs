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

public class AddServlet extends GenericServlet{
	public Connection con;
	public void init()throws ServletException{
		con=DBConnection.getCon();
	}
	public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String bcode=req.getParameter("bcode");
		String bname=req.getParameter("bname");
		String bauthor=req.getParameter("bauthor");
		float bprice=Float.parseFloat(req.getParameter("bprice"));
		int bqty=Integer.parseInt(req.getParameter("bqty"));
try {
	PreparedStatement ps=con.prepareStatement("insert into book13 values(?,?,?,?,?)");
	ps.setString(1, bcode);
	ps.setString(2, bname);
	ps.setString(3, bauthor);
	ps.setFloat(4, bprice);
	ps.setInt(5, bqty);
	int k=ps.executeUpdate();
	if(k>0){
		pw.println("Book Details are updated....");
		RequestDispatcher rd=req.getRequestDispatcher("Options.html");
				rd.include(req, res);

	}
	
}catch(Exception e) {}
	
		
}
}

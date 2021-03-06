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

public class ProductServlet extends GenericServlet{
    public Connection con;
	public void init()throws ServletException
	{
		con=DBConnection.getCon();
	}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	 PrintWriter pw=res.getWriter();
	 res.setContentType("text/html");
	 String pcode=req.getParameter("pcode");
	 try {
		 PreparedStatement ps=con.prepareStatement("select * from product11 where pcode=?");
		 ps.setString(1,pcode);
		 ResultSet rs=ps.executeQuery();
		 if(rs.next()) {
			 RequestDispatcher rd=req.getRequestDispatcher("/dis");
			 rd.forward(req, res);
			 return;
			 
		 }else {
			 pw.print("You Entered Invalid product code.....");
			 RequestDispatcher rd=req.getRequestDispatcher("product.html");
			 rd.include(req, res);
		 }
		
	 }catch(Exception e) {e.printStackTrace();}
		
	}
	

}

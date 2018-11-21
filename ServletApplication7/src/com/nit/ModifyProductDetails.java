package com.nit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ModifyProductDetails extends GenericServlet {
	public static Connection con;
	public void init()throws ServletException
	{
		con=DBConnection.getCon();
	}
	public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		float pprice=Float.parseFloat(req.getParameter("pprice"));
		String pcode=req.getParameter("pcode");
		
		//PreparedStatement ps = con.prepareStatement("select* from product11 where pcode=?");
		//ps.setString(1,pcode);
		//ResultSet rs=ps.executeQuery();
		//if(rs.next())
		//{
		//	pw.println("book code : "+pcode);
		//	pw.println("book name : "+rs.getString(2));
		//	pw.println("book price: "+rs.getString(3));
			//pw.println("book qty : "+pcode);
			
		//}else {
		//	pw.println("You Entered Invalid Product code.....");
		//}
		try {
		PreparedStatement ps = con.prepareStatement("update product11 set pprice=? where pcode=?");
		ps.setFloat(1,pprice);
		ps.setString(2,pcode);
		int k=ps.executeUpdate();
		if(k>0) {
			pw.println("product Details are updated...");
		}else {
			pw.println("You entered Invalid Product code....");
		}
		
		}catch(Exception e) {e.printStackTrace();}
	}
	
	}

package com.nit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class ViewProductsServlet extends HttpServlet{
	public Connection con;
	public ArrayList al;
	public void init()throws ServletException{
		con=DBConnection.getCon();
		al=new ArrayList();
		
	}
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	PrintWriter pw=res.getWriter();
	res.setContentType("text/html");
	try {
		PreparedStatement ps=con.prepareStatement("select * from product11");
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			ProductBean pb=new ProductBean();
			pb.setPCode(rs.getString(1));
			pb.setPName(rs.getString(2));
			pb.setPPrice(rs.getFloat(3));
			pb.setPQty(rs.getInt(4));
			al.add(pb);
			pw.println("<a href='dis?pcode="+rs.getString(1)+"'>"+rs.getString(1)+"</a>");
		}
		
		HttpSession session=req.getSession();
		session.setAttribute("list",al);
	}catch (Exception e) {
		// TODO: handle exception
	}
		
	}
	

}

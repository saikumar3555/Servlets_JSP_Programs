package com.nit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ProductServlet extends GenericServlet {
	public Connection con;
	public ArrayList al;
	public void init()throws ServletException{
		con=DBConnection.getCon();
		 al=new ArrayList();
	}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
				
			}//end of while
			req.setAttribute("jcfref",al);
			RequestDispatcher rd=req.getRequestDispatcher("Display.jsp");
			rd.forward(req,res);
			
		}catch(Exception e) {e.printStackTrace();}
		
		
	}

}

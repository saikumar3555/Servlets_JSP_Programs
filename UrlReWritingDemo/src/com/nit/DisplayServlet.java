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

public class DisplayServlet extends HttpServlet {
	
	private Connection con;
	String pcode;
	 public ArrayList al;
	public void init() throws ServletException {
		con = DBConnection.getCon();
		System.out.println("start");
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		HttpSession session=req.getSession();
		al=(ArrayList)session.getAttribute("list");
		res.setContentType("text/html");
		 pcode = req.getParameter("pcode");
		 System.out.println("pcode"+pcode);
		try {
			//PreparedStatement ps = con.prepareStatement("select * from product11 where pcode=?");
			//ps.setString(1, pcode);
			//ResultSet rs = ps.executeQuery();
		  al.forEach((k)->
		  {
			  System.out.print("iterator");
			   ProductBean pb=(ProductBean)k;
			  String code= pb.getPCode();
			  System.out.print("code"+code);
			  if(pcode.equals(code)) {
				  System.out.print("if block");
				  pw.println("pcode:" + pb.getPCode());
					pw.println("<br>pname:" + pb.getPName());
					pw.println("<br>pprice:" + pb.getPPrice());
					pw.println("<br>pqty:" + pb.getPQty());
			  }
		  });
			/*if (rs.next()) {
				pw.println("pcode:" + rs.getString(1));
				pw.println("<br>pname:" + rs.getString(2));
				pw.println("<br>pprice:" + rs.getFloat(3));
				pw.println("<br>pqty:" + rs.getInt(4));
			}*/
  System.out.print("end");
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}

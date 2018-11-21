package com.nit;
import java.io.*;
import java.sql.*;
import javax.servlet.*;

public class RetriveProduct11Details extends GenericServlet {
	public Connection con;

	public void init() throws ServletException {
		con = DBConnection.getCon();
	}

	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		String pcode = req.getParameter("pcode");
	
		try {
			
		PreparedStatement ps = con.prepareStatement("select * from product11 where pcode=?");
		
			ps.setString(1,pcode);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				pw.println("pcode     : " + rs.getString(1));
				pw.println("<br>pname : " + rs.getString(2));
				pw.println("<br>pprice: " + rs.getFloat(3));
				pw.println("<br>pqty  :  " + rs.getInt(4));
				
			} else {
				pw.println("<br>Invalid product code....");
			}//end of else
		} catch (Exception e) {e.printStackTrace();}
			
	}//end of service method

}

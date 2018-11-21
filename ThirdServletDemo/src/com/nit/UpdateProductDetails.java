package com.nit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class UpdateProductDetails extends GenericServlet {
	public void service(ServletRequest req, ServletResponse res) throws IOException, ServletException {
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		String pcode = req.getParameter("pcode");
		String pname = req.getParameter("pname");
		float pprice = Float.parseFloat(req.getParameter("pprice"));
		int pqty = Integer.parseInt(req.getParameter("pqty"));
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			PreparedStatement ps = con.prepareStatement("insert into product11 values(?,?,?,?)");
			ps.setString(1, pcode);
			ps.setString(2, pname);
			ps.setFloat(3, pprice);
			ps.setInt(4, pqty);
			int k = ps.executeUpdate();
			if (k > 0) {
				pw.println("product details are updated...");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

package com.nit;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DisplayServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		ArrayList al = (ArrayList) req.getAttribute("jcfref");
		
		
		
		//pw.println("<html><body><table><thead><tr>");
	//	pw.println("<th>BC></th> <th>BN></th> <th>BP></th> <th>BQ</th></tr></thead><tbody>");
		
		al.forEach((k) -> {
			ProductBean pb = (ProductBean) k;
			 //
				
			// String bq=String.parseString(pb.getPQty()) ;
				
			
			
	
			
			pw.println("<br>" + pb.getPCode() + "&nbsp" + pb.getPName()+ "&nbsp" + pb.getPPrice() + "&nbsp"
				+ pb.getPQty());
			
		});
		//pw.println("</tbody></table></html>");
	}
}
		
	

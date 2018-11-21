<%@page import="java.util.ArrayList"%>
<%@page import="com.nit.ProductBean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

ArrayList al = (ArrayList)request.getAttribute("jcfref");

al.forEach((k) -> {
	ProductBean pb = (ProductBean) k;

	out.println( pb.getPCode() + "&nbsp" + pb.getPName()+ "&nbsp" + pb.getPPrice() + "&nbsp"
		+ pb.getPQty());
	
});
%>


</body>
</html>
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
String pcode=request.getParameter("pcode");
String pname=request.getParameter("pname");
float pprice=Float.parseFloat(request.getParameter("pprice"));
int pqty=Integer.parseInt(request.getParameter("pqty"));
out.println("----Product Details------");
out.println("<br>Product Code :"+pcode);
out.println("<br>Product Name :"+pname);
out.println("<br>Product Price :"+pprice);
out.println("<br>Product Quantity :"+pqty);

%>
</body>
</html>
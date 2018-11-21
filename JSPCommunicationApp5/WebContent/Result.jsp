<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%String result=request.getParameter("result");
String submit=request.getParameter("submit");
%>
<%
if(submit.equals("Add")){
	%>
	Result of Add:<%=result %>
<%}else{%>
	Result of Sub:<%=result %>
	<% }
%>


</body>
</html>
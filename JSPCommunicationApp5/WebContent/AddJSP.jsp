<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body><%
int field1=Integer.parseInt(request.getParameter("field1"));
		int field2=Integer.parseInt(request.getParameter("field2"));
		int result=field1+field2;

%>
<jsp:forward page="/Result.jsp">
<jsp:param name="result" value="<%=result%>"/></jsp:forward>
</body>
</html>
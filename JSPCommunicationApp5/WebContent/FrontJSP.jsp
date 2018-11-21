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
String submit=request.getParameter("submit");
if(submit.equals("Add")){ %>
	<jsp:forward page="/AddJSP.jsp"></jsp:forward>
	<% 
}else if(submit.equals("Sub")){%>
	<jsp:forward page="/SubJSP.jsp"></jsp:forward>
<%}else{%>
<jsp:forward page="/Home.html"></jsp:forward>
	<%
}
%>


</body>
</html>
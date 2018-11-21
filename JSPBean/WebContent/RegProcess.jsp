<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page errorpage="Registration.html" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="regForm" class="bean.RegForm" scope="session"/>
<jsp:setProperty property="*" name="regForm"/>

<form action="RegProcessFinal.jsp">
FirstName:<input type="text" name="first_name"/>
LastName:<input type="text" name="last_name"/>
Address:<input type="text" name="address">
<input type="submit" value="Register">
</form>
</body>
</html>
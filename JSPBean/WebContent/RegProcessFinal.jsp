<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page errorPage="Registration.html" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<jsp:useBean id="regForm" type="bean.RegForm" scope="session"/>
<jsp:setProperty name="regForm" property="firstName" param="first_name"/>
<jsp:setProperty name="regForm" property="lastName" param="last_name"/>
<jsp:setProperty property="address" name="regForm"/>
<body>
<pre>
Your Registration details are valid...
<a href="ViewRegistrationDetails.jsp">Click</a>ViewRegistrationDetails and conform
</pre>

</body>
</html>
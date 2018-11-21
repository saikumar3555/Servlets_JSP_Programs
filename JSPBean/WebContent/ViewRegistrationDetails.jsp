<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@page errorPage="Registration.html" %>
</head>
<body>
UserName:<jsp:getProperty property="userName" name="regForm"/>
PassWord:<jsp:getProperty property="passWord" name="regForm"/>
RePassWord:<jsp:getProperty property="rePassWord" name="regForm"/>
Email Id:<jsp:getProperty property="email" name="regForm"/>
FirstName:<jsp:getProperty property="firstName" name="regForm"/>
LastName:<jsp:getProperty property="lastName" name="regForm"/>
Address:<jsp:getProperty property="address" name="regForm"/>

<form action="Process.jsp">
<input type="submit" value="Register">
</form>

</body>
</html>
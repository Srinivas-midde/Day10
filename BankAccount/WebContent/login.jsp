<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<%@include file="index.jsp" %>
<form action="login" method="post">
<label>Customer Id:</label>
<input name="id" type="number" size="15">
<br>
<label>Password:</label>
<input name="password" type="password" size="15">
<br>
<input type="submit" value="login">
</form>

</body>
</html>
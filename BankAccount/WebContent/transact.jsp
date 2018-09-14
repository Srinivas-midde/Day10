<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="transact" method="post">
<label>Enter the receivers account id</label>
<input type="number" name="toacc" size="15">
<br><br>
<label>Enter your account id</label>
<input type="number" name="fromacc" size="15">
<br><br>
<label>Enter the amount to be transfered</label>
<input type="number" name="amount" size="15">
<br><br>
<input type="submit" value="proceed">
</form>

</body>
</html>
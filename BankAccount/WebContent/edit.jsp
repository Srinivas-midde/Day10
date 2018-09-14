<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="update" method="post">
<label>Customer Id: </label>
<Input type="number" name="empId" value="${sessionScope.customer.customerId}" readonly="readonly"/>
<br><br>
<label>Customer Name: </label>
<input type="text" name="empName" size="15" value="${sessionScope.customer.customerName}"/>
<br><br>
<label>Customer Address: </label>
<input type="text" name="address" size="15" value="${sessionScope.customer.customerAddress}"/>
<br><br>
<label>Customer EmailId: </label>
<input type="text" name="email" size="15" value="${sessionScope.customer.customerEmailId}"/>
<br><br>
<label>Customer DateOfBirth: </label>
<input type="date" name="dob" size="15" value="${sessionScope.customer.dateOfBirth}"/>
<br><br>
<input type="submit" value="Update">
</form>
</body>
</html>
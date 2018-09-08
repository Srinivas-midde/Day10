<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Edit Employee Details</h1>
<hr>
<form action="editEmployee" method="post">
<label>Employee Id: </label>
<Input type="number" name="empId" value="${param.employeeId}" readonly="readonly"/>
<br><br>
<label>Employee Name: </label>
<input type="text" name="empName" size="15" value="${param.employeeName}"/>
<br><br>
<label>Employee Salary: </label>
<input type="number" name="empSalary" size="15" value="${param.employeeSalary}"/>
<br><br>
<label>Employee Department</label>
<select name="empDept" required selected="${param.employeeDepartment}">
<option value="">----select---</option>
<option value="IT">IT</option>
<option value="ADMIN">ADMIN</option>
<option value="ACCOUNTS">ACCOUNTS</option>
<option value="HR">HR</option>
</select>
<input type="submit" value="Update_Details"> 
</form>
<h3>

<hr>
	<a href="editEmployee.jsp?employeeId=${employee.employeeId}">Edit</a> more Employee Details &nbsp &nbsp &nbsp &nbsp &nbsp<a href="home.html">Home</a>
</body>
</html>
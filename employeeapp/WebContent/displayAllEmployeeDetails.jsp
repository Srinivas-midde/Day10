<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
   <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Employee Details</title>
</head>
<body>
	<h1>Employee Details</h1>
	<hr><br>
	<table border="1">
		<tr>
		     <th>Employee Id</th>
		     <th>Employee Name</th>
		     <th>Employee Salary</th>
		     <th>Employee Department</th>
		     <th>Delete Employee</th>
		     <th>Upadate Employee</th>
		</tr>
		<c:forEach var="employee" items="${requestScope.employeesList}">
			<tr>
			    <td>${employee.employeeId}</td>
			    <td>${employee.employeeName}</td>
			    <td>${employee.employeeSalary}</td>
			    <td>${employee.employeeDepartment}</td>
			    <td><a href="deleteEmployee?employeeId=${employee.employeeId}">Delete</a></td>
			     <td><a href="editEmployee.jsp?employeeId=${employee.employeeId}&employeeName=${employee.employeeName}&employeeSalary=${employee.employeeSalary}&employeeDepartment=${employee.employeeDepartment}">Edit</a></td>
			     		    
			</tr>
		</c:forEach>		
	</table>
	<br><br><br><h3>
	<hr>
	<a href="addEmployee.jsp">Add</a> more Employees &nbsp &nbsp &nbsp &nbsp &nbsp<a href="home.html">Home</a>
</body>
</html>
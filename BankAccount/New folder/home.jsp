<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %>
<br>
<div class="jumbotron">
  <h1 class="display-4">Hello, ${sessionScope.customer.customerName}!</h1>
  <p class="lead">Welcome to our bank. We hope you will have a great experience here.</p>
  <hr class="my-4">
  <p>Thank you for your faith!</p>
</div>
<div class="row m-0">
    <div class="col-md-6 mt-5 ml-1 mr-0 mb-5">
        <div class="card">
            <div class="card-header">
                Customer Details
            </div>
            <div class="m-0">
                <table class="table table-bordered m-0">
                    <thead>
                    <tr>
                        <th scope="col">Customer ID</th>
                        <th scope="col">Name</th>
                        <th scope="col">DOB</th>
                        <th scope="col">Email</th>
                        <th scope="col">Address</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <th scope="row">${sessionScope.customer.customerId}</th>
                        <td>${sessionScope.customer.customerName}</td>
                        <td>${sessionScope.customer.customerDateOfBirth}</td>
                        <td style="font-size: 14px">${sessionScope.customer.customerEmail}</td>
                        <td style="font-size: 14px">${sessionScope.customer.customerAddress}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div class="col-md-5 mt-5 ml-0">
        <div class="card">
            <div class="card-header">
                 Account Details
            </div>
            <div class="m-0">
                <table class="table table-bordered m-0">
                    <thead>
                    <tr>
                        <th scope="col">Account ID</th>
                        <th scope="col">Account Type</th>
                        <th scope="col">Balance</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <th scope="row">${sessionScope.customer.account.accountId}</th>
                        <td>${sessionScope.customer.account.accountType}</td>
                        <td>${sessionScope.customer.account.balance}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
   
</div>



</body>
</html>
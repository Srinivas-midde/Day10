<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<meta charset="ISO-8859-1">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<title>Edit Details</title>
</head>
<body>
<%@ include file="header.jsp" %>
</body>
<div class=" mx-auto  m-5" align="center">
<div class="card" style="width: 50rem;">
<form action="" method="post">
  <div class="form-row">
    <div class="form-group col-md-6 ">
      <label >Sender's Account Id</label>
      <input type="number" class="form-control" name="fromacc" value="${sessionScope.customer.account.accountId }" readonly="readonly">
    </div>
    <div class="form-group col-md-6">
      <label >Receiver's Account Id</label>
      <input type="number" class="form-control" name="toacc" placeholder="Account Id">
    </div>
  </div>
  <div class="form-group">
    <label for="inputAddress">Amount</label>
    <input type="number" class="form-control" name="amount" placeholder="Amount to be transfered">
  </div>
  <button type="submit" class="btn btn-primary">Transfer</button>
</form>
</div>
</div>
</html>
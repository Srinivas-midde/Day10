<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <title>Hello, world!</title>
  </head>
  <body background="C:\Users\smiddeku\Documents\webapps-workspace\BankAccount\WebContent\Images\img2.jpg" class="mr-2">
    <nav class="navbar navbar-expand-lg navbar-dark bg-basic">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent1" aria-controls="navbarSupportedContent1" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent1">
        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSbgHVVHoPNtIV6IKdIRxIyD13HJ6OSw3wPDS_AC42KV5b0RAY02Q" style="width: 90px; height: 90px" >
        <h2>&nbsp;&nbsp;&nbsp;BANK</h2>
        
    </div>
    <div class="d-flex flex-row-reverse">
      
    </div>
</nav>

    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <li class="nav-item active">
                <a class="nav-link" href="index.jsp"><b><strong>Home</strong> </b><span class="sr-only">(current)</span></a>
            </li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <li class="nav-item">
               <a class="nav-link" href="#" data-toggle="modal" data-target="#exampleModal"><b><strong>Edit Profile</strong></b></a>
            </li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <li class="nav-item">
                <a class="nav-link" href="#" data-toggle="modal" data-target="#exampleModal"><b><strong>Fund Transfer</strong></b></a>
            </li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <li class="nav-item">
                <a class="nav-link" href="#" data-toggle="modal" data-target="#exampleModal"><b><strong>Balance Enquiry</strong></b></a>
            </li>
        </ul>
        
        <div class="modal" id="exampleModal" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Error</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <p>Please login.</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        
      </div>
    </div>
  </div>
</div>
    </div>
</nav>

<div class="row">
<div class="col-md-5 m-5">
<div class="card" align="left" style="width: 21rem;">
<form class="p-4" action="login" method="post">
  <div class="form-group">
    <label for="exampleDropdownFormEmail2">Customer Id:</label>
    <input type="number" class="form-control" id="exampleDropdownFormEmail2" name="id" placeholder="customer id">
  </div>
  <div class="form-group">
    <label for="exampleDropdownFormPassword2">Password</label>
    <input type="password" class="form-control" id="exampleDropdownFormPassword2" name="password" placeholder="Password">
  </div>
  <div class="form-check">
    <input type="checkbox" class="form-check-input" id="dropdownCheck2">
    <label class="form-check-label" for="dropdownCheck2">
      Remember me
    </label>
  </div>
  <br>
  <button type="submit" class="btn btn-primary">Sign in</button>

    <c:if test = "${requestScope.name==true }">
    <div class="alert alert-danger" role="alert">
    Invalid Credentials! Try again.
    </div>
    </c:if>
 </form>
</div>
</div>
</div>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  </body>
</html>
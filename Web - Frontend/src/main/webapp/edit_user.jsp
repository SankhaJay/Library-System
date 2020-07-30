<!DOCTYPE HTML>
<html xmlns:th="https://www.thymeleaf.org">>
  <head>
    <title> Employee Page </title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="css/user.css">
  </head>
  <body>

  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="#"> Library </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav ml-auto">
        <li class="nav-item active">
          <a class="nav-link" href="#"> Home <span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#"> Employee </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#"> User </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#"> Books </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#"> Admin </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#"> Log Out </a>
        </li>
      </ul>
    </div>
  </nav>

  <div class="row marginStyle">
     <div class="col-md-12">
        <form action="create_user" method="post">
           <div class="form-group">
              <label for="name">Name</label>
              <input type="text" class="form-control" name="name" placeholder="Enter Name" value="${user.name}">
           </div>
           <div class="form-group">
              <label for="email">Email</label>
              <input type="email" class="form-control" value="${user.email}" name="email" aria-describedby="emailHelp" placeholder="Enter email">
              <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
           </div>
           <div class="form-group">
              <label for="nic">NIC</label>
              <input type="text" class="form-control" name="nic" value="${user.nic}" placeholder="Enter NIC">
           </div>
           <div class="form-group">
              <label for="address">Address</label>
              <input type="text" class="form-control" name="address" value="${user.address}" placeholder="Enter Address">
           </div>
           <div class="form-group">
               <label for="dob">Date of Birth</label>
               <input type="date" class="form-control" name="dob" value="${user.dob}" placeholder="Enter DOB">
           </div>
           <button type="submit" class="btn btn-primary">Submit</button>
        </form>
     </div>
  </div>

  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  </body>
</html>

<html>
  <head>
    <title> Admin Page </title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="css/user.css">
  </head>
  <body>

  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="#"> Library - System </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav ml-auto">
        <li class="nav-item active">
          <a class="nav-link" href="/home"> Home <span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/employee"> Employee </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/user"> User </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/book"> Books </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/admin"> Admin </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/"> Log Out </a>
        </li>
      </ul>
    </div>
  </nav>

  <div class="row" style="margin: 20px 20px 20px 20px;">
     <div class="col-md-12">
        <form action="/edit_admin_form" method="post">
           <input type="text" class="form-control" name="aId" value="${admin.aId}" style="display:none">
           <div class="form-group">
              <label for="name">Name</label>
              <input type="text" class="form-control" name="name" placeholder="Enter Name" value="${admin.name}">
           </div>
           <div class="form-group">
            <label for="address">Address</label>
            <input type="text" class="form-control" name="address" value="${admin.address}" placeholder="Enter Address">
         </div>
           <div class="form-group">
              <label for="salary">email</label>
              <input type="text" class="form-control" name="email" value="${admin.email}" placeholder="Enter email">
           </div>
           
           <div class="form-group">
               <label for="age">NIC</label>
               <input type="text" class="form-control" name="nic" value="${admin.nic}" placeholder="Enter nic">
           </div>
           <div class="form-group">
               <label for="dob">DOB</label>
               <input type="date" class="form-control" name="dob" value="${admin.dob}" placeholder="Enter DOB">
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
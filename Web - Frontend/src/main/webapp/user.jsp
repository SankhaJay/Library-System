<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title> Employee Page </title>
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
     <div class="col-md-5">
         <form action="/filter_user" method="post">
             <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Search User Here" name="name">
                    </div>
                </div>
                <div class="col-md-6">
                   <button type="submit" class="btn btn-outline-success my-2 my-sm-0"> Search </button>
                </div>
             </div>
         </form>
     </div>
     <div class="col-md-4">
        <a href="/add-user" class="btn btn-info"> ADD NEW USER </a>
     </div>
  </div>

  <table class="table">
    <thead class="thead-dark">
      <tr id="tr_data">
        <th scope="col"> ID </th>
        <th scope="col"> Name </th>
        <th scope="col"> DOB </th>
        <th scope="col"> NIC </th>
        <th scope="col"> Address </th>
        <th scope="col"> Email </th>
        <th scope="col">  </th>
        <th scope="col">  </th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${users}" var="user">
      <tr>
        <th scope="row">${user.usr_id}</th>
        <td>${user.name}</td>
        <td>${user.dob}</td>
        <td>${user.nic}</td>
        <td>${user.address}</td>
        <td>${user.email}</td>
        <td><a href="/edit_user/${user.usr_id}" style="color:blue;text-decoration:none;cursor:pointer">Edit</a></td>
        <td><a href="javascript:void(0)" onclick="deleteUser('${user.usr_id}')" style="color:red;text-decoration:none">Delete</button></td>
      </tr>
      </c:forEach>
    </tbody>
  </table>
  <script src="https://code.jquery.com/jquery-3.1.1.min.js">
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  <script type="text/javascript">
      function deleteUser(id) {
          alert(id)
          var URL = "/delete/" + id;
          $.ajax({
              type: "delete",
              url: URL,
              success: function(msg){
                  alert("Successfully Deleted");
              }
          });
      }
   </script>
  </body>
</html>

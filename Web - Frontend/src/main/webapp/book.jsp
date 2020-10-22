<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title> Book Page </title>
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

  <div class="row marginStyle">
     <div class="col-md-5">
         <form action="/filter_book" method="post">
             <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Search Book Here" name="title">
                    </div>
                </div>
                <div class="col-md-6">
                   <button type="submit" class="btn btn-outline-success my-2 my-sm-0"> Search </button>
                </div>
             </div>
         </form>
     </div>
     <div class="col-md-4">
        <a href="/add-book" class="btn btn-info"> ADD NEW BOOK </a>
     </div>
  </div>

  <table class="table">
    <thead class="thead-dark">
      <tr id="tr_data">
        <th scope="col"> ISBN </th>
        <th scope="col"> Title </th>
        <th scope="col"> Publisher </th>
        <th scope="col"> Number Of Books </th>
        <th scope="col"> Price </th>
        <th scope="col"> Edit </th>
        <th scope="col"> Delete </th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${books}" var="book">
      <tr>
        <th scope="row">${book.isbn}</th>
        <td>${book.title}</td>
        <td>${book.publisher}</td>
        <td>${book.numberOfBooks}</td>
        <td>${book.price}</td>
        <td><a href="/edit_book/${book.isbn}" style="color:blue;text-decoration:none;cursor:pointer">Edit</a></td>
        <td><a href="javascript:void(0)" onclick="deleteUser('${book.isbn}')" style="color:red;text-decoration:none">Delete</button></td>
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

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Profile</title>

    <!-- Bootstrap core CSS -->
    <link href="/resource/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	
    <!-- Custom styles for this template -->
    <link href="/resource/css/shop-homepage.css" rel="stylesheet">
	 <link href="/resource/css/signupstyle.css" rel="stylesheet">
  </head>

  <body>

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="#">Profile Page</a>
        <button class="navbar-toggler" role="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link" href="customerIndex.jsp">Home</a>
            </li> 
            <li class="nav-item active">
              <a class="nav-link" href="profile.jsp">My Profile
                <span class="sr-only">(current)</span>
              </a>
            </li>                  
            <li class="nav-item">
              <a class="nav-link" href="orders.jsp">My Orders</a>
            </li>            
          </ul>
        </div>
      </div>
    </nav>

    <!-- Page Content -->
    <div class="container">

      <div class="row">

        <div class="col-lg-3">

          <h1 class="my-4">Username</h1>
          <div class="list-group">
            <a href="#" class="list-group-item">Name</a>
            <a href="#" class="list-group-item">Surname</a>
            <a href="#" class="list-group-item">Address</a>

            
            
                  <div class="row">
         <div class="login">
            <button id = "updateRegister" role="submit"  class="btn btn-primary btn-block btn-large" name="submit">Update Profile</button>
         </div>
      </div>
 <br><br><br><br><br><br>
 <br><br><br><br><br><br>
          </div>

        </div>
        <!-- /.col-lg-3 -->

        <div class="col-lg-9">

     
          <!-- /.row -->

        </div>
        <!-- /.col-lg-9 -->

      </div>
      <!-- /.row -->

    </div>
    <!-- /.container -->

    <!-- Footer -->
    <footer class="py-5 bg-dark">
      <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Your Website 2017</p>
      </div>
      <!-- /.container -->
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="/resource/vendor/jquery/jquery.min.js"></script>
    <script src="/resource/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  </body>

</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Coffee Shop</title>

    <!-- Bootstrap core CSS -->
    <link href="/resource/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	
    <!-- Custom styles for this template -->
    <link href="/resource/css/shop-homepage.css" rel="stylesheet">
	 <link href="/resource/css/signupstyle2.css" rel="stylesheet">
  </head>

  <body>

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="#">Coffee Page</a>
        <button class="navbar-toggler" role="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <a class="nav-link" href="customerIndex.jsp">Home
                <span class="sr-only">(current)</span>
              </a>
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <!-- Page Content -->
    <div class="container">

      <div class="row">
        <!-- /.col-lg-3 -->

        <div class="col-lg-9">

          <div class="row">

            <div class="col-lg-4 col-md-6 mb-4">
              <div class="card h-100">
                <a href="#"><img class="card-img-top" src="/resource/Images/1.jpg" alt=""></a>
                <div class="card-body">
                  <h4 class="card-title">
                    ${product.getName()}
                  </h4>
                  <h5>${product.getId()}</h5>
                  <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur!</p>
                </div>
              </div>
 
            </div>


          </div>
          <!-- /.row -->
<form class="signup-form" action="/orders/newOrder" method="POST">
      <div class="row">
         <h4>Order Product</h4>
         <div class="input-group input-group-icon">
             <input type="hidden" name="productId" value="${product.getId()}" />
             <input type="text" name="quantity" placeholder="Quantity" required="required" />
             <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <div class="input-icon"><i class="fa fa-user"></i></div>
         </div>
      </div>
      <div class="row">
         <div class="login">
            <button role="submit"  id="orderButton" class="btn btn-primary btn-block btn-large" name="submit">Order</button>
         </div>
       
      </div>
   </form>
   
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

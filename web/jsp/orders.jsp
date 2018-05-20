<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Orders</title>

    <!-- Bootstrap core CSS -->
    <link href="/resource/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<script src="js/index.js"></script>
    <!-- Custom styles for this template -->
    <link href="/resource/css/shop-homepage.css" rel="stylesheet">
	 <link href="/resource/css/signupstyle.css" rel="stylesheet">
  </head>

  <body>

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
          <a class="navbar-brand" href="/jsp/customerIndex.jsp">Orders</a>
        <button class="navbar-toggler" role="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link" href="/customerIndex.jsp">Home</a>
            </li>

          </ul>
        </div>
      </div>
    </nav>

    <!-- Page Content -->
    <div class="container">

      <div class="row">

        <div class="col-lg-3">

          <h1 class="my-4">Orders</h1>
          <div class="list-group">
   
          </div>

        </div>
        <!-- /.col-lg-3 -->

        <div class="col-lg-9">

 <section>
  <!--for demo wrap-->
  <h1></h1>
  <div class="tbl-header">
    <table cellpadding="0" cellspacing="0" border="0">
      <thead>
        <tr>
          <th>Product Name</th>
          <th>Quantity</th>
          <th>Orderer</th>
          <th>Is Sent?</th>
        </tr>
      </thead>
    </table>
  </div>
  <div class="tbl-content">
    <table cellpadding="0" cellspacing="0" border="0">
      <tbody>
      <c:forEach items="${orders}" var="order">
          <tr>
              <td>${order.getProduct().getName()}</td>
              <td>${order.getQuantity()}</td>
              <td>${order.getOrderer().getUsername()}</td>
              <sec:authorize access="hasRole('ROLE_ADMIN')">
                      <c:choose>
                          <c:when test="${order.getStatus().equals(\"new\")}">
                              <td><a href="/orders/setStatus?id=${order.getId()}">Send order!</a></td>
                          </c:when>
                          <c:otherwise>
                              <td>${order.getStatus()}</td>
                          </c:otherwise>
                      </c:choose>
              </sec:authorize>
              <sec:authorize access="hasRole('ROLE_USER')">
                  <td>${order.getStatus()}</td>
              </sec:authorize>
          </tr>
      </c:forEach>
      </tbody>
    </table>

  </div>

</section>
     
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

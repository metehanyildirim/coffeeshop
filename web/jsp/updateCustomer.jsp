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
        <a class="navbar-brand" href="#">Update Customer</a>
        <button class="navbar-toggler" role="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home
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

        <div class="col-lg-3">

        </div>
        <!-- /.col-lg-3 -->

        <div class="col-lg-9">


            <form class="signup-form" action="/users/update" method="POST">
                <div class="row">
                    <h4>Update User</h4>
                    <input type="hidden" name="username" value="${user.getUsername()}"/>
                    <div class="input-group input-group-icon">
                        <input type="password" name="password" value="${user.getPassword()}" required="required"/>
                        <div class="input-icon"><i class="fa fa-key"></i></div>
                    </div>
                    <div class="input-group input-group-icon">
                        <input type="text" name="name" value="${user.getName()}" required="required"/>
                        <div class="input-icon"><i class="fa fa-key"></i></div>
                    </div>
                    <div class="input-group input-group-icon">
                        <input type="text" name="surname" value="${user.getSurname()}" required="required"/>
                        <div class="input-icon"><i class="fa fa-key"></i></div>
                    </div>
                    <div class="input-group input-group-icon">
                        <input type="text" name="address" value="${user.getAddress()}" required="required"/>
                        <div class="input-icon"><i class="fa fa-key"></i></div>
                    </div>
                    <input type="hidden" name="id" value="${user.getId()}"/>
                    <input type="hidden" name="enabled" value=true />
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                </div>
                <div class="row">
                    <div class="col-half">
                        <h4>Role</h4>
                        <div class="input-group">
                            <input type="radio" name="role" value="ROLE_USER" id="gender-male" required/>
                            <label for="gender-male">Customer</label>
                            <input type="radio" name="role" value="ROLE_ADMIN" id="gender-female" required/>
                            <label for="gender-female">Owner</label>
                        </div>
                    </div>
                </div>


        </div>
        <div class="row">
            <div class="login">
                <button role="submit"  class="btn btn-primary btn-block btn-large" name="submit">Create</button>
            </div>
        </div>
        </form>

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

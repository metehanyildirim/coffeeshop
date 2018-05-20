<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
 <link href="/resource/css/registerstyle.css" rel="stylesheet">
</head>
<body>

<div class="container">
   <form class="signup-form" action="/users/add" method="POST">
      <div class="row">
         <h4>Account</h4>
         <div class="input-group input-group-icon">
            <input type="text" name="username" placeholder="Username" required="required"/>
            <div class="input-icon"><i class="fa fa-envelope"></i></div>
         </div>
         <div class="input-group input-group-icon">
            <input type="password" name="password" placeholder="Password" required="required"/>
            <div class="input-icon"><i class="fa fa-key"></i></div>
         </div>
         <div class="input-group input-group-icon">
            <input type="text" name="name" placeholder="Name" required="required"/>
            <div class="input-icon"><i class="fa fa-key"></i></div>
         </div>
         <div class="input-group input-group-icon">
            <input type="text" name="surname" placeholder="Surname" required="required"/>
            <div class="input-icon"><i class="fa fa-key"></i></div>
         </div>
         <div class="input-group input-group-icon">
            <input type="text" name="address" placeholder="Address" required="required"/>
            <div class="input-icon"><i class="fa fa-key"></i></div>
         </div>
         <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
         <input type="hidden" name=enabled value=true />
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
      <div class="row">
         <div class="login">
            <button role="submit"  class="btn btn-primary btn-block btn-large" name="submit">Sign Up</button>
         </div>
      </div>
   </form>
</div>



</body>
</html>
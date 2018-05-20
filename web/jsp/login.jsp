<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
 <link href="/resource/css/style.css" rel="stylesheet">
</head>
<body>
		<div class="login">
    		<h1>Login</h1>
    				<form action="/users/login" method="post">
        				  <input type="text" name="username" placeholder="Username" required="required">
       					  <input type="Password" name="password" placeholder="Password"  required="required" >
						  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
						  <button role="submit" class="btn btn-primary btn-block btn-large" name="submit">Login</button>
   					 </form>
  	    			 <form action="/jsp/register.jsp" method="get">
          				  <button class="btn btn-primary btn-block btn-large">Register</button>
      				 </form>

		</div>
		
	
</body>
</html>
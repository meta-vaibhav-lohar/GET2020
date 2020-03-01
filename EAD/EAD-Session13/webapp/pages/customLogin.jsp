
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring Security Login</title>
<link rel="stylesheet" type="text/css" href="css/main.css">

</head>
<body>
	<div class="container-login100">
		<form action="/login" method="post">
			<div class="form-group">
				<div class="alert alert-primary text-center" role="alert">
					${SPRING_SECURITY_LAST_EXCEPTION.message}</div>
				<label for="exampleInputEmail1">Email address</label> <input
					type="text" class="form-control input100" name="username"
					id="exampleInputEmail1" aria-describedby="emailHelp"
					placeholder="Enter email"> <small id="emailHelp"
					class="form-text text-muted">We'll never share your email
					with anyone else.</small>
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Password</label> <input
					type="password" class="form-control input100" name="password"
					id="exampleInputPassword1" placeholder="Password">
			</div>
			<div>
			<input name="_csrf" type="hidden"
				value="d20b7a2c-2054-4ccf-8f7c-8b9941036fdb" />
			<button type="submit" class="login100-form-btn">Submit</button>
			</div>
		</form>
	</div>
</body>
</html>
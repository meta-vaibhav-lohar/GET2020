<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>

<!--===============================================================================================-->
<link rel="icon" type="image/png" href="images/icons/favicon.ico" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="css/util.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->

</head>
<body>

	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100" style="width : 960px">
				<div class="login100-pic js-tilt" data-tilt>
					<img src="images/parking.png" alt="IMG">
				</div>

					

					<form:form method="POST" modelAttribute="login" action="/login" cssClass="login100-form validate-form">
						<span class="login100-form-title"> Employee Login </span>
						<div class="wrap-input100 validate-input" data-validate="Enter Valid Name">
							<form:input path="emailId" type="text" cssClass="input100" id="exampleInputFirstName" placeholder="Email Id" />
							<span class="focus-input100"></span> <span class="symbol-input100"> 
							<i class="fa fa-envelope" aria-hidden="true"></i>
							</span>
							<form:errors path="emailId" cssClass="text-danger" style="color:red" />
						</div>

						<div class="wrap-input100 validate-input" data-validate = "Password is required">
							<form:input path="password" type="password" cssClass="input100"	id="exampleInputLastName" placeholder="Password" />
							<span class="focus-input100"></span>
							<span class="symbol-input100">
							<i class="fa fa-lock" aria-hidden="true"></i>
							</span>
							<form:errors path="password" cssClass="text-danger" style="color:red" />
						</div>
						
						
						<div class="container-login100-form-btn">
							<button class="login100-form-btn">
							Login
							</button>
						</div>

					<div class="text-center p-t-136">
						<a class="txt2" href="/signup">
							Create your Account
							<i class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
						</a>
					</div>


					</form:form>
			</div>
		</div>
	</div>




	<!--===============================================================================================-->
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/tilt/tilt.jquery.min.js"></script>
	<script>
		$('.js-tilt').tilt({
			scale : 1.1
		})
	</script>
	<!--===============================================================================================-->
	<script src="js/main.js"></script>

</body>
</html>
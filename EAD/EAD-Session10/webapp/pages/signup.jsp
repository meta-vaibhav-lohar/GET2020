<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Login V1</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
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
<link rel="stylesheet" type="text/css" href="css/style.css">
<!--===============================================================================================-->
</head>
<body>

	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<form:form method="POST" modelAttribute="employee" action="/signup">

					<span class="login100-form-title"> Employee SignUp </span>

					<div class="wrap-input100 validate-input"
						data-validate="Valid email is required: ex@abc.xyz">
						<form:input path="fullName" type="text" cssClass="input100"
							id="exampleInputFullName" placeholder="Full Name" />
						<span class="focus-input100"></span> <span class="symbol-input100">
							<i class="fa fa-user" aria-hidden="true"></i>
						</span>
						<form:errors path="emailId" cssClass="text-danger"
							style="color:red" />
					</div>

					<div class="wrap-input100 validate-input"
						data-validate="Valid email is required: ex@abc.xyz">
						<label class="label">
							<form:radiobutton path="gender"	value="male" />Male<span class="checkmark"></span>
						</label> 
						<label class="label">
							<form:radiobutton path="gender" value="female" />Female <span class="checkmark"></span>
						</label> 
						<form:errors path="gender" cssClass="text-danger"
							style="color:red" />
					</div>

					<div class="wrap-input100 validate-input"
						data-validate="Valid email is required: ex@abc.xyz">
						<form:input path="emailId" type="text" cssClass="input100"
							id="exampleInputFirstName" placeholder="Email Id" />
						<span class="focus-input100"></span> <span class="symbol-input100">
							<i class="fa fa-envelope" aria-hidden="true"></i>
						</span>
						<form:errors path="emailId" cssClass="text-danger"
							style="color:red" />
					</div>

					<div class="wrap-input100 validate-input"
						data-validate="Valid email is required: ex@abc.xyz">
						<form:input path="password" type="password" cssClass="input100"
							id="exampleInputPassword" placeholder="Password" />
						<span class="focus-input100"></span> <span class="symbol-input100">
							<i class="fa fa-lock" aria-hidden="true"></i>
						</span>
						<form:errors path="password" cssClass="text-danger"
							style="color:red" />
					</div>

					<div class="wrap-input100 validate-input"
						data-validate="Valid email is required: ex@abc.xyz">
						<label for="cpassword"> <input required type="password"
							id="confirmPass" class="input100" name="cpassword"
							placeholder="Confirm Password" required /> <span
							class="focus-input100"></span> <span class="symbol-input100">
								<i class="fa fa-lock" aria-hidden="true"></i>
						</span>
						</label>
					</div>

					<div class="wrap-input100 validate-input"
						data-validate="Valid email is required: ex@abc.xyz">
						<form:input path="contactNum" type="text" cssClass="input100"
							id="exampleInputContactNum" placeholder="Contact Number" />
						<span class="focus-input100"></span> <span class="symbol-input100">
							<i class="fa fa-phone" aria-hidden="true"></i>
						</span>
						<form:errors path="contactNum" cssClass="text-danger"
							style="color:red" />
					</div>

					<div class="wrap-input100 validate-input"
						data-validate="Valid email is required: ex@abc.xyz">
						<form:select path="organization" cssClass="input100" id="list">
							<form:option value="-" label="--Select organisation--" />
							<form:option value="M1">M1</form:option>
							<form:option value="M2">M2</form:option>
							<form:option value="M3">M3</form:option>
							<form:option value="M4">M4</form:option>
						</form:select>
						<form:errors path="organization" cssClass="text-danger"
							style="color:red" />
					</div>

					<div class="container-login100-form-btn">
						<button class="login100-form-btn">SignUp</button>
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
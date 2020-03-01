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
	<form:form method="POST" modelAttribute="vehicle" action="/vehicle">
	
		<div id="vehicleDiv">
				<span class="login100-form-title"> Vehicle Details </span>
		
			<div class="wrap-input100 validate-input">
				<form:input path="name" type="text" cssClass="input100" id="exampleInputName" placeholder="Vehicle Name" />
				<span class="focus-input100"></span> 
				<span class="symbol-input100">
					<i class="fa fa-car" aria-hidden="true"></i>
				</span>
				<form:errors path="name" cssClass="text-danger" style="color:red" />
			</div>

			<div class="wrap-input100 validate-input">
				<form:select path="vehicleType" cssClass="input100" id="list">
					<form:option value="" label="-- Select Vehicle --" />
					<form:option value="cycle">Cycle</form:option>
					<form:option value="bike">Bike</form:option>
					<form:option value="car">Car</form:option>
				</form:select>
				<form:errors path="vehicleType" cssClass="text-danger" style="color:red" />
			</div>
			
			<div class="wrap-input100 validate-input">
				<form:input path="vehicleNumber" type="text" cssClass="input100" id="exampleInptVehicleNumber" placeholder="Vehicle Number" />
				<span class="focus-input100"></span> 
				<span class="symbol-input100">
				</span>
				<form:errors path="vehicleNumber" cssClass="text-danger" style="color:red" />
			</div>

			<div class="wrap-input100 validate-input">
				<form:input path="employeeId" type="text" cssClass="input100" id="exampleInputEmployeeId" placeholder="Employee Id" />
				<span class="focus-input100"></span> 
				<span class="symbol-input100">
					<i class="fa fa-id-badge" aria-hidden="true"></i>
				</span>
				<form:errors path="employeeId" cssClass="text-danger" style="color:red" />
			</div>

			<div class="wrap-input100 validate-input">
				<form:input path="identification" type="text" cssClass="input100" id="exampleInputIdentification" placeholder="Identification" />
				<span class="focus-input100"></span> 
				<span class="symbol-input100">
					<i class="fa fa-comments" aria-hidden="true"></i>
				</span>
				<form:errors path="identification" cssClass="text-danger" style="color:red" />
			</div>
			
			<div class="container-login100-form-btn">
				<input type="button" class="login100-form-btn" onclick="getPass()" value="Next">
			</div>
			
		</div>
		
		
		
		<!-- Pass Div -->
		<div id="passDiv" style="display:none" >
			<span class="login100-form-title"> Pass Subscription </span>
		
			<div class="wrap-input100 validate-input">
				<label class="label"> 
					<form:radiobutton path="passType" value="Daily" />Daily
					 <span class="checkmark"></span><span id="dailyRate1"></span>
				</label> 
				<label class="label"> 
					<form:radiobutton path="passType" value="Monthly" />Monthly 
					<span class="checkmark"></span><span id="monthlyRate1"></span>	
				</label> 
				<label class="label">
					 <form:radiobutton path="passType" value="Yearly" />Yearly
					  <span class="checkmark"></span><span id="yearlyRate1"></span>
				</label>
				 <br/>
				<form:errors path="passType" cssClass="text-danger" style="color:red" />
			</div>
			<div class="container-login100-form-btn">
				<button class="login100-form-btn" >Submit</button>
			</div>	
			
		</div>
	</form:form>
</div></div>

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
	<script src="js/pageHandle.js"></script>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="/css/profile.css">

<!------ Include the above in your HEAD tag ---------->

</head>
<body>
	<div class="container emp-profile">
		
			<div class="row">
				<div class="col-md-4">
					<div class="profile-img">
					<form action="/upload" method="post" enctype="multipart/form-data">
						<img src="/images/${ imageName }" alt="/images/user-solid.svg" />
						<div class="file btn btn-lg btn-primary">
							Change Photo <input type="file" name="file" />
						</div>
						<div class="file btn btn-lg btn-primary">
							Upload <input type="submit" value="Upload Image" name="Submit">
						</div> 
						</form>
						
					</div>
				</div>
				<div class="col-md-6">
					<div class="profile-head">
						<h5>${ 	employee.fullName }</h5>
						<h6>${ vehicle.employeeId }</h6>
						<ul class="nav nav-tabs" id="myTab" role="tablist">
							<li class="nav-item"><a class="nav-link active"
								id="home-tab" data-toggle="tab" href="#home" role="tab"
								aria-controls="home" aria-selected="true">About</a></li>

						</ul>
					</div>
				</div>
			
				<div class="col-md-2">
				<form action="/edit" method="get">
				<input type="submit" class="profile-edit-btn" name="btnAddMore"	value="Edit Profile" onclick="Edit()"/>
				</form>
				<form action="/logout" method="post">
				<input type="submit" class="profile-edit-btn" name="btnAddMore"	value="Log Out"/>
				</form>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4">
					<div class="profile-work">
						<p>Friends</p>
				 		<c:if test="${not empty friends}">
    					<c:forEach items="${friends}" var="friend">
								<li><a href="/profile/${friend.emailId}">${ friend.fullName }</a></li>
						</c:forEach>
						</c:if>

					</div>
				</div>
				<div class="col-md-8">
					<div class="tab-content profile-tab" id="myTabContent">
						<div class="tab-pane fade show active" id="home" role="tabpanel"
							aria-labelledby="home-tab">
							<div class="row">
								<div class="col-md-6">
									<label>Name</label>
								</div>
								<div class="col-md-6">
									<p>${ employee.fullName }</p>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<label>Email</label>
								</div>
								<div class="col-md-6">
									<p>${ employee.emailId }</p>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<label>Phone</label>
								</div>
								<div class="col-md-6">
									<p>${ employee.contactNum }</p>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<label>Organization</label>
								</div>
								<div class="col-md-6">
									<p>${ employee.organization }</p>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<label>Vehicle Type</label>
								</div>
								<div class="col-md-6">
									<p>${ vehicle.vehicleType }</p>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<label>Vehicle Name</label>
								</div>
								<div class="col-md-6">
									<p>${ vehicle.name }</p>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<label>Vehicle Number</label>
								</div>
								<div class="col-md-6">
									<p>${ vehicle.vehicleNumber }</p>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<label>Pass Type</label>
								</div>
								<div class="col-md-6">
									<p>${ vehicle.passType}</p>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<label>Total Bill</label>
								</div>
								<div class="col-md-6">
									<p>$ ${ vehicle.price}</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
	</div>

</body>
</html>
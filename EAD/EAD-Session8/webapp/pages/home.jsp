<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="/resources/style.css">
<title>Students</title>
</head>

<body>
	<div class="heading">${msg}</div>
	
	<div>
		<div class="link">
			<a href="http://localhost:8080/addStudent">Add Student</a>
		</div>
		<div class="link">
			<a href="http://localhost:8080/allStudent">Show Student</a>
		</div>
	</div>
</body>

</html>
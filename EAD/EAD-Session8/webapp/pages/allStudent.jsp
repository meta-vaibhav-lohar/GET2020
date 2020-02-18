<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../includes/header.jsp"%>


<table class="table table-striped">
	<thead>
		<tr>
			<th>First Name</th>
			<th>Last Last</th>
			<th>Father Name</th>
			<th>Email</th>
			<th>Class</th>
			<th>Age</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${student1}" var="student">


			<tr>
				<td>${student.first_name}</td>
				<td>${student.last_name}</td>
				<td>${student.father_name}</td>
				<td>${student.email}</td>
				<td>${student.student_class}</td>
				<td>${student.age}</td>
			</tr>

		</c:forEach>


	</tbody>
</table>

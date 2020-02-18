<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@include file="../includes/header.jsp"%>

<p>${alert}</p>
<form:form method="POST" modelAttribute="student" action="/add">

	<form:errors />
	<form:hidden path="id" />
	<div class="form-group form-items">
		<form:input path="first_name" type="text" cssClass="input"
			id="exampleInputFirstName" placeholder="First Name" /><br/>
		<form:errors path="first_name" cssClass="text-danger" style="color:red"/>
	</div>

	<div class="form-group form-items">
		<form:input path="last_name" type="text" cssClass="input"
			id="exampleInputLastName" placeholder="Last Name" /><br/>
		<form:errors path="last_name" cssClass="text-danger" style="color:red" />
	</div>

	<div class="form-group form-items">
		<form:input path="father_name" type="text" cssClass="input"
			id="exampleInputFatherName" placeholder="Father Name" /><br/>
		<form:errors path="father_name" cssClass="text-danger" style="color:red" />
	</div>
	<div class="form-group form-items">
		<form:input path="email" type="text" cssClass="input"
			id="exampleInputEmail" placeholder="Email" /><br/>
		<form:errors path="email" cssClass="text-danger" style="color:red" />
	</div>
	<div class="form-group form-items">
		<form:input path="student_class" type="text" cssClass="input"
			id="exampleInputClass" placeholder="Class" /><br/>
		<form:errors path="student_class" cssClass="text-danger" style="color:red"  />
	</div>
	<div class="form-group form-items">
		<form:input path="age" type="text" cssClass="input"
			id="exampleInputAge" placeholder="Age" /><br/>
		<form:errors path="age" cssClass="text-danger" style="color:red" />
	</div>
	<button type="submit" class="btn btn-primary">Submit</button>

</form:form>

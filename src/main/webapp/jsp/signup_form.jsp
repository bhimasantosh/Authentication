<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Registration Form</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<style type="text/css">
.bs-example {
	margin: 20px;
}
/* Fix alignment issue of label on extra small devices in Bootstrap 3.2 */
.form-horizontal .control-label {
	padding-top: 7px;
}
</style>
<%@include file="page_header.html"%>
</head>
<body>
	<div class="bs-example">
		<form:form class="form-horizontal" method="post" action="/sbhima/web/signup" modelAttribute="signupform">
			<div class="form-group">
				<label for="firstName" class="control-label col-xs-2">First
					Name</label>
				<div class="col-xs-3">
					<form:input path="firstName" class="form-control" name="firstName"
						placeholder="First Name"/>
				</div>
			</div>
			<div class="form-group">
				<label for="lastName" class="control-label col-xs-2">Last
					Name</label>
				<div class="col-xs-3">
					<form:input path="lastName" class="form-control" name="lastName"
						placeholder="Last Name"/>
				</div>
			</div>
			<div class="form-group">
				<label for="email" class="control-label col-xs-2">Email</label>
				<div class="col-xs-3">
					<form:input path="email" class="form-control" name="email"
						placeholder="Email"/>
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="control-label col-xs-2">Password</label>
				<div class="col-xs-3">
					<form:password name="password" class="form-control" path="password"
						placeholder="Password"/>
				</div>
			</div>
			<div class="form-group">
				<label for="confirmPassword" class="control-label col-xs-2">Confirm
					Password</label>
				<div class="col-xs-3">
					<form:password path="confirmPassword" class="form-control"
						name="confirmPassword" placeholder="Confirm Password"/>
				</div>
			</div>
			<div class="form-group">
				<div class="col-xs-offset-2 col-xs-3">
					<button type="submit" class="btn btn-primary">Register</button>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>

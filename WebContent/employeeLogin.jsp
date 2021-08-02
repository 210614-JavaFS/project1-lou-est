<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Employee Reimbursement System</title>
<link rel="stylesheet" href="css/ERS.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
</head>

<body>
	<main id="main-holder">
		<h1 id="login-header">Employee Login</h1>

		<c:if test="${not empty error}">
			<div id="login-error-msg-holder" style="color: black;">
				<p id="login-error-msg">
					Invalid username <span id="error-msg-second-line">and/or
						password</span>
				</p>
			</div>
		</c:if>

		<form id="login-form" action="EmployeeLoginServlet" method="post">
			<input type="text" name="username" autocomplete="off"
				id="username-field" class="login-form-field" placeholder="Username">
			<input type="password" name="password" id="password-field"
				class="login-form-field" placeholder="Password"> <input
				type="submit" value="Login" id="login-form-submit">
		</form>
		
		<br> <a
			href="<%=request.getContextPath()%>/FinanceManagerLoginServlet">
			<button>Go to Finance Manager Login</button>
		</a>

		<form autocomplete="off"></form>

	</main>
	<script src="/js/ERS.js"></script>
</body>

</html>
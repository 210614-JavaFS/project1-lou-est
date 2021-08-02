<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>View Past Tickets</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: black">
			<div>
				<a href="#" class="navbar-brand"> ERS </a>
			</div>
			<ul class="navbar-nav">
				<li><a
					href="<%=request.getContextPath()%>/AddReimbursementRequestServlet"
					class="nav-link">Add Reimbursement Request</a></li>
			</ul>
			<ul class="navbar-nav">
				<li><a
					href="<%=request.getContextPath()%>/EmployeeLoginServlet"
					class="nav-link">Logout</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<div class="container">
			<h3 class="text-center">View Past Tickets</h3>
			<hr>
			<br>
			<form>
				<table class="table table-bordered results">
					<thead>
						<tr>
							<th>Amount</th>
							<th>Submitted Time</th>
							<th>Resolved Time</th>
							<th>Description</th>
							<th>Author</th>
							<th>Resolver</th>
							<th>Type</th>
							<th>Status</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="r" items="${pastTickets }">
							<tr>
								<td>${r.reimb_amount}</td>
								<td>${r.submitted}</td>
								<td>${r.resolved}</td>
								<td>${r.description}</td>
								<td>${r.authorName}</td>
								<td>${r.resolverName}</td>
								<td>${r.type}</td>
								<td>${r.status}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</form>
		</div>
	</div>
</body>
</html>

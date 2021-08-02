<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>View all reimbursements for all employees</title>
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
					href="<%=request.getContextPath()%>/FinanceManagerLoginServlet"
					class="nav-link">Logout</a></li>
			</ul>
		</nav>
	</header>
	<br>


	<div class="row">
		<div class="container">
			<h4>Filter requests by status</h4>
			<select name="filterData" onchange="location = this.value;">
				<option value="Choose" selected disabled>Choose</option>
				<option
					value="<%=request.getContextPath()%>/ReimbursementByStatus?statusId=-1">All</option>
				<option
					value="<%=request.getContextPath()%>/ReimbursementByStatus?statusId=0">Pending</option>
				<option
					value="<%=request.getContextPath()%>/ReimbursementByStatus?statusId=1">Accepted</option>
				<option
					value="<%=request.getContextPath()%>/ReimbursementByStatus?statusId=2">Denied</option>
			</select>
		</div>
	</div>

	<div class="row">
		<div class="container">
			<h3 class="text-center">All reimbursements</h3>
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
							<th>Approve Request</th>
							<th>Deny Request</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="r" items="${allReimbursement }">
							<tr>
								<td>${r.reimb_amount}</td>
								<td>${r.submitted}</td>
								<td>${r.resolved}</td>
								<td>${r.description}</td>
								<td>${r.authorName}</td>
								<td>${r.resolverName}</td>
								<td>${r.type}</td>
								<td>${r.status}</td>

								<td><a
									href="FinanceManagerDashboard?action=approve&id=<c:out value='${r.reimb_id}'/>">Approve</a>
									&nbsp;&nbsp;&nbsp;&nbsp;</td>

								<td><a
									href="FinanceManagerDashboard?action=deny&id=<c:out value='${r.reimb_id}'/>">Deny</a>
									&nbsp;&nbsp;&nbsp;&nbsp;</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</form>
		</div>
	</div>
</body>
</html>

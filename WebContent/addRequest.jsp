<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Reimbursement Request</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
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
				<li><a href="<%=request.getContextPath()%>/ViewPastTickets"
					class="nav-link">View Past Tickets</a></li>
			</ul>
			<ul class="navbar-nav">
				<li><a
					href="<%=request.getContextPath()%>/EmployeeLoginServlet"
					class="nav-link">Logout</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="container col-md-6">
		<div class="card" style="padding: 3%;">
			<div class="card-body">
				<form action="AddReimbursementRequestServlet" method="post">

					<h2>Add Reimbursement Request</h2>

					<br>
					<div class="row">
						<label>Amount</label> <input type="text" value=""
							class="form-control" name="reimb_amount" required="required">
					</div>

					<br>
					<div class="row">
						<label>Description</label> <input type="text" value=""
							class="form-control" name="description" required="required">
					</div>

					<br>
					<div class="row">
						<label>Type: &nbsp;&nbsp;&nbsp;&nbsp;</label> <select
							name="typeId">
							<option selected value="0">LODGING</option>
							<option value="1">TRAVEL</option>
							<option value="2">FOOD</option>
							<option value="3">OTHER</option>
						</select>
					</div>
					<br>

					<button type="submit" class="btn btn-success">Add</button>

				</form>
			</div>
		</div>
	</div>
</body>
</html>
package com.revature.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.models.Reimbursement;
import com.revature.services.FinanceManagerReimbursementService;
import com.revature.services.UserService;

public class FinanceManagerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static UserService userService = new UserService();
	private static FinanceManagerReimbursementService fmrs = new FinanceManagerReimbursementService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		System.out.println("Finance Manager Login attempt: username: " + username + ", password: " + password);

		if (userService.isFinanceManagerLogin(username, password)) {
			System.out.println("Login successful");

			HttpSession session = request.getSession();
			session.setAttribute("userId", userService.getFinanceManagerIdByUsername(username));
			session.setAttribute("userType", "fm");

			List<Reimbursement> allReimbursement = fmrs.getAllReimbursement();

			System.out.println("allReimbursement size: " + allReimbursement.size());

			request.setAttribute("allReimbursement", allReimbursement);
			RequestDispatcher dispatcher = request.getRequestDispatcher("financeManagerDashboard.jsp");
			dispatcher.forward(request, response);

		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("financeManagerLogin.jsp");

			HttpSession session = request.getSession();
			session.setAttribute("userId", null);
			session.setAttribute("userType", null);

			request.setAttribute("error", "Incorrect Login");
			System.out.println("Incorrect Employee Login");
			dispatcher.forward(request, response);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("financeManagerLogin.jsp");
		dispatcher.forward(request, response);
	}

}

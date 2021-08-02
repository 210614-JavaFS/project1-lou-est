package com.revature.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.models.Reimbursement;
import com.revature.services.EmployeeReimbursementService;
import com.revature.services.UserService;

public class EmployeeLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static UserService userService = new UserService();
	private static EmployeeReimbursementService ers = new EmployeeReimbursementService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		System.out.println("Employee Login attempt: username: " + username + ", password: " + password);

		if (userService.isEmployeeLogin(username, password)) {

			System.out.println("Login successful");
			
			int userId  =userService.getEmployeeIdByUsername(username);
			
			HttpSession session = request.getSession();
			session.setAttribute("userId", userId);
			session.setAttribute("userType", "e");
			
			List<Reimbursement> pastTickets;

			if (userId != -1) {
				pastTickets = ers.getAllReimbursementByAuthor(userId);
			} else {
				pastTickets = new ArrayList<Reimbursement>();
			}

			System.out.println("pastTickets size: " + pastTickets.size());

			request.setAttribute("pastTickets", pastTickets);
			RequestDispatcher dispatcher = request.getRequestDispatcher("employeeViewPastTickets.jsp");
			
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("employeeLogin.jsp");
			request.setAttribute("error", "Incorrect Login");
			System.out.println("Incorrect Employee Login");
			
			HttpSession session = request.getSession();
			session.setAttribute("userId", null);
			session.setAttribute("userType", null);

			dispatcher.forward(request, response);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("employeeLogin.jsp");
		dispatcher.forward(request, response);
	}

}

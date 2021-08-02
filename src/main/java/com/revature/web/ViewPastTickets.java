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

public class ViewPastTickets extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static EmployeeReimbursementService ers = new EmployeeReimbursementService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Reimbursement> pastTickets;

		HttpSession session = request.getSession();
		int userId = -1;
		if (session.getAttribute("userId") != null) {
			userId = (int) session.getAttribute("userId");
			pastTickets = ers.getAllReimbursementByAuthor(userId);
		} else {
			pastTickets = new ArrayList<Reimbursement>();
		}

		System.out.println("pastTickets size: " + pastTickets.size());

		request.setAttribute("pastTickets", pastTickets);
		RequestDispatcher dispatcher = request.getRequestDispatcher("employeeViewPastTickets.jsp");
		dispatcher.forward(request, response);
	}

}

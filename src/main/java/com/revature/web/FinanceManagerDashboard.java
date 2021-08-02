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

public class FinanceManagerDashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static FinanceManagerReimbursementService fmrs = new FinanceManagerReimbursementService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = "";
		action = request.getParameter("action");
		System.out.println("FinanceManagerDashboard action: " + action);

		HttpSession session = request.getSession();
		int userId = -1;
		if (session.getAttribute("userId") != null)
			userId = (int) session.getAttribute("userId");

		switch (action) {
		case "approve":
			int id = Integer.parseInt(request.getParameter("id"));
			fmrs.acceptReimbursement(id, userId);
			System.out.println("Approve Id: " + id);
			break;

		case "deny":
			id = Integer.parseInt(request.getParameter("id"));
			fmrs.denyReimbursement(id, userId);
			System.out.println("Deny Id: " + id);
			break;

		default:
			break;

		}

		List<Reimbursement> allReimbursement = fmrs.getAllReimbursement();

		System.out.println("allReimbursement size: " + allReimbursement.size());

		request.setAttribute("allReimbursement", allReimbursement);
		RequestDispatcher dispatcher = request.getRequestDispatcher("financeManagerDashboard.jsp");
		dispatcher.forward(request, response);
	}

}

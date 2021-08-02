package com.revature.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.models.Reimbursement;
import com.revature.services.FinanceManagerReimbursementService;

public class ReimbursementByStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static FinanceManagerReimbursementService fmrs = new FinanceManagerReimbursementService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int statusId = -1;
		try {
			statusId = Integer.parseInt(request.getParameter("statusId"));
		} catch (Exception e) {
			System.out.println("No filter found fetching all reimbursement ");
		}

		System.out.println("ReimbursementByStatus id: " + statusId);
		List<Reimbursement> allReimbursement = new ArrayList<Reimbursement>();

		if (statusId == -1) {
			allReimbursement = fmrs.getAllReimbursement();
		} else {
			allReimbursement = fmrs.getAllReimbursementByStatus(statusId);
		}

		System.out.println("allReimbursement size: " + allReimbursement.size());

		request.setAttribute("allReimbursement", allReimbursement);
		RequestDispatcher dispatcher = request.getRequestDispatcher("financeManagerDashboard.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

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
import com.revature.services.EmployeeReimbursementService;

public class AddReimbursementRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static EmployeeReimbursementService ers = new EmployeeReimbursementService();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Reimbursement reimbursement = new Reimbursement();
		List<Reimbursement> pastTickets;

		reimbursement.setReimb_amount(Integer.parseInt(request .getParameter("reimb_amount")));
		reimbursement.setDescription(request .getParameter("description"));
		reimbursement.setTypeId(Integer.parseInt(request .getParameter("typeId")));

		HttpSession session = request.getSession();
		int userId = -1;
		if (session.getAttribute("userId") != null) {
			userId = (int) session.getAttribute("userId");
		}
		
		reimbursement.setAuthor(userId);
		ers.createReimbursementRequest(reimbursement);
		

		pastTickets = ers.getAllReimbursementByAuthor(userId);
		System.out.println("pastTickets size: " + pastTickets.size());

		request.setAttribute("pastTickets", pastTickets);
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("employeeViewPastTickets.jsp");
		dispatcher.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("addRequest.jsp");
		dispatcher.forward(request, response);
	}

}

package com.revature.services;

import java.util.List;

import com.revature.daos.ReimbursementDAO;
import com.revature.daos.ReimbursementDAOImpl;
import com.revature.models.Employee;
import com.revature.models.Reimbursement;

public class EmployeeReimbursementService {

	private static ReimbursementDAO reimbursementDAO = new ReimbursementDAOImpl();

	public boolean createReimbursementRequest(Reimbursement reimbursement) {
		// TODO Auto-generated method stub
		return reimbursementDAO.createRequest(reimbursement);
	}
	
	public List<Reimbursement> getAllReimbursementByAuthor(int authorId) {
		return reimbursementDAO.findAll(authorId);
	}

	/*
	 * public boolean createRequest(Reimbursement reimbursement) { return
	 * reimbursementDAO.createRequest(reimbursement); }
	 */



}

package com.revature.services;

import java.util.List;

import com.revature.daos.ReimbursementDAO;
import com.revature.daos.ReimbursementDAOImpl;
import com.revature.models.Employee;
import com.revature.models.Reimbursement;

public class FinanceManagerReimbursementService {

	private static ReimbursementDAO reimbursementDAO = new ReimbursementDAOImpl();

	public List<Reimbursement> getAllReimbursement() {
		return reimbursementDAO.findAll();
	}

	public List<Reimbursement> getAllReimbursementByStatus(int statusId) {
		return reimbursementDAO.findAllByStatusId(statusId);
	}

	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	public Employee getOneEmployee(String replace) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean acceptReimbursement(int id, int resolverId) {
		return reimbursementDAO.acceptReimbursement(id, resolverId);

	}

	public boolean denyReimbursement(int id, int resolverId) {
		return reimbursementDAO.denyReimbursement(id, resolverId);
	}

}

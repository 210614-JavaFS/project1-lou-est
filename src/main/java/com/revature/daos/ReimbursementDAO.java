package com.revature.daos;

import java.util.List;

import com.revature.models.Employee;
import com.revature.models.Reimbursement;

public interface ReimbursementDAO {

	public List<Reimbursement> findAll();

	public List<Reimbursement> findAll(int authorId);

	public Reimbursement findReimbursement(int id);

	public List<Reimbursement> findAllByStatusId(int statusId);

	public boolean acceptReimbursement(int id, int resolverId);

	public boolean denyReimbursement(int id, int resolverId);

	public boolean createRequest(Reimbursement reimbursement);

	public String findUsernameById(int id);
}

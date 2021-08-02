package com.revature.services;

import com.revature.daos.EmployeeDAOImpl;
import com.revature.daos.FinanceManagerDAOImpl;
import com.revature.models.Employee;
import com.revature.models.FinanceManager;

public class UserService {

	private static EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
	private static FinanceManagerDAOImpl fmDAO = new FinanceManagerDAOImpl();

	public boolean isEmployeeLogin(String username, String password) {
		Employee employee = employeeDAO.findByUsername(username);
		if (employee != null)
			if (employee.getPassword().equals(password))
				return true;

		return false;
	}

	public boolean isFinanceManagerLogin(String username, String password) {
		FinanceManager fm = fmDAO.findByUsername(username);
		if (fm != null)
			if (fm.getPassword().equals(password))
				return true;

		return false;
	}

	public int getEmployeeIdByUsername(String username) {
		Employee employee = employeeDAO.findByUsername(username);
		if (employee != null)
			return employee.getUserId();
		return -1;
	}

	public int getFinanceManagerIdByUsername(String username) {
		FinanceManager fm = fmDAO.findByUsername(username);
		if (fm != null)
			return fm.getUserId();
		return -1;
	}

}

package com.revature.daos;

import java.util.List;

import com.revature.models.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();

	public Employee findByUsername(String username);

	public String findUsernameById(int id);

}

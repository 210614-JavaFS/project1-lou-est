package com.revature.daos;

import java.util.List;

import com.revature.models.FinanceManager;

public interface FinanceManagerDAO {

	public List<FinanceManager> findAll();

	public FinanceManager findByUsername(String username);

	public String findUsernameById(int id);
}

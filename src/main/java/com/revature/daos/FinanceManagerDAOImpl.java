package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.FinanceManager;
import com.revature.securitymanager.RevatureSecurityManager;
import com.revature.utils.ConnectionUtil;

public class FinanceManagerDAOImpl implements FinanceManagerDAO {

	@Override
	public List<FinanceManager> findAll() {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM ers_users\n WHERE ers_user_role_id = 2 ";

			Statement statement = conn.createStatement();

			System.out.println("findAll SQL: " + statement.toString());

			ResultSet result = statement.executeQuery(sql);

			List<FinanceManager> list = new ArrayList<>();

			while (result.next()) {
				FinanceManager fm = new FinanceManager();
				fm.setUserId(result.getInt("ers_users_id"));
				fm.setUsername(result.getString("ers_username"));
				fm.setPassword(RevatureSecurityManager.decrypt(result.getString("ers_password")));
				fm.setFirstName(result.getString("user_first_name"));
				fm.setLastName(result.getString("user_last_name"));
				fm.setEmailAddress(result.getString("user_email"));
				fm.setRoleId(result.getInt("ers_user_role_id"));
				list.add(fm);
			}
			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public FinanceManager findByUsername(String username) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM ers_users\nWHERE ers_username = ? AND ers_user_role_id = 2  ";

			PreparedStatement statement = conn.prepareStatement(sql);

			// this is where sql injection is checked for
			statement.setString(1, username);

			System.out.println("findByUsername SQL: " + statement.toString());

			ResultSet result = statement.executeQuery();

			// ResultSets have a cursor similarly to Scanner
			if (result.next()) {
				FinanceManager fm = new FinanceManager();
				fm.setUserId(result.getInt("ers_users_id"));
				fm.setUsername(result.getString("ers_username"));
				fm.setPassword(RevatureSecurityManager.decrypt(result.getString("ers_password")));
				fm.setFirstName(result.getString("user_first_name"));
				fm.setLastName(result.getString("user_last_name"));
				fm.setEmailAddress(result.getString("user_email"));
				fm.setRoleId(result.getInt("ers_user_role_id"));
				return fm;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public String findUsernameById(int id) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM ers_users\n WHERE ers_users_id = " + id;

			Statement statement = conn.createStatement();

			System.out.println("findUsernameById SQL: " + statement.toString());

			ResultSet result = statement.executeQuery(sql);

			if (result.next()) {
				return result.getString("ers_username");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}

}

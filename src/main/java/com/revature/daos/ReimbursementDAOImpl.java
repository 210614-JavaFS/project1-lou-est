package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;
import com.revature.models.Reimbursement;
import com.revature.utils.ConnectionUtil;

public class ReimbursementDAOImpl implements ReimbursementDAO {

	public List<Reimbursement> findAll() {

		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM ers_reimbursement\n"
					+ "INNER JOIN ers_reimbursement_status ers on ers.reimb_status_id = ers_reimbursement.reimb_status_id \n"
					+ "INNER JOIN ers_reimbursement_type ert on ert.reimb_type_id = ers_reimbursement.reimb_type_id";

			Statement statement = conn.createStatement();

			System.out.println("ReimbursementDAOImpl findAll SQL: " + sql);

			ResultSet result = statement.executeQuery(sql);

			List<Reimbursement> list = new ArrayList<>();

			while (result.next()) {
				Reimbursement reimbursement = new Reimbursement();
				reimbursement.setReimb_id(result.getInt("reimb_id"));
				reimbursement.setReimb_amount(result.getInt("reimb_amount"));
				reimbursement.setSubmitted(result.getString("reimb_submitted"));
				reimbursement.setResolved(result.getString("reimb_resolved"));
				reimbursement.setDescription(result.getString("reimb_description"));
				reimbursement.setAuthor(result.getInt("reimb_author"));
				reimbursement.setResolver(result.getInt("reimb_resolver"));
				reimbursement.setStatusId(result.getInt("reimb_status_id"));
				reimbursement.setStatus(result.getString("reimb_status"));
				reimbursement.setTypeId(result.getInt("reimb_type_id"));
				reimbursement.setType(result.getString("reimb_type"));
				list.add(reimbursement);
			}

			// Adding username from userId of Author and Resolver
			for (Reimbursement reimbursement : list) {
				if (reimbursement.getAuthor() > 0)
					reimbursement.setAuthorName(findUsernameById(reimbursement.getAuthor()));

				if (reimbursement.getResolver() > 0)
					reimbursement.setResolverName(findUsernameById(reimbursement.getResolver()));
			}

			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<Reimbursement> findAll(int authorId) {

		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM ers_reimbursement\n"
					+ "INNER JOIN ers_reimbursement_status ers on ers.reimb_status_id = ers_reimbursement.reimb_status_id \n"
					+ "INNER JOIN ers_reimbursement_type ert on ert.reimb_type_id = ers_reimbursement.reimb_type_id\n"
					+ "WHERE ers_reimbursement.reimb_author = " + authorId;

			Statement statement = conn.createStatement();

			System.out.println("ReimbursementDAOImpl findAll SQL: " + sql);

			ResultSet result = statement.executeQuery(sql);

			List<Reimbursement> list = new ArrayList<>();

			while (result.next()) {
				Reimbursement reimbursement = new Reimbursement();
				reimbursement.setReimb_id(result.getInt("reimb_id"));
				reimbursement.setReimb_amount(result.getInt("reimb_amount"));
				reimbursement.setSubmitted(result.getString("reimb_submitted"));
				reimbursement.setResolved(result.getString("reimb_resolved"));
				reimbursement.setDescription(result.getString("reimb_description"));
				reimbursement.setAuthor(result.getInt("reimb_author"));
				reimbursement.setResolver(result.getInt("reimb_resolver"));
				reimbursement.setStatusId(result.getInt("reimb_status_id"));
				reimbursement.setStatus(result.getString("reimb_status"));
				reimbursement.setTypeId(result.getInt("reimb_type_id"));
				reimbursement.setType(result.getString("reimb_type"));
				list.add(reimbursement);
			}

			// Adding username from userId of Author and Resolver
			for (Reimbursement reimbursement : list) {
				if (reimbursement.getAuthor() > 0)
					reimbursement.setAuthorName(findUsernameById(reimbursement.getAuthor()));

				if (reimbursement.getResolver() > 0)
					reimbursement.setResolverName(findUsernameById(reimbursement.getResolver()));
			}

			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public List<Reimbursement> findAllByStatusId(int statusId) {

		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM ers_reimbursement\n"
					+ "INNER JOIN ers_reimbursement_status ers on ers.reimb_status_id = ers_reimbursement.reimb_status_id \n"
					+ "INNER JOIN ers_reimbursement_type ert on ert.reimb_type_id = ers_reimbursement.reimb_type_id\n"
					+ "WHERE ers_reimbursement.reimb_status_id = " + statusId;

			Statement statement = conn.createStatement();

			System.out.println("ReimbursementDAOImpl findAll SQL: " + sql);

			ResultSet result = statement.executeQuery(sql);

			List<Reimbursement> list = new ArrayList<>();

			while (result.next()) {
				Reimbursement reimbursement = new Reimbursement();
				reimbursement.setReimb_id(result.getInt("reimb_id"));
				reimbursement.setReimb_amount(result.getInt("reimb_amount"));
				reimbursement.setSubmitted(result.getString("reimb_submitted"));
				reimbursement.setResolved(result.getString("reimb_resolved"));
				reimbursement.setDescription(result.getString("reimb_description"));
				reimbursement.setAuthor(result.getInt("reimb_author"));
				reimbursement.setResolver(result.getInt("reimb_resolver"));
				reimbursement.setStatusId(result.getInt("reimb_status_id"));
				reimbursement.setStatus(result.getString("reimb_status"));
				reimbursement.setTypeId(result.getInt("reimb_type_id"));
				reimbursement.setType(result.getString("reimb_type"));
				list.add(reimbursement);
			}

			// Adding username from userId of Author and Resolver
			for (Reimbursement reimbursement : list) {
				if (reimbursement.getAuthor() > 0)
					reimbursement.setAuthorName(findUsernameById(reimbursement.getAuthor()));

				if (reimbursement.getResolver() > 0)
					reimbursement.setResolverName(findUsernameById(reimbursement.getResolver()));
			}

			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean denyReimbursement(int id, int resolverId) {
		boolean rowDeleted = false;
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(
						"UPDATE ers_reimbursement set reimb_status_id = 2 , reimb_resolver = ? , reimb_resolved = now() WHERE reimb_id = ?")) {
			statement.setInt(1, resolverId);
			statement.setInt(2, id);

			System.out.println("denyReimbursement sql: " + statement.toString());

			rowDeleted = statement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowDeleted;
	}

	@Override
	public boolean acceptReimbursement(int id, int resolverId) {
		boolean rowDeleted = false;
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(
						"UPDATE ers_reimbursement set reimb_status_id = 1 , reimb_resolver = ? , reimb_resolved = now() WHERE reimb_id = ?")) {
			statement.setInt(1, resolverId);
			statement.setInt(2, id);

			System.out.println("acceptReimbursement sql: " + statement.toString());

			rowDeleted = statement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowDeleted;
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

	@Override
	public Reimbursement findReimbursement(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean createRequest(Reimbursement reimbursement) {
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(
						"INSERT INTO ers_reimbursement (reimb_amount, reimb_description, reimb_author,"
								+ " reimb_status_id, reimb_type_id ) VALUES " + " (?, ?, ?, ?, ?);")) {
			preparedStatement.setInt(1, reimbursement.getReimb_amount());
			preparedStatement.setString(2, reimbursement.getDescription());
			preparedStatement.setInt(3, reimbursement.getAuthor());
			preparedStatement.setInt(4, 0);
			preparedStatement.setInt(5, reimbursement.getTypeId());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}

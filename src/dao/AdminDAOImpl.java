package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.AccountDetails;
import model.Admin;
import model.Remitter;
import util.Db;

public class AdminDAOImpl implements IAdminDAO {

	int result;
	PreparedStatement pst;

	/*
	 * verifyAdmin will verify the username and password taken from the user with
	 * the database.
	 */
	@Override
	public int verifyAdmin(Admin admin) {
		try {
			pst = Db.getDbProperties().prepareStatement(Query.verifyAdmin);

			pst.setString(1, admin.getId());
			pst.setString(2, admin.getPassword());

			result = 0;

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				result = 1;
			}
		} catch (SQLException e) {
			System.err.println("Invalid admin credentials.");
		}
		return result;
	}

//	Adding account numbers

	@Override
	public int addAccountNumber(AccountDetails accountDetails) {
		try {
			pst = Db.getDbProperties().prepareStatement(Query.addAccountNumber);
			pst.setLong(1, accountDetails.getAccountNumber());
			result = 0;
			result = pst.executeUpdate();

		} catch (SQLException e) {
			System.err.println("Account number already exists");
		}
		return result;
	}

//	Viewing all remitters

	// list naam acha nahi
	@Override
	public List<Remitter> viewAllRemitters() {
		List<Remitter> list = new ArrayList<Remitter>();

		try {
			pst = Db.getDbProperties().prepareStatement(Query.viewAllRemitters);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Remitter remitter = new Remitter(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getLong(4),
						rs.getLong(5), rs.getString(6));
				list.add(remitter);
			}
		} catch (SQLException e) {
			System.err.println("viewAllRemitters() " + e.getMessage());
		}
		return list;
	}

	/*
	 * Searching remitter
	 */
	@Override
	public List<Remitter> searchRemitter(Long accountNo) {
		List<Remitter> searchList = new ArrayList<Remitter>();

		try {
			pst = Db.getDbProperties().prepareStatement(Query.searchRemitter);
			pst.setLong(1, accountNo);

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Remitter remitter = new Remitter(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getLong(4),
						rs.getLong(5), rs.getString(6));
				searchList.add(remitter);
			}
		} catch (SQLException e) {
			System.err.println("searchRemitter() " + e.getMessage() + e.getStackTrace());
		}
		return searchList;
	}

	@Override
	public List<AccountDetails> viewAccountNumbers() {
		List<AccountDetails> accountNumbersList = new ArrayList<AccountDetails>();
		try {
			pst = Db.getDbProperties().prepareStatement(Query.viewAllAccountNumbers);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				AccountDetails accountDetails = new AccountDetails(rs.getLong(1));
				accountNumbersList.add(accountDetails);
			}
		} catch (SQLException e) {
			System.err.println("viewAccountNumbers() " + e.getMessage());
			e.printStackTrace();
		}

		return accountNumbersList;
	}
}

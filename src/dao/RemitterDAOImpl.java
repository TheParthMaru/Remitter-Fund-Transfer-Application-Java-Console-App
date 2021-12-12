package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Remitter;
import model.RemitterPersonal;
import util.Db;

public class RemitterDAOImpl implements IRemitterDAO {
	int result;
	PreparedStatement pst;

	@Override
	public int addRemitter(Remitter remitter) {
		try {
			pst = Db.getDbProperties().prepareStatement(Query.addRemitter);
			pst.setString(1, remitter.getName());
			pst.setString(2, remitter.getPassword());
			pst.setLong(3, remitter.getAccountNumber());
			pst.setLong(4, remitter.getAccountBalance());
			pst.setString(5, remitter.getAccountType());

			result = 0;

			// Inserting values in DB
			result = pst.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Account number does not exists or already in use.");
		}
		return result;
	}

	/*
	 * Verify whether the credentials of remitter exists in db or not.
	 */
	@Override
	public int verifyRemitter(Remitter remitter) {
		try {
			pst = Db.getDbProperties().prepareStatement(Query.remitterLogin);
			pst.setLong(1, remitter.getId());
			pst.setString(2, remitter.getPassword());

			result = 0;

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				result = 1;
			}
		} catch (SQLException e) {
			System.err.println("verifyRemitter() " + e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updateRemitterEmail(RemitterPersonal remitterPersonal) {
		try {
			pst = Db.getDbProperties().prepareStatement(Query.updateRemitterEmail);
			pst.setString(1, remitterPersonal.getEmail());
			pst.setLong(2, remitterPersonal.getRid());

			result = 0;

			result = pst.executeUpdate();
		} catch (SQLException e) {
			System.err.println("updateRemitterEmail() " + e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updateRemitterPassword(Remitter remitter) {
		try {
			pst = Db.getDbProperties().prepareStatement(Query.updateRemitterPassword);
			pst.setString(1, remitter.getPassword());
			pst.setLong(2, remitter.getId());

			result = 0;

			result = pst.executeUpdate();
		} catch (SQLException e) {
			System.err.println("updateRemitterPassword() " + e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updateRemitterMobile(RemitterPersonal remitterPersonal) {

		try {
			pst = Db.getDbProperties().prepareStatement(Query.updateRemitterMobile);
			pst.setLong(1, remitterPersonal.getMobile());
			pst.setLong(2, remitterPersonal.getRid());

			result = 0;

			result = pst.executeUpdate();
		} catch (SQLException e) {
			System.err.println("updateRemitterMobile() " + e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updateRemitterAddress(RemitterPersonal remitterPersonal) {
		try {
			pst = Db.getDbProperties().prepareStatement(Query.updateRemitterAddress);
			pst.setString(1, remitterPersonal.getAddress());
			pst.setLong(2, remitterPersonal.getRid());

			result = 0;

			result = pst.executeUpdate();
		} catch (SQLException e) {
			System.err.println("updateRemitterMobile() " + e.getMessage());
			e.printStackTrace();
		}
		return result;

	}

	@Override
	public int addRemitterDetails(RemitterPersonal remitterPersonal) {
		result = 0;

		try {
			pst = Db.getDbProperties().prepareStatement(Query.addRemitterDetails);
			pst.setLong(1, remitterPersonal.getRid());
			pst.setString(2, remitterPersonal.getEmail());
			pst.setLong(3, remitterPersonal.getMobile());
			pst.setString(4, remitterPersonal.getAddress());

			result = 0;

			result = pst.executeUpdate();
		} catch (SQLException e) {
			System.err.println("addRemitterDetails() " + e.getMessage());
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public List<RemitterPersonal> viewPersonalDetails(RemitterPersonal remitterPersonal) {
		List<RemitterPersonal> list = new ArrayList<RemitterPersonal>();

		try {
			pst = Db.getDbProperties().prepareStatement(Query.viewRemitterDetails);
			pst.setLong(1, remitterPersonal.getRid());

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				remitterPersonal = new RemitterPersonal(rs.getLong(1), rs.getString(2), rs.getLong(3), rs.getString(4));

				list.add(remitterPersonal);
			}
		} catch (SQLException e) {
			System.err.println("viewPersonalDetails() " + e.getMessage());
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public int showRemitterId(Remitter remitter) {
		try {
			pst = Db.getDbProperties().prepareStatement(Query.showRemitterID);
			pst.setLong(1, remitter.getAccountNumber());

			result = 0;

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				result = 1;
				if (result == 1) {

					System.out.println("Your account ID for login is " + rs.getLong(1));
				}
			}
		} catch (SQLException e) {
			System.err.println("showRemitterId() " + e.getMessage());
			e.printStackTrace();
		}

		return result;
	}

}

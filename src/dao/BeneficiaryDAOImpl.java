package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Beneficiary;
import util.Db;

public class BeneficiaryDAOImpl implements IBenificiaryDAO {
	int result;
	PreparedStatement pst;

	// Method to add new beneficiary
	@Override
	public int addBeneficiary(Beneficiary beneficiary) {

		try {
			pst = Db.getDbProperties().prepareStatement(Query.addBeneficiary);
			pst.setLong(1, beneficiary.getAccountNumber());
			pst.setString(2, beneficiary.getName());
			pst.setString(3, beneficiary.getAccountType());
			pst.setString(4, beneficiary.getAccountStatus());
			pst.setString(5, beneficiary.getIfscCode());
			pst.setString(6, beneficiary.getEmail());
			pst.setLong(7, beneficiary.getMaxLimit());
			pst.setLong(8, beneficiary.getRid());
			pst.setLong(9, beneficiary.getAccountBalance());

			result = 0;

			// Inserting values in DB
			result = pst.executeUpdate();
		} catch (SQLException e) {
			System.err.println("addBeneficiary() " + e.getMessage());
		}
		return result;
	}

	// Method to delete beneficiary
	@Override
	public int deleteBeneficiary(Beneficiary beneficiary) {
		try {
			pst = Db.getDbProperties().prepareStatement(Query.deleteBeneficiary);
			pst.setLong(1, beneficiary.getAccountNumber());

			result = 0;

			result = pst.executeUpdate();

		} catch (SQLException e) {
			System.err.println("deleteBeneficiary() " + e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

	// Method to display all existing beneficiaries
	@Override
	public List<Beneficiary> viewAllBeneficiaries(Beneficiary beneficiary) {
		List<Beneficiary> beneficiaries = new ArrayList<Beneficiary>();

		try {
			pst = Db.getDbProperties().prepareStatement(Query.viewAllBeneficiaries);
			pst.setLong(1, beneficiary.getRid());

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				beneficiary = new Beneficiary(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getLong(7), rs.getLong(8), rs.getLong(9));

				beneficiaries.add(beneficiary);
			}
		} catch (SQLException e) {
			System.err.println("viewAllBeneficiaries() " + e.getMessage());
			e.printStackTrace();
		}
		return beneficiaries;
	}

	@Override
	public int updateBeneficiaryName(Beneficiary beneficiary) {

		try {
			pst = Db.getDbProperties().prepareStatement(Query.updateBeneficiaryName);
			pst.setString(1, beneficiary.getName());
			pst.setLong(2, beneficiary.getRid());
			pst.setLong(3, beneficiary.getAccountNumber());

			result = 0;

			result = pst.executeUpdate();
		} catch (SQLException e) {
			System.err.println("updateBeneficiaryName() " + e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updateBeneficiaryAccountStatus(Beneficiary beneficiary) {
		try {
			pst = Db.getDbProperties().prepareStatement(Query.updateBeneficiaryAccountStatus);
			pst.setString(1, beneficiary.getAccountStatus());
			pst.setLong(2, beneficiary.getRid());
			pst.setLong(3, beneficiary.getAccountNumber());

			result = 0;

			result = pst.executeUpdate();
		} catch (SQLException e) {
			System.err.println("updateBeneficiaryAccountStatus() " + e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

}

package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Beneficiary;
import model.Remitter;
import model.Transaction;
import util.Db;

public class TransactionDAOImpl implements ITransactionDAO {
	PreparedStatement pst;
	PreparedStatement pst2;

	int result1, result2;

	java.util.Date date = new java.util.Date();
	java.sql.Date sqlDate = new java.sql.Date(date.getTime());

	@Override
	public Map<String, String> fundTransfer(Remitter remitter, Beneficiary beneficiary) {
		Map<String, String> fundTransfer = new HashMap<String, String>();
		try {
			pst = Db.getDbProperties().prepareStatement(Query.fundTransfer);
			pst.setLong(1, remitter.getId());
			pst.setLong(2, beneficiary.getAccountNumber());

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				fundTransfer.put("R_RID", rs.getString("RID"));
				fundTransfer.put("R_ACCOUNT_BALANCE", rs.getString("Account_Balance"));
				fundTransfer.put("R_ACCOUNT_TYPE", rs.getString("Account_Type"));
				fundTransfer.put("B_ACCOUNT_STATUS", rs.getString("Account_Status"));
				fundTransfer.put("B_ACCOUNT_NUMBER", rs.getString("Account_Number"));
				fundTransfer.put("B_MAX_LIMIT", rs.getString("MAX_LIMIT"));
				fundTransfer.put("B_ACCOUNT_BALANCE", rs.getString("B_Account_Balance"));
			}

		} catch (SQLException e) {
			System.err.println("fundTransfer() " + e.getMessage());
			e.printStackTrace();
		}

		return fundTransfer;
	}

	@Override
	public int updatePostFundTransfer(Remitter remitter, Beneficiary beneficiary, String narration, Long amount) {
		try {
			pst = Db.getDbProperties().prepareStatement(Query.updateRemitterAmount);
			pst.setLong(1, remitter.getAccountBalance());
			pst.setLong(2, remitter.getId());

			pst2 = Db.getDbProperties().prepareStatement(Query.updateBeneficiaryAmount);
			pst2.setLong(1, beneficiary.getAccountBalance());
			pst2.setLong(2, beneficiary.getAccountNumber());

			result1 = 0;
			result2 = 0;

			result1 = pst.executeUpdate();
			result2 = pst2.executeUpdate();

			if (result2 > 0 && result1 > 0) {
				int result = 0;
				pst = Db.getDbProperties().prepareStatement(Query.addTransaction);
				pst.setLong(1, remitter.getId());
				pst.setLong(2, amount);
				pst.setString(3, narration);
				pst.setDate(4, sqlDate);
				pst.setLong(5, beneficiary.getAccountNumber());

				result = pst.executeUpdate();

				System.out.println("Transaction Successfull");
			}

		} catch (SQLException e) {
			System.err.println("updatePostFundTransfer() " + e.getMessage());
			e.printStackTrace();
		}
		return result1 + result2;
	}

	@Override
	public List<Transaction> myTransactionReport(Transaction transaction, Date fromDate, Date toDate) {
		List<Transaction> myTransactions = new ArrayList<Transaction>();

		try {
			pst = Db.getDbProperties().prepareStatement(Query.myTransactions);

			pst.setLong(1, transaction.getRid());
			pst.setDate(2, new java.sql.Date(fromDate.getTime()));
			pst.setDate(3, new java.sql.Date(toDate.getTime()));

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				transaction = new Transaction(rs.getLong(1), rs.getLong(2), rs.getString(3), rs.getDate(4),
						rs.getLong(5));
				myTransactions.add(transaction);
			}
		} catch (SQLException e) {
			System.err.println("myTransactionReport() " + e.getMessage());
			e.printStackTrace();
		}
		return myTransactions;
	}

}

package controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import dao.TransactionDAOImpl;
import model.Beneficiary;
import model.Remitter;
import model.Transaction;

public class TransactionController {
	Transaction transaction;
	Remitter remitter = new Remitter();
	Beneficiary beneficiary = new Beneficiary();

	TransactionDAOImpl impl = new TransactionDAOImpl();

	public void intitiateTransaction(Map<String, String> fundTransfer) {
		Long rBalance = Long.parseLong(fundTransfer.get("R_ACCOUNT_BALANCE"));
		Long bBalance = Long.parseLong(fundTransfer.get("B_ACCOUNT_BALANCE"));
		Long amount = Long.parseLong(fundTransfer.get("T_AMOUNT"));
		rBalance = rBalance - amount;
		bBalance = bBalance + amount;
		fundTransfer.put("R_ACCOUNT_BALANCE", rBalance.toString());
		fundTransfer.put("B_ACCOUNT_BALANCE", bBalance.toString());

//		for (Map.Entry<String, String> entry : fundTransfer.entrySet()) {
//			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
//		}

		remitter.setAccountBalance(rBalance);
		beneficiary.setAccountBalance(bBalance);

	}

	public int fundTransferUtil(Long rid, Long beneficiaryAccountNumber, Long amount) {
		remitter.setId(rid);
		beneficiary.setAccountNumber(beneficiaryAccountNumber);

		Map<String, String> fundTransfer = impl.fundTransfer(remitter, beneficiary);

//		for (Map.Entry<String, String> entry : fundTransfer.entrySet()) {
//			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
//		}

		if (fundTransfer.get("B_ACCOUNT_STATUS").equals("active")) {
			Long balance = Long.parseLong(fundTransfer.get("R_ACCOUNT_BALANCE"));
			Long maxLimit = Long.parseLong(fundTransfer.get("B_MAX_LIMIT"));

			if (maxLimit < amount) {
				System.out.println("Max limit exceeded");
				return 1;
			}
			fundTransfer.put("T_AMOUNT", amount.toString());

			if (fundTransfer.get("R_ACCOUNT_TYPE").equals("salary")) {
				if (balance - amount > 0) {
					intitiateTransaction(fundTransfer);

				} else {
					System.out.println("\nInsufficiant funds");
					return 1;
				}
			} else if (fundTransfer.get("R_ACCOUNT_TYPE").equals("savings")) {
				if (balance - amount > 1000) {
					intitiateTransaction(fundTransfer);
				} else {
					System.out.println("\nInsufficiant funds");
					return 1;
				}

			} else if (fundTransfer.get("R_ACCOUNT_TYPE").equals("current")) {
				if (balance - amount > 3000) {
					intitiateTransaction(fundTransfer);
				} else {
					System.out.println("\nInsufficiant funds");
					return 1;
				}
			}

		} else {
			System.out.println("\nBeneficiary account is inactive");
			return 1;
		}

		return 0;

	}

	public void fundTransfer(Long rid, Long beneficiaryAccountNumber, Long amount, String narration) {
		int status = fundTransferUtil(rid, beneficiaryAccountNumber, amount);

		if (status == 0) {
			impl.updatePostFundTransfer(remitter, beneficiary, narration, amount);

		} else {
			System.out.println("Transaction Failed!");
		}
	}

	public List<Transaction> myTransactionReport(Date fromDate, Date toDate, Long rid) {

		transaction = new Transaction();
		transaction.setRid(rid);

		return impl.myTransactionReport(transaction, fromDate, toDate);
	}
}

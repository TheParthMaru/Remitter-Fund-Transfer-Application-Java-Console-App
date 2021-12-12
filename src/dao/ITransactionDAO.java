package dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import model.Beneficiary;
import model.Remitter;
import model.Transaction;

public interface ITransactionDAO {

	public Map<String, String> fundTransfer(Remitter remitter, Beneficiary beneficiary);

	public int updatePostFundTransfer(Remitter remitter, Beneficiary beneficiary, String narration, Long amount);

	public List<Transaction> myTransactionReport(Transaction transaction, Date fromDate, Date toDate);
}

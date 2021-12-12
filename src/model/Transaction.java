package model;

import java.util.Date;

public class Transaction {

	private Long rid;
	private Long transferrendAmount;
	private String narration;
	private Date dateOfTransaction;
	private Long beneficiaryAccountNumber;

	public Transaction() {
	}

	public Transaction(Long rid, Long transferrendAmount, String narration, Date dateOfTransaction,
			Long beneficiaryAccountNumber) {
		this.rid = rid;
		this.transferrendAmount = transferrendAmount;
		this.narration = narration;
		this.dateOfTransaction = dateOfTransaction;
		this.beneficiaryAccountNumber = beneficiaryAccountNumber;
	}

	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public Long getTransferrendAmount() {
		return transferrendAmount;
	}

	public void setTransferrendAmount(Long transferrendAmount) {
		this.transferrendAmount = transferrendAmount;
	}

	public String getNarration() {
		return narration;
	}

	public void setNarration(String narration) {
		this.narration = narration;
	}

	public Date getDateOfTransaction() {
		return dateOfTransaction;
	}

	public void setDateOfTransaction(Date dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}

	public Long getBeneficiaryAccountNumber() {
		return beneficiaryAccountNumber;
	}

	public void setBeneficiaryAccountNumber(Long beneficiaryAccountNumber) {
		this.beneficiaryAccountNumber = beneficiaryAccountNumber;
	}

	@Override
	public String toString() {
		return String.format("%-7s%-10s%-25s%-30s%s", rid, transferrendAmount, narration, dateOfTransaction,
				beneficiaryAccountNumber);
	}

}

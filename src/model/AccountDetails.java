package model;

public class AccountDetails {
	private Long accountNumber;

	public AccountDetails(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Override
	public String toString() {
		return String.format("%s", accountNumber);
	}
}

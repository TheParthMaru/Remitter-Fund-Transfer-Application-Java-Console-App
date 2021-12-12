package model;

public class Beneficiary {

	private Long accountNumber;
	private String name;
	private String accountType;
	private String accountStatus;
	private String ifscCode;
	private String email;
	private Long maxLimit;
	private Long rid;
	private Long accountBalance;

	public Beneficiary() {

	}

	public Beneficiary(Long accountNumber, String name, String accountType, String accountStatus, String ifscCode,
			String email, Long maxLimit, Long rid, Long accountBalance) {

		this.accountNumber = accountNumber;
		this.name = name;
		this.accountType = accountType;
		this.accountStatus = accountStatus;
		this.ifscCode = ifscCode;
		this.email = email;
		this.maxLimit = maxLimit;
		this.rid = rid;
		this.accountBalance = accountBalance;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getMaxLimit() {
		return maxLimit;
	}

	public void setMaxLimit(Long maxLimit) {
		this.maxLimit = maxLimit;
	}

	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public Long getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Long accountBalance) {
		this.accountBalance = accountBalance;
	}

	@Override
	public String toString() {
		return String.format("%-8s%-20s%-15s%-17s%-15s%-30s%-20s%-15s%s", accountNumber, name, accountType,
				accountStatus, ifscCode, email, maxLimit, rid, accountBalance);
	}

}

package model;

public class Remitter {
	private Long id;
	private String name;
	private String password;
	private Long accountNumber;
	private Long accountBalance;
	private String accountType;

	public Remitter() {

	}

	public Remitter(Long id, String name, String password, Long accountNumber, Long accountBalance,
			String accountType) {

		this.id = id;
		this.name = name;
		this.password = password;
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
		this.accountType = accountType;
	}

	public Remitter(String name, String password, Long accountNumber, Long accountBalance, String accountType) {
		this.name = name;
		this.password = password;
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
		this.accountType = accountType;
	}

	public Remitter(Long id, String password) {
		this.id = id;
		this.password = password;
	}

	public Remitter(Long id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Long getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Long accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	@Override
	public String toString() {
		return String.format("%-10s%-20s%-20s%-20s%-20s%s", id, name, password, accountNumber, accountBalance,
				accountType);
	}

}

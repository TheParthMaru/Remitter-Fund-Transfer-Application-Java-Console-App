package dao;

public interface IValidatorDAO {
	public boolean validateName(String name);

	public boolean validatePassword(String password);

	public boolean validateAccountNumber(Long accountNumber);

	public boolean validateAccountType(String accountType);

	public boolean validateAccountBalance(Long accountBalance, String accountType);

	public boolean validateBeneficiaryAccountType(String accountType);

	public boolean validateBeneficiaryAccountStatus(String accountStatus);

	public boolean validateIfscCode(String ifsc);

	public boolean validateEmail(String email);

	public boolean validateTransferLimit(Long transferLimit);

	public boolean validateRemitterId(Long rid);

	public boolean validateMobile(Long mobile);

	public boolean validateAddress(String address);
}

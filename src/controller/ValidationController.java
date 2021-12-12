package controller;

import dao.ValidatorDAOImpl;

public class ValidationController {
	ValidatorDAOImpl impl = new ValidatorDAOImpl();

	public boolean validateName(String name) {
		return impl.validateName(name);
	}

	public boolean validatePassword(String password) {

		return impl.validatePassword(password);
	}

	public boolean validateAccountNumber(Long accountNumber) {
		return impl.validateAccountNumber(accountNumber);
	}

	public boolean validateAccountType(String accountType) {
		return impl.validateAccountType(accountType);
	}

	public boolean validateAccountBalance(Long accountBalance, String accountType) {
		return impl.validateAccountBalance(accountBalance, accountType);
	}

	public boolean validateBeneficiaryAccountType(String accountType) {
		return impl.validateBeneficiaryAccountType(accountType);
	}

	public boolean validateBeneficiaryAccountStatus(String accountStatus) {
		return impl.validateBeneficiaryAccountStatus(accountStatus);
	}

	public boolean validateIfscCode(String ifsc) {
		return impl.validateIfscCode(ifsc);
	}

	public boolean validateEmail(String email) {
		return impl.validateEmail(email);
	}

	public boolean validateTransferLimit(Long transferLimit) {
		return impl.validateTransferLimit(transferLimit);
	}

	public boolean validateRemitterId(Long rid) {
		return impl.validateRemitterId(rid);
	}

	public boolean validateMobile(Long mobile) {
		return impl.validateMobile(mobile);
	}

	public boolean validateAddress(String address) {
		return impl.validateAddress(address);
	}
}

package dao;

public class ValidatorDAOImpl implements IValidatorDAO {
	boolean isValidated;

	@Override
	public boolean validateName(String name) {
		if (name.equals("")) {
			System.out.println("Name cannot be empty");
		} else if (name.matches("[a-zA-Z ]{3,20}")) {
			isValidated = true;
		} else {
			isValidated = false;
		}

		return isValidated;
	}

	@Override
	public boolean validatePassword(String password) {
		isValidated = false;
		if (password.equals("")) {
			System.out.println("Password cannot be empty");
		} else if (password.matches("((?=.*[a-z])(?=.*[A-Z])(?=.*[@!#$%^&*]).{8,16})")) {
			isValidated = true;
		} else {
			isValidated = false;
		}
		return isValidated;
	}

	@Override
	public boolean validateAccountNumber(Long accountNumber) {
		isValidated = false;

		if (accountNumber == null) {
			System.out.println("Account number cannot be empty");
		} else if (accountNumber < 10000 || accountNumber > 99999) {
			isValidated = false;
		} else {
			isValidated = true;
		}
		return isValidated;

	}

	@Override
	public boolean validateAccountType(String accountType) {
		isValidated = false;

		if (accountType.equals("")) {
			System.out.println("Account type cannot be empty");
		} else if (accountType.equalsIgnoreCase("salary") || accountType.equalsIgnoreCase("savings")
				|| accountType.equals("current")) {
			isValidated = true;
		} else {
			isValidated = false;
		}
		return isValidated;
	}

	@Override
	public boolean validateAccountBalance(Long accountBalance, String accountType) {
		isValidated = false;

		if (accountType.equalsIgnoreCase("salary")) {
			if (accountBalance >= 0) {
				isValidated = true;
			} else {
				isValidated = false;
			}
		} else if (accountType.equals("savings")) {
			if (accountBalance >= 1000) {
				isValidated = true;
			} else {
				isValidated = false;
			}
		} else if (accountType.equals("current")) {
			if (accountBalance >= 3000) {
				isValidated = true;
			} else {
				isValidated = false;
			}
		}

		return isValidated;
	}

	@Override
	public boolean validateBeneficiaryAccountType(String accountType) {
		isValidated = false;

		if (accountType.equalsIgnoreCase("salary") || accountType.equalsIgnoreCase("savings")
				|| accountType.equalsIgnoreCase("current")) {
			isValidated = true;
		} else {
			isValidated = false;
		}
		return isValidated;
	}

	@Override
	public boolean validateBeneficiaryAccountStatus(String accountStatus) {
		isValidated = false;

		if (accountStatus.equalsIgnoreCase("active") || accountStatus.equalsIgnoreCase("inactive")) {
			isValidated = true;
		}

		return isValidated;
	}

	@Override
	public boolean validateIfscCode(String ifsc) {
		isValidated = false;

		if (ifsc.matches("^[A-Za-z]{4}[a-zA-Z0-9]{7}$")) {
			isValidated = true;
		} else {
			isValidated = false;
		}
		return isValidated;
	}

	@Override
	public boolean validateEmail(String email) {
		isValidated = false;

		if (email.matches("[a-zA-Z.]{8,30}[@]{1}[a-zA-Z]{4,10}[.]{1}[a-zA-Z]{2,3}")) {
			isValidated = true;
		} else {
			isValidated = false;
		}
		return isValidated;
	}

	@Override
	public boolean validateTransferLimit(Long transferLimit) {
		isValidated = false;
		if (transferLimit == null) {
			isValidated = false;
		} else if (transferLimit >= 0 && transferLimit <= 2_00_000) {
			isValidated = true;
		}
		return isValidated;
	}

	@Override
	public boolean validateRemitterId(Long rid) {
		isValidated = false;
		if (rid == null) {
			isValidated = false;
		} else if (rid >= 101 && rid <= 999) {
			isValidated = true;
		}
		return isValidated;
	}

	@Override
	public boolean validateMobile(Long mobile) {
		isValidated = false;

		if (mobile >= 1000000000L && mobile <= 9999999999L) {
			isValidated = true;
		} else {
			isValidated = false;
		}

		return isValidated;
	}

	@Override
	public boolean validateAddress(String address) {
		isValidated = false;

		if (address.matches("[a-zA-Z0-9, ]{3,30}")) {
			isValidated = true;
		}

		return isValidated;
	}

}

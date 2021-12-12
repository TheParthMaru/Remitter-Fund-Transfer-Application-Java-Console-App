package controller;

import java.util.List;

import dao.BeneficiaryDAOImpl;
import model.Beneficiary;

public class BeneficiaryController {
	Beneficiary beneficiary;
	BeneficiaryDAOImpl impl = new BeneficiaryDAOImpl();

	public int addBeneficiary(Long accountNumber, String name, String accountType, String accountStatus,
			String ifscCode, String email, Long maxLimit, Long rid, Long accountBalance) {
		beneficiary = new Beneficiary(accountNumber, name, accountType, accountStatus, ifscCode, email, maxLimit, rid,
				accountBalance);

		return impl.addBeneficiary(beneficiary);
	}

	public int deleteBeneficiary(Long accountNumber) {
		beneficiary = new Beneficiary();
		beneficiary.setAccountNumber(accountNumber);
		return impl.deleteBeneficiary(beneficiary);
	}

	public List<Beneficiary> viewAllBeneficiaries(Long rid) {
		beneficiary = new Beneficiary();
		beneficiary.setRid(rid);
		return impl.viewAllBeneficiaries(beneficiary);
	}

	public int updateBeneficiaryName(Long rid, Long accountNumber, String name) {
		beneficiary = new Beneficiary();
		beneficiary.setRid(rid);
		beneficiary.setAccountNumber(accountNumber);
		beneficiary.setName(name);
		return impl.updateBeneficiaryName(beneficiary);
	}

	public int updateBeneficiaryAccountStatus(Long rid, Long accountNumber, String accountStatus) {
		beneficiary = new Beneficiary();
		beneficiary.setRid(rid);
		beneficiary.setAccountNumber(accountNumber);
		beneficiary.setAccountStatus(accountStatus);
		return impl.updateBeneficiaryAccountStatus(beneficiary);
	}
}

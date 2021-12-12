package dao;

import java.util.List;

import model.Beneficiary;

public interface IBenificiaryDAO {
	public int addBeneficiary(Beneficiary beneficiary);

	public int deleteBeneficiary(Beneficiary beneficiary);

	public List<Beneficiary> viewAllBeneficiaries(Beneficiary beneficiary);

	public int updateBeneficiaryName(Beneficiary beneficiary);

	public int updateBeneficiaryAccountStatus(Beneficiary beneficiary);

}

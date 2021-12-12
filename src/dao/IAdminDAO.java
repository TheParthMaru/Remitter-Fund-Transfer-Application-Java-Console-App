package dao;

import java.util.List;

import model.AccountDetails;
import model.Admin;
import model.Remitter;

public interface IAdminDAO {

	public int verifyAdmin(Admin admin);

	public int addAccountNumber(AccountDetails accountDetails);

	public List<AccountDetails> viewAccountNumbers();

	public List<Remitter> viewAllRemitters();

	public List<Remitter> searchRemitter(Long accountNo);

}

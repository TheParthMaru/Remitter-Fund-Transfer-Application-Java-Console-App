package controller;

import java.util.List;

import dao.AdminDAOImpl;
import model.AccountDetails;
import model.Admin;
import model.Remitter;

public class AdminController {
	Remitter remitter;
	AccountDetails accountDetails;
	AdminDAOImpl impl = new AdminDAOImpl();

	/*
	 * Verify admin credentials for admin login
	 */
	public int verifyAdmin(String id, String password) {
		Admin admin = new Admin(id, password);
		return impl.verifyAdmin(admin);
	}

	/*
	 * Add new account number
	 */
	public int addAccountNumber(Long accountNumber) {
		accountDetails = new AccountDetails(accountNumber);

		return impl.addAccountNumber(accountDetails);
	}

	/*
	 * View list of all existing remitters
	 */
	public List<Remitter> viewAllRemitters() {
		return impl.viewAllRemitters();
	}

	/*
	 * Searching remitter
	 */
	public List<Remitter> searchRemitter(Long accountNumber) {

		return impl.searchRemitter(accountNumber);
	}

	/*
	 * View all account numbers
	 */
	public List<AccountDetails> viewAccountNumbers() {
		return impl.viewAccountNumbers();
	}

}

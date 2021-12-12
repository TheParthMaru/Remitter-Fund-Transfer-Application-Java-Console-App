package dao;

public class Query {

	/*
	 * Admin Queries
	 */
	public static String verifyAdmin = "select admin_id, password from admin where admin_id=? and password=?";

	public static String addAccountNumber = "insert into account_details values(?)";

	public static String viewAllRemitters = "select * from remitter order by rid";

	public static String searchRemitter = "select * from remitter where account_number = ?";

	public static String viewAllAccountNumbers = "select * from account_details";

	/*
	 * Remitter Queries
	 */
	public static String addRemitter = "insert into remitter values(seq_1.nextval,?,?,?,?,?)";

	public static String showRemitterID = "select rid from remitter where account_number=?";

	public static String remitterLogin = "select rid, name, password from remitter where rid=? and password=?";

	public static String addRemitterDetails = "insert into remitter_personal values(?,?,?,?)";

	public static String updateRemitterEmail = "update remitter_personal set email=? where rid=?";

	public static String updateRemitterPassword = "update remitter set password=? where rid=?";

	public static String updateRemitterMobile = "update remitter_personal set mobile=? where rid=?";

	public static String updateRemitterAddress = "update remitter_personal set address=? where rid=?";

	public static String viewRemitterDetails = "select * from remitter_personal where rid=?";

	/*
	 * Beneficiary Queries
	 */
	public static String addBeneficiary = "insert into beneficiary values(?,?,?,?,?,?,?,?,?)";

	public static String deleteBeneficiary = "delete from beneficiary where account_number=?";

	public static String viewAllBeneficiaries = "select * from beneficiary where rid=? order by account_number";

	public static String updateBeneficiaryName = "update beneficiary set name=? where rid=? AND account_number=?";

	public static String updateBeneficiaryAccountStatus = "update beneficiary set account_status=? where rid=? AND account_number=?";

	// Fund transfer

	public static String fundTransfer = "select r.rid, r.name, r.account_balance, r.account_type, b.name, b.account_status, b.account_number, b.max_limit, b.account_balance as b_account_balance from remitter r, beneficiary b where r.rid = b.rid and r.rid=? and b.account_number=?";

	public static String updateRemitterAmount = "update remitter set account_balance=? where rid=?";
	public static String updateBeneficiaryAmount = "update beneficiary set account_balance=? where account_number=?";

	// Transaction table insertion
	public static String addTransaction = "insert into transaction values(?, ?, ?, ?, ?)";

	public static String myTransactions = "SELECT * FROM transaction WHERE rid = ? AND date_of_transaction BETWEEN ? AND ?";
}

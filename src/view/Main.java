package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import controller.AdminController;
import controller.BeneficiaryController;
import controller.RemitterController;
import controller.TransactionController;
import controller.ValidationController;
import model.AccountDetails;
import model.Beneficiary;
import model.Remitter;
import model.RemitterPersonal;
import model.Transaction;

public class Main {

	static int option;
	static int result;
	static boolean isValid;
	static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

	// static variables for remitter sign up
	static String remitterName;
	static String remitterPassword;
	static Long remitterAccountNumber;
	static String remitterAccountType;
	static Long remitterAccountBalance;

	// Static Variables for remitter personal details
	static String remitterEmail;
	static Long remitterMobile;
	static String remitterAddress;

	// Static variables for beneficiary registration
	static String beneficiaryName;
	static Long beneficiaryAccountNumber;
	static String beneficiaryAccountType;
	static String beneficiaryAccountStatus;
	static String ifscCode;
	static String beneficiaryEmail;
	static Long transferLimit;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		RemitterController remitterController = new RemitterController();
		AdminController adminController = new AdminController();
		ValidationController validationController = new ValidationController();
		BeneficiaryController beneficiaryController = new BeneficiaryController();
		TransactionController transactionController = new TransactionController();

		/*
		 * Welcome Panel
		 */
		System.out.println("-------------------------------------------------------------");
		System.out.println("|***** WELCOME TO REMITTER - FUND TRANSFER APPLICATION *****|");
		System.out.println("-------------------------------------------------------------");

		/*
		 * Login Panel for selecting whether to login as Admin or Remitter or Sign Up as
		 * a new Remitter.
		 */

		do {

			System.out.println();
			System.out.println("-------------------");
			System.out.println("|***** LOGIN *****|");
			System.out.println("-------------------");
			System.out.println("[1] Admin login");
			System.out.println("[2] Remitter login");
			System.out.println("[3] Sign up as new remitter");
			System.out.println("[4] Exit");
			System.out.print("Enter option -> ");
			option = scan.nextInt();
			scan.nextLine();

			switch (option) {
			case 1:

				System.out.println();
				System.out.println("-------------------------");
				System.out.println("|***** ADMIN LOGIN *****|");
				System.out.println("-------------------------");
				System.out.println("Enter username: ");
				String adminUsername = scan.nextLine();

				System.out.println("Enter password: ");
				String adminpassword = scan.nextLine();

				result = adminController.verifyAdmin(adminUsername, adminpassword);

				if (result > 0) {

					do {
						System.out.println();
						System.out.println("---------------------------");
						System.out.println("|***** WELCOME ADMIN *****|");
						System.out.println("---------------------------");
						System.out.println("SELECT ADMIN OPERATIONS...");
						System.out.println("[1] Add account number");
						System.out.println("[2] Display all account numbers");
						System.out.println("[3] Display all existing remitters");
						System.out.println("[4] Search Remitters");
						System.out.println("[5] Logout");
						System.out.print("Enter option -> ");

						option = scan.nextInt();
						scan.nextLine();

						switch (option) {
						/*
						 * Adding the account number
						 */
						case 1:

							try {

								System.out.println("\nEnter account number: ");
								Long accountNumber = scan.nextLong();
								scan.nextLine();

								isValid = validationController.validateAccountNumber(accountNumber);

								if (isValid) {
									result = adminController.addAccountNumber(accountNumber);
									if (result > 0) {
										System.out.println("Account number added successfully");
									} else {
										System.out.println("Failed to add account number");
									}
								} else {
									System.out.println("Invalid account number. Account number should be of 5 digits");
								}
							} catch (InputMismatchException e) {
								System.err.println(
										"InputMismatchException: Account number can only contain digits and should be of length 5");
							}

							break;

						case 2:
							List<AccountDetails> viewAllAccounts = adminController.viewAccountNumbers();
							if (viewAllAccounts.size() > 0) {
								System.out.println();
								System.out.format("%s\n", "Account Numbers");
								for (AccountDetails accountNumber : viewAllAccounts) {
									System.out.println(accountNumber);
								}
							} else {
								System.out.println("\nNo records found\n");
							}
							break;

						/*
						 * Displaying all the remitters
						 */
						case 3:
							List<Remitter> remittersList = adminController.viewAllRemitters();
							if (remittersList.size() > 0) {
								System.out.println();
								System.out.format("%-10s%-20s%-20s%-20s%-20s%s\n", "ID", "Name", "Password",
										"Account Number", "Account Balance", "Account Type");
								for (Remitter remitter : remittersList) {
									System.out.println(remitter);
								}
							} else {
								System.out.println("\nNo records found\n");
							}
							break;

						/*
						 * Searching remitter by account number
						 */
						case 4:
							System.out.println("\nEnter account number: ");
							Long accountNo = scan.nextLong();
							scan.nextLine();

							List<Remitter> searchList = adminController.searchRemitter(accountNo);
							if (searchList.size() > 0) {
								System.out.println();
								System.out.format("%-10s%-20s%-20s%-20s%-20s%s\n", "ID", "Name", "Password",
										"Account Number", "Account Balance", "Account Type");
								for (Remitter remitter : searchList) {
									System.out.println(remitter);
								}
							} else {
								System.out.println("\nNo records found\n");
							}
							break;

						/*
						 * Admin Logout
						 */
						case 5:
							System.out.println("\nSuccessfully logged out");
							break;

						default:
							System.out.println("\nInvalid option... Please enter correct option");
						}

					} while (option != 5);

				} else {
					System.out.println("\nInvalid Credentials!!! Please try again...");
				}

				break;

			/*
			 * Remitter Login
			 */
			case 2:
				System.out.println();
				System.out.println("----------------------------");
				System.out.println("|***** REMITTER LOGIN *****|");
				System.out.println("----------------------------");

				System.out.println("Enter Id: ");
				Long remitterLoginId = scan.nextLong();
				scan.nextLine();

				System.out.println("Enter password: ");
				String remitterLoginPassword = scan.nextLine();

				result = remitterController.verifyRemitter(remitterLoginId, remitterLoginPassword);

				if (result > 0) {
					int remitterOption;

					do {
						System.out.println();
						System.out.println("------------------------------");
						System.out.println("|***** WELCOME REMITTER *****|");
						System.out.println("------------------------------");
						System.out.println("SELECT REMITTER OPERATIONS...");
						System.out.println("[1] Beneficiary registration");
						System.out.println("[2] Fund transfer");
						System.out.println("[3] My Transactions");
						System.out.println("[4] View all beneficiaries");
						System.out.println("[5] Add personal details");
						System.out.println("[6] View personal details");
						System.out.println("[7] Update personal details");
						System.out.println("[8] Update beneficiary's details");
						System.out.println("[9] Delete beneficiary");
						System.out.println("[10] Logout");
						System.out.print("Enter option -> ");
						remitterOption = scan.nextInt();
						scan.nextLine();

						switch (remitterOption) {

						// New beneficiary registration
						case 1:
							System.out.println();
							System.out.println("--------------------------------------");
							System.out.println("|***** BENIFICIARY REGISTRATION *****|");
							System.out.println("--------------------------------------");
							System.out.println("Note: Please provide correct credentials");

							isValid = false;
							while (isValid == false) {
								System.out.println("Enter name: ");
								beneficiaryName = scan.nextLine();
								isValid = validationController.validateName(beneficiaryName);

								if (isValid) {
									System.out.println("Valid name\n");
									break;
								} else {
									System.out.println("Invalid name\n");
								}
							}

							isValid = false;
							while (isValid == false) {
								System.out.println("Enter account number: ");
								beneficiaryAccountNumber = scan.nextLong();
								scan.nextLine();

								isValid = validationController.validateAccountNumber(beneficiaryAccountNumber);

								if (isValid) {
									System.out.println("Valid account number\n");
									break;
								} else {
									System.out.println("Invalid account number\n");
								}
							}

							isValid = false;
							while (isValid == false) {
								System.out.println("Enter account type: (salary/savings/current)");
								beneficiaryAccountType = scan.nextLine();

								isValid = validationController.validateBeneficiaryAccountType(beneficiaryAccountType);

								if (isValid) {
									System.out.println("Valid account type\n");
									break;
								} else {
									System.out.println("Invalid account type\n");
								}
							}

							isValid = false;
							isValid = false;
							while (isValid == false) {
								System.out.println("Enter account status: (active/inactive)");
								beneficiaryAccountStatus = scan.nextLine();

								isValid = validationController
										.validateBeneficiaryAccountStatus(beneficiaryAccountStatus);

								if (isValid) {
									System.out.println("Valid account status\n");
									break;
								} else {
									System.out.println("Invalid account status\n");
								}
							}

							isValid = false;
							while (isValid == false) {
								System.out.println("Enter ifsc code: ");
								ifscCode = scan.nextLine();

								isValid = validationController.validateIfscCode(ifscCode);

								if (isValid) {
									System.out.println("Valid IFSC number\n");
									break;
								} else {
									System.out.println("Invalid IFSC number\n");
								}
							}

							isValid = false;
							while (isValid == false) {
								System.out.println("Enter email: ");
								beneficiaryEmail = scan.nextLine();

								isValid = validationController.validateEmail(beneficiaryEmail);

								if (isValid) {
									System.out.println("Valid email\n");
									break;
								} else {
									System.out.println("Invalid email\n");
								}
							}

							isValid = false;
							while (isValid == false) {
								System.out.println("Enter max limit: ");
								transferLimit = scan.nextLong();
								scan.nextLine();

								isValid = validationController.validateTransferLimit(transferLimit);

								if (isValid) {
									System.out.println("Valid limit\n");
									break;
								} else {
									System.out.println("Invalid limit\n");
								}
							}

							result = beneficiaryController.addBeneficiary(beneficiaryAccountNumber, beneficiaryName,
									beneficiaryAccountType, beneficiaryAccountStatus, ifscCode, beneficiaryEmail,
									transferLimit, remitterLoginId, 0L);

							if (result > 0) {
								System.out.println("\nBeneficiary Successfully added");
							} else {
								System.out.println("\nFailed to add beneficiary");
							}
							break;

						// Fund transfer
						case 2:
							System.out.println();
							System.out.println("---------------------------");
							System.out.println("|***** FUND TRANSFER *****|");
							System.out.println("---------------------------");
							System.out.println("\nMY BENEFICIARIES");
							List<Beneficiary> beneficiaries = beneficiaryController
									.viewAllBeneficiaries(remitterLoginId);
							if (beneficiaries.size() > 0) {
								System.out.println();
								System.out.format("%-8s%-20s%-15s%-17s%-15s%-30s%-20s%s\n", "Acc No", "Name",
										"Account Type", "Account Status", "IFSC Code", "Email", "Max Transfer Limit",
										"Remitter ID");
								for (Beneficiary beneficiary : beneficiaries) {
									System.out.println(beneficiary);
								}
							} else {
								System.out.println("\nNo records found\n");
							}

							System.out.println("\nEnter beneficiary's account number: ");
							beneficiaryAccountNumber = scan.nextLong();
							scan.nextLine();

							System.out.println("Enter amount: ");
							Long amount = scan.nextLong();
							scan.nextLine();

							System.out.println("Enter narration: ");
							String narration = scan.nextLine();

							transactionController.fundTransfer(remitterLoginId, beneficiaryAccountNumber, amount,
									narration);

							break;

						// Transaction reports

						case 3:
							try {
								System.out.println();
								System.out.println("-----------------------------");
								System.out.println("|***** MY TRANSACTIONS *****|");
								System.out.println("-----------------------------");
								System.out.println("Enter from date: (dd-MM-yyyy)");
								String from = scan.nextLine();
								System.out.println("Enter to date: (dd-MM-yyyy)");
								String to = scan.nextLine();

								Date fromDate = sdf.parse(from);
								Date toDate = sdf.parse(to);

								List<Transaction> myTransactions = transactionController.myTransactionReport(fromDate,
										toDate, remitterLoginId);

								if (myTransactions.size() > 0) {
									System.out.println();
									System.out.format("%-7s%-10s%-25s%-30s%s\n", "RID", "Amount", "Narration",
											"Date of transaction", "Beneficiary account number");
									for (Transaction transaction : myTransactions) {
										System.out.println(transaction);
									}
								} else {
									System.out.println("No transactions found");
								}

							} catch (ParseException e) {
								System.err.println("Please check input date format");
								e.printStackTrace();
							}
							break;

						// View all beneficiaries
						case 4:
							List<Beneficiary> beneficiariesList = beneficiaryController
									.viewAllBeneficiaries(remitterLoginId);
							if (beneficiariesList.size() > 0) {
								System.out.println();
								System.out.format("%-8s%-20s%-15s%-17s%-15s%-30s%-20s%-15s%s\n", "Acc No", "Name",
										"Account Type", "Account Status", "IFSC Code", "Email", "Max Transfer Limit",
										"Remitter ID", "Account Balance");
								for (Beneficiary beneficiary : beneficiariesList) {
									System.out.println(beneficiary);
								}
							} else {
								System.out.println("\nNo records found\n");
							}
							break;

						// Add personal details
						case 5:
							System.out.println();
							System.out.println("----------------------------------");
							System.out.println("|***** ADD PERSONAL DETAILS *****|");
							System.out.println("----------------------------------");

							isValid = false;
							while (isValid == false) {
								System.out.println("Enter email: ");
								remitterEmail = scan.nextLine();

								isValid = validationController.validateEmail(remitterEmail);

								if (isValid) {
									System.out.println("Valid email\n");
									break;
								} else {
									System.out.println("Invalid email\n");
								}
							}

							isValid = false;
							while (isValid == false) {
								System.out.println("Enter mobile: ");
								remitterMobile = scan.nextLong();
								scan.nextLine();

								isValid = validationController.validateMobile(remitterMobile);

								if (isValid) {
									System.out.println("Valid mobile\n");
									break;
								} else {
									System.out.println("Invalid mobile\n");
								}
							}

							isValid = false;
							while (isValid == false) {
								System.out.println("Enter address: ");
								remitterAddress = scan.nextLine();

								isValid = validationController.validateAddress(remitterAddress);

								if (isValid) {
									System.out.println("Valid address\n");
									break;
								} else {
									System.out.println("Invalid address\n");
								}
							}

							result = remitterController.addRemitterDetails(remitterLoginId, remitterEmail,
									remitterMobile, remitterAddress);
							if (result > 0) {
								System.out.println("Personal details added successfully");
							} else {
								System.out.println("Failed to add personal details");
							}

							break;

						// View personal details
						case 6:
							List<RemitterPersonal> list = remitterController.viewRemitterDetails(remitterLoginId);

							if (list.size() > 0) {
								System.out.println();
								System.out.format("%-6s%-30s%-16s%s\n", "ID", "Email", "Mobile", "Address");
								for (RemitterPersonal remitterPersonal : list) {
									System.out.println(remitterPersonal);
								}
							} else {
								System.out.println("\nNo records found\n");
							}

							break;

						// Update remitter's details
						case 7:
							int updateOption;
							do {
								System.out.println();
								System.out.println("---------------------------------------");
								System.out.println("|***** UPDATE REMITTER'S DETAILS *****|");
								System.out.println("---------------------------------------");
								System.out.println("[1] Update email");
								System.out.println("[2] Update password");
								System.out.println("[3] Update mobile number");
								System.out.println("[4] Update address");
								System.out.println("[5] Go back");
								System.out.print("Enter option -> ");
								updateOption = scan.nextInt();
								scan.nextLine();

								switch (updateOption) {
								// Update Email
								case 1:
									System.out.println("Enter email: ");
									String email = scan.nextLine();

									isValid = validationController.validateEmail(email);

									if (isValid) {
										result = remitterController.updateRemitterEmail(remitterLoginId, email);
										if (result > 0) {
											System.out.println("Email updation successful");
										} else {
											System.out.println("Failed to update email.");
										}
									} else {
										System.out.println("Invalid email entered");
									}
									break;

								// Update password
								case 2:
									System.out.println("Enter password: ");
									remitterLoginPassword = scan.nextLine();

									isValid = validationController.validatePassword(remitterLoginPassword);

									if (isValid) {
										result = remitterController.updateRemitterPassword(remitterLoginId,
												remitterLoginPassword);
										if (result > 0) {
											System.out.println("Password updation successful");
										} else {
											System.out.println("Failed to update password.");
										}
									} else {
										System.out.println("Invalid password entered");
									}

									break;

								// Update mobile number
								case 3:
									System.out.println("Enter mobile number: ");
									Long mobile = scan.nextLong();
									scan.nextLine();

									isValid = validationController.validateMobile(mobile);

									if (isValid) {
										result = remitterController.updateRemitterMobile(remitterLoginId, mobile);
										if (result > 0) {
											System.out.println("Mobile number updation successful");
										} else {
											System.out.println("Failed to update mobile number.");
										}
									} else {
										System.out.println("Invalid mobile entered");
									}
									break;

								// Update address
								case 4:
									System.out.println("Enter address: ");
									String address = scan.nextLine();

									isValid = validationController.validateAddress(address);

									if (isValid) {
										result = remitterController.updateRemitterAddress(remitterLoginId, address);
										if (result > 0) {
											System.out.println("Remitter's address updation successful");
										} else {
											System.out.println("Failed to update remitter's address.");
										}
									} else {
										System.out.println("Invalid address entered");
									}
									break;

								// Exit update operation
								case 5:
									break;
								}
							} while (updateOption != 5);
							break;

						// Update beneficiary's details
						case 8:
							int option;
							do {
								System.out.println();
								System.out.println("------------------------------------------");
								System.out.println("|***** UPDATE BENEFICIARY'S DETAILS *****|");
								System.out.println("------------------------------------------");
								System.out.println("[1] Update name");
								System.out.println("[2] Update account status");
								System.out.println("[3] Exit");
								System.out.println("Enter option ->");
								option = scan.nextInt();
								scan.nextLine();

								switch (option) {

								// Update beneficiary name
								case 1:
									System.out.println("Enter new name: ");
									beneficiaryName = scan.nextLine();

									System.out.println("Enter beneficiary account number: ");
									beneficiaryAccountNumber = scan.nextLong();
									scan.nextLine();

									isValid = validationController.validateName(beneficiaryName)
											&& validationController.validateAccountNumber(beneficiaryAccountNumber);

									if (isValid) {
										result = beneficiaryController.updateBeneficiaryName(remitterLoginId,
												beneficiaryAccountNumber, beneficiaryName);
										if (result > 0) {
											System.out.println("Beneficiary name updated successfully");
										} else {
											System.out.println("Failed to update beneficiary name.");
										}
									} else {
										System.out.println("Invalid name entered");
									}

									break;

								// Update beneficiary account status
								case 2:
									System.out.println("Enter account status: (active/inactive)");
									beneficiaryAccountStatus = scan.nextLine();

									System.out.println("Enter beneficiary account number: ");
									beneficiaryAccountNumber = scan.nextLong();
									scan.nextLine();

									isValid = validationController
											.validateBeneficiaryAccountStatus(beneficiaryAccountStatus)
											&& validationController
													.validateBeneficiaryAccountStatus(beneficiaryAccountStatus);

									if (isValid) {
										result = beneficiaryController.updateBeneficiaryAccountStatus(remitterLoginId,
												beneficiaryAccountNumber, beneficiaryAccountStatus);
										if (result > 0) {
											System.out.println("Beneficiary account status updated successfully");
										} else {
											System.out.println("Failed to update beneficiary account status.");
										}
									} else {
										System.out.println("Invalid status entered");
									}

									break;

								// Go back
								case 3:
									break;

								default:
									System.out.println("Invalid option selected");
									break;

								}
							} while (option != 3);

							break;

						// Delete beneficiary
						case 9:
							System.out.println("Enter beneficiary's account number: ");
							beneficiaryAccountNumber = scan.nextLong();
							scan.nextLine();

							System.out.println("Are you sure you want to delete beneficiary? (y/n)");
							Character answer = scan.next().charAt(0);

							if (answer == 'y' || answer == 'Y') {
								result = beneficiaryController.deleteBeneficiary(beneficiaryAccountNumber);
								if (result > 0) {
									System.out.println("Beneficiary successfully deleted.");
								} else {
									System.out.println("Invalid account number entered.");
								}
							} else if (answer == 'n' || answer == 'N') {
								System.out.println("Beneficiary deletion cancelled.");
								break;
							}

							break;

						// Remitter logout
						case 10:
							System.out.println("\nSuccessfully logged out");
							break;

						default:
							System.out.println("Invalid Option");

						}
					} while (remitterOption != 10);
				} else {
					System.out.println("\nRemitter not found");
				}

				break;

			/*
			 * Remitter Sign up
			 */
			case 3:

				System.out.println();
				System.out.println("-----------------------------------------");
				System.out.println("|***** WELCOME TO REMITTER SIGN UP *****|");
				System.out.println("-----------------------------------------");
				System.out.println("Note: Please provide correct credentials");

				isValid = false;
				while (isValid == false) {
					System.out.println("Enter name: ");
					remitterName = scan.nextLine();
					isValid = validationController.validateName(remitterName);

					if (isValid) {
						System.out.println("Valid name\n");
						break;
					} else {
						System.out.println("Invalid name\n");
					}
				}

				isValid = false;
				while (isValid == false) {
					System.out.println(
							"Password must contains atleast one lowercase, one alphabet, one digit[0-9] and one special character[@!#$%^&*]");
					System.out.println("Create password: ");
					remitterPassword = scan.nextLine();

					isValid = validationController.validatePassword(remitterPassword);
					if (isValid) {
						System.out.println("Valid password\n");
						break;
					} else {
						System.out.println("Invalid password\n");
					}
				}

				isValid = false;
				while (isValid == false) {
					System.out.println("Enter account number: ");
					remitterAccountNumber = scan.nextLong();
					scan.nextLine();

					isValid = validationController.validateAccountNumber(remitterAccountNumber);
					if (isValid) {
						System.out.println("Valid account number\n");
						break;
					} else {
						System.out.println("Invalid account number\n");
					}
				}

				isValid = false;
				while (isValid == false) {
					System.out.println("For salary account you can have 0 balance account.");
					System.out.println("For savings account you need to have minimum balance of Rs 1000.");
					System.out.println("For current account you need to have minimum balance of Rs 3000.");

					System.out.println("Enter account type: (salary/savings/current)");
					remitterAccountType = scan.nextLine();

					System.out.println("Enter account balance: ");
					remitterAccountBalance = scan.nextLong();
					scan.nextLine();

					isValid = validationController.validateAccountType(remitterAccountType);
					if (isValid) {
						System.out.println("Valid account type");
					} else {
						System.out.println("Invalid account type");
					}

					isValid = validationController.validateAccountBalance(remitterAccountBalance, remitterAccountType);
					if (isValid) {
						System.out.println("Valid account balance");
						break;
					} else {
						System.out.println("Invalid account balance\n");
					}
				}

				result = remitterController.addRemitter(remitterName, remitterPassword, remitterAccountNumber,
						remitterAccountBalance, remitterAccountType);

				if (result > 0) {
					System.out.println("\nRemitter creation successful.");
					result = remitterController.showRemitterId(remitterAccountNumber);
					System.out.println("Thank you for registering with us.");
				} else {
					System.out.println("\nFailed in creating new remitter");
				}

				break;

			/*
			 * Exit Application
			 */
			case 4:
				System.out.println("\nThank You Using Remitter - Fund Transfer Application");
				break;

			default:
				System.out.println("\nInvalid option... Please enter correct option");
			}

		} while (option != 4);

		scan.close();

	}
}

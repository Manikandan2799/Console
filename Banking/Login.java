package bankingsystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Login extends UsesForCustomer {
	Scanner scanner = new Scanner(System.in);

	protected void loginCustomer(ArrayList<CustomerDetail> customerList, ArrayList<TransactionDetail> transactionList) {
		int runLoop = 1;
		repeat: while (runLoop == 1) {

			int accountNumberInOrNot = 0;

			System.out.println("Enter account number : ");
			int accountNumber = scanner.nextInt();
			for (CustomerDetail listCustomer : customerList) {
				if (listCustomer.accountNumber == accountNumber) {
					accountNumberInOrNot = 1;
				}
			}
			if (accountNumberInOrNot == 0) {
				System.out.println("Account Number Doesn't not exist..Create New account or Login Again");
				break repeat;
			}
			for (CustomerDetail listCustomer : customerList) {
				if (listCustomer.accountNumber == accountNumber) {
					boolean looping = true;
					int wrongPassword = 0;
					System.out.println("Enter your password");
					String password = scanner.next();
					while (looping) {

						if (password.equals(listCustomer.password)) {
							usesForCustomer(listCustomer, transactionList, customerList);
							System.out.println("Do you want continue ..press 1..");
							int choice = scanner.nextInt();
							if (choice == 1)
								looping = true;
							else
								looping = false;
						} else if (wrongPassword < 2) {
							System.out.println("Re-enter password : ");
							password = scanner.next();
							wrongPassword++;
						} else {
							System.out.println("Goto change password");
							wrongPassword = 0;
							changePassword(listCustomer);

						}
					}

				}
			}
			runLoop = 0;
		}
	}

	private boolean changePassword(CustomerDetail customerInfo) {
		System.out.println("Enter new password :");
		String newPassword = scanner.next();
		while (true) {
			if (checkValidPassword(newPassword)) {
				customerInfo.password = newPassword;
				System.out.println("Your password accepted");
				return true;
			} else {
				System.out.println("Re-enter password");
				newPassword = scanner.next();
			}
		}
	}

	protected boolean checkValidPassword(String newPassword) {
		if (newPassword.length() <= 6)
			return false;
		char arr[] = newPassword.toCharArray();
		int upper = 0, lower = 0, numeric = 0;
		for (int i = 0; i < newPassword.length(); i++) {
			if (arr[i] >= 'A' && arr[i] <= 'Z')
				upper++;
			if (arr[i] >= 'a' && arr[i] <= 'z')
				lower++;
			if (arr[i] >= '0' && arr[i] <= '9')
				numeric++;
		}
		if (upper > 0 && lower > 0 && numeric > 0) {
			return true;
		}
		return false;
	}
}

package bankingsystem;

import java.util.ArrayList;
import java.util.Scanner;

public class UsesForCustomer {
	Scanner scanner = new Scanner(System.in);

	protected void usesForCustomer(CustomerDetail customerInfo, ArrayList<TransactionDetail> transactionInfo,
			ArrayList<CustomerDetail> customerList) {
		System.out.println("Enter yout option : ");
		System.out.println("1.View Transaction");
		System.out.println("2.Withdraw");
		System.out.println("3.Deposit");
		int customerOption = scanner.nextInt();
		switch (customerOption) {
		case 1:
			viewTransaction(customerInfo, transactionInfo);
			break;
		case 2:
			withdrawAmount(customerInfo, transactionInfo);
			break;
		case 3:
			depositAmount(customerInfo, transactionInfo, customerList);
			break;
		default:
			break;
		}
	}

	protected void viewTransaction(CustomerDetail customerInfo, ArrayList<TransactionDetail> transactionList) {
		int accountNumber = customerInfo.accountNumber;
		System.out.println("-----------------------------------------------------------");
		System.out.println("Name : " + customerInfo.customerName + "\tAccount.No :" + customerInfo.accountNumber);
		System.out.println("Mode Of Payment\t\tBanking method\t\tAmount\t\tBalance");
		System.out.println("-----------------------------------------------------------");

		for (TransactionDetail transaction : transactionList) {
			if (accountNumber == transaction.accountNumber)
				System.out.println(transaction.transactionThrough + "\t\t" + transaction.method + "\t\t"
						+ transaction.amount + "\t\t" + transaction.accountBalance);
		}
		System.out.println("-----------------------------------------------------------");

	}

	private void withdrawAmount(CustomerDetail customerInfo, ArrayList<TransactionDetail> transactionList) {

		System.out.println("Enter the type of Withdrawal");
		System.out.println("1.ATM");
		System.out.println("2.Online Payment");
		System.out.println("3.Bank");
		int typeOfTransaction = scanner.nextInt();
		String byMode = "";
		if (typeOfTransaction == 1)
			byMode = "ATM";
		if (typeOfTransaction == 2)
			byMode = "Online Payment";
		if (typeOfTransaction == 3) {
			byMode = "Bank";
		}
		boolean Loop = true;
		while (Loop) {
			System.out.println("Enter amount : ");
			int amount = scanner.nextInt();
			if (amount <= customerInfo.accountBalance) {
				customerInfo.accountBalance -= amount;
				System.out.println("Money Withdrawed");
				transactionList.add(new TransactionDetail(customerInfo.accountNumber, byMode, "withdraw", amount,
						customerInfo.accountBalance));
				System.out.println("Your Account Balance : " + customerInfo.accountBalance);

				Loop = false;
			} else
				System.out.println("Insufficent Balance...");

		}
	}

	private void depositAmount(CustomerDetail customerInfo, ArrayList<TransactionDetail> transactionList,
			ArrayList<CustomerDetail> customerDetail) {
		System.out.println("Enter Method Of Deposit");
		System.out.println("1.ATM");
		System.out.println("2.Online Banking");
		System.out.println("3.Account Transfer");
		boolean input_choice = true;
		String byMode = "";
		int choice = 0;
		while (input_choice) {
			choice = scanner.nextInt();
			if (choice == 1) {
				byMode = "ATM";
				input_choice = false;
			} else if (choice == 2) {
				byMode = "Online Payment";
				input_choice = false;
			} else if (choice == 3) {
				byMode = "AccountTranfer";
				input_choice = false;

			} else
				System.out.println("Enter 1 to 3....");
		}
		if (choice == 3) {
			int transferAccountNumberInOrNot = 1;

			System.out.println("Enter Transfer Account Num : ");
			int transferAccount = scanner.nextInt();
			for (CustomerDetail tranferAccount : customerDetail) {
				if (tranferAccount.accountNumber == transferAccount) {
					transferAccountNumberInOrNot = 0;
					int transferAmount = 0;
					boolean forLoop = true;
					while (forLoop) {
						System.out.println("Enter transfer amount : ");
						transferAmount = scanner.nextInt();
						if (customerInfo.accountBalance >= transferAmount) {
							tranferAccount.accountBalance += transferAmount;
							transactionList.add(new TransactionDetail(tranferAccount.accountNumber, byMode, "Deposit",
									transferAmount, tranferAccount.accountBalance));
							System.out.println("Money credited to '" + tranferAccount.customerName + "'");

							customerInfo.accountBalance -= transferAmount;
							transactionList.add(new TransactionDetail(customerInfo.accountNumber, byMode, "Transfer",
									transferAmount, customerInfo.accountBalance));
							System.out.println("Your Account Balance : " + customerInfo.accountBalance);
							forLoop = false;
						} else {
							System.out.println("Insufficient Money...");
						}
					}
				}
			}
			if (transferAccountNumberInOrNot == 1) {
				System.out.println("Account Number doesn't exist....");
			}
		} else {
			System.out.println("Enter amount : ");
			int amount = scanner.nextInt();

			customerInfo.accountBalance += amount;
			transactionList.add(new TransactionDetail(customerInfo.accountNumber, byMode, "Deposit", amount,
					customerInfo.accountBalance));
			System.out.println("Money credited...");
		}

	}

}

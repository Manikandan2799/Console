package bankingsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankingSystem {

	public static void main(String[] args) {

		BankingManagement banking = new BankingManagement();
		banking.homePage();
	}

}

class BankingManagement extends Login {
	static Scanner s = new Scanner(System.in);
	static ArrayList<CustomerDetail> customerList = new ArrayList<CustomerDetail>();
	static ArrayList<TransactionDetail> transactionList = new ArrayList<TransactionDetail>();
	static Login login = new Login();

	protected void homePage() {

		customerList.add(new CustomerDetail("Mani", 111, 1000, "Mani123", null));
		customerList.add(new CustomerDetail("Saran", 112, 1000, "Saran123", null));
		customerList.add(new CustomerDetail("Madhu", 113, 1000, "Madhu123", null));
		int homePageLoop = 1;
		do {
			System.out.println("Your options...");
			System.out.println("1.Login         ");
			System.out.println("2.Create account");
			System.out.println("3.View customer details");
			System.out.println("4.Exit");
			System.out.println("Enter your option");
			int optionsHome = s.nextInt();
			switch (optionsHome) {
			case 1:
				login.loginCustomer(customerList, transactionList);
				break;
			case 2:
				createNewAccount();
				break;
			case 3:
				viewAllCustomers();
				break;
			default:
				break;
			}
			System.out.println("If you want continue...press 1...");
			homePageLoop = s.nextInt();
		} while (homePageLoop == 1);

	}

	private void createNewAccount() {
		System.out.println("Welcome.....");
		System.out.println("Enter your name : ");
		String customerName = s.next();
		int forUpdateAccNumber = customerList.size();
		CustomerDetail customerInfo = customerList.get(forUpdateAccNumber - 1);

		int newAccountNumber = customerInfo.accountNumber + 1;

		System.out.println("Create your password : ");
		String newPassword = s.next();
		while (true) {

			if (login.checkValidPassword(newPassword)) {
				System.out.println("Your password is strong");
				break;
			} else {
				System.out.println("Your password is weak : ");
				System.out.println("Re-enter password");
				newPassword = s.next();
			}
		}
		customerList.add(new CustomerDetail(customerName, newAccountNumber, 1000, newPassword, null));
		System.out.println("Successfully created..");
		System.out.println("-------------------------------------");
		System.out.println("Your details.....");
		System.out.println("-------------------------------------");
		System.out.println("Name    : " + customerName);
		System.out.println("Acc_No  : " + newAccountNumber);
		System.out.println("PassWord: " + newPassword);
		System.out.println("Acc_Bal :  1000");
		System.out.println("-------------------------------------");
	}

	private void viewAllCustomers() {
		System.out.println("------------------------------------------------------------");
		System.out.println("Name\t\tAccount.No\tBalance");
		System.out.println("------------------------------------------------------------");
		for (CustomerDetail customerInfo : customerList) {
			System.out.println(customerInfo.customerName + "\t\t" + customerInfo.accountNumber + "\t\t"
					+ customerInfo.accountBalance);
		}
		System.out.println("------------------------------------------------------------");
	}

}

class TransactionDetail {
	int accountNumber;
	String transactionThrough;
	String method;
	int amount;
	int accountBalance;

	TransactionDetail(int accountNumber, String transactionThrough, String method, int amount, int accountBalance) {

		this.accountNumber = accountNumber;
		this.transactionThrough = transactionThrough;
		this.method = method;
		this.amount = amount;
		this.accountBalance = accountBalance;
	}
}

class CustomerDetail {
	String customerName;
	int accountNumber;
	int accountBalance;
	String password;
	List<TransactionDetail> transactionDetail;

	CustomerDetail(String customerName, int accountNumber, int accountBalance, String password,
			List<TransactionDetail> transactionDetail) {
		this.customerName = customerName;
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
		this.password = password;
		this.transactionDetail = transactionDetail;
	}

}

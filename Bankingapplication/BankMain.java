package bankingconsole;

import java.sql.SQLException;

public class BankMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		System.out.println("*******************************");
		System.out.println("      Welcome to " + Banking.bankName);
		System.out.println("*******************************");
		UserInfo user = new UserInfo();
		user.authentication();

	}

}

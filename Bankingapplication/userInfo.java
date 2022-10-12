package bankingconsole;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class UserInfo {
    Scanner input = new Scanner(System.in);
	public void authentication() throws SQLException, ClassNotFoundException {
		Transaction trans = new Transaction();
		System.out.println("1.Login\n2.Enroll");
		int choice = input.nextInt();
		switch (choice) {
		case 1:
			login();
			trans.choice();
			break;
		case 2:
			enroll();
			trans.choice();
			break;

		}

	}

	public void login() throws SQLException {
		Banking acc = new Banking();
		System.out.println("Enter the username:");
		acc.setUserName(input.next());
		System.out.println("Enter the password");
		acc.setPassword(input.next());

		try {

			PreparedStatement stmt = Jdbc.jdbcConnection()
					.prepareStatement("select * from accountdetails where username=? AND passWord=?");
			stmt.setLong(1, acc.accountNumber);
			stmt.setString(2, acc.password);
			ResultSet rs = stmt.executeQuery();
			if (rs.next())
				System.out.println("Welcome " + acc.userName);
			else
				System.out.println("Invalid user name and password");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void enroll() {
		Banking acc_details = new Banking();
		System.out.println("Enetr the username: ");
		acc_details.setUserName(input.next());
		System.out.println("Enter the password:");
		acc_details.setPassword(input.next());

		System.out.println("Enter the  customername:");
		acc_details.setCustomerName(input.next());

		System.out.println("Enter the mobile number:");
		acc_details.setMobileNumber(input.next());
		System.out.println("Enter EmailId:");
		acc_details.setEmailId(input.next());
		System.out.println("you are enroll successfully...");

		PreparedStatement stmt = null;
		try {
			stmt = Jdbc.jdbcConnection().prepareStatement("insert into accountdetails values(?,?,?,?,?,?,?)");
			stmt.setString(1, acc_details.userName);
			stmt.setString(2, acc_details.password);
			stmt.setString(3, acc_details.customerName);
			stmt.setLong(4, acc_details.accountNumber);
			stmt.setString(5, acc_details.mobileNumber);
			stmt.setString(6, acc_details.emailId);
			stmt.setLong(7, acc_details.balance);
			stmt.setLong(7, 0);
			int i = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}


}

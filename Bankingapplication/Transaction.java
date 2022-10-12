package bankingconsole;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class Transaction {
		private long balance;
		private long accountNumber;
		Banking bank = new Banking();
		   Scanner sc=new Scanner(System.in);
		public void choice() throws SQLException, ClassNotFoundException {
			System.out.println("1.ShowAccount\n2.Deposit\n3.withdrawal\n4.BalanceEnquiry\n");
			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				showAccount();
				break;
			case 2:
				deposit();
				break;
			case 3:
				withdrawal();
				break;
			case 4:
				balanceEnquiry();
				break;
			}

		}

		public void close() throws ClassNotFoundException, SQLException {
			System.out.println("Do you want to continue..");
			System.out.println("1.Yes\t2.No");
			int ch = sc.nextInt();
			if (ch == 1) {
				choice();
			} else {
				System.out.println("Thank you for using our services!!!");
			}

		}

		private void showAccount() throws SQLException, ClassNotFoundException {
			System.out.println("Enter the accountNumber:");
			bank.setAccountNumber(sc.nextLong());
			try {

				PreparedStatement cs = Jdbc.jdbcConnection()
						.prepareStatement("select * from accountdetails where accountNumber=? ");
				cs.setLong(1, bank.accountNumber);
				ResultSet rs = cs.executeQuery();
				if (rs.next())
					System.out.println("CustomerName:" + rs.getString("CustomerName") + "\n" + "accountNumber:"
							+ rs.getLong("accountNumber") + "\n" + "MobileNumber:" + rs.getString("mobileNumber") + "\n"
							+ "EmailId:" + rs.getString("emailId") + "\n" + "Balance:" + rs.getLong("balance") + "\n");

			} catch (Exception e) {
				e.printStackTrace();
			}
			close();
		}
	private void deposit() throws SQLException, ClassNotFoundException {
		System.out.println("Enter the amount:");
		int amt = sc.nextInt();
		System.out.println("Enter theaccountNumber:");
	     bank.setAccountNumber(sc.nextLong());
		bank.balance += amt;
		try {
			PreparedStatement updateBal = Jdbc.jdbcConnection()
					.prepareStatement("update accountdetails set balance =balance+ ? where accountNumber=?");
			updateBal.setLong(1, bank.balance);
			updateBal.setLong(2, bank.accountNumber);
			int rs = updateBal.executeUpdate();
			PreparedStatement cs = Jdbc.jdbcConnection()
					.prepareStatement("select   balance from accountdetails where accountNumber=? ");
			cs.setLong(1, bank.accountNumber);
			ResultSet result = cs.executeQuery();
			result.next();
			System.out.println("balance=" + result.getLong("balance"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	   private void withdrawal() throws ClassNotFoundException, SQLException {
		System.out.println("Enter the Acconut Number:");
		bank.setAccountNumber(sc.nextLong());
		System.out.println("Enter the amount:");
		int amt = sc.nextInt();
		try {
			PreparedStatement ps = Jdbc.jdbcConnection()
					.prepareStatement("select balance from accountDetails  where accountNumber=? ");
			ps.setLong(1, bank.accountNumber);
			ResultSet rs = ps.executeQuery();
			rs.next();
			long balance = rs.getLong(1);
			System.out.println(balance);
			if (balance > amt) {
				PreparedStatement ps1 = Jdbc.jdbcConnection().prepareStatement(
						"update accountDetails set balance=balance-" + amt + " where accountNumber=?");
				ps1.setLong(1, bank.getAccountNumber());
				int i = ps1.executeUpdate();
				PreparedStatement ps2 = Jdbc.jdbcConnection()
						.prepareStatement("select balance from accountDetails  where accountNumber=? ");
				ps2.setLong(1, bank.getAccountNumber());
				ResultSet rs3 = ps2.executeQuery();
				rs3.next();
				System.out.println(amt + " is withdrawed from your account\n" + "\nbalance=" + rs3.getLong("balance"));
			} else {
				System.out.println("Insufficient balance...");
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		close();
	}
		private void balanceEnquiry() throws ClassNotFoundException, SQLException {
			System.out.println("Enter the Acconut Number:");
			bank.setAccountNumber(sc.nextLong());
			try {
				PreparedStatement cs = Jdbc.jdbcConnection()
						.prepareStatement("select   balance from accountdetails where accountNumber=? ");
				cs.setLong(1, bank.accountNumber);
				ResultSet result = cs.executeQuery();
				result.next();
				System.out.println("balance=" + result.getLong("balance"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			close();
		}
	}

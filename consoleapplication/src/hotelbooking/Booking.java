package hotelbooking;

import java.util.*;
import java.util.Map.Entry;

public class Booking {
	static int tableno = 11;
	Scanner in = new Scanner(System.in);
	static Booking book = new Booking();
	static HashMap<Integer, Table> tableDetails = new HashMap<Integer, Table>();
	static HashMap<String, Double> foodDetails = new HashMap<String, Double>();
	static HashMap<Integer, Double> billDetails = new HashMap<Integer, Double>();
	static HashMap<Integer, ArrayList> orderDetails = new HashMap<Integer, ArrayList>();

	public static void main(String[] arg) {
		foodDetails.put("Idly", 10.0d);
		foodDetails.put("Dosa", 20.0d);
		foodDetails.put("Vada", 5.0d);
		tableDetails.put(1, new Table(10, "Available"));
		tableDetails.put(2, new Table(20, "Available"));
		tableDetails.put(3, new Table(10, "Available"));
		tableDetails.put(4, new Table(10, "Available"));
		tableDetails.put(5, new Table(10, "Available"));

		book.options();
	}

	public void options() {
		System.out.println("Select Option\n1 Admin..\n2 User..\n3 Exit..");
		int option = in.nextInt();
		switch (option) {
		case 1:
			book.bookingOperation();
			break;
		case 2:
			book.bookingUser();
			break;
		case 3:
			book.exit();
		}

	}

	public void exit() {

	}

	public void bookingUser() {
		System.out.println("Select your option\n1 OrderFood...\n2 CancelFood...\n3 OrderTable...\4 CancelTables...");
		int option = in.nextInt();
		switch (option) {
		case 1:
			book.orderTables();
			break;
		case 2:
			book.cancelFood();
			break;
		case 3:
			book.bookingTable();
			break;
		}
	}

	public void bookingOperation() {
		System.out.println(
				"-----OPTIONS-----\n1 AVAILABLE TABLES..\n2 BOOKING..\n3 BILLING..\n4 MANAGER..\n5 Back.. to Menu\nSELECT YOUR OPTION");
		int option = in.nextInt();
		switch (option) {
		case 1:
			book.availableTable();
			break;
		case 2:
			book.bookingTable();
			break;
		case 3:
			book.bill();
			break;
		case 4:
			book.management();
			break;
		case 5:
			book.options();

		}
	}

	private void management() {
		System.out.println("MANAGER\n1 Tables Maintain.\n2 Add Food");
		int option = in.nextInt();
		switch (option) {
		case 1:
			System.out.println("1 Add Table\n2 Remove Table\nSelect your option");
			int select = in.nextInt();
			if (select == 1) {
				tableDetails.put(tableno, new Table(10, "Available"));
			} else {
				System.out.println("Enter Table No");
				int tableNo = in.nextInt();
				tableDetails.remove(tableNo);
			}
			break;
		case 2:
			System.out.println("Enter Food name");
			String foodName = in.next();
			System.out.println("Enter Amount");
			double rate = in.nextDouble();
			foodDetails.put(foodName, rate);
			break;
		}
		book.bookingOperation();
	}

	private void bill() {
		System.out.println("Enter the table number");
		int tableNo = in.nextInt();
		double total = 0;
		int no = 1;
		System.out.println("--------------------------------\n--------ITC GRAND--------\n---------List-------\n");
		System.out.println("S.no\tName\tQuantity\tCost\tAmount");
		try {
			ArrayList<String> arr = new ArrayList<String>(orderDetails.get(tableNo));
			for (String i : arr) {
				String[] arr1 = i.split(" ");
				System.out.print(no + "\t" + arr1[0] + "\t" + arr1[1] + "\t" + foodDetails.get(arr1[0]) + "\t"
						+ foodDetails.get(arr1[0]) * Double.parseDouble(arr1[1]) + "\n");
				no++;
				total += foodDetails.get(arr1[0]) * Double.parseDouble(arr1[1]);
			}
			System.out.println("\t\tTotal\t" + total);
			tableDetails.get(tableNo).setStatus("Available");
		} catch (Exception e) {
			System.out.println("Out Of Items");
		}
		book.bookingOperation();
	}

	public void availableTable() {
		System.out.println("_______AVAILABLE TABLE_______");
		for (Entry<Integer, Table> l : tableDetails.entrySet()) {
			System.out.print(l.getKey());
			l.getValue().display();
		}
		book.bookingOperation();
	}

	public void cancelFood() {
		System.out.println("__Food Details__\nCancel your Order");
		System.out.println("Table Number");
		int tableNo = in.nextInt();
		orderDetails.remove(tableNo);
		book.bookingOperation();
	}

	public void orderTables() {
		System.out.println("-----Food Details----\nSelect your food");
		for (Entry<String, Double> j : foodDetails.entrySet()) {
			System.out.println(j.getKey() + "  " + j.getValue());
		}
		System.out.println("Table Number");
		int tableNo = in.nextInt();
		ArrayList<String> arr = new ArrayList<String>();
		boolean isValid = true;
		while (isValid) {
			System.out.println("Select the food");
			String food = in.next();
			System.out.println("Select Quantity");
			food += " " + in.next();
			arr.add(food);
			System.out.println("continue...\n1 Yes\n2 No");
			int option = in.nextInt();
			if (1 == option) {
				isValid = true;
				food = "";
			} else {
				isValid = false;
			}
		}
		orderDetails.put(tableNo, arr);
		book.bookingOperation();
	}

	private void bookingTable() {
		System.out.println("Available Tables");
		System.out.println("________AVAILABLE TABLE________");
		for (Entry<Integer, Table> l : tableDetails.entrySet()) {
			System.out.print(l.getKey());
			l.getValue().display();
		}
		System.out.println("Select your table");
		int option = in.nextInt();
		if (tableDetails.get(option).getStatus().equals("Available")) {
			tableDetails.get(option).setStatus("Booked");
		} else {
			System.out.println("Table is Already Booked... Choose another...");
			book.bookingTable();
		}
		book.bookingOperation();
	}
}

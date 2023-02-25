package consoleapplication;

import java.util.*;

public class Main {
	Scanner in = new Scanner(System.in);
	ArrayList<Customer> customerdetails = new ArrayList<Customer>();
	ArrayList<Bus> busdetails = new ArrayList<Bus>();
	ArrayList<Ticket> ticketdetails = new ArrayList<Ticket>();

	void customerSignUp() {
		System.out.println("Enter id,name,password,age,to sign-up");
		int id = in.nextInt();
		String name = in.next();
		String password = in.next();
		int age = in.nextInt();
		int customer_count = 0;
		for (Customer cus_details : customerdetails) {
			if (cus_details.id == (id)) {
				customer_count++;
			}
		}
		if (customer_count == 0) {
			customerdetails.add(new Customer(id, name, password, age));
			System.out.println("Back to home page");
		} else {
			System.out.println("User id already exist");
		}
	}

	void customerLogin() {
		System.out.println("Enter id,password to Login");
		int id = in.nextInt();
		String pass = in.next();
		int check_login = 0;
		Customer currentcustomer = null;
		for (Customer cus_details : customerdetails) {
			if (cus_details.id == (id) && cus_details.password.equals(pass)) {
				currentcustomer = cus_details;
				check_login++;
				break;
			}
		}
		if (check_login == 0) {
			System.out.println("Invalid Login or Password");
		} else {
			int choice = 0;
			System.out.println("Logined Successfully...\nWelcome " + currentcustomer.name);
			while (choice == 0) {
				System.out.println("\n1)BookTickects\n2)ViewTickets\n3)CancelTickets\n4)Summary\n5)Logout");
				int choiceafterlogin = in.nextInt();
				switch (choiceafterlogin) {
				case 1:
					System.out.println("Choose bustype,seattype");
					String bustype = in.next();
					String seattype = in.next();
					for (Bus bus : busdetails) {
						if (bus.bustype.equalsIgnoreCase(bustype) && bus.seattype.equalsIgnoreCase(seattype)) {
							int[] bookedseat = bus.book();
							int nooftickets = bus.nooftick;
							double fare = bus.calculateFare(nooftickets);
							int ticketid = ticketdetails.size();
							System.out.println("-------------------------------");
							ticketdetails.add(new Ticket(ticketid, bookedseat, bus, nooftickets, fare, currentcustomer.id));
							System.out.println("Your Ticket is id:" + ticketid + "\nYou have to pay Rs." + fare
									+ "\nYour Tickets were booked\n!!!!Happy Journey!!!!");
							System.out.println("-------------------------------");
						}
					}
					break;
				case 2:
					System.out.println("Enter bustype,seattype");
					bustype = in.next();
					seattype = in.next();
					for (Bus bus : busdetails) {
						if (bus.bustype.equalsIgnoreCase(bustype) && bus.seattype.equalsIgnoreCase(seattype)) {
							bus.viewSeats();
						}
					}
					break;
				case 3:
					System.out.println("Enter booking id");
					int booking_id = in.nextInt();
					for (Ticket tickets : ticketdetails) {
						if (tickets.id == booking_id && tickets.customer_id != currentcustomer.id) {
							System.out.println("Ticket not belongs to you!!!!\nTicket cancellation cannot be possible");
							break;
						} else if (tickets.id == booking_id) {
							Bus bookedbus = tickets.ticketDetails();
							int[] bookedseats = tickets.bookedtickets;
							bookedbus.deleteSeats(bookedseats);
							ticketdetails.remove(tickets);
							System.out.println("Your ticket has been deleted successfully!!!\nYour amount " + tickets.fare
									+ " will return back soon...\nThank you");
							break;
						}
					}
					break;
				case 4:
					System.out.println("The bus summary are:");
					for (Bus bus : busdetails) {
						System.out.println("Bus type: " + bus.bustype);
						System.out.println("Seat type: " + bus.seattype);
						System.out.println("Booked seats: " + bus.bookedseats);
						System.out.println("------------------------");
					}
					break;
				case 5:
					System.out.println("You have successfully loggedout...come back again!!!");
					choice++;
					break;
				}
			}
		}
	}

	public void createObj() {
		customerdetails.add(new Customer(1, "aaa", "111", 24));
		customerdetails.add(new Customer(2, "bbb", "222", 61));
		customerdetails.add(new Customer(3, "ccc", "333", 22));
		customerdetails.add(new Customer(4, "ddd", "444", 36));
		busdetails.add(new Bus("AC", "Seater"));
		busdetails.add(new Bus("AC", "Sleeper"));
		busdetails.add(new Bus("Non-AC", "Seater"));
		busdetails.add(new Bus("Non-AC", "Sleeper"));
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int choice;
		Main input_choice = new Main();
		input_choice.createObj();
		while (true) {

			System.out.println("1.Customer Sign-up..\n2.Customer Login..\n3.Stop Program..");
			choice = in.nextInt();
			switch (choice) {
			case 1:
				input_choice.customerSignUp();
				break;
			case 2:
				input_choice.customerLogin();
				break;
			case 3:
				System.exit(0);
			}
		}
	}
}

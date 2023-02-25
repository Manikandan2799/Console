package ticketbooking;

import java.util.Scanner;

public class MovieName {
	Scanner s = new Scanner(System.in);
	TicketBooking tb = new TicketBooking();

	void mainMenu() {
		System.out.println("1)Ponniyin Selvan1\n" + "2)Nanae Varuven\n" + "3)Vendhu Thaninthathu Kaadu\n"
				+ "4)Thiruchittrambalam\n");
		System.out.println("Enter movie:");

		int ch = s.nextInt();

		switch (ch) {
		case 1:
			ps1();
			break;
		case 2:
			nanae_varuven();
			break;
		case 3:
			vtk();
			break;
		case 4:
			tcm();
			break;
		case 5:
			exit();
			break;
		}
	}

	private void exit() {

	}

	private void tcm() {

	}

	private void vtk() {

	}

	private void nanae_varuven() {

	}

	void ps1() {

		tb.book();
	}

}

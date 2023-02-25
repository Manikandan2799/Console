package consoleapplication;

import java.util.*;

class Ticket {
	int id;
	int[] bookedtickets;
	Bus object;
	int nooftickets;
	double fare;
	int customer_id;

	Ticket(int id, int[] bookedtickets, Bus object, int nooftickets, double fare, int customer_id) {
		this.id = id;
		this.bookedtickets = bookedtickets;
		this.object = object;
		this.nooftickets = nooftickets;
		this.fare = fare;
		this.customer_id = customer_id;
	}

	Bus ticketDetails() {
		System.out.println("-----------------------");
		System.out.println("Ticket details are:\n");
		System.out.println("Bus type:" + object.bustype);
		System.out.println("Seat type:" + object.seattype);
		System.out.println("Booked by the customer id:" + customer_id);
		System.out.println("No. of tickets:" + nooftickets);
		System.out.println("Booked seates:" + Arrays.toString(bookedtickets));
		System.out.println("------------------------");
		return object;
	}
}

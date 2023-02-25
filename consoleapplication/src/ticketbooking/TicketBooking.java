package ticketbooking;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class TicketBooking {
	Scanner s = new Scanner(System.in);

	public void book() {
		int ch = s.nextInt();
		switch (ch) {
		case 1:
			mr();
			break;
		case 2:
			// eve();
			break;
		case 3:
			// night();
			break;
		case 4:
			System.out.println("invalid");
			break;
		}

	}

	private void mr() {
		System.out.println("Enter no.of tickets:");
		int t = s.nextInt();
		try {
			PreparedStatement ps = Jdbc.jdbcConnection()
					.prepareStatement("select morning_Show from movieInfo where movie_Name=" + "Ponniyin Selvan1");
			ResultSet rs = ps.executeQuery();
			rs.next();
			int i = rs.getInt(1);
			if (i > t) {
				PreparedStatement ps1 = Jdbc.jdbcConnection().prepareStatement(
						"update movieInfo set morning_Show =morning_Show-" + t + " movie_Name=" + "Ponniyin Selvan1");
				int j = ps.executeUpdate();
			} else
				System.out.println("Sorry!no tickets available");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

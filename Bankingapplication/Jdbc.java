package bankingconsole;

import java.sql.Connection;
import java.sql.DriverManager;

public class Jdbc {
	public static Connection jdbcConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/bankapplication", "root", "Monisha06");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

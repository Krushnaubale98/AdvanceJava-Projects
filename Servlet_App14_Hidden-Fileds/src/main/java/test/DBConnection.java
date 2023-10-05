package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*SingleTon Class design pattern*/
public class DBConnection {

	private static Connection con = null;

	static {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "ADDJAVA", "ORACLE");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static Connection getCon() {
		return con;
	}
}

package test;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	private static Connection con = null;

	private DBConnection() {
	} //constructor

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "ADDJAVA", "ORACLE");
		} catch (Exception e1) {
			e1.printStackTrace();
		} //end of try

	}

	public static Connection getCon() {
		return con;
	}
}

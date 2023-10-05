package test;

import java.sql.Connection;
import java.sql.DriverManager;

//Single-ton class pattern
public class DBConnection {

	public static Connection con = null;

	//o_para constructor
	private DBConnection() {
	}

	static {
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "ADDJAVA", "ORACLE");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getCon() {
		return con;
	}

}

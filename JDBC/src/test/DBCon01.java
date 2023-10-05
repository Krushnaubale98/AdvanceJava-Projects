package test;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
//Constructing JDBC Application using IDE Eclipse to retrieve data from the

//table Employee44:

public class DBCon01 {
	public static void main(String args[]) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // step 1

			Connection con = DriverManager.getConnection("jdbc:oracle:" + "thin:@localhost:1521:orcl", "ADDJAVA",
					"ORACLE");// step 2
			Statement stm = con.createStatement(); // step 3
			ResultSet rs = stm.executeQuery("select * from Employee44");// step 4
			while (rs.next()) {
				System.out.println(
						rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getInt(4));
			} // end of the whilLoop
			con.close();// step 5
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/*Case-2 : Batch processing using 'PreparedStatement'
 * 
 *  =>Batch Processing using 'Statement' we can update multiple DB-Tables.
    =>Batch Processing using 'PreparedStatement' we can update same table with
        multiple records
*/
public class DBCon19 {
	@SuppressWarnings("unused")
	public static void main(String[] args) {

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "ADDJAVA", "ORACLE");

			PreparedStatement ps1 = con.prepareStatement("Insert into book44 values(?,?,?,?,?)");
			//PreparedStatement ps2 = con.prepareStatement("Insert into employee44 values(?,?,?,?)");

			//book44
			ps1.setString(1, "G112");
			ps1.setString(2, "C++");
			ps1.setString(3, "B-Sam");
			ps1.setFloat(4, 700);
			ps1.setInt(5, 10);
			ps1.addBatch();

			ps1.setString(1, "G113");
			ps1.setString(2, "C");
			ps1.setString(3, "W-Ram");
			ps1.setFloat(4, 990);
			ps1.setInt(5, 17);
			ps1.addBatch();

			int b[] = ps1.executeBatch();

			for (Integer A : b) {
				System.out.println("Data inserted successfully....");
			}

			/*
			 * //employee44 ps2.setString(1, "A114"); ps2.setString(2, "soham");
			 * ps2.setString(3, "C-engineer"); ps2.setFloat(4, 45000); ps2.addBatch();
			 * 
			 * ps2.setString(1, "A115"); ps2.setString(2, "mohini"); ps2.setString(3,
			 * "E-engineer"); ps2.setFloat(4, 22000); ps2.addBatch();
			 * 
			 * int c[] = ps2.executeBatch();
			 * 
			 * for (Integer m : c) { System.out.println("Data inserted successfully...."); }
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

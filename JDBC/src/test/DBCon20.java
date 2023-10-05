package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*Types of ResultSet objects:
	 =>Based on control over the cursor,the ResultSet objects are categorized
	into two types:
	     1.Non-Scrollable ResultSet object
	     2.Scrollable ResultSet object

Ex_Program : Using 'Statement'
*/
public class DBCon20 {

	public static void main(String[] args) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "AddJava", "ORACLE");

			Statement stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			ResultSet rs = stm.executeQuery("Select * from employee44");

			System.out.println("===Employee Details reverse=======");

			rs.afterLast(); //Cursor indicationg after the last row
			while (rs.previous()) {
				System.out.println(
						rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getInt(4));
			} //end of loop

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

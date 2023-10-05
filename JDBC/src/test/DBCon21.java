package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*Types of ResultSet objects:
	 =>Based on control over the cursor,the ResultSet objects are categorized
	into two types:
	     1.Non-Scrollable ResultSet object
	     2.Scrollable ResultSet object
	     
Ex_Program : Using 'PreparedStatement'.
*/
public class DBCon21 {
	public static void main(String[] args) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "ADDJAVA", "ORACLE");

			PreparedStatement pst = con.prepareStatement("Select * from employee44", 1004, 1008);

			ResultSet rs = pst.executeQuery();

			System.out.println("==========absolute(3)=========");
			rs.absolute(3); //cursor indicating to row 3
			System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getInt(4));

			System.out.println("======relative(+1)=======");
			rs.relative(+1); //incrementing the corsor position by 1
			System.out.println(rs.getString(1) +"\t"+ rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getInt(4));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

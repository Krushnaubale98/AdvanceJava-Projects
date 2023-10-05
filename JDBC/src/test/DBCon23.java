package test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/*MetaData interface:
	The following are the metadata components from JDBC:
        1.DatabaseMetaData
        2.ParameterMetaData
        3.ResultSetMetaData 
        4.RowSetMetaData
*/
public class DBCon23 {
	public static void main(String[] args) {
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "ADDJAVA", "ORACLE");

			DatabaseMetaData dmd = con.getMetaData(); //MetaData object
			System.out.println("DriverName: " + dmd.getDriverName());

			PreparedStatement pst = con.prepareStatement("Select * from employee44 where eid=?  ");
			pst.setString(1, "A123");
			//pst.setString(2, "Raj");
			ParameterMetaData pmd = pst.getParameterMetaData();//metaData object
			System.out.println("Count of parameters: " + pmd.getParameterCount());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				System.out.println(
						rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getFloat(4));
			} //end of if

			ResultSetMetaData rsmd = rs.getMetaData();
			//ResultSetMetaData object
			System.out.println("Columnts count: " + rsmd.getColumnCount());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

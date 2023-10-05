package test;

import java.util.Scanner;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

//Example on rowset...(RowSetFactory)
public class DBCon22 {
	public static void main(String[] args) {

		try {

			Scanner sc = new Scanner(System.in);
			Class.forName("oracle.jdbc.driver.OracleDriver");
			RowSetFactory rsf = RowSetProvider.newFactory(); //RowSetFactory object

			System.out.println("======choice=========");

			System.out.println("1.JdbcRowSet\n2.ChachedRowSet");
			System.out.println("Enter the choice:");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				//JdbcRowSet

				JdbcRowSet jrs = rsf.createJdbcRowSet();
				//JdbcRowSet object
				jrs.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
				jrs.setUsername("ADDJAVA");
				jrs.setPassword("ORACLE");
				jrs.setCommand("Select * from employee44");
				jrs.execute();

				while (jrs.next()) {
					System.out.println(jrs.getString(1) + "\t" + jrs.getString(2) + "\t" + jrs.getString(3) + "\t"
							+ jrs.getInt(4));
				} //end of while

				break;

			case 2:
				//ChachedRowSets
				CachedRowSet crs = rsf.createCachedRowSet();
				//CachedRowSet object

				crs.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
				crs.setUsername("ADDJAVA");
				crs.setPassword("ORACLE");
				crs.setCommand("Select * from book44");
				crs.execute();

				while (crs.next()) {
					System.out.println(crs.getString(1) + "\t" + crs.getString(2) + "\t" + crs.getString(3) + "\t"
							+ crs.getFloat(4) + "\t" + crs.getInt(5));
				} //end of loop

				break;
			default:
				System.out.println("Invalid choice...");

			}//end of switch

			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

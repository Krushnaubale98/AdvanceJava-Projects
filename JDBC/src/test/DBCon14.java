package test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

/*Assignment-2 :
Construct JDBC application to execute function to retrieve totSal of an 
employee based eId.

table=EmpSalary44
*/
public class DBCon14 {
	public static void main(String args[]) {

		try {
			Scanner sc = new Scanner(System.in);

			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "ADDJAVA", "ORACLE");

			System.out.println("Enter the eid: ");
			String eid = sc.nextLine();

			CallableStatement cs = con.prepareCall("{call ?:=GetTotSal44(?)}"); //compilation

			cs.registerOutParameter(1, Types.FLOAT);

			cs.setString(2, eid);
			cs.execute();//execution

			System.out.println("Eid: " + eid);
			System.out.println("Totsal: " + cs.getFloat(1));
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

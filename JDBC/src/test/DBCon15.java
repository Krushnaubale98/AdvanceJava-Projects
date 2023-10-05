package test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

/*Assignment 3:
Construct JDBC application to execute function to display result of Student
based on rollNo
*/

public class DBCon15 {

	public static void main(String args[]) {

		try {
			Scanner sc = new Scanner(System.in);

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "ADDJAVA", "ORACLE");

			System.out.println("Enter the rollno: ");
			String rollno = sc.nextLine().toUpperCase();

			CallableStatement cs = con.prepareCall("{call ?:=GetStuResult44(?)}");
			                                    
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.setString(2, rollno);
			
			cs.execute();
			System.out.println("Rollno: "+rollno);
			System.out.println("Result: "+cs.getString(1));
			
			System.out.println("Function executed successfully...");
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

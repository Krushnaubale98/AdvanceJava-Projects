package test;

import java.sql.DriverManager;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.Statement;

/*Ex_Program:
Write JDBC Application to read Employee details from Console(Keyboard)
and insert data to DB Table Employee44.
*/
public class DBCon02 {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the EmpId: ");
			String eid = sc.nextLine();
			System.out.println("Enter thge EmpName: ");
			String name = sc.nextLine();
			System.out.println("Enter the EmpDesg: ");
			String desg = sc.nextLine();
			System.out.println("Enter the EmpbSal:");
			int bSal = sc.nextInt();

			Class.forName("oracle.jdbc.driver.OracleDriver");// step 1
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:" + "@localhost:1521:orcl", "ADDJAVA",
					"ORACLE");// step 2
			Statement stm = con.createStatement();// step 3

			int k = stm.executeUpdate(
					"Insert into employee44 values('" + eid + "' ,'" + name + "','" + desg + "','" + bSal + "')");
			// step
			// 4
			/*
			 * int k = stm.executeUpdate("delete from employee44 where ename='Swati'");
			 */if (k > 0) {
				System.out.println("Employee details inserted successfully....");
			}
			con.close();
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

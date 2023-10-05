package test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

/**
 * imp Construct and Execute function:
 * 
 * step-1 : Construct function to retrieve balance of an employee based on eId.
 * 
 * create or replace function getBalance444 (a number)return number as bal
 * number; begin select balance into bal from Bank44 where accno=a; return bal;
 * end; /
 * 
 * step-2 : Construct JDBC Application to execute function.
 */
public class DBCon13 {

	@SuppressWarnings("unused")
	public static void main(String args[]) {
		try {
			Scanner sc = new Scanner(System.in);
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "ADDJAVA", "ORACLE");
			System.out.println("Enter the CustAccNo: ");
			Long accNo = sc.nextLong();

			CallableStatement cs = con.prepareCall("{call ?:=getBalance44(?)}");//compilation

			cs.registerOutParameter(1, Types.FLOAT);
			cs.setLong(2, accNo);
			cs.execute();// execution

			System.out.println("AccNo: " + accNo);
			System.out.println("Balance :" + cs.getFloat(1));
			con.close();
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

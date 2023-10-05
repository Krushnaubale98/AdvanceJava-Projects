package test;

import java.sql.DriverManager;

/**
 * imp Constructing and Executing Procedure on DB Product:
 * 
 * step-1 : Construct the following tables:
 * Bank44(accno,custname,balance,acctype) CustDetails44(accno,addr,mid,phno)
 * Primary Key : accno
 * 
 * create table Bank44(accno number(15),custname varchar2(15), balance
 * number(10,2),acctype varchar2(15),primary key(accno));
 * 
 * create table CustDetails44(accno number(15),addr varchar2(15), mid
 * varchar2(25),phno number(15),primary key(accno));
 * 
 * step-2 : Construct procedure to insert data to DB Tables
 * 
 * create or replace procedure CreateAccount44 (a number,b varchar2,c number,d
 * varchar2,e varchar2,f varchar2,g number) is begin insert into Bank44
 * values(a,b,c,d); insert into CustDetails44 values(a,e,f,g); end; /
 * 
 * step-3 : Construct JDBC application to execute procedure
 */

import java.util.*;
import java.sql.*;

public class DBCon09 {
	public static void main(String args[]) {
		try {

			Scanner sc = new Scanner(System.in);

			System.out.println("Enter the AccNo: ");
			long accNo = Long.parseLong(sc.nextLine());
			System.out.println("Enter the CustName: ");
			String custName = sc.nextLine();
			System.out.println("Enter the Balance: ");
			float bal = Float.parseFloat(sc.nextLine());
			System.out.println("Enter the AccType: ");
			String accType = sc.nextLine();
			System.out.println("Enter the Address: ");
			String addr = sc.nextLine();
			System.out.println("Enter the MailId: ");
			String mailId = sc.nextLine();
			System.out.println("Enter the PhoNo: ");
			long phoNo = Long.parseLong(sc.nextLine());

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "ADDJAVA",
					"ORACLE");

			CallableStatement cs = con.prepareCall("{ call CreateAccount44(?,?,?,?,?,?,?)}"); // compailation

			cs.setLong(1, accNo);
			cs.setString(2, custName);
			cs.setFloat(3, bal);
			cs.setString(4, accType);
			cs.setString(5, addr);
			cs.setString(6, mailId);
			cs.setLong(7, phoNo);

			cs.execute();// execution

			System.out.println("Procedure executed successfully...");
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

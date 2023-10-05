package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.util.Scanner;

/*Ex:
DB Table : Bank44

     ACCNO CUSTNAME           BALANCE ACCTYPE
---------- --------------- ---------- ---------------
   6123456 Raj                  12000 savings
    313131 Alex                   500 savings

Transaction => Transfer amt 3000/- from accNo:6123456 to accNo:313131
      SubT1 => Subtract amt 3000/- from accNo:6123456
      SubT2 => Add amt 3000/- to accNo:313131
*/
@SuppressWarnings("serial")
public class DBCon16 extends Exception {
	public static void main(String[] args) {

		try {
			Scanner sc = new Scanner(System.in);

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "ADDJAVA", "ORACLE");

			System.out.println("Commit status: " + con.getAutoCommit());
			con.setAutoCommit(false);
			System.out.println("Commit status: " + con.getAutoCommit());

			PreparedStatement ps1 = con.prepareStatement("Select * from bank44 where accno=?");//Compilation

			PreparedStatement ps2 = con.prepareStatement("update bank44 set balance=balance+? where accno=?");//compailation

			Savepoint sp = con.setSavepoint();

			System.out.println("Enter the HomeAccNo(mohan):");
			long hAccNo = sc.nextLong();

			ps1.setLong(1, hAccNo);
			ResultSet rs1 = ps1.executeQuery();//execution

			if (rs1.next()) {
				float bal = rs1.getFloat(3);//retriveing balance

				System.out.println("Enter the bAccNo(ramesh):");
				long bAccNo = sc.nextLong();

				ps1.setLong(1, bAccNo);
				ResultSet rs2 = ps1.executeQuery();//execution

				if (rs2.next()) {
					System.out.println("Enter the amt to be transfrred:");
					int amt = sc.nextInt();

					if (amt <= bal) {
						ps2.setInt(1, -amt);
						ps2.setLong(2, hAccNo);
						int h = ps2.executeUpdate();//execution

						ps2.setInt(1, amt);
						ps2.setLong(2, bAccNo);
						int b = ps2.executeUpdate();//execution

						if (h == 1 && b == 1) {
							con.commit(); //update from buffers to database
							System.out.println("Transaction successfully....");
						} else {
							con.rollback(sp);
							System.out.println("Transaction failed...");
						}

					} else {
						System.out.println("Insufficient balance..");
					}

				} else {
					System.out.println("Invalid bankAccNo...");
				}
			} else {
				System.out.println("Invalid homeAccNo...");
			}
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

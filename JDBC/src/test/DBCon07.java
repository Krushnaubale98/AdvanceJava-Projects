package test;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*Ex_Program:
JDBC application to perform the following operations on DB Table Book44
based on User choice.
    1.UpdateBook(bprice,bqty)
    2.DeleteBook
*/
public class DBCon07 {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "addjava", "ORACLE");
		Scanner sc = new Scanner(System.in);
		System.out.println("=======choice===========");
		System.out.println("1.UpdateBook\n2.DeleteBook");
		System.out.println("Enter the choice:");
		int choice = Integer.parseInt(sc.nextLine());
		PreparedStatement ps1 = con.prepareStatement("Select * from book44 where bcode=?");
		switch (choice) {
		case 1:
			// UpdateBook
			System.out.println("Enter the bcode: ");
			String bCode1 = sc.nextLine().toUpperCase();
			ps1.setString(1, bCode1);
			ResultSet rs1 = ps1.executeQuery();// execution
			if (rs1.next()) {
				System.out.println("Old price: " + rs1.getFloat(4));
				System.out.println("Old qty: " + rs1.getInt(5));
				System.out.println("Enter the new price: ");
				float price = sc.nextFloat();
				System.out.println("Enter the new qty: ");
				int qty = sc.nextInt();
				PreparedStatement ps2 = con.prepareStatement("Update book44 set bprice=?,bqty=? where bcode=?");
				ps2.setFloat(1, price);
				ps2.setInt(2, qty);
				ps2.setString(3, bCode1);
				int k = ps2.executeUpdate();// execution
				if (k > 0) {
					System.out.println("Bookdetails updated for: " + bCode1);

				} else {
					System.out.println("Invalid book code...");
				}
			} // end of if
			break;
		case 2:
			// DeleteBook

			System.out.println("Enter the bcode: ");
			String bCode2 = sc.nextLine().toUpperCase();
			ps1.setString(1, bCode2);
			ResultSet rs2 = ps1.executeQuery();
			if (rs2.next()) {
				PreparedStatement ps3 = con.prepareStatement("delete from book44 where bcode =?");
				ps3.setString(1, bCode2);
				int k = ps3.executeUpdate();
				if (k > 0) {
					System.out.println("BookDtails deleted for " + bCode2);
				} else {
					System.out.println("Invalid book code...");
				}
			} // end of if

			break;
		default:
			System.out.println("Invalid choice...");
		}// end of the switch
	}

}

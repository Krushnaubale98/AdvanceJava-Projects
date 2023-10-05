package test;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.sql.Connection;

/*Assignment-2 :(Update using PreparedStatement)
Consider DB Table : Product44(pcode,pname,pprice,pqty)

Construct JDBC Application to perform the following operation based on user
choice:
      1.AddProductDetails
      2.ViewsAllProducts 
*/
public class DBCon04 {
	public static void main(String[] args) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "ADDJAVA", "ORACLE");
			Scanner sc = new Scanner(System.in);
			System.out.println("=============choice=============");
			System.out.println("1.AddProductDetails\n2.ViewAllProducts");
			System.out.println("Enter the choice: ");
			switch (Integer.parseInt(sc.nextLine())) {
			case 1:
				/*
				 * PreparedStatement ps1 = con.prepareStatement("Create table Products44(" +
				 * "pcode varchar2(10)," + "pname varchar2(15)," + "pprice number(8,2)," +
				 * "pqty number(3)" + ")");
				 */

				PreparedStatement ps1 = con.prepareStatement("Insert into products44 values(?,?,?,?)");

				System.out.println("Enter the pCode: ");
				String pCode = sc.nextLine();
				System.out.println("Enter the pName: ");
				String pName = sc.nextLine();
				System.out.println("Enter the pPrice: ");
				float pPrice = Float.parseFloat(sc.nextLine());
				System.out.println("Enter the pQty: ");
				int pQty = sc.nextInt();

				ps1.setString(1, pCode);
				ps1.setString(2, pName);
				ps1.setFloat(3, pPrice);
				ps1.setInt(4, pQty);

				int k = ps1.executeUpdate();
				if (k > 0) {
					// System.out.println("Table created successfully...");
					System.out.println("data inserted  successfully...");
				}
				break;
			case 2:

				PreparedStatement ps2 = con.prepareStatement("Select * from products44");
				ResultSet rs = ps2.executeQuery();

				while (rs.next()) {
					System.out.println(
							rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getFloat(3) + "\t" + rs.getInt(4));
				}
				break;

			default:
				System.out.println("Invalid choice...");
			}// end of the switch
			sc.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

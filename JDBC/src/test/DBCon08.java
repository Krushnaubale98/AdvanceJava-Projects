package test;

import java.sql.DriverManager;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;;
/*Assignment-2:
JDBC Application to perform the following operations on DB Table Product44
based on UserChoice:
   1.AddProduct
   2.ViewAllProducts
   3.ViewProductByCode
   4.UpdateProduct(price and qty)
   5.DeleteProduct*/

public class DBCon08 {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		try (sc;) {
			while (true) {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "ADDJAVA",
						"ORACLE");

				System.out.println("========choice=========");
				System.out.println("1.Addproduct\n2.ViewAllProducts" + "\n3.ViewProductByCode"
						+ "\n4.UpdateProduct(price & qty)" + "\n5.DeleteProduct");
				System.out.println("Enter the choice: ");
				int choice = Integer.parseInt(sc.nextLine());
				PreparedStatement ps1 = con.prepareStatement("Select * from products44 where pcode=?");
				switch (choice) {
				case 1:
					// Addproduct
					PreparedStatement ps2 = con.prepareStatement("Insert into Products44 values(?,?,?,?)");
					System.out.println("Enter the pCode:");
					String pCode = sc.nextLine().toUpperCase();
					System.out.println("Enter the pName: ");
					String pName = sc.nextLine();
					System.out.println("Enter the pPrice: ");
					float pPrice = Float.parseFloat(sc.nextLine());
					System.out.println("Enter the pQty");
					int pQty = Integer.parseInt(sc.nextLine());
					ps2.setString(1, pCode);
					ps2.setString(2, pName);
					ps2.setFloat(3, pPrice);
					ps2.setInt(4, pQty);

					int k = ps2.executeUpdate();
					if (k > 0) {
						System.out.println("Product added successfully...");
					}
					break;
				case 2:
					// ViewAllProduct

					PreparedStatement ps3 = con.prepareStatement("Select * from products44");
					ResultSet rs3 = ps3.executeQuery();

					while (rs3.next()) {
						System.out.println(rs3.getString(1) + "\t" + rs3.getString(2) + "\t" + rs3.getFloat(3) + "\t"
								+ rs3.getInt(4));
					}
					break;
				case 3:
					// ViewProductByCode
					System.out.println("Enter the pCode: ");
					String pCode4 = sc.nextLine().toUpperCase();

					ps1.setString(1, pCode4);

					ResultSet rs4 = ps1.executeQuery();
					if (rs4.next()) {
						System.out.println(rs4.getString(2) + "\t" + rs4.getFloat(3) + "\t" + rs4.getInt(4));
					} else {
						System.out.println("Product code is not available in DB...");
					}
					break;
				case 4:
					// UpdateProduct(price & qty)

					System.out.println("Enter the pCode: ");
					String pCode5 = sc.nextLine().toUpperCase();
					ps1.setString(1, pCode5);
					ResultSet rs5 = ps1.executeQuery();
					if (rs5.next()) {

						System.out.println("Old product price: " + rs5.getFloat(3));
						System.out.println("Old product qty: " + rs5.getInt(4));

						PreparedStatement ps5 = con
								.prepareStatement("Update products44 set pprice=? , pqty=? where pcode=? ");
						System.out.println("Enter the new Price: ");
						float pPrice5 = Float.parseFloat(sc.nextLine());
						System.out.println("Enter the new qty: ");
						int pqty5 = Integer.parseInt(sc.nextLine());

						ps5.setFloat(1, pPrice5);
						ps5.setInt(2, pqty5);
						ps5.setString(3, pCode5);
						int k5 = ps5.executeUpdate();
						if (k5 > 0) {
							System.out.println("Product details updated successfully ..for: " + pCode5);
						} else {
							System.out.println("Product code not matched ....");
						}

					}
					break;
				case 5:
					// DeleteProduct

					System.out.println("Enter the product code: ");
					String pCode6 = sc.nextLine().toUpperCase();

					ps1.setString(1, pCode6);
					ResultSet rs6 = ps1.executeQuery();
					if (rs6.next()) {

						PreparedStatement ps6 = con.prepareStatement("Delete from products44 where pcode=?");
						ps6.setString(1, pCode6);
						int k6 = ps6.executeUpdate();

						if (k6 > 0) {
							System.out.println("Product deleted for thid code: " + pCode6);

						}

					} else {
						System.out.println("Product code is wrong...");
					}
					break;
				default:
					System.out.println("Invalid choice....");
				}// end of switch
			} // end of while
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
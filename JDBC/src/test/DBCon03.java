package test;

/*Assignment-1:(Solution with PreparedStatement)
Consider DB Table : Book44(bcode,bname,bauthor,bprice,bqty)

Construct JDBC Application to perform the following operation based on user
choice:
      1.AddBookDetails
      2.ViewsBooks 
*/
import java.sql.*;
import java.util.Scanner;

public class DBCon03 {
	public static void main(String[] args) {
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");// step 1
			Connection con = DriverManager.getConnection("jdbc:oracle" + ":thin:@localhost:1521:orcl", "ADDJAVA",
					"ORACLE"); // step 2

			while (true) {
				Scanner sc = new Scanner(System.in);
				System.out.println("=======choice ==========");
				System.out.println("1.AddBookDetails\n2.ViewBooks");
				System.out.println("Enter the choice: ");
				switch (Integer.parseInt(sc.nextLine())) {
				case 1:
					PreparedStatement ps1 = con.prepareStatement("Insert into book44 values(?,?,?,?,?)");// Compilation
					System.out.println("Enter the bCode: ");
					String bCode = sc.nextLine();
					System.out.println("Enter the bName: ");
					String bName = sc.nextLine();
					System.out.println("Enter the bAuthor: ");
					String bAuthor = sc.nextLine();
					System.out.println("Enter the  bPrice: ");
					float bPrice = Float.parseFloat(sc.nextLine());
					System.out.println("Enter the bQry:  ");
					int bQty = sc.nextInt();

					ps1.setString(1, bCode);
					ps1.setString(2, bName);
					ps1.setString(3, bAuthor);
					ps1.setFloat(4, bPrice);
					ps1.setInt(5, bQty);

					int k = ps1.executeUpdate(); // execution

					if (k > 0) {
						System.out.println("BookDetails inserted successfully...");
					}
					break;
				case 2:
					PreparedStatement ps2 = con.prepareStatement("Select * from Book44");// compilation
					ResultSet rs = ps2.executeQuery();// Execution
					while (rs.next()) {
						System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t"
								+ rs.getFloat(4) + "\t" + rs.getInt(5));
					} // end of the loop
					break;
				default:
					System.out.println("Invalid choice...");
				}// end of the switch

				sc.close();
				con.close();

			} // end of the while
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

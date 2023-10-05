package test;

/*Assignment-3:
Consider DB Table : UserReg44(uname,pword,fname,lname,addr,mid,phno)
                   Primary Key : uname and pword

Construct JDBC Application to perform the following operation based on user
choice:
      1.Register
      2.Login
             =>read 'uname and pword' and perform login process
             =>Display:
                 welcome user : firstName
                 Login:
                	 select * from UserReg44 where uname=? and pword=?

       3.ViewProfile 
             =>read 'uName and pWord' and display userDetails:
               fName,lName,addr,mid,phno
*/
import java.sql.*;
import java.util.Scanner;

public class DBCon05 {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "ADDJAVA", "ORACLE");
			try (Scanner sc = new Scanner(System.in)) {
				while (true) {
					System.out.println("========choice========");
					System.out.println("1.Register\n2.Login\n3.ViewProfile");
					System.out.println("Enter the choice: ");
					switch (Integer.parseInt(sc.nextLine())) {

					case 1:
						// Register
						System.out.println("Enter the uName: ");
						String uName = sc.nextLine().toLowerCase();
						System.out.println("Enter the pWord: ");
						String pWord = sc.nextLine().toLowerCase();
						System.out.println("Enter the fName: ");
						String fName = sc.nextLine();
						System.out.println("Enter the lName: ");
						String lName = sc.nextLine();
						System.out.println("Enter the Address: ");
						String Address = sc.nextLine();
						System.out.println("Enter the emailId: ");
						String emailId = sc.nextLine().toLowerCase();
						System.out.println("Enter the phoNo: ");
						long phoNo = Long.parseLong(sc.nextLine());

						PreparedStatement ps1 = con.prepareStatement("Insert into userreg44 values(?,?,?,?,?,?,?)");
						ps1.setString(1, uName);
						ps1.setString(2, pWord);
						ps1.setString(3, fName);
						ps1.setString(4, lName);
						ps1.setString(5, Address);
						ps1.setString(6, emailId);
						ps1.setLong(7, phoNo);

						int k = ps1.executeUpdate();
						if (k > 0) {
							System.out.println("User Registerd successfully....");
						}
						break;
					case 2:
						// login

						System.out.println("Enter the Uname: ");
						String Uname = sc.nextLine().toLowerCase();
						System.out.println("Enter the Pword: ");
						String Pword = sc.nextLine().toLowerCase();
						PreparedStatement ps2 = con.prepareStatement("Select * from Userreg44 where uname=? and pword=?");
						ps2.setString(1, Uname);
						ps2.setString(2, Pword);
						ResultSet rs2 = ps2.executeQuery();

						if (rs2.next()) {
							System.out.println("Login Successfull....");
							System.out.println("Welcome user : " + rs2.getString(3));
						} // end of if
						else {
							System.out.println("Invalid username/Password");
						}
						break;
					case 3:
						// ViewProfile
						System.out.println("Enter the Uname: ");
						String uname = sc.nextLine().toLowerCase();
						System.out.println("Enter the Pword: ");
						String pword = sc.nextLine().toLowerCase();

						PreparedStatement ps3 = con.prepareStatement("Select * from userreg44 where uname=? and pword=?");

						ps3.setString(1, uname);
						ps3.setString(2, pword);

						ResultSet rs3 = ps3.executeQuery();

						if (rs3.next()) {
							System.out.println("========UserDetails=========");
							System.out.println("FirstName:" + rs3.getString(3) + "\nLastName:" + rs3.getString(4)
									+ "\nAddress:" + rs3.getString(5) + "\nMailId:" + rs3.getString(6) + "\nPhoNo:"
									+ rs3.getLong(7));

						} else {
							System.out.println("Invalid userName/passWord...");
						}
						break;
					default:
						System.out.println("Invalid choice....");
					}// end of the switch

				} // end the while loop
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

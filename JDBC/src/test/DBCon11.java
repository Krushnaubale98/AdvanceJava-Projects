package test;

/*Assignment-1:
DB Tables ,
    EmpData44(eid,ename,edesg)
    EmpAddress44(eid,hno,sname,city,pincode)
    EmpContact44(eid,mid,phno)
    EmpSalary44(eid,bsal,totsal)
Note:
  =>totSal is calculated based on bsal
totsal = bSal+HRA+DA;
HRA = 93% of bSal
DA  = 63% of bSal

Construct JDBC application to execute IN-Parameter procedure to update 
DB Tables.
*/
import java.util.*;
import java.sql.*;

public class DBCon11 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		try {
			Scanner sc = new Scanner(System.in);

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "ADDJAVA", "ORACLE");

			CallableStatement cs = con.prepareCall("{call InsertEmp44(?,?,?,?,?,?,?,?,?,?,?)}");

			// EmpData44
			System.out.println("Enter the eid: ");
			String eid = sc.nextLine();
			System.out.println("Enter the ename: ");
			String ename = sc.nextLine();
			System.out.println("Enter the edesg: ");
			// EmpAddress44
			String edesg = sc.nextLine();
			System.out.println("Enter the hno:");
			String hno = sc.nextLine();
			System.out.println("Enter the sname: ");
			String sname = sc.nextLine();
			System.out.println("Enter the city: ");
			String city = sc.nextLine();
			System.out.println("Enter the pincode: ");
			int pincode = Integer.parseInt(sc.nextLine());

			// empContact44
			System.out.println("Enter the mid: ");
			String mid = sc.nextLine();
			System.out.println("Enter the phno: ");
			long phno = Long.parseLong(sc.nextLine());

			// Empsalary44
			System.out.println("Enter the bsal: ");
			int bsal = Integer.parseInt(sc.nextLine());

			float totsal = bsal + (bsal * 0.93f) + (bsal * 0.63f);

			cs.setString(1, eid);
			cs.setString(2, ename);
			cs.setString(3, edesg);
			cs.setString(4, hno);
			cs.setString(5, sname);
			cs.setString(6, city);
			cs.setInt(7, pincode);
			cs.setString(8, mid);
			cs.setLong(9, phno);
			cs.setInt(10, bsal);
			cs.setFloat(11, totsal);

			cs.execute();
			System.out.println("Data/procedure inserted successfully...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

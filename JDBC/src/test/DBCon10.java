package test;

/*Constructing and executing OUT parameter procedure to display CustDetails 
using accNo:
step-1 : Construct Out-Parameter procedure.
  
create or replace procedure RetrieveDetails44
(a number,b OUT varchar2,c OUT number,d OUT varchar2,e OUT varchar2,
f OUT varchar2,g OUT number) is
begin
   select custname,balance,acctype into b,c,d from Bank44 where accno=a;
   select addr,mid,phno into e,f,g from CustDetails44 where accno=a;
end;
/

step-2 : Construct JDBC Application to execute OUT-Parameter Procedure
*/
import java.util.*;
import java.sql.*;

public class DBCon10 {

	public static void main(String args[]) {
		try {

			Scanner sc = new Scanner(System.in);

			System.out.println("Enter the accNO: ");
			long accNo = Integer.parseInt(sc.nextLine());

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "ADDJAVA", "ORACLE");

			CallableStatement cs = con.prepareCall("{call RetrieveDetails44(?,?,?,?,?,?,?)}");

			cs.setLong(1, accNo);

			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.FLOAT);
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.VARCHAR);
			cs.registerOutParameter(6, Types.VARCHAR);
			cs.registerOutParameter(7, Types.BIGINT);

			cs.execute();// execution
			System.out.println("Procedure executed successfully...");

			System.out.println("AccNo: " + accNo);
			System.out.println("CustName: "+cs.getString(2));
			System.out.println("Balance: "+cs.getFloat(3));
			System.out.println("AccType: "+cs.getString(4));
			System.out.println("Address: "+cs.getString(5));
			System.out.println("EmailId: "+cs.getString(6));
			System.out.println("PhoNo: "+cs.getLong(7));
			
			sc.close();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

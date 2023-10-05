package test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

/*Assignment-2 :
 * 
 *  EmpData44(eid,ename,edesg)
    EmpAddress44(eid,hno,sname,city,pincode)
    EmpContact44(eid,mid,phno)
    EmpSalary44(eid,bsal,totsal)

Construct JDBC appliaction to execute OUT-parameter procedure to display
employee details based of eId.
*/
public class DBCon12 {
	public static void main(String args[]) {

		try {
			Scanner sc = new Scanner(System.in);

			System.out.println("Enter the eid: ");
			String eid = sc.nextLine().toUpperCase();

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "ADDJAVA", "ORACLE");
			/*RetriveEmp44*/
			CallableStatement cs = con.prepareCall("{call RetrieveEmployee44(?,?,?,?,?,?,?,?,?,?,?)}");
			cs.setString(1, eid);

			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.VARCHAR);

			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.VARCHAR);
			cs.registerOutParameter(6, Types.VARCHAR);
			cs.registerOutParameter(7, Types.INTEGER);

			cs.registerOutParameter(8, Types.VARCHAR);
			cs.registerOutParameter(9, Types.BIGINT);

			cs.registerOutParameter(10, Types.INTEGER);
			cs.registerOutParameter(11, Types.FLOAT);

			cs.execute();
			System.out.println("Retriver procedure executed successfully...");

			System.out.println(eid);
			System.out.println(cs.getString(2));
			System.out.println(cs.getString(3));
			System.out.println(cs.getString(4));
			System.out.println(cs.getString(5));
			System.out.println(cs.getString(6));
			System.out.println(cs.getInt(7));

			System.out.println(cs.getString(8));
			System.out.println(cs.getLong(9));
			System.out.println(cs.getInt(10));
			System.out.println(cs.getFloat(11));

			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}


/*create or replace procedure RetriveEmp44
       ( eid varchar2,ename out varchar2,edesg out varchar2,
          hno out varchar2,sname out varchar2, city out varchar2,pincode out number,
          mid out varchar2,phno out number,
          bsal out number, totsal out number) 
     is
       begin
         select ename,edesg into ename,edesg from empdata44 where eid=eid;
         select hno,sname,city,pincode into hno,sname,city,pincode from empaddress44 where eid=eid;
         select mid,phno into mid,phno from empContact44 where eid=eid;
         select bsal,totsal into bsal,totsal from empsalary44 where eid=eid;
end;
/*/
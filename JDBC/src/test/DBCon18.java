package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/*Case-1 : Batch processing using 'Statement'*/
public class DBCon18 {
	public static void main(String[] args) {
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "ADDJAVA", "ORACLE");

			Statement stm = con.createStatement();
			stm.addBatch("delete from employee44 where eid='A111'");
			stm.addBatch("delete from book44 where bcode='D112'");
			stm.addBatch("Insert into employee44 values('A111','sonal','M Enginer',17000)");
			stm.addBatch("Insert into book44 values('D112','C-java','pqr',1500,40)");
			stm.addBatch("update employee44 set bsal=40000 where eid='A121'");

			int k[] = stm.executeBatch();

			for (int i = 0; i < k.length; i++) {
				System.out.println("Updated successfuly");
			}
			stm.close();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}

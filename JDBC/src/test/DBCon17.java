package test;

import java.sql.Connection;

import maccess.DB17ConnectionPooling;

/**
 * imp Connection Pooling in JDBC: =>The process of organizing multiple
 * Pre-Initialized DataBase connections among multiple users is known as
 * 'Connection Pooling'.
 * 
 * Note: =>we use 'Vector<E>' Object in Connection pooling process.
 * =>'java.util.Vector<E>' class is implementation class of List<E>.
 * 
 * Hierarchy of Vector<E>:
 */
public class DBCon17 {
	public static void main(String args[]) {
		try {

			DB17ConnectionPooling cp = new DB17ConnectionPooling("jdbc:oracle:thin:@localhost:1521:orcl", "ADDJAVA",
					"ORACLE"); //object (constructor)
			
			cp.createConnction(); // Creating 5 connection objects

			System.out.println("Pool size: " + cp.v.size());

			System.out.println("======user-1=========");
			Connection con = cp.userConnection();
			System.out.println("User Using: " + con);
			System.out.println("Pool size: " + cp.v.size());

			

			System.out.println("======user-2=========");
			Connection con2 = cp.userConnection();
			System.out.println("User Using: " + con);
			System.out.println("\nPool size: " + cp.v.size());
			
			System.out.println("==User-1 returned the connection==");
			cp.addConnectionToPool(con2); //adding connection
			System.out.println("\nPool size: " + cp.v.size());
			
			System.out.println("=====Connections from the pool===");
			cp.v.forEach((k) -> {
				System.out.println(k);
			});
		} catch (Exception e) {

		}

	}

}

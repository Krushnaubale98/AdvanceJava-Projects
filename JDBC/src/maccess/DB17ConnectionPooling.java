package maccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

public class DB17ConnectionPooling {

	public String url, uName, pWord;// Instance variable memory object

	public DB17ConnectionPooling(String url, String uName, String pWord) {
		//constructior to initialize instance variable

		this.url = url;
		this.uName = uName;
		this.pWord = pWord;

	}

	public Vector<Connection> v = new Vector<Connection>();
	// Vector holding Connection object

	public void createConnction() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			while (v.size() < 5) {
				System.out.println("ConnectionPool is not full...");

				try {
					Connection con = DriverManager.getConnection(url, uName, pWord);
					v.add(con);//adding the connection to a Vector
					System.out.println(con);

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (v.size() == 5) {
				System.out.println("ConnectionPool is full...");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	} //end of method

	public synchronized Connection userConnection() {
		//getting the connection from the pool
		Connection con = v.firstElement();//getting the first connection	
		v.removeElementAt(0); //removing the Connection from the pool
		return con;
	}

	public synchronized void addConnectionToPool(Connection con) {

		v.addElement(con); //adding connection to pool
		System.out.println("Connection added back to the pool successfully..");
	}
}

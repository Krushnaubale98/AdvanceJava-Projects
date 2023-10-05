package test;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@SuppressWarnings("serial")
public class AddDao implements Serializable {
	int k = 0;
	public int add(BookBean bb) {
		try {
			Connection con = DBConnection.getCon();
			//get dbConnection
			PreparedStatement ps = con.prepareStatement("insert into book44 values(?,?,?,?,?)");

			ps.setString(1, bb.getBcode());
			ps.setString(2, bb.getBname());
			ps.setString(3, bb.getBauthor());
			ps.setFloat(4, bb.getBprice());
			ps.setInt(5, bb.getBqty());

			k = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return k;

	}

}

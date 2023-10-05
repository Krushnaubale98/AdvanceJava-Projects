package test;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@SuppressWarnings("serial")
public class DeleteDao implements Serializable {

	int k = 0;

	public int delete(String bcode) {

		try {
			Connection con = DBConnection.getCon();
			//get Connection

			PreparedStatement ps = con.prepareStatement("Delete from book44 where bcode=?");
			ps.setString(1, bcode);
			k = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return k;
	}
}

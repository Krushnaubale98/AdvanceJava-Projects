package test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteDao {

	public static int deleteprod(String pcode) {

		int k = 0;

		try {
			Connection con = DBConnection.getCon();
			//get connection

			PreparedStatement ps = con.prepareStatement("delete from product44 where pcode=?");
			ps.setString(1, pcode);
			k = ps.executeUpdate();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}

}

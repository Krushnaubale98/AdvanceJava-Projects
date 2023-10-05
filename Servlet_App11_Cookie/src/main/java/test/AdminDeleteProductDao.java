package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminDeleteProductDao {

	public int k = 0;

	public int delete(ProductBean pb) {

		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("Delete from product44 where pcode=?");
			ps.setString(1, pb.getCode());

			k = ps.executeUpdate();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return k;
	}
}

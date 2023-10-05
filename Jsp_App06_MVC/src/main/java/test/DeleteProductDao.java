package test;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.http.HttpServletRequest;

public class DeleteProductDao {

	int k = 0;

	public int delete(HttpServletRequest req) {
		try {

			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("delete from product44 where pcode=?");
			ps.setString(1, req.getParameter("pcode"));
			k = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}
}

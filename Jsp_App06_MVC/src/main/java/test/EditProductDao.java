package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.http.HttpServletRequest;

public class EditProductDao {

	public ProductBean pb = null;

	public ProductBean retrieve(HttpServletRequest req) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("Select * from product44 where pcode=?");
			ps.setString(1, req.getParameter("pcode"));
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				pb = new ProductBean();//Bean object
				pb.setCode(rs.getString(1));
				pb.setName(rs.getString(2));
				pb.setPrice(rs.getFloat(3));
				pb.setQty(rs.getInt(4));
			} //end of if

		} catch (Exception e) {
			e.printStackTrace();
		}
		return pb;
	}
}

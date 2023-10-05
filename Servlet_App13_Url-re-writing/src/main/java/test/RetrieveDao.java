package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.http.HttpServletRequest;

public class RetrieveDao {

	public ProductBean pb = null; //instacne variable

	public ProductBean retrieve(HttpServletRequest req) {

		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("Select * from Product44 where pcode=?");
			ps.setString(1, req.getParameter("pcode"));
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				pb = new ProductBean();

				pb.setPcode(rs.getString(1));
				pb.setPname(rs.getString(2));
				pb.setPprice(rs.getFloat(3));
				pb.setQty(rs.getInt(4));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pb;
	}

}

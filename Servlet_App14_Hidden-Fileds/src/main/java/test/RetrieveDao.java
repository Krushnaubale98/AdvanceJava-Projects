package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.http.HttpServletRequest;

public class RetrieveDao {

	public ProductBean pb = null; //instance variable

	public ProductBean retrieve(HttpServletRequest req) {

		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("Select * from product44 where pcode=?");

			ps.setString(1, req.getParameter("pcode"));
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				pb = new ProductBean(); //getting prodcutBean object
				pb.setPcode(rs.getString(1));
				pb.setPname(rs.getString(2));
				pb.setPprice(rs.getFloat(3));
				pb.setPqty(rs.getInt(4));
			} //end of the while loop
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pb;
	}

}

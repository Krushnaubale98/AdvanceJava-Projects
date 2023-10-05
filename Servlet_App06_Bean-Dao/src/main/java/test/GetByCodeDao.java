package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import jakarta.servlet.ServletRequest;

public class GetByCodeDao {

	ProductBean pb = new ProductBean(); //bean object

	public ProductBean getbyid(String pcode) {
		try {
			Connection con = DBConnection.getCon(); //Accessing Connection
			PreparedStatement ps = con.prepareStatement("select * from  product44 where pcode=?");

			ps.setString(1, pcode);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				pb.setCode(rs.getString(1));
				pb.setName(rs.getString(2));
				pb.setPrice(rs.getFloat(3));
				pb.setQty(rs.getInt(4));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return pb;

	}

}

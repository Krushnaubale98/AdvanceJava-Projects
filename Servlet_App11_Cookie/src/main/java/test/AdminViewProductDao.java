package test;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class AdminViewProductDao implements Serializable {

	public ProductBean pb = null;
	int k = 0;
	ArrayList<ProductBean> al = new ArrayList<ProductBean>();

	public ArrayList<ProductBean> view() {

		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("Select * from Product44");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				pb = new ProductBean();

				pb.setCode(rs.getString(1));
				pb.setName(rs.getString(2));
				pb.setPrice(rs.getFloat(3));
				pb.setQty(rs.getInt(4));

				al.add(pb);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;

	}
}

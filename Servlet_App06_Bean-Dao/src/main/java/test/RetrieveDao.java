package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RetrieveDao {

	public ArrayList<ProductBean> al = new ArrayList<ProductBean>();
	// arraylist object  added whith ProductBean class

	public ArrayList<ProductBean> retrieve() {

		try {
			Connection con = DBConnection.getCon();

			//Accessing connection
			PreparedStatement ps = con.prepareStatement("Select * from product44");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				ProductBean pb = new ProductBean(); //bean object

				pb.setCode(rs.getString(1));
				pb.setName(rs.getString(2));
				pb.setPrice(rs.getFloat(3));
				pb.setQty(rs.getInt(4));

				al.add(pb); //adding bean object to arraylist
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return al;

	}
}

package test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateDao {

	public int k = 0;

	public int update(ProductBean pb) {
		try {
			Connection con = DBConnection.getCon();
			//get connection
			PreparedStatement ps = con.prepareStatement("update product44 set pname=?,pprice=?,pqty=? where pcode=?");

			ps.setString(1, pb.getName());
			ps.setFloat(2, pb.getPrice());
			ps.setInt(3, pb.getQty());
			ps.setString(4, pb.getCode());


			 k = ps.executeUpdate();

			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return k;

	}

}

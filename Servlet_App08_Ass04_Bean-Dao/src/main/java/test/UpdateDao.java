package test;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@SuppressWarnings("serial")
public class UpdateDao implements Serializable {
	int k = 0;

	public int update(BookBean bb) {

		try {
			Connection con = DBConnection.getCon();
			//get Connection

			PreparedStatement ps = con
					.prepareStatement("update book44 set bname=?,bauthor=?,bprice=?,bqty=? where bcode=?");

			ps.setString(1, bb.getBname());
			ps.setString(2, bb.getBauthor());
			ps.setFloat(3, bb.getBprice());
			ps.setInt(4, bb.getBqty());
			ps.setString(5, bb.getBcode());

			k = ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return k;
	}
}

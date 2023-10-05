package test;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class ViewDao implements Serializable {

	List<BookBean> al = new ArrayList<BookBean>();

	//ArrayList obj to add productBean object
	public List<BookBean> view() {

		try {
			Connection con = DBConnection.getCon();
			//Get Connection object

			PreparedStatement ps = con.prepareStatement("Select * from book44");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				BookBean bb=new BookBean ();
				bb.setBcode(rs.getString(1));
				bb.setBname(rs.getString(2));
				bb.setBauthor(rs.getString(3));
				bb.setBprice(rs.getFloat(4));
				bb.setBqty(rs.getInt(5));

				al.add(bb);//obj added into a arraylist
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
		
		
	}


}

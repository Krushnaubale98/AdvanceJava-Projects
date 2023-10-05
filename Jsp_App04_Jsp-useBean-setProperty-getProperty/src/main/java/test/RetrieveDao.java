package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.http.HttpServletRequest;

public class RetrieveDao {

	public ResultSet rs = null; //instance variable

	public ResultSet retrieve(HttpServletRequest req) {

		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("Select * from book44 where bcode=?");

			ps.setString(1, req.getParameter("bcode"));
			rs = ps.executeQuery();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
}

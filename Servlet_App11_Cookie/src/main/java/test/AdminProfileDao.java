package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminProfileDao {

	public UserBean ub = null;

	public UserBean profile(String uname, String pword) {

		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("Select * from adminReg44 where uname=? and pword=?");

			ps.setString(1, uname);
			ps.setString(2, pword);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				ub = new UserBean();

				ub.setuName(rs.getString(1));
				ub.setpWord(rs.getString(2));
				ub.setfName(rs.getString(3));
				ub.setLName(rs.getString(4));
				ub.setAddr(rs.getString(5));
				ub.setmId(rs.getString(6));
				ub.setPhNo(rs.getLong(7));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ub;
	}
}

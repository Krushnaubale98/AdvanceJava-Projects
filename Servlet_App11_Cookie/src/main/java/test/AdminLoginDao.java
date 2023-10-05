package test;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.http.HttpServletRequest;

@SuppressWarnings("serial")
public class AdminLoginDao implements Serializable {

	public UserBean ub = null;

	public UserBean login(HttpServletRequest req) {

		try {
			Connection con = DBConnection.getCon();

			PreparedStatement ps = con.prepareStatement("Select * from adminreg44 where uname=? and pword=?");

			ps.setString(1, req.getParameter("uname"));
			ps.setString(2, req.getParameter("pword"));

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

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

package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.http.HttpServletRequest;

public class LoginDao {
	public UserBean ub = null; //instance variable

	public UserBean login(HttpServletRequest req) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("select *  from Userreg44 where uname=? and pword=?");

			ps.setString(1, req.getParameter("uname"));
			ps.setString(2, req.getParameter("pword"));

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				ub = new UserBean();// bean object

				ub.setuName(rs.getString(1));
				ub.setpWord(rs.getString(2));
				ub.setfName(rs.getString(3));
				ub.setlName(rs.getString(4));
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

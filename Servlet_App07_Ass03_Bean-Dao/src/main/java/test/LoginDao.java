package test;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletRequest;

@SuppressWarnings("serial")
public class LoginDao implements Serializable

{
	UserBean ub = null;

	public UserBean login(ServletRequest req) {

		try {
			Connection con = DBConnection.getCon();
			//get dbConnection

			PreparedStatement ps = con.prepareStatement("select * from userReg44 where uname=? and pword=?");
			ps.setString(1, req.getParameter("uname"));
			ps.setString(2, req.getParameter("pword"));
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				ub = new UserBean();

				ub.setUname(rs.getString(1));
				ub.setPword(rs.getString(2));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ub;

	}
}

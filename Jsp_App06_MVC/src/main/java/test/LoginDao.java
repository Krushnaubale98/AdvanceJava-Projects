package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;

public class LoginDao {

	public UserBean ub = null;

	public UserBean login(HttpServletRequest req) {

		try {
			Connection con = DBConnection.getCon();
			ServletContext sct = req.getServletContext();
			String s1 = (String) sct.getAttribute("logintype");
			if (s1.equals("UserLogin")) {
				PreparedStatement ps = con.prepareStatement("Select * from userreg44 where uname=? and pword=?");

				ps.setString(1, req.getParameter("uname"));
				ps.setString(2, req.getParameter("pword"));
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					ub = new UserBean(); //Bean object
					ub.setuName(rs.getString(1));
					ub.setpWord(rs.getString(2));
					ub.setfName(rs.getString(3));
					ub.setlName(rs.getString(4));
					ub.setAddr(rs.getString(5));
					ub.setmId(rs.getString(6));
					ub.setPhNo(rs.getLong(7));
				} //end of if
			} else {
				PreparedStatement ps = con.prepareStatement("Select * from AdminReg44 where uname=? and pword=?");
				ps.setString(1, req.getParameter("uname"));
				ps.setString(2, req.getParameter("pword"));

				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					ub = new UserBean(); //Bean object
					ub.setuName(rs.getString(1));
					ub.setpWord(rs.getString(2));
					ub.setfName(rs.getString(3));
					ub.setlName(rs.getString(4));
					ub.setAddr(rs.getString(5));
					ub.setmId(rs.getString(6));
					ub.setPhNo(rs.getLong(7));
				} //end of if
			} //end of if-else
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ub;
	}
}

package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserProfileDao {

	public ArrayList<UserBean> al = new ArrayList<UserBean>();

	public ArrayList<UserBean> retrieve() {

		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("select * from userreg44");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UserBean ub = new UserBean();
				ub.setuName(rs.getString(1));
				ub.setpWord(rs.getString(2));
				ub.setfName(rs.getString(3));
				ub.setLName(rs.getString(4));
				ub.setAddr(rs.getString(5));
				ub.setmId(rs.getString(6));
				ub.setPhNo(rs.getLong(7));
				al.add(ub); //adding bean object into a arraylist

			} //end of the while loop
		} catch (Exception e) {
			e.printStackTrace();
		}
		return al;
	}

}

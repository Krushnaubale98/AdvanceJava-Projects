package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletRequest;

public class LoginDao {

public String fName=null;
	
	public String login(ServletRequest req) {
	
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("Select * from UserReg44 where uname=? and pword=?");
			ps.setString(1, req.getParameter("uname"));
			ps.setString(2, req.getParameter("pword"));
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				
				fName=rs.getString(3);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fName;
	}
	
}

package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Database2.Mysql;
import Model.Admin;

public class adminController {
	
	public int doLogin(Admin admin) throws SQLException 
	{
		
		int count = 0;
		
		Connection connection = null;
		connection = Mysql.dbConnector();
		
		String query2 ="select * from Admin_Registered where username=? and password=?";
		PreparedStatement pst2= connection.prepareStatement(query2);
		
		pst2.setString(1, admin.getUsername());
		pst2.setString(2, admin.getPassword());
		
		ResultSet rs= pst2.executeQuery();
		
		while(rs.next()) 
		{
			count=count+1;
			
		}
		
		connection.close();
		return count;
		
	}
}

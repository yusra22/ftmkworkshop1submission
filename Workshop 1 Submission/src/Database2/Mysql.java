package Database2;


import java.sql.*;

import javax.swing.*;

public class Mysql {

	Connection conn=null;
	public static Connection dbConnector()
	{
		try {
			
	 		Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/workshop2","root","");
			//JOptionPane.showMessageDialog(null, "Connection is Successful To MySQL");
			return conn;
			
		}catch (Exception e) 
		{
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}

}
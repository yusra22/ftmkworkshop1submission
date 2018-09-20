package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Database2.Mysql;
import Model.Kohout;
import Model.Student;
import View.Kahout;

public class kohoutController {
	
	public int insertUser(Kohout kohout) throws SQLException
	{
		int status = 0;
		
		Connection connection = null;
		connection = Mysql.dbConnector();
		
		String query = "insert into Kohout (Kohout,Status) values (?,?)";
		
		PreparedStatement pst = connection.prepareStatement(query);
		
		pst.setString(1, kohout.getKohout());
		pst.setString(2, kohout.getStatus());
		
		pst.execute();
		pst.close();
		
		return status;
		
	}
	
		public int assignInsert(Kohout kohout) throws SQLException
	{
		int status = 0;
		
		Connection connection = null;
		connection = Mysql.dbConnector();
		
		String query = "update Kohout set Status=? where Kohout='"+Kahout.comboBox.getSelectedItem()+"'";
		
		PreparedStatement pst = connection.prepareStatement(query);
		
		pst.setString(1, kohout.getStatus());
		
		pst.execute();
		pst.close();
		
		return status;
		
	}

}

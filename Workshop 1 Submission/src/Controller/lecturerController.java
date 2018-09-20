package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Database2.Mysql;
import Model.Lecturer;
import Model.Student;
import View.Assign_Student;
import View.Lecturer_Main;
import View.Profile;
import View.ProfileLec;
import View.Student_Main;

public class lecturerController {
	
	public int doLogin(Lecturer lec) throws SQLException 
	{
		
		int count = 0;
		
		Connection connection = null;
		connection = Mysql.dbConnector();
		
		String query2 ="select * from Lecturer_Registered where username=? and password=?";
		PreparedStatement pst2= connection.prepareStatement(query2);
		
		pst2.setString(1, lec.getUsername());
		pst2.setString(2, lec.getPassword());
		
		ResultSet rs= pst2.executeQuery();
		
		while(rs.next()) 
		{
			count=count+1;
			
		}
		
		connection.close();
		return count;
		
	}
	
/*	public int insertUser(Lecturer lec) throws SQLException
	{
		int status = 0;
		
		Connection connection = null;
		connection = Mysql.dbConnector();
		
		String query = "insert into Lecturer_Registered (LID,Name,Username,Password,Email,Questions,Answer,Position,Telephone,Status) values (?,?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement pst = connection.prepareStatement(query);
		
		pst.setString(1, lec.getLID());
		pst.setString(2, lec.getName());
		pst.setString(3, lec.getUsername());
		pst.setString(4, lec.getPassword());
		pst.setString(5, lec.getEmail());
		pst.setString(6, lec.getQuestions());
		pst.setString(7, lec.getAnswer());
		pst.setString(8, lec.getPosition());
		pst.setString(9, lec.getTelephone());
		pst.setString(10,lec.getStatus());
		pst.execute();
		
		pst.close();
		
		return status;
		
	}*/
	
	public int insertUser(Lecturer lec) throws SQLException
	{
		int status = 0;
		
		Connection connection = null;
		connection = Mysql.dbConnector();
		
		String query = "insert into Lecturer_Registered (LID,Name,Username,Password,Email,Questions,Answer,Position,Telephone,Kohout) values (?,?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement pst = connection.prepareStatement(query);
		
		pst.setString(1, lec.getLID());
		pst.setString(2, lec.getName());
		pst.setString(3, lec.getUsername());
		pst.setString(4, lec.getPassword());
		pst.setString(5, lec.getEmail());
		pst.setString(6, lec.getQuestions());
		pst.setString(7, lec.getAnswer());
		pst.setString(8, lec.getPosition());
		pst.setString(9, lec.getTelephone());
		pst.setString(10,lec.getKohout());
		pst.execute();
		
		pst.close();
		
		return status;
		
	}
	public String updateLecturer(Lecturer lec) throws SQLException 
	{
		
		Connection connection = null;
		connection = Mysql.dbConnector();
		
		String query = "update Lecturer_Registered set LID=? , Name=?, Position=?, Email=?, Telephone=? where LID='"+ProfileLec.textFieldID.getText()+"' ";
		
		PreparedStatement pst = connection.prepareStatement(query);
		
		pst.setString(1, lec.getLID()); //textFieldID.getText());
		pst.setString(2, lec.getName()); //textFieldFullName.getText());
		pst.setString(3, lec.getPosition()); //textFieldEmail.getText());
		pst.setString(4, lec.getEmail());
		pst.setString(5, lec.getTelephone());
		pst.execute();
		
		return null;
	}
	
	public String selectNameLec(Lecturer lec) throws SQLException 
	{
		Connection connection = null;
		connection = Mysql.dbConnector();
		
		String a1= Lecturer_Main.lblYourName.getText();
		String query="Select * from Lecturer_Registered where Username='"+a1+"' ";
		
		PreparedStatement pst= connection.prepareStatement(query);
		ResultSet rs= pst.executeQuery();
			
		if(rs.next())
		{
			Lecturer_Main.lblYourName.setText(rs.getString(2));
				
			rs.close();
			pst.close();
		}
		else
		{
				//JOptionPane.showMessageDialog(null, "Incorrect Username");
		}
			
		return null;
	}
	
	public String updateLecturerProfile(Lecturer lecturer) throws SQLException 
	{
		Connection connection = null;
		connection = Mysql.dbConnector();
		
		String query = "update Lecturer_Registered set LID=? , Image=? where LID='"+ProfileLec.textFieldID.getText()+"' ";
		
		PreparedStatement pst = connection.prepareStatement(query);
		
		pst.setString(1, lecturer.getLID());//textFieldID.getText());
		//pst.setString(2, lblRealTime.getText());
		//pst.setString(3, lblNotGrated.getText());
		pst.setBytes(2, lecturer.getPerson_image());//person_image);
		pst.execute();
		return null;
		
	}
	
/*	public int assignInsert(Lecturer lecturer) throws SQLException
	{
		int status = 0;
		
		Connection connection = null;
		connection = Mysql.dbConnector();
		
		String query = "update Lecturer_Registered set Status=? where LID='"+Assign_Student.textFieldLID.getText()+"'";
		
		PreparedStatement pst = connection.prepareStatement(query);
		
		pst.setString(1, lecturer.getStatus());
		
		pst.execute();
		pst.close();
		
		return status;
		
	}*/

}

package Controller;

import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import Database2.Mysql;
import Model.Student;
import View.Assign_Student;
import View.MyStudent_Details;
import View.Profile;
import View.Student_Details;
import View.Student_Main;

public class studentController {
	
	private ImageIcon format = null;
	
	public int doLogin(Student student) throws SQLException 
	{
		
		int count = 0;
		
		Connection connection = null;
		connection = Mysql.dbConnector();
		
		String query2 ="select * from Student_Registered where username=? and password=?";
		PreparedStatement pst2= connection.prepareStatement(query2);
		
		pst2.setString(1, student.getUsername());
		pst2.setString(2, student.getPassword());
		
		ResultSet rs= pst2.executeQuery();
		
		while(rs.next()) 
		{
			count=count+1;
			
		}
		
		connection.close();
		return count;
		
	}
	
/*	public int insertUser(Student student) throws SQLException
	{
		int status = 0;
		
		Connection connection = null;
		connection = Mysql.dbConnector();
		
		String query = "insert into Student_Registered (SID,Name,Username,Password,Email,Questions,Answer,Course,Telephone) values (?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement pst = connection.prepareStatement(query);
		
		pst.setString(1, student.getSID());
		pst.setString(2, student.getName());
		pst.setString(3, student.getUsername());
		pst.setString(4, student.getPassword());
		pst.setString(5, student.getEmail());
		pst.setString(6, student.getQuestions());
		pst.setString(7, student.getAnswer());
		pst.setString(8, student.getCourse());
		pst.setString(9, student.getTelephone());
		
		pst.execute();
		pst.close();
		
		return status;
		
	}*/
	
	public int insertUser(Student student) throws SQLException
	{
		int status = 0;
		
		Connection connection = null;
		connection = Mysql.dbConnector();
		
		String query = "insert into Student_Registered (SID,Name,Username,Password,Email,Questions,Answer,Course,Telephone,Kohout) values (?,?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement pst = connection.prepareStatement(query);
		
		pst.setString(1, student.getSID());
		pst.setString(2, student.getName());
		pst.setString(3, student.getUsername());
		pst.setString(4, student.getPassword());
		pst.setString(5, student.getEmail());
		pst.setString(6, student.getQuestions());
		pst.setString(7, student.getAnswer());
		pst.setString(8, student.getCourse());
		pst.setString(9, student.getTelephone());
		pst.setString(10,student.getKohout());
		
		pst.execute();
		pst.close();
		
		return status;
		
	}
	
	public String updateStudent(Student student) throws SQLException 
	{
		
		Connection connection = null;
		connection = Mysql.dbConnector();
		
		String query = "update Student_Registered set SID=? , Name=?, Email=?, Course=?, Telephone=? where SID='"+Profile.textFieldID.getText()+"' ";
		
		PreparedStatement pst = connection.prepareStatement(query);
		
		pst.setString(1, student.getSID()); //textFieldID.getText());
		pst.setString(2, student.getName()); //textFieldFullName.getText());
		pst.setString(3, student.getEmail()); //textFieldEmail.getText());
		pst.setString(4, student.getCourse());
		pst.setString(5, student.getTelephone());
		pst.execute();
		
		return null;
	}
	
	public String updateStudentProfile(Student student) throws SQLException 
	{
		Connection connection = null;
		connection = Mysql.dbConnector();
		
		String query = "update Student_Registered set SID=? , Image=? where SID='"+Profile.textFieldID.getText()+"' ";
		
		PreparedStatement pst = connection.prepareStatement(query);
		
		pst.setString(1, student.getSID());//textFieldID.getText());
		//pst.setString(2, lblRealTime.getText());
		//pst.setString(3, lblNotGrated.getText());
		pst.setBytes(2, student.getPerson_image());//person_image);
		pst.execute();
		return null;
		
	}
	
	public String selectName(Student student) throws SQLException 
	{
		Connection connection = null;
		connection = Mysql.dbConnector();
		
		String a1= Student_Main.lblYourName.getText();
		String query="Select * from Student_Registered where Username='"+a1+"' ";
		
			PreparedStatement pst= connection.prepareStatement(query);
			ResultSet rs= pst.executeQuery();
			
			if(rs.next())
			{
				Student_Main.lblYourName.setText(rs.getString(2));
				
				rs.close();
				pst.close();
			}
			else
			{
				//JOptionPane.showMessageDialog(null, "Incorrect Username");
			}
			return null;
		
	}
	
	public int assignInsert(Student student) throws SQLException
	{
		int status = 0;
		
		Connection connection = null;
		connection = Mysql.dbConnector();
		
		String query = "update Student_Registered set LID=? where SID='"+Assign_Student.idtextField.getText()+"'";
		
		PreparedStatement pst = connection.prepareStatement(query);
		
		pst.setString(1, student.getLID());
		
		pst.execute();
		pst.close();
		
		return status;
		
	}
	
	public String updateMyStudent_Details(Student student) throws SQLException 
	{
		
		Connection connection = null;
		connection = Mysql.dbConnector();
		
		String query = "update Student_Registered set SID=? , Name=?, Email=?, Course=?, Telephone=? where SID='"+MyStudent_Details.textFieldID.getText()+"' ";
		
		PreparedStatement pst = connection.prepareStatement(query);
		
		pst.setString(1, student.getSID()); //textFieldID.getText());
		pst.setString(2, student.getName()); //textFieldFullName.getText());
		pst.setString(3, student.getEmail()); //textFieldEmail.getText());
		pst.setString(4, student.getCourse());
		pst.setString(5, student.getTelephone());
		pst.execute();
		
		return null;
	}
	
	public String updateAllStudent_Details(Student student) throws SQLException 
	{
		
		Connection connection = null;
		connection = Mysql.dbConnector();
		
		String query = "update Student_Registered set SID=? , Name=?, Email=?, Course=?, Telephone=? where SID='"+Student_Details.textFieldID.getText()+"' ";
		
		PreparedStatement pst = connection.prepareStatement(query);
		
		pst.setString(1, student.getSID()); //textFieldID.getText());
		pst.setString(2, student.getName()); //textFieldFullName.getText());
		pst.setString(3, student.getEmail()); //textFieldEmail.getText());
		pst.setString(4, student.getCourse());
		pst.setString(5, student.getTelephone());
		pst.execute();
		
		return null;
	}
	
	public String updateMyStudentProfile_Details(Student student) throws SQLException 
	{
		Connection connection = null;
		connection = Mysql.dbConnector();
		
		String query = "update Student_Registered set SID=? , Image=? where SID='"+MyStudent_Details.textFieldID.getText()+"' ";
		
		PreparedStatement pst = connection.prepareStatement(query);
		
		pst.setString(1, student.getSID());//textFieldID.getText());
		//pst.setString(2, lblRealTime.getText());
		//pst.setString(3, lblNotGrated.getText());
		pst.setBytes(2, student.getPerson_image());//person_image);
		pst.execute();
		return null;
		
	}
	
	public String updateAllStudentProfile_Details(Student student) throws SQLException 
	{
		Connection connection = null;
		connection = Mysql.dbConnector();
		
		String query = "update Student_Registered set SID=? , Image=? where SID='"+Student_Details.textFieldID.getText()+"' ";
		
		PreparedStatement pst = connection.prepareStatement(query);
		
		pst.setString(1, student.getSID());//textFieldID.getText());
		//pst.setString(2, lblRealTime.getText());
		//pst.setString(3, lblNotGrated.getText());
		pst.setBytes(2, student.getPerson_image());//person_image);
		pst.execute();
		return null;
		
	}
	
	public String refreshSelectProfile(Student student) throws SQLException 
	{
		Connection connection = null;
		connection = Mysql.dbConnector();
		
		String query= "Select * from Student_Registered where SID='"+Profile.textFieldID.getText()+"' ";
		
		PreparedStatement pst = connection.prepareStatement(query);
		ResultSet rs= pst.executeQuery();
		
		if(rs.next())
		{
			student.setSID(rs.getString(2));
			student.setName(rs.getString(3));
			student.setEmail(rs.getString(6));
			student.setCourse(rs.getString(9));
			student.setTelephone(rs.getString(10));
		}
		else 
		{
			JOptionPane.showMessageDialog(null, "Incorrect Username");
		}
		return null;
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

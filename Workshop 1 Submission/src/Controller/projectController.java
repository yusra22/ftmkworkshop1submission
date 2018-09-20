package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Database2.Mysql;
import Model.Document;
import Model.Project;
import View.MyStudent_Details;
import View.Student_Details;
import View.Student_Project;
import View.UploadProposal;

public class projectController {
	
	public int insertProject(Project project) throws SQLException
	{
		int status = 0;
		
		Connection connection = null;
		connection = Mysql.dbConnector();
		
		String query = "insert into Project (SID) values (?)";
		
		PreparedStatement pst = connection.prepareStatement(query);
		
		pst.setString(1, project.getSID());
		
		pst.execute();
		
		pst.close();
		
		return status;
		
	}
	
	public String UpdateProject(Project project) throws SQLException
	{

		
		Connection connection = null;
		connection = Mysql.dbConnector();
		
		String query = "update Project set SID=? , Title=?, Objective=?, Skill=? where SID='"+Student_Project.textFieldID.getText()+"' ";
		
		PreparedStatement pst = connection.prepareStatement(query);
		
		pst.setString(1, project.getSID());
		pst.setString(2, project.getTitle());
		pst.setString(3, project.getObjective());
		pst.setString(4, project.getSkill());
		
		pst.execute();
		
		pst.close();
		
		return null;
		
	}
	
	public String UpdateProjectForMyStudent(Project project) throws SQLException
	{

		
		Connection connection = null;
		connection = Mysql.dbConnector();
		
		String query = "update Project set SID=? , Title=?, Objective=?, Skill=?, Status=? where SID='"+MyStudent_Details.textFieldID.getText()+"' ";
		
		PreparedStatement pst = connection.prepareStatement(query);
		
		pst.setString(1, project.getSID());
		pst.setString(2, project.getTitle());
		pst.setString(3, project.getObjective());
		pst.setString(4, project.getSkill());
		pst.setString(5, project.getStatus());
		
		pst.execute();
		
		pst.close();
		
		return null;
		
	}
	
	public String UpdateProjectForAllStudent(Project project) throws SQLException
	{

		
		Connection connection = null;
		connection = Mysql.dbConnector();
		
		String query = "update Project set SID=? , Title=?, Objective=?, Skill=?, Status=? where SID='"+Student_Details.textFieldID.getText()+"' ";
		
		PreparedStatement pst = connection.prepareStatement(query);
		
		pst.setString(1, project.getSID());
		pst.setString(2, project.getTitle());
		pst.setString(3, project.getObjective());
		pst.setString(4, project.getSkill());
		pst.setString(5, project.getStatus());
		
		pst.execute();
		
		pst.close();
		
		return null;
		
	}
	
	

}

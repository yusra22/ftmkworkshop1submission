package Controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Database2.Mysql;
import Model.Document;
import Model.Student;
import View.UploadAnalysis;
import View.UploadDesign;
import View.UploadProposal;
import View.UploadReport;

public class documentController {
	
	public int insertDocument(Document document) throws SQLException
	{
		int status = 0;
		
		Connection connection = null;
		connection = Mysql.dbConnector();
		
		String query = "insert into Document (SID) values (?)";
		
		PreparedStatement pst = connection.prepareStatement(query);
		
		pst.setString(1, document.getSID());
		
		pst.execute();
		
		pst.close();
		
		return status;
		
	}
	
	public String proposal(Document document) throws SQLException
	{

		
		Connection connection = null;
		connection = Mysql.dbConnector();
		
		String query = "update Document set SID=? , Proposal=?, Ptime=? where SID='"+UploadProposal.lblCardMatrik.getText()+"' ";
		
		PreparedStatement pst = connection.prepareStatement(query);
		
		pst.setString(1, document.getSID());
		pst.setBytes(2, document.getPROPOSAL());
		pst.setString(3, document.getPtime());
		
		pst.execute();
		
		pst.close();
		
		return null;
		
	}
	
	public String analysis(Document document) throws SQLException
	{

		
		Connection connection = null;
		connection = Mysql.dbConnector();
		
		String query = "update Document set SID=? , Analysis=?, Atime=? where SID='"+UploadAnalysis.lblCardMatrik.getText()+"' ";
		
		PreparedStatement pst = connection.prepareStatement(query);
		
		pst.setString(1, document.getSID());
		pst.setBytes(2, document.getPROPOSAL());
		pst.setString(3, document.getPtime());
		
		pst.execute();
		
		pst.close();
		
		return null;
		
	}
	
	public String design(Document document) throws SQLException
	{

		
		Connection connection = null;
		connection = Mysql.dbConnector();
		
		String query = "update Document set SID=? , Design=?, Dtime=? where SID='"+UploadDesign.lblCardMatrik.getText()+"' ";
		
		PreparedStatement pst = connection.prepareStatement(query);
		
		pst.setString(1, document.getSID());
		pst.setBytes(2, document.getPROPOSAL());
		pst.setString(3, document.getPtime());
		
		pst.execute();
		
		pst.close();
		
		return null;
		
	}
	
	public String report(Document document) throws SQLException
	{

		
		Connection connection = null;
		connection = Mysql.dbConnector();
		
		String query = "update Document set SID=? , Report=?, Rtime=? where SID='"+UploadReport.lblCardMatrik.getText()+"' ";
		
		PreparedStatement pst = connection.prepareStatement(query);
		
		pst.setString(1, document.getSID());
		pst.setBytes(2, document.getPROPOSAL());
		pst.setString(3, document.getPtime());
		
		pst.execute();
		
		pst.close();
		
		return null;
		
	}

}

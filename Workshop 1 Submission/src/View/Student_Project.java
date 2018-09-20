package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.MatteBorder;

import Controller.projectController;
import Controller.studentController;
import Database2.Mysql;
import Model.Project;
import Model.Student;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class Student_Project extends JFrame {

	private JPanel contentPane;
	public static JTextField textFieldID;
	private JTextField textFieldTitle;
	private JTextField textFieldObjective;
	private JTextField textFieldSkills;
	private JTextField textFieldStatus;
	

	/**
	 * Launch the application.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student_Project frame = new Student_Project();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection = null;

	/**
	 * Create the frame.
	 */
	public Student_Project() {
		connection=Mysql.dbConnector();
		
		setBackground(new Color(112, 128, 144));
		setTitle("My Project");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 866, 592);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(211, 211, 211));
		contentPane.setBackground(new Color(245, 245, 245));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button_1 = new JButton("Edit");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				textFieldTitle.setForeground(new Color(255, 255, 255));
				textFieldTitle.setEditable(true);
				textFieldTitle.setBackground(new Color(105, 105, 105));
				
				textFieldObjective.setForeground(new Color(255, 255, 255));
				textFieldObjective.setEditable(true);
				textFieldObjective.setBackground(new Color(105, 105, 105));
				
				
				textFieldSkills.setForeground(new Color(255, 255, 255));
				textFieldSkills.setEditable(true);
				textFieldSkills.setBackground(new Color(105, 105, 105));
				
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		button_1.setBackground(Color.GRAY);
		button_1.setBounds(253, 466, 158, 47);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Save");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Project project = new Project();
				project.setSID(textFieldID.getText().trim());
				project.setTitle(textFieldTitle.getText().trim());
				project.setObjective(textFieldObjective.getText().trim());
				project.setSkill(textFieldSkills.getText().trim());
				
				
				try 
				{
					projectController sCtrl = new projectController();
					sCtrl.UpdateProject(project);
					
					JOptionPane.showMessageDialog(null, "Update Success!");
					
				} catch (Exception e2) 
				{
					JOptionPane.showMessageDialog(null, "Update Error");
				}
				
				textFieldTitle.setForeground(new Color(0, 0, 0));
				textFieldTitle.setEditable(false);
				textFieldTitle.setBackground(new Color(245, 245, 245));
				
				textFieldObjective.setForeground(new Color(0, 0, 0));
				textFieldObjective.setEditable(false);
				textFieldObjective.setBackground(new Color(245, 245, 245));
				
				
				textFieldSkills.setForeground(new Color(0, 0, 0));
				textFieldSkills.setEditable(false);
				textFieldSkills.setBackground(new Color(245, 245, 245));
			}
		});
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		button_2.setBackground(new Color(0, 153, 153));
		button_2.setBounds(450, 466, 158, 47);
		contentPane.add(button_2);
		
		JLabel lblProjectDetails = new JLabel("PROJECT DETAILS");
		lblProjectDetails.setForeground(Color.DARK_GRAY);
		lblProjectDetails.setFont(new Font("Arial Narrow", Font.BOLD, 30));
		lblProjectDetails.setBackground(Color.DARK_GRAY);
		lblProjectDetails.setBounds(315, 44, 237, 57);
		contentPane.add(lblProjectDetails);
		
		JButton button_3 = new JButton("Back");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String user = textFieldID.getText();
				Student_Main studentmain = new Student_Main();
				studentmain.lblYourName.setText(user);
				studentmain.setVisible(true);
				dispose();
			}
		});
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		button_3.setBackground(new Color(204, 0, 51));
		button_3.setBounds(12, 54, 158, 44);
		contentPane.add(button_3);
		
		JLabel label = new JLabel("Student ID:");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		label.setBounds(194, 189, 97, 34);
		contentPane.add(label);
		
		textFieldID = new JTextField();
		textFieldID.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
				
				refreshSelect();
			}
			public void ancestorMoved(AncestorEvent arg0) {
			}
			public void ancestorRemoved(AncestorEvent arg0) {
			}
		});
		textFieldID.setForeground(Color.BLACK);
		textFieldID.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		textFieldID.setEditable(false);
		textFieldID.setColumns(10);
		textFieldID.setBackground(new Color(245, 245, 245));
		textFieldID.setBounds(328, 189, 292, 28);
		contentPane.add(textFieldID);
		
		JLabel lblObjective = new JLabel("Title:");
		lblObjective.setForeground(Color.BLACK);
		lblObjective.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblObjective.setBounds(218, 236, 61, 34);
		contentPane.add(lblObjective);
		
		textFieldTitle = new JTextField();
		textFieldTitle.setForeground(Color.BLACK);
		textFieldTitle.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		textFieldTitle.setEditable(false);
		textFieldTitle.setColumns(10);
		textFieldTitle.setBackground(new Color(245, 245, 245));
		textFieldTitle.setBounds(328, 239, 292, 28);
		contentPane.add(textFieldTitle);
		
		JLabel lblObjective_1 = new JLabel("Objective:");
		lblObjective_1.setForeground(Color.BLACK);
		lblObjective_1.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblObjective_1.setBounds(194, 283, 97, 34);
		contentPane.add(lblObjective_1);
		
		textFieldObjective = new JTextField();
		textFieldObjective.setForeground(Color.BLACK);
		textFieldObjective.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		textFieldObjective.setEditable(false);
		textFieldObjective.setColumns(10);
		textFieldObjective.setBackground(new Color(245, 245, 245));
		textFieldObjective.setBounds(328, 286, 292, 28);
		contentPane.add(textFieldObjective);
		
		JLabel lblSkills = new JLabel("Programming Language:");
		lblSkills.setForeground(Color.BLACK);
		lblSkills.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblSkills.setBounds(85, 330, 191, 34);
		contentPane.add(lblSkills);
		
		textFieldSkills = new JTextField();
		textFieldSkills.setForeground(Color.BLACK);
		textFieldSkills.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		textFieldSkills.setEditable(false);
		textFieldSkills.setColumns(10);
		textFieldSkills.setBackground(new Color(245, 245, 245));
		textFieldSkills.setBounds(328, 340, 292, 28);
		contentPane.add(textFieldSkills);
		
		textFieldStatus = new JTextField();
		textFieldStatus.setForeground(Color.BLACK);
		textFieldStatus.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		textFieldStatus.setEditable(false);
		textFieldStatus.setColumns(10);
		textFieldStatus.setBackground(new Color(245, 245, 245));
		textFieldStatus.setBounds(328, 387, 292, 28);
		contentPane.add(textFieldStatus);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setForeground(Color.BLACK);
		lblStatus.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblStatus.setBounds(194, 377, 61, 34);
		contentPane.add(lblStatus);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.controlDkShadow);
		panel.setBounds(0, 114, 860, 10);
		contentPane.add(panel);
		
		setResizable(false);
		setLocationRelativeTo(null);
	}
	
	public void refreshSelect() 
	{
		String a1= textFieldID.getText();
		String query="Select * from Project where SID='"+a1+"' ";
		
		try 
		{
			PreparedStatement pst= connection.prepareStatement(query);
			ResultSet rs= pst.executeQuery();
			
			if(rs.next())
			{
				textFieldID.setText(rs.getString(2));
				textFieldTitle.setText(rs.getString(3));
				textFieldObjective.setText(rs.getString(4));
				textFieldSkills.setText(rs.getString(5));
				textFieldStatus.setText(rs.getString(6));
				
				
				rs.close();
				pst.close();
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "Incorrect Username");
			}
		} catch (Exception e) 
		{
			JOptionPane.showMessageDialog(null, e);
		}
	}
}

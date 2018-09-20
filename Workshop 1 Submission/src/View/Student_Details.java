package View;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.event.AncestorListener;

import Controller.documentController;
import Controller.projectController;
import Controller.studentController;
import Database2.Mysql;
import Model.Document;
import Model.Project;
import Model.Student;

import javax.swing.event.AncestorEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import org.matrix.BlackTabbedPane;

import com.sbix.jnotify.NPosition;
import com.sbix.jnotify.NoticeWindow;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Student_Details extends JFrame {

	private JPanel contentPane;
	public static JTextField textFieldID;
	public static JTextField textFieldFullName;
	private JTextField textFieldCourse;
	private JTextField textFieldEmail;
	private JTextField textFieldContact;
	private ImageIcon format = null;
	public JLabel lblImageDisplay = new JLabel("   Upload Your Picture Here");
	int s=0;
	byte[] person_image=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		//JTattoo Design
        try {
            // select Look and Feel
             UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
		
		
        
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student_Details frame = new Student_Details();
					frame.setVisible(true);
					frame.setResizable(false);
					
					//Set GUI Middle
					Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
					frame.setLocation(screenSize.width/2-frame.getWidth()/2, screenSize.height/2 - frame.getHeight()/2);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection = null;
	public InputStream input = null;
	public FileOutputStream output = null;
	public int k = 1;
	
	private JTextField textFieldPath;
	private JTextField textFieldTitle;
	private JTextField textFieldObjective;
	private JTextField textFieldSkills;
	private JTextField textFieldStatus;
	JLabel lblTime = new JLabel("Real TIme");
	JLabel lblTime2;
	JLabel lblTime3;
	JLabel lblTime4;
	public JComboBox comboBoxStatus;
	

	/**
	 * Create the frame.
	 */
	public Student_Details() {
		
		connection=Mysql.dbConnector();
		
		setBackground(new Color(112, 128, 144));
		setTitle("All Student Profile");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 921, 656);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(211, 211, 211));
		contentPane.setBackground(new Color(245, 245, 245));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(Color.DARK_GRAY);
		tabbedPane.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		tabbedPane.setBackground(new Color(245, 245, 245));
		tabbedPane.setBounds(12, 139, 879, 457);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBackground(new Color(245, 245, 245));
		tabbedPane.addTab("General", null, panel, null);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Student ID:");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		label.setBounds(27, 97, 97, 34);
		panel.add(label);
		
		JLabel lblFullName = new JLabel("Full Name:");
		lblFullName.setForeground(Color.BLACK);
		lblFullName.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblFullName.setBounds(27, 144, 97, 34);
		panel.add(lblFullName);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblEmail.setBounds(27, 238, 61, 34);
		panel.add(lblEmail);
		
		JLabel lblCourse = new JLabel("Course:");
		lblCourse.setForeground(Color.BLACK);
		lblCourse.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblCourse.setBounds(27, 191, 71, 34);
		panel.add(lblCourse);
		
		JLabel lblContact = new JLabel("Contact:");
		lblContact.setForeground(Color.BLACK);
		lblContact.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblContact.setBounds(27, 285, 71, 34);
		panel.add(lblContact);
		
		JLabel lblMyProfile_1 = new JLabel("Student Profile");
		lblMyProfile_1.setForeground(Color.GRAY);
		lblMyProfile_1.setFont(new Font("Arial Narrow", Font.BOLD, 30));
		lblMyProfile_1.setBackground(Color.GRAY);
		lblMyProfile_1.setBounds(27, 31, 185, 53);
		panel.add(lblMyProfile_1);
		
		JPanel imagePanel = new JPanel();
		imagePanel.setBackground(new Color(255, 255, 255));
		imagePanel.setBounds(573, 39, 220, 221);
		panel.add(imagePanel);
		imagePanel.setLayout(null);
		
		lblImageDisplay = new JLabel("   Upload Your Picture Here");
		lblImageDisplay.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		lblImageDisplay.setBounds(0, 0, 220, 221);
		imagePanel.add(lblImageDisplay);
		
		JButton btnChangeProfilePicture = new JButton("Change profile picture");
		btnChangeProfilePicture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				uploadPicture();
				uploadLoad();
				
			}
		});
		btnChangeProfilePicture.setForeground(new Color(245, 245, 245));
		btnChangeProfilePicture.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		btnChangeProfilePicture.setBackground(new Color(0, 153, 153));
		btnChangeProfilePicture.setBounds(573, 261, 220, 45);
		panel.add(btnChangeProfilePicture);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//textFieldID.setForeground(new Color(255, 255, 255));
				//textFieldID.setEditable(true);
				//textFieldID.setBackground(new Color(105, 105, 105));
				
				textFieldFullName.setForeground(new Color(255, 255, 255));
				textFieldFullName.setEditable(true);
				textFieldFullName.setBackground(new Color(105, 105, 105));
				
				textFieldCourse.setForeground(new Color(255, 255, 255));
				textFieldCourse.setEditable(true);
				textFieldCourse.setBackground(new Color(105, 105, 105));
				
				
				textFieldEmail.setForeground(new Color(255, 255, 255));
				textFieldEmail.setEditable(true);
				textFieldEmail.setBackground(new Color(105, 105, 105));
				
				textFieldContact.setForeground(new Color(255, 255, 255));
				textFieldContact.setEditable(true);
				textFieldContact.setBackground(new Color(105, 105, 105));
				
			}
		});
		btnEdit.setForeground(Color.WHITE);
		btnEdit.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		btnEdit.setBackground(new Color(128, 128, 128));
		btnEdit.setBounds(493, 345, 158, 47);
		panel.add(btnEdit);
		
		JButton button_3 =   new JButton("Save");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				updateDataStudent_Registered();
				
				textFieldID.setForeground(new Color(0, 0, 0));
				textFieldID.setEditable(false);
				textFieldID.setBackground(new Color(245, 245, 245));
				
				textFieldFullName.setForeground(new Color(0, 0, 0));
				textFieldFullName.setEditable(false);
				textFieldFullName.setBackground(new Color(245, 245, 245));
				
				textFieldCourse.setForeground(new Color(0, 0, 0));
				textFieldCourse.setEditable(false);
				textFieldCourse.setBackground(new Color(245, 245, 245));
				
				
				textFieldEmail.setForeground(new Color(0, 0, 0));
				textFieldEmail.setEditable(false);
				textFieldEmail.setBackground(new Color(245, 245, 245));
				
				textFieldContact.setForeground(new Color(0, 0, 0));
				textFieldContact.setEditable(false);
				textFieldContact.setBackground(new Color(245, 245, 245));
				
			}
		});
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		button_3.setBackground(new Color(0, 153, 153));
		button_3.setBounds(690, 345, 158, 47);
		panel.add(button_3);
		
		textFieldID = new JTextField();
		textFieldID.setForeground(new Color(0, 0, 0));
		textFieldID.setEditable(false);
		textFieldID.setBackground(new Color(245, 245, 245));
		textFieldID.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		textFieldID.setBounds(161, 97, 292, 28);
		panel.add(textFieldID);
		textFieldID.setColumns(10);
		
		textFieldFullName = new JTextField();
		textFieldFullName.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
				
				refreshSelect();
				refreshProject();
				
			}
			public void ancestorMoved(AncestorEvent arg0) {
			}
			public void ancestorRemoved(AncestorEvent arg0) {
			}
		});
		textFieldFullName.setEditable(false);
		textFieldFullName.setForeground(new Color(0, 0, 0));
		textFieldFullName.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		textFieldFullName.setColumns(10);
		textFieldFullName.setBackground(new Color(245, 245, 245));
		textFieldFullName.setBounds(161, 147, 292, 28);
		panel.add(textFieldFullName);
		
		textFieldCourse = new JTextField();
		textFieldCourse.setEditable(false);
		textFieldCourse.setForeground(new Color(0, 0, 0));
		textFieldCourse.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		textFieldCourse.setColumns(10);
		textFieldCourse.setBackground(new Color(245, 245, 245));
		textFieldCourse.setBounds(161, 194, 292, 28);
		panel.add(textFieldCourse);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setEditable(false);
		textFieldEmail.setForeground(new Color(0, 0, 0));
		textFieldEmail.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		textFieldEmail.setColumns(10);
		textFieldEmail.setBackground(new Color(245, 245, 245));
		textFieldEmail.setBounds(161, 248, 292, 28);
		panel.add(textFieldEmail);
		
		textFieldContact = new JTextField();
		textFieldContact.setEditable(false);
		textFieldContact.setForeground(new Color(0, 0, 0));
		textFieldContact.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		textFieldContact.setColumns(10);
		textFieldContact.setBackground(new Color(245, 245, 245));
		textFieldContact.setBounds(161, 293, 292, 28);
		panel.add(textFieldContact);
		
		textFieldPath = new JTextField();
		textFieldPath.setForeground(Color.WHITE);
		textFieldPath.setColumns(10);
		textFieldPath.setBackground(Color.BLACK);
		textFieldPath.setBounds(583, 273, 208, 22);
		panel.add(textFieldPath);
		
		textFieldStatus = new JTextField();
		textFieldStatus.setBounds(161, 297, 292, 22);
		panel.add(textFieldStatus);
		textFieldStatus.setForeground(Color.BLACK);
		textFieldStatus.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		textFieldStatus.setEditable(false);
		textFieldStatus.setColumns(10);
		textFieldStatus.setBackground(new Color(245, 245, 245));
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(178, 34, 34));
		panel_1.setBackground(new Color(245, 245, 245));
		tabbedPane.addTab("Project", null, panel_1, "");
		panel_1.setLayout(null);
		
		JLabel label_2 = new JLabel("Title:");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		label_2.setBounds(247, 56, 61, 34);
		panel_1.add(label_2);
		
		textFieldTitle = new JTextField();
		textFieldTitle.setForeground(Color.BLACK);
		textFieldTitle.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		textFieldTitle.setEditable(false);
		textFieldTitle.setColumns(10);
		textFieldTitle.setBackground(new Color(245, 245, 245));
		textFieldTitle.setBounds(357, 59, 292, 28);
		panel_1.add(textFieldTitle);
		
		JLabel label_3 = new JLabel("Objective:");
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		label_3.setBounds(223, 103, 97, 34);
		panel_1.add(label_3);
		
		textFieldObjective = new JTextField();
		textFieldObjective.setForeground(Color.BLACK);
		textFieldObjective.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		textFieldObjective.setEditable(false);
		textFieldObjective.setColumns(10);
		textFieldObjective.setBackground(new Color(245, 245, 245));
		textFieldObjective.setBounds(357, 106, 292, 28);
		panel_1.add(textFieldObjective);
		
		JLabel label_4 = new JLabel("Programming Language:");
		label_4.setForeground(Color.BLACK);
		label_4.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		label_4.setBounds(114, 150, 191, 34);
		panel_1.add(label_4);
		
		textFieldSkills = new JTextField();
		textFieldSkills.setForeground(Color.BLACK);
		textFieldSkills.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		textFieldSkills.setEditable(false);
		textFieldSkills.setColumns(10);
		textFieldSkills.setBackground(new Color(245, 245, 245));
		textFieldSkills.setBounds(357, 160, 292, 28);
		panel_1.add(textFieldSkills);
		
		JLabel label_5 = new JLabel("Status");
		label_5.setForeground(Color.BLACK);
		label_5.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		label_5.setBounds(223, 197, 61, 34);
		panel_1.add(label_5);
		
		comboBoxStatus = new JComboBox();
		comboBoxStatus.setEnabled(false);
		comboBoxStatus.setModel(new DefaultComboBoxModel(new String[] {"Not Approve", "Approve"}));
		comboBoxStatus.setForeground(Color.BLACK);
		comboBoxStatus.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		comboBoxStatus.setBackground(new Color(245, 245, 245));
		comboBoxStatus.setBounds(357, 201, 292, 34);
		panel_1.add(comboBoxStatus);
		
		JButton button = new JButton("Edit");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textFieldTitle.setForeground(new Color(255, 255, 255));
				textFieldTitle.setEditable(true);
				textFieldTitle.setBackground(new Color(105, 105, 105));
				
				textFieldObjective.setForeground(new Color(255, 255, 255));
				textFieldObjective.setEditable(true);
				textFieldObjective.setBackground(new Color(105, 105, 105));
				
				
				textFieldSkills.setForeground(new Color(255, 255, 255));
				textFieldSkills.setEditable(true);
				textFieldSkills.setBackground(new Color(105, 105, 105));
				
				textFieldStatus.setForeground(new Color(255, 255, 255));
				textFieldStatus.setEditable(true);
				textFieldStatus.setBackground(new Color(105, 105, 105));
				
				comboBoxStatus.setEnabled(true);
				
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		button.setBackground(Color.GRAY);
		button.setBounds(294, 305, 158, 47);
		panel_1.add(button);
		
		JButton button_1 = new JButton("Save");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Project project = new Project();
				project.setSID(textFieldID.getText().trim());
				project.setTitle(textFieldTitle.getText().trim());
				project.setObjective(textFieldObjective.getText().trim());
				project.setSkill(textFieldSkills.getText().trim());
				project.setStatus(textFieldStatus.getText().trim());
				project.setStatus((String) comboBoxStatus.getSelectedItem());
				
				
				
				try 
				{
					projectController sCtrl = new projectController();
					sCtrl.UpdateProjectForAllStudent(project);
					
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
				
				textFieldStatus.setForeground(new Color(0, 0, 0));
				textFieldStatus.setEditable(false);
				textFieldStatus.setBackground(new Color(245, 245, 245));
				
				comboBoxStatus.setEnabled(false);
				
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		button_1.setBackground(new Color(0, 153, 153));
		button_1.setBounds(491, 305, 158, 47);
		panel_1.add(button_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(245, 245, 245));
		tabbedPane.addTab("File Upload", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel label_1 = new JLabel("PROPOSAL");
		label_1.setForeground(Color.GRAY);
		label_1.setFont(new Font("Arial Narrow", Font.BOLD, 30));
		label_1.setBackground(Color.GRAY);
		label_1.setBounds(12, 13, 145, 65);
		panel_2.add(label_1);
		
		JLabel label_6 = new JLabel("Time Upload:");
		label_6.setForeground(Color.BLACK);
		label_6.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		label_6.setBounds(12, 91, 109, 34);
		panel_2.add(label_6);
		
		JLabel label_7 = new JLabel("File Submission:");
		label_7.setForeground(Color.BLACK);
		label_7.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		label_7.setBounds(12, 138, 154, 34);
		panel_2.add(label_7);
		
		lblTime = new JLabel("Real TIme");
		lblTime.setForeground(Color.BLACK);
		lblTime.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		lblTime.setBounds(121, 91, 188, 34);
		panel_2.add(lblTime);
		
		JButton btnNewButton = new JButton("Download");
		btnNewButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent arg0) {
				
				try 
				{
					String a1= textFieldID.getText();
					String query2 ="Select Proposal from Document where SID='"+a1+"'";
					PreparedStatement pst2= connection.prepareStatement(query2);
					
					ResultSet rs= pst2.executeQuery(query2);
					
					Random dice = new Random();
					int number = 0;
					
					for(int counter=1;counter<=10;counter++)
					{
						number= 1+dice.nextInt(30);
						System.out.println(number + " ");
					}
					
					
					File theFile = new File("Proposal "+a1+"("+number+")"+".pdf");
					output = new FileOutputStream(theFile);
					
					if(rs.next()) 
					{
						input = rs.getBinaryStream("proposal");
						System.out.println("Reading from database....");
						System.out.println(query2);
						
						byte[] buffer = new byte[1024];
						while (input.read(buffer) > 0) 
						{
							output.write(buffer);
						}
						
						System.out.println("\nSaved to file:" + theFile.getAbsolutePath());
						System.out.println("\nCompleted successfully!");
						
						new NoticeWindow("\nSaved to file:" + theFile.getAbsolutePath(), NPosition.BOTTOM_RIGHT);
					}
					
					rs.close();
					pst2.close();
					//connection.close();
					
				} 
				catch (SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally 
				{
					if (input !=null) 
					{
						try {
							input.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					if(output != null) 
					{
						try {
							output.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				
				
			}
		});
		btnNewButton.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		btnNewButton.setBounds(150, 138, 117, 32);
		panel_2.add(btnNewButton);
		
		JLabel label_8 = new JLabel("DESIGN");
		label_8.setForeground(Color.GRAY);
		label_8.setFont(new Font("Arial Narrow", Font.BOLD, 30));
		label_8.setBackground(Color.GRAY);
		label_8.setBounds(12, 234, 145, 65);
		panel_2.add(label_8);
		
		JLabel label_9 = new JLabel("Time Upload:");
		label_9.setForeground(Color.BLACK);
		label_9.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		label_9.setBounds(12, 312, 109, 34);
		panel_2.add(label_9);
		
		lblTime3 = new JLabel("Real TIme");
		lblTime3.setForeground(Color.BLACK);
		lblTime3.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		lblTime3.setBounds(121, 312, 188, 34);
		panel_2.add(lblTime3);
		
		JLabel label_11 = new JLabel("File Submission:");
		label_11.setForeground(Color.BLACK);
		label_11.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		label_11.setBounds(12, 359, 154, 34);
		panel_2.add(label_11);
		
		JButton button_4 = new JButton("Download");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try 
				{
					String a1= textFieldID.getText();
					String query2 ="Select Design from Document where SID='"+a1+"'";
					PreparedStatement pst2= connection.prepareStatement(query2);
					
					ResultSet rs= pst2.executeQuery(query2);
					
					Random dice = new Random();
					int number = 0;
					
					for(int counter=1;counter<=10;counter++)
					{
						number= 1+dice.nextInt(30);
						System.out.println(number + " ");
					}
					
					
					File theFile = new File("Design "+a1+"("+number+")"+".pdf");
					output = new FileOutputStream(theFile);
					
					if(rs.next()) 
					{
						input = rs.getBinaryStream("design");
						System.out.println("Reading from database....");
						System.out.println(query2);
						
						byte[] buffer = new byte[1024];
						while (input.read(buffer) > 0) 
						{
							output.write(buffer);
						}
						
						System.out.println("\nSaved to file:" + theFile.getAbsolutePath());
						System.out.println("\nCompleted successfully!");
						
						new NoticeWindow("\nSaved to file:" + theFile.getAbsolutePath(), NPosition.BOTTOM_RIGHT);
					}
					
					rs.close();
					pst2.close();
					//connection.close();
					
				} 
				catch (SQLException | IOException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
					
				} finally 
				{
					if (input !=null) 
					{
						try {
							input.close();
						} catch (IOException e3) {
							// TODO Auto-generated catch block
							e3.printStackTrace();
						}
					}
					
					if(output != null) 
					{
						try {
							output.close();
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
					}
				}
				
			}
		});
		button_4.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		button_4.setBounds(150, 359, 117, 32);
		panel_2.add(button_4);
		
		JLabel label_12 = new JLabel("File Submission:");
		label_12.setForeground(Color.BLACK);
		label_12.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		label_12.setBounds(441, 359, 154, 34);
		panel_2.add(label_12);
		
		JLabel label_13 = new JLabel("Time Upload:");
		label_13.setForeground(Color.BLACK);
		label_13.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		label_13.setBounds(441, 312, 109, 34);
		panel_2.add(label_13);
		
		lblTime4 = new JLabel("Real TIme");
		lblTime4.setForeground(Color.BLACK);
		lblTime4.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		lblTime4.setBounds(550, 312, 188, 34);
		panel_2.add(lblTime4);
		
		JButton button_5 = new JButton("Download");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try 
				{
					String a1= textFieldID.getText();
					String query2 ="Select Report from Document where SID='"+a1+"'";
					PreparedStatement pst2= connection.prepareStatement(query2);
					
					ResultSet rs= pst2.executeQuery(query2);
					
					Random dice = new Random();
					int number = 0;
					
					for(int counter=1;counter<=10;counter++)
					{
						number= 1+dice.nextInt(30);
						System.out.println(number + " ");
					}
					
					
					File theFile = new File("Report "+a1+"("+number+")"+".pdf");
					output = new FileOutputStream(theFile);
					
					if(rs.next()) 
					{
						input = rs.getBinaryStream("report");
						System.out.println("Reading from database....");
						System.out.println(query2);
						
						byte[] buffer = new byte[1024];
						while (input.read(buffer) > 0) 
						{
							output.write(buffer);
						}
						
						System.out.println("\nSaved to file:" + theFile.getAbsolutePath());
						System.out.println("\nCompleted successfully!");
						
						new NoticeWindow("\nSaved to file:" + theFile.getAbsolutePath(), NPosition.BOTTOM_RIGHT);
					}
					
					rs.close();
					pst2.close();
					//connection.close();
					
				} 
				catch (SQLException | IOException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
					
				} finally 
				{
					if (input !=null) 
					{
						try {
							input.close();
						} catch (IOException e3) {
							// TODO Auto-generated catch block
							e3.printStackTrace();
						}
					}
					
					if(output != null) 
					{
						try {
							output.close();
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
					}
				}
				
			}
		});
		button_5.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		button_5.setBounds(579, 359, 117, 32);
		panel_2.add(button_5);
		
		JLabel label_15 = new JLabel("REPORT");
		label_15.setForeground(Color.GRAY);
		label_15.setFont(new Font("Arial Narrow", Font.BOLD, 30));
		label_15.setBackground(Color.GRAY);
		label_15.setBounds(441, 234, 145, 65);
		panel_2.add(label_15);
		
		JLabel label_16 = new JLabel("File Submission:");
		label_16.setForeground(Color.BLACK);
		label_16.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		label_16.setBounds(441, 138, 154, 34);
		panel_2.add(label_16);
		
		JButton button_6 = new JButton("Download");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try 
				{
					String a1= textFieldID.getText();
					String query2 ="Select Analysis from Document where SID='"+a1+"'";
					PreparedStatement pst2= connection.prepareStatement(query2);
					
					ResultSet rs= pst2.executeQuery(query2);
					
					Random dice = new Random();
					int number = 0;
					
					for(int counter=1;counter<=10;counter++)
					{
						number= 1+dice.nextInt(30);
						System.out.println(number + " ");
					}
					
					
					File theFile = new File("Analysis "+a1+"("+number+")"+".pdf");
					output = new FileOutputStream(theFile);
					
					if(rs.next()) 
					{
						input = rs.getBinaryStream("analysis");
						System.out.println("Reading from database....");
						System.out.println(query2);
						
						byte[] buffer = new byte[1024];
						while (input.read(buffer) > 0) 
						{
							output.write(buffer);
						}
						
						System.out.println("\nSaved to file:" + theFile.getAbsolutePath());
						System.out.println("\nCompleted successfully!");
						
						new NoticeWindow("\nSaved to file:" + theFile.getAbsolutePath(), NPosition.BOTTOM_RIGHT);
					}
					
					rs.close();
					pst2.close();
					//connection.close();
					
				} 
				catch (SQLException | IOException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
					
				} finally 
				{
					if (input !=null) 
					{
						try {
							input.close();
						} catch (IOException e3) {
							// TODO Auto-generated catch block
							e3.printStackTrace();
						}
					}
					
					if(output != null) 
					{
						try {
							output.close();
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
					}
				}
				
			}
		});
		button_6.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		button_6.setBounds(579, 138, 117, 32);
		panel_2.add(button_6);
		
		JLabel label_17 = new JLabel("Time Upload:");
		label_17.setForeground(Color.BLACK);
		label_17.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		label_17.setBounds(441, 91, 109, 34);
		panel_2.add(label_17);
		
		lblTime2 = new JLabel("Real TIme");
		lblTime2.setForeground(Color.BLACK);
		lblTime2.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		lblTime2.setBounds(550, 91, 188, 34);
		panel_2.add(lblTime2);
		
		JLabel label_19 = new JLabel("ANALYSIS");
		label_19.setForeground(Color.GRAY);
		label_19.setFont(new Font("Arial Narrow", Font.BOLD, 30));
		label_19.setBackground(Color.GRAY);
		label_19.setBounds(441, 13, 145, 65);
		panel_2.add(label_19);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new MatteBorder(0, 0, 10, 0, (Color) Color.LIGHT_GRAY));
		panel_3.setBackground(new Color(245, 245, 245));
		panel_3.setBounds(0, 0, 911, 122);
		contentPane.add(panel_3);
		
		JLabel lblProfile = new JLabel("STUDENT INFO");
		lblProfile.setForeground(Color.GRAY);
		lblProfile.setFont(new Font("Arial Narrow", Font.BOLD, 30));
		lblProfile.setBackground(Color.GRAY);
		lblProfile.setBounds(332, 39, 190, 57);
		panel_3.add(lblProfile);
		
		JButton button_2 = new JButton("Back");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//String user = textFieldID.getText();
				Student_Search1 studsearch = new Student_Search1();
				studsearch.setVisible(true);
				dispose();
				
			}
		});
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		button_2.setBackground(new Color(204, 0, 51));
		button_2.setBounds(12, 49, 158, 44);
		panel_3.add(button_2);
		
		setResizable(false);
		setLocationRelativeTo(null);
		setIcon();
	}
	
	public void updateDataStudent_Registered() 
	{
		
		
		Student student = new Student();
		student.setSID(textFieldID.getText().trim());
		student.setName(textFieldFullName.getText().trim());
		student.setEmail(textFieldEmail.getText().trim());
		student.setCourse(textFieldCourse.getText().trim());
		student.setTelephone(textFieldContact.getText().trim());
		
		try 
		{
			studentController sCtrl = new studentController();
			sCtrl.updateAllStudent_Details(student);
			
			JOptionPane.showMessageDialog(null, "Update Success!");
			
		} catch (Exception e) 
		{
			JOptionPane.showMessageDialog(null, "Update Error");
		}
		
		/*try 
		{
		String query = "update Student_Registered set SID=? , Name=?, Email=? where SID='"+textFieldID.getText()+"' ";
		
		PreparedStatement pst = connection.prepareStatement(query);
		
		pst.setString(1, textFieldID.getText());
		pst.setString(2, textFieldFullName.getText());
		pst.setString(3, textFieldEmail.getText());
		pst.execute();
		
		//ResultSet rs= pst.executeQuery();
		
		JOptionPane.showMessageDialog(null, "Update Success");
		
		pst.close();
		}
		catch (Exception e1) 
		{
			JOptionPane.showMessageDialog(null, "Update Error");
		}*/
	}
	
	public void uploadPicture() 
	{
		String filename =null;
		
		JFileChooser chooser = new JFileChooser();
		chooser.showOpenDialog(null);
		File f = chooser.getSelectedFile();
		filename = f.getAbsolutePath();
		textFieldPath.setText(filename);
		
		try 
		{
			File image = new File (filename);
			FileInputStream fis= new FileInputStream(image);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			for(int readNum; (readNum=fis.read(buf))!=-1;) 
			{
				bos.write(buf, 0, readNum);
				
			}
			person_image=bos.toByteArray();
			
		}
		catch(Exception e) 
		{
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	public void uploadLoad() 
	{
		
		
		Student student = new Student();
		student.setSID(textFieldID.getText());
		student.setPerson_image(person_image);
		
		try 
		{
			studentController sCtrl = new studentController();
			sCtrl.updateAllStudentProfile_Details(student);
			
			refreshSelect();
			
			JOptionPane.showMessageDialog(null, "Update Success!");
			
		} catch (Exception e2) 
		{
			//JOptionPane.showMessageDialog(null, "Update Error");
		}
		
		
		/*try 
		{
			
		//String query = "update StudentInfo set SID=? , Name=?, Username=? , Document=? where SID='"+lblCardMatrik.getText()+"' ";
		String query = "update StudentInfo set SID=? , Image=? where SID='"+textFieldID.getText()+"' ";
		
		PreparedStatement pst = connection.prepareStatement(query);
		
		pst.setString(1, textFieldID.getText());
		//pst.setString(2, lblRealTime.getText());
		//pst.setString(3, lblNotGrated.getText());
		pst.setBytes(2, person_image);
		pst.execute();
		
		//ResultSet rs= pst.executeQuery();
		
		JOptionPane.showMessageDialog(null, "Update Success");
		
		pst.close();
		}
		catch (Exception e1) 
		{
			JOptionPane.showMessageDialog(null, "Update Error");
		}*/
		
	}
	
	public void refreshSelect() 
	{
		String a1= textFieldID.getText();
		String query="Select * from Student_Registered,Project,Document where Student_Registered.SID='"+a1+"' = Document.SID='"+a1+"' ";
		
		try 
		{
			PreparedStatement pst= connection.prepareStatement(query);
			ResultSet rs= pst.executeQuery();
			
			if(rs.next())
			{
				textFieldID.setText(rs.getString(2));
				textFieldFullName.setText(rs.getString(3));
				textFieldEmail.setText(rs.getString(6));
				textFieldCourse.setText(rs.getString(9));
				textFieldContact.setText(rs.getString(10));
				/*textFieldTitle.setText(rs.getString("Title"));
				textFieldObjective.setText(rs.getString("Objective"));
				textFieldSkills.setText(rs.getString("Skill"));
				textFieldStatus.setText(rs.getString("Status"));*/
				lblTime.setText(rs.getString("Ptime"));
				lblTime2.setText(rs.getString("Atime"));
				lblTime3.setText(rs.getString("Dtime"));
				lblTime4.setText(rs.getString("Rtime"));
				
				
				//For Display Image
				byte[] imagedata = rs.getBytes("image");
				format = new ImageIcon(imagedata);
				lblImageDisplay.setIcon(format);
				lblImageDisplay.setIcon(new ImageIcon(new javax.swing.ImageIcon(imagedata).getImage().getScaledInstance(lblImageDisplay.getWidth(), lblImageDisplay.getHeight(), Image.SCALE_SMOOTH)));
					
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
	
	public void refreshProject()
	{
		String a1= textFieldID.getText();
		String query="Select * from Project where Project.SID='"+a1+"' ";
		
		try 
		{
			PreparedStatement pst= connection.prepareStatement(query);
			ResultSet rs= pst.executeQuery();
			
			if(rs.next())
			{
				textFieldTitle.setText(rs.getString(3));
				textFieldObjective.setText(rs.getString("Objective"));
				textFieldSkills.setText(rs.getString("Skill"));
				textFieldStatus.setText(rs.getString("Status"));
				comboBoxStatus.setSelectedItem(rs.getString("Status"));

			}
			
		} catch (Exception e) 
		{
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	private void setIcon() 
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/FTMK logo.png")));
	}
}

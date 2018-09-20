package View;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;
import java.sql.*;
import javax.swing.*;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;

import Controller.documentController;
import Controller.lecturerController;
import Controller.projectController;
import Controller.studentController;
import Database2.Mysql;
import Model.Document;
import Model.Lecturer;
import Model.Project;
import Model.Student;

import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField fullnameField;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JTextField emailField;
	public JButton btnLecturer = new JButton("Register");
	public JComboBox comboBox_1;
	public JComboBox comboBox_2;

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
					Register frame = new Register();
					frame.setVisible(true);
					
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
	private JTextField answertextField;
	private JTextField matricField;
	private JTextField textFieldCourse;
	private JTextField textFieldTelephone;
	public JComboBox questionComboBox = new JComboBox();
	private JTextField staffanswer;
	private JTextField stafftel;
	private JTextField staffemail;
	private JTextField staffusername;
	private JTextField staffid;
	private JTextField staffposition;
	private JPasswordField staffpassword;
	private JTextField stafffullname;
	public JComboBox comboBox;
	/**
	 * Create the frame.
	 */
	public Register() {
		
		connection = Mysql.dbConnector();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1159, 652);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(128, 128, 128));
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 206, 209), 6));
		panel.setBounds(0, 0, 1153, 617);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblRegister = new JLabel("");
		lblRegister.setBounds(37, 112, 324, 317);
		panel.add(lblRegister);
		//Image registerlogo = new ImageIcon(this.getClass().getResource("/register2.png")).getImage();
		//lblRegister.setIcon(new ImageIcon(registerlogo));
		lblRegister.setForeground(Color.WHITE);
		lblRegister.setBackground(Color.WHITE);
		lblRegister.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/register2.png")).getImage().getScaledInstance(lblRegister.getWidth(), lblRegister.getHeight(), Image.SCALE_SMOOTH)));
		
		JLabel lblProgramming = new JLabel("\" Programming Is Usually Taught By Examples\"");
		lblProgramming.setBounds(37, 447, 342, 91);
		panel.add(lblProgramming);
		lblProgramming.setFont(new Font("Monotype Corsiva", Font.PLAIN, 20));
		lblProgramming.setForeground(new Color(245, 245, 245));
		
		JLabel lblNiklas = new JLabel("< Niklaus WIrth />");
		lblNiklas.setBounds(125, 527, 160, 44);
		panel.add(lblNiklas);
		lblNiklas.setForeground(new Color(245, 245, 245));
		lblNiklas.setFont(new Font("Monotype Corsiva", Font.PLAIN, 20));
		
		JLabel lblNewLabel = new JLabel("REGISTERATION FORM");
		lblNewLabel.setBounds(105, 47, 200, 44);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(245, 245, 245));
		lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		
		JLabel lblSignInOr = new JLabel("SIGN IN OR SIGN UP");
		lblSignInOr.setBounds(434, 47, 177, 44);
		panel.add(lblSignInOr);
		lblSignInOr.setForeground(new Color(245, 245, 245));
		lblSignInOr.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		tabbedPane.setBounds(379, 86, 762, 502);
		panel.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.LIGHT_GRAY);
		tabbedPane.addTab("Student", null, panel_1, null);
		panel_1.setLayout(null);
		
		textFieldCourse = new JTextField();
		textFieldCourse.setBounds(380, 192, 314, 36);
		panel_1.add(textFieldCourse);
		textFieldCourse.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		textFieldCourse.setColumns(20);
		
		JLabel lblCourse = new JLabel("Course");
		lblCourse.setBounds(381, 155, 82, 44);
		panel_1.add(lblCourse);
		lblCourse.setForeground(Color.WHITE);
		lblCourse.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				String pass = passwordField.getText();
				
				if(pass.length()<7)
				{
					  System.out.println("Password should be less than 15 and more than 8 characters in length.");
					  passwordField.setBackground(Color.RED);
				}
				else
				{
					System.out.println("Password is Good.");
					passwordField.setBackground(Color.DARK_GRAY);
				}
				
			}
		});
		passwordField.setBounds(380, 123, 314, 36);
		panel_1.add(passwordField);
		passwordField.setFont(new Font("Arial Narrow", Font.PLAIN, 25));
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(380, 86, 82, 44);
		panel_1.add(lblPassword);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		
		fullnameField = new JTextField();
		fullnameField.setBounds(380, 54, 314, 36);
		panel_1.add(fullnameField);
		fullnameField.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		fullnameField.setColumns(20);
		
		JLabel lblFullName = new JLabel("Full Name");
		lblFullName.setBounds(381, 15, 82, 44);
		panel_1.add(lblFullName);
		lblFullName.setForeground(Color.WHITE);
		lblFullName.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		
		JLabel lblNoMatric = new JLabel("No Matric");
		lblNoMatric.setBounds(28, 15, 82, 44);
		panel_1.add(lblNoMatric);
		lblNoMatric.setForeground(Color.WHITE);
		lblNoMatric.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		
		matricField = new JTextField();
		matricField.setBounds(27, 54, 314, 36);
		panel_1.add(matricField);
		matricField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				String SID = matricField.getText();
				
				if(SID.length()<9)
				{
					  System.out.println("Password should be less than 15 and more than 8 characters in length.");
					  matricField.setBackground(Color.RED);
				}
				else
				{
					System.out.println("Password is Good.");
					matricField.setBackground(Color.DARK_GRAY);
				}
				
				/*int key=arg0.getKeyCode();
				if((key>=arg0.VK_0&&key<=arg0.VK_9) ||(key>=arg0.VK_NUMPAD0&&key<=arg0.VK_NUMPAD9 || key==KeyEvent.VK_BACK_SPACE))
				{
					matricField.setEditable(true);
					matricField.setBackground(Color.YELLOW);
				}
				else 
				{
					matricField.setEditable(false);
					matricField.setBackground(Color.RED);
				}*/
				
			}
		});
		matricField.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		matricField.setColumns(20);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(28, 86, 82, 44);
		panel_1.add(lblUsername);
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		
		usernameField = new JTextField();
		usernameField.setBounds(27, 125, 314, 36);
		panel_1.add(usernameField);
		usernameField.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		usernameField.setColumns(20);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(28, 155, 82, 44);
		panel_1.add(lblEmail);
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		
		emailField = new JTextField();
		emailField.setBounds(27, 194, 314, 36);
		panel_1.add(emailField);
		emailField.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		emailField.setColumns(20);
		
		JLabel lblTel = new JLabel("Telephone No.");
		lblTel.setBounds(380, 231, 107, 44);
		panel_1.add(lblTel);
		lblTel.setForeground(Color.WHITE);
		lblTel.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		
		textFieldTelephone = new JTextField();
		textFieldTelephone.setBounds(380, 269, 314, 36);
		panel_1.add(textFieldTelephone);
		textFieldTelephone.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		textFieldTelephone.setColumns(20);
		
		answertextField = new JTextField();
		answertextField.setBounds(27, 337, 314, 36);
		panel_1.add(answertextField);
		answertextField.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		answertextField.setColumns(20);
		
		JLabel lblAnswer = new JLabel("Answer");
		lblAnswer.setBounds(28, 298, 82, 44);
		panel_1.add(lblAnswer);
		lblAnswer.setForeground(Color.WHITE);
		lblAnswer.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(27, 404, 158, 47);
		panel_1.add(btnRegister);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				
				String SID = matricField.getText().trim();
				String Name = fullnameField.getText().trim();
				String Username = usernameField.getText().trim();
				String Password = passwordField.getText().trim();
				String Course = textFieldCourse.getText().trim();
				String Telephone = textFieldTelephone.getText().trim();
				
				if(SID.equals("")) {
					
					JOptionPane.showMessageDialog(null, "Your Student ID cannot be empty");
					
				}
				if(Name.equals("")) 
				{
					JOptionPane.showMessageDialog(null, "Please Enter Your Name");
				}
				if(Username.equals("")) 
				{
					JOptionPane.showMessageDialog(null, "Your username cannot be empty");
				}

				if(Course.equals("")) 
				{
					JOptionPane.showMessageDialog(null, "Your Course cannot be empty");
				}
				if(Telephone.equals("")) 
				{
					JOptionPane.showMessageDialog(null, "Please enter your contact number");
				}
				if(Password.equals("")||Password.length()<8) 
				{
					JOptionPane.showMessageDialog(null, "Your password must be longer than 8 character");
				}
				if(Password.length()>=8) 
				{
					Student student = new Student();
					student.setSID(matricField.getText().trim());
					student.setName(fullnameField.getText().trim());
					student.setUsername(usernameField.getText().trim());
					student.setPassword(passwordField.getText().trim());
					student.setEmail(emailField.getText().trim());
					student.setQuestions((String) questionComboBox.getSelectedItem());
					student.setAnswer(answertextField.getText().trim());
					student.setCourse(textFieldCourse.getText().trim());
					student.setTelephone(textFieldTelephone.getText().trim());
					student.setKohout((String)comboBox_2.getSelectedItem());
					//student.setImage(answertextField.getText());
					
					Document document = new Document();
					document.setSID(matricField.getText().trim());
					
					Project project = new Project();
					project.setSID(matricField.getText().trim());
					
					try 
					{
					studentController sCtrl = new studentController();
					sCtrl.insertUser(student);
					
					documentController dCtrl = new documentController();
					dCtrl.insertDocument(document);
					
					projectController pCtrl = new projectController();
					pCtrl.insertProject(project);
					
					JOptionPane.showMessageDialog(null, "You Are Registered");
					
					} 
					catch (Exception e) 
					{
						JOptionPane.showMessageDialog(null, "Please Register Again/ You Already Registered");
					}
				}
			}
			});
		btnRegister.setForeground(Color.WHITE);
		btnRegister.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		btnRegister.setBackground(new Color(0, 153, 153));
		
		JLabel btnAlreadyMember = new JLabel("Already a member");
		btnAlreadyMember.setBounds(235, 405, 147, 44);
		panel_1.add(btnAlreadyMember);
		btnAlreadyMember.setBackground(Color.RED);
		btnAlreadyMember.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnAlreadyMember.setForeground(new Color(204, 0, 51));
				dispose();
				Login login = new Login();
				login.setVisible(true);

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnAlreadyMember.setForeground(new Color(204, 0, 51));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnAlreadyMember.setForeground(new Color(245, 245, 245));
			}
		});
		btnAlreadyMember.setForeground(new Color(245, 245, 245));
		btnAlreadyMember.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		
		comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		comboBox_2.setBounds(380, 337, 314, 36);
		panel_1.add(comboBox_2);
		
		JLabel label_4 = new JLabel("Semester:");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		label_4.setBounds(380, 298, 136, 44);
		panel_1.add(label_4);
		questionComboBox.setBounds(27, 270, 314, 36);
		panel_1.add(questionComboBox);
		questionComboBox.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		questionComboBox.setModel(new DefaultComboBoxModel(new String[] {"What you favourite color?", "What is your nick name?", "Who is your lover?", "What is your favourite game?"}));
		
		JLabel lblSecurityQuestion = new JLabel("Security Question");
		lblSecurityQuestion.setBounds(27, 231, 136, 44);
		panel_1.add(lblSecurityQuestion);
		lblSecurityQuestion.setForeground(Color.WHITE);
		lblSecurityQuestion.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Lecturer", null, panel_2, null);
		panel_2.setLayout(null);
		
		staffanswer = new JTextField();
		staffanswer.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		staffanswer.setColumns(20);
		staffanswer.setBounds(27, 335, 314, 36);
		panel_2.add(staffanswer);
		
		JLabel label = new JLabel("Answer");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		label.setBounds(28, 296, 82, 44);
		panel_2.add(label);
		
		stafftel = new JTextField();
		stafftel.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		stafftel.setColumns(20);
		stafftel.setBounds(380, 266, 314, 36);
		panel_2.add(stafftel);
		
		JLabel label_1 = new JLabel("Telephone No.");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		label_1.setBounds(380, 228, 107, 44);
		panel_2.add(label_1);
		
		staffemail = new JTextField();
		staffemail.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		staffemail.setColumns(20);
		staffemail.setBounds(27, 192, 314, 36);
		panel_2.add(staffemail);
		
		JLabel label_2 = new JLabel("Email");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		label_2.setBounds(28, 153, 82, 44);
		panel_2.add(label_2);
		
		staffusername = new JTextField();
		staffusername.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		staffusername.setColumns(20);
		staffusername.setBounds(27, 123, 314, 36);
		panel_2.add(staffusername);
		
		JLabel label_3 = new JLabel("Username");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		label_3.setBounds(28, 84, 82, 44);
		panel_2.add(label_3);
		
		staffid = new JTextField();
		staffid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				String LID = staffid.getText();
				
				if(LID.length()<9)
				{
					  System.out.println("Password should be less than 15 and more than 8 characters in length.");
					  staffid.setBackground(Color.RED);
				}
				else
				{
					System.out.println("Password is Good.");
					staffid.setBackground(Color.DARK_GRAY);
				}
			}
		});
		staffid.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		staffid.setColumns(20);
		staffid.setBounds(27, 52, 314, 36);
		panel_2.add(staffid);
		
		JLabel lblNoStaff = new JLabel("No Staff");
		lblNoStaff.setForeground(Color.WHITE);
		lblNoStaff.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		lblNoStaff.setBounds(28, 13, 82, 44);
		panel_2.add(lblNoStaff);
		
		staffposition = new JTextField();
		staffposition.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		staffposition.setColumns(20);
		staffposition.setBounds(380, 190, 314, 36);
		panel_2.add(staffposition);
		
		JLabel lblUnit = new JLabel("Position");
		lblUnit.setForeground(Color.WHITE);
		lblUnit.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		lblUnit.setBounds(381, 153, 82, 44);
		panel_2.add(lblUnit);
		
		staffpassword = new JPasswordField();
		staffpassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String password = staffpassword.getText();
				
				if(password.length()<7)
				{
					  System.out.println("Password should be less than 15 and more than 8 characters in length.");
					  staffpassword.setBackground(Color.RED);
				}
				else
				{
					System.out.println("Password is Good.");
					staffpassword.setBackground(Color.DARK_GRAY);
				}
			}
		});
		staffpassword.setFont(new Font("Arial Narrow", Font.PLAIN, 25));
		staffpassword.setBounds(380, 121, 314, 36);
		panel_2.add(staffpassword);
		
		JLabel label_7 = new JLabel("Password");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		label_7.setBounds(380, 84, 82, 44);
		panel_2.add(label_7);
		
		stafffullname = new JTextField();
		stafffullname.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		stafffullname.setColumns(20);
		stafffullname.setBounds(380, 52, 314, 36);
		panel_2.add(stafffullname);
		
		JLabel label_8 = new JLabel("Full Name");
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		label_8.setBounds(381, 13, 82, 44);
		panel_2.add(label_8);
		
		btnLecturer = new JButton("Register");
		btnLecturer.setBounds(27, 404, 158, 47);
		panel_2.add(btnLecturer);
		btnLecturer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String LID = staffid.getText().trim();
				String Name = stafffullname.getText().trim();
				String Username = staffusername.getText().trim();
				String Password = staffpassword.getText().trim();
				String Position = staffposition.getText().trim();
				String Telephone = stafftel.getText().trim();
				
				if(LID.equals("")) {
					
					JOptionPane.showMessageDialog(null, "Your Student ID cannot be empty");
					
				}
				if(Name.equals("")) 
				{
					JOptionPane.showMessageDialog(null, "Please Enter Your Name");
				}
				if(Username.equals("")) 
				{
					JOptionPane.showMessageDialog(null, "Your username cannot be empty");
				}

				if(Position.equals("")) 
				{
					JOptionPane.showMessageDialog(null, "Your Course cannot be empty");
				}
				if(Telephone.equals("")) 
				{
					JOptionPane.showMessageDialog(null, "Please enter your contact number");
				}
				if(Password.equals("")||Password.length()<8) 
				{
					JOptionPane.showMessageDialog(null, "Your password must be longer than 8 character");
				}
				if(Password.length()>=8) 
				{
				
				Lecturer lec = new Lecturer();
				lec.setLID(staffid.getText().trim());
				lec.setName(stafffullname.getText().trim());
				lec.setUsername(staffusername.getText().trim());
				lec.setPassword(staffpassword.getText().trim());
				lec.setEmail(staffemail.getText().trim());
				lec.setQuestions((String) comboBox.getSelectedItem());
				lec.setAnswer(staffanswer.getText().trim());
				lec.setPosition(staffposition.getText().trim());
				lec.setTelephone(stafftel.getText().trim());
				lec.setKohout((String)comboBox_1.getSelectedItem());
				//lec.setStatus("0");
				
				try 
				{
				lecturerController lCtrl = new lecturerController();
				lCtrl.insertUser(lec);
				
				JOptionPane.showMessageDialog(null, "Register Success!");
				
				} 
				catch (Exception e2) 
				{
					JOptionPane.showMessageDialog(null, "Please Register Again/ You Already Registered");
				}
				}
			}
		});
		btnLecturer.setForeground(Color.WHITE);
		btnLecturer.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		btnLecturer.setBackground(new Color(0, 153, 153));
		

		//btnLecturer.setEnabled(false);
		
		JLabel label_9 = new JLabel("Already a member");
		label_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				label_9.setForeground(new Color(204, 0, 51));
				dispose();
				Login login = new Login();
				login.setVisible(true);

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				label_9.setForeground(new Color(204, 0, 51));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label_9.setForeground(new Color(245, 245, 245));
			}
		});
		label_9.setForeground(new Color(245, 245, 245));
		label_9.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		label_9.setBackground(Color.RED);
		label_9.setBounds(237, 405, 147, 44);
		panel_2.add(label_9);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		comboBox_1.setBounds(380, 335, 314, 36);
		panel_2.add(comboBox_1);
		
		JLabel lblSemester = new JLabel("Semester:");
		lblSemester.setForeground(Color.WHITE);
		lblSemester.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		lblSemester.setBounds(380, 296, 136, 44);
		panel_2.add(lblSemester);
		
		comboBox = new JComboBox();
		comboBox.setBounds(27, 267, 314, 36);
		panel_2.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"What is your pet name?", "What is your nickname?", "Who was your favorite singer/band?", "Who was your favorite film star?"}));
		comboBox.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		
		JLabel label_5 = new JLabel("Security Question");
		label_5.setBounds(27, 228, 136, 44);
		panel_2.add(label_5);
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		
		fillComboBox();
		
		setResizable(false);
		setLocationRelativeTo(null);
		//setUndecorated(true);
	}
	
	public void fillComboBox() 
	{
		try {
			
			//String query = "Select * from Lecturer_Registered Where Status='0' ";
			String query = "Select * from Kohout where Status=1";
			//String query = "Select * from Lecturer_Registered ";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs =pst.executeQuery();
			
			while(rs.next()) 
			{
				comboBox_1.addItem(rs.getString("Kohout"));
				comboBox_2.addItem(rs.getString("Kohout"));
			}
			
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

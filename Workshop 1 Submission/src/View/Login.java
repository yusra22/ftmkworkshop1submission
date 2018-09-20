package View;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.border.EmptyBorder;
import Database2.Mysql;
import Model.Admin;
import Model.Lecturer;
import Model.Student;

import java.sql.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import Controller.adminController;
import Controller.lecturerController;
import Controller.studentController;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		
		//JTattoo Design
        // select Look and Feel
        UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
        //UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        
        
             
		EventQueue.invokeLater(new Runnable() {
			public Login frame;
			
			public void run() {
				try {
					frame = new Login();
					frame.setVisible(true);
					
					Login window = new Login();
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
	private JTextField usernameField;
	private JPasswordField passwordField;
	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("WORKSHOP I: SUBMISSION & AUTO REPORT SYSTEM SUBMISSION");
		
		connection = Mysql.dbConnector();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1056, 549);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBorder(new LineBorder(new Color(0, 206, 209), 6));
		panel.setBounds(12, 24, 1014, 464);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton button = new JButton("Login");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Student student = new Student();
				student.setUsername(usernameField.getText().trim());
				student.setPassword(passwordField.getText().trim());
				
				studentController sCtrl = new studentController();
				int count = 0;
				
				Lecturer lec = new Lecturer();
				lec.setUsername(usernameField.getText().trim());
				lec.setPassword(passwordField.getText().trim());
				
				lecturerController lCtrl = new lecturerController();
				int count1 = 0;
				
				Admin admin = new Admin();
				admin.setUsername(usernameField.getText().trim());
				admin.setPassword(passwordField.getText().trim());
				
				adminController aCtrl = new adminController();
				int count2 = 0;
				
				try 
				{
					count = sCtrl.doLogin(student);
					count1 = lCtrl.doLogin(lec);
					count2 = aCtrl.doLogin(admin);
					
					if (count == 1) 
					{
						
						JOptionPane.showMessageDialog(null, "Username and Password is Correct");
						
						String user = usernameField.getText();
						Student_Main studentmenu = new Student_Main();
						studentmenu.lblYourName.setText(user);
						studentmenu.setVisible(true);
						dispose();
						
					}
					if (count1 == 1) 
					{
						
						JOptionPane.showMessageDialog(null, "Username and Password is Correct");
						
						String user = usernameField.getText();
						Lecturer_Main lecmenu = new Lecturer_Main();
						lecmenu.lblYourName.setText(user);
						lecmenu.setVisible(true);
						dispose();
						
					}
					else if (count2 == 1) 
					{
						
						JOptionPane.showMessageDialog(null, "Username and Password is Correct");
						
						Student_Search1 serh = new Student_Search1();
						serh.setVisible(true);
						dispose();
						
					}
					else if (count > 1) 
					{
						JOptionPane.showMessageDialog(null, "Duplicate Username and Password");
					}
					else if (count1 > 1) 
					{
						JOptionPane.showMessageDialog(null, "Duplicate Username and Password");
					}
					else if (count2 > 1) 
					{
						JOptionPane.showMessageDialog(null, "Duplicate Username and Password");
					}
					else if (count != 1)
					{
						
						JOptionPane.showMessageDialog(null, "Please try again");
					}
					
				} catch (Exception e) 
				{
					JOptionPane.showMessageDialog(null, e);
				}
				
/*				Lecturer lec = new Lecturer();
				lec.setUsername(usernameField.getText().trim());
				lec.setPassword(passwordField.getText().trim());
				
				lecturerController lCtrl = new lecturerController();
				int count1 = 0;*/
/*				try 
				{
					count1 = lCtrl.doLogin(lec);
					
					if (count1 == 1) 
					{
						
						JOptionPane.showMessageDialog(null, "Username and Password is Correct");
						
						String user = usernameField.getText();
						Lecturer_Main lecmenu = new Lecturer_Main();
						lecmenu.lblYourName.setText(user);
						lecmenu.setVisible(true);
						dispose();
						
					}
					else if (count1 > 1) 
					{
						JOptionPane.showMessageDialog(null, "Duplicate Username and Password");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Please try again");
					}
					
				} catch (Exception e) 
				{
					JOptionPane.showMessageDialog(null, e);
				}*/
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Arial Narrow", Font.PLAIN, 23));
		button.setBackground(new Color(0, 153, 153));
		button.setBounds(542, 300, 158, 47);
		panel.add(button);
		
		JLabel lblForgot = new JLabel("Forgot Password?");
		lblForgot.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				lblForgot.setForeground(new Color(204, 0, 51));
				Forgot_Password forgot = new Forgot_Password();
				forgot.setVisible(true);
				dispose();
				
				
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
				lblForgot.setForeground(new Color(204, 0, 51));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				
				lblForgot.setForeground(new Color(245, 245, 245));
			}
		});
		lblForgot.setForeground(new Color(245, 245, 245));
		lblForgot.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		lblForgot.setBackground(Color.RED);
		lblForgot.setBounds(666, 373, 133, 44);
		panel.add(lblForgot);
		
		JButton button_1 = new JButton("Register");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Register register = new Register();
				register.setVisible(true);
				dispose();
				
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Arial Narrow", Font.PLAIN, 23));
		button_1.setBackground(new Color(204, 0, 51));
		button_1.setBounds(745, 300, 158, 47);
		panel.add(button_1);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Arial Narrow", Font.PLAIN, 25));
		passwordField.setBounds(662, 222, 179, 31);
		panel.add(passwordField);
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("Arial Narrow", Font.PLAIN, 23));
		usernameField.setBounds(662, 155, 179, 31);
		panel.add(usernameField);
		usernameField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Arial Narrow", Font.PLAIN, 23));
		lblPassword.setBounds(542, 215, 95, 47);
		panel.add(lblPassword);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Arial Narrow", Font.PLAIN, 23));
		lblUsername.setBounds(542, 143, 95, 47);
		panel.add(lblUsername);
		
		JLabel lblImage = new JLabel("");
		lblImage.setBounds(96, 89, 322, 328);
		panel.add(lblImage);
		lblImage.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/rsz_3logo2.png")).getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH)));
		
		JLabel label_1 = new JLabel("WELCOME TO WORKSHOP I: SUBMISSION AND AUTO REPORT SYSTEM");
		label_1.setBounds(136, 29, 736, 47);
		panel.add(label_1);
		label_1.setForeground(new Color(245, 245, 245));
		label_1.setFont(new Font("Arial Narrow", Font.PLAIN, 26));
		
		JLabel label = new JLabel("");
		label.setBounds(12, 13, 990, 438);
		panel.add(label);
		label.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/blur1.jpg")).getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH)));
		
		
		JLabel labelbackground = new JLabel("");
		labelbackground.setBounds(0, 0, 1048, 526);
		contentPane.add(labelbackground);
		labelbackground.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/blur1.jpg")).getImage().getScaledInstance(labelbackground.getWidth(), labelbackground.getHeight(), Image.SCALE_SMOOTH)));
		
		setResizable(false);
		setLocationRelativeTo(null);
		setIcon();
		
	}
	
	private void setIcon() 
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/FTMK logo.png")));
	}
	
}

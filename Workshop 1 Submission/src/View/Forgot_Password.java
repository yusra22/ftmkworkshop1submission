package View;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import Database2.Mysql;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.awt.event.ActionEvent;
import sun.audio.*;
import java.io.*;

public class Forgot_Password extends JFrame {

	private JPanel contentPane;
	private JTextField usernametextField;
	private JTextField fullnameTextField;
	private JTextField answertextField;
	private JTextField passwordTextField;
	private JTextField questiontextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		//JTattoo Design
        try {
            // select Look and Feel
             UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
            // start application
            new Forgot_Password();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					
					
					Forgot_Password frame = new Forgot_Password();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					
					
					
					//Set GUI Middle
					Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
					int height = screenSize.height;
					int width = screenSize.width;
					frame.setLocation(screenSize.width/2-frame.getSize().width/2, screenSize.height/2-frame.getSize().height/2);
					
					
					
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
	public Forgot_Password() {
		
		connection=Mysql.dbConnector();
		
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 998, 643);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 360, 612);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblForgotYourPassword = new JLabel("CHANGE YOUR");
		lblForgotYourPassword.setBackground(Color.LIGHT_GRAY);
		lblForgotYourPassword.setBounds(103, 446, 133, 44);
		panel.add(lblForgotYourPassword);
		lblForgotYourPassword.setForeground(Color.DARK_GRAY);
		lblForgotYourPassword.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		
		JLabel lblYour = new JLabel("PASSWORD NOW!");
		lblYour.setBackground(Color.LIGHT_GRAY);
		lblYour.setBounds(90, 474, 146, 44);
		panel.add(lblYour);
		lblYour.setHorizontalAlignment(SwingConstants.LEFT);
		lblYour.setForeground(Color.DARK_GRAY);
		lblYour.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		Image registerlogo = new ImageIcon(this.getClass().getResource("/setting5.gif")).getImage();
		
		JLabel lblForgotYourPassword_1 = new JLabel("FORGOT YOUR PASSWORD ?");
		lblForgotYourPassword_1.setForeground(Color.DARK_GRAY);
		lblForgotYourPassword_1.setFont(new Font("Arial Narrow", Font.BOLD, 23));
		lblForgotYourPassword_1.setBackground(Color.LIGHT_GRAY);
		lblForgotYourPassword_1.setBounds(39, 60, 280, 44);
		panel.add(lblForgotYourPassword_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBackground(new Color(255, 99, 71));
		panel_1.setBounds(39, 136, 255, 283);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel forgotlabel = new JLabel("");
		forgotlabel.setBounds(0, 0, 269, 283);
		panel_1.add(forgotlabel);
		forgotlabel.setBackground(new Color(72, 209, 204));
		forgotlabel.setIcon(new ImageIcon(registerlogo));
		
		JLabel lblNewLabel = new JLabel("Security");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 25));
		lblNewLabel.setForeground(new Color(245, 245, 245));
		lblNewLabel.setBounds(0, 0, 255, 48);
		panel_1.add(lblNewLabel);
		
		JLabel lblIsImportant = new JLabel("Is Important");
		lblIsImportant.setHorizontalAlignment(SwingConstants.CENTER);
		lblIsImportant.setForeground(new Color(245, 245, 245));
		lblIsImportant.setFont(new Font("Arial Narrow", Font.BOLD, 25));
		lblIsImportant.setBounds(0, 235, 255, 48);
		panel_1.add(lblIsImportant);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(new Color(245, 245, 245));
		lblUsername.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		lblUsername.setBounds(436, 50, 82, 44);
		contentPane.add(lblUsername);
		
		usernametextField = new JTextField();
		usernametextField.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		usernametextField.setColumns(20);
		usernametextField.setBounds(435, 89, 314, 36);
		contentPane.add(usernametextField);
		
		fullnameTextField = new JTextField();
		fullnameTextField.setEditable(false);
		fullnameTextField.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		fullnameTextField.setColumns(20);
		fullnameTextField.setBounds(436, 177, 314, 36);
		contentPane.add(fullnameTextField);
		
		JLabel lblFullName = new JLabel("Full Name");
		lblFullName.setForeground(new Color(245, 245, 245));
		lblFullName.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		lblFullName.setBounds(437, 138, 82, 44);
		contentPane.add(lblFullName);
		
		JLabel lblQuestion = new JLabel("Your Question");
		lblQuestion.setForeground(new Color(245, 245, 245));
		lblQuestion.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		lblQuestion.setBounds(437, 226, 118, 44);
		contentPane.add(lblQuestion);
		
		JLabel lblAnswer = new JLabel("Answer");
		lblAnswer.setForeground(new Color(245, 245, 245));
		lblAnswer.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		lblAnswer.setBounds(437, 314, 82, 44);
		contentPane.add(lblAnswer);
		
		answertextField = new JTextField();
		answertextField.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		answertextField.setColumns(20);
		answertextField.setBounds(436, 353, 314, 36);
		contentPane.add(answertextField);
		
		JLabel lblChangeYourPassword = new JLabel("PASSWORD RECOVERY");
		lblChangeYourPassword.setForeground(Color.LIGHT_GRAY);
		lblChangeYourPassword.setFont(new Font("Arial Narrow", Font.BOLD, 23));
		lblChangeYourPassword.setBounds(498, 13, 235, 44);
		contentPane.add(lblChangeYourPassword);
		
		JButton btnRecover = new JButton("Recover");
		btnRecover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Recover();
			}
		});
		btnRecover.setForeground(Color.WHITE);
		btnRecover.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		btnRecover.setBackground(new Color(0, 153, 153));
		btnRecover.setBounds(762, 348, 158, 47);
		contentPane.add(btnRecover);
		
		JButton btnMenu = new JButton("Back");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Login login = new Login();
				login.setVisible(true);
				dispose();
				
				
			}
		});
		btnMenu.setForeground(Color.WHITE);
		btnMenu.setFont(new Font("Arial Narrow", Font.PLAIN, 23));
		btnMenu.setBackground(new Color(204, 0, 51));
		btnMenu.setBounds(762, 429, 158, 47);
		contentPane.add(btnMenu);
		
		JLabel lblPassword = new JLabel("Your Password");
		lblPassword.setForeground(new Color(245, 245, 245));
		lblPassword.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		lblPassword.setBounds(437, 397, 118, 44);
		contentPane.add(lblPassword);
		
		passwordTextField = new JTextField();
		passwordTextField.setEditable(false);
		passwordTextField.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		passwordTextField.setColumns(20);
		passwordTextField.setBounds(436, 436, 314, 36);
		contentPane.add(passwordTextField);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Search();
			}
		});
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		btnSearch.setBackground(new Color(153, 50, 204));
		btnSearch.setBounds(761, 84, 158, 47);
		contentPane.add(btnSearch);
		
		questiontextField = new JTextField();
		questiontextField.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		questiontextField.setEditable(false);
		questiontextField.setColumns(20);
		questiontextField.setBounds(435, 265, 314, 36);
		contentPane.add(questiontextField);
		
		//setUndecorated(true);
		setLocationRelativeTo(null);
		setIcon();
	}
	
	public void Search() 
	{
		String a1= usernametextField.getText();
		String query="Select * from Student_Registered where Username='"+a1+"' ";
		String query2="Select * from Lecturer_Registered where Username='"+a1+"' ";

		try 
		{
			PreparedStatement pst= connection.prepareStatement(query);
			ResultSet rs= pst.executeQuery();
			
			PreparedStatement pst2= connection.prepareStatement(query2);
			ResultSet rs2= pst2.executeQuery();
			
			if(rs.next())
			{
				fullnameTextField.setText(rs.getString(3));
				questiontextField.setText(rs.getString(7));

			}
			else if(rs2.next())
			{
				fullnameTextField.setText(rs2.getString(3));
				questiontextField.setText(rs2.getString(7));
			
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "incorrect username");
			}
		} catch (Exception e) 
		{
			JOptionPane.showMessageDialog(null, e);
		}
		
	}
	
	public void Recover() 
	{
		//String a1= questiontextField.getText();
		String a2= answertextField.getText();
		String query="Select * from Student_Registered where Answer='"+a2+"' ";
		String query2="Select * from Lecturer_Registered where Answer='"+a2+"' ";
		
		try 
		{
			PreparedStatement pst= connection.prepareStatement(query);
			ResultSet rs= pst.executeQuery();
			
			PreparedStatement pst2= connection.prepareStatement(query2);
			ResultSet rs2= pst2.executeQuery();
			
			if(rs.next()) 
			{
				passwordTextField.setText(rs.getString(5));
				rs.close();
				pst.close();
			}
			if(rs2.next()) 
			{
				passwordTextField.setText(rs2.getString(5));
				rs2.close();
				pst2.close();
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "Sorry but the answer is wrong");
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

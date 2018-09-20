package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import Controller.documentController;
import Controller.kohoutController;
import Controller.projectController;
import Controller.studentController;
import Database2.Mysql;
import Model.Document;
import Model.Kohout;
import Model.Project;
import Model.Student;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Kahout extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldSem;
	private JLabel lblKohout;
	public static JComboBox comboBox;

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
					Kahout frame = new Kahout();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection = null;
	private JButton btnActive;
	private JButton btnBack;

	/**
	 * Create the frame.
	 */
	public Kahout() {
		
		connection=Mysql.dbConnector();
		
		setBackground(new Color(0, 0, 0));
		setTitle("Kahout");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 558);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(250, 235, 215));
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Enter Semester to Register");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		label.setBounds(137, 56, 214, 47);
		contentPane.add(label);
		
		textFieldSem = new JTextField();
		textFieldSem.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		textFieldSem.setColumns(10);
		textFieldSem.setBounds(137, 105, 214, 29);
		contentPane.add(textFieldSem);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Kohout kohout = new Kohout();
				kohout.setKohout(textFieldSem.getText().trim());
				kohout.setStatus("0");
				
				try 
				{
				kohoutController kCtrl = new kohoutController();
				kCtrl.insertUser(kohout);
				
				JOptionPane.showMessageDialog(null, "You Are Registered");
				
				} 
				catch (Exception e) 
				{
					JOptionPane.showMessageDialog(null, "Please Register Again/ You Already Registered");
				}
			}
		});
		btnRegister.setForeground(Color.WHITE);
		btnRegister.setFont(new Font("Arial Narrow", Font.PLAIN, 23));
		btnRegister.setBackground(new Color(0, 153, 153));
		btnRegister.setBounds(164, 147, 158, 47);
		contentPane.add(btnRegister);
		
		lblKohout = new JLabel("Kohout:");
		lblKohout.setForeground(Color.WHITE);
		lblKohout.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		lblKohout.setBounds(69, 260, 64, 47);
		contentPane.add(lblKohout);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		comboBox.setBounds(155, 268, 179, 31);
		contentPane.add(comboBox);
		
		btnActive = new JButton("Activate");
		btnActive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Kohout kohout = new Kohout();
				kohout.setStatus("1");
				
				try 
				{
					kohoutController kCtrl = new kohoutController();
					kCtrl.assignInsert(kohout);
					
					JOptionPane.showMessageDialog(null, "Update Success!");
					
				} catch (Exception e) 
				{
					JOptionPane.showMessageDialog(null, "Update Error");
				}
				
			}
		});
		btnActive.setForeground(Color.WHITE);
		btnActive.setFont(new Font("Arial Narrow", Font.PLAIN, 23));
		btnActive.setBackground(new Color(0, 153, 153));
		btnActive.setBounds(45, 357, 158, 47);
		contentPane.add(btnActive);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Student_Search1 stud = new Student_Search1();
				stud.setVisible(true);
				dispose();
				
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Arial Narrow", Font.PLAIN, 23));
		btnBack.setBackground(new Color(255, 140, 0));
		btnBack.setBounds(164, 440, 158, 47);
		contentPane.add(btnBack);
		
		JButton btnDiactive = new JButton("Diactive");
		btnDiactive.setForeground(Color.WHITE);
		btnDiactive.setFont(new Font("Arial Narrow", Font.PLAIN, 23));
		btnDiactive.setBackground(new Color(204, 0, 51));
		btnDiactive.setBounds(269, 357, 158, 47);
		contentPane.add(btnDiactive);
		
		fillComboBox();
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	public void fillComboBox() 
	{
		try {
			
			//String query = "Select * from Lecturer_Registered Where Status='0' ";
			String query = "Select * from Kohout";
			//String query = "Select * from Lecturer_Registered ";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs =pst.executeQuery();
			
			while(rs.next()) 
			{
				comboBox.addItem(rs.getString("Kohout"));
			}
			
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

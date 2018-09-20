package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Image;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.event.AncestorListener;

import Controller.lecturerController;
import Controller.studentController;
import Database2.Mysql;
import Model.Lecturer;
import Model.Student;

import javax.swing.event.AncestorEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import com.bolivia.label.CLabel;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import sun.audio.*;

public class Lecturer_Main extends JFrame {

	private JPanel contentPane;
	public static JLabel lblYourName = new JLabel("Urname");
	public JLabel lblClock = new JLabel("Clock");
	public JLabel lblDate = new JLabel("Date");

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
					Lecturer_Main frame = new Lecturer_Main();
					frame.setVisible(true);
					frame.setResizable(false);
					
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
	public Lecturer_Main() {
		connection=Mysql.dbConnector();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1160, 810);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 255));
		contentPane.setBackground(new Color(0, 0, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(new Color(30, 144, 255));
		panel.setBackground(new Color(220, 220, 220));
		panel.setBounds(0, 0, 1172, 801);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.controlDkShadow);
		panel_1.setBounds(0, 151, 1160, 10);
		panel.add(panel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setForeground(Color.DARK_GRAY);
		panel_3.setBorder(new LineBorder(new Color(128, 128, 128), 12));
		panel_3.setBackground(Color.DARK_GRAY);
		panel_3.setBounds(312, 217, 544, 426);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnStudent =    new JButton("PROFILE");
		btnStudent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
			    try {
			    	
			        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\Yusara\\eclipse-workspace\\Workshop 1 Submission\\Resources\\Cloud Click.wav"));
			        Clip clip = AudioSystem.getClip();
			        clip.open(audioInputStream);
			        clip.start();
			    } catch(Exception ex) {
			        System.out.println("Error with playing sound.");
			        ex.printStackTrace();
			    }
				
			}
		});
		btnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String user = lblYourName.getText();
				ProfileLec lec = new ProfileLec();
				lec.textFieldID.setText(user);
				lec.setVisible(true);
				dispose();
				
			}
		});
		btnStudent.setBounds(26, 34, 243, 168);
		panel_3.add(btnStudent);
		btnStudent.setForeground(new Color(255, 255, 255));
		Image img1 = new ImageIcon(this.getClass().getResource("/lecturerlog.png")).getImage();
		btnStudent.setIcon(new ImageIcon(img1));
		btnStudent.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		btnStudent.setBackground(new Color(0, 0, 0));
		Image img3 = new ImageIcon(this.getClass().getResource("/search.png")).getImage();
		
		JButton btnMyStudent = new JButton("MY STUD");
		btnMyStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String user = lblYourName.getText();
				MyStudent_Search1 search = new MyStudent_Search1();
				search.lblID.setText(user);
				search.setVisible(true);
				dispose();
				
			}
		});
		btnMyStudent.setForeground(new Color(255, 255, 255));
		Image img4 = new ImageIcon(this.getClass().getResource("/studentlog.png")).getImage();
		btnMyStudent.setIcon(new ImageIcon(img4));
		btnMyStudent.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		btnMyStudent.setBackground(new Color(0, 0, 0));
		btnMyStudent.setBounds(281, 34, 243, 168);
		panel_3.add(btnMyStudent);
		Image img5 = new ImageIcon(this.getClass().getResource("/statistic.png")).getImage();
		
		JButton btnAbout = new JButton("ABOUT");
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String user = lblYourName.getText();
				AboutLec abt = new AboutLec();
				abt.label.setText(user);
				abt.setVisible(true);
				dispose();
			}
		});
		btnAbout.setForeground(new Color(255, 255, 255));
		Image img6 = new ImageIcon(this.getClass().getResource("/about.png")).getImage();
		btnAbout.setIcon(new ImageIcon(img6));
		btnAbout.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		btnAbout.setBackground(new Color(0, 0, 0));
		btnAbout.setBounds(26, 228, 243, 168);
		panel_3.add(btnAbout);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login login = new Login();
				login.setVisible(true);
				
			}
		});
		btnLogout.setForeground(new Color(255, 255, 255));
		Image img7 = new ImageIcon(this.getClass().getResource("/logout.png")).getImage();
		btnLogout.setIcon(new ImageIcon(img7));
		btnLogout.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		btnLogout.setBackground(new Color(0, 0, 0));
		btnLogout.setBounds(281, 228, 243, 168);
		panel_3.add(btnLogout);
		
		JLabel labelBackground2 = new JLabel("");
		labelBackground2.setBounds(0, 13, 560, 400);
		panel_3.add(labelBackground2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.controlDkShadow);
		panel_2.setBounds(0, 691, 1160, 10);
		panel.add(panel_2);
		
		JLabel lblWelcome = new JLabel("Hello & Welcome");
		lblWelcome.setForeground(Color.WHITE);
		lblWelcome.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblWelcome.setBounds(90, 174, 137, 36);
		panel.add(lblWelcome);
		
		JLabel lblWorkshopIAuto = new JLabel("Workshop I: Auto Reporting System");
		lblWorkshopIAuto.setForeground(Color.WHITE);
		lblWorkshopIAuto.setFont(new Font("Arial Narrow", Font.ITALIC, 30));
		lblWorkshopIAuto.setBounds(397, 88, 394, 36);
		panel.add(lblWorkshopIAuto);
		lblYourName.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
				
				Lecturer lec = new Lecturer();
				lec.setName(lblYourName.getText().trim());
				
				try 
				{
				lecturerController lCtrl = new lecturerController();
				lCtrl.selectNameLec(lec);
				
				//JOptionPane.showMessageDialog(null, "Success");
				
				} 
				catch (Exception e) 
				{
					JOptionPane.showMessageDialog(null, "Fail");
				}
				
			}
			public void ancestorMoved(AncestorEvent arg0) {
			}
			public void ancestorRemoved(AncestorEvent arg0) {
			}
		});
		
		//JLabel lblYourName = new JLabel("Urname");
		
		lblYourName.setText("Urname");
		lblYourName.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourName.setForeground(Color.WHITE);
		lblYourName.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		lblYourName.setBounds(12, 203, 288, 36);
		panel.add(lblYourName);
		
		JLabel lblFTMK = new JLabel("New label");
		lblFTMK.setBounds(-79, -43, 464, 269);
		lblFTMK.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/utemnoob2.png")).getImage().getScaledInstance(lblFTMK.getWidth(), lblFTMK.getHeight(), Image.SCALE_SMOOTH)));
		panel.add(lblFTMK);
		
		JLabel lblUniverstiTeknikalMalaysia = new JLabel("UNIVERSITI TEKNIKAL MALAYSIA MELAKA");
		lblUniverstiTeknikalMalaysia.setForeground(Color.WHITE);
		lblUniverstiTeknikalMalaysia.setFont(new Font("Arial Narrow", Font.BOLD, 30));
		lblUniverstiTeknikalMalaysia.setBounds(330, 39, 526, 36);
		panel.add(lblUniverstiTeknikalMalaysia);
		
		JLabel label_7 = new JLabel("Copyright 2018, FTMK. All rights reserved.");
		label_7.setForeground(Color.LIGHT_GRAY);
		label_7.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		label_7.setBounds(787, 718, 328, 36);
		panel.add(label_7);
		
		lblDate = new JLabel("Date");
		lblDate.setForeground(Color.LIGHT_GRAY);
		lblDate.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblDate.setBounds(199, 714, 143, 36);
		panel.add(lblDate);
		
		lblClock = new JLabel("Clock");
		lblClock.setForeground(Color.LIGHT_GRAY);
		lblClock.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblClock.setBounds(12, 714, 143, 36);
		panel.add(lblClock);
		
		JLabel lblMyStudent = new JLabel("Student Assign:");
		lblMyStudent.setForeground(Color.WHITE);
		lblMyStudent.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblMyStudent.setBounds(33, 249, 137, 36);
		panel.add(lblMyStudent);
		
		JLabel lblTotalNumberOf = new JLabel("Total Number of Student:");
		lblTotalNumberOf.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotalNumberOf.setForeground(Color.WHITE);
		lblTotalNumberOf.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		lblTotalNumberOf.setBounds(34, 287, 194, 36);
		panel.add(lblTotalNumberOf);
		
		JLabel lblTotal = new JLabel("0");
		lblTotal.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
				
				String a1= lblYourName.getText();
				String query = "Select Count(id) AS LID2 FROM Student_Registered WHERE LID LIKE '"+a1+"%'";
				//String query = "Select Count(Proposal) AS LID2 FROM Document WHERE LID LIKE '"+a1+"%'";
				
				try {
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					
					if(rs.next()) 
					{
						String sum = rs.getString("LID2");
						lblTotal.setText(sum);
						System.out.println(sum);
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				
			}
			public void ancestorMoved(AncestorEvent arg0) {
			}
			public void ancestorRemoved(AncestorEvent arg0) {
			}
		});
		lblTotal.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotal.setForeground(Color.WHITE);
		lblTotal.setFont(new Font("Arial Narrow", Font.ITALIC, 20));
		lblTotal.setBounds(227, 287, 59, 36);
		panel.add(lblTotal);
		
		JLabel labelBackground = new JLabel("");
		labelBackground.setBounds(0, 0, 1156, 812);
		labelBackground.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/blur1.jpg")).getImage().getScaledInstance(labelBackground.getWidth(), labelBackground.getHeight(), Image.SCALE_SMOOTH)));
		panel.add(labelBackground);
		
		clock();
		
		setResizable(false);
		setLocationRelativeTo(null);
		//setUndecorated(true);
		setIcon();
	}
	
	
	public void clock() 
	{
		Thread clock = new Thread()
		{
			public void run() 
			{
				try {
					
					for(;;) 
					{
					
					Calendar cal = new GregorianCalendar();
					int day=cal.get(Calendar.DAY_OF_MONTH);
					int month=cal.get(Calendar.MONTH)+1;
					int year=cal.get(Calendar.YEAR);
					
					int am_pm= cal.get(Calendar.AM_PM);
					int second=cal.get(Calendar.SECOND);
					int minutes=cal.get(Calendar.MINUTE);
					int hour=cal.get(Calendar.HOUR);
					
					String day_night = "";
					
					
					if(am_pm == 1) 
					{
						day_night = "PM";
					}
					else 
					{
						day_night = "AM";
					}
					
					lblClock.setText("Time: "+ hour +":"+ minutes +":"+ second + " " + day_night); 
					lblDate.setText(" Date: " + year +"/"+ month + "/" + day);
					
					sleep(1000);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		clock.start();
	}
	
	private void setIcon() 
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/FTMK logo.png")));
	}
}

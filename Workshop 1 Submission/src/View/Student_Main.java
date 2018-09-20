package View;
import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.event.AncestorListener;

import com.mysql.jdbc.Util;

import Controller.studentController;
import Database2.Mysql;
import Model.Student;

import javax.swing.event.AncestorEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.bolivia.label.CLabel;

public class Student_Main extends JFrame {

	private JPanel contentPane;
	public JPanel panelFullMenu = new JPanel();
	String luser;
	public static JLabel lblYourName = new JLabel();
	public JLabel lblstatus = new JLabel("");
	public JLabel lblClock = new JLabel("Clock");
	public JLabel lblDate = new JLabel("Date");
	public CLabel lblClabel = new CLabel();
	private ImageIcon format = null;
	public JPanel panel_4;
	public JPanel panel_5;
	public JPanel panel_6;

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
					Student_Main frame = new Student_Main();
					frame.setLocationRelativeTo(null);
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
	

	/**
	 * Create the frame.
	 */
	public Student_Main() {
		setTitle("Student Menu");
	
		connection=Mysql.dbConnector();
		
		setForeground(new Color(0, 0, 0));
		setBackground(new Color(0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1160, 810);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		
		JPanel panelMenu = new JPanel();
		panelMenu.setBounds(-260, 0, 260, 801);
		panelMenu.setBackground(Color.DARK_GRAY);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		JButton btnMenuToggle = new JButton("");
		btnMenuToggle.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		btnMenuToggle.setBounds(0, 0, 65, 54);
		btnMenuToggle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

				
				int position = btnMenuToggle.getX();
				if(position > 5) 
				{
					Animacion.Animacion.mover_izquierda(211, 5, 2, 2,btnMenuToggle);
					Animacion.Animacion.mover_izquierda(5, -260, 2, 2,panelMenu);
					//Animacion.Animacion.mover_izquierda(5, 5, 2, 2,panelFullMenu);
					Image toggle = new ImageIcon(this.getClass().getResource("/toggle.png")).getImage();
					btnMenuToggle.setIcon(new ImageIcon(toggle));
					
				}
				else 
				{
					Animacion.Animacion.mover_derecha(5, 261, 2, 2,btnMenuToggle);
					Animacion.Animacion.mover_derecha(-200, 0, 2, 2,panelMenu);
					//Animacion.Animacion.mover_derecha(5, 172, 2, 2,panelFullMenu);
					Image toggle = new ImageIcon(this.getClass().getResource("/toggle3.png")).getImage();
					btnMenuToggle.setIcon(new ImageIcon(toggle));
				}
				
			}
		});
		Image toggle = new ImageIcon(this.getClass().getResource("/toggle.png")).getImage();
		btnMenuToggle.setIcon(new ImageIcon(toggle));
		btnMenuToggle.setBackground(new Color(0, 0, 0));
		btnMenuToggle.setForeground(new Color(0, 0, 0));
		contentPane.add(btnMenuToggle);
		
		JPanel panelFullMenu = new JPanel();
		panelFullMenu.setForeground(new Color(30, 144, 255));
		panelFullMenu.setLayout(null);
		
		panelFullMenu.setBackground(new Color(220, 220, 220));
		//panelFullMenu.setOpaque(false);
		panelFullMenu.setBounds(0, 0, 1172, 801);
		contentPane.add(panelFullMenu);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(105, 105, 105));
		panel.setBounds(0, 151, 1160, 10);
		panelFullMenu.add(panel);
		Image img1 = new ImageIcon(this.getClass().getResource("/proposal.png")).getImage();
		Image img2 = new ImageIcon(this.getClass().getResource("/analysis.png")).getImage();
		Image img3 = new ImageIcon(this.getClass().getResource("/design.png")).getImage();
		Image img4 = new ImageIcon(this.getClass().getResource("/report2.png")).getImage();
		Image img5 = new ImageIcon(this.getClass().getResource("/about.png")).getImage();
		Image img6 = new ImageIcon(this.getClass().getResource("/logout.png")).getImage();
		
		JLabel label = new JLabel("Workshop I: Auto Reporting System");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Arial Narrow", Font.ITALIC, 30));
		label.setBounds(384, 88, 394, 36);
		panelFullMenu.add(label);
		
		JLabel label_1 = new JLabel("UNIVERSITI TEKNIKAL MALAYSIA MELAKA");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Arial Narrow", Font.BOLD, 30));
		label_1.setBounds(317, 39, 526, 36);
		panelFullMenu.add(label_1);
		
		JLabel label_2 = new JLabel("New label");
		label_2.setBounds(775, -38, 464, 269);
		label_2.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/utemnoob2.png")).getImage().getScaledInstance(label_2.getWidth(), label_2.getHeight(), Image.SCALE_SMOOTH)));
		panelFullMenu.add(label_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setForeground(Color.DARK_GRAY);
		panel_3.setBorder(new LineBorder(new Color(128, 128, 128), 12));
		panel_3.setBackground(Color.DARK_GRAY);
		panel_3.setBounds(312, 211, 803, 426);
		panelFullMenu.add(panel_3);
		
		JButton btnProposal = new JButton("PROPOSAL");
		btnProposal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String user = lblYourName.getText();
				UploadProposal proposal = new UploadProposal();
				UploadProposal.lblCardMatrik.setText(user);
				proposal.setVisible(true);
				dispose();
			}
		});
		btnProposal.setForeground(Color.WHITE);
		btnProposal.setIcon(new ImageIcon(img1));
		btnProposal.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		btnProposal.setBackground(Color.BLACK);
		btnProposal.setBounds(26, 34, 243, 168);
		panel_3.add(btnProposal);
		
		JButton btnAnalysis = new JButton("ANALYSIS");
		btnAnalysis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String user = lblYourName.getText();
				UploadAnalysis analysis = new UploadAnalysis();
				UploadAnalysis.lblCardMatrik.setText(user);
				analysis.setVisible(true);
				dispose();
				
			}
		});
		btnAnalysis.setForeground(Color.WHITE);
		btnAnalysis.setIcon(new ImageIcon(img2));
		btnAnalysis.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		btnAnalysis.setBackground(Color.BLACK);
		btnAnalysis.setBounds(281, 34, 243, 168);
		panel_3.add(btnAnalysis);
		
		JButton btnDesign = new JButton("DESIGN");
		btnDesign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String user = lblYourName.getText();
				UploadDesign design = new UploadDesign();
				UploadDesign.lblCardMatrik.setText(user);
				design.setVisible(true);
				dispose();
				
			}
		});
		btnDesign.setForeground(Color.WHITE);
		btnDesign.setIcon(new ImageIcon(img3));
		btnDesign.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		btnDesign.setBackground(Color.BLACK);
		btnDesign.setBounds(536, 34, 243, 168);
		panel_3.add(btnDesign);
		
		JButton btnFinalReport = new JButton("REPORT");
		btnFinalReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String user = lblYourName.getText();
				UploadReport report = new UploadReport();
				UploadReport.lblCardMatrik.setText(user);
				report.setVisible(true);
				dispose();
				
			}
		});
		btnFinalReport.setForeground(Color.WHITE);
		btnFinalReport.setIcon(new ImageIcon(img4));
		btnFinalReport.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		btnFinalReport.setBackground(Color.BLACK);
		btnFinalReport.setBounds(26, 228, 243, 168);
		panel_3.add(btnFinalReport);
		
		JButton btnAbout = new JButton("ABOUT");
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String user = lblYourName.getText();
				About abt = new About();
				abt.label.setText(user);
				abt.setVisible(true);
				dispose();
			}
		});
		btnAbout.setForeground(Color.WHITE);
		btnAbout.setIcon(new ImageIcon(img5));
		btnAbout.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		btnAbout.setBackground(Color.BLACK);
		btnAbout.setBounds(281, 228, 243, 168);
		panel_3.add(btnAbout);
		
		JButton btnOut = new JButton("LOGOUT");
		btnOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Login login = new Login();
				login.setVisible(true);
				dispose();
				
			}
		});
		btnOut.setForeground(Color.WHITE);
		btnOut.setIcon(new ImageIcon(img6));
		btnOut.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		btnOut.setBackground(Color.BLACK);
		btnOut.setBounds(536, 228, 243, 168);
		panel_3.add(btnOut);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(0, 13, 791, 400);
		panel_3.add(label_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
				
			}
		});
		panel_2.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
				
				String a1= lblYourName.getText();
				//String query="Select Telephone from StudentInfo where Name='"+a1+"' ";
				String query="Select Proposal,Analysis,Design,Report from Document where SID='"+a1+"' ";
				
				try 
				{
					PreparedStatement pst= connection.prepareStatement(query);
					ResultSet rs= pst.executeQuery();
				
					rs.next() ;
					
					String checkDatabase = rs.getString(1);
					String checkDBA = rs.getString("Analysis");
					String checkDBD = rs.getString("Design");
					String checkDBR = rs.getString("Report");
					//byte[] checkDatabase2 = rs.getBytes(1);
					//System.out.println(rs.getString(1));
					
					
					if(checkDatabase == null)
					{	
						
						//System.out.println("This is null and dont have no value");
					}
					if(checkDatabase != null) 
					{
						panel_2.setBackground(new Color(0, 206, 209));
					}
					if(checkDBA != null) 
					{
						panel_4.setBackground(new Color(0, 206, 209));
					}
					
					if(checkDBD != null) 
					{
						panel_5.setBackground(new Color(0, 206, 209));
					}
					if(checkDBR != null) 
					{
						panel_6.setBackground(new Color(0, 206, 209));
					}
					
					/*else 
					{
						panel_2.setBackground(new Color(0, 206, 209));
						//System.out.println("This has values");
					
					}*/
					rs.close();
					
				} catch (Exception e) 
				{
					JOptionPane.showMessageDialog(null, e);
				}
				
			}
			public void ancestorMoved(AncestorEvent arg0) {
			}
			public void ancestorRemoved(AncestorEvent arg0) {
			}
		});
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_2.setBackground(new Color(178, 34, 34));
		panel_2.setBounds(57, 374, 48, 45);
		panelFullMenu.add(panel_2);
		panel_2.setLayout(null);
		lblstatus.setHorizontalAlignment(SwingConstants.CENTER);
		
		//JLabel lblstatus = new JLabel("");
		lblstatus.setBounds(0, 0, 48, 45);
		panel_2.add(lblstatus);
		
		panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_4.setBackground(new Color(178, 34, 34));
		panel_4.setBounds(57, 432, 48, 45);
		panelFullMenu.add(panel_4);
		
		JLabel label_4 = new JLabel("");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(0, 0, 48, 45);
		panel_4.add(label_4);
		
		panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_5.setBackground(new Color(178, 34, 34));
		panel_5.setBounds(57, 490, 48, 45);
		panelFullMenu.add(panel_5);
		
		JLabel label_6 = new JLabel("");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(0, 0, 48, 45);
		panel_5.add(label_6);
		
		panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_6.setBackground(new Color(178, 34, 34));
		panel_6.setBounds(57, 548, 48, 45);
		panelFullMenu.add(panel_6);
		
		JLabel label_8 = new JLabel("");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setBounds(0, 0, 48, 45);
		panel_6.add(label_8);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_7.setBackground(new Color(0, 206, 209));
		panel_7.setBounds(12, 260, 48, 45);
		panelFullMenu.add(panel_7);
		
		JLabel label_5 = new JLabel("");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(0, 0, 48, 45);
		panel_7.add(label_5);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_8.setBackground(new Color(178, 34, 34));
		panel_8.setBounds(162, 260, 48, 45);
		panelFullMenu.add(panel_8);
		
		JLabel label_7 = new JLabel("");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setBounds(0, 0, 48, 45);
		panel_8.add(label_7);
		
		JLabel lblIncomplete = new JLabel("Incomplete");
		lblIncomplete.setForeground(Color.WHITE);
		lblIncomplete.setFont(new Font("Arial Narrow", Font.PLAIN, 19));
		lblIncomplete.setBackground(Color.WHITE);
		lblIncomplete.setBounds(222, 269, 78, 36);
		panelFullMenu.add(lblIncomplete);
		
		JLabel lblUploaded = new JLabel("Complete");
		lblUploaded.setForeground(Color.WHITE);
		lblUploaded.setFont(new Font("Arial Narrow", Font.PLAIN, 19));
		lblUploaded.setBackground(Color.WHITE);
		lblUploaded.setBounds(72, 269, 78, 36);
		panelFullMenu.add(lblUploaded);
		
		JLabel lblSubmitStatus = new JLabel("Proposal");
		lblSubmitStatus.setBounds(117, 383, 78, 36);
		panelFullMenu.add(lblSubmitStatus);
		lblSubmitStatus.setBackground(Color.WHITE);
		lblSubmitStatus.setForeground(Color.WHITE);
		lblSubmitStatus.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		
		JLabel lblAnalysis = new JLabel("Analysis");
		lblAnalysis.setForeground(Color.WHITE);
		lblAnalysis.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		lblAnalysis.setBackground(Color.WHITE);
		lblAnalysis.setBounds(117, 441, 78, 36);
		panelFullMenu.add(lblAnalysis);
		
		JLabel lblDesign = new JLabel("Design");
		lblDesign.setForeground(Color.WHITE);
		lblDesign.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		lblDesign.setBackground(Color.WHITE);
		lblDesign.setBounds(117, 499, 78, 36);
		panelFullMenu.add(lblDesign);
		
		JLabel lblFinalReport = new JLabel("Final Report");
		lblFinalReport.setForeground(Color.WHITE);
		lblFinalReport.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		lblFinalReport.setBackground(Color.WHITE);
		lblFinalReport.setBounds(117, 557, 97, 36);
		panelFullMenu.add(lblFinalReport);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(105, 105, 105));
		panel_1.setBounds(0, 691, 1160, 10);
		panelFullMenu.add(panel_1);
		
		JLabel lblUploadStatus = new JLabel("Current Status:");
		lblUploadStatus.setForeground(Color.WHITE);
		lblUploadStatus.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblUploadStatus.setBackground(Color.WHITE);
		lblUploadStatus.setBounds(60, 325, 133, 36);
		panelFullMenu.add(lblUploadStatus);
		
		JLabel lblStatusGuide = new JLabel("Status Guide:");
		lblStatusGuide.setForeground(Color.WHITE);
		lblStatusGuide.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblStatusGuide.setBackground(Color.WHITE);
		lblStatusGuide.setBounds(57, 211, 133, 36);
		panelFullMenu.add(lblStatusGuide);
		
		lblClock = new JLabel("Clock");
		lblClock.setForeground(Color.LIGHT_GRAY);
		lblClock.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblClock.setBounds(25, 714, 143, 36);
		panelFullMenu.add(lblClock);
		clock();
		
		lblDate = new JLabel("Date");
		lblDate.setForeground(Color.LIGHT_GRAY);
		lblDate.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblDate.setBounds(212, 714, 143, 36);
		panelFullMenu.add(lblDate);
		
		JLabel lblAbout = new JLabel("Copyright 2018, FTMK. All rights reserved.");
		lblAbout.setForeground(Color.LIGHT_GRAY);
		lblAbout.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblAbout.setBounds(787, 718, 328, 36);
		panelFullMenu.add(lblAbout);
		
		JLabel labelBackground = new JLabel("");
		labelBackground.setBounds(0, 0, 1156, 812);
		labelBackground.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/blur1.jpg")).getImage().getScaledInstance(labelBackground.getWidth(), labelBackground.getHeight(), Image.SCALE_SMOOTH)));
		panelFullMenu.add(labelBackground);
		
		JButton btnNewButton_1 = new JButton("Profile");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String user = lblYourName.getText();
				Profile profile = new Profile();
				profile.textFieldID.setText(user);
				profile.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setForeground(new Color(245, 245, 245));
		btnNewButton_1.setBackground(new Color(0, 153, 153));
		btnNewButton_1.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		btnNewButton_1.setBounds(12, 344, 236, 49);
		panelMenu.add(btnNewButton_1);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setForeground(new Color(245, 245, 245));
		btnLogout.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		btnLogout.setBackground(new Color(204, 0, 51));
		btnLogout.setBounds(12, 468, 236, 49);
		panelMenu.add(btnLogout);
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setForeground(new Color(220, 220, 220));
		lblWelcome.setFont(new Font("Arial Narrow", Font.PLAIN, 25));
		lblWelcome.setBounds(90, 13, 89, 49);
		panelMenu.add(lblWelcome);
		lblYourName.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				callData();
				getImgDB();
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		lblYourName.setText("User");
		
		//JLabel lblYourName = new JLabel("Your Name");
		lblYourName.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourName.setForeground(new Color(220, 220, 220));
		lblYourName.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		lblYourName.setBounds(12, 42, 236, 49);
		panelMenu.add(lblYourName);
		
		JButton buttonProject = new JButton("Project");
		buttonProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String user = lblYourName.getText();
				Student_Project project = new Student_Project();
				project.textFieldID.setText(user);
				project.setVisible(true);
				dispose();
				
			}
		});
		buttonProject.setForeground(new Color(245, 245, 245));
		buttonProject.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		buttonProject.setBackground(new Color(112, 128, 144));
		buttonProject.setBounds(12, 406, 236, 49);
		panelMenu.add(buttonProject);
		
		lblClabel = new CLabel();
		lblClabel.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
			}
			public void ancestorMoved(AncestorEvent arg0) {
			}
			public void ancestorRemoved(AncestorEvent arg0) {
			}
		});
		lblClabel.setLineColor(new Color(0, 191, 255));
		lblClabel.setText("");
		lblClabel.setBounds(22, 104, 211, 216);
		panelMenu.add(lblClabel);
		Image studentlogo = new ImageIcon(this.getClass().getResource("/rsz_ftmk.png")).getImage();
		Image utemlogo = new ImageIcon(this.getClass().getResource("/utem.png")).getImage();
		panelFullMenu.add(labelBackground);
		
		setResizable(false);
		setLocationRelativeTo(null);
		
	}
	
	public void callData() 
	{
		
		Student student = new Student();
		student.setName(lblYourName.getText().trim());
		
		try 
		{
		studentController sCtrl = new studentController();
		sCtrl.selectName(student);
		
		//JOptionPane.showMessageDialog(null, "Success");
		
		} 
		catch (Exception e) 
		{
			JOptionPane.showMessageDialog(null, "Fail");
		}
		
		/*String a1= lblYourName.getText();
		String query="Select * from Student_Registered where Username='"+a1+"' ";

		try 
		{
			PreparedStatement pst= connection.prepareStatement(query);
			ResultSet rs= pst.executeQuery();
			
			if(rs.next())
			{
				lblYourName.setText(rs.getString(3));
				
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
		}*/
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
	
	public void getImgDB() 
	{
		String a1= lblYourName.getText();
		String query="Select * from Student_Registered where SID='"+a1+"' ";
		
		try 
		{
			PreparedStatement pst= connection.prepareStatement(query);
			ResultSet rs= pst.executeQuery();
			
			if(rs.next())
			{
				
				//For Display Image
				byte[] imagedata = rs.getBytes("image");
				format = new ImageIcon(imagedata);
				lblClabel.setIcon(format);
				lblClabel.setIcon(new ImageIcon(new javax.swing.ImageIcon(imagedata).getImage().getScaledInstance(lblClabel.getWidth(), lblClabel.getHeight(), Image.SCALE_SMOOTH)));
				
				rs.close();
				pst.close();
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "Incorrect Username");
			}
		} catch (Exception e2) 
		{
			//JOptionPane.showMessageDialog(null, e2);
		}
	}
}

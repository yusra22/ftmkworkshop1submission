package View;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.border.EmptyBorder;
import Database2.Mysql;
import Model.Student;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.Window;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.SystemColor;

public class MyStudent_Search1 extends JFrame {

	private JPanel contentPane;

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
					MyStudent_Search1 frame = new MyStudent_Search1();
					frame.setVisible(true);
					
					//Set GUI Middle
					Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
					int height = screenSize.height;
					int width = screenSize.width;
					frame.setLocation(screenSize.width/2-frame.getSize().width/2, screenSize.height/2-frame.getSize().height/2);
					
					//Set Maximize Disable
					frame.setResizable(false);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection = null;
	private JLabel labelBackground;
	private JButton btnBack;
	private ImageIcon format = null;
	int s=0;
	byte[] person_image=null;
	JLabel lblID = new JLabel("L1112");
	JLabel lblNewLabel = new JLabel("L1112");
	JButton btnL = new JButton("L1112");
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JLabel lblAvatar1;
	private JLabel lblAvatar2;
	private JLabel lblAvatar3;
	private JLabel lblAvatar4;
	private JLabel lblAvatar5;
	private JLabel label;
	private JLabel lblFTMK;
	private JLabel textAvatar1;
	private JLabel textAvatar2;
	private JLabel textAvatar3;
	private JLabel textAvatar4;
	private JLabel textAvatar5;
	private JPanel panel_8;
	private JLabel label_1;
	private JPanel panel_9;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel lblMyStudentList;
	private JPanel panel_1;
	private JLabel label_6;
	private JPanel panelA1;
	private JLabel label_7;
	private JPanel panelD1;
	private JLabel label_8;
	private JPanel panelR1;
	private JLabel label_9;
	private JLabel label_10;
	private JLabel label_11;
	private JLabel label_12;
	private JLabel label_13;
	private JPanel panelP2;
	private JLabel label_14;
	private JPanel panelA2;
	private JLabel label_15;
	private JPanel panelD2;
	private JLabel label_16;
	private JPanel panelR2;
	private JLabel label_17;
	private JLabel label_18;
	private JLabel label_19;
	private JLabel label_20;
	private JLabel label_21;
	private JPanel panelP3;
	private JLabel label_22;
	private JPanel panelA3;
	private JLabel label_23;
	private JPanel panelD3;
	private JLabel label_24;
	private JPanel panelR3;
	private JLabel label_25;
	private JLabel label_26;
	private JLabel label_27;
	private JLabel label_28;
	private JLabel label_29;
	private JPanel panelP4;
	private JLabel label_30;
	private JPanel panelA4;
	private JLabel label_31;
	private JPanel panelD4;
	private JLabel label_32;
	private JPanel panelR4;
	private JLabel label_33;
	private JLabel label_34;
	private JLabel label_35;
	private JLabel label_36;
	private JLabel label_37;
	private JPanel panelP5;
	private JLabel label_38;
	private JPanel panelA5;
	private JLabel label_39;
	private JPanel panelD5;
	private JLabel label_40;
	private JPanel panelR5;
	private JLabel label_41;
	private JLabel label_42;
	private JLabel label_43;
	private JLabel label_44;
	private JLabel label_45;
	

	/**
	 * Create the frame.
	 */
	public MyStudent_Search1() {
		setTitle("My Student");
		
		connection=Mysql.dbConnector(); 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1411, 783);
		contentPane = new JPanel();
		contentPane.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) 
			{
				
				Animacion.Animacion.mover_derecha(-200, 20, 2, 2,panel_3);
				Animacion.Animacion.mover_derecha(-200, 300, 2, 2,panel_4);
				Animacion.Animacion.mover_derecha(-200, 586, 2, 2,panel_5);
				Animacion.Animacion.mover_derecha(-200, 859, 2, 2,panel_6);
				Animacion.Animacion.mover_derecha(-200, 1131, 2, 2,panel_7);
				

				
				
			}
			public void ancestorMoved(AncestorEvent arg0) {
			}
			public void ancestorRemoved(AncestorEvent arg0) {
			}
		});
		contentPane.setForeground(new Color(50, 205, 50));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);;
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Lecturer_Main lec = new Lecturer_Main();
				lec.setVisible(true);
				String user = lblID.getText();
				lec.lblYourName.setText(user);
				dispose();
				
			}
		});
		btnBack.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		btnBack.setBackground(new Color(204, 0, 51));
		btnBack.setBounds(22, 37, 155, 45);
		contentPane.add(btnBack);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.controlDkShadow);
		panel.setBounds(-1, 109, 1412, 10);
		contentPane.add(panel);
		
		panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.controlDkShadow);
		panel_2.setBounds(-1, 657, 1412, 10);
		contentPane.add(panel_2);
		
		panel_3 = new JPanel();
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String sid = textAvatar1.getText();
				
				MyStudent_Details studProfile = new MyStudent_Details();
				studProfile.setVisible(true);
				studProfile.textFieldID.setText(sid);
				
				String lid = lblID.getText();
				studProfile.lblID.setText(lid);
				dispose();
				
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				
				panel_3.setBackground(new Color(0, 76, 153));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				panel_3.setBackground(new Color(105, 105, 105));
			}
		});
		panel_3.setBorder(new LineBorder(new Color(192, 192, 192), 3));
		panel_3.setBackground(new Color(105, 105, 105));
		panel_3.setBounds(20, 148, 251, 486);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		lblAvatar1 = new JLabel("");
		lblAvatar1.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblAvatar1.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
				
			}
			public void ancestorMoved(AncestorEvent arg0) {
			}
			public void ancestorRemoved(AncestorEvent arg0) {
			}
		});
		lblAvatar1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		lblAvatar1.setBounds(12, 39, 227, 168);
		Image img1 = new ImageIcon(this.getClass().getResource("/avatar1.png")).getImage();
		lblAvatar1.setIcon(new ImageIcon(img1));
		panel_3.add(lblAvatar1);
		
		textAvatar1 = new JLabel("");
		textAvatar1.setHorizontalAlignment(SwingConstants.CENTER);
		textAvatar1.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
								
				String a1= lblID.getText();
				String query = "SELECT * FROM Student_Registered WHERE LID  LIKE '"+a1+"%' LIMIT 1 OFFSET 0 ";
				
				try 
				{	
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs= pst.executeQuery();

					if(rs.next())
					{
						textAvatar1.setText(rs.getString(2));
					}
					
				} catch (Exception e1) 
				{
					//JOptionPane.showMessageDialog(null, e1);
				}
				
				String a2= textAvatar1.getText();
				String query2="Select Proposal,Analysis,Design,Report from Document where SID='"+a2+"' ";
				
				try 
				{
					PreparedStatement pst= connection.prepareStatement(query2);
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
						panel_1.setBackground(new Color(0, 206, 209));
					}
					if(checkDBA != null) 
					{
						panelA1.setBackground(new Color(0, 206, 209));
					}
					
					if(checkDBD != null) 
					{
						panelD1.setBackground(new Color(0, 206, 209));
					}
					if(checkDBR != null) 
					{
						panelR1.setBackground(new Color(0, 206, 209));
					}
					
					/*else 
					{
						panel_2.setBackground(new Color(0, 206, 209));
						//System.out.println("This has values");
					
					}*/
					rs.close();
					
				} catch (Exception e) 
				{
					//JOptionPane.showMessageDialog(null, e);
				}

				
			}
			public void ancestorMoved(AncestorEvent arg0) {
			}
			public void ancestorRemoved(AncestorEvent arg0) {
			}
		});
		textAvatar1.setForeground(Color.WHITE);
		textAvatar1.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		textAvatar1.setBounds(62, 26, 126, 26);
		panel_3.add(textAvatar1);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_1.setBackground(new Color(178, 34, 34));
		panel_1.setBounds(45, 209, 48, 45);
		panel_3.add(panel_1);
		
		label_6 = new JLabel("");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(0, 0, 48, 45);
		panel_1.add(label_6);
		
		panelA1 = new JPanel();
		panelA1.setLayout(null);
		panelA1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panelA1.setBackground(new Color(178, 34, 34));
		panelA1.setBounds(45, 267, 48, 45);
		panel_3.add(panelA1);
		
		label_7 = new JLabel("");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setBounds(0, 0, 48, 45);
		panelA1.add(label_7);
		
		panelD1 = new JPanel();
		panelD1.setLayout(null);
		panelD1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panelD1.setBackground(new Color(178, 34, 34));
		panelD1.setBounds(45, 325, 48, 45);
		panel_3.add(panelD1);
		
		label_8 = new JLabel("");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setBounds(0, 0, 48, 45);
		panelD1.add(label_8);
		
		panelR1 = new JPanel();
		panelR1.setLayout(null);
		panelR1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panelR1.setBackground(new Color(178, 34, 34));
		panelR1.setBounds(45, 383, 48, 45);
		panel_3.add(panelR1);
		
		label_9 = new JLabel("");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setBounds(0, 0, 48, 45);
		panelR1.add(label_9);
		
		label_10 = new JLabel("Proposal");
		label_10.setForeground(Color.WHITE);
		label_10.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		label_10.setBackground(Color.WHITE);
		label_10.setBounds(105, 218, 78, 36);
		panel_3.add(label_10);
		
		label_11 = new JLabel("Analysis");
		label_11.setForeground(Color.WHITE);
		label_11.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		label_11.setBackground(Color.WHITE);
		label_11.setBounds(105, 276, 78, 36);
		panel_3.add(label_11);
		
		label_12 = new JLabel("Design");
		label_12.setForeground(Color.WHITE);
		label_12.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		label_12.setBackground(Color.WHITE);
		label_12.setBounds(105, 334, 78, 36);
		panel_3.add(label_12);
		
		label_13 = new JLabel("Final Report");
		label_13.setForeground(Color.WHITE);
		label_13.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		label_13.setBackground(Color.WHITE);
		label_13.setBounds(105, 392, 97, 36);
		panel_3.add(label_13);
		
		panel_4 = new JPanel();
		panel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String sid = textAvatar2.getText();
				
				
				MyStudent_Details studProfile = new MyStudent_Details();
				studProfile.setVisible(true);
				studProfile.textFieldID.setText(sid);
				
				String lid = lblID.getText();
				studProfile.lblID.setText(lid);
				dispose();
				
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				
				panel_4.setBackground(new Color(0, 76, 153));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				panel_4.setBackground(new Color(105, 105, 105));
			}
		});
		panel_4.setBorder(new LineBorder(new Color(192, 192, 192), 3));
		panel_4.setBackground(SystemColor.controlDkShadow);
		panel_4.setBounds(300, 148, 251, 486);

		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		lblAvatar2 = new JLabel("");
		lblAvatar2.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvatar2.setBounds(12, 40, 227, 168);
		Image img2 = new ImageIcon(this.getClass().getResource("/avatar2.png")).getImage();
		lblAvatar2.setIcon(new ImageIcon(img2));
		panel_4.add(lblAvatar2);
		
		textAvatar2 = new JLabel("");
		textAvatar2.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
				
				String a1= lblID.getText();
				String query = "SELECT * FROM Student_Registered WHERE LID  LIKE '"+a1+"%' LIMIT 1 OFFSET 1 ";
				
				try 
				{	
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs= pst.executeQuery();

					if(rs.next())
					{
						textAvatar2.setText(rs.getString(2));
					}
					else 
					{
						//JOptionPane.showMessageDialog(null, "Incorrect Username");
					}
					
				} catch (Exception e1) 
				{
					//JOptionPane.showMessageDialog(null, e1);
				}
				
				String a2= textAvatar2.getText();
				String query2="Select Proposal,Analysis,Design,Report from Document where SID='"+a2+"' ";
				
				try 
				{
					PreparedStatement pst= connection.prepareStatement(query2);
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
						panelP2.setBackground(new Color(0, 206, 209));
					}
					if(checkDBA != null) 
					{
						panelA2.setBackground(new Color(0, 206, 209));
					}
					
					if(checkDBD != null) 
					{
						panelD2.setBackground(new Color(0, 206, 209));
					}
					if(checkDBR != null) 
					{
						panelR2.setBackground(new Color(0, 206, 209));
					}
					
					/*else 
					{
						panel_2.setBackground(new Color(0, 206, 209));
						//System.out.println("This has values");
					
					}*/
					rs.close();
					
				} catch (Exception e) 
				{
					//JOptionPane.showMessageDialog(null, e);
				}
				
			}
			public void ancestorMoved(AncestorEvent arg0) {
			}
			public void ancestorRemoved(AncestorEvent arg0) {
			}
		});
		textAvatar2.setHorizontalAlignment(SwingConstants.CENTER);
		textAvatar2.setForeground(Color.WHITE);
		textAvatar2.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		textAvatar2.setBounds(64, 27, 126, 26);
		panel_4.add(textAvatar2);
		
		panelP2 = new JPanel();
		panelP2.setLayout(null);
		panelP2.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panelP2.setBackground(new Color(178, 34, 34));
		panelP2.setBounds(51, 207, 48, 45);
		panel_4.add(panelP2);
		
		label_14 = new JLabel("");
		label_14.setHorizontalAlignment(SwingConstants.CENTER);
		label_14.setBounds(0, 0, 48, 45);
		panelP2.add(label_14);
		
		panelA2 = new JPanel();
		panelA2.setLayout(null);
		panelA2.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panelA2.setBackground(new Color(178, 34, 34));
		panelA2.setBounds(51, 265, 48, 45);
		panel_4.add(panelA2);
		
		label_15 = new JLabel("");
		label_15.setHorizontalAlignment(SwingConstants.CENTER);
		label_15.setBounds(0, 0, 48, 45);
		panelA2.add(label_15);
		
		panelD2 = new JPanel();
		panelD2.setLayout(null);
		panelD2.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panelD2.setBackground(new Color(178, 34, 34));
		panelD2.setBounds(51, 323, 48, 45);
		panel_4.add(panelD2);
		
		label_16 = new JLabel("");
		label_16.setHorizontalAlignment(SwingConstants.CENTER);
		label_16.setBounds(0, 0, 48, 45);
		panelD2.add(label_16);
		
		panelR2 = new JPanel();
		panelR2.setLayout(null);
		panelR2.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panelR2.setBackground(new Color(178, 34, 34));
		panelR2.setBounds(51, 381, 48, 45);
		panel_4.add(panelR2);
		
		label_17 = new JLabel("");
		label_17.setHorizontalAlignment(SwingConstants.CENTER);
		label_17.setBounds(0, 0, 48, 45);
		panelR2.add(label_17);
		
		label_18 = new JLabel("Proposal");
		label_18.setForeground(Color.WHITE);
		label_18.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		label_18.setBackground(Color.WHITE);
		label_18.setBounds(111, 216, 78, 36);
		panel_4.add(label_18);
		
		label_19 = new JLabel("Analysis");
		label_19.setForeground(Color.WHITE);
		label_19.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		label_19.setBackground(Color.WHITE);
		label_19.setBounds(111, 274, 78, 36);
		panel_4.add(label_19);
		
		label_20 = new JLabel("Design");
		label_20.setForeground(Color.WHITE);
		label_20.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		label_20.setBackground(Color.WHITE);
		label_20.setBounds(111, 332, 78, 36);
		panel_4.add(label_20);
		
		label_21 = new JLabel("Final Report");
		label_21.setForeground(Color.WHITE);
		label_21.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		label_21.setBackground(Color.WHITE);
		label_21.setBounds(111, 390, 97, 36);
		panel_4.add(label_21);
		
		panel_5 = new JPanel();
		panel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String sid = textAvatar3.getText();
				
				MyStudent_Details studProfile = new MyStudent_Details();
				studProfile.setVisible(true);
				studProfile.textFieldID.setText(sid);
				
				String lid = lblID.getText();
				studProfile.lblID.setText(lid);
				dispose();
				
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				
				panel_5.setBackground(new Color(0, 76, 153));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				panel_5.setBackground(new Color(105, 105, 105));
			}
		});
		panel_5.setBorder(new LineBorder(new Color(192, 192, 192), 3));
		panel_5.setBackground(SystemColor.controlDkShadow);
		panel_5.setBounds(586, 148, 251, 486);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		lblAvatar3 = new JLabel("");
		lblAvatar3.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvatar3.setBounds(12, 40, 227, 168);
		Image img3 = new ImageIcon(this.getClass().getResource("/avatar3.png")).getImage();
		lblAvatar3.setIcon(new ImageIcon(img3));
		panel_5.add(lblAvatar3);
		
		textAvatar3 = new JLabel("");
		textAvatar3.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				
				String a1= lblID.getText();
				String query = "SELECT * FROM Student_Registered WHERE LID  LIKE '"+a1+"%' LIMIT 1 OFFSET 2 ";
				
				try 
				{	
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs= pst.executeQuery();

					if(rs.next())
					{
						textAvatar3.setText(rs.getString(2));
					}
					
				} catch (Exception e1) 
				{
					//JOptionPane.showMessageDialog(null, e1);
				}
				
				String a2= textAvatar3.getText();
				String query2="Select Proposal,Analysis,Design,Report from Document where SID='"+a2+"' ";
				
				try 
				{
					PreparedStatement pst= connection.prepareStatement(query2);
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
						panelP3.setBackground(new Color(0, 206, 209));
					}
					if(checkDBA != null) 
					{
						panelA3.setBackground(new Color(0, 206, 209));
					}
					
					if(checkDBD != null) 
					{
						panelD3.setBackground(new Color(0, 206, 209));
					}
					if(checkDBR != null) 
					{
						panelR3.setBackground(new Color(0, 206, 209));
					}
					
					/*else 
					{
						panel_2.setBackground(new Color(0, 206, 209));
						//System.out.println("This has values");
					
					}*/
					rs.close();
					
				} catch (Exception e) 
				{
					//JOptionPane.showMessageDialog(null, e);
				}
				
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		textAvatar3.setHorizontalAlignment(SwingConstants.CENTER);
		textAvatar3.setForeground(Color.WHITE);
		textAvatar3.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		textAvatar3.setBounds(69, 29, 126, 26);
		panel_5.add(textAvatar3);
		
		panelP3 = new JPanel();
		panelP3.setLayout(null);
		panelP3.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panelP3.setBackground(new Color(178, 34, 34));
		panelP3.setBounds(49, 210, 48, 45);
		panel_5.add(panelP3);
		
		label_22 = new JLabel("");
		label_22.setHorizontalAlignment(SwingConstants.CENTER);
		label_22.setBounds(0, 0, 48, 45);
		panelP3.add(label_22);
		
		panelA3 = new JPanel();
		panelA3.setLayout(null);
		panelA3.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panelA3.setBackground(new Color(178, 34, 34));
		panelA3.setBounds(49, 268, 48, 45);
		panel_5.add(panelA3);
		
		label_23 = new JLabel("");
		label_23.setHorizontalAlignment(SwingConstants.CENTER);
		label_23.setBounds(0, 0, 48, 45);
		panelA3.add(label_23);
		
		panelD3 = new JPanel();
		panelD3.setLayout(null);
		panelD3.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panelD3.setBackground(new Color(178, 34, 34));
		panelD3.setBounds(49, 326, 48, 45);
		panel_5.add(panelD3);
		
		label_24 = new JLabel("");
		label_24.setHorizontalAlignment(SwingConstants.CENTER);
		label_24.setBounds(0, 0, 48, 45);
		panelD3.add(label_24);
		
		panelR3 = new JPanel();
		panelR3.setLayout(null);
		panelR3.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panelR3.setBackground(new Color(178, 34, 34));
		panelR3.setBounds(49, 384, 48, 45);
		panel_5.add(panelR3);
		
		label_25 = new JLabel("");
		label_25.setHorizontalAlignment(SwingConstants.CENTER);
		label_25.setBounds(0, 0, 48, 45);
		panelR3.add(label_25);
		
		label_26 = new JLabel("Proposal");
		label_26.setForeground(Color.WHITE);
		label_26.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		label_26.setBackground(Color.WHITE);
		label_26.setBounds(109, 219, 78, 36);
		panel_5.add(label_26);
		
		label_27 = new JLabel("Analysis");
		label_27.setForeground(Color.WHITE);
		label_27.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		label_27.setBackground(Color.WHITE);
		label_27.setBounds(109, 277, 78, 36);
		panel_5.add(label_27);
		
		label_28 = new JLabel("Design");
		label_28.setForeground(Color.WHITE);
		label_28.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		label_28.setBackground(Color.WHITE);
		label_28.setBounds(109, 335, 78, 36);
		panel_5.add(label_28);
		
		label_29 = new JLabel("Final Report");
		label_29.setForeground(Color.WHITE);
		label_29.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		label_29.setBackground(Color.WHITE);
		label_29.setBounds(109, 393, 97, 36);
		panel_5.add(label_29);
		
		panel_6 = new JPanel();
		panel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String sid = textAvatar4.getText();
				
				MyStudent_Details studProfile = new MyStudent_Details();
				studProfile.setVisible(true);
				studProfile.textFieldID.setText(sid);
				
				String lid = lblID.getText();
				studProfile.lblID.setText(lid);
				dispose();
				
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				
				panel_6.setBackground(new Color(0, 76, 153));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				panel_6.setBackground(new Color(105, 105, 105));
			}
		});
		panel_6.setBorder(new LineBorder(new Color(192, 192, 192), 3));
		panel_6.setBackground(SystemColor.controlDkShadow);
		panel_6.setBounds(859, 148, 251, 486);
		contentPane.add(panel_6);
		panel_6.setLayout(null);
		
		lblAvatar4 = new JLabel("");
		lblAvatar4.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvatar4.setBounds(12, 40, 227, 168);
		Image img4 = new ImageIcon(this.getClass().getResource("/avatar4.png")).getImage();
		lblAvatar4.setIcon(new ImageIcon(img4));
		panel_6.add(lblAvatar4);
		
		textAvatar4 = new JLabel("");
		textAvatar4.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				
				String a1= lblID.getText();
				String query = "SELECT * FROM Student_Registered WHERE LID  LIKE '"+a1+"%' LIMIT 1 OFFSET 3 ";
				
				try 
				{	
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs= pst.executeQuery();

					if(rs.next())
					{
						textAvatar4.setText(rs.getString(2));
					}
					
				} catch (Exception e1) 
				{
					//JOptionPane.showMessageDialog(null, e1);
				}
				
				String a2= textAvatar4.getText();
				String query2="Select Proposal,Analysis,Design,Report from Document where SID='"+a2+"' ";
				
				try 
				{
					PreparedStatement pst= connection.prepareStatement(query2);
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
						panelP4.setBackground(new Color(0, 206, 209));
					}
					if(checkDBA != null) 
					{
						panelA4.setBackground(new Color(0, 206, 209));
					}
					
					if(checkDBD != null) 
					{
						panelD4.setBackground(new Color(0, 206, 209));
					}
					if(checkDBR != null) 
					{
						panelR4.setBackground(new Color(0, 206, 209));
					}
					
					/*else 
					{
						panel_2.setBackground(new Color(0, 206, 209));
						//System.out.println("This has values");
					
					}*/
					rs.close();
					
				} catch (Exception e) 
				{
					//JOptionPane.showMessageDialog(null, e);
				}
				
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
			
		});
		textAvatar4.setHorizontalAlignment(SwingConstants.CENTER);
		textAvatar4.setForeground(Color.WHITE);
		textAvatar4.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		textAvatar4.setBounds(60, 29, 126, 26);
		panel_6.add(textAvatar4);
		
		panelP4 = new JPanel();
		panelP4.setLayout(null);
		panelP4.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panelP4.setBackground(new Color(178, 34, 34));
		panelP4.setBounds(60, 212, 48, 45);
		panel_6.add(panelP4);
		
		label_30 = new JLabel("");
		label_30.setHorizontalAlignment(SwingConstants.CENTER);
		label_30.setBounds(0, 0, 48, 45);
		panelP4.add(label_30);
		
		panelA4 = new JPanel();
		panelA4.setLayout(null);
		panelA4.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panelA4.setBackground(new Color(178, 34, 34));
		panelA4.setBounds(60, 270, 48, 45);
		panel_6.add(panelA4);
		
		label_31 = new JLabel("");
		label_31.setHorizontalAlignment(SwingConstants.CENTER);
		label_31.setBounds(0, 0, 48, 45);
		panelA4.add(label_31);
		
		panelD4 = new JPanel();
		panelD4.setLayout(null);
		panelD4.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panelD4.setBackground(new Color(178, 34, 34));
		panelD4.setBounds(60, 328, 48, 45);
		panel_6.add(panelD4);
		
		label_32 = new JLabel("");
		label_32.setHorizontalAlignment(SwingConstants.CENTER);
		label_32.setBounds(0, 0, 48, 45);
		panelD4.add(label_32);
		
		panelR4 = new JPanel();
		panelR4.setLayout(null);
		panelR4.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panelR4.setBackground(new Color(178, 34, 34));
		panelR4.setBounds(60, 386, 48, 45);
		panel_6.add(panelR4);
		
		label_33 = new JLabel("");
		label_33.setHorizontalAlignment(SwingConstants.CENTER);
		label_33.setBounds(0, 0, 48, 45);
		panelR4.add(label_33);
		
		label_34 = new JLabel("Proposal");
		label_34.setForeground(Color.WHITE);
		label_34.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		label_34.setBackground(Color.WHITE);
		label_34.setBounds(120, 221, 78, 36);
		panel_6.add(label_34);
		
		label_35 = new JLabel("Analysis");
		label_35.setForeground(Color.WHITE);
		label_35.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		label_35.setBackground(Color.WHITE);
		label_35.setBounds(120, 279, 78, 36);
		panel_6.add(label_35);
		
		label_36 = new JLabel("Design");
		label_36.setForeground(Color.WHITE);
		label_36.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		label_36.setBackground(Color.WHITE);
		label_36.setBounds(120, 337, 78, 36);
		panel_6.add(label_36);
		
		label_37 = new JLabel("Final Report");
		label_37.setForeground(Color.WHITE);
		label_37.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		label_37.setBackground(Color.WHITE);
		label_37.setBounds(120, 395, 97, 36);
		panel_6.add(label_37);
		
		panel_7 = new JPanel();
		panel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String sid = textAvatar5.getText();
				
				MyStudent_Details studProfile = new MyStudent_Details();
				studProfile.setVisible(true);
				studProfile.textFieldID.setText(sid);
				dispose();
				
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				
				panel_7.setBackground(new Color(0, 76, 153));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				panel_7.setBackground(new Color(105, 105, 105));
			}
		});
		panel_7.setBorder(new LineBorder(new Color(192, 192, 192), 3));
		panel_7.setBackground(SystemColor.controlDkShadow);
		panel_7.setBounds(1131, 148, 251, 486);
		contentPane.add(panel_7);
		panel_7.setLayout(null);
		
		lblAvatar5 = new JLabel("");
		lblAvatar5.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvatar5.setBounds(12, 40, 227, 168);
		Image img5 = new ImageIcon(this.getClass().getResource("/avatar5.png")).getImage();
		lblAvatar5.setIcon(new ImageIcon(img5));
		panel_7.add(lblAvatar5);
		
		textAvatar5 = new JLabel("");
		textAvatar5.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				
				String a1= lblID.getText();
				String query = "SELECT * FROM Student_Registered WHERE LID  LIKE '"+a1+"%' LIMIT 1 OFFSET 4 ";
				
				try 
				{	
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs= pst.executeQuery();

					if(rs.next())
					{
						textAvatar5.setText(rs.getString(2));
					}
					
				} catch (Exception e1) 
				{
					//JOptionPane.showMessageDialog(null, e1);
				}
				
				String a2= textAvatar5.getText();
				String query2="Select Proposal,Analysis,Design,Report from Document where SID='"+a2+"' ";
				
				try 
				{
					PreparedStatement pst= connection.prepareStatement(query2);
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
						panelP5.setBackground(new Color(0, 206, 209));
					}
					if(checkDBA != null) 
					{
						panelA5.setBackground(new Color(0, 206, 209));
					}
					
					if(checkDBD != null) 
					{
						panelD5.setBackground(new Color(0, 206, 209));
					}
					if(checkDBR != null) 
					{
						panelR5.setBackground(new Color(0, 206, 209));
					}
					
					/*else 
					{
						panel_2.setBackground(new Color(0, 206, 209));
						//System.out.println("This has values");
					
					}*/
					rs.close();
					
				} catch (Exception e) 
				{
					//JOptionPane.showMessageDialog(null, e);
				}
				
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		textAvatar5.setHorizontalAlignment(SwingConstants.CENTER);
		textAvatar5.setForeground(Color.WHITE);
		textAvatar5.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		textAvatar5.setBounds(65, 35, 126, 26);
		panel_7.add(textAvatar5);
		
		panelP5 = new JPanel();
		panelP5.setLayout(null);
		panelP5.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panelP5.setBackground(new Color(178, 34, 34));
		panelP5.setBounds(65, 213, 48, 45);
		panel_7.add(panelP5);
		
		label_38 = new JLabel("");
		label_38.setHorizontalAlignment(SwingConstants.CENTER);
		label_38.setBounds(0, 0, 48, 45);
		panelP5.add(label_38);
		
		panelA5 = new JPanel();
		panelA5.setLayout(null);
		panelA5.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panelA5.setBackground(new Color(178, 34, 34));
		panelA5.setBounds(65, 271, 48, 45);
		panel_7.add(panelA5);
		
		label_39 = new JLabel("");
		label_39.setHorizontalAlignment(SwingConstants.CENTER);
		label_39.setBounds(0, 0, 48, 45);
		panelA5.add(label_39);
		
		panelD5 = new JPanel();
		panelD5.setLayout(null);
		panelD5.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panelD5.setBackground(new Color(178, 34, 34));
		panelD5.setBounds(65, 329, 48, 45);
		panel_7.add(panelD5);
		
		label_40 = new JLabel("");
		label_40.setHorizontalAlignment(SwingConstants.CENTER);
		label_40.setBounds(0, 0, 48, 45);
		panelD5.add(label_40);
		
		panelR5 = new JPanel();
		panelR5.setLayout(null);
		panelR5.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panelR5.setBackground(new Color(178, 34, 34));
		panelR5.setBounds(65, 387, 48, 45);
		panel_7.add(panelR5);
		
		label_41 = new JLabel("");
		label_41.setHorizontalAlignment(SwingConstants.CENTER);
		label_41.setBounds(0, 0, 48, 45);
		panelR5.add(label_41);
		
		label_42 = new JLabel("Proposal");
		label_42.setForeground(Color.WHITE);
		label_42.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		label_42.setBackground(Color.WHITE);
		label_42.setBounds(125, 222, 78, 36);
		panel_7.add(label_42);
		
		label_43 = new JLabel("Analysis");
		label_43.setForeground(Color.WHITE);
		label_43.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		label_43.setBackground(Color.WHITE);
		label_43.setBounds(125, 280, 78, 36);
		panel_7.add(label_43);
		
		label_44 = new JLabel("Design");
		label_44.setForeground(Color.WHITE);
		label_44.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		label_44.setBackground(Color.WHITE);
		label_44.setBounds(125, 338, 78, 36);
		panel_7.add(label_44);
		
		label_45 = new JLabel("Final Report");
		label_45.setForeground(Color.WHITE);
		label_45.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		label_45.setBackground(Color.WHITE);
		label_45.setBounds(125, 396, 97, 36);
		panel_7.add(label_45);
		
		label = new JLabel("Copyright 2018, FTMK. All rights reserved.");
		label.setForeground(Color.LIGHT_GRAY);
		label.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		label.setBounds(1054, 699, 328, 36);
		contentPane.add(label);
		
		lblFTMK = new JLabel("New label");
		lblFTMK.setBounds(1023, -60, 464, 269);
		lblFTMK.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/utemnoob2.png")).getImage().getScaledInstance(lblFTMK.getWidth(), lblFTMK.getHeight(), Image.SCALE_SMOOTH)));

		contentPane.add(lblFTMK);
		
		panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_8.setBackground(new Color(0, 206, 209));
		panel_8.setBounds(210, 690, 48, 45);
		contentPane.add(panel_8);
		
		label_1 = new JLabel("");
		contentPane.add(label_1);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_9.setBackground(new Color(178, 34, 34));
		panel_9.setBounds(360, 690, 48, 45);
		contentPane.add(panel_9);
		
		label_2 = new JLabel("");
		contentPane.add(label_2);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		label_3 = new JLabel("Incomplete");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Arial Narrow", Font.PLAIN, 19));
		label_3.setBackground(Color.WHITE);
		label_3.setBounds(420, 699, 78, 36);
		contentPane.add(label_3);
		
		label_4 = new JLabel("Complete");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Arial Narrow", Font.PLAIN, 19));
		label_4.setBackground(Color.WHITE);
		label_4.setBounds(270, 699, 78, 36);
		contentPane.add(label_4);
		
		label_5 = new JLabel("Status Guide:");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		label_5.setBackground(Color.WHITE);
		label_5.setBounds(44, 699, 133, 36);
		contentPane.add(label_5);
		
		lblMyStudentList = new JLabel("MY STUDENT LIST");
		lblMyStudentList.setForeground(Color.WHITE);
		lblMyStudentList.setFont(new Font("Arial Narrow", Font.BOLD, 30));
		lblMyStudentList.setBounds(598, 37, 228, 36);
		contentPane.add(lblMyStudentList);
		
		labelBackground = new JLabel("");
		labelBackground.setBounds(0, 0, 1411, 760);
		labelBackground.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/blur1.jpg")).getImage().getScaledInstance(labelBackground.getWidth(), labelBackground.getHeight(), Image.SCALE_SMOOTH)));
		contentPane.add(labelBackground);
		
		lblID = new JLabel("");
		lblID.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		lblID.setForeground(Color.WHITE);
		lblID.setBounds(308, 37, 99, 26);
		contentPane.add(lblID);
		
		setResizable(false);
		setLocationRelativeTo(null);
		setIcon();
	}
	
	private void setIcon() 
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/FTMK logo.png")));
	}
}

package unwantedframe;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.border.EmptyBorder;
import Database2.Mysql;
import Model.Student;
import View.Lecturer_Main;
import View.MyStudent_Details;

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

public class MyStudent_Search extends JFrame {

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
					MyStudent_Search frame = new MyStudent_Search();
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
	public JTable table;
	private JLabel labelBackground;
	private JButton btnBack;
	private ImageIcon format = null;
	int s=0;
	byte[] person_image=null;
	private JButton btnDisplayImage;
	JLabel lblID = new JLabel("L1112");
	
	

	/**
	 * Create the frame.
	 */
	public MyStudent_Search() {
		setTitle("My Student");
		
		connection=Mysql.dbConnector(); 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1374, 783);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(50, 205, 50));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();;
		scrollPane.setEnabled(false);
		scrollPane.getViewport().setBackground(Color.DARK_GRAY);
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int index = table.getSelectedRow();
				String model = (table.getModel().getValueAt(index, 0).toString());
				
				//String sid = model.getValueAt(index, 1).toString();
				//String name = model.getValueAt(index, 3).toString();
				//String course = model.getValueAt(index, 4).toString();
				

				
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				if(arg0.isPopupTrigger()) {}
				
			}
		});
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(259, 76, 1091, 644);
		contentPane.add(scrollPane);
		
		table = new JTable()
		{  
		       public boolean isCellEditable(int row,int column){  
		    	   
		         return false;  
		       }  
		};
		table.setShowGrid(false);
		table.setBorder(null);
		table.setBackground(Color.WHITE);
		table.setForeground(Color.DARK_GRAY);
		table.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		scrollPane.setViewportView(table);
		
		JButton btnLoadLecturer = new JButton("Load Table");
		btnLoadLecturer.setBackground(new Color(65, 105, 225));
		btnLoadLecturer.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		btnLoadLecturer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try 
				{
					//String query = "SELECT SID, Name, Email, Course, Telephone FROM Student_Registered";
					//String query = "SELECT Student_Registered.SID, Student_Registered.Name, Student_Registered.Email, Student_Registered.Course, "
							//+ "Project.Title, Project.Objective, Project.Skill FROM Student_Registered INNER JOIN Project ON Student_Registered.SID = Project.SID  ";
					//String query = "SELECT * FROM Student_Registered LEFT JOIN Lecturer_Registered ON Student_Registered.LID = Lecturer_Registered.LID='"+a1+"' ";
					//String query = "SELECT Student_Registered.Name, Student_Registered.Email, Lecturer_Registered.Name FROM Student_Registered INNER JOIN Lecturer_Registered ON Student_Registered.LID = '"+a1+"' ";
					
					String a1= lblID.getText();
					String query = "SELECT SID, Name, Email, Course, Telephone FROM Student_Registered WHERE LID  LIKE '"+a1+"%'; ";
					
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs= pst.executeQuery();

					//DbUtils = rs2xml.jar class
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					scrollPane.setVisible(true);
					
				} catch (Exception e1) 
				{
					
				}
			}
		});
		btnLoadLecturer.setBounds(51, 518, 188, 39);
		contentPane.add(btnLoadLecturer);
		
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
		btnBack.setBackground(new Color(220, 20, 60));
		btnBack.setBounds(51, 570, 188, 39);
		contentPane.add(btnBack);
		
		btnDisplayImage = new JButton("Student Details");
		btnDisplayImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index = table.getSelectedRow();
				TableModel model = table.getModel();
				
				String sid = model.getValueAt(index, 0).toString();
				String name = model.getValueAt(index, 1).toString();
				String course = model.getValueAt(index, 2).toString();
				String tel = model.getValueAt(index, 3).toString();
				
				MyStudent_Details studProfile = new MyStudent_Details();
				studProfile.setVisible(true);
				studProfile.textFieldID.setText(sid);
				dispose();
				
			}
		});
		btnDisplayImage.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		btnDisplayImage.setBackground(new Color(65, 105, 225));
		btnDisplayImage.setBounds(51, 466, 188, 39);
		contentPane.add(btnDisplayImage);
		
		lblID = new JLabel("");
		lblID.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		lblID.setForeground(Color.WHITE);
		lblID.setBounds(308, 37, 99, 26);
		contentPane.add(lblID);
		
		labelBackground = new JLabel("");
		labelBackground.setBounds(0, 0, 1374, 760);
		labelBackground.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/blur1.jpg")).getImage().getScaledInstance(labelBackground.getWidth(), labelBackground.getHeight(), Image.SCALE_SMOOTH)));
		contentPane.add(labelBackground);
	}
}

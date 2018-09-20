package View;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.border.EmptyBorder;
import Database2.Mysql;
import Model.Kohout;
import Model.Student;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.Window;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import java.text.MessageFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
import java.text.*;
import java.awt.print.*;

public class Student_Search1 extends JFrame {

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
					Student_Search1 frame = new Student_Search1();
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
	private JButton btnDeleteSelectedRow;
	private JButton btnAdd;
	private JTextField searchtextField;
	private JPanel panel;
	private JLabel lblSearchIdnamecourse;
	private JLabel labelBackground;
	private ImageIcon format = null;
	int s=0;
	byte[] person_image=null;
	private JLabel lblClock;
	private JLabel lblDate;
	private JLabel lblTotalDoc;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel lblTotal;
	private JLabel lblTotalStudent;
	private JLabel label_5;
	private JButton btnPrint;
	private JButton btnLogout;
	private JButton btnKahout;
	static JComboBox comboBox;
	
	
	/**
	 * Create the frame.
	 */
	public Student_Search1() {
		
		connection=Mysql.dbConnector(); 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1471, 781);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
				
/*				try 
				{
					String query = "select SID, Name, Course, Telephone from Student_Registered";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs= pst.executeQuery();

					//DbUtils = rs2xml.jar class
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					scrollPane.setVisible(true);
					
				} catch (Exception e1) 
				{
					
				}*/
				
			}
			public void ancestorMoved(AncestorEvent arg0) {
			}
			public void ancestorRemoved(AncestorEvent arg0) {
			}
		});;
		scrollPane.setEnabled(false);
		scrollPane.getViewport().setBackground(Color.DARK_GRAY);
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				/*int index = table.getSelectedRow();
				String model = (table.getModel().getValueAt(index, 0).toString());
				
				//String sid = model.getValueAt(index, 1).toString();
				//String name = model.getValueAt(index, 3).toString();
				//String course = model.getValueAt(index, 4).toString();
				
				try 
				{
				
					String query="Select image from Student_Registered where SID='"+model+"'";
					PreparedStatement pst= connection.prepareStatement(query);
					ResultSet rs= pst.executeQuery();
					
					if(rs.next()) 
					{
					//For Display Image
					byte[] imagedata = rs.getBytes("image");
					format = new ImageIcon(imagedata);
					lblImageDisplay.setIcon(format);
					lblImageDisplay.setIcon(new ImageIcon(new javax.swing.ImageIcon(imagedata).getImage().getScaledInstance(lblImageDisplay.getWidth(), lblImageDisplay.getHeight(), Image.SCALE_SMOOTH)));
					}
					
				} catch (Exception e) 
				{
					JOptionPane.showMessageDialog(null, "fail");
				}*/
				
			}
		});
		scrollPane.setViewportBorder(new MatteBorder(2, 3, 3, 3, (Color) Color.LIGHT_GRAY));
		scrollPane.setBounds(240, 96, 1201, 607);
		contentPane.add(scrollPane);
		
		table = new JTable()
		{  
		       public boolean isCellEditable(int row,int column){  
		    	   
		         return false;  
		       }  
		};
		table.setShowGrid(false);
		table.setBorder(new LineBorder(Color.DARK_GRAY, 3));
		table.setBackground(Color.LIGHT_GRAY);
		table.setForeground(new Color(255, 255, 255));
		table.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
		scrollPane.setViewportView(table);
		
		JButton btnLoadLecturer = new JButton("Reload");
		btnLoadLecturer.setForeground(Color.DARK_GRAY);
		btnLoadLecturer.setBackground(new Color(245, 245, 245));
		btnLoadLecturer.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		btnLoadLecturer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try 
				{
					String query = "select SID, Name, Course, Telephone from Student_Registered";
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
		btnLoadLecturer.setBounds(958, 13, 153, 62);
		Image img3 = new ImageIcon(this.getClass().getResource("/reload.png")).getImage();
		btnLoadLecturer.setIcon(new ImageIcon(img3));
		contentPane.add(btnLoadLecturer);
		
		btnDeleteSelectedRow = new JButton("Delete");
		btnDeleteSelectedRow.setForeground(Color.DARK_GRAY);
		btnDeleteSelectedRow.setBackground(new Color(245, 245, 245));
		btnDeleteSelectedRow.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		btnDeleteSelectedRow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	                
	             int action=JOptionPane.showConfirmDialog(null, "Do you really want to delete?","Delete",JOptionPane.YES_NO_OPTION);
	             
	             if(action==0) 
	             {
	 				DefaultTableModel model = (DefaultTableModel) table.getModel();
					int SelectedRowIndex = table.getSelectedRow();
					
					String selected = model.getValueAt(SelectedRowIndex, 0).toString();
				
					if (SelectedRowIndex >= 0) {

		                model.removeRow(SelectedRowIndex);
	            	
	 				try {
	 					
	 					String query = "DELETE from Student_Registered WHERE SID='"+selected+"' ";
	 					String query2 = "DELETE from Project WHERE SID='"+selected+"' ";
	 					String query3 = "DELETE from Document WHERE SID='"+selected+"' ";
	 					
	 					
	 					
	 					PreparedStatement pst = connection.prepareStatement(query);
	 					pst.executeUpdate();
	 					
	 					PreparedStatement pst2 = connection.prepareStatement(query2);
	 					pst2.executeUpdate();
	 					
	 					PreparedStatement pst3 = connection.prepareStatement(query3);
	 					pst3.executeUpdate();
	 					
	 					JOptionPane.showMessageDialog(null, "Delete Success");
	 					pst.close();
	 					pst2.close();
	 					pst3.close();
	 					
	 					//String query = "DELETE from StudentInfo where SID='"+lblB.getText()+"' ";
	 					//String query = "DELETE Student_Registered.SID, Project.SID FROM Student_Registered JOIN Project ON Student_Registered.SID = Project.SID ON Project.SID='"+selected+"'";
	 					//String query = "DELETE from Student_Registered where SID='"+selected+"' ";
	 					} catch (Exception e2) 
	 					{
	 						JOptionPane.showMessageDialog(null, "Please select a row to be deleted");
	 					}
	             }
	             
				
				}
				
				
			}
		});
		btnDeleteSelectedRow.setBounds(1123, 13, 153, 62);
		Image img4 = new ImageIcon(this.getClass().getResource("/delete.png")).getImage();
		btnDeleteSelectedRow.setIcon(new ImageIcon(img4));
		contentPane.add(btnDeleteSelectedRow);
		
		btnAdd = new JButton("Enroll");
		btnAdd.setForeground(Color.DARK_GRAY);
		btnAdd.setBackground(new Color(245, 245, 245));
		btnAdd.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Untuk Carry Assign Index
				int index = table.getSelectedRow();
				TableModel model = table.getModel();
				
				String sid = model.getValueAt(index, 0).toString();
				String name = model.getValueAt(index, 1).toString();
				String course = model.getValueAt(index, 2).toString();
				String tel = model.getValueAt(index, 3).toString();
				
				Assign_Student assign = new Assign_Student();
				assign.setVisible(true);
			
				
				assign.idtextField.setText(sid);
				//assign.nameField.setText(name);
				//assign.courseField.setText(course);
				//assign.telField.setText(tel);
			
				
			}
		});
		btnAdd.setBounds(793, 13, 153, 62);
		Image img2 = new ImageIcon(this.getClass().getResource("/enroll.png")).getImage();
		btnAdd.setIcon(new ImageIcon(img2));
		contentPane.add(btnAdd);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(65, 105, 225), 2, true));
		panel.setBounds(240, 13, 376, 70);
		contentPane.add(panel);
		panel.setLayout(null);
		
		searchtextField = new JTextField();
		searchtextField.setBounds(233, 13, 129, 28);
		panel.add(searchtextField);
		searchtextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				try 
				{
					String query="Select SID,Name,Course,Telephone from Student_Registered where SID=?";
					PreparedStatement pst= connection.prepareStatement(query);
					pst.setString(1, searchtextField.getText());
					ResultSet rs = pst.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					while(rs.next()) 
					{
						
					}
					
					pst.close();
					
				} 
				catch(Exception e2) 
				{
					
				}
				
			}
		});
		searchtextField.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		searchtextField.setColumns(10);
		
		JLabel lblSearch = new JLabel("Search :");
		lblSearch.setBounds(164, 13, 198, 29);
		panel.add(lblSearch);
		lblSearch.setBackground(Color.WHITE);
		lblSearch.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		
		lblSearchIdnamecourse = new JLabel("Search By Id");
		lblSearchIdnamecourse.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		lblSearchIdnamecourse.setBackground(Color.WHITE);
		lblSearchIdnamecourse.setBounds(233, 41, 129, 29);
		panel.add(lblSearchIdnamecourse);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String a1=(String) comboBox.getSelectedItem();
				String query= "select SID, Name, Course, Telephone from Student_Registered where Kohout='"+a1+"' ";
				
				try 
				{
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
		comboBox.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		comboBox.setBounds(12, 18, 140, 23);
		panel.add(comboBox);
		
		JButton btnStudentDetail = new JButton("Details");
		btnStudentDetail.setForeground(Color.DARK_GRAY);
		btnStudentDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index = table.getSelectedRow();
				TableModel model = table.getModel();
				
				String sid = model.getValueAt(index, 0).toString();
				String name = model.getValueAt(index, 1).toString();
				String course = model.getValueAt(index, 2).toString();
				String tel = model.getValueAt(index, 3).toString();
				
				Student_Details studProfile = new Student_Details();
				studProfile.setVisible(true);
				studProfile.textFieldID.setText(sid);
				dispose();
				
			}
		});
		btnStudentDetail.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		btnStudentDetail.setBackground(new Color(245, 245, 245));
		btnStudentDetail.setBounds(628, 13, 153, 62);
		Image img1 = new ImageIcon(this.getClass().getResource("/details.png")).getImage();
		
		JLabel lblFTMK = new JLabel("New label");
		lblFTMK.setBounds(-103, -60, 464, 269);
		lblFTMK.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/utemnoob2.png")).getImage().getScaledInstance(lblFTMK.getWidth(), lblFTMK.getHeight(), Image.SCALE_SMOOTH)));
		contentPane.add(lblFTMK);
		btnStudentDetail.setIcon(new ImageIcon(img1));
		contentPane.add(btnStudentDetail);
		
		btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MessageFormat header = new MessageFormat("Report Print");
				
				MessageFormat footer = new MessageFormat("Page{0,number,integer}");
				
				try 
				{
					table.print(JTable.PrintMode.NORMAL, header, footer);
				} 
				catch (Exception e2) 
				{
					System.err.format("Cannot print %s%n",  e2.getMessage());
				}
				
			}
		});
		btnPrint.setForeground(Color.DARK_GRAY);
		btnPrint.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		btnPrint.setBackground(new Color(245, 245, 245));
		btnPrint.setBounds(1288, 13, 153, 62);
		Image img5 = new ImageIcon(this.getClass().getResource("/print.png")).getImage();
		btnPrint.setIcon(new ImageIcon(img5));
		contentPane.add(btnPrint);
		
		lblClock = new JLabel("Clock");
		lblClock.setForeground(new Color(255, 255, 255));
		lblClock.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		lblClock.setBounds(12, 396, 162, 36);
		contentPane.add(lblClock);
		
		lblDate = new JLabel("Date");
		lblDate.setForeground(new Color(255, 255, 255));
		lblDate.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		lblDate.setBounds(12, 427, 130, 36);
		contentPane.add(lblDate);
		
		lblTotalDoc = new JLabel("0");
		lblTotalDoc.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				
				String query = "Select COUNT(Proposal) AS PR,COUNT(Analysis) AS ANAL,COUNT(Design) AS DESIGN, COUNT(REPORT) AS RE FROM Document";
				
				try {
					
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					
					if(rs.next()) 
					{
						int sum = rs.getInt("PR");
						int sum2 = rs.getInt("ANAL");
						int sum3 = rs.getInt("DESIGN");
						int sum4 = rs.getInt("RE");
						int total = (sum+sum2+sum3+sum4);
						String numberAsString = Integer.toString(total);
						lblTotalDoc.setText(numberAsString);
						System.out.println(numberAsString);
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		lblTotalDoc.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotalDoc.setForeground(Color.WHITE);
		lblTotalDoc.setFont(new Font("Arial Narrow", Font.ITALIC, 20));
		lblTotalDoc.setBounds(174, 327, 59, 36);
		contentPane.add(lblTotalDoc);
		
		label_1 = new JLabel("Document Receives:");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		label_1.setBounds(12, 327, 162, 36);
		contentPane.add(label_1);
		
		label_2 = new JLabel("Total Number of Student:");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		label_2.setBounds(13, 296, 194, 36);
		contentPane.add(label_2);
		
		lblTotal = new JLabel("0");
		lblTotal.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
				
				//String a1= lblYourName.getText();
				//String query = "Select Count(id) AS LID2 FROM Student_Registered ";
				String query = "Select Count(SID) AS SID2 FROM Student_Registered";
				
				try {
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					
					if(rs.next()) 
					{
						String sum = rs.getString("SID2");
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
		lblTotal.setBounds(206, 296, 59, 36);
		contentPane.add(lblTotal);
		
		lblTotalStudent = new JLabel("Student Registered:");
		lblTotalStudent.setForeground(Color.WHITE);
		lblTotalStudent.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblTotalStudent.setBounds(12, 258, 167, 36);
		contentPane.add(lblTotalStudent);
		
		label_5 = new JLabel("Hello & Welcome");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		label_5.setBounds(69, 201, 137, 36);
		contentPane.add(label_5);
		
		btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Login login = new Login();
				login.setVisible(true);
				
			}
		});
		btnLogout.setForeground(Color.DARK_GRAY);
		btnLogout.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		btnLogout.setBackground(new Color(245, 245, 245));
		btnLogout.setBounds(37, 500, 153, 62);
		Image img6 = new ImageIcon(this.getClass().getResource("/logout-2.png")).getImage();
		btnLogout.setIcon(new ImageIcon(img6));
		contentPane.add(btnLogout);
		
		btnKahout = new JButton("Kohout");
		btnKahout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Kahout kohout = new Kahout();
				kohout.setVisible(true);
			}
		});
		btnKahout.setForeground(Color.DARK_GRAY);
		btnKahout.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		Image img7 = new ImageIcon(this.getClass().getResource("/registerkahout.png")).getImage();
		btnKahout.setIcon(new ImageIcon(img7));
		btnKahout.setBackground(new Color(245, 245, 245));
		btnKahout.setBounds(37, 586, 153, 62);
		contentPane.add(btnKahout);
		
		labelBackground = new JLabel("");
		labelBackground.setForeground(new Color(245, 245, 245));
		labelBackground.setBackground(new Color(220, 220, 220));
		labelBackground.setBounds(0, 0, 1491, 787);
		labelBackground.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/blur1.jpg")).getImage().getScaledInstance(labelBackground.getWidth(), labelBackground.getHeight(), Image.SCALE_SMOOTH)));
		contentPane.add(labelBackground);
		
		clock();
		fillComboBox();
		
		setResizable(false);
		setLocationRelativeTo(null);
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
					
					lblClock.setText(" Time: "+ hour +":"+ minutes +":"+ second + " " + day_night); 
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
	
	private void setIcon() 
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/FTMK logo.png")));
	}
}

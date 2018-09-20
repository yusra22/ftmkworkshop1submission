package unwantedframe;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.border.EmptyBorder;
import Database2.Mysql;
import Model.Student;
import View.Assign_Student;
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
public class Student_Search extends JFrame {

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
					Student_Search frame = new Student_Search();
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
	private JButton btnBack;
	private JLabel lblImageDisplay;
	private ImageIcon format = null;
	int s=0;
	byte[] person_image=null;
	private JPanel panel_1;
	private JButton btnDisplayImage;
	
	

	/**
	 * Create the frame.
	 */
	public Student_Search() {
		
		connection=Mysql.dbConnector(); 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1471, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
				
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
		scrollPane.setBounds(308, 96, 1091, 607);
		contentPane.add(scrollPane);
		
		table = new JTable()
		{  
		       public boolean isCellEditable(int row,int column){  
		    	   
		         return false;  
		       }  
		};
		table.setShowGrid(false);
		table.setBorder(new LineBorder(Color.WHITE, 3));
		table.setBackground(Color.WHITE);
		table.setForeground(Color.DARK_GRAY);
		table.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
		scrollPane.setViewportView(table);
		
		JButton btnLoadLecturer = new JButton("Load Table");
		btnLoadLecturer.setBackground(new Color(65, 105, 225));
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
		btnLoadLecturer.setBounds(51, 612, 188, 39);
		contentPane.add(btnLoadLecturer);
		
		btnDeleteSelectedRow = new JButton("Delete Row");
		btnDeleteSelectedRow.setBackground(new Color(65, 105, 225));
		btnDeleteSelectedRow.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		btnDeleteSelectedRow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int SelectedRowIndex = table.getSelectedRow();
				
				String selected = model.getValueAt(SelectedRowIndex, 0).toString();
			
				if (SelectedRowIndex >= 0) {

	                model.removeRow(SelectedRowIndex);
				
				try {
				
				//String query = "DELETE from StudentInfo where SID='"+lblB.getText()+"' ";
				
				String query = "DELETE from Student_Registered where SID='"+selected+"' ";
				PreparedStatement pst = connection.prepareStatement(query);
				//pst.setString(1, lblB.getText() );
				pst.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "Delete Success");
				
				} catch (Exception e2) 
				{
					JOptionPane.showMessageDialog(null, "Please select a row to be deleted");
				}
				
				}
				
				
			}
		});
		btnDeleteSelectedRow.setBounds(51, 560, 188, 39);
		contentPane.add(btnDeleteSelectedRow);
		
		btnAdd = new JButton("Enroll Student");
		btnAdd.setBackground(new Color(65, 105, 225));
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
		btnAdd.setBounds(51, 404, 188, 39);
		contentPane.add(btnAdd);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Lecturer_Main lec = new Lecturer_Main();
				lec.setVisible(true);
				
			}
		});
		btnBack.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		btnBack.setBackground(new Color(220, 20, 60));
		btnBack.setBounds(51, 664, 188, 39);
		contentPane.add(btnBack);
		
		btnDisplayImage = new JButton("Display Image");
		btnDisplayImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index = table.getSelectedRow();
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
					
				} catch (Exception e2) 
				{
					JOptionPane.showMessageDialog(null, "fail");
				}
				
			}
		});
		btnDisplayImage.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		btnDisplayImage.setBackground(new Color(65, 105, 225));
		btnDisplayImage.setBounds(51, 508, 188, 39);

		contentPane.add(btnDisplayImage);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(65, 105, 225), 2, true));
		panel.setBounds(310, 13, 376, 70);
		contentPane.add(panel);
		panel.setLayout(null);
		
		searchtextField = new JTextField();
		searchtextField.setBounds(106, 13, 256, 28);
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
		lblSearch.setBounds(37, 13, 158, 29);
		panel.add(lblSearch);
		lblSearch.setBackground(Color.WHITE);
		lblSearch.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		
		lblSearchIdnamecourse = new JLabel("Search By Id");
		lblSearchIdnamecourse.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		lblSearchIdnamecourse.setBackground(Color.WHITE);
		lblSearchIdnamecourse.setBounds(106, 41, 158, 29);
		panel.add(lblSearchIdnamecourse);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(65, 105, 225), 2, true));
		panel_1.setBounds(27, 85, 244, 250);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblImageDisplay = new JLabel("                    Picture Display");
		lblImageDisplay.setBounds(12, 13, 220, 224);
		panel_1.add(lblImageDisplay);
		
		JButton btnStudentDetail = new JButton("Student Detail");
		btnStudentDetail.addActionListener(new ActionListener() {
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
		btnStudentDetail.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		btnStudentDetail.setBackground(new Color(65, 105, 225));
		btnStudentDetail.setBounds(51, 456, 188, 39);
		contentPane.add(btnStudentDetail);
		
		labelBackground = new JLabel("");
		labelBackground.setBounds(0, 0, 1491, 787);
		labelBackground.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/blur1.jpg")).getImage().getScaledInstance(labelBackground.getWidth(), labelBackground.getHeight(), Image.SCALE_SMOOTH)));
		contentPane.add(labelBackground);
		
		setResizable(false);
	}
}

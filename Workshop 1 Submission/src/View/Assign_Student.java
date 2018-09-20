package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import Controller.documentController;
import Controller.lecturerController;
import Controller.projectController;
import Controller.studentController;
import Database2.Mysql;
import Model.Lecturer;
import Model.Student;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import rojerusan.RSFotoSquare;
import rojerusan.RSFotoCircle;
import com.bolivia.label.CLabel;
import com.bolivia.label.CircleBorder;
import com.bolivia.label.CLabelBeanInfo;

public class Assign_Student extends JFrame {

	public JPanel contentPane;
	public static JTextField idtextField;
	public JComboBox comboBox = new JComboBox();
	private ImageIcon format = null;

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
					Assign_Student frame = new Assign_Student();
					frame.setVisible(true);
					frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					
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
	public static JTextField textFieldLID;
	CLabel lblClabel = new CLabel();

	/**
	 * Create the frame.
	 */
	public Assign_Student() {
		
		connection=Mysql.dbConnector();
		
		setBackground(new Color(0, 0, 0));
		setTitle("Assign Student");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 558);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(250, 235, 215));
		contentPane.setBackground(new Color(112, 128, 144));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAssign = new JButton("Assign");
		btnAssign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Student student = new Student();
				student.setLID(textFieldLID.getText());
				
				try 
				{
				studentController sCtrl = new studentController();
				sCtrl.assignInsert(student);
				
				JOptionPane.showMessageDialog(null, "Success");
				
				} 
				catch (Exception e) 
				{
					JOptionPane.showMessageDialog(null, "Not Success");
				}
				
				
/*				Lecturer lecturer = new Lecturer();
				lecturer.setStatus("1");
				
				try 
				{
				lecturerController sCtrl = new lecturerController();
				sCtrl.assignInsert(lecturer);
				
				JOptionPane.showMessageDialog(null, "Success");
				
				} 
				catch (Exception e) 
				{
					JOptionPane.showMessageDialog(null, "Not Success");
				}*/
				
			}
		});
		btnAssign.setForeground(Color.WHITE);
		btnAssign.setFont(new Font("Arial Narrow", Font.PLAIN, 23));
		btnAssign.setBackground(new Color(0, 153, 153));
		btnAssign.setBounds(40, 438, 158, 47);
		contentPane.add(btnAssign);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				
			}
		});
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Arial Narrow", Font.PLAIN, 23));
		btnCancel.setBackground(new Color(204, 0, 51));
		btnCancel.setBounds(273, 438, 158, 47);
		contentPane.add(btnCancel);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setForeground(Color.WHITE);
		lblStudentId.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		lblStudentId.setBounds(86, 13, 95, 47);
		contentPane.add(lblStudentId);
		
		idtextField = new JTextField();
		idtextField.setEditable(false);
		idtextField.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		idtextField.setColumns(10);
		idtextField.setBounds(206, 25, 179, 31);
		contentPane.add(idtextField);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String a1=(String) comboBox.getSelectedItem();
				String query="Select * from Lecturer_Registered where Name='"+a1+"' ";
				
				try 
				{
					PreparedStatement pst= connection.prepareStatement(query);
					ResultSet rs= pst.executeQuery();
					
					if(rs.next())
					{
						textFieldLID.setText(rs.getString(2));
						
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
		});
		comboBox.setBounds(206, 338, 179, 31);
		contentPane.add(comboBox);
		
		JLabel lblLecturer = new JLabel("Lecturer:");
		lblLecturer.setForeground(Color.WHITE);
		lblLecturer.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		lblLecturer.setBounds(86, 328, 95, 47);
		contentPane.add(lblLecturer);
		
		JLabel lblLedId = new JLabel("Lecture ID:");
		lblLedId.setForeground(Color.WHITE);
		lblLedId.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		lblLedId.setBounds(86, 378, 95, 47);
		contentPane.add(lblLedId);
		
		textFieldLID = new JTextField();
		textFieldLID.setEditable(false);
		textFieldLID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		textFieldLID.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		textFieldLID.setColumns(10);
		textFieldLID.setBounds(206, 382, 179, 31);
		contentPane.add(textFieldLID);
		
		lblClabel = new CLabel();
		lblClabel.setLineBorder(3);
		lblClabel.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		lblClabel.setLineColor(new Color(0, 191, 255));
		lblClabel.setBackground(new Color(192, 192, 192));
		lblClabel.setForeground(new Color(255, 255, 255));
		lblClabel.setBounds(96, 73, 243, 242);
		//lblClabel.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/blur6.jpg")).getImage().getScaledInstance(lblClabel.getWidth(), lblClabel.getHeight(), Image.SCALE_SMOOTH)));
		contentPane.add(lblClabel);
		
		fillComboBox();
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setIcon();
	}
	
	public void fillComboBox() 
	{
		try {
			
			//String query = "Select * from Lecturer_Registered Where Status='0' ";
			String query = "Select * from Lecturer_Registered Where Kohout='"+Student_Search1.comboBox.getSelectedItem()+"'";
			//String query = "Select * from Lecturer_Registered Where Kohout='SEM@1/2'";
			//String query = "Select * from Lecturer_Registered ";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs =pst.executeQuery();
			
			while(rs.next()) 
			{
				comboBox.addItem(rs.getString("Name"));
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

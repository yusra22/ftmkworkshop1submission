package View;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.event.AncestorListener;

import Controller.documentController;
import Controller.lecturerController;
import Controller.studentController;
import Database2.Mysql;
import Model.Document;
import Model.Lecturer;
import Model.Student;

import javax.swing.event.AncestorEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.JPasswordField;

public class ProfileLec extends JFrame {

	private JPanel contentPane;
	public static JTextField textFieldID;
	public JTextField textFieldFullName;
	private JTextField textFieldPosition;
	private JTextField textFieldEmail;
	private JTextField textFieldContact;
	private ImageIcon format = null;
	public JLabel lblImageDisplay = new JLabel("   Upload Your Picture Here");
	int s=0;
	byte[] person_image=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		//JTattoo Design
        try {
            // select Look and Feel
             UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
		
		
        
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profile frame = new Profile();
					frame.setVisible(true);
					
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
	private JTextField textFieldPath;
	private JPasswordField comfirmpass;
	private JPasswordField newpass;
	private JPasswordField comfirmoldpass;
	private JPasswordField oldpass;

	/**
	 * Create the frame.
	 */
	public ProfileLec() {
		
		connection=Mysql.dbConnector();
		
		setBackground(new Color(112, 128, 144));
		setTitle("My Profile");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 921, 656);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(211, 211, 211));
		contentPane.setBackground(new Color(245, 245, 245));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(Color.DARK_GRAY);
		tabbedPane.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		tabbedPane.setBackground(new Color(245, 245, 245));
		tabbedPane.setBounds(12, 139, 879, 457);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBackground(new Color(245, 245, 245));
		tabbedPane.addTab("General", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblLecturerId = new JLabel("Lecturer ID:");
		lblLecturerId.setForeground(Color.BLACK);
		lblLecturerId.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblLecturerId.setBounds(27, 97, 97, 34);
		panel.add(lblLecturerId);
		
		JLabel lblFullName = new JLabel("Full Name:");
		lblFullName.setForeground(Color.BLACK);
		lblFullName.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblFullName.setBounds(27, 144, 97, 34);
		panel.add(lblFullName);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblEmail.setBounds(27, 238, 61, 34);
		panel.add(lblEmail);
		
		JLabel lblCourse = new JLabel("Position:");
		lblCourse.setForeground(Color.BLACK);
		lblCourse.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblCourse.setBounds(27, 191, 71, 34);
		panel.add(lblCourse);
		
		JLabel lblContact = new JLabel("Contact:");
		lblContact.setForeground(Color.BLACK);
		lblContact.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblContact.setBounds(27, 285, 71, 34);
		panel.add(lblContact);
		
		JLabel lblMyProfile_1 = new JLabel("My Profile");
		lblMyProfile_1.setForeground(Color.GRAY);
		lblMyProfile_1.setFont(new Font("Arial Narrow", Font.BOLD, 30));
		lblMyProfile_1.setBackground(Color.GRAY);
		lblMyProfile_1.setBounds(27, 31, 141, 53);
		panel.add(lblMyProfile_1);
		
		JPanel imagePanel = new JPanel();
		imagePanel.setBackground(new Color(255, 255, 255));
		imagePanel.setBounds(573, 39, 220, 221);
		panel.add(imagePanel);
		imagePanel.setLayout(null);
		
		lblImageDisplay = new JLabel("   Upload Your Picture Here");
		lblImageDisplay.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		lblImageDisplay.setBounds(0, 0, 220, 221);
		imagePanel.add(lblImageDisplay);
		
		JButton btnChangeProfilePicture = new JButton("Change profile picture");
		btnChangeProfilePicture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				uploadPicture();
				uploadLoad();
				
			}
		});
		btnChangeProfilePicture.setForeground(new Color(245, 245, 245));
		btnChangeProfilePicture.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		btnChangeProfilePicture.setBackground(new Color(0, 153, 153));
		btnChangeProfilePicture.setBounds(573, 261, 220, 45);
		panel.add(btnChangeProfilePicture);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//textFieldID.setForeground(new Color(255, 255, 255));
				//textFieldID.setEditable(true);
				//textFieldID.setBackground(new Color(105, 105, 105));
				
				textFieldFullName.setForeground(new Color(255, 255, 255));
				textFieldFullName.setEditable(true);
				textFieldFullName.setBackground(new Color(105, 105, 105));
				
				textFieldPosition.setForeground(new Color(255, 255, 255));
				textFieldPosition.setEditable(true);
				textFieldPosition.setBackground(new Color(105, 105, 105));
				
				
				textFieldEmail.setForeground(new Color(255, 255, 255));
				textFieldEmail.setEditable(true);
				textFieldEmail.setBackground(new Color(105, 105, 105));
				
				textFieldContact.setForeground(new Color(255, 255, 255));
				textFieldContact.setEditable(true);
				textFieldContact.setBackground(new Color(105, 105, 105));
				
			}
		});
		btnEdit.setForeground(Color.WHITE);
		btnEdit.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		btnEdit.setBackground(new Color(128, 128, 128));
		btnEdit.setBounds(493, 345, 158, 47);
		panel.add(btnEdit);
		
		JButton button_3 = new JButton("Save");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				updateDataLecturer_Registered();
				
				textFieldID.setForeground(new Color(0, 0, 0));
				textFieldID.setEditable(false);
				textFieldID.setBackground(new Color(245, 245, 245));
				
				textFieldFullName.setForeground(new Color(0, 0, 0));
				textFieldFullName.setEditable(false);
				textFieldFullName.setBackground(new Color(245, 245, 245));
				
				textFieldPosition.setForeground(new Color(0, 0, 0));
				textFieldPosition.setEditable(false);
				textFieldPosition.setBackground(new Color(245, 245, 245));
				
				
				textFieldEmail.setForeground(new Color(0, 0, 0));
				textFieldEmail.setEditable(false);
				textFieldEmail.setBackground(new Color(245, 245, 245));
				
				textFieldContact.setForeground(new Color(0, 0, 0));
				textFieldContact.setEditable(false);
				textFieldContact.setBackground(new Color(245, 245, 245));
				
			}
		});
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		button_3.setBackground(new Color(0, 153, 153));
		button_3.setBounds(690, 345, 158, 47);
		panel.add(button_3);
		
		textFieldID = new JTextField();
		textFieldID.setForeground(new Color(0, 0, 0));
		textFieldID.setEditable(false);
		textFieldID.setBackground(new Color(245, 245, 245));
		textFieldID.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		textFieldID.setBounds(161, 97, 292, 28);
		panel.add(textFieldID);
		textFieldID.setColumns(10);
		
		textFieldFullName = new JTextField();
		textFieldFullName.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
				
				reSelected();
				
			}
			public void ancestorMoved(AncestorEvent arg0) {
			}
			public void ancestorRemoved(AncestorEvent arg0) {
			}
		});
		textFieldFullName.setEditable(false);
		textFieldFullName.setForeground(new Color(0, 0, 0));
		textFieldFullName.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		textFieldFullName.setColumns(10);
		textFieldFullName.setBackground(new Color(245, 245, 245));
		textFieldFullName.setBounds(161, 147, 292, 28);
		panel.add(textFieldFullName);
		
		textFieldPosition = new JTextField();
		textFieldPosition.setEditable(false);
		textFieldPosition.setForeground(new Color(0, 0, 0));
		textFieldPosition.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		textFieldPosition.setColumns(10);
		textFieldPosition.setBackground(new Color(245, 245, 245));
		textFieldPosition.setBounds(161, 194, 292, 28);
		panel.add(textFieldPosition);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setEditable(false);
		textFieldEmail.setForeground(new Color(0, 0, 0));
		textFieldEmail.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		textFieldEmail.setColumns(10);
		textFieldEmail.setBackground(new Color(245, 245, 245));
		textFieldEmail.setBounds(161, 248, 292, 28);
		panel.add(textFieldEmail);
		
		textFieldContact = new JTextField();
		textFieldContact.setEditable(false);
		textFieldContact.setForeground(new Color(0, 0, 0));
		textFieldContact.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		textFieldContact.setColumns(10);
		textFieldContact.setBackground(new Color(245, 245, 245));
		textFieldContact.setBounds(161, 293, 292, 28);
		panel.add(textFieldContact);
		
		textFieldPath = new JTextField();
		textFieldPath.setForeground(Color.WHITE);
		textFieldPath.setColumns(10);
		textFieldPath.setBackground(Color.BLACK);
		textFieldPath.setBounds(583, 273, 208, 22);
		panel.add(textFieldPath);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(178, 34, 34));
		panel_1.setBackground(new Color(245, 245, 245));
		tabbedPane.addTab("Change Password", null, panel_1, null);
		panel_1.setLayout(null);
		
		comfirmpass = new JPasswordField();
		comfirmpass.setForeground(Color.BLACK);
		comfirmpass.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		comfirmpass.setBackground(new Color(220, 220, 220));
		comfirmpass.setBounds(387, 202, 292, 28);
		panel_1.add(comfirmpass);
		
		JLabel label = new JLabel("Comfirm New Password:");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		label.setBounds(185, 196, 196, 34);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("New Password:");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		label_1.setBounds(185, 148, 190, 34);
		panel_1.add(label_1);
		
		newpass = new JPasswordField();
		newpass.setForeground(Color.BLACK);
		newpass.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		newpass.setBackground(new Color(220, 220, 220));
		newpass.setBounds(387, 154, 292, 28);
		panel_1.add(newpass);
		
		comfirmoldpass = new JPasswordField();
		comfirmoldpass.setForeground(Color.BLACK);
		comfirmoldpass.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		comfirmoldpass.setBackground(new Color(220, 220, 220));
		comfirmoldpass.setBounds(387, 102, 292, 28);
		panel_1.add(comfirmoldpass);
		
		JLabel label_2 = new JLabel("Comfirm Old Password:");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		label_2.setBounds(185, 101, 190, 34);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("Old Password:");
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		label_3.setBounds(185, 56, 190, 34);
		panel_1.add(label_3);
		
		oldpass = new JPasswordField();
		oldpass.setForeground(Color.BLACK);
		oldpass.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		oldpass.setBackground(new Color(220, 220, 220));
		oldpass.setBounds(387, 57, 292, 28);
		panel_1.add(oldpass);
		
		JButton button = new JButton("Change");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String value1= oldpass.getText();
				String value2= comfirmoldpass.getText();
				String value3= newpass.getText();
				String value4= comfirmpass.getText();
				String value5= textFieldID.getText();
				
				try 
				{
					
					if(value1.equals(value2) && value3.equals(value4))
					{
						String sql = "update Lecturer_Registered set Password='"+value3+"' where Password='"+value1+"' AND Password='"+value2+"' AND LID='"+value5+"'";
						PreparedStatement pst = connection.prepareStatement(sql);
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "Password Update Success");
					}
			
					else 
					{
						JOptionPane.showMessageDialog(null, "Please check your password again");
					}
					
					
				}
				catch (Exception e5) 
				{
					JOptionPane.showMessageDialog(null, e5);
				}
				
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		button.setBackground(new Color(0, 153, 153));
		button.setBounds(298, 272, 158, 47);
		panel_1.add(button);
		
		JButton button_1 = new JButton("Clear");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				oldpass.setText("");
				comfirmoldpass.setText("");
				newpass.setText("");
				comfirmpass.setText("");
				
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		button_1.setBackground(Color.GRAY);
		button_1.setBounds(521, 272, 158, 47);
		panel_1.add(button_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new MatteBorder(0, 0, 10, 0, (Color) Color.LIGHT_GRAY));
		panel_3.setBackground(new Color(245, 245, 245));
		panel_3.setBounds(0, 0, 911, 122);
		contentPane.add(panel_3);
		
		JLabel lblProfile = new JLabel("PROFILE");
		lblProfile.setForeground(Color.GRAY);
		lblProfile.setFont(new Font("Arial Narrow", Font.BOLD, 30));
		lblProfile.setBackground(Color.GRAY);
		lblProfile.setBounds(379, 39, 111, 57);
		panel_3.add(lblProfile);
		
		JButton button_2 = new JButton("Back");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				String user = textFieldID.getText();
				Lecturer_Main lecmain = new Lecturer_Main();
				lecmain.lblYourName.setText(user);
				lecmain.setVisible(true);
				dispose();
				
			}
		});
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		button_2.setBackground(new Color(204, 0, 51));
		button_2.setBounds(12, 49, 158, 44);
		panel_3.add(button_2);
		
		setResizable(false);
		setLocationRelativeTo(null);
		setIcon();
	}
	
	public void updateDataLecturer_Registered() 
	{
		
		
		Lecturer lec = new Lecturer();
		lec.setLID(textFieldID.getText().trim());
		lec.setName(textFieldFullName.getText().trim());
		lec.setPosition(textFieldPosition.getText().trim());
		lec.setEmail(textFieldEmail.getText().trim());
		lec.setTelephone(textFieldContact.getText().trim());
		
		try 
		{
			lecturerController sCtrl = new lecturerController();
			sCtrl.updateLecturer(lec);
			
			JOptionPane.showMessageDialog(null, "Update Success!");
			
		} catch (Exception e) 
		{
			JOptionPane.showMessageDialog(null, "Update Error");
		}
		
		/*try 
		{
		String query = "update Student_Registered set SID=? , Name=?, Email=? where SID='"+textFieldID.getText()+"' ";
		
		PreparedStatement pst = connection.prepareStatement(query);
		
		pst.setString(1, textFieldID.getText());
		pst.setString(2, textFieldFullName.getText());
		pst.setString(3, textFieldEmail.getText());
		pst.execute();
		
		//ResultSet rs= pst.executeQuery();
		
		JOptionPane.showMessageDialog(null, "Update Success");
		
		pst.close();
		}
		catch (Exception e1) 
		{
			JOptionPane.showMessageDialog(null, "Update Error");
		}*/
	}
	
	public void uploadPicture() 
	{
		String filename =null;
		
		JFileChooser chooser = new JFileChooser();
		chooser.showOpenDialog(null);
		File f = chooser.getSelectedFile();
		filename = f.getAbsolutePath();
		textFieldPath.setText(filename);
		
		try 
		{
			File image = new File (filename);
			FileInputStream fis= new FileInputStream(image);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			for(int readNum; (readNum=fis.read(buf))!=-1;) 
			{
				bos.write(buf, 0, readNum);
				
			}
			person_image=bos.toByteArray();
			
		}
		catch(Exception e) 
		{
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	public void uploadLoad() 
	{
		
		
		Lecturer lecturer = new Lecturer();
		lecturer.setLID(textFieldID.getText());
		lecturer.setPerson_image(person_image);
		
		try 
		{
			lecturerController lCtrl = new lecturerController();
			lCtrl.updateLecturerProfile(lecturer);
			
			reSelected();
			
			JOptionPane.showMessageDialog(null, "Update Success!");
			
		} catch (Exception e2) 
		{
			JOptionPane.showMessageDialog(null, "Update Error");
		}
		
		
		/*try 
		{
			
		//String query = "update StudentInfo set SID=? , Name=?, Username=? , Document=? where SID='"+lblCardMatrik.getText()+"' ";
		String query = "update StudentInfo set SID=? , Image=? where SID='"+textFieldID.getText()+"' ";
		
		PreparedStatement pst = connection.prepareStatement(query);
		
		pst.setString(1, textFieldID.getText());
		//pst.setString(2, lblRealTime.getText());
		//pst.setString(3, lblNotGrated.getText());
		pst.setBytes(2, person_image);
		pst.execute();
		
		//ResultSet rs= pst.executeQuery();
		
		JOptionPane.showMessageDialog(null, "Update Success");
		
		pst.close();
		}
		catch (Exception e1) 
		{
			JOptionPane.showMessageDialog(null, "Update Error");
		}*/
		
	}
	
	public void reSelected() 
	{
		String a1= textFieldID.getText();
		String query="Select * from Lecturer_Registered where LID='"+a1+"' ";
		
		try 
		{
			PreparedStatement pst= connection.prepareStatement(query);
			ResultSet rs= pst.executeQuery();
			
			if(rs.next())
			{
				textFieldFullName.setText(rs.getString(3));
				textFieldEmail.setText(rs.getString(6));
				textFieldPosition.setText(rs.getString(9));
				textFieldContact.setText(rs.getString(10));
				
				//For Display Image
				byte[] imagedata = rs.getBytes("image");
				format = new ImageIcon(imagedata);
				lblImageDisplay.setIcon(format);
				lblImageDisplay.setIcon(new ImageIcon(new javax.swing.ImageIcon(imagedata).getImage().getScaledInstance(lblImageDisplay.getWidth(), lblImageDisplay.getHeight(), Image.SCALE_SMOOTH)));
					
				
				rs.close();
				pst.close();
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "Incorrect Username");
			}
		} catch (Exception e) 
		{
			//JOptionPane.showMessageDialog(null, e);
		}
	}
	
	private void setIcon() 
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/FTMK logo.png")));
	}
	
}

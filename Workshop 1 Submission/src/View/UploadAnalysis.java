package View;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.event.AncestorListener;

import com.sbix.jnotify.NPosition;
import com.sbix.jnotify.NoticeType;
import com.sbix.jnotify.NoticeWindow;

import Controller.documentController;
import Controller.studentController;
import Database2.Mysql;
import Model.Document;

import javax.swing.event.AncestorEvent;

public class UploadAnalysis extends JFrame {

	private JPanel contentPane;
	
	
	

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
					UploadAnalysis frame = new UploadAnalysis();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection = null;
	
	private ImageIcon format = null;
	String filename =null;
	int s=0;
	byte[] person_image=null;
	private JTextField idField;
	private JTextField fullnameField;
	private JTextField usernameField;
	private JTextField textFieldPath;
	public static JLabel lblCardMatrik = new JLabel();
	public JLabel lblClock2 = new JLabel("Real TIme");
	private JLabel lblTime;
	public JLabel lblFile = new JLabel("Not Sent yet");
	public JButton button;
	
	public InputStream input = null;
	public FileOutputStream output = null;
	public int k = 1;

	/**
	 * Create the frame.
	 */
	
	
	
	public UploadAnalysis() {
		
		connection=Mysql.dbConnector();
		
		setBackground(new Color(211, 211, 211));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 930, 660);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 245));
		contentPane.setBorder(new LineBorder(Color.LIGHT_GRAY));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 911, 122);
		panel.setBorder(new MatteBorder(0, 0, 10, 0, (Color) Color.LIGHT_GRAY));
		panel.setBackground(new Color(245, 245, 245));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblUploadProposal = new JLabel("FILE UPLOAD");
		lblUploadProposal.setBackground(new Color(128, 128, 128));
		lblUploadProposal.setFont(new Font("Arial Narrow", Font.BOLD, 30));
		lblUploadProposal.setForeground(new Color(128, 128, 128));
		lblUploadProposal.setBounds(349, 25, 211, 84);
		panel.add(lblUploadProposal);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(54, 167, 413, 330);
		panel_1.setBorder(new LineBorder(new Color(192, 192, 192), 4, true));
		panel_1.setBackground(new Color(245, 245, 245));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblImageUpload = new JLabel("");
		Image uploadlogo = new ImageIcon(this.getClass().getResource("/upload1.png")).getImage();
		lblImageUpload.setIcon(new ImageIcon(uploadlogo));
		lblImageUpload.setBounds(129, 58, 161, 198);
		panel_1.add(lblImageUpload);
		
		JLabel lblNewLabel = new JLabel("UPLOAD YOUR FILE HERE");
		lblNewLabel.setForeground(new Color(128, 128, 128));
		lblNewLabel.setFont(new Font("Arial Narrow", Font.PLAIN, 25));
		lblNewLabel.setBounds(71, 249, 274, 51);
		panel_1.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("BROWSE FILE");
		btnNewButton.setBounds(54, 494, 413, 65);
		btnNewButton.setBackground(new Color(0, 153, 153));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
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
		});
		btnNewButton.setForeground(new Color(245, 245, 245));
		btnNewButton.setFont(new Font("Arial Narrow", Font.PLAIN, 25));
		contentPane.add(btnNewButton);
		
		JLabel lblSubmissionStatus = new JLabel("Student ID:");
		lblSubmissionStatus.setBounds(520, 258, 97, 34);
		lblSubmissionStatus.setForeground(new Color(0, 0, 0));
		lblSubmissionStatus.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		contentPane.add(lblSubmissionStatus);
		
		JLabel lblGrandingStatus = new JLabel("File Submission:");
		lblGrandingStatus.setBounds(520, 352, 154, 34);
		lblGrandingStatus.setForeground(Color.BLACK);
		lblGrandingStatus.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		contentPane.add(lblGrandingStatus);
		lblCardMatrik.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				
				refreshSelect();
				
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		
		//JLabel lblCardMatrik = new JLabel("111111");
		lblCardMatrik.setBounds(629, 258, 117, 34);
		lblCardMatrik.setForeground(Color.BLACK);
		lblCardMatrik.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		contentPane.add(lblCardMatrik);
		
		JLabel lblTimeUpload = new JLabel("Time Upload:");
		lblTimeUpload.setBounds(520, 305, 109, 34);
		lblTimeUpload.setForeground(Color.BLACK);
		lblTimeUpload.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		contentPane.add(lblTimeUpload);
		
		lblTime = new JLabel("Real TIme");
		lblTime.setBounds(629, 305, 188, 34);
		lblTime.setForeground(Color.BLACK);
		lblTime.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		contentPane.add(lblTime);
		clock();
		
		JButton btnSubmit = new JButton("Save");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Document document = new Document();
				document.setSID(lblCardMatrik.getText());
				document.setPROPOSAL(person_image);
				document.setPtime(lblClock2.getText());
				
				try 
				{
					documentController dCtrl = new documentController();
					dCtrl.analysis(document);
					
					JOptionPane.showMessageDialog(null, "Update Success!");
					refreshSelect();
					
					button.setEnabled(true);
					
				} catch (Exception e2) 
				{
					JOptionPane.showMessageDialog(null, "Update Error");
				}
				
				/*try 
				{
				//String query = "update StudentInfo set SID=? , Name=?, Username=? , Document=? where SID='"+lblCardMatrik.getText()+"' ";
				
					
				String query = "update Document set SID=? , Proposal=? where SID='"+lblCardMatrik.getText()+"' ";
				
				PreparedStatement pst = connection.prepareStatement(query);
				
				pst.setString(1, lblCardMatrik.getText());
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
		});
		btnSubmit.setBounds(520, 503, 158, 47);
		btnSubmit.setForeground(Color.WHITE);
		btnSubmit.setFont(new Font("Arial Narrow", Font.PLAIN, 23));
		btnSubmit.setBackground(new Color(0, 153, 153));
		contentPane.add(btnSubmit);
		
		JButton btnCancel = new JButton("Back");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String user = lblCardMatrik.getText();
				Student_Main studentmain = new Student_Main();
				studentmain.lblYourName.setText(user);
				studentmain.setVisible(true);
				dispose();
				
			}
		});
		btnCancel.setBounds(717, 504, 158, 44);
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Arial Narrow", Font.PLAIN, 23));
		btnCancel.setBackground(new Color(204, 0, 51));
		contentPane.add(btnCancel);
		

		
		JLabel lblProposal = new JLabel("ANALYSIS");
		lblProposal.setForeground(Color.GRAY);
		lblProposal.setFont(new Font("Arial Narrow", Font.BOLD, 30));
		lblProposal.setBackground(Color.GRAY);
		lblProposal.setBounds(520, 161, 145, 65);
		contentPane.add(lblProposal);
		
		lblClock2 = new JLabel("Real TIme");
		lblClock2.setBounds(0, 0, 117, 34);
		contentPane.add(lblClock2);
		lblClock2.setForeground(Color.BLACK);
		lblClock2.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		
		textFieldPath = new JTextField();
		textFieldPath.setBounds(64, 495, 401, 22);
		contentPane.add(textFieldPath);
		textFieldPath.setForeground(Color.WHITE);
		textFieldPath.setBackground(Color.BLACK);
		textFieldPath.setColumns(10);
		
		button = new JButton("Download");
		button.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
				
				String a1= lblCardMatrik.getText();
				String query2 ="Select Analysis from Document where SID='"+a1+"'";
				
				
				try 
				{
					PreparedStatement pst= connection.prepareStatement(query2);
					ResultSet rs= pst.executeQuery();
				
					rs.next() ;
					
					String checkDatabase = rs.getString(1);
					//System.out.println(rs.getString(1));
					
					
					if(checkDatabase == null)
					{	
						button.setEnabled(false);
						//System.out.println("This is null and dont have no value");
					}
					else 
					{
						button.setEnabled(true);
						//System.out.println("This has values");
					
					}
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
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try 
				{
					String a1= lblCardMatrik.getText();
					String query2 ="Select Analysis from Document where SID='"+a1+"'";
					PreparedStatement pst2= connection.prepareStatement(query2);
					
					ResultSet rs= pst2.executeQuery(query2);
					
					Random dice = new Random();
					int number = 0;
					
					for(int counter=1;counter<=10;counter++)
					{
						number= 1+dice.nextInt(30);
						System.out.println(number + " ");
					}
					
					
					File theFile = new File("Analysis "+a1+"("+number+")"+".pdf");
					output = new FileOutputStream(theFile);
					
					if(rs.next()) 
					{
						input = rs.getBinaryStream("Analysis");
						System.out.println("Reading from database....");
						System.out.println(query2);
						
						byte[] buffer = new byte[1024];
						while (input.read(buffer) > 0) 
						{
							output.write(buffer);
						}
						
						System.out.println("\nSaved to file:" + theFile.getAbsolutePath());
						
						new NoticeWindow("\nSaved to file:" + theFile.getAbsolutePath(), NPosition.BOTTOM_RIGHT);
					}
					
					rs.close();
					pst2.close();
					//connection.close();
					
				} 
				catch (SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					new NoticeWindow(NoticeType.ERROR_NOTIFICATION,"File cannot be download",NoticeWindow.LONG_DELAY, NPosition.BOTTOM_RIGHT);
				} finally 
				{
					if (input !=null) 
					{
						try {
							input.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					if(output != null) 
					{
						try {
							output.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				
			}
		});
		button.setForeground(new Color(255, 255, 255));
		button.setBackground(new Color(0, 0, 0));
		button.setEnabled(false);
		button.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		button.setBounds(662, 353, 117, 32);
		contentPane.add(button);
		
		setResizable(false);
		setLocationRelativeTo(null);
		setIcon();
	}
	
	//buat function or method untuk restart
	public void refreshSelect() 
	{
		String a1= lblCardMatrik.getText();
		String query="Select * from Document where SID='"+a1+"' ";

		try 
		{
			PreparedStatement pst= connection.prepareStatement(query);
			ResultSet rs= pst.executeQuery();
			
			if(rs.next())
			{
				lblCardMatrik.setText(rs.getString(2));
				//byte[] person_image = rs.getBytes(3);
				lblTime.setText(rs.getString(6));
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
		}
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
					
					lblClock2.setText(year +"/"+ month + "/" + day + "," + hour +":"+ minutes +":"+ second + " " + day_night); 
					
					
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

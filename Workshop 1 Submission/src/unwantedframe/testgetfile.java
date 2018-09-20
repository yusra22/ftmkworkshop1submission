package unwantedframe;

import java.awt.BorderLayout;
import java.io.InputStream;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Database2.Mysql;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.sound.sampled.AudioInputStream;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

import java.io.*;
import com.sun.speech.freetts.*;
import com.sun.speech.freetts.audio.AudioPlayer;

public class testgetfile extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testgetfile frame = new testgetfile();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection = null;
	public InputStream input = null;
	public FileOutputStream output = null;
	public int k;
	private JTextField readfield;
	private static final String VOICENAME = "kevin16";
	/**
	 * Create the frame.
	 */
	public testgetfile() {
		
		connection=Mysql.dbConnector();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDownloadHere = new JLabel("Download Here");
		lblDownloadHere.setBounds(139, 34, 100, 16);
		contentPane.add(lblDownloadHere);
		
		JButton btnClickMe = new JButton("Click Me");
		btnClickMe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try 
				{
					String query2 ="Select Proposal from Document where SID='B031710085'";
					PreparedStatement pst2= connection.prepareStatement(query2);
					
					ResultSet rs= pst2.executeQuery(query2);
					
					//for(k=1;k<=12;k++)
					File theFile = new File("Filetest"+k+".pdf");
					output = new FileOutputStream(theFile);
					
					
					if(rs.next()) 
					{
						input = rs.getBinaryStream("proposal");
						System.out.println("Reading from database....");
						System.out.println(query2);
						
						byte[] buffer = new byte[1024];
						while (input.read(buffer) > 0) 
						{
							output.write(buffer);
						}
						
						System.out.println("\nSaved to file:" + theFile.getAbsolutePath());
						System.out.println("\nCompleted successfully!");
					}
					
					
					rs.close();
					pst2.close();
					connection.close();
					
				} 
				catch (SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
		btnClickMe.setBounds(139, 63, 97, 25);
		contentPane.add(btnClickMe);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String query = "Select Count(id) AS ID2 FROM Document";
				try {
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					
					if(rs.next()) 
					{
						String sum = rs.getString("ID2");
						lblNewLabel.setText(sum);
						System.out.println(sum);
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		lblNewLabel.setBounds(139, 129, 112, 33);
		contentPane.add(lblNewLabel);
		
		readfield = new JTextField();
		readfield.setText("WELCOME B031710085");
		readfield.setBounds(51, 176, 116, 22);
		contentPane.add(readfield);
		readfield.setColumns(10);
		
		JButton btnread = new JButton("Read");
		btnread.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				System.setProperty("mbrola.base","C:\\Users\\Yusara\\Desktop\\mbrola");
				Voice voice;
				VoiceManager vm = VoiceManager.getInstance();
				//voice=vm.getVoice("mbrola_us1");
				voice=vm.getVoice(VOICENAME);
				
				voice.allocate();
				
				try 
				{
					voice.speak(readfield.getText());
				} 
				catch(Exception e) 
				{
					
				}
				
			}
		});
		btnread.setBounds(203, 175, 97, 25);
		contentPane.add(btnread);
		
		JButton btnSound = new JButton("Play");
		btnSound.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				InputStream in;
				AudioInputStream BGM;
				
				
			}
		});
		btnSound.setBounds(203, 133, 97, 25);
		contentPane.add(btnSound);
	}
}

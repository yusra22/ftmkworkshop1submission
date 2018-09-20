package View;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.LineBorder;

import Database2.Mysql;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;

public class Splash_Screen extends JFrame {

	private JPanel contentPane;
	int s=0;
	Thread th;
	JProgressBar progressBar = new JProgressBar();
	
	/**
	 * Launch the application.
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		
		
		//JTattoo Design
        try {
            // select Look and Feel
             UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
             
             
            
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
		
		Splash_Screen frame = new Splash_Screen();
		 frame.setUndecorated(true);
		 

		for(int i = 0; i <= 100; i++) 
		{
			Thread.sleep(30);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			frame.progressBar.setValue(i);
			
			if(i==100)
			{
				Login login = new Login();
				login.setVisible(true);
				frame.dispose();
			}
		}
		
		EventQueue.invokeLater(new Runnable()
		{
	 		public void run() {
				try {
					
					

					
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
	public Splash_Screen() {
		
		connection = Mysql.dbConnector();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 506, 555);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLoading = new JLabel("STARTING SYSTEM");
		lblLoading.setForeground(Color.BLACK);
		lblLoading.setFont(new Font("Arial Narrow", Font.BOLD, 30));
		lblLoading.setBounds(120, 13, 233, 66);
		contentPane.add(lblLoading);
		
		
		JLabel lblPic = new JLabel(new ImageIcon(this.getClass().getResource("/gif3.gif")));
		//Image pic = new ImageIcon(this.getClass().getResource("/loading2.gif")).getImage();
		//lblPic.setIcon(new ImageIcon(pic));
		lblPic.setBounds(12, 65, 464, 354);
		contentPane.add(lblPic);
		progressBar.setForeground(Color.CYAN);
		

		progressBar.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		progressBar.setStringPainted(true);
		progressBar.setBounds(33, 432, 413, 43);
		contentPane.add(progressBar);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 511, 537);
		//label.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/blur4.jpg")).getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH)));
		contentPane.add(label);

		setIcon();
		//setUndecorated(true);
		setResizable(false);
		setLocationRelativeTo(null);
		
	}
	
	
	private void setIcon() 
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/FTMK logo.png")));
	}
		
		
		
		
}	


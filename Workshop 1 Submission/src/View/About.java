package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class About extends JFrame {

	private JPanel contentPane;
	JLabel label;

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
					About frame = new About();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public About() {
		setTitle("About");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 771, 428);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblpic = new JLabel("New label");
		lblpic.setBounds(26, 87, 254, 96);
		lblpic.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/FTMK logo.png")).getImage().getScaledInstance(lblpic.getWidth(), lblpic.getHeight(), Image.SCALE_SMOOTH)));
		contentPane.add(lblpic);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(22, 240, 254, 103);
		lblNewLabel.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/utem.png")).getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH)));
		contentPane.add(lblNewLabel);
		
		JLabel lblWorkshopAuto = new JLabel("Workshop 1: Auto Report & Submission");
		lblWorkshopAuto.setBackground(Color.BLACK);
		lblWorkshopAuto.setForeground(Color.DARK_GRAY);
		lblWorkshopAuto.setFont(new Font("Arial Narrow", Font.BOLD, 25));
		lblWorkshopAuto.setBounds(322, 62, 417, 47);
		contentPane.add(lblWorkshopAuto);
		
		JLabel lblVersion = new JLabel("Version 1.0");
		lblVersion.setForeground(Color.DARK_GRAY);
		lblVersion.setFont(new Font("Arial Narrow", Font.BOLD, 22));
		lblVersion.setBackground(Color.BLACK);
		lblVersion.setBounds(470, 99, 105, 47);
		contentPane.add(lblVersion);
		
		JLabel lblCopyright = new JLabel("Copyright @2018");
		lblCopyright.setForeground(Color.DARK_GRAY);
		lblCopyright.setFont(new Font("Arial Narrow", Font.BOLD, 22));
		lblCopyright.setBackground(Color.BLACK);
		lblCopyright.setBounds(450, 137, 171, 47);
		contentPane.add(lblCopyright);
		
		JLabel lblContact = new JLabel("Contact - eftmk.utem.edu.my");
		lblContact.setForeground(Color.DARK_GRAY);
		lblContact.setFont(new Font("Arial Narrow", Font.BOLD, 19));
		lblContact.setBackground(Color.BLACK);
		lblContact.setBounds(411, 214, 254, 47);
		contentPane.add(lblContact);
		
		JLabel lblFacebook = new JLabel("Facebook - facebook.com/MyUTeM/");
		lblFacebook.setForeground(Color.DARK_GRAY);
		lblFacebook.setFont(new Font("Arial Narrow", Font.BOLD, 19));
		lblFacebook.setBackground(Color.BLACK);
		lblFacebook.setBounds(390, 260, 270, 47);
		contentPane.add(lblFacebook);
		
		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String user = label.getText();
				Student_Main stud = new Student_Main();
				stud.lblYourName.setText(user);
				stud.setVisible(true);
				dispose();
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Arial Narrow", Font.PLAIN, 23));
		button.setBackground(new Color(204, 0, 51));
		button.setBounds(450, 331, 158, 44);
		contentPane.add(button);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(0, 0, 765, 407);
		lblNewLabel_1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/blur3.jpg")).getImage().getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(), Image.SCALE_SMOOTH)));
		contentPane.add(lblNewLabel_1);
		
		label = new JLabel("");
		label.setBounds(22, 13, 185, 22);
		contentPane.add(label);
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		setIcon();
	}
	
	private void setIcon() 
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/FTMK logo.png")));
	}
}

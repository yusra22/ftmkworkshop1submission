package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;

import Database2.Mysql;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class Test_Chart extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test_Chart frame = new Test_Chart();
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
	
	Connection connection = null;
	
	public Test_Chart() {
		
		connection=Mysql.dbConnector();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnChart = new JButton("Chart");
		btnChart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
/*				try 
				{
					String query= "select Proposal,Analysis from Document";
					JDBCCategoryDataset dataset = new JDBCCategoryDataset(Mysql.dbConnector(),query);
					JFreeChart chart = ChartFactory.createBarChart3D("Query chart", "proposal", "analysis", dataset, PlotOrientation.VERTICAL, false, true, false);
					BarRenderer renderer = null;
					CategoryPlot plot = null;
					renderer=new BarRenderer();
					ChartFrame frame = new ChartFrame("Query Chart",chart);
					frame.setVisible(true);
					frame.setSize(450,350);
					
				} 
				catch (Exception e1) 
				{
					
				}*/
				
				
				
				DefaultCategoryDataset dataset = new DefaultCategoryDataset();
				dataset.setValue(80, "Marks", "Student1");
				dataset.setValue(50, "Marks", "Student2");
				dataset.setValue(90, "Marks", "Student3");
				dataset.setValue(95, "Marks", "Student4");
				
				JFreeChart chart = ChartFactory.createBarChart3D("Student Score", "Student Name", "Marks", 
						dataset, PlotOrientation.VERTICAL, false, true, false);
				chart.setBackgroundPaint(Color.white);
				chart.getTitle().setPaint(Color.blue);
				CategoryPlot p = chart.getCategoryPlot();
				p.setRangeGridlinePaint(Color.BLACK);
				ChartFrame frame = new ChartFrame("Bar Chart for student",chart);
				frame.setVisible(true);
				frame.setSize(450,350);
				
				
				
			}
		});
		btnChart.setBounds(46, 40, 97, 25);
		contentPane.add(btnChart);
	}
}

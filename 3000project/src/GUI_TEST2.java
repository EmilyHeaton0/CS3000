import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.JScrollPane;

public class GUI_TEST2 {

	private JFrame frame;
	
	private Color accent1;
	private Color accent2;
	private Color accent3;
	
	private JPanel Center;
	private JPanel North;
	private JPanel South;
	
	private JLabel lblIpaddress;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_TEST2 window = new GUI_TEST2();
					window.getFrame().setVisible(true);
					window.temp();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GUI_TEST2() {
		initialize();
	}

	private void initialize() {
		
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 1100, 800);  //something, something, width, height
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(new BorderLayout(0, 0));
		
		North = new JPanel();
		frame.add(North, BorderLayout.NORTH);
		FlowLayout NorthLayout= new FlowLayout(0,0,0);
		North.setLayout(NorthLayout);
		
		Center = new JPanel();
		frame.add(Center, BorderLayout.CENTER);
		FlowLayout CenterLayout= new FlowLayout();
		Center.setLayout(CenterLayout);
		
		lblIpaddress = new JLabel("IPAddress");
		North.add(lblIpaddress);
		
		South= new JPanel();
		frame.add(South, BorderLayout.SOUTH);
		
	}
		
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame f) {
		frame = f;
	}
	
	public void setThemeColors(Color a1, Color a2, Color a3) {
		accent1=a1;
		accent2=a2;
		accent3=a3;
	}
	
	public void temp() {	
		Color BlueTheme = new Color(0,80,255);
		Color OrangeTheme= new Color(255,111,0);
		Color RedTheme= new Color(255,0,0);
		Color PurpleTheme= new Color(118,0,62);
		Color White= new Color(255,255,255);
		
		setThemeColors(BlueTheme,BlueTheme,White);
		setTheme();
	}
	
	public void setTheme() {
		Center.setBackground(accent3);
		North.setBackground(accent1);
		South.setBackground(accent1);
		lblIpaddress.setForeground(accent3);	
	}
	
}

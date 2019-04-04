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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_TEST2 window = new GUI_TEST2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI_TEST2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel Center = new JPanel();
		frame.getContentPane().add(Center, BorderLayout.CENTER);
		FlowLayout CenterLayout= new FlowLayout();
		Center.setLayout(CenterLayout);
		JScrollPane scrollPane = new JScrollPane();
		Center.add(scrollPane);
		
		JPanel North = new JPanel();
		frame.getContentPane().add(North, BorderLayout.NORTH);
		FlowLayout NorthLayout= new FlowLayout(0,0,0);
		North.setLayout(NorthLayout);
		
		JToolBar Palette = new JToolBar();
		Dimension PaletteDimension= new Dimension(30,30);
		North.add(Palette);
		
		
		ActionListener ThemeChanger = new ActionListener() {
			public void actionPerformed(ActionEvent ColorEvent) {
				UpdateTheme(ColorEvent);
		    }
		};	
		
		Button Blue= new Button("");
		Color BlueTheme = new Color(0,80,255);
		Blue.setBackground(BlueTheme);
		Blue.setPreferredSize(PaletteDimension);
		Blue.setActionCommand("blue");
		Blue.addActionListener(ThemeChanger);
		Palette.add(Blue);
		
		Button Green= new Button("");
		Color GreenTheme= new Color(48,255,125);
		Green.setBackground(GreenTheme);
		Green.setPreferredSize(PaletteDimension);
		Green.setActionCommand("green");
		Green.addActionListener(ThemeChanger);
		Palette.add(Green);
		
		Button Orange= new Button("");
		Color OrangeTheme= new Color(255,111,0);
		Orange.setBackground(OrangeTheme);
		Orange.setPreferredSize(PaletteDimension);
		Orange.setActionCommand("orange");
		Orange.addActionListener(ThemeChanger);
		Palette.add(Orange);
		
		Button Red= new Button("");
		Color RedTheme= new Color(255,0,0);
		Red.setBackground(RedTheme);
		Red.setPreferredSize(PaletteDimension);
		Red.setActionCommand("red");
		Red.addActionListener(ThemeChanger);
		Palette.add(Red);
		
		JLabel lblIpaddress = new JLabel("IPAddress");
		North.add(lblIpaddress);
		
		JPanel South= new JPanel();
		frame.getContentPane().add(South, BorderLayout.SOUTH);
		
	}
	
	public void UpdateTheme(ActionEvent b) {
		String command= b.getActionCommand();
		if(b.equals("blue")) {
			
		}else if(b.equals("green")) {
			
		}else if(b.equals("orange")) {
			
		}else if(b.equals("red")) {
			
		}
	}

}

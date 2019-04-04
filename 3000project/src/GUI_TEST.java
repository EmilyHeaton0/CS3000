import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class GUI_TEST {
	
	private Connector connection;

	private JFrame frame;
	private JTextField textField;
	private JLabel label;
	private JTextField textField_1;
	private JLabel label_1;
	private JTextField textField_2;
	private JLabel lblEnterIpAddress;
	private Button submit;
	private JLabel error;
	private JLabel label_2;
	private JTextField textField_3;
	
	private Color accent1;
	private Color accent2;
	private Color accent3;
	
	private JLabel Title;
	private JLabel Title2;
	
	private JPanel Level2North;
	private JPanel Level2Center;
	private JPanel Level2South;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_TEST window = new GUI_TEST();
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
	public GUI_TEST() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//Formatted text fields?
		
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 700);   //something, something, width, height
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BorderLayout Level1= new BorderLayout();
		frame.getContentPane().setLayout(Level1);
		
		Level2Center = new JPanel();
		frame.add(Level2Center, BorderLayout.CENTER);
		
		Level2North= new JPanel();
		frame.add(Level2North, BorderLayout.NORTH);
		
		GridLayout Level2NorthLayout = new GridLayout(3,1,0,15);
		Level2North.setLayout(Level2NorthLayout);
		
		Title= new JLabel("         Hello, Welcome to Our Server!!");
		Title2= new JLabel("         Please enter an IPv4 Address Below");

		Font TitleFont= new Font("TitleFont",10,30);
		
		Title.setPreferredSize(new Dimension(50,50));
		Title2.setPreferredSize(new Dimension(50,50));
		Title.setFont(TitleFont);
		Title2.setFont(TitleFont);
		
		Level2North.add(Title);
		Level2North.add(Title2);
		
		FlowLayout Level2CenterLayout = new FlowLayout(0,10,150);
		Level2Center.setLayout(Level2CenterLayout);
		
		Dimension textFieldDimen= new Dimension(50,50);
		Font LabelFont= new Font("LabelFont",10,20);
		Font PointFont= new Font("PointFont",10,50);
		
		lblEnterIpAddress = new JLabel("Enter IP address:");
		lblEnterIpAddress.setPreferredSize(new Dimension(165,50));
		lblEnterIpAddress.setFont(LabelFont);
		Level2Center.add(lblEnterIpAddress);
		
		textField_1 = new JTextField();
		textField_1.setColumns(3);
		textField_1.setPreferredSize(textFieldDimen);
		textField_1.setFont(LabelFont);
		Level2Center.add(textField_1);

		label = new JLabel(".");
		label.setFont(PointFont);
		Level2Center.add(label);
		
		textField_2 = new JTextField();
		textField_2.setColumns(3);
		textField_2.setPreferredSize(textFieldDimen);
		textField_2.setFont(LabelFont);
		Level2Center.add(textField_2);

		label_1 = new JLabel(".");
		label_1.setFont(PointFont);
		Level2Center.add(label_1);
		
		textField = new JTextField();
		textField.setColumns(3);
		textField.setPreferredSize(textFieldDimen);
		textField.setFont(LabelFont);
		Level2Center.add(textField);
		
		label_2 = new JLabel(".");
		label_2.setFont(PointFont);
		Level2Center.add(label_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(3);
		textField_3.setPreferredSize(textFieldDimen);
		textField_3.setFont(LabelFont);
		Level2Center.add(textField_3);
		
	    ActionListener actionListener = new ActionListener() {
	        public void actionPerformed(ActionEvent actionEvent) {
	          Connect2Server(actionEvent);
	        }
	      };
		
		submit= new Button("Connect");
		submit.setPreferredSize(new Dimension(100,50));
		submit.setFont(LabelFont);
		submit.setActionCommand("connect");
		submit.addActionListener(actionListener);
		Level2Center.add(submit);
		
		error= new JLabel("");
		error.setPreferredSize(new Dimension(300,100));
		error.setFont(LabelFont);
		Level2Center.add(error);
		
		
		Level2South= new JPanel();   
		frame.add(Level2South,BorderLayout.SOUTH);
		FlowLayout Level2SouthLayout= new FlowLayout(0,0,0);
		Level2South.setLayout(Level2SouthLayout);

		
		JToolBar Palette= new JToolBar();
		Dimension PaletteDimension= new Dimension(30,30);
		Level2South.add(Palette);
		
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
		
	}
	
	public void Connect2Server(ActionEvent a) {
		String command = a.getActionCommand();
		if(command.equals("connect")) {
			String one= textField_1.getText();
			String two= textField_2.getText();
			String three= textField.getText();
			String four= textField_3.getText();
			String ipAddress= (one+"."+two+"."+three+"."+four);
			if(Validate(one) && Validate(two) && Validate(three) && Validate(four)) {
				connection= new Connector(ipAddress,11000);
			}
			else {
				error.setText("Invalid Address");
			}
		}		
	}
	
	public void UpdateTheme(ActionEvent b) {
		String command= b.getActionCommand();
		if(command.equals("blue")) {
			accent1= new Color(0,80,255);
			accent2= new Color(0,80,255);
			accent3= new Color(255,255,255);
		}else if(command.equals("green")) {
			accent1= new Color(48,255,125);
			accent2= new Color(48,255,125);
			accent3= new Color(255,255,255);
		}else if(command.equals("orange")) {
			accent1= new Color(255,111,0);
			accent2= new Color(255,111,0);
			accent3= new Color(255,255,255);
		}else if(command.equals("red")) {
			accent1= new Color(255,0,0);
			accent2= new Color(255,0,0);
			accent3= new Color(255,255,255);
		}
		Level2Center.setBackground(accent1);
		Level2North.setBackground(accent1);
		Level2South.setBackground(accent1);
		label_1.setForeground(accent3);
		label.setForeground(accent3);
		label_2.setForeground(accent3);
		Title.setForeground(accent3);
		Title2.setForeground(accent3);
		submit.setBackground(accent3);
		submit.setForeground(accent1);
		lblEnterIpAddress.setForeground(accent3);
		error.setForeground(accent3);
		textField.setForeground(accent1);
		textField_1.setForeground(accent1);
		textField_2.setForeground(accent1);
	}
	
	public boolean Validate(String num) {
		String[] badChars= {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t",
		"u","v","w","x","y","z","!","@","#","$","%","^","&","*","(",")",".","/","+","{","}","+","-","_"};
		if(num.length()==0) {
			return false;
		}
		for(int i=0; i<badChars.length; i++) {
			if(num.contains(badChars[i])) {
				return false;
			}
		}
		int check= Integer.parseInt(num);
		if(check>-1 && check<256) {
			return true;
		}
		return false;
	}

}

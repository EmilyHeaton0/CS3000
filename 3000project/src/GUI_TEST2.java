import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI_TEST2 {
	
	private JFrame frame;
	
	private Color accent1; //header, footer colors
	private Color accent2; //received messages
	private Color accent3; //sent messages
	private Color accent4; //text color, center background
	
	private JPanel Center;
	private JPanel North;
	private JPanel South;
	
	//private JLabel lblIpaddress;
	private RTextField enterText;
	private JButton send;
	private JButton save;
	
	//private ArrayList<JLabel> conversation;
	
	private JLabel[] conversation;
	private int messageNUM;

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
		
	    ActionListener actionListener2 = new ActionListener() {
	        public void actionPerformed(ActionEvent actionEvent) {
	          SaveButton(actionEvent);
	        }
	    };
		
		save= new JButton("Save");
		save.setPreferredSize(new Dimension(105,50));	//width, height
		save.setFont(new Font("Save_Font",30,30));		//name, style, size
		save.setBorderPainted(false);
		save.setActionCommand("send");
		save.addActionListener(actionListener2);
		North.add(save);
		
		//lblIpaddress = new JLabel("IPAddress");
		//North.add(lblIpaddress);
		
		Center = new JPanel();
		frame.add(Center, BorderLayout.CENTER);
		FlowLayout CenterLayout= new FlowLayout();
		Center.setLayout(CenterLayout);
		
		conversation= new JLabel[100];
		for(int i=0; i<conversation.length; i++) {
			conversation[i]= new JLabel("");
			Center.add(conversation[i]);
		}
		messageNUM=0;
		
		South= new JPanel();
		frame.add(South, BorderLayout.SOUTH);
		FlowLayout SouthLayout= new FlowLayout(0,5,10);
		South.setLayout(SouthLayout);
		
		enterText= new RTextField(38);
		enterText.setPreferredSize(new Dimension(0,50));
		enterText.setFont(new Font("enterText_Font",30,30));
		South.add(enterText);
		
	    ActionListener actionListener = new ActionListener() {
	        public void actionPerformed(ActionEvent actionEvent) {
	          SendMessage(actionEvent);
	        }
	    };
			
		send= new JButton("Send");
		send.setPreferredSize(new Dimension(105,50));	//width, height
		send.setFont(new Font("Send_Font",30,30));		//name, style, size
		send.setBorderPainted(false);
		send.setActionCommand("send");
		send.addActionListener(actionListener);
		South.add(send);    
	}
	
	public void SendMessage(ActionEvent a) {
		String command = a.getActionCommand();
		if(command.equals("send")) {
			if(messageNUM<conversation.length) {
				conversation[messageNUM].setForeground(accent4);
				conversation[messageNUM].setOpaque(true);
				conversation[messageNUM].setBackground(accent3);
				conversation[messageNUM].setText(enterText.getText());
				messageNUM++;
			}else{
				messageNUM=0;
				SaveConversation();
				reset();
			}
		}
	}
	
	public void reset() {
		for(int i=0; i<conversation.length; i++) {
			conversation[i].setText("");
		}
	}
	
	public void SaveButton(ActionEvent a) {
		SaveConversation();
		reset();
	}
	
	public void SaveConversation() {
		for(int i=0; i<conversation.length; i++) {
			String message= conversation[i].getText();
			if(!message.equals("")) {
				System.out.println(message);
			}
		}
		System.out.println();
	}
		
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame f) {
		frame = f;
	}
	
	public void setThemeColors(Color a1, Color a2, Color a3, Color a4) {
		accent1=a1;
		accent2=a2;
		accent3=a3;
		accent4=a4;
	}
	
	public void temp() {	
		Color BlueTheme = new Color(0,80,255);
		Color BlueTheme2= new Color(0,228,255);
		Color BlueTheme3= new Color(255,93,0);
		
		Color OrangeTheme= new Color(255,111,0);
		Color RedTheme= new Color(255,0,0);
		Color PurpleTheme= new Color(118,0,62);
		
		Color White= new Color(255,255,255);
		
		setThemeColors(BlueTheme,BlueTheme2,BlueTheme3,White);
		setTheme();
	}
	
	public void setTheme() {
		Center.setBackground(accent4);
		North.setBackground(accent1);
		South.setBackground(accent1);
		//lblIpaddress.setForeground(accent4);
		enterText.setForeground(accent1);
		send.setBackground(accent1);
		send.setForeground(accent4);
		save.setBackground(accent1);
		save.setForeground(accent4);
	}
	
}


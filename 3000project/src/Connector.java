import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Connector {
	
	private String sentence;
	private String modifiedSentence;
	private BufferedReader inFromUser;
	private BufferedReader inFromServer;
	private Socket clientSocket;
	private DataOutputStream outToServer;
	
	
	public Connector(String address, int port) {
		
		sentence= "";
		inFromUser= new BufferedReader(new InputStreamReader(System.in));
		
		try {
			clientSocket = new Socket(address, port);
			outToServer = new DataOutputStream(clientSocket.getOutputStream());
			inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			sentence = inFromUser.readLine();
			outToServer.writeBytes(sentence + 'n');
			modifiedSentence = inFromServer.readLine();
			System.out.println("FROM SERVER: "+modifiedSentence);
			clientSocket.close();
			
		} catch (IOException e) {
			System.out.println("There was an error connected to the server");
			e.printStackTrace();
		}

		
	}
	
}

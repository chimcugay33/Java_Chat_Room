package Server;

import java.io.*;
import java.net.*;
import java.util.*;

public class ClientHandler implements Runnable{
	
	private Socket socket;
	private OutputStreamWriter out;
	private InputStreamReader in;
	private ArrayList<ClientHandler> clientHandlers = new ArrayList<>();
	public ClientHandler(Socket socket) {
		try {
			this.socket = socket;
			out = new OutputStreamWriter(socket.getOutputStream());
			in = new InputStreamReader(socket.getInputStream());
			clientHandlers.add(this);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (socket.isConnected()) {
			
		}
	}	

}

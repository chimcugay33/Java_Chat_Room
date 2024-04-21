package Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;



public class ClientHandler implements Runnable{
	
	private Socket socket;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private ArrayList<ClientHandler> clientHandlers = new ArrayList<>();
	private String user_id;
	public ClientHandler(Socket socket) {
		try {
			this.socket = socket;
			out = new ObjectOutputStream(socket.getOutputStream());
			in = new ObjectInputStream(socket.getInputStream());
			clientHandlers.add(this);
			message msg;
			try {
				msg = (message) in.readObject();
				this.user_id = msg.getContent(); 
				// khi moi vao chuong trinh, bat nhap mot cai ten su dung dc, la userid trong content cua msg
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (socket.isConnected()) {
			try {
				message msg = (message) in.readObject();
				sendMessage(msg);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }	
	}
	public void sendMessage(message msg) {
		for (ClientHandler i : clientHandlers) {
			try {
				if (i.user_id.equals(msg.getUser_ID())) {
					i.out.writeObject(msg);
				}
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				//closeEverything(socket, bufferedReader, bufferedWriter);
				break;
			}
		}
	}
}

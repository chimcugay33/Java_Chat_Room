package Server;

import java.io.IOException;
import java.net.*;

public class ServerCore {

	private ServerSocket serverSocket;
	public ServerCore(ServerSocket ss) {
		this.serverSocket = ss;
	}
	
	public void startServer() {
		try {
			Socket socket = serverSocket.accept();
			while (serverSocket.isClosed() == false) {
				Socket socket1 = serverSocket.accept();
				ClientHandler cH = new ClientHandler(socket1);
				Thread thread = new Thread(cH);
				thread.start();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(1500);
			ServerCore sc = new ServerCore(serverSocket);
			sc.startServer();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

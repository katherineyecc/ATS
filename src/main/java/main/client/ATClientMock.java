package main.client;

import java.net.Socket;
import java.net.UnknownHostException;
import java.io.IOException;
import main.utilities.Trace;
import org.apache.log4j.Logger;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ATClientMock implements Runnable {
	
	private int ID = 0;
	private Socket socket = null;
	private Thread thread = null;
	private ClientThreadMock client = null;
	private BufferedReader file = null;
	private BufferedReader streamIn = null;
	private BufferedWriter streamOut = null;
	private Logger logger = Trace.getInstance().getLogger(this);
	private String fileName = null;
	private FileInputStream f = null;
	private File fl = null;
	private boolean countOfFailRegister = false;
	
	
	public ATClientMock(String serverName, int serverPort, String filename) {
		System.out.println("Mock is connecting to the server. Please wait ...");
		try {
			this.socket = new Socket(serverName, serverPort);
			this.ID = socket.getLocalPort();
			this.fileName = filename;
			logger.info(String.format("%d : Connected to server: %s", ID, socket.getInetAddress()));
			logger.info(String.format("%d : Connected to portid: %s", ID, socket.getLocalPort()));
			this.start();
			System.out.println("Welcome To Academic Tracking System!");
			System.out.println("Greeting To Start!");
		} catch (UnknownHostException uhe) {
			System.err.println(ID + ": Unknown Host");
			String message = String.format("Exception thrown : %s \n", uhe.getMessage());
			logger.info(String.format("Class: %-12s: %s", this.getClass().getSimpleName(), message));
		} catch (IOException ioe) {
			System.out.println(ID + "Unexpected exception");
			String message = String.format("Exception thrown : %s \n", ioe.getMessage());
			logger.info(String.format("Class: %-12s: %s", this.getClass().getSimpleName(), message));
		}
	}
	
	public ATClientMock(String serverName, int serverPort) {
		System.out.println("Mock is connecting to the server. Please wait ...");
		try {
			this.socket = new Socket(serverName, serverPort);
			this.ID = socket.getLocalPort();
			logger.info(String.format("%d : Connected to server: %s", ID, socket.getInetAddress()));
			logger.info(String.format("%d : Connected to portid: %s", ID, socket.getLocalPort()));
			this.start();
			System.out.println("Welcome To Academic Tracking System!");
			System.out.println("Greeting To Start!");
		} catch (UnknownHostException uhe) {
			System.err.println(ID + ": Unknown Host");
			String message = String.format("Exception thrown : %s \n", uhe.getMessage());
			logger.info(String.format("Class: %-12s: %s", this.getClass().getSimpleName(), message));
		} catch (IOException ioe) {
			System.out.println(ID + "Unexpected exception");
			String message = String.format("Exception thrown : %s \n", ioe.getMessage());
			logger.info(String.format("Class: %-12s: %s", this.getClass().getSimpleName(), message));
		}
	}
	
	public int getID() {
		return this.ID;
	}
	
	public void start() throws IOException {
		try {
			fl = new File(fileName);
			f = new FileInputStream(fl);
			file = new BufferedReader(new InputStreamReader(f));
			streamIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			streamOut = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			if(thread == null) {
				client = new ClientThreadMock(this, socket);
				thread = new Thread(this);
				thread.start();
			}
		} catch (IOException ioe) {
			String message = String.format("Exception thrown : %s \n", ioe.getMessage());
			logger.info(String.format("Class: %-12s: %s", this.getClass().getSimpleName(), message));
		}
	}
	
	public void run() {
		while(thread != null) {
			try {
				if(streamOut != null) {
					streamOut.flush();
					String line = file.readLine(); // read mock input from file
					if(line == null) {
						break;
					} else {
						streamOut.write(line + "\n");
						//System.out.println(line);
					}
				} else {
					System.out.println(ID + ": Stream Closed");
				}
			} catch(IOException e) {
				String message = String.format("Exception thrown : %s \n", e.getMessage());
				logger.info(String.format("Class: %-12s: %s", this.getClass().getSimpleName(), message));
				stop();
			}
		}
	}
	
	public void handle(String msg) {
		if(msg.equalsIgnoreCase("exit")) {
			System.out.println("Good Bye.");
			stop();
		} else {
			System.out.println(msg);
			if(msg.equalsIgnoreCase("Unable to register for this course!")) {
				countOfFailRegister = true;
				//stop();
			}
		}
	}
	
	public void stop() {
		try {
			if(thread != null)
				thread = null;
			if(file != null)
				file.close();
			if(streamIn != null)
				streamIn.close();
			if(streamOut != null)
				streamOut.close();
			if(f != null)
				f.close();
			if(socket != null)
				socket.close();
			if(fl != null)
				fl = null;
			this.socket = null;
			this.file = null;
			this.f = null;
			this.streamIn = null;
			this.streamOut = null;
		} catch (IOException ioe) {
			String message = String.format("Exception thrown : %s \n",
					ioe.getMessage());
			logger.info(String.format("Class: %-12s: %s", this.getClass()
					.getSimpleName(), message));
		}
		client.close();
	}
	
	public boolean getCountOfFailRegister() {
		return countOfFailRegister;
	}
}

import java.io.File;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
//import java.net.InetAddress;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.net.UnknownHostException;
//import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

// Created by Dominick Forlenza

public class driver {

	// File mutex lock ensuring only one instance of RooommateRoulette will run at a time
	public static boolean fileLock(final String mutexFile) throws IOException {
		final File file = new File(mutexFile);
		try {
			final RandomAccessFile tempFile = new RandomAccessFile(file, "rw");
			final FileLock file_lock = tempFile.getChannel().tryLock();
			if (file_lock != null) {
				Runtime.getRuntime().addShutdownHook(new Thread() {
					public void run() {
						try {
							file_lock.release();
							tempFile.close();
							file.delete();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static void main(String[] args) {
		
		// Main user input at beginning of app session
        // All input done through terminal until GUI is created
		user_input u1 = new user_input();
		
		// File mutex
		try {
			fileLock("temp");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*
		// Socket approach to one program restriction
		// Bind to port 9999
		// Port timeout issues! 
		ServerSocket server = null;
		Socket sock = null;
		try {
			server = new ServerSocket(9999, 10, InetAddress.getLocalHost());
			while (true) {
				sock = server.accept();
			}
		}catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				server.close();
				sock.close();
			} catch (IOException s) {
				s.printStackTrace();
			}
		}
		*/
		
		u1.sessionBegin(null);
	}
}


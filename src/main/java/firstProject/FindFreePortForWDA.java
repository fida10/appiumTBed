package firstProject;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;

public class FindFreePortForWDA {
	public static void main(String[] args){
		System.out.println(findFreePort());
	}

	// the ports below 1024 are system ports
	private static final int MIN_PORT_NUMBER = 8100;
	// the ports above 49151 are dynamic and/or private
	private static final int MAX_PORT_NUMBER = 8200;

	public static int findFreePort() {
		for (int i = MIN_PORT_NUMBER; i <= MAX_PORT_NUMBER; i++) {
			if (available(i)) {
				return i;
			}
		}
		throw new RuntimeException("Could not find an available port between " +
				MIN_PORT_NUMBER + " and " + MAX_PORT_NUMBER);
	}

	private static boolean available(final int port) {
		ServerSocket serverSocket = null;
		DatagramSocket dataSocket = null;
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.setReuseAddress(true);
			dataSocket = new DatagramSocket(port);
			dataSocket.setReuseAddress(true);
			return true;
		} catch (final IOException e) {
			return false;
		} finally {
			if (dataSocket != null) {
				dataSocket.close();
			}
			if (serverSocket != null) {
				try {
					serverSocket.close();
				} catch (final IOException e) {
					// can never happen
				}
			}
		}
	}
}

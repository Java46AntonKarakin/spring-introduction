package telran.spring.service;

import org.springframework.stereotype.Service;

import java.net.Socket;

@Service("TCP")
public class TcpSender implements Sender {

	String correctAdress = "Message: %s has been sent to socket %s%n";

	@Override
	public void send(String text, String address) {
		String [] socketParts = address.split("\\:");
		try {
			Socket socket = new Socket(socketParts[0], Integer.valueOf(socketParts[1]));
		} catch (Exception e) {
			System.out.printf("\"%s\" is wrong socket address", address);
		} 
		System.out.printf(correctAdress, text, address);
	}

}

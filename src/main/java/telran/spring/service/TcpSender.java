package telran.spring.service;

import org.springframework.stereotype.Service;

@Service("tcp")
public class TcpSender implements Sender {

	String correctAdress = "Message: %s has been sent to socket %s%n";
	String inCorrectAdress = "incorrect address%n";
	String regEx = "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\:[\\d]{1,5}";

	@Override
	public void send(String text, String address) {
		String output = address.matches(regEx) ? String.format(correctAdress, text, address)
				: String.format(inCorrectAdress, address);
		System.out.printf(output);
	}
}

package telran.spring.service;

import org.springframework.stereotype.Service;

@Service("email")
public class EmailSender implements Sender {
	String correctAdress = "Email message: %s has been sent to address %s%n";
	String inCorrectAdress = "incorrect address%n";
	String regEx = "^((([0-9A-Za-z]{2,30}))@([A-Za-z]{1,}\\.){1,}[-A-Za-z]{2,})$";

	@Override
	public void send(String text, String address) {
		String output = address.matches(regEx) ? String.format(correctAdress, text, address)
				: String.format(inCorrectAdress, address);
		System.out.printf(output);
	}
}

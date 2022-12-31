package telran.spring.service;

import org.springframework.stereotype.Service;

@Service("whatsup")
public class WhatsupSender implements Sender {
	String correctAdress = "Internet message: \"%s\" has been sent to %s%n";
	String inCorrectAdress = "incorrect phone number%n";
	String regEx = "[\\d]{3}\\-[\\d]{7}";

	@Override
	public void send(String text, String address) {
		String output = address.matches(regEx) ? String.format(correctAdress, text, address)
				: String.format(inCorrectAdress, address);
		System.out.printf(output);
	}
}

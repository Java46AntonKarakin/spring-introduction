package telran.spring.service;

import org.springframework.stereotype.Service;

@Service("sms")
public class SmsSender implements Sender {
	String correctAdress = "SMS message: %s has been sent to phone number %s%n";
	String inCorrectAdress = "incorrect address%n";
	String regEx = "[\\d]{3}\\-[\\d]{7}";

	@Override
	public void send(String text, String address) {
		String output = address.matches(regEx) ? String.format(correctAdress, text, address)
				: String.format(inCorrectAdress, address);
		System.out.printf(output);
	}
}

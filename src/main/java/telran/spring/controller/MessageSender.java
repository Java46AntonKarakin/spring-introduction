package telran.spring.controller;

import java.util.*;
import java.util.stream.Collectors;

import telran.view.*;
import org.springframework.stereotype.Component;
import telran.spring.service.Sender;

@Component
public class MessageSender {

	Map<String, Sender> senders;

	public MessageSender(Map<String, Sender> senders) {
		this.senders = senders;
	}

	public void viewBasedMenu(String[] args) {
		InputOutput io = new ConsoleInputOutput();
		List<String> options = senders.entrySet().stream().map(etr -> etr.getKey()).collect(Collectors.toList());
		options.add("exit");
		while (true) {
			String msgType = io.readOption("Enter message type or \"exit\"", "Wrong message type", options);
			if (msgType.toLowerCase().equals("exit")) {
				break;
			}
			String msgText = io.readString("Enter message text");
			String msgAddress = io.readString("Enter message address");
			senders.get(msgType).send(msgText, msgAddress);
		}
	}
}

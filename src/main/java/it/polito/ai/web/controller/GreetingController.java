package it.polito.ai.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import it.polito.ai.model.Greeting;
import it.polito.ai.model.HelloMessage;
import it.polito.ai.model.Message;
import it.polito.ai.service.MessageService;

@Controller
public class GreetingController {
	
	@Autowired
	MessageService messageService;
	
	
	
	//@MessageMapping("/gs-guide-websocket")
	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Greeting greeting(HelloMessage message) throws Exception {
		Thread.sleep(1000); // simulated delay
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String nickName=auth.getName();
		String mess=message.getName();
		
		messageService.addMessage(nickName, mess, "PROVAAAA");
		return new Greeting("Hello, " + message.getName() + "!");
	}
	/*
	@MessageMapping("/BusMetro")
	@SendTo("/topic/Bus_Metro")
	public Message chatBusMetro(HelloMessage message) throws Exception {
		Thread.sleep(1000); // simulated delay
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String nickName=auth.getName();
		String mess=message.getName();
		
		messageService.addMessage(nickName, mess);
		return new Message(nickName, message.getName(), , );
	}*/
	
	
	
	
	
}

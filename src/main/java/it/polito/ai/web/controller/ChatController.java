package it.polito.ai.web.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import it.polito.ai.model.Greeting;
import it.polito.ai.model.HelloMessage;
import it.polito.ai.model.Message;
import it.polito.ai.service.MessageService;

@Controller
public class ChatController
{
	
	@Autowired
	MessageService messageService;

	@RequestMapping("/index")
	public String home(HttpServletRequest http, Model m)
	{
		String topic=http.getQueryString();
		//System.out.println("URL:::::::::::::::::::::::::"+ url);
		
		
		List<Message> listaMessage=messageService.getLast10Message(topic);
		List<Greeting> listaGreeting =new ArrayList<Greeting>();
		
		
		
		
		for(Message mess: listaMessage)
			listaGreeting.add(new Greeting(mess.getNickName() + ": " + mess.getMessage()));
		
		Collections.reverse(listaGreeting);
		m.addAttribute("messaggi", listaGreeting);
			
			//System.out.println(mess.toString());
		
		
		
		//m.addAttribute("messaggio", "Hello World!");
		//m.addAttribute("Barra Di Navigazione", Barra);
		//System.out.println("CAZZOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
		return "index";
	}
	
	
	
	
	@MessageMapping("/BusMetro")
	@SendTo("/topic/_BusMetro")
	public Greeting chatBusMetro(HelloMessage message) throws Exception 
	{
		
		Thread.sleep(1000); // simulated delay
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String nickName=auth.getName();
		String mess=message.getName();
		String topic="BusMetro";
		
		messageService.addMessage(nickName, mess, topic);
		
		return new Greeting(nickName + ": " + message.getName());
	}
	
	@MessageMapping("/Traffico")
	@SendTo("/topic/_Traffico")
	public Greeting chatTraffico(HelloMessage message) throws Exception 
	{
		Thread.sleep(1000); // simulated delay
		//System.out.print("ciaooooooooooooooooooooooooooooooooo");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String nickName=auth.getName();
		String mess=message.getName();
		String topic="Traffico";
		
		messageService.addMessage(nickName, mess, topic);
		return new Greeting(nickName + ": " + message.getName());
	}
	
	
	@MessageMapping("/GiroBici")
	@SendTo("/topic/_GiroBici")
	public Greeting chatGiroBici(HelloMessage message) throws Exception 
	{
		Thread.sleep(1000); // simulated delay
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String nickName=auth.getName();
		String mess=message.getName();
		String topic="GiroBici";
		
		messageService.addMessage(nickName, mess, topic);
		return new Greeting(nickName + ": " + message.getName());
	}
	
	
	
	
	
	
	
	
	
	

}

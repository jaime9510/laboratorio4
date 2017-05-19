package it.polito.ai.web.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.lang.UsesJava7;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import it.polito.ai.model.Chat;
import it.polito.ai.model.Greeting;
import it.polito.ai.model.HelloMessage;
import it.polito.ai.model.Message;
import it.polito.ai.model.User;
import it.polito.ai.service.MessageService;
import it.polito.ai.service.UserService;

@Controller
public class ChatController
{
	
	@Autowired
	MessageService messageService;
	
	@Autowired
	UserService userService;

	@RequestMapping("/index")
	public String home(HttpServletRequest http, Model m)
	{
		String topic=http.getQueryString();
		//System.out.println("URL:::::::::::::::::::::::::"+ url);
		//List<User> allUser=userService.findAll();
		//List<User> chatUser=new ArrayList<User>();
		
		List<Message> listaMessage=messageService.getLast10Message(topic);
		List<Greeting> listaGreeting =new ArrayList<Greeting>();
		//List<Chat> listaChat = new ArrayList<Chat>();
		
		
		
		for(Message mess: listaMessage)
		{
			SimpleDateFormat data=new SimpleDateFormat("dd MMM yyyy HH:mm");
			//String  nick=mess.getNickName();
			
			/*for(User ut: allUser)
					if(ut.getNickName().equals(nick))
							chatUser.add(ut);*/
			//Ce' solo un problema!!! i nickname devono essere univoci altrimenti in questo for(sopra)
			//preleva più di un utente!!!!!
			
			listaGreeting.add( new Greeting("("+data.format(mess.getTimestamp().getTime()) +")   ---   "+ mess.getNickName() + ": " + mess.getMessage()));
		}
		
		//Collections.reverse(chatUser);
		Collections.reverse(listaGreeting);
		/*int i=0;
		for(Greeting str: listaGreeting)
		{
			listaChat.add(new Chat(str, chatUser.get(i).getImmagine()));
			i++;
		}*/
		
		
		
		//m.addAttribute("chat", listaChat);
		//m.addAttribute("user", chatUser);
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
		GregorianCalendar timestamp=new GregorianCalendar();
		SimpleDateFormat data=new SimpleDateFormat("dd MMM yyyy HH:mm");
		Thread.sleep(1000); // simulated delay
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String nickName=auth.getName();
		String mess=message.getName();
		String topic="BusMetro";
		
		messageService.addMessage(nickName, mess, topic, timestamp);
		
		return new Greeting("("+data.format(timestamp.getTime()) +")   ---   "+ nickName + ": " + message.getName() );
	}
	
	@MessageMapping("/Traffico")
	@SendTo("/topic/_Traffico")
	public Greeting chatTraffico(HelloMessage message) throws Exception 
	{
		GregorianCalendar timestamp=new GregorianCalendar();
		SimpleDateFormat data=new SimpleDateFormat("dd MMM yyyy HH:mm");
		Thread.sleep(1000); // simulated delay
		//System.out.print("ciaooooooooooooooooooooooooooooooooo");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String nickName=auth.getName();
		String mess=message.getName();
		String topic="Traffico";
		
		messageService.addMessage(nickName, mess, topic, timestamp);
		return new Greeting("("+data.format(timestamp.getTime()) +")   ---   "+ nickName + ": " + message.getName() );
	}
	
	
	@MessageMapping("/GiroBici")
	@SendTo("/topic/_GiroBici")
	public Greeting chatGiroBici(HelloMessage message) throws Exception 
	{
		GregorianCalendar timestamp=new GregorianCalendar();
		SimpleDateFormat data=new SimpleDateFormat("dd MMM yyyy HH:mm");
		Thread.sleep(1000); // simulated delay
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String nickName=auth.getName();
		String mess=message.getName();
		String topic="GiroBici";
		
		messageService.addMessage(nickName, mess, topic, timestamp);
		return new Greeting("("+data.format(timestamp.getTime()) +")   ---   "+ nickName + ": " + message.getName() );
	}
	
	
	
	
	
	
	
	
	
	

}

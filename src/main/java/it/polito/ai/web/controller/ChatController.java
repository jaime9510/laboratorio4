package it.polito.ai.web.controller;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

public class ChatController implements ApplicationListener<ApplicationEvent> {

	@Override
	public void onApplicationEvent(ApplicationEvent event) 
	{
//		if (event instanceof SessionDisconnectEvent) 
//		{
//			SessionDisconnectEvent sde = (SessionDisconnectEvent) event;
//			users.removeUser(sde.getSessionId());
//			messagingTemplate.convertAndSend("/topic/presence", new Roster(users.getUsers()));
//		}
	}

}

package it.polito.ai.service;

import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.polito.ai.model.Message;
import it.polito.ai.repository.MessageRepository;

@Service
public class MessageServiceImpl implements MessageService
{
	@Autowired
	MessageRepository messageRepository;
	
	
	@Override
	public void addMessage(String nickName, String message) 
	{
		GregorianCalendar timestamp=new GregorianCalendar();
		System.out.println(timestamp.getTime());
		Message m=new Message(nickName, message, timestamp);
		messageRepository.save(m);
		
		
	}

}

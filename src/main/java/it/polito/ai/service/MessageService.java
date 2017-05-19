package it.polito.ai.service;

import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.polito.ai.model.Message;
import it.polito.ai.model.User;



public interface MessageService 
{
	public void addMessage(String nickName, String message, String topic, GregorianCalendar timestamp);
	public List<Message> getLast10Message(String topic);
	
	public List<String> getTopic();
	

	public Page<Message> getDiscussion(String topic, Pageable pageable);
	
}

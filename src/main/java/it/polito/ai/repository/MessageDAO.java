package it.polito.ai.repository;

import java.util.List;

import it.polito.ai.model.Message;

public interface MessageDAO 
{
	
	public List<Message> getLast10Message(String topic);
	
	public List<String> getTopic();

	public void saveMessage(Message message);

	
	
}

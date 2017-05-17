package it.polito.ai.service;

import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.polito.ai.model.Message;
import it.polito.ai.repository.MessageDAO;
import it.polito.ai.repository.MessageRepository;

@Service
public class MessageServiceImpl implements MessageService
{
	@Autowired
	MessageRepository messageRepository;
	
	@Autowired
	MessageDAO messageDAO;
	
	
	@Override
	public void addMessage(String nickName, String message, String topic) 
	{
		GregorianCalendar timestamp=new GregorianCalendar();
		System.out.println(timestamp.getTime());
		Message m=new Message(nickName, message, timestamp, topic);
//		messageRepository.save(m);
		messageDAO.saveMessage(m);
	}

	@Override
	public List<Message> getLast10Message(String topic) 
	{
		List<Message> ListaMessage=messageDAO.getLast10Message(topic);
		
		return ListaMessage;
	}

	@Override
	public List<String> getTopic() 
	{
		return messageDAO.getTopic();
	}

	@Override
	public Page<Message> getDiscussion(String topic, Pageable pageable) 
	{
		return messageRepository.findByTopic(topic, pageable);
	}

}

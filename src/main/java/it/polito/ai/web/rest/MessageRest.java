package it.polito.ai.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.polito.ai.model.Message;
import it.polito.ai.service.MessageService;
@RestController
public class MessageRest 
{
	
	@Autowired
	MessageService messageService;
	
	@RequestMapping(value="/topic", method=RequestMethod.GET)
	public List<String> getListUsers()
	{
		return messageService.getTopic();
	}
	
	@RequestMapping(value="/topic/{ID_topic}/{ID_page}", method=RequestMethod.GET)
	public Page<Message> getDiscussion(@PathVariable(value="ID_topic") String topic, @PathVariable(value="ID_page") Integer page)
	{
		return  messageService.getDiscussion(topic, new PageRequest(page, 10));
	}
	
	
	
	

}

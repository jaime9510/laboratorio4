package it.polito.ai.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import it.polito.ai.model.Message;
import it.polito.ai.model.User;

public interface MessageRepository extends MongoRepository<Message, String> 
{
	//@query()
	
}

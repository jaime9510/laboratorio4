package it.polito.ai.repository;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import it.polito.ai.model.Message;

@Repository
public class MessageDAOImpl implements MessageDAO
{
	
	@Autowired
	private MongoTemplate mongoTemplate;
	

	public MessageDAOImpl(MongoTemplate mongoTemplate) {
		super();
		this.mongoTemplate = mongoTemplate;
	}


	@Override
	public List<Message> getLast10Message(String topic) 
	{
		Query q=new Query();
		q.addCriteria( Criteria.where("topic").is(topic));
		q.with(new Sort(Sort.Direction.DESC, "timestamp.time", "message"));
		
		q.limit(10);
		
		
		
		return mongoTemplate.find(q, Message.class);
		
		
	}


	@Override
	public List<String> getTopic() 
	{
		return (List<String>) mongoTemplate.getCollection("message").distinct("topic");
	}
	
	


	@Override
	public void saveMessage(Message message) {
		mongoTemplate.save(message);
	}
	
	

}

package it.polito.ai.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import it.polito.ai.model.Message;

@Repository
public interface MessageRepository extends PagingAndSortingRepository<Message, String> 
{
	
	//@Query("{topic:'Traffico'}.sort({'timestamp.time':-1}).limit(10)")
	//@Query("{topic:'Traffico'}, $sort: { 'timestamp.time':-1}")
	//@Query("{topic:'Traffico'}, limit(10)")
	//@Query("{ topic:'Traffico', $sort: {'timestamp.time':-1}, $limit:10 }")
	//public List<Message> findLast10Message();
	
	Page<Message> findByTopic(String topic, Pageable page);
	
	
}

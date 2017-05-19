package it.polito.ai.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import it.polito.ai.model.User;

public interface UserRepository extends MongoRepository<User, String> {
	
	public User findByEmail(String email);
	public User findByNickName(String nickName);
	
}

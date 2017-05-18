package it.polito.ai.service;

import java.util.List;

import it.polito.ai.model.User;
import it.polito.ai.web.dto.UserDto;

public interface UserService {
	
	public User registerNewUserAccount(UserDto accountDto) throws Exception;

	public User getUserInformation(String nickName);
	
	public List<User> findAll();
	
	public User modifyUser(UserDto userDto);
	
}

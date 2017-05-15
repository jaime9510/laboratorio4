package it.polito.ai.service;

import it.polito.ai.model.User;
import it.polito.ai.web.dto.UserDto;

public interface UserService {
	
	public User registerNewUserAccount(UserDto accountDto) throws Exception;

	public User getUserInformation(String nickName);
	
}

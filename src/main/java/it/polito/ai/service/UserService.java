package it.polito.ai.service;

import it.polito.ai.model.User;
import it.polito.ai.web.dto.UserDto;

public interface UserService {
	
	User registerNewUserAccount(UserDto accountDto) throws Exception;

}

package it.polito.ai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.polito.ai.model.User;
import it.polito.ai.repository.UserRepository;
import it.polito.ai.web.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;
	
	@Transactional
	@Override
	public User registerNewUserAccount(UserDto userDto) throws Exception {
		
		if (emailExist(userDto.getEmail()) || nickNameExist(userDto.getNickName())) {   
            throw new Exception("There is an account with that email address: "  + userDto.getEmail());
        }
		User user = new User();
		user.setNickName(userDto.getNickName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		
		//TODO: for now all the users will be standard (it could change later)
		user.setRole("USER");
		
		return repository.save(user);
		
	}

	private boolean emailExist(String email) {
        User user = repository.findByEmail(email);
        if (user != null) {
            return true;
        }
        return false;
    }
	
	private boolean nickNameExist(String nickName) {
        User user = repository.findByNickName(nickName);
        if (user != null) {
            return true;
        }
        return false;
    }

	@Override
	public User getUserInformation(String nickName) {
		User user = repository.findByNickName(nickName);
		return user;
	}
	
}

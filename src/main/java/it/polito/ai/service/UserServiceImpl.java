package it.polito.ai.service;

import java.awt.Image;
import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.gridfs.GridFS;

import it.polito.ai.model.Auto;
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
		user.setGender(userDto.getGender());
		user.setYears(userDto.getYears());
		user.setInstructionLevel(userDto.getInstructionLevel());
		user.setImmagine(null);
		
		
		if(userDto.getStringImage() != null) 
		{
			user.setStringImage(userDto.getStringImage());
			/*String pathFile="../images/" + user.getStringImage() + ".png";
			File file=new File(pathFile);
			
			/*DB db=DB.class;
			GridFS image=new GridFS(user, "user");
			
			
			
			user.setImmagine(image);*/
			
			
			
			
			
		}
		
		
		if(userDto.getAuto().getRegistrationYear() != null) {
			user.setAuto(new Auto(userDto.getAuto().getRegistrationYear(), userDto.getAuto().getTypeFuel()));	
		} else {
			user.setAuto(new Auto(0, "No"));
		}
		if(userDto.getCarSharing() != null && !userDto.getCarSharing().isEmpty()) {
			user.setCarSharing(userDto.getCarSharing());
		} else {
			user.setCarSharing("No");
		}
		if(userDto.getBike() != null && !userDto.getBike().isEmpty()) {
			user.setBike(userDto.getBike());
		} else {
			user.setBike("No");
		}
		if(userDto.getPublicTransport() != null && !userDto.getPublicTransport().isEmpty()) {
			user.setPublicTransport(userDto.getPublicTransport());
		} else 
		{
			user.setPublicTransport("No");
		}
		
		if(userDto.getStringImage()==null)
			System.out.println("La string eè null:::::::::::: ");
		
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

	@Override
	public List<User> findAll() 
	{
		return repository.findAll();
	}

	@Override
	public User modifyUser(UserDto userDto) {
		User user = repository.findByEmail(userDto.getEmail());
		if(user != null) {
			if(userDto.getNickName() != null && !userDto.getNickName().isEmpty()) {
				user.setNickName(userDto.getNickName());
			}
			
			if(userDto.getPassword() != null && !userDto.getPassword().isEmpty()) {
				user.setPassword(userDto.getPassword());
			}
			repository.save(user);
		}
		return user;
	}
	
}

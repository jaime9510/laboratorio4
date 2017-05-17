package it.polito.ai.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.util.JSON;

import it.polito.ai.model.User;
import it.polito.ai.service.UserService;

@RestController
public class ElencoUserRest 
{
	@Autowired
	UserService userService;
	
	
		@RequestMapping(value="/ListUsers", method=RequestMethod.GET)
		public List<User> getListUsers()
		{
			return userService.findAll();
		}
		
		
		

}

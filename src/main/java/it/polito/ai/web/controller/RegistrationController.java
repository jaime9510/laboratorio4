package it.polito.ai.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import it.polito.ai.model.User;
import it.polito.ai.service.UserService;
import it.polito.ai.web.dto.UserDto;

@Controller
public class RegistrationController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/user/registration", method = RequestMethod.GET)
	public String showRegistrationForm(WebRequest webRequest, Model model) {
		UserDto userDto = new UserDto();
		model.addAttribute("user", userDto);
		return "registration";
	}
	
	@RequestMapping(value = "/user/registration", method = RequestMethod.POST)
	public ModelAndView registerUserAccount(@ModelAttribute("user") @Valid UserDto userDto, 
			BindingResult result, WebRequest request, Error error) {
		
		User registered = new User();
		if(!result.hasErrors()) {
			registered = createUserAccount(userDto, result);
		}
		if (registered == null) {
	        result.rejectValue("email", "message.regError");
	    }
	    if (result.hasErrors()) {
	        return new ModelAndView("registration", "user", userDto);
	    } 
	    else {
	        return new ModelAndView("hello", "user", userDto);
	    }
	}
	
	private User createUserAccount(UserDto userDto, BindingResult result) {
	    User registered = null;
	    try {
	        registered = userService.registerNewUserAccount(userDto);
	    } catch (Exception e) {
	        return null;
	    }
	    return registered;
	}

}

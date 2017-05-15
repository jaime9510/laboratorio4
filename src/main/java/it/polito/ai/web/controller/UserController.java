package it.polito.ai.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/user/profile", method = RequestMethod.GET)
	public String showUserProfile(WebRequest webRequest, Model model) {
		
		System.out.println("\n\n *********** profile **********\n\n");
		
		User user = new User();
		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		user = userService.getUserInformation(userDetails.getUsername());
		model.addAttribute("user", user);
		return "userProfile";
	}
	
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
	        return new ModelAndView("login", "user", userDto);
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
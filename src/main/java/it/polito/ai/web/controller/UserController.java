package it.polito.ai.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
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
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	/*@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String showHomePAge( Model model) 
	{
		String image=null;
		image=;

		
		model.addAttribute("image", image);
		return "home";
	}*/
	
	
	
	
	
	@RequestMapping(value = "/user/profile", method = RequestMethod.GET)
	public String showUserProfile(WebRequest webRequest, Model model) {
		User user = new User();
		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		user = userService.getUserInformation(userDetails.getUsername());
		
		model.addAttribute("user", new UserDto(user));
		return "profile";
	}
	
	@RequestMapping(value = "/user/profile/modifica", method = RequestMethod.POST)
	public ModelAndView userModifica(@ModelAttribute("user") @Valid UserDto userDto, 
			BindingResult result, WebRequest request, Error error) {
		
		User modified = new User();
		if(!result.hasErrors()) {
			modified = userService.modifyUser(userDto);
			
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String userName = ((UserDetails)auth.getPrincipal()).getUsername();
			if(modified != null && !userName.equals(modified.getNickName())) {
				
				Authentication authentication = new UsernamePasswordAuthenticationToken(userDetailsService.loadUserByUsername(modified.getEmail()), auth.getCredentials(), auth.getAuthorities());
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		}
		
		if (modified == null) {
	        result.rejectValue("email", "message.regError");
	    }
	    if (result.hasErrors()) {
	        return new ModelAndView("profile", "user", userDto);
	    } 
	    else {
	        return new ModelAndView("profile", "user", new UserDto(modified));
	    }
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

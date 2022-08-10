package com.youth.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.youth.main.model.UserModel;
import com.youth.main.repository.UserRepository;
import com.youth.main.service.UserService;

@Controller
public class UserProfileController {

    @Autowired
    private UserService userService;

    @Autowired
	private UserRepository userRepository;

    @GetMapping("/user/user_profile")
	public String userProfile(Model model) {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
	    String username = loggedInUser.getName(); 

	    
	    UserModel userData = userService.findByUsername(username);
	    // String originalUsername = getActualUsername.getUsername();

        model.addAttribute("userdata", userData);
        return "user_profile";
    }
}

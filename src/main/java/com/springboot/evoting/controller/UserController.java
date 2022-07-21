package com.springboot.evoting.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.evoting.DTO.LogInDto;
import com.springboot.evoting.DTO.SignUpDto;
import com.springboot.evoting.model.RolesEntity;
import com.springboot.evoting.model.UsersEntity;
import com.springboot.evoting.repository.RolesRepo;
import com.springboot.evoting.repository.UsersRepo;



@RestController
@RequestMapping("/api/auth")
public class UserController {

	@Autowired
    private AuthenticationManager authenticationManager;
	
	@Autowired
	private UsersRepo userRepository;
	
	@Autowired
	private RolesRepo roleRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@PostMapping("/signin")
	public ResponseEntity<String> authenticateUser(@RequestBody LogInDto loginDto){
		
	      Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
	                loginDto.getUserEmail(), loginDto.getPassword()));

	      SecurityContextHolder.getContext().setAuthentication(authentication);
	      
	      return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
	}
	

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@RequestBody SignUpDto signUpDto){


	        // add check for email exists in DB
	        if(userRepository.existsByuserEmail(signUpDto.getUserEmail())){
	        	
	        
	            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
	        }

	        UsersEntity users = new UsersEntity();
	    	
	        users.setUserName(signUpDto.getUserName());
	        users.setUserEmail(signUpDto.getUserEmail());
	        users.setPassword(passwordEncoder.encode(signUpDto.getPassword()));

	       RolesEntity role = roleRepo.findByroleName("USER").get();
	        users.setRoles(Collections.singleton(role));

	        userRepository.save(users);

	        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);

	        
	}

	
	
	

}

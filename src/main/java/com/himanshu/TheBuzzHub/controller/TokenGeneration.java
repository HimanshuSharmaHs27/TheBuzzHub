package com.himanshu.TheBuzzHub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.himanshu.TheBuzzHub.config.UserDetailsServiceImpl;
import com.himanshu.TheBuzzHub.entity.User;
import com.himanshu.TheBuzzHub.service.UserServices;
import com.himanshu.TheBuzzHub.utils.JwtUtil;

@RestController
@RequestMapping("generate")
public class TokenGeneration {

	@Autowired
	UserServices userServices;

	@Autowired
	UserDetailsServiceImpl detailsserviceimpl;

	@Autowired
	AuthenticationManager authenticationmanager;

	@Autowired
	JwtUtil jwtutil;

	@PostMapping("token")
	public ResponseEntity<Object> token(@RequestBody User user) {
		authenticationmanager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		UserDetails userdetails = detailsserviceimpl.loadUserByUsername(user.getUsername());
		String token = jwtutil.generateToken(userdetails.getUsername());
		return new ResponseEntity<>(token, HttpStatus.OK);

	}

}

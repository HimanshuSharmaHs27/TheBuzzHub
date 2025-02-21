package com.himanshu.TheBuzzHub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.himanshu.TheBuzzHub.entity.User;
import com.himanshu.TheBuzzHub.service.UserServices;

@RestController
@RequestMapping("public")
public class SignUp {

	@Autowired
	UserServices userservices;

	@PostMapping(value = "sign-up")
	public ResponseEntity<Object> createUser(@RequestBody User user) {

		String Response = userservices.createUser(user);
		if (Response != null && Response.equalsIgnoreCase("User Registered succefully")) {
			return new ResponseEntity<>(Response, HttpStatus.CREATED);
		} else if (Response != null && Response.equalsIgnoreCase("User Name Already exists")) {
			return new ResponseEntity<>(Response, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(Response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}

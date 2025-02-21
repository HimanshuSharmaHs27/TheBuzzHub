package com.himanshu.TheBuzzHub.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.himanshu.TheBuzzHub.service.UserServices;

import io.jsonwebtoken.io.IOException;

@RestController
@RequestMapping("login")
public class LogIn {

	@Autowired
	UserServices userservices;

	@GetMapping(value = "show-email")
	public ResponseEntity<Object> showEmail() {
		Object Response = userservices.showEmail();

		if (Response != null || !Response.equals("")) {

			return new ResponseEntity<>(Response, HttpStatus.OK);
		}

		return new ResponseEntity<>("User Not Registered", HttpStatus.BAD_REQUEST);

	}

	@PutMapping(value = "change-password")
	public ResponseEntity<Object> changePassword(
			@RequestParam(value = "lastpassword", required = true) String lastPaswword,
			@RequestParam(value = "newpassword", required = true) String newPaswword) {
		Object Response = userservices.changePassword(lastPaswword, newPaswword);
		if (!Response.equals(null) && Response.equals("User  not found")) {
			return new ResponseEntity<>(Response, HttpStatus.NOT_FOUND);
		} else if (!Response.equals(null) && Response.equals("Please provide valid credentials")) {
			return new ResponseEntity<>(Response, HttpStatus.BAD_REQUEST);
		} else if (!Response.equals(null) && Response.equals("An error occurred while changing the password")) {
			return new ResponseEntity<>(Response, HttpStatus.INTERNAL_SERVER_ERROR);
		} else if (!Response.equals(null) && Response.equals("Password changed successfully")) {
			return new ResponseEntity<>(Response, HttpStatus.OK);
		}
		return new ResponseEntity<>(Response, HttpStatus.NO_CONTENT);
	}

	@GetMapping(value = "/image")
	public ResponseEntity<InputStreamResource> getImage() throws IOException, FileNotFoundException {

		File imageFile = new File("D:\\Screenshot.png");

		if (!imageFile.exists()) {
			return ResponseEntity.notFound().build();
		}

		MediaType mediaType = MediaType.IMAGE_PNG;

		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=" + imageFile.getName())
				.contentType(mediaType).body(new InputStreamResource(new FileInputStream(imageFile)));
	}

}

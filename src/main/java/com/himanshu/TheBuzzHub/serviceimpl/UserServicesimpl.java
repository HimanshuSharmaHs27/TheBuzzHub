package com.himanshu.TheBuzzHub.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.himanshu.TheBuzzHub.entity.User;
import com.himanshu.TheBuzzHub.repository.UserRepository;
import com.himanshu.TheBuzzHub.service.UserServices;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServicesimpl implements UserServices {

	@Autowired
	UserRepository repository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	AuthenticationManager authenticationmanager;

	@Override
	public String createUser(User user) {

		if (repository.existsByUsername(user.getUsername())) {
			return "User Name Already exists";
		}
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole("USER");
		repository.save(user);
		return "User Registered succefully";
	}

	@Override
	public Object showEmail() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = userDetails.getUsername();
		User user = repository.findByUsername(username);
		return user.getEmail();
	}

	@Override
	public String changePassword(String lastPassword, String newPassword) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = userDetails.getUsername();
		log.info(username);

		try {

			authenticationmanager.authenticate(new UsernamePasswordAuthenticationToken(username, lastPassword));

			User user = repository.findByUsername(username);
			if (user == null) {
				return "User  not found";
			}
			user.setPassword(passwordEncoder.encode(newPassword));
			repository.save(user);

			return "Password changed successfully";
		} catch (BadCredentialsException e) {
			return "Please provide valid credentials";
		} catch (Exception e) {
			return "An error occurred while changing the password";
		}
	}

}

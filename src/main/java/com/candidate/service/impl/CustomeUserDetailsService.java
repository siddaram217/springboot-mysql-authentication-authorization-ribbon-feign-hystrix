package com.candidate.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.candidate.model.CustomUserDetails;
import com.candidate.model.User;
import com.candidate.repository.UserRepository;

@Service
public class CustomeUserDetailsService implements UserDetailsService {

	private static final Logger logger = LoggerFactory.getLogger(CustomeUserDetailsService.class);

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("CustomeUserDetailsService.loadUserByUsername() " + username);
		Optional<User> optional = userRepository.findByUserName(username);
		optional.orElseThrow(() -> new UsernameNotFoundException("User not found"));
		/*return optional.map(user -> {
			return new CustomUserDetails(user);
		}).get();*/
		
		return optional.map(CustomUserDetails::new).get();
	}
}

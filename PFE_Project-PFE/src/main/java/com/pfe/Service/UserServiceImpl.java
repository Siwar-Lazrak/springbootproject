package com.pfe.Service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.pfe.Model.User;

import com.pfe.Repository.UserRepository;



@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	
	@Autowired
	PasswordEncoder encoder;

	@Override
	public User findUserByEmail(final String email) {
		
		return userRepository.findByEmail(email);
	}


	
	 

}

package com.recipemanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.recipemanagement.models.User;
import com.recipemanagement.repositories.UserRepository;
import com.recipemanagement.security.UserDetailsImpl;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	
	@Autowired
	UserRepository userRepository;
	


	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
		//wording differs, but functionality the same
		//email will be the username in this case
		User user = userRepository.findByEmail(email).get();
		
		if (user == null)
		{
			throw new UsernameNotFoundException("User Not Found");
		}
		
		return UserDetailsImpl.build(user);
	}
}

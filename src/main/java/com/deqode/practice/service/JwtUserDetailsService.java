package com.deqode.practice.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.deqode.practice.model.BasicUser;
import com.deqode.practice.repository.BasicUserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	private BasicUserRepository basicUser;
	
	public BasicUser addNewUser(BasicUser b) {
		PasswordEncoder p = new BCryptPasswordEncoder();
		b.setPassword(p.encode(b.getPassword()));
		return basicUser.save(b);
		
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		BasicUser u = basicUser.findByUsername(username);
		//System.out.println(username);
		
		if (u != null) {
			return new User(u.getUsername(), u.getPassword(),
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}

package com.agendapro.product_demo.auth;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		/**
		 * Para esta demo voy a trabajar solo con usuario admin/admin.
		 * 
		 * Uso una password encriptada con BCryptEncoder para simular lo que puede ser tener una pass en base. 
		 */
		if("admin".equalsIgnoreCase(username)) {
			return new User("admin", "$2a$12$raK8UZAGBVdzmPZyub/5o.3zHLNXCs1zIYCJxNWjFPlXOk9rkrhxa", new ArrayList<>());
		}
		throw new UsernameNotFoundException("Usuario "+username+" no encontrado");
	}
}

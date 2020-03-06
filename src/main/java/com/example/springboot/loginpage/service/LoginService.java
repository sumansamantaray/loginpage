/**
 * 
 */
package com.example.springboot.loginpage.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * @author samasu5
 *
 */
@Service
public class LoginService {

	
	public boolean validateUser(String name, String password) {
		boolean isValidUser = Boolean.FALSE;
		
		if ("Suman".equalsIgnoreCase(name)) {
			isValidUser = Boolean.TRUE;
		}
		
		return isValidUser;
	}
}

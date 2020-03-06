/**
 * 
 */
package com.example.springboot.loginpage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.springboot.loginpage.service.LoginService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author samasu5
 *
 */
@Controller
@Api (description = "Controller pertaining to the login operations.")
@SessionAttributes("name")
public class LoginController {
	
	@Autowired
	LoginService service;
	
	/**
	 * A GET method call for the First landing page. 
	 * @param inputModel
	 * @return
	 */
	@RequestMapping(value= "/login", method = RequestMethod.GET)
	@ApiOperation(value = "First GET call to load the page")
	public String showLoginPage(ModelMap inputModel) {
		System.out.println("inside login Page");
		return "login";
	}
	
	/**
	 * A POST method call to take the user id and pwd
	 * Validate the user and if successful, show the welcome page.
	 * @param model
	 * @param name
	 * @param password
	 * @return
	 */
	@RequestMapping(value="/login", method = RequestMethod.POST)
	@ApiOperation(value = "POST call to validate the user and route to Welcome Page.")
    public String showWelcomePage(ModelMap model, 
    		@ApiParam(name = "name", value = "User Name") @RequestParam String name, 
    		@ApiParam(name = "password", value = "User Password") @RequestParam String password){
		System.out.println("Inside show welcome page");
        boolean isValidUser = service.validateUser(name, password);

        if (!isValidUser) {
            model.put("errorMessage", "Invalid Credentials");
            return "login";
        }

        model.put("name", name);
        model.put("password", password);

        return "welcome";
    }

}

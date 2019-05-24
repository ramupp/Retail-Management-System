package com.crunchify.controller;


import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.*;
import com.crunchify.services.RegService;


@RestController
public class RegController {

	private static final Logger logger = Logger.getLogger(RegController.class);
	
  @Autowired
  private RegService regservice;

  //@RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json", consumes="application/json"
 //     )
//  public ResponseEntity<User> UserRegister(@RequestBody User user, HttpServletRequest request) throws Exception
//       {
//	  System.out.println("hello world");
//     logger.debug("UserRegister() method invoked in RegController:");
//    User u = new User();
//    try {
//       u = regservice.Registration(user);
//      return new ResponseEntity<User>(u, HttpStatus.OK);
//    } catch (SpringCrunchifyException e) {
//    	logger.error("Error in  user registration " + this.getClass(), e);    	
//      return new ResponseEntity<User>(u, HttpStatus.OK);
//    }
//    finally
//    {
//    	logger.debug("UserRegister() mehtod executes Successfully:");
//    }
//
//  }


}

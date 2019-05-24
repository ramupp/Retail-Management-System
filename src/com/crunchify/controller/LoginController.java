package com.crunchify.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.CallData;
import com.crunchify.model.OrderCodeMaster;
import com.crunchify.model.SiteDetails;
import com.crunchify.model.User;
import com.crunchify.model.VtplUser;
import com.crunchify.services.Login_Service;

@RestController
public class LoginController {
	
	@Autowired
	private Login_Service service;
	
	/* Logger implementation */
	private static final Logger logger = Logger.getLogger(LoginController.class);
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<User> Login(@RequestBody User user) throws Exception {
		 logger.debug("Login() method invoked in LoginController:");
		User usr=new User();
		try{
			usr=service.login(user.getUid(), user.getPwd());
			return new ResponseEntity<User>(usr ,HttpStatus.OK);
			
		}catch(SpringCrunchifyException e)
		{
			logger.error("Error in login " + this.getClass(), e);
			return new ResponseEntity<User>(user ,HttpStatus.OK);
		}
		finally{
			logger.debug("Login() method executes Successfully:");
		}
				
	}
	
	@RequestMapping(value = "/ajke", method = RequestMethod.GET,produces = "application/json", consumes="application/json")
    public ResponseEntity<SiteDetails> Ajke( HttpServletRequest request) throws Exception {
		 logger.debug("Login() method invoked in LoginController:");
		 SiteDetails st=new SiteDetails();
		 try{
				st=service.getVal(14);
				return new ResponseEntity<SiteDetails>(st ,HttpStatus.OK);
				
			}catch(SpringCrunchifyException e)
			{
				logger.error("Error in login " + this.getClass(), e);
				return new ResponseEntity<SiteDetails>(st ,HttpStatus.OK);
			}
			finally{
				logger.debug("Login() method executes Successfully:");
			}
		
		
	}
	
	@RequestMapping(value = "/saveData", method = RequestMethod.POST, consumes="application/json")
    public String saveData( @RequestBody SiteDetails site) throws Exception {
		 logger.debug("Login() method invoked in LoginController:");
		 SiteDetails st=new SiteDetails();
		 try{
			String	st1=service.setVal(site);
				return st1;
				
			}catch(SpringCrunchifyException e)
			{
				logger.error("Error in login " + this.getClass(), e);
				return "Error";
			}
			finally{
				logger.debug("Login() method executes Successfully:");
			}
		
		
	}
	
	@RequestMapping(value = "/getOrderCodes", method = RequestMethod.GET)
    public ResponseEntity<List<OrderCodeMaster>> getOrderCodes(HttpServletRequest request) throws Exception {
		 logger.debug("Login() method invoked in LoginController:");
		List<OrderCodeMaster> st=new ArrayList<OrderCodeMaster>();
		 try{
				st=service.getOrderCodes();
				return new ResponseEntity<List<OrderCodeMaster>>(st ,HttpStatus.OK);
				
			}catch(SpringCrunchifyException e)
			{
				logger.error("Error in login " + this.getClass(), e);
				return new ResponseEntity<List<OrderCodeMaster>>(st ,HttpStatus.OK);
			}
			finally{
				logger.debug("Login() method executes Successfully:");
			}
		
		
	}
	
	@RequestMapping(value = "/loginForVtpl", method = RequestMethod.POST, produces = "application/json", consumes="application/json")
    public ResponseEntity<List<VtplUser>> loginForVtpl(@RequestBody VtplUser user) throws Exception {
		 logger.debug("Login() method invoked in LoginController:");
		 List<VtplUser> list=new ArrayList<VtplUser>();
		 VtplUser us=new VtplUser();
		 String uname=user.getUid();
		 String pass=user.getPass();
		 System.out.println("send-"+us.getUid());
		 try {
		    	list = service.getLoginStatus(uname,pass);
		      return new ResponseEntity<List<VtplUser>>(list, HttpStatus.OK);
		    } catch (Exception e) {
		    	logger.error("Error in  user permission " + this.getClass(), e);    	
		      return new ResponseEntity<List<VtplUser>>(list, HttpStatus.OK);
		    }
		    finally
		    {
		    	logger.debug("appPermision() mehtod executes Successfully:");
		    }
		
		
	}

}

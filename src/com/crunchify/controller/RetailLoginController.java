package com.crunchify.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.RetailRegistrationBean;
import com.crunchify.services.RetailLoginService;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.MapSerializer;
import com.google.gson.Gson;

@RestController
//@Configuration
//@ComponentScan("com.crunchify.services")
@SessionAttributes("user1")
public class RetailLoginController {
	
	private static final Logger logger = Logger.getLogger(RetailRegistrationBean.class);
	
	@ModelAttribute("user1") 
	public RetailRegistrationBean setUpUserForm() {
	      return new RetailRegistrationBean();
	   }
	
	 @Autowired
	  private RetailLoginService loginservice;
	 @JsonSerialize
     Map<String,List<RetailRegistrationBean>> data=new HashMap<String,List<RetailRegistrationBean>>();

	  @RequestMapping(value = "/retaillogin", method = RequestMethod.POST,produces = "application/json", consumes="application/json")
	  public ResponseEntity<List<RetailRegistrationBean>> appReports(@RequestBody RetailRegistrationBean user, HttpServletRequest request,@ModelAttribute("user1") RetailRegistrationBean user1 ) throws Exception
	       {
		  System.out.println("hello world");
	     logger.debug("appReports() method invoked in VtplReportController:");
	     List<RetailRegistrationBean> list=new ArrayList<RetailRegistrationBean>();
	    try {
	    	list = loginservice.login(user); 
	    	for (RetailRegistrationBean retailRegistrationBean : list) {
	    		user1.setUser_id(retailRegistrationBean.getUser_id());
	    		user1.setUser_nm(retailRegistrationBean.getUser_nm());
	    		user1.setUser_type(retailRegistrationBean.getUser_type());
	    		user1.setCo_id(user.getCo_id());
			}  	
	      return new ResponseEntity<List<RetailRegistrationBean>>(list, HttpStatus.OK);
	    } catch (SpringCrunchifyException e) {
	    	logger.error("Error in  user registration " + this.getClass(), e);    	
	      return new ResponseEntity<List<RetailRegistrationBean>>(list, HttpStatus.OK);
	    }
	    finally
	    {
	    	logger.debug("UserRegister() mehtod executes Successfully:");
	    }

	  }
	  
	  @RequestMapping(value = "/getAllUser", method = RequestMethod.GET,produces = "application/json")
	  public ResponseEntity<List<RetailRegistrationBean>> getAllUser( HttpServletRequest request) throws Exception
	       {
		  System.out.println("hello world");
	     logger.debug("appReports() method invoked in VtplReportController:");
	     List<RetailRegistrationBean> list=new ArrayList<RetailRegistrationBean>();
	    
	     Gson gson = new Gson();
	    try {
	    	list = loginservice.getAllUser();
	    	for (RetailRegistrationBean retailRegistrationBean : list) {
	    		System.out.println(retailRegistrationBean.getUser_id());
			}
	    	System.out.println("Sucessfully executed");
	    	//String x=gson.toJson(list);
	    	//data.put("current", String.valueOf(request.getParameter("current")));
	    	//data.put("rowCount", String.valueOf(request.getParameter("rowCount")));
	    	//data.put("rows", list);
	    	//data.put("total",String.valueOf(list.size()));
	    
	      return new ResponseEntity<List<RetailRegistrationBean>>(list, HttpStatus.OK);
	    } catch (SpringCrunchifyException e) {
	    	logger.error("Error in  user registration " + this.getClass(), e);    	
	      return new ResponseEntity<List<RetailRegistrationBean>>(list, HttpStatus.OK);
	    }
	    finally
	    {
	    	logger.debug("UserRegister() mehtod executes Successfully:");
	    }

	  }

}

package com.crunchify.controller;

import java.net.Socket;
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

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.DropDownBean;
import com.crunchify.model.StockData;
import com.crunchify.services.DropDownService;

@RestController
public class DropDownController {
	
	private static final Logger logger = Logger.getLogger(DropDownBean.class);
	
	
	 @Autowired
	  private DropDownService downService;
	 
	
	 
	  @RequestMapping(value = "/getSelectData", method = RequestMethod.POST,produces = "application/json",consumes="application/json")
	  public ResponseEntity<List<Object>> getSelectData(@RequestBody DropDownBean getData, HttpServletRequest request) throws Exception
	       {
		  System.out.println("hello world");
	     logger.debug("getSelectData() method invoked in VtplReportController:");
	    // String val=getData.getBeanName();
	     List<Object> list=new ArrayList<Object>();
	    try {
	    	list=downService.getSelectData(getData);
	    	
	    	System.out.println("Sucessfully executed");
	    
	      return new ResponseEntity<List<Object>>(list, HttpStatus.OK);
	    } catch (SpringCrunchifyException e) {
	    	logger.error("Error in  user registration " + this.getClass(), e);    	
	      return new ResponseEntity<List<Object>>(list, HttpStatus.OK);
	    }
	    finally
	    {
	    	logger.debug("UserRegister() mehtod executes Successfully:");
	    }

	  }

}

package com.crunchify.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.ItemMasterBean;
import com.crunchify.model.ItemTypeBean;
import com.crunchify.model.MiscHeadBean;
import com.crunchify.model.RetailRegistrationBean;
import com.crunchify.model.RoleDataHdr;
import com.crunchify.model.UserRegRoleCompany;
import com.crunchify.model.UserRoleCompany;
import com.crunchify.services.ItemTypeService;
import com.crunchify.services.MiscHeadService;
import com.crunchify.services.RoleService;

@RestController
public class MiscHeadController {

	private static final Logger logger = Logger.getLogger(RoleCreationController.class);
	
  @Autowired
  private MiscHeadService mischeadservice;

  
  
  @RequestMapping(value = "/miscHead", method = RequestMethod.POST,produces = "application/json", consumes="application/json")
  @ResponseBody
  public String miscHeadCreate(@RequestBody MiscHeadBean misc,HttpServletRequest request) throws Exception
       {	 
     logger.debug("miscHeadCreate() method invoked in VtplReportController:");
     List<MiscHeadBean> list=new ArrayList<MiscHeadBean>();
    try {
    	RetailRegistrationBean rb=(RetailRegistrationBean)request.getSession().getAttribute("user1");
    	misc.setActive("Y");
    	misc.setCreated_by(rb.getUser_id());
    	 Date dt = new Date();
    	 misc.setCreated_on(dt);
    	return mischeadservice.miscHeadCreate(misc);
      
    } catch (Exception e) {
    	logger.error("Error in  miscHeadCreate " + this.getClass(), e);    	
      return "error";
    }
    finally
    {
    	logger.debug("miscHead() mehtod executes Successfully:");
    }

  }
  @RequestMapping(value = "/fetchAllMiscHead", method = RequestMethod.GET,produces = "application/json")
  public ResponseEntity<List<MiscHeadBean>> fetchAllMiscHead( HttpServletRequest request) throws Exception
       {
	  System.out.println("hello world");
     logger.debug("appReports() method invoked in VtplReportController:");
     List<MiscHeadBean> list=new ArrayList<MiscHeadBean>();
    
    try {
    	list = mischeadservice.misc_head();

    	System.out.println("Sucessfully executed");
    	
      return new ResponseEntity<List<MiscHeadBean>>(list, HttpStatus.OK);
    } catch (SpringCrunchifyException e) {
    	logger.error("Error in  user registration " + this.getClass(), e);    	
      return new ResponseEntity<List<MiscHeadBean>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("viewMiscCreate() mehtod executes Successfully:");
    }

  }
  
  

}


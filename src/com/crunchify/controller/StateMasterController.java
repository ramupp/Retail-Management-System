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
import com.crunchify.model.CityMasterBean;
import com.crunchify.model.ItemMasterBean;
import com.crunchify.model.ItemTypeBean;
import com.crunchify.model.RetailRegistrationBean;
import com.crunchify.model.RoleDataHdr;
import com.crunchify.model.StateMasterBean;
import com.crunchify.model.UserRegRoleCompany;
import com.crunchify.model.UserRoleCompany;
import com.crunchify.services.CityMasterService;
import com.crunchify.services.ItemMasterService;
import com.crunchify.services.ItemTypeService;
import com.crunchify.services.RoleService;
import com.crunchify.services.StateMasterService;

@RestController
public class StateMasterController {

	private static final Logger logger = Logger.getLogger(RoleCreationController.class);
	
  @Autowired
  private StateMasterService stateMasterservice;

  
  
  @RequestMapping(value = "/Addstate_master", method = RequestMethod.POST,produces = "application/json", consumes="application/json")
  @ResponseBody
  public String stateMasterCreate(@RequestBody StateMasterBean state_m,HttpServletRequest request) throws Exception
       {	 
     logger.debug("stateMasterCreate() method invoked in VtplReportController:");
     List<StateMasterBean> list=new ArrayList<StateMasterBean>();
    try {
    	RetailRegistrationBean rb=(RetailRegistrationBean)request.getSession().getAttribute("user1");
    	state_m.setActive("Y");
    	state_m.setCreated_by(rb.getUser_id());
    	 Date dt = new Date();
    	 state_m.setCreated_on(dt);
    	return stateMasterservice.stateMasterCreate(state_m);
     
    } catch (Exception e) {
    	logger.error("Error in  stateMasterCreate " + this.getClass(), e);    	
        return "error";
      }
    finally
    {
    	logger.debug("Addcity_master() mehtod executes Successfully:");
    }

  }
  @RequestMapping(value = "/fetchAllState", method = RequestMethod.GET,produces = "application/json")
  public ResponseEntity<List<StateMasterBean>> fetchAllCity( HttpServletRequest request) throws Exception
       {
	  System.out.println("hello world");
     logger.debug("appReports() method invoked in VtplReportController:");
     List<StateMasterBean> list=new ArrayList<StateMasterBean>();
    
    try {
    	list = stateMasterservice.state_type();
//    	for (ItemMasterBean itemMasterservice : list) {
//    		System.out.println(itemMasterservice.item_master());
		
    	System.out.println("Sucessfully executed");
    	//String x=gson.toJson(list);
    	//data.put("current", String.valueOf(request.getParameter("current")));
    	//data.put("rowCount", String.valueOf(request.getParameter("rowCount")));
    	//data.put("rows", list);
    	//data.put("total",String.valueOf(list.size()));
    
      return new ResponseEntity<List<StateMasterBean>>(list, HttpStatus.OK);
    } catch (SpringCrunchifyException e) {
    	logger.error("Error in  user registration " + this.getClass(), e);    	
      return new ResponseEntity<List<StateMasterBean>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("viewStateCreate() mehtod executes Successfully:");
    }

  }
  
  @RequestMapping(value = "/stateUpdate", method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity<List<StateMasterBean>> stateUpdate(@RequestBody StateMasterBean state,HttpServletRequest request) throws Exception
       {	 
     logger.debug("stateUpdate() method invoked in VtplReportController:");
     List<StateMasterBean> list=new ArrayList<StateMasterBean>();
    try {
    	RetailRegistrationBean rb=(RetailRegistrationBean)request.getSession().getAttribute("user1");
    	state.setActive("Y");
    	state.setModified_by(rb.getUser_id());
    	 Date dt = new Date();
    	 state.setModified_on(dt);
    	 stateMasterservice.stateUpdate(state);
    	list = stateMasterservice.state_type();
      return new ResponseEntity<List<StateMasterBean>>(list, HttpStatus.OK);
    } catch (Exception e) {
    	logger.error("Error in  stateUpdate " + this.getClass(), e);    	
    	return new ResponseEntity<List<StateMasterBean>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("Addstate_master() mehtod executes Successfully:");
    }

  }
  @RequestMapping(value = "/stateDelete", method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity<List<StateMasterBean>> stateTypDelete(@RequestBody StateMasterBean state_typ,HttpServletRequest request) throws Exception
  
       {	 
     logger.debug("stateTypDelete() method invoked in VtplReportController:");
     List<StateMasterBean> list=new ArrayList<StateMasterBean>();
    try { 
    	
    	//System.out.println("the item type is:-----"+item_typ.getItm_typ_id());
    
    	RetailRegistrationBean rb=(RetailRegistrationBean)request.getSession().getAttribute("user1");
    	state_typ.setActive("Y");
    	state_typ.setModified_by(rb.getUser_id());
    	 Date dt = new Date();
    	 state_typ.setModified_on(dt);
    	 stateMasterservice.stateTypeDelete(state_typ);
    	list = stateMasterservice.state_type();
      return new ResponseEntity<List<StateMasterBean>>(list, HttpStatus.OK);
    } catch (Exception e) {
    	logger.error("Error in  stateTypeDelete " + this.getClass(), e);    	
    	return new ResponseEntity<List<StateMasterBean>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("Addstate_master() mehtod executes Successfully:");
    }

  }
  



}


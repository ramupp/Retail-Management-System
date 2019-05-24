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
import com.crunchify.model.ConsgMasterBean;
import com.crunchify.model.ConsgViewBean;
import com.crunchify.model.ItemMasterBean;
import com.crunchify.model.ItemTypeBean;
import com.crunchify.model.PartyMasterBean;
import com.crunchify.model.PartyViewBean;
import com.crunchify.model.RetailRegistrationBean;
import com.crunchify.model.RoleDataHdr;
import com.crunchify.model.UserRegRoleCompany;
import com.crunchify.model.UserRoleCompany;
import com.crunchify.model.view.ItemMasterViewBean;
import com.crunchify.services.ItemMasterService;
import com.crunchify.services.ItemTypeService;
import com.crunchify.services.PartyConsgService;
import com.crunchify.services.PartyMasterService;
import com.crunchify.services.RoleService;

@RestController
public class PartyConsgController {

	private static final Logger logger = Logger.getLogger(RoleCreationController.class);
	
  @Autowired
  private PartyConsgService consg_masterservice;

  
  
  @RequestMapping(value = "/Addparty_consg", method = RequestMethod.POST,produces = "application/json", consumes="application/json")
  @ResponseBody
  public String consgMasterCreate(@RequestBody ConsgMasterBean consg_m,HttpServletRequest request) throws Exception
       {	 
     logger.debug("consgMasterCreate() method invoked in VtplReportController:");
     List<ConsgMasterBean> list=new ArrayList<ConsgMasterBean>();
    try {
    	RetailRegistrationBean rb=(RetailRegistrationBean)request.getSession().getAttribute("user1");
    	consg_m.setActive("Y");
    	consg_m.setCreated_by(rb.getUser_id());
    	 Date dt = new Date();
    	 consg_m.setCreated_on(dt);
    	return consg_masterservice.consgMasterCreate(consg_m);
     // return new ResponseEntity<List<PartyMasterBean>>(list, HttpStatus.OK);
    } catch (Exception e) {
    	logger.error("Error in  consgMasterCreate " + this.getClass(), e);    	
     // return new ResponseEntity<List<PartyMasterBean>>(list, HttpStatus.OK);
    	return "error";
    }
    finally
    {
    	logger.debug("Addconsg_master() mehtod executes Successfully:");
    }

  }
  @RequestMapping(value = "/fetchAllConsgMaster", method = RequestMethod.GET,produces = "application/json")
  public ResponseEntity<List<ConsgViewBean>> fetchAllConsgType( HttpServletRequest request) throws Exception
       {
	  System.out.println("hello world");
     logger.debug("appReports() method invoked in VtplReportController:");
     List<ConsgViewBean> list=new ArrayList<ConsgViewBean>();
    
    try {
    	list = consg_masterservice.consg_master();
//    	for (ItemMasterBean itemMasterservice : list) {
//    		System.out.println(itemMasterservice.item_master());
		
    	System.out.println("Sucessfully executed");
    	//String x=gson.toJson(list);
    	//data.put("current", String.valueOf(request.getParameter("current")));
    	//data.put("rowCount", String.valueOf(request.getParameter("rowCount")));
    	//data.put("rows", list);
    	//data.put("total",String.valueOf(list.size()));
    
      return new ResponseEntity<List<ConsgViewBean>>(list, HttpStatus.OK);
    } catch (SpringCrunchifyException e) {
    	logger.error("Error in  user registration " + this.getClass(), e);    	
      return new ResponseEntity<List<ConsgViewBean>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("viewConsgMasterCreate() mehtod executes Successfully:");
    }

  }
  @RequestMapping(value = "/consgUpdate", method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity<List<ConsgMasterBean>> consgUpdate(@RequestBody ConsgMasterBean consg,HttpServletRequest request) throws Exception
       {	 
     logger.debug("consgUpdate() method invoked in VtplReportController:");
     List<ConsgMasterBean> list=new ArrayList<ConsgMasterBean>();
     System.out.println("Pani Pani de.....");
    try {
    	RetailRegistrationBean rb=(RetailRegistrationBean)request.getSession().getAttribute("user1");
    	consg.setActive("Y");
    	consg.setModified_by(rb.getUser_id());
    	 Date dt = new Date();
    	 consg.setModified_on(dt);
    	 consg_masterservice.consgUpdate(consg);
    	//list = consg_masterservice.consg();
      return new ResponseEntity<List<ConsgMasterBean>>(list, HttpStatus.OK);
    } catch (Exception e) {
    	logger.error("Error in  consgMasterCreate " + this.getClass(), e);    	
    	return new ResponseEntity<List<ConsgMasterBean>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("Addparty_consg() mehtod executes Successfully:");
    }

  }
  
  
  @RequestMapping(value = "/partyConsgDelete", method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity<List<ConsgMasterBean>> consgTypDelete(@RequestBody ConsgMasterBean consg_typ,HttpServletRequest request) throws Exception
  
       {	 
     logger.debug("consgTypDelete() method invoked in VtplReportController:");
     List<ConsgMasterBean> list=new ArrayList<ConsgMasterBean>();
    try { 
    	//System.out.println("the item type is:-----"+item_typ.getItm_typ_id());
    
    	RetailRegistrationBean rb=(RetailRegistrationBean)request.getSession().getAttribute("user1");
    	consg_typ.setActive("Y");
    	consg_typ.setModified_by(rb.getUser_id());
    	 Date dt = new Date();
    	 consg_typ.setModified_on(dt);
    	 consg_masterservice.consgTypeDelete(consg_typ);
    	//list = consg_masterservice.consg_type();
      return new ResponseEntity<List<ConsgMasterBean>>(list, HttpStatus.OK);
    } catch (Exception e) {
    	logger.error("Error in  consgTypeDelete " + this.getClass(), e);    	
    	return new ResponseEntity<List<ConsgMasterBean>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("Addparty_consg() mehtod executes Successfully:");
    }

  }
}


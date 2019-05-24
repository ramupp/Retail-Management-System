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
import com.crunchify.model.ItemRateTypeBean;
import com.crunchify.model.ItemTypeBean;
import com.crunchify.model.PartyTypeBean;
import com.crunchify.model.RetailRegistrationBean;
import com.crunchify.model.RoleDataHdr;
import com.crunchify.model.UserRegRoleCompany;
import com.crunchify.model.UserRoleCompany;
import com.crunchify.services.ItemMasterService;
import com.crunchify.services.ItemTypeService;
import com.crunchify.services.PartyTypeService;
import com.crunchify.services.RoleService;

@RestController
public class PartyTypeController {

	private static final Logger logger = Logger.getLogger(RoleCreationController.class);
	
  @Autowired
  private PartyTypeService partyTypeservice;

  
  
  @RequestMapping(value = "/Addparty_typ", method = RequestMethod.POST,produces = "application/json", consumes="application/json")
  @ResponseBody
  public String partyTypeCreate(@RequestBody PartyTypeBean party,HttpServletRequest request) throws Exception
       {	 
     logger.debug("partyTypeCreate() method invoked in VtplReportController:");
     List<PartyTypeBean> list=new ArrayList<PartyTypeBean>();
    try {
    	RetailRegistrationBean rb=(RetailRegistrationBean)request.getSession().getAttribute("user1");
    	party.setActive("Y");
    	party.setCreated_by(rb.getUser_id());
    	 Date dt = new Date();
    	 party.setCreated_on(dt);
    	return partyTypeservice.partyTypeCreate(party);
      //return new ResponseEntity<List<PartyTypeBean>>(list, HttpStatus.OK);
    } catch (Exception e) {
    	logger.error("Error in  partyTypeCreate " + this.getClass(), e);    	
      //return new ResponseEntity<List<PartyTypeBean>>(list, HttpStatus.OK);
    	return "error";
    }
    finally
    {
    	logger.debug("Addparty_typ() mehtod executes Successfully:");
    }

  }
  
  @RequestMapping(value = "/fetchAllPartyType", method = RequestMethod.GET,produces = "application/json")
  public ResponseEntity<List<PartyTypeBean>> fetchAllPartyType( HttpServletRequest request) throws Exception
       {
	  System.out.println("hello world");
     logger.debug("appReports() method invoked in VtplReportController:");
     List<PartyTypeBean> list=new ArrayList<PartyTypeBean>();
    
    try {
    	list = partyTypeservice.party_type();
//    	for (ItemMasterBean itemMasterservice : list) {
//    		System.out.println(itemMasterservice.item_master());
		
    	System.out.println("Sucessfully executed");
    	//String x=gson.toJson(list);
    	//data.put("current", String.valueOf(request.getParameter("current")));
    	//data.put("rowCount", String.valueOf(request.getParameter("rowCount")));
    	//data.put("rows", list);
    	//data.put("total",String.valueOf(list.size()));
    
      return new ResponseEntity<List<PartyTypeBean>>(list, HttpStatus.OK);
    } catch (SpringCrunchifyException e) {
    	logger.error("Error in  user registration " + this.getClass(), e);    	
      return new ResponseEntity<List<PartyTypeBean>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("viewPartyTypCreate() mehtod executes Successfully:");
    }

  }
  
  @RequestMapping(value = "/partytypUpdate", method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity<List<PartyTypeBean>> partyTypUpdate(@RequestBody PartyTypeBean party,HttpServletRequest request) throws Exception
       {	 
     logger.debug("partyTypUpdate() method invoked in VtplReportController:");
     List<PartyTypeBean> list=new ArrayList<PartyTypeBean>();
    try {
    	RetailRegistrationBean rb=(RetailRegistrationBean)request.getSession().getAttribute("user1");
    	party.setActive("Y");
    	party.setModified_by(rb.getUser_id());
    	 Date dt = new Date();
    	 party.setModified_on(dt);
    	 partyTypeservice.partyTypeUpdate(party);
    	list = partyTypeservice.party_type();
      return new ResponseEntity<List<PartyTypeBean>>(list, HttpStatus.OK);
    } catch (Exception e) {
    	logger.error("Error in  itemTypeUpdate " + this.getClass(), e);    	
    	return new ResponseEntity<List<PartyTypeBean>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("Addparty_typ() mehtod executes Successfully:");
    }

  }
  
  @RequestMapping(value = "/associateTypeDelete", method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity<List<PartyTypeBean>> associateTypDelete(@RequestBody PartyTypeBean associate_typ,HttpServletRequest request) throws Exception
  
       {	 
     logger.debug("associateTypDelete() method invoked in VtplReportController:");
     List<PartyTypeBean> list=new ArrayList<PartyTypeBean>();
    try { 
    	System.out.println("the associate typeis:-----"+associate_typ.getParty_typ_id());
    
    	RetailRegistrationBean rb=(RetailRegistrationBean)request.getSession().getAttribute("user1");
    	associate_typ.setActive("Y");
    	associate_typ.setModified_by(rb.getUser_id());
    	 Date dt = new Date();
    	 associate_typ.setModified_on(dt);
    	 partyTypeservice.associateTypeDelete(associate_typ);
    	//list = itemrateservice.rate_typ();
      return new ResponseEntity<List<PartyTypeBean>>(list, HttpStatus.OK);
    } catch (Exception e) {
    	logger.error("Error in  rateTypeDelete " + this.getClass(), e);    	
    	return new ResponseEntity<List<PartyTypeBean>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("Addparty_typ() mehtod executes Successfully:");
    }

  }
  
  


}


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
import com.crunchify.model.RetailRegistrationBean;
import com.crunchify.model.RoleDataHdr;
import com.crunchify.model.UomMasterBean;
import com.crunchify.model.UserRegRoleCompany;
import com.crunchify.model.UserRoleCompany;
import com.crunchify.services.ItemMasterService;
import com.crunchify.services.ItemTypeService;
import com.crunchify.services.RoleService;
import com.crunchify.services.UomMasterService;

@RestController
public class UomMasterController {

	private static final Logger logger = Logger.getLogger(RoleCreationController.class);
	
  @Autowired
  private UomMasterService uomMasterservice;

  
  
  @RequestMapping(value = "/Adduom_master", method = RequestMethod.POST,produces = "application/json", consumes="application/json")
  @ResponseBody
  public String uomMasterCreate(@RequestBody UomMasterBean uom_m,HttpServletRequest request) throws Exception
       {	 
     logger.debug("uomMasterCreate() method invoked in VtplReportController:");
     List<UomMasterBean> list=new ArrayList<UomMasterBean>();
    try {
    	RetailRegistrationBean rb=(RetailRegistrationBean)request.getSession().getAttribute("user1");
    	uom_m.setActive("Y");
    	uom_m.setCreated_by(rb.getUser_id());
    	 Date dt = new Date();
    	 uom_m.setCreated_on(dt);
    	return uomMasterservice.uomMasterCreate(uom_m);
     // return new ResponseEntity<List<UomMasterBean>>(list, HttpStatus.OK);
    } catch (Exception e) {
    	logger.error("Error in  uomMasterCreate " + this.getClass(), e);    	
      return "error";
    }
    finally
    {
    	logger.debug("Adduom_master() mehtod executes Successfully:");
    }

  }
  @RequestMapping(value = "/fetchAllUomMaster", method = RequestMethod.GET,produces = "application/json")
  public ResponseEntity<List<UomMasterBean>> fetchAllUomMaster( HttpServletRequest request) throws Exception
       {
	  System.out.println("hello world");
     logger.debug("appReports() method invoked in VtplReportController:");
     List<UomMasterBean> list=new ArrayList<UomMasterBean>();
    
    try {
    	list = uomMasterservice.uom_master();
//    	for (ItemMasterBean itemMasterservice : list) {
//    		System.out.println(itemMasterservice.item_master());
		
    	System.out.println("Sucessfully executed");
    	//String x=gson.toJson(list);
    	//data.put("current", String.valueOf(request.getParameter("current")));
    	//data.put("rowCount", String.valueOf(request.getParameter("rowCount")));
    	//data.put("rows", list);
    	//data.put("total",String.valueOf(list.size()));
    
      return new ResponseEntity<List<UomMasterBean>>(list, HttpStatus.OK);
    } catch (SpringCrunchifyException e) {
    	logger.error("Error in  user registration " + this.getClass(), e);    	
      return new ResponseEntity<List<UomMasterBean>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("viewMasterCreate() mehtod executes Successfully:");
    }

  }
  
  @RequestMapping(value = "/Updateuom_master", method = RequestMethod.POST,consumes="application/json")
  public ResponseEntity<List<UomMasterBean>> uomMasterUpdate(@RequestBody UomMasterBean uom_m,HttpServletRequest request) throws Exception
       {	
	  System.out.println("Pani pani de...");
     logger.debug("uomMasterUpdate() method invoked in VtplReportController:");
     List<UomMasterBean> list=new ArrayList<UomMasterBean>();
    try {
    	RetailRegistrationBean rb=(RetailRegistrationBean)request.getSession().getAttribute("user1");
    	uom_m.setActive("Y");
    	uom_m.setModified_by(rb.getUser_id()); 
    	Date dt = new Date();
    	uom_m.setModified_on(dt);
    	 uomMasterservice.uomMasterUpdate(uom_m);
    	 list = uomMasterservice.uom_master();
    	 return new ResponseEntity<List<UomMasterBean>>(list, HttpStatus.OK);
     // return new ResponseEntity<List<UomMasterBean>>(list, HttpStatus.OK);
    } catch (Exception e) {
    	logger.error("Error in  user registration " + this.getClass(), e);    	
        return new ResponseEntity<List<UomMasterBean>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("Adduom_master() mehtod executes Successfully:");
    }

  }
  
  @RequestMapping(value = "/uomDelete", method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity<List<UomMasterBean>> uomTypDelete(@RequestBody UomMasterBean uom_typ,HttpServletRequest request) throws Exception
  
       {	 
     logger.debug("uomTypDelete() method invoked in VtplReportController:");
     List<UomMasterBean> list=new ArrayList<UomMasterBean>();
    try { 
    	//System.out.println("the item type is:-----"+item_typ.getItm_typ_id());
    
    	RetailRegistrationBean rb=(RetailRegistrationBean)request.getSession().getAttribute("user1");
    	uom_typ.setActive("Y");
    	uom_typ.setModified_by(rb.getUser_id());
    	 Date dt = new Date();
    	 uom_typ.setModified_on(dt);
    	 uomMasterservice.uomTypeDelete(uom_typ);
    	//list =     	 uomMasterservice.uom_typ();
      return new ResponseEntity<List<UomMasterBean>>(list, HttpStatus.OK);
    } catch (Exception e) {
    	logger.error("Error in  uomTypeDelete " + this.getClass(), e);    	
    	return new ResponseEntity<List<UomMasterBean>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("Adduom_master() mehtod executes Successfully:");
    }

  }
 




}


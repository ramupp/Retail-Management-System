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
import com.crunchify.model.UserRegRoleCompany;
import com.crunchify.model.UserRoleCompany;
import com.crunchify.services.ItemTypeService;
import com.crunchify.services.RoleService;

@RestController
public class ItemTypeController {

	private static final Logger logger = Logger.getLogger(RoleCreationController.class);
	
  @Autowired
  private ItemTypeService itemtypeservice;

  
  
  @RequestMapping(value = "/itmtyp", method = RequestMethod.POST,produces = "application/json", consumes="application/json")
  @ResponseBody
  public String itemTypCreate(@RequestBody ItemTypeBean item,HttpServletRequest request) throws Exception
       {	 
     logger.debug("itemTypCreate() method invoked in VtplReportController:");
     List<ItemTypeBean> list=new ArrayList<ItemTypeBean>();
    try {
    	RetailRegistrationBean rb=(RetailRegistrationBean)request.getSession().getAttribute("user1");
    	item.setActive("Y");
    	item.setCreated_by(rb.getUser_id());
    	 Date dt = new Date();
    	 item.setCreated_on(dt);
    	return itemtypeservice.itemTypeCreate(item);
      
    } catch (Exception e) {
    	logger.error("Error in  ItemtypeCreate " + this.getClass(), e);    	
      return "error";
    }
    finally
    {
    	logger.debug("itmtyp() mehtod executes Successfully:");
    }

  }
  @RequestMapping(value = "/fetchAllItmType", method = RequestMethod.GET,produces = "application/json")
  public ResponseEntity<List<ItemTypeBean>> fetchAllItemMaster( HttpServletRequest request) throws Exception
       {
	  System.out.println("hello world");
     logger.debug("appReports() method invoked in VtplReportController:");
     List<ItemTypeBean> list=new ArrayList<ItemTypeBean>();
    
    try {
    	list = itemtypeservice.item_type();
//    	for (ItemMasterBean itemMasterservice : list) {
//    		System.out.println(itemMasterservice.item_master());
		
    	System.out.println("Sucessfully executed");
    	//String x=gson.toJson(list);
    	//data.put("current", String.valueOf(request.getParameter("current")));
    	//data.put("rowCount", String.valueOf(request.getParameter("rowCount")));
    	//data.put("rows", list);
    	//data.put("total",String.valueOf(list.size()));
    
      return new ResponseEntity<List<ItemTypeBean>>(list, HttpStatus.OK);
    } catch (SpringCrunchifyException e) {
    	logger.error("Error in  user registration " + this.getClass(), e);    	
      return new ResponseEntity<List<ItemTypeBean>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("viewTypCreate() mehtod executes Successfully:");
    }

  }
  
  @RequestMapping(value = "/itmtypUpdate", method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity<List<ItemTypeBean>> itemTypUpdate(@RequestBody ItemTypeBean item,HttpServletRequest request) throws Exception
       {	 
     logger.debug("itemTypUpdate() method invoked in VtplReportController:");
     List<ItemTypeBean> list=new ArrayList<ItemTypeBean>();
    try {
    	RetailRegistrationBean rb=(RetailRegistrationBean)request.getSession().getAttribute("user1");
    	item.setActive("Y");
    	item.setModified_by(rb.getUser_id());
    	 Date dt = new Date();
    	 item.setModified_on(dt);
    	itemtypeservice.itemTypeUpdate(item);
    	list = itemtypeservice.item_type();
      return new ResponseEntity<List<ItemTypeBean>>(list, HttpStatus.OK);
    } catch (Exception e) {
    	logger.error("Error in  itemTypeUpdate " + this.getClass(), e);    	
    	return new ResponseEntity<List<ItemTypeBean>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("itmtyp() mehtod executes Successfully:");
    }

  }
  
  @RequestMapping(value = "/itmtypDelete", method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity<List<ItemTypeBean>> itemTypDelete(@RequestBody ItemTypeBean item_typ,HttpServletRequest request) throws Exception
  
       {	 
     logger.debug("itemTypDelete() method invoked in VtplReportController:");
     List<ItemTypeBean> list=new ArrayList<ItemTypeBean>();
    try { System.out.println("the item type is:-----"+item_typ.getItm_typ_id());
    
    	RetailRegistrationBean rb=(RetailRegistrationBean)request.getSession().getAttribute("user1");
    	item_typ.setActive("Y");
    	item_typ.setModified_by(rb.getUser_id());
    	 Date dt = new Date();
    	 item_typ.setModified_on(dt);
    	itemtypeservice.itemTypeDelete(item_typ);
    	list = itemtypeservice.item_type();
      return new ResponseEntity<List<ItemTypeBean>>(list, HttpStatus.OK);
    } catch (Exception e) {
    	logger.error("Error in  itemTypeDelete " + this.getClass(), e);    	
    	return new ResponseEntity<List<ItemTypeBean>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("itmtyp() mehtod executes Successfully:");
    }

  }
  
 


}


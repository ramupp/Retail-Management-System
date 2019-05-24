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
import com.crunchify.model.view.ItemMasterViewBean;
import com.crunchify.services.ItemMasterService;
import com.crunchify.services.ItemTypeService;
import com.crunchify.services.RoleService;
import com.google.gson.Gson;

@RestController
public class ItemMasterController {

	private static final Logger logger = Logger.getLogger(RoleCreationController.class);
	
  @Autowired
  private ItemMasterService itemMasterservice;


  
  
  @RequestMapping(value = "/Additm_master", method = RequestMethod.POST,produces = "application/json", consumes="application/json")
  @ResponseBody
  public String itemMasterCreate(@RequestBody ItemMasterBean item_m,HttpServletRequest request) throws Exception
       {	 
     logger.debug("itemMasterCreate() method invoked in VtplReportController:");
     List<ItemMasterBean> list=new ArrayList<ItemMasterBean>();
    try {
    	RetailRegistrationBean rb=(RetailRegistrationBean)request.getSession().getAttribute("user1");
    	item_m.setActive("Y");
    	item_m.setCreated_by(rb.getUser_id());
    	 Date dt = new Date();
    	 item_m.setCreated_on(dt);
    	return itemMasterservice.itemMasterCreate(item_m);
      //return new ResponseEntity<List<ItemMasterBean>>(list, HttpStatus.OK);
    } catch (Exception e) {
    	logger.error("Error in  itemMasterCreate " + this.getClass(), e);    	
      return "error";
    }
    finally
    {
    	logger.debug("Additm_master() mehtod executes Successfully:");
    }

  }
  
  @RequestMapping(value = "/fetchAllItemMaster", method = RequestMethod.GET,produces = "application/json")
  public ResponseEntity<List<ItemMasterViewBean>> Additm_master( HttpServletRequest request) throws Exception
       {
	  System.out.println("hello world");
     logger.debug("appReports() method invoked in VtplReportController:");
     List<ItemMasterViewBean> list=new ArrayList<ItemMasterViewBean>();
    
    try {
    	list = itemMasterservice.item_master();
//    	for (ItemMasterBean itemMasterservice : list) {
//    		System.out.println(itemMasterservice.item_master());
		
    	System.out.println("Sucessfully executed");
    	//String x=gson.toJson(list);
    	//data.put("current", String.valueOf(request.getParameter("current")));
    	//data.put("rowCount", String.valueOf(request.getParameter("rowCount")));
    	//data.put("rows", list);
    	//data.put("total",String.valueOf(list.size()));
    
      return new ResponseEntity<List<ItemMasterViewBean>>(list, HttpStatus.OK);
    } catch (SpringCrunchifyException e) {
    	logger.error("Error in  user registration " + this.getClass(), e);    	
      return new ResponseEntity<List<ItemMasterViewBean>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("viewMasterCreate() mehtod executes Successfully:");
    }

  }
  @RequestMapping(value = "/itmUpdate", method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity<List<ItemMasterViewBean>> itmUpdate(@RequestBody ItemMasterBean data,HttpServletRequest request) throws Exception
       {	 
     logger.debug("itmUpdate() method invoked in VtplReportController:");
     List<ItemMasterViewBean> list=new ArrayList<ItemMasterViewBean>();
     System.out.println("Pani Pani de.....");
    try {
    	RetailRegistrationBean rb=(RetailRegistrationBean)request.getSession().getAttribute("user1");
    	data.setActive("Y");
    	data.setModified_by(rb.getUser_id());
    	 Date dt = new Date();
    	 data.setModified_on(dt);
    	itemMasterservice.itemMasterUpdate(data);
    	list = itemMasterservice.item_master();
      return new ResponseEntity<List<ItemMasterViewBean>>(list, HttpStatus.OK);
    } catch (Exception e) {
    	logger.error("Error in  itemMasterCreate " + this.getClass(), e);    	
    	return new ResponseEntity<List<ItemMasterViewBean>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("Additm_master() mehtod executes Successfully:");
    }

  }
  
  @RequestMapping(value = "/itmDelete", method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity<List<ItemMasterViewBean>> itemMasterDelete(@RequestBody ItemMasterBean item_master,HttpServletRequest request) throws Exception
  
       {	 
     logger.debug("itemMasterDelete() method invoked in VtplReportController:");
     List<ItemMasterViewBean> list=new ArrayList<ItemMasterViewBean>();
    try {
    	System.out.println("the item master is:-----"+item_master.getItm_typ_id());
    
    	RetailRegistrationBean rb=(RetailRegistrationBean)request.getSession().getAttribute("user1");
    	item_master.setActive("Y");
    	item_master.setModified_by(rb.getUser_id());
    	 Date dt = new Date();
    	 item_master.setModified_on(dt);
    	 itemMasterservice.itemMasterDelete(item_master);
    	list = itemMasterservice.item_master();
      return new ResponseEntity<List<ItemMasterViewBean>>(list, HttpStatus.OK);
    } catch (Exception e) {
    	logger.error("Error in  itemTypeDelete " + this.getClass(), e);    	
    	return new ResponseEntity<List<ItemMasterViewBean>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("itmtyp() mehtod executes Successfully:");
    }

  }


}


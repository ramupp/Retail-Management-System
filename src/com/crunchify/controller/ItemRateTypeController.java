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
import com.crunchify.model.RetailRegistrationBean;
import com.crunchify.model.RoleDataHdr;
import com.crunchify.model.UserRegRoleCompany;
import com.crunchify.model.UserRoleCompany;
import com.crunchify.services.ItemRateTypeService;
import com.crunchify.services.ItemTypeService;
import com.crunchify.services.RoleService;

@RestController
public class ItemRateTypeController {

	private static final Logger logger = Logger.getLogger(RoleCreationController.class);
	
  @Autowired
  private ItemRateTypeService itemrateservice;

  
  
  @RequestMapping(value = "/Addrate_typ", method = RequestMethod.POST,produces = "application/json", consumes="application/json")
  @ResponseBody
  public String itemRateCreate(@RequestBody ItemRateTypeBean item_rate,HttpServletRequest request) throws Exception
       {	 
     logger.debug("itemRateCreate() method invoked in VtplReportController:");
     List<ItemRateTypeBean> list=new ArrayList<ItemRateTypeBean>();
    try {
    	RetailRegistrationBean rb=(RetailRegistrationBean)request.getSession().getAttribute("user1");
    	item_rate.setActive("Y");
    	item_rate.setCreated_by(rb.getUser_id());
    	 Date dt = new Date();
    	 item_rate.setCreated_on(dt);
    	return itemrateservice.itemRateCreate(item_rate);
     // return new ResponseEntity<List<ItemRateTypeBean>>(list, HttpStatus.OK);
    } catch (Exception e) {
    	logger.error("Error in  ItemRateCreate " + this.getClass(), e);    	
     // return new ResponseEntity<List<ItemRateTypeBean>>(list, HttpStatus.OK);
    	return "error";
    }
    finally
    {
    	logger.debug("Addrate_typ() mehtod executes Successfully:");
    }

  }
  
  @RequestMapping(value = "/fetchAllRateType", method = RequestMethod.GET,produces = "application/json")
  public ResponseEntity<List<ItemRateTypeBean>> fetchAllRateType( HttpServletRequest request) throws Exception
       {
	  System.out.println("hello world");
     logger.debug("appReports() method invoked in VtplReportController:");
     List<ItemRateTypeBean> list=new ArrayList<ItemRateTypeBean>();
    
    try {
    	list = itemrateservice.item_rate();
//    	for (ItemMasterBean itemMasterservice : list) {
//    		System.out.println(itemMasterservice.item_master());
		
    	System.out.println("Sucessfully executed");
    	//String x=gson.toJson(list);
    	//data.put("current", String.valueOf(request.getParameter("current")));
    	//data.put("rowCount", String.valueOf(request.getParameter("rowCount")));
    	//data.put("rows", list);
    	//data.put("total",String.valueOf(list.size()));
    
      return new ResponseEntity<List<ItemRateTypeBean>>(list, HttpStatus.OK);
    } catch (SpringCrunchifyException e) {
    	logger.error("Error in  user registration " + this.getClass(), e);    	
      return new ResponseEntity<List<ItemRateTypeBean>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("viewRateCreate() mehtod executes Successfully:");
    }

  }
  @RequestMapping(value = "/rateUpdate", method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity<List<ItemRateTypeBean>> rateUpdate(@RequestBody ItemRateTypeBean rate,HttpServletRequest request) throws Exception
       {	 
     logger.debug("rateUpdate() method invoked in VtplReportController:");
     List<ItemRateTypeBean> list=new ArrayList<ItemRateTypeBean>();
     System.out.println("Pani Pani de.....");
    try {
    	RetailRegistrationBean rb=(RetailRegistrationBean)request.getSession().getAttribute("user1");
    	rate.setActive("Y");
    	rate.setModified_by(rb.getUser_id());
    	 Date dt = new Date();
    	 rate.setModified_on(dt);
    	 itemrateservice.itemRateUpdate(rate);
    	list = itemrateservice.item_rate();
      return new ResponseEntity<List<ItemRateTypeBean>>(list, HttpStatus.OK);
    } catch (Exception e) {
    	logger.error("Error in  itemRateCreate " + this.getClass(), e);    	
    	return new ResponseEntity<List<ItemRateTypeBean>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("Addrate_master() mehtod executes Successfully:");
    }

  }
  
  @RequestMapping(value = "/rateTypeDelete", method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity<List<ItemRateTypeBean>> rateTypDelete(@RequestBody ItemRateTypeBean rate_typ,HttpServletRequest request) throws Exception
  
       {	 
     logger.debug("rateTypDelete() method invoked in VtplReportController:");
     List<ItemRateTypeBean> list=new ArrayList<ItemRateTypeBean>();
    try { 
    	System.out.println("the rate typeis:-----"+rate_typ.getRt_typ_id());
    
    	RetailRegistrationBean rb=(RetailRegistrationBean)request.getSession().getAttribute("user1");
    	rate_typ.setActive("Y");
    	rate_typ.setModified_by(rb.getUser_id());
    	 Date dt = new Date();
    	 rate_typ.setModified_on(dt);
    	 itemrateservice.rateTypeDelete(rate_typ);
    	//list = itemrateservice.rate_typ();
      return new ResponseEntity<List<ItemRateTypeBean>>(list, HttpStatus.OK);
    } catch (Exception e) {
    	logger.error("Error in  rateTypeDelete " + this.getClass(), e);    	
    	return new ResponseEntity<List<ItemRateTypeBean>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("Addrate_typ() mehtod executes Successfully:");
    }

  }
  

}


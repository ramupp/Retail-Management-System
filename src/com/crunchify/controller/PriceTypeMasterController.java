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
import com.crunchify.model.PriceTypeMasterBean;
import com.crunchify.model.RetailRegistrationBean;
import com.crunchify.model.RoleDataHdr;
import com.crunchify.model.UserRegRoleCompany;
import com.crunchify.model.UserRoleCompany;
import com.crunchify.services.ItemMasterService;
import com.crunchify.services.ItemTypeService;
import com.crunchify.services.PriceTypeMasterService;
import com.crunchify.services.RoleService;

@RestController
public class PriceTypeMasterController {

	private static final Logger logger = Logger.getLogger(RoleCreationController.class);
	
  @Autowired
  private PriceTypeMasterService pricetypMasterservice;

  
  
  @RequestMapping(value = "/Add_prc_typ", method = RequestMethod.POST,produces = "application/json", consumes="application/json")
  @ResponseBody
  public String priceMasterCreate(@RequestBody PriceTypeMasterBean price_m,HttpServletRequest request) throws Exception
       {	 
     logger.debug("priceMasterCreate() method invoked in VtplReportController:");
     List<PriceTypeMasterBean> list=new ArrayList<PriceTypeMasterBean>();
    try {
    	RetailRegistrationBean rb=(RetailRegistrationBean)request.getSession().getAttribute("user1");
    	price_m.setActive("Y");
    	price_m.setCreated_by(rb.getUser_id());
    	 Date dt = new Date();
    	 price_m.setCreated_on(dt);
    	return pricetypMasterservice.priceMasterCreate(price_m);
     // return new ResponseEntity<List<PriceTypeMasterBean>>(list, HttpStatus.OK);
    } catch (Exception e) {
    	logger.error("Error in  priceMasterCreate " + this.getClass(), e);    	
      return "error";
    }
    finally
    {
    	logger.debug("Add_prc_typ() mehtod executes Successfully:");
    }

  }
  @RequestMapping(value = "/fetchAllPrice", method = RequestMethod.GET,produces = "application/json")
  public ResponseEntity<List<PriceTypeMasterBean>> fetchAllPrice( HttpServletRequest request) throws Exception
       {
	  System.out.println("hello world");
     logger.debug("appReports() method invoked in VtplReportController:");
     List<PriceTypeMasterBean> list=new ArrayList<PriceTypeMasterBean>();
    
    try {
    	list = pricetypMasterservice.price_type();
//    	for (ItemMasterBean itemMasterservice : list) {
//    		System.out.println(itemMasterservice.item_master());
		
    	System.out.println("Sucessfully executed");
    	//String x=gson.toJson(list);
    	//data.put("current", String.valueOf(request.getParameter("current")));
    	//data.put("rowCount", String.valueOf(request.getParameter("rowCount")));
    	//data.put("rows", list);
    	//data.put("total",String.valueOf(list.size()));
    
      return new ResponseEntity<List<PriceTypeMasterBean>>(list, HttpStatus.OK);
    } catch (SpringCrunchifyException e) {
    	logger.error("Error in  user registration " + this.getClass(), e);    	
      return new ResponseEntity<List<PriceTypeMasterBean>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("viewpriceCreate() mehtod executes Successfully:");
    }

  }
  
  @RequestMapping(value = "/priceTypeUpdate", method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity<List<PriceTypeMasterBean>> priceTypUpdate(@RequestBody PriceTypeMasterBean price_type,HttpServletRequest request) throws Exception
       {	 
     logger.debug("priceTypUpdate() method invoked in VtplReportController:");
     List<PriceTypeMasterBean> list=new ArrayList<PriceTypeMasterBean>();
    try {
    	RetailRegistrationBean rb=(RetailRegistrationBean)request.getSession().getAttribute("user1");
    	price_type.setActive("Y");
    	price_type.setModified_by(rb.getUser_id());
    	 Date dt = new Date();
    	 price_type.setModified_on(dt);
    	 pricetypMasterservice.priceTypUpdate(price_type);
    	list = pricetypMasterservice.price_type();
      return new ResponseEntity<List<PriceTypeMasterBean>>(list, HttpStatus.OK);
    } catch (Exception e) {
    	logger.error("Error in  priceTypUpdate " + this.getClass(), e);    	
    	return new ResponseEntity<List<PriceTypeMasterBean>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("itmtyp() mehtod executes Successfully:");
    }

  }
  
  
  @RequestMapping(value = "/priceTypeDelete", method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity<List<PriceTypeMasterBean>> priceTypDelete(@RequestBody PriceTypeMasterBean price_typ,HttpServletRequest request) throws Exception
  
       {	 
     logger.debug("priceTypDelete() method invoked in VtplReportController:");
     List<PriceTypeMasterBean> list=new ArrayList<PriceTypeMasterBean>();
    try { 
    	//System.out.println("the item type is:-----"+item_typ.getItm_typ_id());
    
    	RetailRegistrationBean rb=(RetailRegistrationBean)request.getSession().getAttribute("user1");
    	price_typ.setActive("Y");
    	price_typ.setModified_by(rb.getUser_id());
    	 Date dt = new Date();
    	 price_typ.setModified_on(dt);
    	 pricetypMasterservice.priceTypeDelete(price_typ);
    	list = pricetypMasterservice.price_type();
      return new ResponseEntity<List<PriceTypeMasterBean>>(list, HttpStatus.OK);
    } catch (Exception e) {
    	logger.error("Error in  priceTypeDelete " + this.getClass(), e);    	
    	return new ResponseEntity<List<PriceTypeMasterBean>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("Add_prc_typ() mehtod executes Successfully:");
    }

  }



}


package com.crunchify.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.*;
import com.crunchify.model.view.CashSaleViewBean;
import com.crunchify.model.view.PurDataViewBean;
import com.crunchify.services.PurchaseService;
import com.crunchify.services.RegService;
import com.crunchify.services.RoleService;
import com.crunchify.services.StockService;
import com.crunchify.services.Impl.PurchaseServiceImpl;


@RestController
public class PurchaseController {

	private static final Logger logger = Logger.getLogger(PurchaseController.class);
	
  @Autowired
  private PurchaseService purservice;

  
  
  @RequestMapping(value = "/purchaseEntry", method = RequestMethod.POST, consumes="application/json")
  @ResponseBody 
  public String purchaseEntry(@RequestBody PurDataHdr purDataHdr,HttpServletRequest request) throws Exception
       {	 
	  logger.debug("purchaseEntry() method invoked in VtplReportController:");
	     List<PurDataHdr> list=new ArrayList<PurDataHdr>();
	     RetailRegistrationBean rb=(RetailRegistrationBean) request.getSession().getAttribute("user1"); 
	     //int updateId=Integer.parseInt(request.getSession().getAttribute("idp").toString());
	    // System.out.println(updateId);
	    // purDataHdr.setUpdateId(updateId);
	     if(purDataHdr.getVr_type().equalsIgnoreCase("PURC")){
	 	  	//int updateId=Integer.parseInt(request.getSession().getAttribute("idp").toString());
	 	 	//purDataHdr.setUpdateId(updateId);
	 	     }
	     else
	     {
	    	 purDataHdr.setFrom_co_id(purDataHdr.getCo_id()); 
	     }
	     Date now1 = new Date();
	     purDataHdr.setCreated_by(rb.getUser_id());
	     purDataHdr.setActive("Y");
	     purDataHdr.setCreated_on(now1);
	     
	     int co_id = Integer.parseInt(rb.getCo_id());
	     purDataHdr.setCo_id(co_id);
	    try {
	    	String x=purservice.purchaseEntry(purDataHdr);
	    	System.out.println("x is:----"+x);
	    	return x;
	    } catch (Exception e) {
	    	logger.error("Error in  roleCreate " + this.getClass(), e);    
	    	System.out.println("e is:----"+e);
	    	return "";
	    }
	    finally
	    {
	    	logger.debug("rolecreation() mehtod executes Successfully:");
	    }


 }
  
  
  @RequestMapping(value = "/purchaseReturnEntry", method = RequestMethod.POST, consumes="application/json")
  @ResponseBody 
  public String purchaseReturnEntry(@RequestBody PurDataHdr purDataHdr,HttpServletRequest request) throws Exception
       {	 
	  logger.debug("purchaseRetrunEntry() method invoked in VtplReportController:");
	     List<PurDataHdr> list=new ArrayList<PurDataHdr>();
	     RetailRegistrationBean rb=(RetailRegistrationBean) request.getSession().getAttribute("user1");  
	 	int updateId=Integer.parseInt(request.getSession().getAttribute("idp").toString());
	 	purDataHdr.setUpdateId(updateId);
	     Date now1 = new Date();
	     purDataHdr.setCreated_by(rb.getUser_id());
	     purDataHdr.setActive("Y");
	     purDataHdr.setCreated_on(now1);
	     int co_id = Integer.parseInt(rb.getCo_id());
	     purDataHdr.setCo_id(co_id);
	    try {
	    	
	    			String x=purservice.purchaseReturnEntry(purDataHdr);
	    	System.out.println("I am in done--"+x);
	    	return x;
	    	
	      //return "success";
	    } catch (Exception e) { System.out.println("I am in error");
	    	logger.error("Error in  roleCreate " + this.getClass(), e);    	
	      return "failure";
	    }
	    finally
	    {
	    	logger.debug("rolecreation() mehtod executes Successfully:");
	    }


 }
  
  @RequestMapping(value = "/fetchPurchaseDetails", method = RequestMethod.GET,produces = "application/json")
  public ResponseEntity<List<PurDataViewBean>> fetchPurchaseDetails(HttpServletRequest request) throws Exception
       {	 
     logger.debug("fetchPurchaseDetails() method invoked in VtplReportController:");
     List<PurDataViewBean> list=new ArrayList<PurDataViewBean>();
    try {
    	RetailRegistrationBean rb=(RetailRegistrationBean) request.getSession().getAttribute("user1");  
    	String co = rb.getCo_id();
    
    	list=purservice.getPurchaseDetails(co);
    	 return new ResponseEntity<List<PurDataViewBean>>(list, HttpStatus.OK);
    } catch (Exception e) {
    	logger.error("Error in  roleCreate " + this.getClass(), e);    	
    	 return new ResponseEntity<List<PurDataViewBean>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("rolecreation() mehtod executes Successfully:");
    }

  }
  
  
  @RequestMapping(value = "/fetchDesign", method = RequestMethod.GET,produces = "application/json")
  public ResponseEntity<List<Map<String,String>>> fetchDesign(HttpServletRequest request,@RequestParam("val") String id) throws Exception
       {	 
	  RetailRegistrationBean rb=(RetailRegistrationBean)request.getSession().getAttribute("user1");
	 // String co_id=rb.getCo_id();
     logger.debug("fetchDesign() method invoked in VtplReportController:");
     List<AutocompleteDesignBean> list=new ArrayList<>();
     Map<String,String> p=null;
     List<Map<String,String>> x= new ArrayList<>();
    try {
    
    	list=(ArrayList<AutocompleteDesignBean>)purservice.fetchDesign(id);

    	
    	for (AutocompleteDesignBean autocompleteBean :list) {
    		System.out.println("1:-"+autocompleteBean.getId()+" 2:-"+autocompleteBean.getLabel());
    		p=new HashMap<String,String>();
    		p.put("id",String.valueOf(autocompleteBean.getId()));
    		
    		p.put("label",String.valueOf(autocompleteBean.getLabel()));
    		x.add(p);
		}
    	
    	 return new ResponseEntity<List<Map<String,String>>>(x, HttpStatus.OK);
    } catch (Exception e) {
    	logger.error("Error in  roleCreate " + this.getClass(), e);    	
    	 return new ResponseEntity<List<Map<String,String>>>(x, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("rolecreation() mehtod executes Successfully:");
    }

  }

  
  
  
  

}

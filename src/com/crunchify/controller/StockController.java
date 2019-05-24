package com.crunchify.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.*;
import com.crunchify.model.view.CashSaleViewBean;
import com.crunchify.model.view.CrSaleViewBean;
import com.crunchify.services.RegService;
import com.crunchify.services.RoleService;
import com.crunchify.services.StockService;


@RestController
public class StockController {

	private static final Logger logger = Logger.getLogger(StockController.class);
	
  @Autowired
  private StockService stockservice;

  
  
  @RequestMapping(value = "/stockEntry", method = RequestMethod.POST, consumes="application/json")
  @ResponseBody
  public String stockEntry(@RequestBody StockData stData,HttpServletRequest request) throws Exception
       {	 
     logger.debug("stockEntry() method invoked in VtplReportController:");
     List<StockData> list=new ArrayList<StockData>();
     RetailRegistrationBean rb=(RetailRegistrationBean) request.getSession().getAttribute("user1");     
     stData.setCreated_by(rb.getUser_id());
     int co_id = Integer.parseInt(rb.getCo_id());
     stData.setCo_id(co_id);
    try {
    	return stockservice.stockEntry(stData);
     // return new ResponseEntity<List<StockData>>(list, HttpStatus.OK);
    } catch (Exception e) {
    	logger.error("Error in  roleCreate " + this.getClass(), e);    	
      return "error";
    }
    finally
    {
    	logger.debug("rolecreation() mehtod executes Successfully:");
    }

  }
  
//  @RequestMapping(value = "/stockEntry", method = RequestMethod.POST, consumes="application/json")
//  @ResponseBody
//  public String stockEntryRm(@RequestBody StockData stData,HttpServletRequest request) throws Exception
//       {	 
//     logger.debug("stockEntryRm() method invoked in VtplReportController:");
//     List<StockData> list=new ArrayList<StockData>();
//     RetailRegistrationBean rb=(RetailRegistrationBean) request.getSession().getAttribute("user1");     
//     stData.setCreated_by(rb.getUser_id());
//     int co_id = Integer.parseInt(rb.getCo_id());
//     stData.setCo_id(co_id);
//    try {
//    	return stockservice.stockEntry(stData);
//     // return new ResponseEntity<List<StockData>>(list, HttpStatus.OK);
//    } catch (Exception e) {
//    	logger.error("Error in  roleCreate " + this.getClass(), e);    	
//      return "error";
//    }
//    finally
//    {
//    	logger.debug("rolecreation() mehtod executes Successfully:");
//    }
//
//  }
  
  
  @RequestMapping(value = "/fetchAllStock", method = RequestMethod.GET,produces = "application/json")
  public ResponseEntity<List<StockData>> fetchAllStock(@RequestParam(value="desg_no", required=true) String desg_id,
	        @RequestParam(value="co_id", required=false) int co_id, HttpServletRequest request) throws Exception
       {
	  System.out.println("fetchAllStock");
	  System.out.println("co_id=> "+co_id);
	  System.out.println("desg_no=> "+desg_id);
     logger.debug("appReports() method invoked in VtplReportController:");
     List<StockData> list=new ArrayList<StockData>();
     StockData stData=new StockData();
     stData.setDesg_no(desg_id);
     stData.setCo_id(co_id);
    try {
    	list = stockservice.stockView(stData);
//    	for (ItemMasterBean itemMasterservice : list) {
    		System.out.println(stockservice.stockView(stData));
		
    	System.out.println("Sucessfully executed");
    	//String x=gson.toJson(list);
    	//data.put("current", String.valueOf(request.getParameter("current")));
    	//data.put("rowCount", String.valueOf(request.getParameter("rowCount")));
    	//data.put("rows", list);
    	//data.put("total",String.valueOf(list.size()));
    
      return new ResponseEntity<List<StockData>>(list, HttpStatus.OK);
    } catch (SpringCrunchifyException e) {
    	logger.error("Error in  user registration " + this.getClass(), e);    	
      return new ResponseEntity<List<StockData>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("viewStockCreate() mehtod executes Successfully:");
    }
    

  }
  
  
  @RequestMapping(value = "/fetchStockTransAcknow", method = RequestMethod.GET,produces = "application/json")
  public ResponseEntity<List<CrSaleViewBean>> fetchStockTransAcknow(HttpServletRequest request) throws Exception
  {	 
	     logger.debug("fetchStockTransAcknow() method invoked in VtplReportController:");
	     RetailRegistrationBean rb=(RetailRegistrationBean)request.getSession().getAttribute("user1");
	     String co_id=rb.getCo_id();
	     List<CrSaleViewBean> list=new ArrayList<CrSaleViewBean>();
	    try {
	    
	    	list=stockservice.getStockTransAcknow(co_id);
	    	 return new ResponseEntity<List<CrSaleViewBean>>(list, HttpStatus.OK);
	    } catch (Exception e) {
	    	logger.error("Error in  fetchStockTransAcknow " + this.getClass(), e);    	
	    	 return new ResponseEntity<List<CrSaleViewBean>>(list, HttpStatus.OK);
	    }
	    finally
	    {
	    	logger.debug("fetchStockTransAcknow() mehtod executes Successfully:");
	    }

 }

}

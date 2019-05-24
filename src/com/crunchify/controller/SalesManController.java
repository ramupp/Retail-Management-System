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
import com.crunchify.model.SalesManBean;
import com.crunchify.model.UserRegRoleCompany;
import com.crunchify.model.UserRoleCompany;
import com.crunchify.services.ItemTypeService;
import com.crunchify.services.RoleService;
import com.crunchify.services.SalesManService;

@RestController
public class SalesManController {

	private static final Logger logger = Logger.getLogger(RoleCreationController.class);
	
  @Autowired
  private SalesManService salesmanservice;

  
  
  @RequestMapping(value = "/salesman", method = RequestMethod.POST,produces = "application/json", consumes="application/json")
  @ResponseBody
  public String salesManCreate(@RequestBody SalesManBean sales_man,HttpServletRequest request) throws Exception
       {	System.out.println("in controller"); 
     logger.debug("salesManCreate() method invoked in VtplReportController:");
     List<SalesManBean> list=new ArrayList<SalesManBean>();
    try {
    	RetailRegistrationBean rb=(RetailRegistrationBean)request.getSession().getAttribute("user1");
    	sales_man.setActive("Y");
    	sales_man.setCreated_by(rb.getUser_id());
    	 Date dt = new Date();
    	 sales_man.setCreated_on(dt);
    	return salesmanservice.salesManCreate(sales_man);
      
    } catch (Exception e) {
    	logger.error("Error in  ItemtypeCreate " + this.getClass(), e);    	
      return "error";
    }
    finally
    {
    	logger.debug("salesman() mehtod executes Successfully:");
    }

  }
  
  @RequestMapping(value = "/fetchAllSalesMan", method = RequestMethod.GET,produces = "application/json")
  public ResponseEntity<List<SalesManBean>> fetchAllSalesMan( HttpServletRequest request) throws Exception
       {
	  System.out.println("hello world");
     logger.debug("appReports() method invoked in VtplReportController:");
     List<SalesManBean> list=new ArrayList<SalesManBean>();
    
    try {
    	list = salesmanservice.sales_man();
//    	for (ItemMasterBean itemMasterservice : list) {
//    		System.out.println(itemMasterservice.item_master());
		
    	System.out.println("Sucessfully executed");
    	//String x=gson.toJson(list);
    	//data.put("current", String.valueOf(request.getParameter("current")));
    	//data.put("rowCount", String.valueOf(request.getParameter("rowCount")));
    	//data.put("rows", list);
    	//data.put("total",String.valueOf(list.size()));
    
      return new ResponseEntity<List<SalesManBean>>(list, HttpStatus.OK);
    } catch (SpringCrunchifyException e) {
    	logger.error("Error in  user registration " + this.getClass(), e);    	
      return new ResponseEntity<List<SalesManBean>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("viewsalesManCreate() mehtod executes Successfully:");
    }

  }
  
  @RequestMapping(value = "/SalesManUpdate", method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity<List<SalesManBean>> salesManUpdate(@RequestBody SalesManBean sales_m,HttpServletRequest request) throws Exception
       {	 
     logger.debug("salesManUpdate() method invoked in VtplReportController:");
     List<SalesManBean> list=new ArrayList<SalesManBean>();
    try {
    	RetailRegistrationBean rb=(RetailRegistrationBean)request.getSession().getAttribute("user1");
    	sales_m.setActive("Y");
    	sales_m.setModified_by(rb.getUser_id());
    	 Date dt = new Date();
    	 sales_m.setModified_on(dt);
    	 salesmanservice.salesManUpdate(sales_m);
    	//list = salesmanservice.sales_m();
      return new ResponseEntity<List<SalesManBean>>(list, HttpStatus.OK);
    } catch (Exception e) {
    	logger.error("Error in  salesManUpdate " + this.getClass(), e);    	
    	return new ResponseEntity<List<SalesManBean>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("salesman() mehtod executes Successfully:");
    }

  }
  
  @RequestMapping(value = "/sales_manDelete", method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity<List<SalesManBean>> sales_manTypDelete(@RequestBody SalesManBean s_m_typ,HttpServletRequest request) throws Exception
  
       {	 
     logger.debug("sales_manTypDelete() method invoked in VtplReportController:");
     List<SalesManBean> list=new ArrayList<SalesManBean>();
    try { 
    	
    	//System.out.println("the item type is:-----"+item_typ.getItm_typ_id());
    
    	RetailRegistrationBean rb=(RetailRegistrationBean)request.getSession().getAttribute("user1");
    	s_m_typ.setActive("Y");
    	s_m_typ.setModified_by(rb.getUser_id());
    	 Date dt = new Date();
    	 s_m_typ.setModified_on(dt);
    	 salesmanservice.sales_manTypDelete(s_m_typ);
    	//list = salesmanservice.s_m_typ();
      return new ResponseEntity<List<SalesManBean>>(list, HttpStatus.OK);
    } catch (Exception e) {
    	logger.error("Error in  sales_manTypDelete " + this.getClass(), e);    	
    	return new ResponseEntity<List<SalesManBean>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("salesman() mehtod executes Successfully:");
    }

  }


}
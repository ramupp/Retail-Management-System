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
import com.crunchify.model.YearCodeBean;
import com.crunchify.services.ItemMasterService;
import com.crunchify.services.ItemTypeService;
import com.crunchify.services.RoleService;
import com.crunchify.services.YearCodeService;

@RestController
public class YearCodeController {

	private static final Logger logger = Logger.getLogger(RoleCreationController.class);
	
  @Autowired
  private YearCodeService yearCodeservice;

  
  
  @RequestMapping(value = "/Add_yr_cd_master", method = RequestMethod.POST,produces = "application/json", consumes="application/json")
  @ResponseBody
  public String yearCodeCreate(@RequestBody YearCodeBean year_c,HttpServletRequest request) throws Exception
       {	 
     logger.debug("yearCodeCreate() method invoked in VtplReportController:");
     List<YearCodeBean> list=new ArrayList<YearCodeBean>();
    try {
    	RetailRegistrationBean rb=(RetailRegistrationBean)request.getSession().getAttribute("user1");
    	year_c.setActive("Y");
    	year_c.setCreated_by(rb.getUser_id());
    	 Date dt = new Date();
    	 year_c.setCreated_on(dt);
    	return yearCodeservice.yearCodeCreate(year_c);
    	
    } catch (Exception e) {
    	logger.error("Error in  yearCodeCreate " + this.getClass(), e);    	
      return "error";
    }
    finally
    {
    	logger.debug("Add_yr_cd_master() mehtod executes Successfully:");
    }

  }
  @RequestMapping(value = "/fetchAllYearCode", method = RequestMethod.GET,produces = "application/json")
  public ResponseEntity<List<YearCodeBean>> fetchAllYearCode( HttpServletRequest request) throws Exception
       {
	  System.out.println("hello world");
     logger.debug("appReports() method invoked in VtplReportController:");
     List<YearCodeBean> list=new ArrayList<YearCodeBean>();
    
    try {
    	list = yearCodeservice.yearcd_master();
//    	for (ItemMasterBean itemMasterservice : list) {
//    		System.out.println(itemMasterservice.item_master());
		
    	System.out.println("Sucessfully executed");
    	//String x=gson.toJson(list);
    	//data.put("current", String.valueOf(request.getParameter("current")));
    	//data.put("rowCount", String.valueOf(request.getParameter("rowCount")));
    	//data.put("rows", list);
    	//data.put("total",String.valueOf(list.size()));
    
      return new ResponseEntity<List<YearCodeBean>>(list, HttpStatus.OK);
    } catch (SpringCrunchifyException e) {
    	logger.error("Error in  user registration " + this.getClass(), e);    	
      return new ResponseEntity<List<YearCodeBean>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("viewYearCodeCreate() mehtod executes Successfully:");
    }

  }
  
  @RequestMapping(value = "/yearcodeUpdate", method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity<List<YearCodeBean>> yearCodeUpdate(@RequestBody YearCodeBean yr_cd,HttpServletRequest request) throws Exception
       {	 
     logger.debug("yearCodeUpdate() method invoked in VtplReportController:");
     List<YearCodeBean> list=new ArrayList<YearCodeBean>();
    try {
    	RetailRegistrationBean rb=(RetailRegistrationBean)request.getSession().getAttribute("user1");
    	yr_cd.setActive("Y");
    	yr_cd.setModified_by(rb.getUser_id());
    	 Date dt = new Date();
    	 yr_cd.setModified_on(dt);
    	 yearCodeservice.yearCodeUpdate(yr_cd);
    	//list = yearCodeservice.yr_cd();
      return new ResponseEntity<List<YearCodeBean>>(list, HttpStatus.OK);
    } catch (Exception e) {
    	logger.error("Error in  yearCodeUpdate " + this.getClass(), e);    	
    	return new ResponseEntity<List<YearCodeBean>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("Add_yr_cd_master() mehtod executes Successfully:");
    }

  }
  
  @RequestMapping(value = "/year_cdDelete", method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity<List<YearCodeBean>> yearCodeDelete(@RequestBody YearCodeBean year_cd,HttpServletRequest request) throws Exception
  
       {	 
     logger.debug("yearCodeDelete() method invoked in VtplReportController:");
     List<YearCodeBean> list=new ArrayList<YearCodeBean>();
    try { 
    	//System.out.println("the year code is:-----"+item_typ.getItm_typ_id());
    
    	RetailRegistrationBean rb=(RetailRegistrationBean)request.getSession().getAttribute("user1");
    	year_cd.setActive("Y");
    	year_cd.setModified_by(rb.getUser_id());
    	 Date dt = new Date();
    	 year_cd.setModified_on(dt);
    	 yearCodeservice.yearCodeDelete(year_cd);
    	//list = yearCodeservice.year_cd();
      return new ResponseEntity<List<YearCodeBean>>(list, HttpStatus.OK);
    } catch (Exception e) {
    	logger.error("Error in  yearCodeDelete " + this.getClass(), e);    	
    	return new ResponseEntity<List<YearCodeBean>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("Add_yr_cd_master() mehtod executes Successfully:");
    }

  }


}


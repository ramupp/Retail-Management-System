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
import com.crunchify.model.CityMasterBean;
import com.crunchify.model.ItemMasterBean;
import com.crunchify.model.ItemTypeBean;
import com.crunchify.model.PartyTypeBean;
import com.crunchify.model.RetailRegistrationBean;
import com.crunchify.model.RoleDataHdr;
import com.crunchify.model.UserRegRoleCompany;
import com.crunchify.model.UserRoleCompany;
import com.crunchify.services.CityMasterService;
import com.crunchify.services.ItemMasterService;
import com.crunchify.services.ItemTypeService;
import com.crunchify.services.RoleService;

@RestController
public class CityMasterController {

	private static final Logger logger = Logger.getLogger(RoleCreationController.class);
	
  @Autowired
  private CityMasterService cityMasterservice;

  
  
  @RequestMapping(value = "/Addcity_master", method = RequestMethod.POST,produces = "application/json", consumes="application/json")
  @ResponseBody
  public String cityMasterCreate(@RequestBody CityMasterBean city_m,HttpServletRequest request) throws Exception
       {	 
     logger.debug("cityMasterCreate() method invoked in VtplReportController:");
     List<CityMasterBean> list=new ArrayList<CityMasterBean>();
    try {
    	RetailRegistrationBean rb=(RetailRegistrationBean)request.getSession().getAttribute("user1");
    	city_m.setActive("Y");
    	city_m.setCreated_by(rb.getUser_id());
    	 Date dt = new Date();
    	 city_m.setCreated_on(dt);
    	return cityMasterservice.cityMasterCreate(city_m);
    
    } catch (Exception e) {
    	logger.error("Error in  cityMasterCreate " + this.getClass(), e);    	
        return "error";
      }
    finally
    {
    	logger.debug("Addcity_master() mehtod executes Successfully:");
    }

  }

  @RequestMapping(value = "/fetchAllCity", method = RequestMethod.GET,produces = "application/json")
  public ResponseEntity<List<CityMasterBean>> fetchAllCity( HttpServletRequest request) throws Exception
       {
	  System.out.println("hello world");
     logger.debug("appReports() method invoked in VtplReportController:");
     List<CityMasterBean> list=new ArrayList<CityMasterBean>();
    
    try {
    	list = cityMasterservice.city_type();
//    	for (ItemMasterBean itemMasterservice : list) {
//    		System.out.println(itemMasterservice.item_master());
		
    	System.out.println("Sucessfully executed");
    	//String x=gson.toJson(list);
    	//data.put("current", String.valueOf(request.getParameter("current")));
    	//data.put("rowCount", String.valueOf(request.getParameter("rowCount")));
    	//data.put("rows", list);
    	//data.put("total",String.valueOf(list.size()));
    
      return new ResponseEntity<List<CityMasterBean>>(list, HttpStatus.OK);
    } catch (SpringCrunchifyException e) {
    	logger.error("Error in  user registration " + this.getClass(), e);    	
      return new ResponseEntity<List<CityMasterBean>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("viewCityCreate() mehtod executes Successfully:");
    }

  }
  
  @RequestMapping(value = "/cityUpdate", method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity<List<CityMasterBean>> cityUpdate(@RequestBody CityMasterBean city,HttpServletRequest request) throws Exception
       {	 
     logger.debug("cityUpdate() method invoked in VtplReportController:");
     List<CityMasterBean> list=new ArrayList<CityMasterBean>();
    try {
    	RetailRegistrationBean rb=(RetailRegistrationBean)request.getSession().getAttribute("user1");
    	city.setActive("Y");
    	city.setModified_by(rb.getUser_id());
    	 Date dt = new Date();
    	 city.setModified_on(dt);
    	 cityMasterservice.cityUpdate(city);
    	list = cityMasterservice.city_type();
      return new ResponseEntity<List<CityMasterBean>>(list, HttpStatus.OK);
    } catch (Exception e) {
    	logger.error("Error in  cityUpdate " + this.getClass(), e);    	
    	return new ResponseEntity<List<CityMasterBean>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("Addcity_master() mehtod executes Successfully:");
    }

  }
  
  @RequestMapping(value = "/CityDelete", method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity<List<CityMasterBean>> cityTypDelete(@RequestBody CityMasterBean city_typ,HttpServletRequest request) throws Exception
  
       {	 
     logger.debug("cityTypDelete() method invoked in VtplReportController:");
     List<CityMasterBean> list=new ArrayList<CityMasterBean>();
    try { 
    	//System.out.println("the item type is:-----"+item_typ.getItm_typ_id());
    
    	RetailRegistrationBean rb=(RetailRegistrationBean)request.getSession().getAttribute("user1");
    	city_typ.setActive("Y");
    	city_typ.setModified_by(rb.getUser_id());
    	 Date dt = new Date();
    	 city_typ.setModified_on(dt);
    	 cityMasterservice.cityTypeDelete(city_typ);
    	//list = cityMasterservice.city_typ();
      return new ResponseEntity<List<CityMasterBean>>(list, HttpStatus.OK);
    } catch (Exception e) {
    	logger.error("Error in  cityTypeDelete " + this.getClass(), e);    	
    	return new ResponseEntity<List<CityMasterBean>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("Addcity_master() mehtod executes Successfully:");
    }

  }


}


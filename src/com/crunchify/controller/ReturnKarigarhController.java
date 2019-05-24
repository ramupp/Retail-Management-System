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
import com.crunchify.model.RcvRetKarHdrBean;
import com.crunchify.model.ItemMasterBean;
import com.crunchify.model.ItemTypeBean;
import com.crunchify.model.RetailRegistrationBean;
import com.crunchify.model.RoleDataHdr;
import com.crunchify.model.UserRegRoleCompany;
import com.crunchify.model.UserRoleCompany;
import com.crunchify.model.view.ItemMasterViewBean;
import com.crunchify.services.ItemMasterService;
import com.crunchify.services.ItemTypeService;
import com.crunchify.services.ReturnKarigarhService;
import com.crunchify.services.RoleService;
import com.crunchify.util.UtilityHelper;
import com.google.gson.Gson;

@RestController
public class ReturnKarigarhController {

	private static final Logger logger = Logger.getLogger(RoleCreationController.class);
	
  @Autowired
  private ReturnKarigarhService returnKarigarhService;


  
  
  @RequestMapping(value = "/addReturnKarigarh", method = RequestMethod.POST,produces = "application/json", consumes="application/json")
  @ResponseBody
  public String returnKarigarhCreate(@RequestBody RcvRetKarHdrBean ret_kar,HttpServletRequest request) throws Exception
       {
	  System.out.println("Im in Controller");
     logger.debug("returnKarigarhCreate() method invoked in VtplReportController:");
     UtilityHelper utilityHelper=new UtilityHelper();
     List<RcvRetKarHdrBean> list=new ArrayList<RcvRetKarHdrBean>();
    try {
    	RetailRegistrationBean rb=(RetailRegistrationBean)request.getSession().getAttribute("user1");
    	ret_kar.setActive("Y");
    	ret_kar.setCreated_by(rb.getUser_id());
    	ret_kar.setOrg_id(utilityHelper.findOrgIdByCoId(Integer.parseInt(rb.getCo_id())));
    	 Date dt = new Date();
    	 ret_kar.setCreated_on(dt);
    	 ret_kar.setType("T");
    	ret_kar.setCo_id(Integer.parseInt(rb.getCo_id()));
    	
    	return returnKarigarhService.returnKarigarhCreate(ret_kar);
     
    } catch (Exception e) {
    	logger.error("Error in  returnKarigarhCreate " + this.getClass(), e);    	
      return "error";
    }
    finally
    {
    	logger.debug("addReturnKarigarh() mehtod executes Successfully:");
    }

  }
  
  @RequestMapping(value = "/fetchKarigarhReturn", method = RequestMethod.GET,produces = "application/json")
  public ResponseEntity<List<RcvRetKarHdrBean>> fetchKarigarhReturn(HttpServletRequest request) throws Exception
       {	 
     logger.debug("fetchKarigarhReturn() method invoked in VtplReportController:");
     List<RcvRetKarHdrBean> list=new ArrayList<RcvRetKarHdrBean>();
    try {
    	RetailRegistrationBean rb=(RetailRegistrationBean) request.getSession().getAttribute("user1");  
    	String co = rb.getCo_id();
    
    	list = returnKarigarhService.ret_kar();
    	 return new ResponseEntity<List<RcvRetKarHdrBean>>(list, HttpStatus.OK);
    } catch (Exception e) {
    	logger.error("Error in  roleCreate " + this.getClass(), e);    	
    	 return new ResponseEntity<List<RcvRetKarHdrBean>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("fetchKarigarhReturn() mehtod executes Successfully:");
    }

  }
  
}

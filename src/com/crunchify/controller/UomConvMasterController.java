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
import com.crunchify.model.UomConvMasterBean;
import com.crunchify.model.UserRegRoleCompany;
import com.crunchify.model.UserRoleCompany;
import com.crunchify.services.ItemMasterService;
import com.crunchify.services.ItemTypeService;
import com.crunchify.services.RoleService;
import com.crunchify.services.UomConvMasterService;
import com.google.gson.Gson;

@RestController
public class UomConvMasterController {

	private static final Logger logger = Logger.getLogger(RoleCreationController.class);
	
  @Autowired
  private UomConvMasterService uomConvMasterservice;


  
  
  @RequestMapping(value = "/Add_uom_cn_master", method = RequestMethod.POST,produces = "application/json", consumes="application/json")
  public ResponseEntity<List<UomConvMasterBean>> uomConvCreate(@RequestBody UomConvMasterBean conv,HttpServletRequest request) throws Exception
       {	 
     logger.debug("uomConvCreate() method invoked in VtplReportController:");
     List<UomConvMasterBean> list=new ArrayList<UomConvMasterBean>();
    try {
    	RetailRegistrationBean rb=(RetailRegistrationBean)request.getSession().getAttribute("user1");
    	conv.setActive("Y");
    	conv.setCreated_by(rb.getUser_id());
    	 Date dt = new Date();
    	 conv.setCreated_on(dt);
    	uomConvMasterservice.uomConvCreate(conv);
      return new ResponseEntity<List<UomConvMasterBean>>(list, HttpStatus.OK);
    } catch (Exception e) {
    	logger.error("Error in  uomConvCreate " + this.getClass(), e);    	
      return new ResponseEntity<List<UomConvMasterBean>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("Add_uom_cn_master() mehtod executes Successfully:");
    }

  }
  
  @RequestMapping(value = "/fetchAllUOMConv", method = RequestMethod.GET,produces = "application/json")
  public ResponseEntity<List<UomConvMasterBean>> Additm_master( HttpServletRequest request) throws Exception
       {
	  System.out.println("hello world");
     logger.debug("appReports() method invoked in VtplReportController:");
     List<UomConvMasterBean> list=new ArrayList<UomConvMasterBean>();
    
    try {
    	list = uomConvMasterservice.uom_cnv();
    	System.out.println("Sucessfully executed");
    	return new ResponseEntity<List<UomConvMasterBean>>(list, HttpStatus.OK);
    } catch (SpringCrunchifyException e) {
    	logger.error("Error in  user registration " + this.getClass(), e);    	
      return new ResponseEntity<List<UomConvMasterBean>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("viewUOMCCreate() mehtod executes Successfully:");
    }

  }
  
  @RequestMapping(value = "/uom_convUpdate", method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity<List<UomConvMasterBean>> uom_convUpdate(@RequestBody UomConvMasterBean uom_cnv,HttpServletRequest request) throws Exception
       {	 
     logger.debug("uom_convUpdate() method invoked in VtplReportController:");
     List<UomConvMasterBean> list=new ArrayList<UomConvMasterBean>();
    try {
    	RetailRegistrationBean rb=(RetailRegistrationBean)request.getSession().getAttribute("user1");
    	uom_cnv.setActive("Y");
    	uom_cnv.setModified_by(rb.getUser_id());
    	 Date dt = new Date();
    	 uom_cnv.setModified_on(dt);
    	 uomConvMasterservice.uom_convUpdate(uom_cnv);
    	list = uomConvMasterservice.uom_cnv();
      return new ResponseEntity<List<UomConvMasterBean>>(list, HttpStatus.OK);
    } catch (Exception e) {
    	logger.error("Error in  uom_convUpdate " + this.getClass(), e);    	
    	return new ResponseEntity<List<UomConvMasterBean>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("Add_uom_cn_master() mehtod executes Successfully:");
    }

  }
  
  @RequestMapping(value = "/uomCnvDelete", method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity<List<UomConvMasterBean>> uomcnvTypDelete(@RequestBody UomConvMasterBean ucnv_typ,HttpServletRequest request) throws Exception
  
       {	 
     logger.debug("uomcnvTypDelete() method invoked in VtplReportController:");
     List<UomConvMasterBean> list=new ArrayList<UomConvMasterBean>();
    try { 
    	//System.out.println("the item type is:-----"+item_typ.getItm_typ_id());
    
    	RetailRegistrationBean rb=(RetailRegistrationBean)request.getSession().getAttribute("user1");
    	ucnv_typ.setActive("Y");
    	ucnv_typ.setModified_by(rb.getUser_id());
    	 Date dt = new Date();
    	 ucnv_typ.setModified_on(dt);
    	 uomConvMasterservice.uomcnvTypDelete(ucnv_typ);
    //	list = uomConvMasterservice.ucnv_typ();
      return new ResponseEntity<List<UomConvMasterBean>>(list, HttpStatus.OK);
    } catch (Exception e) {
    	logger.error("Error in  uomcnvTypDelete " + this.getClass(), e);    	
    	return new ResponseEntity<List<UomConvMasterBean>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("Add_uom_cn_master() mehtod executes Successfully:");
    }

  }


}
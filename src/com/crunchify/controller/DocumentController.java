package com.crunchify.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.DocumentBean;
import com.crunchify.model.ItemMasterBean;
import com.crunchify.model.ItemTypeBean;
import com.crunchify.model.RetailRegistrationBean;
import com.crunchify.model.RoleDataHdr;
import com.crunchify.model.UserRegRoleCompany;
import com.crunchify.model.UserRoleCompany;
import com.crunchify.model.view.DocumentRequestBodyBean;
import com.crunchify.services.DocumentService;
import com.crunchify.services.ItemMasterService;
import com.crunchify.services.ItemTypeService;
import com.crunchify.services.RoleService;
import com.google.gson.Gson;

@RestController
public class DocumentController {

	private static final Logger logger = Logger.getLogger(RoleCreationController.class);
	
  @Autowired
  private DocumentService documentrservice;
  
  
  
  @RequestMapping(value = "/fetchAllDocument", method = RequestMethod.GET,produces = "application/json")
  public ResponseEntity<List<DocumentBean>> fetchAllDocument( HttpServletRequest request) throws Exception
       {
	  System.out.println("hello world");
     logger.debug("appReports() method invoked in VtplReportController:");
     List<DocumentBean> list=new ArrayList<DocumentBean>();
    
    try {
    	list = documentrservice.doc();
//    	for (ItemMasterBean itemMasterservice : list) {
//    		System.out.println(itemMasterservice.item_master());
		
    	System.out.println("Sucessfully executed");
    	//String x=gson.toJson(list);
    	//data.put("current", String.valueOf(request.getParameter("current")));
    	//data.put("rowCount", String.valueOf(request.getParameter("rowCount")));
    	//data.put("rows", list);
    	//data.put("total",String.valueOf(list.size()));
    
      return new ResponseEntity<List<DocumentBean>>(list, HttpStatus.OK);
    } catch (SpringCrunchifyException e) {
    	logger.error("Error in  user registration " + this.getClass(), e);    	
      return new ResponseEntity<List<DocumentBean>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("viewDocCreate() mehtod executes Successfully:");
    }

  }
  
  @RequestMapping(value = "/addDocumentMaster", method = RequestMethod.POST, consumes="application/json")
  @ResponseBody
  public String appReports(@RequestBody DocumentRequestBodyBean doc, HttpServletRequest request ) throws Exception
       {
	  System.out.println("hello world");
    String flag="";
    try {
    	flag=documentrservice.addDocument(doc);
    	System.out.println("return value is:-"+flag);
    	return flag;
    } catch (SpringCrunchifyException e) {
    	logger.error("Error in  user registration " + this.getClass(), e);   
    	System.out.println("return value is:-"+flag);
      return "error";
    }
   
  }


}


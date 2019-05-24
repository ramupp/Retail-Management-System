package com.crunchify.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
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
import com.crunchify.model.PartyMasterBean;
import com.crunchify.model.RetailRegistrationBean;
import com.crunchify.model.view.ItemMasterViewBean;
import com.crunchify.model.view.PurDataViewBean;
import com.crunchify.services.RcvKarService;
import com.crunchify.util.UtilityHelper;


@RestController
public class RcvKarController {

 private static final Logger logger = Logger.getLogger(RcvKarController.class);
	
  @Autowired
  private RcvKarService issueKarService;

  @Autowired
  ServletContext context;
  
  
  @RequestMapping(value = "/updateIssueKar", method = RequestMethod.POST,produces = "application/json", consumes="application/json")
  @ResponseBody
  public ResponseEntity<List<RcvRetKarHdrBean>> issueUpdate(@RequestBody RcvRetKarHdrBean rcv_kar,HttpServletRequest request) throws Exception
       {
	  System.out.println("im in controller");
     logger.debug("issueUpdate() method invoked in VtplReportController:");
     UtilityHelper utilityHelper=new UtilityHelper();
     List<RcvRetKarHdrBean> list=new ArrayList<RcvRetKarHdrBean>();
    try {
    	RetailRegistrationBean rb=(RetailRegistrationBean)request.getSession().getAttribute("user1");
    	rcv_kar.setActive("Y");
    	rcv_kar.setType("R");
    	System.out.println("compid-----"+rb.getCo_id());
    	rcv_kar.setCo_id(Integer.parseInt(rb.getCo_id()));
    	rcv_kar.setOrg_id(utilityHelper.findOrgIdByCoId(Integer.parseInt(rb.getCo_id())));
    	
    	rcv_kar.setCreated_by(rb.getUser_id());
    	rcv_kar.setKar_cd(rcv_kar.getKar_cd());
    	 Date dt = new Date();
    	 rcv_kar.setCreated_on(dt);
    	 
    	 issueKarService.issueKarUpdate(rcv_kar);
    	//list = party_masterservice.party_type();
      return new ResponseEntity<List<RcvRetKarHdrBean>>(list, HttpStatus.OK);
    } catch (Exception e) {
    	logger.error("Error in  itemTypeUpdate " + this.getClass(), e);    	
    	return new ResponseEntity<List<RcvRetKarHdrBean>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("UpdateIssuekar() mehtod executes Successfully:");
    }

  }
  
  @RequestMapping(value = "/fetchKarigarhReceive", method = RequestMethod.GET,produces = "application/json")
  public ResponseEntity<List<RcvRetKarHdrBean>> fetchKarigarhReceive(HttpServletRequest request) throws Exception
       {	 
     logger.debug("fetchKarigarhReceive() method invoked in VtplReportController:");
     List<RcvRetKarHdrBean> list=new ArrayList<RcvRetKarHdrBean>();
    try {
    	RetailRegistrationBean rb=(RetailRegistrationBean) request.getSession().getAttribute("user1");  
    	String co = rb.getCo_id();
    	//issueKarService.itemMasterUpdate(data);
    	list = issueKarService.rcv_kar();
    	 return new ResponseEntity<List<RcvRetKarHdrBean>>(list, HttpStatus.OK);
    } catch (Exception e) {
    	logger.error("Error in  roleCreate " + this.getClass(), e);    	
    	 return new ResponseEntity<List<RcvRetKarHdrBean>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("fetchKarigarhReceive() mehtod executes Successfully:");
    }

  }
  
  
  @RequestMapping(value = "/rcv_karUpdate", method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity<List<RcvRetKarHdrBean>> rcv_karUpdate(@RequestBody RcvRetKarHdrBean rcv_kar,HttpServletRequest request) throws Exception
       {	 
     logger.debug("rcv_karUpdate() method invoked in VtplReportController:");
     List<RcvRetKarHdrBean> list=new ArrayList<RcvRetKarHdrBean>();
     System.out.println("Pani Pani de.....");
    try {
    	RetailRegistrationBean rb=(RetailRegistrationBean)request.getSession().getAttribute("user1");
    	rcv_kar.setActive("Y");
    	rcv_kar.setModified_by(rb.getUser_id());
    	 Date dt = new Date();
    	 rcv_kar.setModified_on(dt);
    	// issueKarService.issueKarService(rcv_kar);
    	list = issueKarService.rcv_kar();
      return new ResponseEntity<List<RcvRetKarHdrBean>>(list, HttpStatus.OK);
    } catch (Exception e) {
    	logger.error("Error in  rcv_karUpdate " + this.getClass(), e);    	
    	return new ResponseEntity<List<RcvRetKarHdrBean>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("updateIssueKar() mehtod executes Successfully:");
    }

  }

  
  
  
  

}

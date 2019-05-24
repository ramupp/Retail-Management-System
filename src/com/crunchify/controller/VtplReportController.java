package com.crunchify.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.*;
import com.crunchify.services.RegService;


@RestController
public class VtplReportController {

	private static final Logger logger = Logger.getLogger(VtplReportController.class);
	
  @Autowired
  private RegService regservice;

  @RequestMapping(value = "/reports", method = RequestMethod.POST,produces = "application/json", consumes="application/json")
  public ResponseEntity<List<VtplReports>> appReports(@RequestBody VtplReports vtplReports, HttpServletRequest request) throws Exception
       {
	  System.out.println("hello world");
     logger.debug("appReports() method invoked in VtplReportController:");
     List<VtplReports> list=new ArrayList<VtplReports>();
    try {
    	list = regservice.appReports(vtplReports);
      return new ResponseEntity<List<VtplReports>>(list, HttpStatus.OK);
    } catch (SpringCrunchifyException e) {
    	logger.error("Error in  user registration " + this.getClass(), e);    	
      return new ResponseEntity<List<VtplReports>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("UserRegister() mehtod executes Successfully:");
    }

  }
  
  
  @RequestMapping(value = "/userpermission", method = RequestMethod.POST,produces = "application/json", consumes="application/json")
  public ResponseEntity<List<User>> appPermision(@RequestBody User user, HttpServletRequest request) throws Exception
       {
	  System.out.println("hello world");
     logger.debug("appReports() method invoked in VtplReportController:");
     List<User> list=new ArrayList<User>();
    try {
    	list = regservice.getPermission(user);
      return new ResponseEntity<List<User>>(list, HttpStatus.OK);
    } catch (Exception e) {
    	logger.error("Error in  user permission " + this.getClass(), e);    	
      return new ResponseEntity<List<User>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("appPermision() mehtod executes Successfully:");
    }

  }
  
  @RequestMapping(value = "/callAssignment", method = RequestMethod.POST,produces = "application/json", consumes="application/json")
  public ResponseEntity<List<CallData>> callAssignment(@RequestBody CallData callData, HttpServletRequest request) throws Exception
       {	 
     logger.debug("callAssignment() method invoked in VtplReportController:");
     List<CallData> list=new ArrayList<CallData>();
    try {
    	list = regservice.getAssignment(callData);
      return new ResponseEntity<List<CallData>>(list, HttpStatus.OK);
    } catch (Exception e) {
    	logger.error("Error in callAssignment " + this.getClass(), e);    	
      return new ResponseEntity<List<CallData>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("callAssignment() mehtod executes Successfully:");
    }

  }
  
  @RequestMapping(value = "/engDashboard", method = RequestMethod.POST,produces = "application/json", consumes="application/json")
  public ResponseEntity<List<CallData>> engDashboard(@RequestBody CallData callData, HttpServletRequest request) throws Exception
       {	 
     logger.debug("engDashboard() method invoked in VtplReportController:");
     List<CallData> list=new ArrayList<CallData>();
    try {
    	list = regservice.getEngDashboard(callData);
      return new ResponseEntity<List<CallData>>(list, HttpStatus.OK);
    } catch (Exception e) {
    	logger.error("Error in engDashboard " + this.getClass(), e);    	
      return new ResponseEntity<List<CallData>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("engDashboard() mehtod executes Successfully:");
    }

  }
  
  
  @RequestMapping(value = "/getSerial", method = RequestMethod.POST,produces = "application/json", consumes="application/json")
  public ResponseEntity<List<CallData>> getSerial(@RequestBody CallData callData, HttpServletRequest request) throws Exception
       {	 
     logger.debug("callRegister() method invoked in VtplReportController:");
     List<CallData> list=new ArrayList<CallData>();
    try {
    	list = regservice.getRegister(callData);
      return new ResponseEntity<List<CallData>>(list, HttpStatus.OK);
    } catch (Exception e) {
    	logger.error("Error in  callRegister " + this.getClass(), e);    	
      return new ResponseEntity<List<CallData>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("callRegister() mehtod executes Successfully:");
    }

  }
  
  @RequestMapping(value = "/getRemainingCallNo", method = RequestMethod.POST,produces = "application/json", consumes="application/json")
  public ResponseEntity<List<CallData>> getRemainingCallNo(@RequestBody CallData callData, HttpServletRequest request) throws Exception
       {	 
     logger.debug("getRemainingCallNo() method invoked in VtplReportController:");
     List<CallData> list=new ArrayList<CallData>();
    try {
    	list = regservice.getRemainingCallNo(callData);
      return new ResponseEntity<List<CallData>>(list, HttpStatus.OK);
    } catch (Exception e) {
    	logger.error("Error in  getRemainingCallNo " + this.getClass(), e);    	
      return new ResponseEntity<List<CallData>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("callRegister() mehtod executes Successfully:");
    }

  }
  
  @RequestMapping(value = "/getRemainingCallDetail", method = RequestMethod.POST,produces = "application/json", consumes="application/json")
  public ResponseEntity<List<CallData>> getRemainingCallDetail(@RequestBody CallData callData, HttpServletRequest request) throws Exception
       {	 
     logger.debug("getRemainingCallNo() method invoked in VtplReportController:");
     List<CallData> list=new ArrayList<CallData>();
    try {
    	list = regservice.getRemainingCallDetail(callData);
      return new ResponseEntity<List<CallData>>(list, HttpStatus.OK);
    } catch (Exception e) {
    	logger.error("Error in  getRemainingCallNo " + this.getClass(), e);    	
      return new ResponseEntity<List<CallData>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("callRegister() mehtod executes Successfully:");
    }

  }
  
  
  
  @RequestMapping(value = "/callRegisterDetail", method = RequestMethod.POST,produces = "application/json", consumes="application/json")
  public ResponseEntity<List<CallData>> callRegisterDetail(@RequestBody CallData callData, HttpServletRequest request) throws Exception
       {	 
     logger.debug("callRegisterDetail() method invoked in VtplReportController:");
     List<CallData> list=new ArrayList<CallData>();
    try {
    	list = regservice.getRegisterDetail(callData);
      return new ResponseEntity<List<CallData>>(list, HttpStatus.OK);
    } catch (Exception e) {
    	logger.error("Error in  callRegisterDetail " + this.getClass(), e);    	
      return new ResponseEntity<List<CallData>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("callRegisterDetail() mehtod executes Successfully:");
    }

  }
  
  
  @RequestMapping(value = "/callBooking", method = RequestMethod.POST, produces = "application/json", consumes="application/json"
	      )
	  public String callBooking(@RequestBody CallData callData, HttpServletRequest request) throws Exception
	       {
	     logger.debug("callBooking() method invoked in RegController:");
	    String msg="";
	    try {
	       msg = regservice.callBooking(callData);
	      return msg;
	    } catch (SpringCrunchifyException e) {
	    	logger.error("Error in  callBooking " + this.getClass(), e);    	
	      return msg;
	    }
	    finally
	    {
	    	logger.debug("callBooking() mehtod executes Successfully:");
	    }

	  }
  
  @RequestMapping(value = "/ccfrEntry", method = RequestMethod.POST, produces = "application/json", consumes="application/json"
	      )
	  public String ccfrEntry(@RequestBody CcfrMasterBean ccfr, HttpServletRequest request) throws Exception
	       {
	     logger.debug("ccfrEntry() method invoked in RegController:");
	    String msg="";
	    try {
	       msg = regservice.ccfrEntry(ccfr);
	      return msg;
	    } catch (SpringCrunchifyException e) {
	    	logger.error("Error in  ccfrEntry " + this.getClass(), e);    	
	      return msg;
	    }
	    finally
	    {
	    	logger.debug("ccfrEntry() mehtod executes Successfully:");
	    }

	  }
  
  
  @RequestMapping(value = "/callClosureView", method = RequestMethod.POST, produces = "application/json", consumes="application/json"
	      )
	  public ResponseEntity<List<CallData>> callClosureView(@RequestBody CallData callData, HttpServletRequest request) throws Exception
	  {	 
		     logger.debug("callClosureView() method invoked in VtplReportController:");
		     List<CallData> list=new ArrayList<CallData>();
		    try {
		    	list = regservice.callClosureView(callData);
		      return new ResponseEntity<List<CallData>>(list, HttpStatus.OK);
		    } catch (Exception e) {
		    	logger.error("Error in  callRegister " + this.getClass(), e);    	
		      return new ResponseEntity<List<CallData>>(list, HttpStatus.OK);
		    }
		    finally
		    {
		    	logger.debug("callRegister() mehtod executes Successfully:");
		    }

		  }
  
  
  @RequestMapping(value = "/assignCall", method = RequestMethod.POST, produces = "application/json", consumes="application/json"
	      )
	  public String assignCall(@RequestBody CallData callData, HttpServletRequest request) throws Exception
	       {
	     logger.debug("assignCall() method invoked in RegController:");
	    String msg="";
	    try {
	       msg = regservice.assignCall(callData);
	      return msg;
	    } catch (SpringCrunchifyException e) {
	    	logger.error("Error in  callBooking " + this.getClass(), e);    	
	      return msg;
	    }
	    finally
	    {
	    	logger.debug("callBooking() mehtod executes Successfully:");
	    }

	  }
  
  
  @RequestMapping(value = "/CallClose", method = RequestMethod.POST, produces = "application/json", consumes="application/json"
	      )
	  public String CallClose(@RequestBody CallData callData, HttpServletRequest request) throws Exception
	       {
	     logger.debug("CallClose() method invoked in RegController:");
	    String msg="";
	    try {
	       msg = regservice.CallClose(callData);
	      return msg;
	    } catch (SpringCrunchifyException e) {
	    	logger.error("Error in  CallClose " + this.getClass(), e);    	
	      return msg;
	    }
	    finally
	    {
	    	logger.debug("CallClose() mehtod executes Successfully:");
	    }

	  }
  
  
  @RequestMapping(value = "/AssignedTo", method = RequestMethod.POST,produces = "application/json", consumes="application/json")
  public ResponseEntity<List<CallData>> AssignedTo(@RequestBody CallData callData, HttpServletRequest request) throws Exception
       {	 
     logger.debug("AssignedTo() method invoked in VtplReportController:");
     List<CallData> list=new ArrayList<CallData>();
    try {
    	list = regservice.getAssignedTo(callData);
      return new ResponseEntity<List<CallData>>(list, HttpStatus.OK);
    } catch (Exception e) {
    	logger.error("Error in  callRegister " + this.getClass(), e);    	
      return new ResponseEntity<List<CallData>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("AssignedTo() mehtod executes Successfully:");
    }

  }
  
  
  @RequestMapping(value = "/AssignedOEM", method = RequestMethod.POST,produces = "application/json", consumes="application/json")
  public ResponseEntity<List<CallData>> AssignedOEM(@RequestBody CallData callData,HttpServletRequest request) throws Exception
       {	 
     logger.debug("AssignedOEM() method invoked in VtplReportController:");
     List<CallData> list=new ArrayList<CallData>();
    try {
    	list = regservice.getAssignedOEM();
      return new ResponseEntity<List<CallData>>(list, HttpStatus.OK);
    } catch (Exception e) {
    	logger.error("Error in  callRegister " + this.getClass(), e);    	
      return new ResponseEntity<List<CallData>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("callRegister() mehtod executes Successfully:");
    }

  }
  
  
  
  

}

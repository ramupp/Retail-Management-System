package com.crunchify.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import com.crunchify.model.AgentMasterBean;
import com.crunchify.model.ItemTypeBean;
import com.crunchify.model.RetailRegistrationBean;
import com.crunchify.services.AgentMasterService;
import com.crunchify.services.ItemTypeService;

@RestController
public class AgentMasterController {

	private static final Logger logger = Logger.getLogger(RoleCreationController.class);
	
  @Autowired
  private AgentMasterService agentmasterservice;

  
  
  @RequestMapping(value = "/AgentMaster", method = RequestMethod.POST,produces = "application/json", consumes="application/json")
  @ResponseBody
  public String agentMasterCreate(@RequestBody AgentMasterBean agent,HttpServletRequest request) throws Exception
       {	 
     logger.debug("agentMasterCreate() method invoked in VtplReportController:");
     List<AgentMasterBean> list=new ArrayList<AgentMasterBean>();
    try {
    	RetailRegistrationBean rb=(RetailRegistrationBean)request.getSession().getAttribute("user1");
    	agent.setActive("Y");
    	agent.setCreated_by(rb.getUser_id());
    	 Date dt = new Date();
    	 agent.setCreated_on(dt);
    	return agentmasterservice.agentMasterCreate(agent);
      
    } catch (Exception e) {
    	logger.error("Error in  agentMasterCreate " + this.getClass(), e);    	
      return "error";
    }
    finally
    {
    	logger.debug("AgentMaster() mehtod executes Successfully:");
    }

  }
  @RequestMapping(value = "/fetchAllAgent", method = RequestMethod.GET,produces = "application/json")
  public ResponseEntity<List<AgentMasterBean>> fetchAllAgent( HttpServletRequest request) throws Exception
       {
	  System.out.println("hello world");
     logger.debug("appReports() method invoked in VtplReportController:");
     List<AgentMasterBean> list=new ArrayList<AgentMasterBean>();
    
    try {
    	list = agentmasterservice.agent();
//    	for (ItemMasterBean itemMasterservice : list) {
//    		System.out.println(itemMasterservice.item_master());
		
    	System.out.println("Sucessfully executed");
    	//String x=gson.toJson(list);
    	//data.put("current", String.valueOf(request.getParameter("current")));
    	//data.put("rowCount", String.valueOf(request.getParameter("rowCount")));
    	//data.put("rows", list);
    	//data.put("total",String.valueOf(list.size()));
    
      return new ResponseEntity<List<AgentMasterBean>>(list, HttpStatus.OK);
    } catch (SpringCrunchifyException e) {
    	logger.error("Error in  user registration " + this.getClass(), e);    	
      return new ResponseEntity<List<AgentMasterBean>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("viewAgentCreate() mehtod executes Successfully:");
    }

  }
  
  @RequestMapping(value = "/AgentMasterUpdate", method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity<List<AgentMasterBean>> agentMasterUpdate(@RequestBody AgentMasterBean agent,HttpServletRequest request) throws Exception
       {	 
     logger.debug("agentMasterUpdate() method invoked in VtplReportController:");
     List<AgentMasterBean> list=new ArrayList<AgentMasterBean>();
    try {
    	RetailRegistrationBean rb=(RetailRegistrationBean)request.getSession().getAttribute("user1");
    	agent.setActive("Y");
    	agent.setModified_by(rb.getUser_id());
    	 Date dt = new Date();
    	 agent.setModified_on(dt);
    	 
    	 agentmasterservice.agentMasterUpdate(agent);
    	list = agentmasterservice.agent();
      return new ResponseEntity<List<AgentMasterBean>>(list, HttpStatus.OK);
    } catch (Exception e) {
    	logger.error("Error in  agentMasterUpdate " + this.getClass(), e);    	
    	return new ResponseEntity<List<AgentMasterBean>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("AgentMaster() mehtod executes Successfully:");
    }

  }
  @RequestMapping(value = "/agentDelete", method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity<List<AgentMasterBean>> agentTypDelete(@RequestBody AgentMasterBean agent_typ,HttpServletRequest request) throws Exception
  
       {	 
     logger.debug("agentTypDelete() method invoked in VtplReportController:");
     List<AgentMasterBean> list=new ArrayList<AgentMasterBean>();
    try { 
    	
    	//System.out.println("the item type is:-----"+item_typ.getItm_typ_id());
    
    	RetailRegistrationBean rb=(RetailRegistrationBean)request.getSession().getAttribute("user1");
    	agent_typ.setActive("Y");
    	agent_typ.setModified_by(rb.getUser_id());
    	 Date dt = new Date();
    	 agent_typ.setModified_on(dt);
    	 agentmasterservice.agentTypeDelete(agent_typ);
    	//list = agentmasterservice.agent_type();
      return new ResponseEntity<List<AgentMasterBean>>(list, HttpStatus.OK);
    } catch (Exception e) {
    	logger.error("Error in  agentTypeDelete " + this.getClass(), e);    	
    	return new ResponseEntity<List<AgentMasterBean>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("AgentMaster() mehtod executes Successfully:");
    }

  }
  





}

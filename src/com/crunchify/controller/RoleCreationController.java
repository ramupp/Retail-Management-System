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
import com.crunchify.services.RegService;
import com.crunchify.services.RoleService;


@RestController
public class RoleCreationController {

	private static final Logger logger = Logger.getLogger(RoleCreationController.class);
	
  @Autowired
  private RoleService roleservice;

  
  
  @RequestMapping(value = "/rolecreation", method = RequestMethod.POST,produces = "application/json", consumes="application/json")
  public ResponseEntity<List<RoleDataHdr>> roleCreate(@RequestBody RoleDataHdr rhdr,HttpServletRequest request) throws Exception
       {	 
     logger.debug("roleCreate() method invoked in VtplReportController:");
     List<RoleDataHdr> list=new ArrayList<RoleDataHdr>();
    try {
    	roleservice.roleCreate(rhdr);
      return new ResponseEntity<List<RoleDataHdr>>(list, HttpStatus.OK);
    } catch (Exception e) {
    	logger.error("Error in  roleCreate " + this.getClass(), e);    	
      return new ResponseEntity<List<RoleDataHdr>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("rolecreation() mehtod executes Successfully:");
    }

  }
  
  
  @RequestMapping(value = "/roleupdation", method = RequestMethod.POST,produces = "application/json", consumes="application/json")
  public ResponseEntity<List<RoleDataHdr>> roleUpdate(@RequestBody RoleDataHdr rhdr,HttpServletRequest request) throws Exception
       {	 
     logger.debug("roleUpdate() method invoked in VtplReportController:");
     List<RoleDataHdr> list=new ArrayList<RoleDataHdr>();
    try {
    	roleservice.roleUpdate(rhdr);
      return new ResponseEntity<List<RoleDataHdr>>(list, HttpStatus.OK);
    } catch (Exception e) {
    	logger.error("Error in  roleUpdate " + this.getClass(), e);    	
      return new ResponseEntity<List<RoleDataHdr>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("roleUpdate() mehtod executes Successfully:");
    }

  }
  
  
//  @RequestMapping(value = "/menucreation", method = RequestMethod.POST,produces = "application/json", consumes="application/json")
//  public ResponseEntity<List<MenuDataBean>> menuCreate(@RequestBody MenuDataBean mbean,HttpServletRequest request) throws Exception
//       {	 
//     logger.debug("menuCreate() method invoked in VtplReportController:");
//     List<MenuDataBean> list=new ArrayList<MenuDataBean>();
//    try {
//    	mbean.setActive("Y");
//    	roleservice.menuCreate(mbean);
//      return new ResponseEntity<List<MenuDataBean>>(list, HttpStatus.OK);
//    } catch (Exception e) {
//    	logger.error("Error in  roleCreate " + this.getClass(), e);    	
//      return new ResponseEntity<List<MenuDataBean>>(list, HttpStatus.OK);
//    }
//    finally
//    {
//    	logger.debug("rolecreation() mehtod executes Successfully:");
//    }
//
//  }
  
  
  
  
  
  @RequestMapping(value = "/usercreationrole", method = RequestMethod.POST,produces = "application/json", consumes="application/json")
  public ResponseEntity<List<UserRegRoleCompany>> userCreate(@RequestBody UserRegRoleCompany urc,HttpServletRequest request) throws Exception
       {
	  System.out.println("i am in usercreationrole");
     logger.debug("userCreate() method invoked in VtplReportController:");
     List<UserRegRoleCompany> list=new ArrayList<UserRegRoleCompany>();
     
     RetailRegistrationBean rbean=new RetailRegistrationBean(); 
     List<UserRoleCompany> roleComp=new ArrayList<>();
     
     rbean.setUser_id(urc.getUser_id());
     rbean.setUser_nm(urc.getUser_nm());
     rbean.setUser_pw(urc.getUser_pw());
     //rbean.setUser_type("U");
     rbean.setQues(urc.getQues());
     rbean.setQues_ans(urc.getQuesAns());
//   
     HashMap<Integer,Integer> a = urc.getcId();
     HashMap<Integer, List<Integer>> c=urc.getRoleId();
    
    
     for (Entry<Integer, Integer> entry : a.entrySet()) {
    	   // System.out.println("aaa-"+entry.getKey()+"-bbb-"+entry.getValue());
    	   // for (Entry<Integer,List<Integer>> val : c.entrySet()) {
    	    	
    	    List<Integer> p=c.get(entry.getKey());
    	    UserRoleCompany x=null;
    	    
    	    for (int i = 0; i < p.size(); i++)  {
    	    	x=new UserRoleCompany();
				x.setUser_id(urc.getUser_id());
				x.setCo_id(entry.getValue().toString());
				x.setRole_id(p.get(i).toString());
				System.out.println("the key is:-"+entry.getValue().toString()+" ,the array is:-"+x.getRole_id());
				roleComp.add(x);
			}
			
    	}
    
     
    try {
    	roleservice.userCreate(rbean,roleComp);
      return new ResponseEntity<List<UserRegRoleCompany>>(list, HttpStatus.OK);
    } catch (Exception e) {
    	logger.error("Error in  roleCreate " + this.getClass(), e);    	
      return new ResponseEntity<List<UserRegRoleCompany>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("rolecreation() mehtod executes Successfully:");
    }

  }
  
  
  @RequestMapping(value = "/Change_Pwd", method = RequestMethod.POST ,produces = "application/json", consumes="application/json")
  @ResponseBody
  public ResponseEntity<List<RetailRegistrationBean>> changePwdUpdate(@RequestBody RetailRegistrationBean pwd,HttpServletRequest request) throws Exception
       {	 
     logger.debug("changePwdUpdate() method invoked in VtplReportController:");
     List<RetailRegistrationBean> list=new ArrayList<RetailRegistrationBean>();
    try {
    	RetailRegistrationBean rb=(RetailRegistrationBean)request.getSession().getAttribute("user1");
    	//pwd.setActive("Y");
    	pwd.setModified_by(rb.getUser_id());
    	 Date dt = new Date();
    	 pwd.setModified_on(dt);
    	 roleservice.changePwdUpdate(pwd);
    	list = roleservice.change_pwd();
      return new ResponseEntity<List<RetailRegistrationBean>>(list, HttpStatus.OK);
    } catch (Exception e) {
    	logger.error("Error in  changePwdUpdate " + this.getClass(), e);    	
    	return new ResponseEntity<List<RetailRegistrationBean>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("Change_Pwd() mehtod executes Successfully:");
    }

  }

  
  
  

}

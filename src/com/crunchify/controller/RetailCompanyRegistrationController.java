package com.crunchify.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import org.springframework.web.bind.annotation.SessionAttributes;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.RetailCompanyMasterBean;
import com.crunchify.model.RetailOrgMasterBean;
import com.crunchify.model.RetailRegistrationBean;
import com.crunchify.services.RetailCompanyMasterService;
import com.crunchify.services.RetailOrgMasterService;


@RestController
public class RetailCompanyRegistrationController {
	
	private static final Logger logger = Logger.getLogger(RetailOrgMasterBean.class);
	
	@Autowired
	private RetailOrgMasterService orgMasterService;
	
	@Autowired
	private RetailCompanyMasterService companyMasterService;
	
	 @RequestMapping(value = "/addOrgMaster", method = RequestMethod.POST, consumes="application/json")
	 @ResponseBody
	 public String addOrg(@RequestBody RetailOrgMasterBean org, HttpServletRequest request ) throws Exception
     {
		 System.out.println("i am in controller");
		// RetailRegistrationBean x =(RetailRegistrationBean) request.getSession().getAttribute("user1");
		 System.out.println("active is :-"+org.getActive()+ "org nm:-"+org.getOrg_nm());
		 int flag=-1;
		 String msg="";
		 try {
			
			// System.out.println("user is:-"+x.getUser_id());
			// org.setCreated_on(x.getUser_id());
		    	flag = orgMasterService.addOrg(org);
		    System.out.println("flag is:-"+flag);
		    if(flag==0)
		    {
		    	msg="error";
		      return msg;
		    }else{ msg="success";
		      return msg;}
		    } catch (SpringCrunchifyException e) {
		    	logger.error("Error in  user registration " + this.getClass(), e);    
		    	msg="error";
			      return msg;
		    }
		    finally
		    {
		    	logger.debug("UserRegister() mehtod executes Successfully:");
		    }
		// return 0;
     }
	 
	 @RequestMapping(value = "/addCompanyMaster", method = RequestMethod.POST, consumes="application/json" )
	 @ResponseBody
	 public String addCompanyMaster(@RequestBody RetailCompanyMasterBean comp, HttpServletRequest request) throws Exception
     {
		 System.out.println("i am in controller");
		// RetailRegistrationBean x =(RetailRegistrationBean) request.getSession().getAttribute("user1");
		 System.out.println("active is :-"+comp.getActive()+ "comp key:-"+comp.getCo_key());
		 int flag=-1;
		 String msg="";
		 try {
			
			// System.out.println("user is:-"+x.getUser_id());
			// org.setCreated_on(x.getUser_id());
		    	flag = companyMasterService.addCompany(comp);
		    System.out.println("flag is:-"+flag);
		    if(flag==0)
		    {
		    	msg="error";
		      return msg;
		    }else{ msg="success";
		      return msg;}
		    } catch (SpringCrunchifyException e) {
		    	logger.error("Error in  user registration " + this.getClass(), e);    
		    	msg="error";
			      return msg;
		    }
		    finally
		    {
		    	logger.debug("UserRegister() mehtod executes Successfully:");
		    }
		// return 0;
     }
     
	 
}

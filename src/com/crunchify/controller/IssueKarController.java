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
import com.crunchify.model.IssueKarHdrBean;
import com.crunchify.model.ItemMasterBean;
import com.crunchify.model.ItemTypeBean;
import com.crunchify.model.RetailRegistrationBean;
import com.crunchify.model.view.ItemMasterViewBean;
import com.crunchify.services.IssueKarService;
import com.crunchify.util.UtilityHelper;


@RestController
public class IssueKarController {

 private static final Logger logger = Logger.getLogger(IssueKarController.class);
	
  @Autowired
  private IssueKarService issueKarService;

  @Autowired
  ServletContext context;
  
  
  @RequestMapping(value = "/addIssuekar", method = RequestMethod.POST, consumes="application/json")
  @ResponseBody
	public String addIssueKar(@RequestBody IssueKarHdrBean kar,
			HttpServletRequest request) {
	String retVal=null;
	//System.out.println("i m in kar:-");
	RetailRegistrationBean rb=(RetailRegistrationBean)request.getSession().getAttribute("user1");
	UtilityHelper util=new UtilityHelper();
	int org=util.findOrgIdByCoId(Integer.parseInt(rb.getCo_id()));
	//int updateId=Integer.parseInt(request.getSession().getAttribute("idp").toString());
	//slip.setUpdateId(updateId);
	kar.setActive("Y");
	kar.setCreated_by(rb.getUser_id());
	kar.setCo_id(Integer.parseInt(rb.getCo_id()));
	kar.setOrg_id(org);
	kar.setType("I");
	kar.setStatus("O");
	//NumberToWordsConverter ctx= new NumberToWordsConverter(slip.getNet_amt());
	//String amount_inword=ctx.returnText();
	//slip.setAmt_in_word(amount_inword);
	Date dt=new Date();
	kar.setCreated_on(dt);
				try {
					retVal= issueKarService.addIssueKar(kar);
					System.out.println("the retVal->"+retVal);
					return  retVal;

				} catch (SpringCrunchifyException e) {
					e.printStackTrace();
					return null;
				}
			
	}
  
  @RequestMapping(value = "/fetchAllIssuekar", method = RequestMethod.GET,produces = "application/json")
  public ResponseEntity<List<IssueKarHdrBean>> fetchAllIssuekar( HttpServletRequest request) throws Exception
       {
	  System.out.println("hello world");
     logger.debug("appReports() method invoked in VtplReportController:");
     List<IssueKarHdrBean> list=new ArrayList<IssueKarHdrBean>();
    
    try {
    	list = issueKarService.kar();
//    	for (ItemMasterBean itemMasterservice : list) {
//    		System.out.println(itemMasterservice.item_master());
		
    	System.out.println("Sucessfully executed");
    	//String x=gson.toJson(list);
    	//data.put("current", String.valueOf(request.getParameter("current")));
    	//data.put("rowCount", String.valueOf(request.getParameter("rowCount")));
    	//data.put("rows", list);
    	//data.put("total",String.valueOf(list.size()));
    
      return new ResponseEntity<List<IssueKarHdrBean>>(list, HttpStatus.OK);
    } catch (SpringCrunchifyException e) {
    	logger.error("Error in  user registration " + this.getClass(), e);    	
      return new ResponseEntity<List<IssueKarHdrBean>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("viewTypCreate() mehtod executes Successfully:");
    }

  }

  @RequestMapping(value = "/IssuekarUpdate", method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity<List<IssueKarHdrBean>> IssuekarUpdate(@RequestBody IssueKarHdrBean data,HttpServletRequest request) throws Exception
       {	 
     logger.debug("itmUpdate() method invoked in VtplReportController:");
     List<IssueKarHdrBean> list=new ArrayList<IssueKarHdrBean>();
     System.out.println("arka");
    try {
    	RetailRegistrationBean rb=(RetailRegistrationBean)request.getSession().getAttribute("user1");
    	data.setActive("Y");
    	data.setModified_by(rb.getUser_id());
    	 Date dt = new Date();
    	 data.setModified_on(dt);
    	 issueKarService.updateIssueKar(data);
    	list = issueKarService.kar();
      return new ResponseEntity<List<IssueKarHdrBean>>(list, HttpStatus.OK);
    } catch (Exception e) {
    	logger.error("Error in  itemMasterCreate " + this.getClass(), e);    	
    	return new ResponseEntity<List<IssueKarHdrBean>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("Additm_master() mehtod executes Successfully:");
    }

  }
  
  
  
}

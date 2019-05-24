package com.crunchify.controller;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.*;
import com.crunchify.model.view.CashSaleViewBean;
import com.crunchify.model.view.DesignViewBean;
import com.crunchify.services.CashSaleService;
import com.crunchify.services.RegService;
import com.crunchify.services.RetailDesignService;
import com.crunchify.services.RoleService;
import com.crunchify.util.Barcode_Image;
import com.crunchify.util.MyConnection;
import com.crunchify.util.NumberToWordsConverter;


@RestController
public class CashSaleController {

	private static final Logger logger = Logger.getLogger(CashSaleController.class);
	
  @Autowired
  private CashSaleService cashSaleService;

  @Autowired
  ServletContext context;
  
  
  @RequestMapping(value = "/addCashSale", method = RequestMethod.POST)
  @ResponseBody
	public String addDesign(@RequestBody CashSaleHdrBean cashSale,HttpServletRequest request) {
	RetailRegistrationBean rb=(RetailRegistrationBean)request.getSession().getAttribute("user1");
	//int updateId=Integer.parseInt(request.getSession().getAttribute("idp").toString());
	//cashSale.setUpdateId(updateId);
	cashSale.setActive("Y");
	cashSale.setCreated_by(rb.getUser_id());
	NumberToWordsConverter ctx= new NumberToWordsConverter(cashSale.getNet_amt());
	String amount_inword=ctx.returnText();
	cashSale.setAmt_in_word(amount_inword);
	cashSale.setCo_id(Integer.parseInt(rb.getCo_id()));
	Date dt=new Date();
	cashSale.setCreated_on(dt);
				try {
					return cashSaleService.addCashSale(cashSale);
				} catch (SpringCrunchifyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}
			
	}
  
  @RequestMapping(value = "/fetchCashSaleDetails", method = RequestMethod.GET,produces = "application/json")
  public ResponseEntity<List<CashSaleViewBean>> fetchDesignDetails1() throws Exception
       {	 
     logger.debug("roleCreate() method invoked in VtplReportController:");
     List<CashSaleViewBean> list=new ArrayList<CashSaleViewBean>();
    try {
    
    	list=cashSaleService.getCashSaleDetails();
    	 return new ResponseEntity<List<CashSaleViewBean>>(list, HttpStatus.OK);
    } catch (Exception e) {
    	logger.error("Error in  roleCreate " + this.getClass(), e);    	
    	 return new ResponseEntity<List<CashSaleViewBean>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("rolecreation() mehtod executes Successfully:");
    }

  }
  
  @RequestMapping(value = "/fetchCashParty", method = RequestMethod.GET,produces = "application/json")
  public ResponseEntity<List<Map<String,String>>> fetchCashParty(HttpServletRequest request) throws Exception
       {	 
	  RetailRegistrationBean rb=(RetailRegistrationBean)request.getSession().getAttribute("user1");
	  String co_id=rb.getCo_id();
     logger.debug("roleCreate() method invoked in VtplReportController:");
     List<AutocompleteBean> list=new ArrayList<AutocompleteBean>();
     Map<String,String> p=null;
     List<Map<String,String>> x= new ArrayList<>();
    try {
    
    	list=(ArrayList<AutocompleteBean>)cashSaleService.getCashParty(co_id);

    	
    	for (AutocompleteBean autocompleteBean :list) {
    		System.out.println("1:-"+autocompleteBean.getId()+" 2:-"+autocompleteBean.getLabel());
    		p=new HashMap<String,String>();
    		p.put("id",String.valueOf(autocompleteBean.getId()));
    		
    		p.put("label",String.valueOf(autocompleteBean.getLabel()));
    		x.add(p);
		}
    	
    	 return new ResponseEntity<List<Map<String,String>>>(x, HttpStatus.OK);
    } catch (Exception e) {
    	logger.error("Error in  roleCreate " + this.getClass(), e);    	
    	 return new ResponseEntity<List<Map<String,String>>>(x, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("rolecreation() mehtod executes Successfully:");
    }

  }
  
  
  

}

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
import org.json.JSONObject;
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
import com.crunchify.services.CashSaleService;
import com.crunchify.services.CrSaleService;
import com.crunchify.services.PackingSlipService;
import com.crunchify.services.RegService;
import com.crunchify.services.RetailDesignService;
import com.crunchify.services.RoleService;
import com.crunchify.util.Barcode_Image;
import com.crunchify.util.MyConnection;
import com.crunchify.util.NumberToWordsConverter;
import com.crunchify.util.UtilityHelper;


@RestController
public class CrSaleController {

	private static final Logger logger = Logger.getLogger(CrSaleController.class);
	
  @Autowired
  private CrSaleService crSaleService;

  @Autowired
  ServletContext context;
 
  
  
  @RequestMapping(value = "/addCrSale", method = RequestMethod.POST, consumes="application/json")
  @ResponseBody
	public String addCrSale(@RequestBody CrSaleHdrBean crSale,HttpServletRequest request) {
	  String retVal=null;
	RetailRegistrationBean rb=(RetailRegistrationBean)request.getSession().getAttribute("user1");
	//int updateId=Integer.parseInt(request.getSession().getAttribute("idp").toString());
	//crSale.setUpdateId(updateId);
	crSale.setActive("Y");
	crSale.setAccepted("N");
	crSale.setCreated_by(rb.getUser_id());
	crSale.setCo_id(Integer.parseInt(rb.getCo_id()));
	//UtilityHelper util=new UtilityHelper()
	NumberToWordsConverter ctx= new NumberToWordsConverter(crSale.getNet_amt());
	String amount_inword=ctx.returnText();
	crSale.setAmt_in_word(amount_inword);
	Date dt=new Date();
	crSale.setCreated_on(dt);
				try {
					retVal= crSaleService.addCrSale(crSale);
					System.out.println("the retVal->"+retVal);
					//JSONObject json=new JSONObject();
					//json.put("flag", retVal);
					return  retVal;

				} catch (SpringCrunchifyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}
			
	}
  
  @RequestMapping(value = "/addCrSaleForStockOut", method = RequestMethod.POST, consumes="application/json")
  @ResponseBody
	public String addCrSaleForStockOut(@RequestBody CrSaleHdrBean crSale,HttpServletRequest request) {
	  String retVal=null;
	RetailRegistrationBean rb=(RetailRegistrationBean)request.getSession().getAttribute("user1");
	//int updateId=Integer.parseInt(request.getSession().getAttribute("idp").toString());
	//crSale.setUpdateId(updateId);
	crSale.setActive("Y");
	crSale.setAccepted("N");
	crSale.setCreated_by(rb.getUser_id());
	crSale.setCo_id(Integer.parseInt(rb.getCo_id()));
	//UtilityHelper util=new UtilityHelper()
	NumberToWordsConverter ctx= new NumberToWordsConverter(crSale.getNet_amt());
	String amount_inword=ctx.returnText();
	crSale.setAmt_in_word(amount_inword);
	Date dt=new Date();
	crSale.setCreated_on(dt);
				try {
					retVal= crSaleService.addCrSaleForStockOut(crSale);
					System.out.println("the retVal->"+retVal);
					//JSONObject json=new JSONObject();
					//json.put("flag", retVal);
					return  retVal;

				} catch (SpringCrunchifyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}
			
	}
  
  
  
  
  
  
  

}

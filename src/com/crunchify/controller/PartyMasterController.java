package com.crunchify.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import com.crunchify.model.AutocompleteBean;
import com.crunchify.model.AutocompleteBean;
import com.crunchify.model.ItemMasterBean;
import com.crunchify.model.ItemTypeBean;
import com.crunchify.model.PartyMasterBean;
import com.crunchify.model.PartyViewBean;
import com.crunchify.model.RetailRegistrationBean;
import com.crunchify.model.RoleDataHdr;
import com.crunchify.model.StockData;
import com.crunchify.model.UserRegRoleCompany;
import com.crunchify.model.UserRoleCompany;
import com.crunchify.services.ItemMasterService;
import com.crunchify.services.ItemTypeService;
import com.crunchify.services.PartyMasterService;
import com.crunchify.services.RoleService;

@RestController
public class PartyMasterController {

	private static final Logger logger = Logger.getLogger(RoleCreationController.class);
	
  @Autowired
  private PartyMasterService party_masterservice;

  
  
  @RequestMapping(value = "/Addparty_master", method = RequestMethod.POST,produces = "application/json", consumes="application/json")
  @ResponseBody
  public String partyMasterCreate(@RequestBody PartyMasterBean party_m,HttpServletRequest request) throws Exception
 // public String partyMasterCreate(@RequestParam(value = "name", required=false)  String name)
       {	 
     logger.debug("partyMasterCreate() method invoked in VtplReportController:");
     List<PartyMasterBean> list=new ArrayList<PartyMasterBean>();
    try {
    	RetailRegistrationBean rb=(RetailRegistrationBean)request.getSession().getAttribute("user1");
    	party_m.setActive("Y");
    	party_m.setCo_location(Integer.parseInt(rb.getCo_id()));
    	party_m.setCreated_by(rb.getUser_id());
    	 Date dt = new Date();
    	 party_m.setCreated_on(dt);
    	return party_masterservice.partyMasterCreate(party_m);
     // return new ResponseEntity<List<PartyMasterBean>>(list, HttpStatus.OK);
    } catch (Exception e) {
    	logger.error("Error in  partyMasterCreate " + this.getClass(), e);    	
     // return new ResponseEntity<List<PartyMasterBean>>(list, HttpStatus.OK);
    	return "error";
    }
    finally
    {
    	logger.debug("Addparty_master() mehtod executes Successfully:");
    }

  }
  @RequestMapping(value = "/fetchAllPartyMaster", method = RequestMethod.GET,produces = "application/json")
  public ResponseEntity<List<PartyViewBean>> fetchAllPartyType( HttpServletRequest request) throws Exception
       {
	  System.out.println("im in controller");
     logger.debug("appReports() method invoked in VtplReportController:");
     List<PartyViewBean> list=new ArrayList<PartyViewBean>();
     PartyViewBean stData=new PartyViewBean();
     //stData.setDesg_no(desg_id);
     stData.setParty_nm("party_nm");
    
    try {
    	list = party_masterservice.party_master();
//    	for (ItemMasterBean itemMasterservice : list) {
    		System.out.println(party_masterservice.party_master());
		
    	System.out.println("Sucessfully executed");
    	//String x=gson.toJson(list);
    	//data.put("current", String.valueOf(request.getParameter("current")));
    	//data.put("rowCount", String.valueOf(request.getParameter("rowCount")));
    	//data.put("rows", list);
    	//data.put("total",String.valueOf(list.size()));
    
      return new ResponseEntity<List<PartyViewBean>>(list, HttpStatus.OK);
    } catch (SpringCrunchifyException e) {
    	logger.error("Error in  user registration " + this.getClass(), e);    	
      return new ResponseEntity<List<PartyViewBean>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("viewPartyMasterCreate() mehtod executes Successfully:");
    }

  }
  
  @RequestMapping(value = "/party_mtypUpdate", method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity<List<PartyMasterBean>> party_mTypUpdate(@RequestBody PartyMasterBean party_m,HttpServletRequest request) throws Exception
       {	 
     logger.debug("party_mTypUpdate() method invoked in VtplReportController:");
     List<PartyMasterBean> list=new ArrayList<PartyMasterBean>();
    try {
    	RetailRegistrationBean rb=(RetailRegistrationBean)request.getSession().getAttribute("user1");
    	party_m.setActive("Y");
    	party_m.setModified_by(rb.getUser_id());
    	 Date dt = new Date();
    	 party_m.setModified_on(dt);
    	 party_masterservice.party_mTypeUpdate(party_m);
    	//list = party_masterservice.party_type();
      return new ResponseEntity<List<PartyMasterBean>>(list, HttpStatus.OK);
    } catch (Exception e) {
    	logger.error("Error in  itemTypeUpdate " + this.getClass(), e);    	
    	return new ResponseEntity<List<PartyMasterBean>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("Addparty_master() mehtod executes Successfully:");
    }

  }
  
  @RequestMapping(value = "/partyDelete", method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity<List<PartyMasterBean>> partyTypDelete(@RequestBody PartyMasterBean party_typ,HttpServletRequest request) throws Exception
  
       {	 
     logger.debug("partyTypDelete() method invoked in VtplReportController:");
     List<PartyMasterBean> list=new ArrayList<PartyMasterBean>();
    try { 
    	//System.out.println("the item type is:-----"+item_typ.getItm_typ_id());
    
    	RetailRegistrationBean rb=(RetailRegistrationBean)request.getSession().getAttribute("user1");
    	party_typ.setActive("Y");
    	party_typ.setModified_by(rb.getUser_id());
    	 Date dt = new Date();
    	 party_typ.setModified_on(dt);
    	 party_masterservice.partyTypDelete(party_typ);
    	//list = party_masterservice.party_type();
      return new ResponseEntity<List<PartyMasterBean>>(list, HttpStatus.OK);
    } catch (Exception e) {
    	logger.error("Error in  partyTypeDelete " + this.getClass(), e);    	
    	return new ResponseEntity<List<PartyMasterBean>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("Addparty_master() mehtod executes Successfully:");
    }

  }
  
  @RequestMapping(value = "/fetchCustomerForPartyMaster", method = RequestMethod.GET,produces = "application/json")
  public ResponseEntity<List<Map<String,String>>> fetchCustomerForPartyMaster(HttpServletRequest request,@RequestParam("val") String id) throws Exception
       {	 
	  RetailRegistrationBean rb=(RetailRegistrationBean)request.getSession().getAttribute("user1");
	 // String co_id=rb.getCo_id();
	  System.out.println("idid:----"+id);
     logger.debug("fetchCustomerForPartyMaster() method invoked in VtplReportController:");
     List<AutocompleteBean> list=new ArrayList<>();
     Map<String,String> p=null;
     List<Map<String,String>> x= new ArrayList<>();
    try {
    	//party_masterservice.fetchCustomerForPartyMaster(id);
    	list=(ArrayList<AutocompleteBean>)party_masterservice.fetchCustomerForPartyMaster(id);

    	
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


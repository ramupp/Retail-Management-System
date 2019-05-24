package com.crunchify.services.Impl;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crunchify.dao.PurchaseDao;
import com.crunchify.dao.StockDao;
import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.AutocompleteBean;
import com.crunchify.model.AutocompleteDesignBean;
import com.crunchify.model.PurDataHdr;
import com.crunchify.model.StockData;
import com.crunchify.model.view.CashSaleViewBean;
import com.crunchify.model.view.PurDataViewBean;
import com.crunchify.services.PurchaseService;
import com.crunchify.services.StockService;


@Service
@Transactional
public class PurchaseServiceImpl implements PurchaseService {
	
	 private static final Logger logger = Logger.getLogger(PurchaseServiceImpl.class);
	 
  @Autowired
  PurchaseDao purDao;
  
  
  @Override
  @Transactional
  public String purchaseEntry(PurDataHdr purDataHdr) throws SpringCrunchifyException {
	  try {    	
	    	 logger.debug("Inside purchaseEntry() method");
	    	 
	    	
	    	return purDao.purchaseEntry(purDataHdr);
	    	// return "success";
	    	
	    	
	    } catch (Exception e) {
	    	logger.error("Error in  roleCreate : " + this.getClass(), e);
	    	throw new SpringCrunchifyException(e);
	    }   
	    finally {
	        logger.debug("Dao Implemented:");
	    }
} 
  
  @Override
  @Transactional
  public String purchaseReturnEntry(PurDataHdr purDataHdr) throws SpringCrunchifyException {
	  try {    	
	    	 logger.debug("Inside purchaseEntry() method");
	    	 
	    	
	    	return purDao.purchaseReturnEntry(purDataHdr);
	    	
	    	
	    } catch (Exception e) {
	    	logger.error("Error in  roleCreate : " + this.getClass(), e);
	    	throw new SpringCrunchifyException(e);
	    }   
	    finally {
	        logger.debug("Dao Implemented:");
	    }
	  
} 
  
  @Override
  @Transactional
  public List<PurDataViewBean> getPurchaseDetails(String co) throws SpringCrunchifyException {
	  try {    	
	    	 logger.debug("Inside purchaseEntry() method");
	    	 
	    	
	    	 return purDao.getPurchaseDetails(co);
	    	
	    	
	    } catch (Exception e) {
	    	logger.error("Error in  roleCreate : " + this.getClass(), e);
	    	throw new SpringCrunchifyException(e);
	    }   
	    finally {
	        logger.debug("Dao Implemented:");
	    }
	 // return "";
} 
  
  @Override
	public List<AutocompleteDesignBean> fetchDesign(String id) throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		return purDao.fetchDesign(id);
	}
}

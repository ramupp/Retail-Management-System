package com.crunchify.services.Impl;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crunchify.dao.ItemMasterDao;
import com.crunchify.dao.ItemTypeDao;
import com.crunchify.dao.PriceTypeMasterDao;
import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.ItemMasterBean;
import com.crunchify.model.ItemRateTypeBean;
import com.crunchify.model.ItemTypeBean;
import com.crunchify.model.PriceTypeMasterBean;
import com.crunchify.services.ItemMasterService;
import com.crunchify.services.ItemTypeService;
import com.crunchify.services.PriceTypeMasterService;




@Service
@Transactional
public class PriceTypeMasterServiceImpl implements PriceTypeMasterService {
	
	 private static final Logger logger = Logger.getLogger(PriceTypeMasterServiceImpl.class);
	 
  @Autowired
  private PriceTypeMasterDao itemDao;
  
  
  @Override
  //@Transactional
  public String priceMasterCreate(PriceTypeMasterBean price_m) throws SpringCrunchifyException{
  
    try {    	
    	 logger.debug("Inside priceMasterCreate() method");
    	 
    	
    	return itemDao.priceMasterCreate(price_m);
    	
    	
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
 	public List<PriceTypeMasterBean> price_type()
 			throws SpringCrunchifyException {
 		// TODO Auto-generated method stub
 		return itemDao.price_type();
 	}
  
  @Override
  //@Transactional
  public String priceTypUpdate(PriceTypeMasterBean price_type) throws SpringCrunchifyException{
  
    try {    	
    	 logger.debug("Inside itemTypeCreate() method");
    	 
    	
    	 return itemDao.priceTypUpdate(price_type);
    	
    	
    } catch (Exception e) {
    	logger.error("Error in  roleCreate : " + this.getClass(), e);
    	throw new SpringCrunchifyException(e);
    }   
    finally {
        logger.debug("Dao Implemented:");
    }
    //return "";
}
  
  
  @Override
  //@Transactional
  public String priceTypeDelete(PriceTypeMasterBean price_typ) throws SpringCrunchifyException{
  
    try {    	
    	 logger.debug("Inside itemTypeCreate() method");
    	 
    	
    	 return itemDao.priceTypeDelete(price_typ);
    	
    	
    } catch (Exception e) {
    	logger.error("Error in  roleCreate : " + this.getClass(), e);
    	throw new SpringCrunchifyException(e);
    }   
    finally {
        logger.debug("Dao Implemented:");
    }
    //return "";
}
  
  
 
}

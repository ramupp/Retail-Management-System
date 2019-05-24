package com.crunchify.services.Impl;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crunchify.dao.ItemRateTypeDao;
import com.crunchify.dao.ItemTypeDao;
import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.ItemMasterBean;
import com.crunchify.model.ItemRateTypeBean;
import com.crunchify.model.ItemTypeBean;
import com.crunchify.services.ItemRateTypeService;
import com.crunchify.services.ItemTypeService;




@Service
@Transactional
public class ItemRateTypeServiceImpl implements ItemRateTypeService {
	
	 private static final Logger logger = Logger.getLogger(ItemRateTypeServiceImpl.class);
	 
  @Autowired
  private ItemRateTypeDao itemDao;
  
  
  @Override
  //@Transactional
  public String itemRateCreate(ItemRateTypeBean item_rate) throws SpringCrunchifyException{
  
    try {    	
    	 logger.debug("Inside itemRateCreate() method");
    	 
    	
    	return itemDao.itemRateCreate(item_rate);
    	
    	
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
	public List<ItemRateTypeBean> item_rate()
			throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		return itemDao.item_rate();
	}
  
  @Override
  //@Transactional
  public String itemRateUpdate(ItemRateTypeBean rate) throws SpringCrunchifyException{
  
    try {    	
    	 logger.debug("Inside itemRateCreate() method");
    	 
    	
    	return itemDao.itemRateUpdate(rate);
    	
    	
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
  //@Transactional
  public String rateTypeDelete(ItemRateTypeBean rate_typ) throws SpringCrunchifyException{
  
    try {    	
    	 logger.debug("Inside itemTypeCreate() method");
    	 
    	
    	 return itemDao.rateTypeDelete(rate_typ);
    	
    	
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

package com.crunchify.services.Impl;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crunchify.dao.ItemMasterDao;
import com.crunchify.dao.ItemTypeDao;
import com.crunchify.dao.RetailLoginDao;
import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.ItemMasterBean;
import com.crunchify.model.ItemTypeBean;
import com.crunchify.model.RetailRegistrationBean;
import com.crunchify.model.view.ItemMasterViewBean;
import com.crunchify.services.ItemMasterService;
import com.crunchify.services.ItemTypeService;
import com.crunchify.services.RetailLoginService;




@Service
@Transactional
public class ItemMasterServiceImpl implements ItemMasterService {
	
	 private static final Logger logger = Logger.getLogger(ItemMasterServiceImpl.class);
	 
  @Autowired
  private ItemMasterDao itemDao;
  
  
  @Override
  //@Transactional
  public String itemMasterCreate(ItemMasterBean item_m) throws SpringCrunchifyException{
  
    try {    	
    	 logger.debug("Inside itemMasterCreate() method");
    	 
    	
    	return itemDao.itemMasterCreate(item_m);
    	
    	
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
	public List<ItemMasterViewBean> item_master()
			throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		return itemDao.item_master();
	}
  @Override
  //@Transactional
  public String itemMasterUpdate(ItemMasterBean item_m) throws SpringCrunchifyException{
  
    try {    	
    	 logger.debug("Inside itemMasterCreate() method");
    	 
    	
    	return itemDao.itemMasterUpdate(item_m);
    	
    	
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
  public String itemMasterDelete(ItemMasterBean item_master) throws SpringCrunchifyException{
  
    try {    	
    	 logger.debug("Inside itemTypeCreate() method");
    	 
    	
    	 return itemDao.itemMasterDelete(item_master);
    	
    	
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


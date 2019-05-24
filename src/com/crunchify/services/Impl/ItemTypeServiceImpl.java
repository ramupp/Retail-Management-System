package com.crunchify.services.Impl;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crunchify.dao.ItemTypeDao;
import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.ItemMasterBean;
import com.crunchify.model.ItemTypeBean;
import com.crunchify.services.ItemTypeService;




@Service
@Transactional
public class ItemTypeServiceImpl implements ItemTypeService {
	
	 private static final Logger logger = Logger.getLogger(ItemTypeServiceImpl.class);
	 
  @Autowired
  private ItemTypeDao itemDao;
  
  
  @Override
  //@Transactional
  public String itemTypeCreate(ItemTypeBean item) throws SpringCrunchifyException{
  
    try {    	
    	 logger.debug("Inside itemTypeCreate() method");
    	 
    	
    	 return itemDao.itemTypeCreate(item);
    	
    	
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
 	public List<ItemTypeBean> item_type()
 			throws SpringCrunchifyException {
 		// TODO Auto-generated method stub
 		return itemDao.item_type();
 	}
  
  @Override
  //@Transactional
  public String itemTypeUpdate(ItemTypeBean item) throws SpringCrunchifyException{
  
    try {    	
    	 logger.debug("Inside itemTypeCreate() method");
    	 
    	
    	 return itemDao.itemTypeUpdate(item);
    	
    	
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
  public String itemTypeDelete(ItemTypeBean item_typ) throws SpringCrunchifyException{
  
    try {    	
    	 logger.debug("Inside itemTypeCreate() method");
    	 
    	
    	 return itemDao.itemTypeDelete(item_typ);
    	
    	
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

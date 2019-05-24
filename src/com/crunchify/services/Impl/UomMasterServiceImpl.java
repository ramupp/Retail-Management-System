package com.crunchify.services.Impl;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crunchify.dao.ItemMasterDao;
import com.crunchify.dao.ItemTypeDao;
import com.crunchify.dao.UomMasterDao;
import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.ItemMasterBean;
import com.crunchify.model.ItemTypeBean;
import com.crunchify.model.UomMasterBean;
import com.crunchify.services.ItemMasterService;
import com.crunchify.services.ItemTypeService;
import com.crunchify.services.UomMasterService;




@Service
@Transactional
public class UomMasterServiceImpl implements UomMasterService {
	
	 private static final Logger logger = Logger.getLogger(UomMasterServiceImpl.class);
	 
  @Autowired
  private UomMasterDao itemDao;
  
  
  @Override
  //@Transactional
  public String uomMasterCreate(UomMasterBean uom_m) throws SpringCrunchifyException{
  
    try {    	
    	 logger.debug("Inside uomMasterCreate() method");
    	 
    	
    	return itemDao.uomMasterCreate(uom_m);
    	
    	
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
 	public List<UomMasterBean> uom_master()
 			throws SpringCrunchifyException {
 		// TODO Auto-generated method stub
 		return itemDao.uom_master();
 	}
  
  @Override
  //@Transactional
  public String uomMasterUpdate(UomMasterBean uom_m) throws SpringCrunchifyException{
  
    try {    	
    	 logger.debug("Inside uomMasterCreate() method");
    	 
    	
    	return itemDao.uomMasterUpdate(uom_m);
    	
    	
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
  public String uomTypeDelete(UomMasterBean uom_typ) throws SpringCrunchifyException{
  
    try {    	
    	 logger.debug("Inside itemTypeCreate() method");
    	 
    	
    	 return itemDao.uomTypeDelete(uom_typ);
    	
    	
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

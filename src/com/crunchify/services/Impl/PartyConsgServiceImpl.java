package com.crunchify.services.Impl;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crunchify.dao.ItemMasterDao;
import com.crunchify.dao.ItemTypeDao;
import com.crunchify.dao.PartyConsgDao;
import com.crunchify.dao.PartyMasterDao;
import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.ConsgMasterBean;
import com.crunchify.model.ConsgViewBean;
import com.crunchify.model.ItemMasterBean;
import com.crunchify.model.ItemTypeBean;
import com.crunchify.model.PartyMasterBean;
import com.crunchify.model.PartyViewBean;
import com.crunchify.services.ItemMasterService;
import com.crunchify.services.ItemTypeService;
import com.crunchify.services.PartyConsgService;
import com.crunchify.services.PartyMasterService;




@Service
@Transactional
public class PartyConsgServiceImpl implements PartyConsgService {
	
	 private static final Logger logger = Logger.getLogger(PartyConsgServiceImpl.class);
	 
  @Autowired
  private PartyConsgDao itemDao;
  
  
  @Override
  //@Transactional
  public String consgMasterCreate(ConsgMasterBean consg_m) throws SpringCrunchifyException{
  
    try {    	
    	 logger.debug("Inside consgMasterCreate() method");
    	 
    	
    	return itemDao.consgMasterCreate(consg_m);
    	
    	
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
 	public List<ConsgViewBean> consg_master()
 			throws SpringCrunchifyException {
 		// TODO Auto-generated method stub
 		return itemDao.consg_master();
 	}
  
  @Override
  //@Transactional
  public String consgUpdate(ConsgMasterBean consg) throws SpringCrunchifyException{
  
    try {    	
    	 logger.debug("Inside consgMasterCreate() method");
    	 
    	
    	return itemDao.consgUpdate(consg);
    	
    	
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
  public String consgTypeDelete(ConsgMasterBean consg_typ) throws SpringCrunchifyException{
  
    try {    	
    	 logger.debug("Inside itemTypeCreate() method");
    	 
    	
    	 return itemDao.consgTypeDelete(consg_typ);
    	
    	
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

package com.crunchify.services.Impl;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crunchify.dao.CityMasterDao;
import com.crunchify.dao.ItemMasterDao;
import com.crunchify.dao.ItemTypeDao;
import com.crunchify.dao.StateMasterDao;
import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.CityMasterBean;
import com.crunchify.model.ItemMasterBean;
import com.crunchify.model.ItemTypeBean;
import com.crunchify.model.StateMasterBean;
import com.crunchify.services.CityMasterService;
import com.crunchify.services.ItemMasterService;
import com.crunchify.services.ItemTypeService;
import com.crunchify.services.StateMasterService;




@Service
@Transactional
public class StateMasterServiceImpl implements StateMasterService {
	
	 private static final Logger logger = Logger.getLogger(StateMasterServiceImpl.class);
	 
  @Autowired
  private StateMasterDao itemDao;
  
  
  @Override
  //@Transactional
  public String stateMasterCreate(StateMasterBean state_m) throws SpringCrunchifyException{
  
    try {    	
    	 logger.debug("Inside stateMasterCreate() method");
    	 
    	
    	 return itemDao.stateMasterCreate(state_m);
    	
    	
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
	public List<StateMasterBean> state_type()
			throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		return itemDao.view_state_type();
	}
  
  @Override
  //@Transactional
  public String stateUpdate(StateMasterBean state) throws SpringCrunchifyException{
  
    try {    	
    	 logger.debug("Inside itemTypeCreate() method");
    	 
    	
    	 return itemDao.stateUpdate(state);
    	
    	
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
  public String stateTypeDelete(StateMasterBean state_typ) throws SpringCrunchifyException{
  
    try {    	
    	 logger.debug("Inside itemTypeCreate() method");
    	 
    	
    	 return itemDao.stateTypeDelete(state_typ);
    	
    	
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

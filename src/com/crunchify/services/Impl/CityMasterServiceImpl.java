package com.crunchify.services.Impl;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crunchify.dao.CityMasterDao;
import com.crunchify.dao.ItemMasterDao;
import com.crunchify.dao.ItemTypeDao;
import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.CityMasterBean;
import com.crunchify.model.ItemMasterBean;
import com.crunchify.model.ItemTypeBean;
import com.crunchify.model.PartyTypeBean;
import com.crunchify.services.CityMasterService;
import com.crunchify.services.ItemMasterService;
import com.crunchify.services.ItemTypeService;




@Service
@Transactional
public class CityMasterServiceImpl implements CityMasterService {
	
	 private static final Logger logger = Logger.getLogger(ItemMasterServiceImpl.class);
	 
  @Autowired
  private CityMasterDao itemDao;
  
  
  @Override
  //@Transactional
  public String cityMasterCreate(CityMasterBean city_m) throws SpringCrunchifyException{
  
    try {    	
    	 logger.debug("Inside cityMasterCreate() method");
    	 
    	
    	 return itemDao.cityMasterCreate(city_m);
    	
    	
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
 	public List<CityMasterBean> city_type()
 			throws SpringCrunchifyException {
 		// TODO Auto-generated method stub
 		return itemDao.view_city_type();
 	}
  
  @Override
  //@Transactional
  public String cityUpdate(CityMasterBean city) throws SpringCrunchifyException{
  
    try {    	
    	 logger.debug("Inside itemTypeCreate() method");
    	 
    	
    	 return itemDao.cityUpdate(city);
    	
    	
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
  public String cityTypeDelete(CityMasterBean city_typ) throws SpringCrunchifyException{
  
    try {    	
    	 logger.debug("Inside itemTypeCreate() method");
    	 
    	
    	 return itemDao.cityTypeDelete(city_typ);
    	
    	
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

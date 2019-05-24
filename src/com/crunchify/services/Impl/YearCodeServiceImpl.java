package com.crunchify.services.Impl;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crunchify.dao.ItemMasterDao;
import com.crunchify.dao.ItemTypeDao;
import com.crunchify.dao.YearCodeDao;
import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.ItemMasterBean;
import com.crunchify.model.ItemTypeBean;
import com.crunchify.model.UomMasterBean;
import com.crunchify.model.YearCodeBean;
import com.crunchify.services.ItemMasterService;
import com.crunchify.services.ItemTypeService;
import com.crunchify.services.YearCodeService;




@Service
@Transactional
public class YearCodeServiceImpl implements YearCodeService {
	
	 private static final Logger logger = Logger.getLogger(YearCodeServiceImpl.class);
	 
  @Autowired
  private YearCodeDao itemDao;
  
  
  @Override
  //@Transactional
  public String yearCodeCreate(YearCodeBean year_c) throws SpringCrunchifyException{
  
    try {    	
    	 logger.debug("Inside yearCodeCreate() method");
    	 
    	
    	 itemDao.yearCodeCreate(year_c);
    	
    	
    } catch (Exception e) {
    	logger.error("Error in  roleCreate : " + this.getClass(), e);
    	throw new SpringCrunchifyException(e);
    }   
    finally {
        logger.debug("Dao Implemented:");
    }
    return "success";
}
  @Override
	public List<YearCodeBean> yearcd_master()
			throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		return itemDao.yearcd_master();
	}
  
  @Override
  //@Transactional
  public String yearCodeUpdate(YearCodeBean yr_cd) throws SpringCrunchifyException{
  
    try {    	
    	 logger.debug("Inside itemTypeCreate() method");
    	 
    	
    	 return itemDao.yearCodeUpdate(yr_cd);
    	
    	
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
  public String yearCodeDelete(YearCodeBean year_cd) throws SpringCrunchifyException{
  
    try {    	
    	 logger.debug("Inside itemTypeCreate() method");
    	 
    	
    	 return itemDao.yearCodeDelete(year_cd);
    	
    	
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

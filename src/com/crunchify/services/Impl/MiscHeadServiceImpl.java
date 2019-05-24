package com.crunchify.services.Impl;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crunchify.dao.ItemTypeDao;
import com.crunchify.dao.MiscHeadDao;
import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.ItemMasterBean;
import com.crunchify.model.ItemTypeBean;
import com.crunchify.model.MiscHeadBean;
import com.crunchify.services.ItemTypeService;
import com.crunchify.services.MiscHeadService;




@Service
@Transactional
public class MiscHeadServiceImpl implements MiscHeadService {
	
	 private static final Logger logger = Logger.getLogger(ItemTypeServiceImpl.class);
	 
  @Autowired
  private MiscHeadDao itemDao;
  
  
  @Override
  //@Transactional
  public String miscHeadCreate(MiscHeadBean misc) throws SpringCrunchifyException{
  
    try {    	
    	 logger.debug("Inside itemTypeCreate() method");
    	 
    	
    	 return itemDao.miscHeadCreate(misc);
    	
    	
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
 	public List<MiscHeadBean> misc_head()
 			throws SpringCrunchifyException {
 		// TODO Auto-generated method stub
 		return itemDao.misc_head();
 	}
  
  
  
}

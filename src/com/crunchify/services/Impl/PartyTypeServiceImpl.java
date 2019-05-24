package com.crunchify.services.Impl;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crunchify.dao.ItemMasterDao;
import com.crunchify.dao.ItemTypeDao;
import com.crunchify.dao.PartyTypeDao;
import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.ItemMasterBean;
import com.crunchify.model.ItemTypeBean;
import com.crunchify.model.PartyTypeBean;
import com.crunchify.services.ItemMasterService;
import com.crunchify.services.ItemTypeService;
import com.crunchify.services.PartyTypeService;




@Service
@Transactional
public class PartyTypeServiceImpl implements PartyTypeService {
	
	 private static final Logger logger = Logger.getLogger(PartyTypeServiceImpl.class);
	 
  @Autowired
  private PartyTypeDao itemDao;
  
  
  @Override
  //@Transactional
  public String partyTypeCreate(PartyTypeBean party) throws SpringCrunchifyException{
  
    try {    	
    	 logger.debug("Inside itemMasterCreate() method");
    	 
    	
    	return itemDao.partyTypeCreate(party);
    	
    	
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
	public List<PartyTypeBean> party_type()
			throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		return itemDao.view_party_type();
	}
  
  @Override
  //@Transactional
  public String partyTypeUpdate(PartyTypeBean party) throws SpringCrunchifyException{
  
    try {    	
    	 logger.debug("Inside partyTypeCreate() method");
    	 
    	
    	 return itemDao.partyTypeUpdate(party);
    	
    	
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
  public String associateTypeDelete(PartyTypeBean associate_typ) throws SpringCrunchifyException{
  
    try {    	
    	 logger.debug("Inside itemTypeCreate() method");
    	 
    	
    	 return itemDao.associateTypeDelete(associate_typ);
    	
    	
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

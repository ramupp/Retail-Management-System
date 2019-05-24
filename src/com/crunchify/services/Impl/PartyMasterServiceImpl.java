package com.crunchify.services.Impl;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crunchify.dao.ItemMasterDao;
import com.crunchify.dao.ItemTypeDao;
import com.crunchify.dao.PartyMasterDao;
import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.AutocompleteBean;
import com.crunchify.model.AutocompleteDesignBean;
import com.crunchify.model.ItemMasterBean;
import com.crunchify.model.ItemRateTypeBean;
import com.crunchify.model.ItemTypeBean;
import com.crunchify.model.PartyMasterBean;
import com.crunchify.model.PartyViewBean;
import com.crunchify.services.ItemMasterService;
import com.crunchify.services.ItemTypeService;
import com.crunchify.services.PartyMasterService;




@Service
@Transactional
public class PartyMasterServiceImpl implements PartyMasterService {
	
	 private static final Logger logger = Logger.getLogger(PartyMasterServiceImpl.class);
	 
  @Autowired
  private PartyMasterDao itemDao;
  
  
  @Override
  //@Transactional
  public String partyMasterCreate(PartyMasterBean party_m) throws SpringCrunchifyException{
  
    try {    	
    	 logger.debug("Inside partyMasterCreate() method");
    	 
    	
    	return itemDao.partyMasterCreate(party_m);
    	
    	
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
 	public List<PartyViewBean> party_master()
 			throws SpringCrunchifyException {
 		// TODO Auto-generated method stub
 		return itemDao.party_master();
 	}
  
  @Override
  //@Transactional
  public String party_mTypeUpdate(PartyMasterBean party_m) throws SpringCrunchifyException{
  
    try {    	
    	 logger.debug("Inside itemTypeCreate() method");
    	 
    	
    	 return itemDao.party_mTypeUpdate(party_m);
    	
    	
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
  public String partyTypDelete(PartyMasterBean party_typ) throws SpringCrunchifyException{
  
    try {    	
    	 logger.debug("Inside partyTypeCreate() method");
    	 
    	
    	 return itemDao.partyTypeDelete(party_typ);
    	
    	
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
public List<AutocompleteBean> fetchCustomerForPartyMaster(String id)
		throws SpringCrunchifyException {
	// TODO Auto-generated method stub
	return itemDao.fetchCustomerForPartyMaster(id);
	
	
	
	
}

  
}

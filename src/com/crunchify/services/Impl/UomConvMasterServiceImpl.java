package com.crunchify.services.Impl;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crunchify.dao.ItemTypeDao;
import com.crunchify.dao.UomConvMasterDao;
import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.ItemMasterBean;
import com.crunchify.model.ItemTypeBean;
import com.crunchify.model.UomConvMasterBean;
import com.crunchify.services.ItemTypeService;
import com.crunchify.services.UomConvMasterService;
import com.crunchify.services.UomMasterService;




@Service
@Transactional
public class UomConvMasterServiceImpl implements UomConvMasterService {
	
	 private static final Logger logger = Logger.getLogger(UomConvMasterServiceImpl.class);
	 
  @Autowired
  private UomConvMasterDao itemDao;
  
  
  @Override
  //@Transactional
  public String uomConvCreate(UomConvMasterBean conv) throws SpringCrunchifyException{
  
    try {    	
    	 logger.debug("Inside uomConvCreate() method");
    	 
    	
    	 itemDao.uomConvCreate(conv);
    	
    	
    } catch (Exception e) {
    	logger.error("Error in  roleCreate : " + this.getClass(), e);
    	throw new SpringCrunchifyException(e);
    }   
    finally {
        logger.debug("Dao Implemented:");
    }
    return "";
}
  @Override
 	public List<UomConvMasterBean> uom_cnv()
 			throws SpringCrunchifyException {
 		// TODO Auto-generated method stub
 		return itemDao.uom_cnv();
 	}
  
  @Override
  //@Transactional
  public String uom_convUpdate(UomConvMasterBean uom_cnv) throws SpringCrunchifyException{
  
    try {    	
    	 logger.debug("Inside itemTypeCreate() method");
    	 
    	
    	 return itemDao.uom_convUpdate(uom_cnv);
    	
    	
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
  public String uomcnvTypDelete(UomConvMasterBean ucnv_typ) throws SpringCrunchifyException{
  
    try {    	
    	 logger.debug("Inside itemTypeCreate() method");
    	 
    	
    	 return itemDao.uomcnvTypDelete(ucnv_typ);
    	
    	
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

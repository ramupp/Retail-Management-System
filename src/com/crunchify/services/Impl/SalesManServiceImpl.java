package com.crunchify.services.Impl;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crunchify.dao.ItemTypeDao;
import com.crunchify.dao.SalesManDao;
import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.ItemMasterBean;
import com.crunchify.model.ItemTypeBean;
import com.crunchify.model.SalesManBean;
import com.crunchify.services.ItemTypeService;
import com.crunchify.services.SalesManService;




@Service
@Transactional
public class SalesManServiceImpl implements SalesManService {
	
	 private static final Logger logger = Logger.getLogger(ItemTypeServiceImpl.class);
	 
  @Autowired
  private SalesManDao itemDao;
  
  
  @Override
  //@Transactional
  public String salesManCreate(SalesManBean sales_man) throws SpringCrunchifyException{
  
   // try {    	
    	 logger.debug("Inside salesManCreate() method");
    	 
    	
    	 return itemDao.salesManCreate(sales_man);
    	
    	
   // } catch (Exception e) {
    	//logger.error("Error in  roleCreate : " + this.getClass(), e);
    //	throw new SpringCrunchifyException(e);
    	//return null;
   // }   
//    finally {
//        logger.debug("Dao Implemented:");
//    }
//    //return "";
}
  @Override
	public List<SalesManBean> sales_man()
			throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		return itemDao.sales_man();
	}

  
  @Override
  //@Transactional
  public String salesManUpdate(SalesManBean sales_m) throws SpringCrunchifyException{
  
    try {    	
    	 logger.debug("Inside itemTypeCreate() method");
    	 
    	
    	 return itemDao.salesManUpdate(sales_m);
    	
    	
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
  public String sales_manTypDelete(SalesManBean s_m_typ) throws SpringCrunchifyException{
  
    try {    	
    	 logger.debug("Inside itemTypeCreate() method");
    	 
    	
    	 return itemDao.sales_manTypDelete(s_m_typ);
    	
    	
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

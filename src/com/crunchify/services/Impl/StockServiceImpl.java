package com.crunchify.services.Impl;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crunchify.dao.StockDao;
import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.StockData;
import com.crunchify.model.StockDataRm;
import com.crunchify.model.view.CashSaleViewBean;
import com.crunchify.model.view.CrSaleViewBean;
import com.crunchify.services.StockService;


@Service
@Transactional
public class StockServiceImpl implements StockService {
	
	 private static final Logger logger = Logger.getLogger(StockServiceImpl.class);
	 
  @Autowired
  StockDao stockDao;
  
  
  @Override
  @Transactional
  public String stockEntry(StockData stData) throws SpringCrunchifyException {
  
    try {    	
    	 logger.debug("Inside roleCreate() method");
    	 
    	
    	return stockDao.stockEntry(stData);
    	
    	
    } catch (Exception e) {
    	logger.error("Error in  roleCreate : " + this.getClass(), e);
    	throw new SpringCrunchifyException(e);
    	//return "error";
    }   
    finally {
        logger.debug("Dao Implemented:");
    }
    
} 
  
  
  @Override
  @Transactional
  public String stockEntryRm(StockDataRm stData) throws SpringCrunchifyException {
  
    try {    	
    	 logger.debug("Inside stockEntryRm() method");
    	 
    	
    	return stockDao.stockEntryRm(stData);
    	
    	
    } catch (Exception e) {
    	logger.error("Error in  roleCreate : " + this.getClass(), e);
    	throw new SpringCrunchifyException(e);
    	//return "error";
    }   
    finally {
        logger.debug("Dao Implemented:");
    }
    
} 
  
  @Override
	public List<StockData> stockView(StockData stData)
			throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		return stockDao.stockView(stData);
	}
  
  @Override
	public List<CrSaleViewBean> getStockTransAcknow(String co_id) throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		return stockDao.getStockTransAcknow(co_id);
	}
	
}

package com.crunchify.services.Impl;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crunchify.dao.RcvKarDao;
import com.crunchify.dao.ItemMasterDao;
import com.crunchify.dao.ItemTypeDao;
import com.crunchify.dao.RetailLoginDao;
import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.RcvRetKarHdrBean;
import com.crunchify.model.ItemMasterBean;
import com.crunchify.model.ItemTypeBean;
import com.crunchify.model.RetailDesignBean;
import com.crunchify.model.RetailRegistrationBean;


import com.crunchify.services.RcvKarService;
import com.crunchify.services.ItemTypeService;
import com.crunchify.services.RetailLoginService;




@Service
@Transactional
public class RcvKarServiceImpl implements RcvKarService {
	
	 private static final Logger logger = Logger.getLogger(RcvKarServiceImpl.class);
	 
  @Autowired
  private RcvKarDao itemDao;
  
  
  @Override
	public String issueKarUpdate(RcvRetKarHdrBean rcv_kar)
			throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		return itemDao.updateIssue(rcv_kar);
	}

  @Override
	public List<RcvRetKarHdrBean> rcv_kar()
			throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		return itemDao.rcv_kar();
	}

  @Override
  //@Transactional
  public String updateRcvKar(RcvRetKarHdrBean rcv_kar) throws SpringCrunchifyException{
  
    try {    	
    	 logger.debug("Inside rcv_kar() method");
    	 
    	
    	return itemDao.updateRcvKar(rcv_kar);
    	
    	
    } catch (Exception e) {
    	logger.error("Error in  roleCreate : " + this.getClass(), e);
    	throw new SpringCrunchifyException(e);
    }   
    finally {
        logger.debug("Dao Implemented:");
    }
   // return "";
}
  






}


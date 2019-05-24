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
import com.crunchify.dao.ReturnKarigarhDao;
import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.RcvRetKarHdrBean;
import com.crunchify.model.ItemMasterBean;
import com.crunchify.model.ItemTypeBean;
import com.crunchify.model.RetailDesignBean;
import com.crunchify.model.RetailRegistrationBean;


import com.crunchify.services.RcvKarService;
import com.crunchify.services.ItemTypeService;
import com.crunchify.services.RetailLoginService;
import com.crunchify.services.ReturnKarigarhService;




@Service
@Transactional
public class ReturnKarigarhServiceImpl implements ReturnKarigarhService {
	
	 private static final Logger logger = Logger.getLogger(RcvKarServiceImpl.class);
	 
  @Autowired
  private ReturnKarigarhDao itemDao;
  
  
  @Override
	public String returnKarigarhCreate(RcvRetKarHdrBean ret_kar)
			throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		return itemDao.returnKarigarhCreate(ret_kar);
	}


  @Override
	public List<RcvRetKarHdrBean> ret_kar()
			throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		return itemDao.ret_kar();
	}






  
}



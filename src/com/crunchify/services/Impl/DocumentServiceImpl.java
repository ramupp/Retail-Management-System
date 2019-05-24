package com.crunchify.services.Impl;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crunchify.dao.DocumentDao;
import com.crunchify.dao.ItemMasterDao;
import com.crunchify.dao.ItemTypeDao;
import com.crunchify.dao.RetailLoginDao;
import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.DocumentBean;
import com.crunchify.model.ItemMasterBean;
import com.crunchify.model.ItemTypeBean;
import com.crunchify.model.RetailRegistrationBean;
import com.crunchify.model.view.DocumentRequestBodyBean;
import com.crunchify.services.DocumentService;
import com.crunchify.services.ItemMasterService;
import com.crunchify.services.ItemTypeService;
import com.crunchify.services.RetailLoginService;




@Service
@Transactional
public class DocumentServiceImpl implements DocumentService {
	
	 private static final Logger logger = Logger.getLogger(DocumentServiceImpl.class);
	 
  @Autowired
  private DocumentDao itemDao;
  
  @Override
	public List<DocumentBean> doc()
			throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		return itemDao.doc();
	}

@Override
public String addDocument(DocumentRequestBodyBean doc)
		throws SpringCrunchifyException {
	// TODO Auto-generated method stub
	return itemDao.addDocument(doc);
}


}
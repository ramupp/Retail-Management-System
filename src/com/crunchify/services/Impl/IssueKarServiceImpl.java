package com.crunchify.services.Impl;

import java.util.List;

import javax.transaction.Transactional;

//import org.hibernate.annotations.common.util.impl.Log_.logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crunchify.dao.IssueKarDao;
import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.IssueKarHdrBean;
import com.crunchify.model.ItemMasterBean;
import com.crunchify.model.ItemTypeBean;
import com.crunchify.services.IssueKarService;

@Service
@Transactional
public class IssueKarServiceImpl implements IssueKarService {
	@Autowired
	IssueKarDao issueKarDao;

	@Override
	public String addIssueKar(IssueKarHdrBean kar)
			throws SpringCrunchifyException {
		return issueKarDao.addIssueKar(kar);
	}
	
	@Override
	public List<IssueKarHdrBean> kar()
 			throws SpringCrunchifyException {
// 		// TODO Auto-generated method stub
		return issueKarDao.kar();
 	}
  
	@Override
	  //@Transactional
	  public String updateIssueKar(IssueKarHdrBean kar) throws SpringCrunchifyException{
	  
	    try {    	
	    	 //logger.debug("Inside addIssueKar() method");
	    	 
	    	
	    	return issueKarDao.addIssueKar(kar);
	    	
	    	
	    } catch (Exception e) {
	    	//logger.error("Error in  roleCreate : " + this.getClass(), e);
	    	throw new SpringCrunchifyException(e);
	    }   
	    finally {
	        //logger.debug("Dao Implemented:");
	    }
	   // return "";
	}
}

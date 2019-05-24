package com.crunchify.services.Impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crunchify.dao.RetailOrgMasterDao;
import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.RetailOrgMasterBean;
import com.crunchify.services.RetailOrgMasterService;

@Service
@Transactional
public class RetailOrgMasterServiceImpl implements RetailOrgMasterService {

	@Autowired
	RetailOrgMasterDao r;
	
	
	@Override
	public int addOrg(RetailOrgMasterBean s) throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		return r.addOrg(s);
		
	}

}
